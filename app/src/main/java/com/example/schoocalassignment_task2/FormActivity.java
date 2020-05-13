package com.example.schoocalassignment_task2;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatSpinner;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private long selectedDob;
    private EditText firstNameTextView;
    private EditText lastNameTextView;
    private AppCompatSpinner stateSpinner;
    private RadioGroup genderRadioGroup;
    private RadioButton selectedGender;
    private EditText dobEditText;
    private EditText cityEditText;
    private Button saveButton;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        firstNameTextView = findViewById(R.id.firstName);
        lastNameTextView = findViewById(R.id.lastName);
        stateSpinner = findViewById(R.id.stateSpinner);
        genderRadioGroup = findViewById(R.id.gender_radioGroup);
        dobEditText = findViewById(R.id.dob);
        cityEditText = findViewById(R.id.cityName);
        saveButton = findViewById(R.id.save_button);


        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                getDataFromFields();
            }
        });
    }

    private void getDataFromFields() {
        String firstName = firstNameTextView.getText().toString();
        String lastName = lastNameTextView.getText().toString();
        String fullName = firstName + " " + lastName;
        selectedGender = findViewById(genderRadioGroup.getCheckedRadioButtonId());
        String gender = selectedGender.getText().toString();
        String dob = dobEditText.getText().toString();
        String selectedState = stateSpinner.getSelectedItem().toString();
        String CityName = cityEditText.getText().toString();

        openResultActivity(new FormData(fullName, gender, dob, selectedState, CityName));
    }

    private void openResultActivity(FormData formData) {
        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("details",formData);
        startActivity(intent);
        finish();
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, year);
        calendar.set(Calendar.MONTH, month);
        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        Date date = calendar.getTime();
        selectedDob = date.getTime();
        EditText dobText = findViewById(R.id.dob);
        dobText.setText(new SimpleDateFormat("dd/MM/yyyy").format(date));
    }

    public void showDatePicker(View view) {
        DatePickerFragment datePickerFragment = new DatePickerFragment();
        Bundle args = new Bundle();
        args.putLong("selected date", selectedDob);
        datePickerFragment.setArguments(args);
        datePickerFragment.show(getSupportFragmentManager(), "DATE_PICKER");
    }
}
