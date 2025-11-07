package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    EditText edUsername, edEmail, edPassword, edConfirm;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        edUsername = findViewById(R.id.editTextAppFullName);
        edEmail = findViewById(R.id.editTextAppAddress);
        edPassword = findViewById(R.id.editTextAppContactNumber);
        edConfirm = findViewById(R.id.editTextAppFees);
        btn = findViewById(R.id.buttonBookAppointment);
        tv = findViewById(R.id.textViewExistingUser);

        // Open LoginActivity on TextView click
        tv.setOnClickListener(view ->
                startActivity(new Intent(RegisterActivity.this, LoginActivity.class))
        );

        // Handle registration logic on button click
        btn.setOnClickListener(view -> {
            String username = edUsername.getText().toString();
            String email = edEmail.getText().toString();
            String password = edPassword.getText().toString();
            String confirm = edConfirm.getText().toString();
            Database db = new Database(getApplicationContext(),"healthcare",null,1);


            if (username.isEmpty() || email.isEmpty() || password.isEmpty() || confirm.isEmpty()) {
                Toast.makeText(getApplicationContext(), "Please fill ALL details", Toast.LENGTH_SHORT).show();
            } else {
                if (password.compareTo(confirm) == 0) {
                    if (isValid(password)) {
                        db.register(username,email,password);
                        Toast.makeText(getApplicationContext(), "Record Inserted", Toast.LENGTH_SHORT).show();
                        startActivity(new Intent(RegisterActivity.this, LoginActivity.class));
                    } else {
                        Toast.makeText(getApplicationContext(), "Password must contain at least 8 characters with letters, digits, and special symbols", Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Password and Confirm password didn't match", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public static boolean isValid(String passwordhere) {
        int f1 = 0, f2 = 0, f3 = 0;

        // Length check
        if (passwordhere.length() < 8) {
            return false;
        } else {
            // Check for at least one letter
            for (int p = 0; p < passwordhere.length(); p++) {
                if (Character.isLetter(passwordhere.charAt(p))) {
                    f1 = 1;
                    break;
                }
            }

            // Check for at least one digit
            for (int c = 0; c < passwordhere.length(); c++) {
                if (Character.isDigit(passwordhere.charAt(c))) {
                    f2 = 1;
                    break;
                }
            }

            // Check for at least one special character
            for (int s = 0; s < passwordhere.length(); s++) {
                char ch = passwordhere.charAt(s);
                if ((ch >= 33 && ch <= 46) || ch == 64) {
                    f3 = 1;
                    break;
                }
            }

            // All conditions met
            return f1 == 1 && f2 == 1 && f3 == 1;
        }
    }
}
