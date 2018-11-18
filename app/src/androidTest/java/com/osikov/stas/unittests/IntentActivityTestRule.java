package com.osikov.stas.unittests;

import android.content.Intent;
import android.support.test.rule.ActivityTestRule;

import com.osikov.stas.unittests.models.Constants;

public class IntentActivityTestRule extends ActivityTestRule {

    public IntentActivityTestRule() {
        super(SecondIntentActivity.class);
    }

    @Override
    protected Intent getActivityIntent() {
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_ID, 3);
        intent.putExtra(Constants.EXTRA_NAME, "Name 3");
        return intent;

    }

    @Override
    protected void beforeActivityLaunched() {
        super.beforeActivityLaunched();
        System.out.println("beforeActivityLaunched");
    }

    @Override
    protected void afterActivityLaunched() {
        super.afterActivityLaunched();
        System.out.println("afterActivityLaunched");
    }

    @Override
    protected void afterActivityFinished() {
        super.afterActivityFinished();
        System.out.println("afterActivityFinished");
    }
}
