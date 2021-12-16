package com.example.labwork;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.example.labwork.SingInFragment;
import com.example.labwork.InfoFragment;

import java.nio.BufferUnderflowException;

public class MainActivity extends AppCompatActivity {
    private Button bSingInFragment;
    private Button bInfoFragment;
    private FrameLayout flFragment;
    private SingInFragment fSingInFragment;
    private InfoFragment fInfoFragment;
    private Bundle bundle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bundle = new Bundle();
        bSingInFragment = (Button) findViewById(R.id.bSignInFragment);
        bSingInFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ft.replace(R.id.flFragment, fSingInFragment);
                ft.commit();
            }
        });
        bInfoFragment = (Button) findViewById(R.id.bInfoFragment);
        bInfoFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                bundle.putString("Password", fSingInFragment.getEnteredPassword());
                fInfoFragment.setArguments(bundle);
                ft.replace(R.id.flFragment, fInfoFragment);
                ft.commit();
            }
        });
        flFragment = (FrameLayout) findViewById(R.id.flFragment);
        fSingInFragment = new SingInFragment();
        fInfoFragment = new InfoFragment();
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.flFragment, fSingInFragment);
        ft.commit();
    }
}