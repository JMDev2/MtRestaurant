package com.moringaschool.myrestaurants.ui;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.moringaschool.myrestaurants.Constants;
import com.moringaschool.myrestaurants.R;

import butterknife.BindView;
import butterknife.ButterKnife;

//public class MainActivity extends AppCompatActivity implements View.OnClickListener {
//
////    shared preference shared member variables
////    private SharedPreferences msharedPreferences;
////    private SharedPreferences.Editor mEditor;
//
//    //FIREBASE variable reference
//    private DatabaseReference mSearchedLocationReference;
//    //removing event listener
//    private ValueEventListener mSearchedLocationReferenceListener;
//
//
//    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
//    @BindView(R.id.locationEditText) EditText mLocationEditText;
//    @BindView(R.id.appNametextView) TextView mAppNameTextView;
//    @BindView(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;
//
//    //Displaying Saved Names
//    private FirebaseAuth mAuth;
//    private FirebaseAuth.AuthStateListener mAuthListener;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//
//        mAuth = FirebaseAuth.getInstance();
//        mAuthListener = new FirebaseAuth.AuthStateListener() {
//            @Override
//            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
//                FirebaseUser user = firebaseAuth.getCurrentUser();
//                if (user != null) {
//                    getSupportActionBar().setTitle("Welcome," + user.getDisplayName() + "!");
//                } else {
//                }
//            }
//        };
//        //FIREBASE instantiating methods
//        mSearchedLocationReference = FirebaseDatabase
//                .getInstance()
//                        .getReference()
//                                .child(Constants.FIREBASE_CHILD_SEARCHED_LOCATION);
//
//        //Eventlistener
//        mSearchedLocationReferenceListener = mSearchedLocationReference.addValueEventListener(new ValueEventListener() {            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {//something changed
//                for(DataSnapshot locationSnapshot : snapshot.getChildren()){
//                    String location = locationSnapshot.getValue().toString();
//                    Log.d("Locations updated", "location: " + location); //log
//                }
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });
//
//
//
//
//
////        assigning the shared preference variables to their repective values
////        msharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
////        mEditor = msharedPreferences.edit();
//        mSavedRestaurantsButton.setOnClickListener(this);
//        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(v == mFindRestaurantsButton){
//                    String location = mLocationEditText.getText().toString();
//
//                    //FIREBASE save location
//                    saveLocationToFirebase(location);
//
//
//                    //adding our location into shared preferences
////                    if(!(location).equals("")){
////                        addToSharedPreferences(location);
////                    }
//                    Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
//                    intent.putExtra("location", location);
//                    startActivity(intent);
//
//
//                    }
//                if (v == mSavedRestaurantsButton) {
//                    Intent intent = new Intent(MainActivity.this, SavedRestaurantListActivity.class);
//                    startActivity(intent);
//                }
//
//            }
//
//        });
//
//    }
//
//    //****************MENU************************
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu){
//        MenuInflater inflate = getMenuInflater();
//        inflate.inflate(R.menu.menu_main, menu);
//        return super.onCreateOptionsMenu(menu);
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item){
//        int id = item.getItemId();
//        if(id == R.id.action_logout){
//            logout();
//            return true;
//
//        }
//        return super.onOptionsItemSelected(item);
//    }
//
//    private void logout() {
//        FirebaseAuth.getInstance().signOut();
//        Intent intent = new Intent(MainActivity.this, LoginActivity.class);
//        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        startActivity(intent);
//        finish();
//    }
////    //******************************************
//
//
//    @Override
//    public void onClick(View v) {
//
//    }
//    //FIREBASE save method
//    public void saveLocationToFirebase(String location){
//        mSearchedLocationReference.push().setValue(location);
//    }
//
//    //remove eventListener
//    @Override
//    protected void onDestroy(){
//        super.onDestroy();
//        mSearchedLocationReference.removeEventListener(mSearchedLocationReferenceListener);
//    }




//    a sharedpreference method to take user input as an arguemnet inside the onclick method

//    public void addToSharedPreferences(String location){
//        mEditor.putString(Constants.PREFERENCES_LOCATION_KEY, location).apply();
//    }
//}


public class MainActivity extends AppCompatActivity implements View.OnClickListener{
   @BindView(R.id.savedRestaurantsButton) Button mSavedRestaurantsButton;
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mFindRestaurantsButton.setOnClickListener(this);
        mSavedRestaurantsButton.setOnClickListener(this);

    }
    @Override
    public void onClick(View v){
        if (v == mFindRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, RestaurantListActivity.class);
            startActivity(intent);
        }
        if (v == mSavedRestaurantsButton) {
            Intent intent = new Intent(MainActivity.this, SavedRestaurantListActivity.class);
            startActivity(intent);
        }
    }

}
















