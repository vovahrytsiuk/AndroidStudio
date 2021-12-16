package com.example.labwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText passwordField = (EditText) findViewById(R.id.passwordField);
        TextView outputField = (TextView) findViewById(R.id.hellotext);
        Button button = (Button) findViewById(R.id.okbutton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = passwordField.getText().toString();
                if (password.isEmpty())
                {
                    Toast.makeText(MainActivity.this,
                            "Error: password empty",
                            Toast.LENGTH_SHORT)
                            .show();
                    outputField.setText("Enter password!");
                }
                else {
                    outputField.setText("Entered password: " + passwordField.getText().toString());
                }
            }
        });
        RadioGroup passwordMode = (RadioGroup) findViewById(R.id.passwordModeRadioGroup);
        passwordMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = passwordMode.getCheckedRadioButtonId();
                if (selectedId == R.id.showPasswordRadioButton)
                {
                    passwordField.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else
                {
                    passwordField.setInputType(1 | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });

    }
}