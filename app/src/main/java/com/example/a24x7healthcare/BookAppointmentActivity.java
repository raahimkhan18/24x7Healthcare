package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class BookAppointmentActivity extends AppCompatActivity {

    EditText ed1, ed2, ed3, ed4;
    TextView tv;
    private DatePickerDialog datePickerDialog;
    private Button dateButton;
    private Button timeButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_appointment);

        tv = findViewById(R.id.textViewAppTitle);
        ed1 = findViewById(R.id.editTextAppFullName);
        ed2 = findViewById(R.id.editTextAppAddress);
        ed3 = findViewById(R.id.editTextAppContactNumber);
        ed4 = findViewById(R.id.editTextAppFees);
        dateButton = findViewById(R.id.buttonAppDate);
        timeButton = findViewById(R.id.buttonAppTime);
        Button btnBook = findViewById(R.id.buttonBookAppointment);
        Button btnBack = findViewById(R.id.buttonAppBack);

        ed1.setKeyListener(null);
        ed2.setKeyListener(null);
        ed3.setKeyListener(null);
        ed4.setKeyListener(null);

        Intent it = getIntent();
        String title = it.getStringExtra("text1");
        String fullName = it.getStringExtra("text2");
        String address = it.getStringExtra("text3");
        String contact = it.getStringExtra("text4");
        String fees = it.getStringExtra("text5");

        tv.setText(title);
        ed1.setText(fullName);
        ed2.setText(address);
        ed3.setText(contact);
        ed4.setText(getString(R.string.fee_text, fees)); // Use resource

        initDatePicker();
        dateButton.setOnClickListener(v -> datePickerDialog.show());

        timeButton.setOnClickListener(v -> initTimePicker().show());

        btnBack.setOnClickListener(v -> startActivity(new Intent(BookAppointmentActivity.this, FindDoctorActivity.class)));

        btnBook.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");

            String date = dateButton.getText().toString();
            String time = timeButton.getText().toString();

            if (fees == null || fees.isEmpty()) {
                Toast.makeText(this, "Fees not available", Toast.LENGTH_SHORT).show();
                return;
            }

            try (Database db = new Database(getApplicationContext(), "healthcare", null, 1)) {
                if (db.checkAppointmentExists(username, title + "=>" + fullName, address, contact, date, time) == 1) {
                    Toast.makeText(getApplicationContext(), title + " => Appointment already booked", Toast.LENGTH_LONG).show();
                } else {
                    db.addOrder(
                            username,
                            title + "=>" + fullName,
                            address,
                            contact,
                            0,
                            date,
                            time,
                            Float.parseFloat(fees),
                            "appointment"
                    );
                    Toast.makeText(getApplicationContext(), "Your appointment is done successfully", Toast.LENGTH_LONG).show();
                    startActivity(new Intent(BookAppointmentActivity.this, HomeActivity.class));
                }
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error while booking appointment", Toast.LENGTH_LONG).show();
            }
        });
    }

    private void initDatePicker() {
        DatePickerDialog.OnDateSetListener dateSetListener = (DatePicker view, int year, int month, int dayOfMonth) ->
                dateButton.setText(getString(R.string.date_format, dayOfMonth, month + 1, year));

        Calendar cal = Calendar.getInstance();
        int year = cal.get(Calendar.YEAR);
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        datePickerDialog = new DatePickerDialog(this, dateSetListener, year, month, day);
        datePickerDialog.getDatePicker().setMinDate(cal.getTimeInMillis() + 86400000);
    }

    private TimePickerDialog initTimePicker() {
        TimePickerDialog.OnTimeSetListener timeSetListener = (TimePicker view, int hourOfDay, int minute) ->
                timeButton.setText(getString(R.string.time_format, hourOfDay, minute));

        Calendar cal = Calendar.getInstance();
        int hrs = cal.get(Calendar.HOUR_OF_DAY);
        int mins = cal.get(Calendar.MINUTE);

        return new TimePickerDialog(this, timeSetListener, hrs, mins, true);
    }
}
