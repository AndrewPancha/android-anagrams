package com.example.anagrams;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    public static final String IGNORE = "ignore";
    public static final String TEXT = "text";
    public static final String RESULT = "result";

    private EditText userText;
    private EditText ignoreText;
    private TextView anagramTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userText = findViewById(R.id.user_text_edit_text);
        ignoreText = findViewById(R.id.ignore_edit_text);
        anagramTextView = findViewById(R.id.anagram_text_view);

        Button makeAnagramButton = findViewById(R.id.anagram_button);

        if (savedInstanceState != null) {
            userText.setText(savedInstanceState.getString(IGNORE));
            ignoreText.setText(savedInstanceState.getString(TEXT));
            anagramTextView.setText(savedInstanceState.getString(RESULT));
        }

        makeAnagramButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String toIgnore = ignoreText.getText().toString();
                String text = userText.getText().toString();
                if ("".equals(text)) {
                    Toast.makeText(MainActivity.this, R.string.toast_message, Toast.LENGTH_LONG).show();
                } else {
                    String result = ReverseUtil.reverseText(text, toIgnore);
                    anagramTextView.setText(result);
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(IGNORE, ignoreText.getText().toString());
        outState.putString(TEXT, userText.getText().toString());
        outState.putString(RESULT, anagramTextView.getText().toString());
    }


}