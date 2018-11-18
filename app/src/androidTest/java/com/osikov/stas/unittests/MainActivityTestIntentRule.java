package com.osikov.stas.unittests;

import android.app.Activity;
import android.app.Instrumentation;
import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;

import com.osikov.stas.unittests.models.Constants;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intending;
import static android.support.test.espresso.intent.matcher.BundleMatchers.hasEntry;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasExtras;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.AllOf.allOf;


public class MainActivityTestIntentRule {

    @Rule
    public IntentsTestRule<MainActivity> activityTestRule = new IntentsTestRule<>(MainActivity.class);

    @Test
    public void checkSentIntent() throws Exception {
        // first activity, button click
        onView(withId(R.id.intentButton)).perform(click());
        // check intent sent by application
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_RESULT, "Result");
        Instrumentation.ActivityResult result = new Instrumentation.ActivityResult(Activity.RESULT_OK, intent);
        // provide the stub result object in response
        intending(
                hasExtras(
                        allOf(
                                hasEntry(equalTo(Constants.EXTRA_ID), equalTo(1)),
                                hasEntry(equalTo(Constants.EXTRA_NAME), equalTo("Name 1"))
                        )
                )
        ).respondWith(result);
        // first activity, button click
        onView(withId(R.id.buttonIntentSecond)).perform(click());

        // first activity, text check
        onView(withId(R.id.intentText)).check(matches(withText("Result")));
    }
    @Test
    public void handleFailedStartActivityResult() throws Exception {
        // create stub result object
        Instrumentation.ActivityResult result =
                new Instrumentation.ActivityResult(Activity.RESULT_CANCELED, null);

        // provide the stub result object in response
        intending(
                hasExtras(
                        allOf(
                                hasEntry(equalTo(Constants.EXTRA_ID), equalTo(1)),
                                hasEntry(equalTo(Constants.EXTRA_NAME), equalTo("Name 1"))
                        )
                )
        ).respondWith(result);
        // first activity, button click
        onView(withId(R.id.intentButton)).perform(click());
        // first activity, text check
        onView(withId(R.id.intentText)).check(matches(withText("Cancel")));

    }
}