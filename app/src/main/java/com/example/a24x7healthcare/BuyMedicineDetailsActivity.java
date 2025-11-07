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

public class BuyMedicineDetailsActivity extends AppCompatActivity {

    TextView tvPackageName, tvTotalCost;
    EditText edDetails;
    Button btnBack, btnAddToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine_details);

        tvPackageName = findViewById(R.id.textViewBMDPackageName);
        edDetails = findViewById(R.id.editTextTextBMDMultiLine);
        edDetails.setKeyListener(null);
        tvTotalCost = findViewById(R.id.textViewBMDTotalCost);
        btnBack = findViewById(R.id.buttonBMDBack);
        btnAddToCart = findViewById(R.id.buttonBMDAddToCart);

        Intent intent = getIntent();
        String packageName = intent.getStringExtra("text1");
        String details = intent.getStringExtra("text2");
        String cost = intent.getStringExtra("text3");

        tvPackageName.setText(packageName);
        edDetails.setText(details);

        if (cost != null) {
            tvTotalCost.setText(getString(R.string.total_cost_format, cost));
        }

        btnBack.setOnClickListener(v ->
                startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class))
        );

        btnAddToCart.setOnClickListener(v -> {
            SharedPreferences sharedPreferences = getSharedPreferences("shared_prefs", Context.MODE_PRIVATE);
            String username = sharedPreferences.getString("username", "");

            if (username.isEmpty() || packageName == null || cost == null) {
                Toast.makeText(getApplicationContext(), "Invalid data", Toast.LENGTH_SHORT).show();
                return;
            }

            float price = Float.parseFloat(cost);

            try (Database db = new Database(getApplicationContext(), "healthcare", null, 1)) {
                if (db.checkCart(username, packageName) == 1) {
                    Toast.makeText(getApplicationContext(), "Product Already Added", Toast.LENGTH_SHORT).show();
                } else {
                    db.addCart(username, packageName, price, "medicine");
                    Toast.makeText(getApplicationContext(), "Record Inserted to Cart", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(BuyMedicineDetailsActivity.this, BuyMedicineActivity.class));
                }
            }
        });
    }
}
