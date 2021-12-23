package com.example.labwork;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.text.method.ScrollingMovementMethod;

public class FileViewerActivity extends AppCompatActivity {
    private  Storage passwordStorage;
    private TextView tvSavedPasswords;
    private static String NO_SAVED_PASSWORDS = "Storage is empty";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_file_viewer);
        passwordStorage = new Storage();
        tvSavedPasswords = (TextView) findViewById(R.id.storageContent);
        getSavedPasswords();
        tvSavedPasswords.setMovementMethod(new ScrollingMovementMethod());
    }

    private void getSavedPasswords()
    {
        String passwordInfo = passwordStorage.readFromFile(this);
        if (passwordInfo.isEmpty() == true)
        {
            tvSavedPasswords.setText(NO_SAVED_PASSWORDS);
        }
        else
        {
            tvSavedPasswords.setText(passwordInfo);
        }
    }
}