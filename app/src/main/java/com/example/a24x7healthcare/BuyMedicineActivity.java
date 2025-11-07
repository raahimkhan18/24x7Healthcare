package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import java.util.ArrayList;
import java.util.HashMap;

public class BuyMedicineActivity extends AppCompatActivity {

    private final String[][] packages = {
            {"Uprise-D3 1000IU Capsule", "", "", "", "50"},
            {"HealthVit Chromium Picolinate 200mcg Capsule", "", "", "", "305"},
            {"Vitamin B Complex Capsules", "", "", "", "448"},
            {"INLIFE Vitamin E Wheat Germ Oil Capsule", "", "", "", "539"},
            {"Dolo 650 Tablet", "", "", "", "30"},
            {"Crocin 650 Advance Tablet", "", "", "", "50"},
            {"Strepsils Medicated Lozenges for Sore Throat", "", "", "", "40"},
            {"Tata 1mg Calcium + Vitamin D3", "", "", "", "30"},
            {"Feronia -XT Tablet", "", "", "", "130"},
            {"Limcee Vitamin C Chewable Tablet", "", "", "", "40"},
            {"Becosules capsule", "", "", "", "45"},
            {"Alex Cough Formula Sugar Free Syrup 100ml", "", "", "", "154"},
            {"Paracetamol 500mg Tablet", "", "", "", "55"},
            {"Azithromycin 250mg Tablet", "", "", "", "364"},
            {"Ibuprofen 400mg Tablet", "", "", "", "478"},
            {"Amoxicillin 500mg Capsule", "", "", "", "529"},
            {"Cetrizine 10mg Tablet", "", "", "", "170"},
            {"Pantoprazole 40mg Tablet", "", "", "", "496"},
            {"Ranitidine 150mg Tablet", "", "", "", "216"},
            {"Aspirin 75mg Tablet", "", "", "", "263"},
            {"Metformin 500mg Tablet", "", "", "", "574"},
            {"Losartan 50mg Tablet", "", "", "", "256"},
            {"Amlodipine 5mg Tablet", "", "", "", "297"},
            {"Atorvastatin 10mg Tablet", "", "", "", "145"},
            {"Montelukast 10mg Tablet", "", "", "", "570"},
            {"Levocetirizine 5mg Tablet", "", "", "", "101"},
            {"Omeprazole 20mg Capsule", "", "", "", "275"},
            {"Dicyclomine 10mg Tablet", "", "", "", "321"},
            {"Domperidone 10mg Tablet", "", "", "", "235"},
            {"Iron Folic Acid Tablet", "", "", "", "258"},
            {"Vitamin B12 Supplement", "", "", "", "597"},
            {"Vitamin C 500mg Chewable Tablet", "", "", "", "224"},
            {"Multivitamin Syrup", "", "", "", "36"},
            {"Cough Syrup Herbal 100ml", "", "", "", "531"},
            {"ORS Powder Sachet", "", "", "", "383"},
            {"Loperamide 2mg Tablet", "", "", "", "161"},
            {"Diclofenac Gel 30g", "", "", "", "475"},
            {"Antifungal Cream 20g", "", "", "", "29"},
            {"Clotrimazole 1% Dusting Powder", "", "", "", "353"},
            {"Hydrocortisone Cream 1%", "", "", "", "532"},
            {"Saline Nasal Spray", "", "", "", "462"},
            {"Steam Inhaler", "", "", "", "353"},
            {"Glucometer Test Strips (50)", "", "", "", "223"},
            {"Digital Thermometer", "", "", "", "427"},
            {"Pulse Oximeter", "", "", "", "269"},
            {"Pregnancy Test Kit", "", "", "", "390"},
            {"Hand Sanitizer 100ml", "", "", "", "205"},
            {"Face Mask (Pack of 5)", "", "", "", "143"},
            {"Hot Water Bag", "", "", "", "79"},
            {"Cold Pack Gel", "", "", "", "542"}
    };

    private final String[] package_details = {
            "Building and keeping the bones & teeth strong...",
            "Chromium is an essential trace mineral...",
            "Provides relief from vitamin B deficiencies...",
            "Promotes health as well as skin benefit...",
            "Helps relieve pain and fever...",
            "Relieves symptoms of throat infection...",
            "Reduces the risk of calcium deficiency...",
            "Helps reduce iron deficiency...",
            "Treats iron deficiency anemia...",
            "Boosts immunity and protects against colds...",
            "Promotes overall health and metabolism...",
            "Quick relief from cough and cold symptoms...",
            "Used for fever and pain relief...",
            "Treats various bacterial infections...",
            "Relieves pain and inflammation...",
            "Treats bacterial infections...",
            "Relieves allergy symptoms...",
            "Reduces stomach acid...",
            "Used for ulcers...",
            "Reduces pain, fever, and inflammation...",
            "Manages type 2 diabetes...",
            "Treats high blood pressure...",
            "Lowers blood pressure and stroke risk...",
            "Reduces cholesterol levels...",
            "Used for asthma and allergies...",
            "Treats hay fever symptoms...",
            "Treats acid reflux and ulcers...",
            "Relieves stomach spasms...",
            "Treats vomiting and nausea...",
            "Prevents iron deficiency anemia...",
            "Supports nerve health...",
            "Acts as an antioxidant...",
            "Tonic for general health...",
            "Relieves cough naturally...",
            "Hydrates body during illness...",
            "Treats diarrhea...",
            "Relieves joint/muscle pain...",
            "Treats fungal skin infections...",
            "Treats skin folds infections...",
            "Reduces eczema inflammation...",
            "Clears nasal blockage...",
            "Used for cold relief steam...",
            "Measures blood sugar...",
            "Measures body temperature...",
            "Measures oxygen in blood...",
            "Detects pregnancy...",
            "Ensures hand hygiene...",
            "Protects from pollution...",
            "Relieves muscle pain...",
            "Relieves swelling..."
    };

    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;
    ListView lst;
    Button btnBack, btnGoToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy_medicine);

        lst = findViewById(R.id.listViewBM);
        btnBack = findViewById(R.id.buttonBMBack);
        btnGoToCart = findViewById(R.id.buttonBMGoToCart);

        btnBack.setOnClickListener(view ->
                startActivity(new Intent(BuyMedicineActivity.this, HomeActivity.class)));

        btnGoToCart.setOnClickListener(view ->
                startActivity(new Intent(BuyMedicineActivity.this, CartBuyMedicineActivity.class)));

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            HashMap<String, String> item = new HashMap<>();
            item.put("Line1", packages[i][0]);
            item.put("Line2", packages[i][1]);
            item.put("Line3", packages[i][2]);
            item.put("Line4", packages[i][3]);
            item.put("Line5", "Total Cost: ₹" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it = new Intent(BuyMedicineActivity.this, BuyMedicineDetailsActivity.class);
            it.putExtra("text1", packages[i][0]);
            it.putExtra("text2", package_details[i]);
            it.putExtra("text3", packages[i][4]);
            startActivity(it);
        });
    }
}
