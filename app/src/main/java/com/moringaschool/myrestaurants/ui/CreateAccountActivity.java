package com.moringaschool.myrestaurants.ui;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.moringaschool.myrestaurants.R;

import java.util.Objects;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CreateAccountActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = CreateAccountActivity.class.getSimpleName();

    @BindView(R.id.createUserButton) Button mCreateUserButton;
    @BindView(R.id.nameEditText) EditText mNameEditText;
    @BindView(R.id.emailEditText) EditText mEmailEditText;
    @BindView(R.id.passwordEditText) EditText mPasswordEditText;
    @BindView(R.id.confirmPasswordEditText) EditText mConfirmPasswordEditText;
    @BindView(R.id.loginTextView) TextView mLoginTextView;

    private String mName; //saving users names

    //progressbar
    @BindView(R.id.firebaseProgressBar) ProgressBar mSigninProgressBar;
    @BindView(R.id.loadingTextView) TextView mLoadingSignUp;
    //***********
    private FirebaseAuth mAuth; //member var that gets the instance of Firebase Auth object to access
    // the tools provided in the firebase auth SDK

    private FirebaseAuth.AuthStateListener mAuthListener; //

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        ButterKnife.bind(this);

        mLoginTextView.setOnClickListener(this);
        mCreateUserButton.setOnClickListener(this);

        mAuth = FirebaseAuth.getInstance();
        mAuth.signOut();

        createAuthStateListener();
    }

    //progressbar
    private void showProgressBar(){
        mSigninProgressBar.setVisibility(View.VISIBLE);
            mLoadingSignUp.setVisibility(View.VISIBLE);
            mLoadingSignUp.setText("Sign Up in Progress");
    }
    private void hideProgressBar(){
        mSigninProgressBar.setVisibility(View.GONE);
        mLoadingSignUp.setVisibility(View.GONE);
    }
    //***************

    //Clickc the text to take you back to login form when yiou already have an account
    @Override
    public void onClick(View v) {
        if(v == mLoginTextView){
            Intent intent = new Intent(CreateAccountActivity.this, LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
        if (v == mCreateUserButton){
            createNewUser();
        }

    }


    //create New User Method
    private void createNewUser(){
        mName = mNameEditText.getText().toString().trim(); //getting the username to save
        final String name = mNameEditText.getText().toString().trim();
        final String email = mEmailEditText.getText().toString().trim();
        String password = mPasswordEditText.getText().toString().trim();
        String confirmPassword = mConfirmPasswordEditText.getText().toString().trim();

        //CALLING THE THE VALIDATION METHODSS
        boolean validEmail = isValidEmail(email);
        boolean validName = isValidName(name);
        boolean validPassword = isValidPassword(password, confirmPassword);
        if(!validEmail || !validName || !validPassword) return;

        showProgressBar(); //Calling the progressBar
        //********

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                            hideProgressBar();//calling the hide progressbar

                            if (task.isSuccessful()){
                                Log.d(TAG, "Authentication succesful");

                                createFirebaseUserProfile(Objects.requireNonNull(task.getResult().getUser())); // calling the dispolay user method to the create name method
                            }else {
                                Toast.makeText(CreateAccountActivity.this, "Authentication Failed.",
                                        Toast.LENGTH_SHORT).show();
                            }

                    }
                });

    }

//    Validating the users
    //*****************EMAIL******************************
    private boolean isValidEmail(String email){
        boolean isGooodEmail = (email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches());
        if (!isGooodEmail){
            mEmailEditText.setError("Please enter a valid email address");
        }
        return isGooodEmail;
    }
//    USERNAME
    private boolean isValidName(String name){
        if(name.equals("")){
            mNameEditText.setError("Please enter your name");
            return false;
        }
        return true;
    }
    //PASSWORD
    private boolean isValidPassword(String password, String confirmPassword){
        if (password.length() < 6) {
            mPasswordEditText.setText("Please create a password containing at least 6 characters");
            return false;
        }else if (!password.equals(confirmPassword)) {
            mPasswordEditText.setError("password do not match");
            return false;
        }
        return true;
    }
    //***********************************************

//    A method that will set the users name for display
    private void createFirebaseUserProfile(final FirebaseUser user){
        UserProfileChangeRequest addProfileName = new UserProfileChangeRequest.Builder()
                .setDisplayName(mName)
                .build();
        user.updateProfile(addProfileName)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()){
                            Log.d(TAG, Objects.requireNonNull(user.getDisplayName()));
                            Toast.makeText(CreateAccountActivity.this, "The display name has been set", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
//************************************************************
    //
    private void createAuthStateListener() {
        mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                final FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    Intent intent = new Intent(CreateAccountActivity.this, MainActivity.class);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                    startActivity(intent);
                    finish();
                }
            }
        };
    }

        @Override
        public void onStart(){
            super.onStart();
            mAuth.addAuthStateListener(mAuthListener);
        }
        @Override
        public void onStop(){
            super.onStop();
            mAuth.removeAuthStateListener(mAuthListener);
        }

    }


