package com.example.schoocalassignment_task2;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResultActivity extends AppCompatActivity {

    private TextView name;
    private TextView gender;
    private TextView dob;
    private TextView address;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initializeViews();
        FormData formContent = (FormData) getIntent().getSerializableExtra("details");
        if (formContent != null) {
            setDataIntoViews(formContent);
        }
    }

    private void setDataIntoViews(FormData formContent) {
        name.setText(formContent.getName());
        gender.setText(formContent.getGender());
        dob.setText(formContent.getDob());
        address.setText(String.format("%s, %s", formContent.getCity(), formContent.getState()));
    }

    private void initializeViews() {
        name = findViewById(R.id.name);
        gender = findViewById(R.id.gender);
        dob = findViewById(R.id.dob);
        address = findViewById(R.id.address);
    }
}
