package com.osikov.stas.unittests;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.osikov.stas.unittests.models.Constants;

public class SecondIntentActivity extends AppCompatActivity {
    TextView textView;

    @SuppressLint("all")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        textView = findViewById(R.id.textIntentSecond);

        textView.setText(getIntent().getIntExtra(Constants.EXTRA_ID, 0) +
                ", " + getIntent().getStringExtra(Constants.EXTRA_NAME));

        findViewById(R.id.buttonIntentSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
            }
        });
    }

    private void buttonClick() {
        Intent intent = new Intent();
        intent.putExtra(Constants.EXTRA_RESULT, "Result");
        setResult(RESULT_OK, intent);
        finish();
    }
}
