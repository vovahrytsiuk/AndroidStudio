package com.example.labwork;

import android.content.Context;
import android.widget.Toast;

import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;



public class Storage {
    private static String FILE_NAME = "passwords.txt";
    public void writeToFile(String data,Context context) {
        try {
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(context.openFileOutput(FILE_NAME, Context.MODE_APPEND));
            outputStreamWriter.write(data + "\n");
            outputStreamWriter.close();
            Toast.makeText(context,
                    context.getFilesDir().toString(),
                    Toast.LENGTH_SHORT)
                    .show();
        }
        catch (IOException e) {
            System.out.println("Exception :" + " File write failed: " + e.toString());
        }
    }
    public String readFromFile(Context context) {

        String ret = "";

        try {
            InputStream inputStream = context.openFileInput(FILE_NAME);

            if ( inputStream != null ) {
                InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                String receiveString = "";
                StringBuilder stringBuilder = new StringBuilder();

                while ( (receiveString = bufferedReader.readLine()) != null ) {
                    stringBuilder.append("\n").append(receiveString);
                }

                inputStream.close();
                ret = stringBuilder.toString();
            }
        }
        catch (FileNotFoundException e) {
            System.out.println("login activity :" + " File not found: " + e.toString());
        } catch (IOException e) {
            System.out.println("login activity :" + " Can not read file: " + e.toString());
        }

        return ret;
    }
}
