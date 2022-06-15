package com.moringaschool.myrestaurants;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import com.moringaschool.myrestaurants.ui.CreateAccountActivity;
import com.moringaschool.myrestaurants.ui.LoginActivity;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class CreateAccountActivityTest {

    @Rule
    public ActivityScenarioRule<CreateAccountActivity> activityRule =
            new ActivityScenarioRule<>(CreateAccountActivity.class);

    @Test
    public void validateEditText() {
        String name = "Linet";
        String email = "linet@gmail.com";
        String password = "linett";
        String cPassword = "linett";

        onView(withId(R.id.nameEditText)).perform(typeText(name))
                .check(matches(withText(name))).perform(closeSoftKeyboard());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println("Got interrupted!");
        }



        onView(withId(R.id.emailEditText)).perform(typeText(email))
                .check(matches(withText(email))).perform(closeSoftKeyboard());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println("Got interrupted!");
        }


        onView(withId(R.id.passwordEditText)).perform(typeText(password))
                .check(matches(withText(password))).perform(closeSoftKeyboard());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println("Got interrupted!");
        }


        onView(withId(R.id.confirmPasswordEditText)).perform(typeText(cPassword))
                .check(matches(withText(cPassword))).perform(closeSoftKeyboard());
        try {
            Thread.sleep(500);
        } catch (InterruptedException e){
            System.out.println("Got interrupted!");
        }


        onView(withId(R.id.createUserButton)).perform(click());

    }
}
