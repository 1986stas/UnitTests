package com.osikov.stas.unittests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.osikov.stas.unittests.presenter.Order;

import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


@SuppressWarnings("all")
@RunWith(AndroidJUnit4.class)
public class SecondActivityAdapterTest {

    @Rule
    public ActivityTestRule<SecondActivityAdapter> activityRule =
            new ActivityTestRule(SecondActivityAdapter.class);

    @BeforeClass
    public static void redirectToSecondActivity(){
        onView(withId(R.id.secondActivity)).perform(click());
    }

    @Test
    public void onCreate() {
        Order order = new Order();
    }
}