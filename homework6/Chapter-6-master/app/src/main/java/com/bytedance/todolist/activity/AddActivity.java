package com.bytedance.todolist.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.bytedance.todolist.R;

public class AddActivity extends AppCompatActivity {
    private EditText mEditText;
    private Button mButton;
    private Intent mIntent;
    private static final String TAG = "AddActivity";
    public static final String TODO = "TODO";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        setTitle("take a note");
        mIntent = getIntent();
        mEditText = findViewById(R.id.edit_text);
        mButton = findViewById(R.id.bt_confirm);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String input = mEditText.getText().toString();
                Log.d(TAG, input);
                if(input.isEmpty()) {
                    setResult(RESULT_CANCELED, mIntent);
                }
                else {
                    mIntent.putExtra(TODO, input);
                    setResult(RESULT_OK, mIntent);
                }
                finish();
            }
        });
    }
}