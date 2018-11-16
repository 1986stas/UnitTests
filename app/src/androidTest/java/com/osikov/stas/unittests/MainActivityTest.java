package com.osikov.stas.unittests;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.osikov.stas.unittests.presenter.Order;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItem;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.hasDescendant;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.containsString;


@SuppressWarnings("all")
@RunWith(AndroidJUnit4.class)
public class MainActivityTest {

    @Rule
    public ActivityTestRule<MainActivity> activityRule = new ActivityTestRule(MainActivity.class);

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
        order.setName("Order name 21");
        order.setDescription("Order description 21");
//        onData(equalTo(order)).perform(click());

        onView(withId(R.id.textview)).check(matches(isDisplayed()));
    }

    @Test
    public void recyclerViewTest(){
        onView(withId(R.id.thirdActivity)).perform(click());
        onView(withId(R.id.rvContacts))
                .perform(actionOnItemAtPosition(49, click()));
    }

    @Test
    public void listItemClick(){
        onView(withId(R.id.thirdActivity)).perform(click());
        onView(withId(R.id.rvContacts)).
                perform(actionOnItem(hasDescendant(withText("Person 50")), click()));
    }

    @Test
    public void listItemClickIfContainsText(){
        onView(withId(R.id.thirdActivity)).perform(click());
        onView(withId(R.id.rvContacts)).
                perform(actionOnItem(hasDescendant(withText(containsString("Person 4"))), click())
                .atPosition(4));
    }


}