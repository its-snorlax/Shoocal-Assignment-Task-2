package com.example.schoocalassignment_task2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class FormActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {
    private long selectedDob;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
