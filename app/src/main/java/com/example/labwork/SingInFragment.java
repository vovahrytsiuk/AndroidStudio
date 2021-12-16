package com.example.labwork;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.InputType;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SingInFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SingInFragment extends Fragment {

    private RadioGroup rgPasswordMode;
    private EditText etPasswordField;
    private Button bVerify;

    public SingInFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SingInFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SingInFragment newInstance(String param1, String param2) {
        SingInFragment fragment = new SingInFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    public String getEnteredPassword()
    {
        return etPasswordField.getText().toString();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        etPasswordField = (EditText) getActivity().findViewById(R.id.passwordField);
        rgPasswordMode = (RadioGroup) getActivity().findViewById(R.id.passwordModeRadioGroup);
        rgPasswordMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                int selectedId = rgPasswordMode.getCheckedRadioButtonId();
                if (selectedId == R.id.showPasswordRadioButton)
                {
                    etPasswordField.setInputType(InputType.TYPE_CLASS_TEXT);
                }
                else
                {
                    etPasswordField.setInputType(1 | InputType.TYPE_TEXT_VARIATION_PASSWORD);
                }
            }
        });
        bVerify = (Button) getActivity().findViewById(R.id.okbutton);
        bVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String password = etPasswordField.getText().toString();
                if (password.isEmpty())
                {
                    Toast.makeText(getActivity(),
                            "Error: password empty",
                            Toast.LENGTH_SHORT)
                            .show();
                }
                else {
                    Toast.makeText(getActivity(),
                            "Password successfully entered",
                            Toast.LENGTH_SHORT)
                            .show();
                }
            }
        });
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_sing_in, container, false);
    }
}