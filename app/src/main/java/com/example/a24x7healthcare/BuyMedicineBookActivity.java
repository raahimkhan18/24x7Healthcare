package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class BuyMedicineBookActivity extends AppCompatActivity {
    EditText edname, edaddress, edcontact, edpincode;
    Button btnBooking;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_book);

        edname = findViewById(R.id.editTextBMBFullname);
        edaddress = findViewById(R.id.editTextBMBAddress);
        edcontact = findViewById(R.id.editTextBMBContact);
        edpincode = findViewById(R.id.editTextBMBPincode);
        btnBooking = findViewById(R.id.buttonBMBBooking);

        Intent intent = getIntent();
        String priceExtra = intent.getStringExtra("price");
        String date = intent.getStringExtra("date");

        if (priceExtra == null || date == null) {
            Toast.makeText(this, "Required data missing", Toast.LENGTH_SHORT).show();
            finish();
            return;
        }

        String[] price = priceExtra.split(java.util.regex.Pattern.quote(":"));

        btnBooking.setOnClickListener(view -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");

            try (Database db = new Database(getApplicationContext(), "healthcare", null, 1)) {
                db.addOrder(
                        username,
                        edname.getText().toString(),
                        edaddress.getText().toString(),
                        edcontact.getText().toString(),
                        Integer.parseInt(edpincode.getText().toString()),
                        date,
                        "",
                        Float.parseFloat(price[1]),
                        "medicine"
                );
                db.removeCart(username, "medicine");
            } catch (Exception e) {
                e.printStackTrace();
                Toast.makeText(getApplicationContext(), "Error during booking", Toast.LENGTH_LONG).show();
                return;
            }

            Toast.makeText(getApplicationContext(), "Your booking is done successfully", Toast.LENGTH_LONG).show();
            startActivity(new Intent(BuyMedicineBookActivity.this, HomeActivity.class));
        });
    }
}
