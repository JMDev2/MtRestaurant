package com.moringaschool.myrestaurants;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import android.widget.EditText;
import android.widget.TextView;

import com.moringaschool.myrestaurants.ui.LoginActivity;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;

@RunWith(RobolectricTestRunner.class)
public class LoginActivityTest {
    private LoginActivity loginActivity;

    @Before
    public void setUp() throws Exception {
        loginActivity = Robolectric.buildActivity(LoginActivity.class)
                .create()
                .resume()
                .get();
    }

    @Test
    public void validateEmailTextViewContent() {

        EditText emailTextView = loginActivity.findViewById(R.id.emailEditText);
        assertEquals("Email", emailTextView.getHint());


        EditText nameTextView = loginActivity.findViewById(R.id.nameEditText);
        assertEquals("Name", emailTextView.getHint());
    }

    @Test
    public void validateEmailTextViewCuontent() {
        EditText nameTextView = loginActivity.findViewById(R.id.passwordEditText);
        assertEquals("Password", nameTextView.getHint());

    }
}
