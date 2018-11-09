package com.osikov.stas.unittests;


import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.osikov.stas.unittests.presenter.Order;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;

@SuppressWarnings("all")
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule(MainActivity.class);

    @Test
    public void changeTextCorrect() throws Exception {
        String typingText = "Android is a cool stuff";
        onView(withId(R.id.editText)).perform(typeText(typingText));

        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.view)).check(matches(withText(typingText)));
    }

    @Test
    public void changeTextEmpty() throws Exception {
        onView(withId(R.id.button)).perform(click());
        onView(withId(R.id.view)).check(matches(withText(R.string.empty_text)));
    }

    @Test
    public void redirectToSecondActivity(){
        onView(withId(R.id.secondActivity)).perform(click());
        Order order = new Order();
        order.setDescription("Order description 21");
        onData(equalTo(order)).perform(click());

        onView(withId(R.id.textview)).check(matches(withText("Order name 21Order description 21")));
    }

}