package com.osikov.stas.unittests;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.osikov.stas.unittests.models.Constants;


public class MainActivity extends AppCompatActivity {


    private TextView textView;
    private EditText editText;
    private Button startActivity;
    private Button thirdActivity;
    private TextView intentTextView;

    public static final int REQUEST_CODE = 1;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        startActivity = findViewById(R.id.secondActivity);
        thirdActivity = findViewById(R.id.thirdActivity);
        textView = findViewById(R.id.view);
        Button button = findViewById(R.id.button);
        editText = findViewById(R.id.editText);

        intentTextView = findViewById(R.id.intentText);
        Button intentButton = findViewById(R.id.intentButton);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text = editText.getText().toString();
                if (TextUtils.isEmpty(text)) {
                    text = getString(R.string.empty_text);
                }
                textView.setText(text);
            }
        });
        onClickListViewActivity();
        onClickRecyclerViewActivity();

        intentButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                buttonClick();
            }
        });
    }

    private void onClickListViewActivity(){
        final Intent intent = new Intent(this, SecondActivityAdapter.class);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void onClickRecyclerViewActivity(){
        final Intent intent = new Intent(this, ActivityRecyclerView.class);
        thirdActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(intent);
            }
        });
    }

    private void buttonClick() {
        Intent intent = new Intent(this, SecondIntentActivity.class);
        intent.putExtra(Constants.EXTRA_ID, 1);
        intent.putExtra(Constants.EXTRA_NAME, "Name 1");
        startActivityForResult(intent, REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                intentTextView.setText(data.getStringExtra(Constants.EXTRA_RESULT));
            } else {
                intentTextView.setText("Cancel");
            }
        }
    }

}
