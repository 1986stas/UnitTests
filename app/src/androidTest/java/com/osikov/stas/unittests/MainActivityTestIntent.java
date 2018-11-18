package com.osikov.stas.unittests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


@RunWith(AndroidJUnit4.class)
public class MainActivityTestIntent {

    @Rule
    public ActivityTestRule<MainActivity> activityTestRule = new ActivityTestRule<>(MainActivity.class);


    @Test
    public void onActivityResult() {
        onView(withId(R.id.intentButton)).perform(click());
        onView(withId(R.id.textIntentSecond)).check(matches(withText("1, Name 1")));
        onView(withId(R.id.buttonIntentSecond)).perform(click());
        onView(withId(R.id.intentText)).check(matches(withText("Result")));
    }

    @Test
    public void startSecondActivityAndReturnResultCancel(){
        onView(withId(R.id.intentButton)).perform(click());
        onView(withId(R.id.textIntentSecond)).check(matches(withText("1, Name 1")));
        pressBack();
        onView(withId(R.id.intentText)).check(matches(withText("Cancel")));
    }
}