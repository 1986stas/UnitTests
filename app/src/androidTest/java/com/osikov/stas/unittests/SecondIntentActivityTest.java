package com.osikov.stas.unittests;

import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
public class SecondIntentActivityTest {

//    @Rule
//    public ActivityTestRule<SecondIntentActivity> activityTestRule = new ActivityTestRule<>(SecondIntentActivity.class, false, false);
//
//    @Test
//    public void showDataFromIntent() throws Exception {
//        Intent intent = new Intent();
//        intent.putExtra(Constants.EXTRA_ID, 2);
//        intent.putExtra(Constants.EXTRA_NAME, "Name 2");
//        activityTestRule.launchActivity(intent);
//        onView(withId(R.id.textIntentSecond)).check(matches(withText("2, Name 2")));
//    }

    @Rule
    public IntentActivityTestRule activityTestRule = new IntentActivityTestRule();

    @Before
    public void setUp() throws Exception {
        System.out.println("setUp");
    }

    @Test
    public void showDataFromIntentTestRule() throws Exception {
        System.out.println("test start");
        onView(withId(R.id.textIntentSecond)).check(matches(withText("3, Name 3")));
        System.out.println("test end");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("tearDown");
    }
}