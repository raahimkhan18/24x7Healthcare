package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edUsername, edPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edUsername = findViewById(R.id.editTextLoginUsername);
        edPassword = findViewById(R.id.editTextLoginPassword);
        Button btn = findViewById(R.id.buttonBookAppointment);
        TextView tv = findViewById(R.id.textViewNewUser);

        btn.setOnClickListener(view -> {
            String username = edUsername.getText().toString().trim();
            String password = edPassword.getText().toString().trim();
            Database db = new Database(getApplicationContext(), "healthcare", null, 1);

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(getApplicationContext(), getString(R.string.fill_all_details), Toast.LENGTH_SHORT).show();
            } else {
                if (db.login(username, password) == 1) {
                    Toast.makeText(getApplicationContext(), getString(R.string.login_success), Toast.LENGTH_SHORT).show();
                    SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
                    sharedPreferences.edit().putString("username", username).apply();
                    startActivity(new Intent(LoginActivity.this, HomeActivity.class));
                } else {
                    Toast.makeText(getApplicationContext(), getString(R.string.invalid_credentials), Toast.LENGTH_SHORT).show();
                }
            }
        });

        tv.setOnClickListener(view ->
                startActivity(new Intent(LoginActivity.this, RegisterActivity.class))
        );
    }
}
