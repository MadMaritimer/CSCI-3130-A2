package school.ben.csci_3130_a2;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest

public class EspressoTesting {
    private String textToFind;

    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule<>(
            MainActivity.class);


    @Test
    public void failLength()
    {
        //Tries to find the text on the screen
        //Return true if it matches the expected test
        onView(withId(R.id.txt_input)).perform(typeText("te$t"));
        onView(withId(R.id.txt_input)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_Validate)).perform(click());
        onView(withId(R.id.feedback)).check(matches(withText("Password Insecure")));
    }
    @Test
    public void failPassword(){
        onView(withId(R.id.txt_input)).perform(typeText("password"));
        onView(withId(R.id.txt_input)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_Validate)).perform(click());
        onView(withId(R.id.feedback)).check(matches(withText("Password Insecure")));
    }
    @Test
    public void failCommon(){
        onView(withId(R.id.txt_input)).perform(typeText("football"));
        onView(withId(R.id.txt_input)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_Validate)).perform(click());
        onView(withId(R.id.feedback)).check(matches(withText("Password Insecure")));
    }
    @Test
    public void failSpecChar(){
        onView(withId(R.id.txt_input)).perform(typeText("Activate"));
        onView(withId(R.id.txt_input)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_Validate)).perform(click());
        onView(withId(R.id.feedback)).check(matches(withText("Password Insecure")));
    }
    @Test
    public void failMixedCase(){
        onView(withId(R.id.txt_input)).perform(typeText("@ctivate"));
        onView(withId(R.id.txt_input)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_Validate)).perform(click());
        onView(withId(R.id.feedback)).check(matches(withText("Password Insecure")));
    }
    @Test
    public void passAll(){
        onView(withId(R.id.txt_input)).perform(typeText("Activ@te"));
        onView(withId(R.id.txt_input)).perform(closeSoftKeyboard());
        onView(withId(R.id.btn_Validate)).perform(click());
        onView(withId(R.id.feedback)).check(matches(withText("Password Secure")));
    }
}
