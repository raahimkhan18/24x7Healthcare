package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;

public class LabTestActivity extends AppCompatActivity {

    private final String[][] packages = {
            {"Package 1: Full Body Checkup", "", "", "", "999"},
            {"Package 2: Blood Glucose Fasting", "", "", "", "299"},
            {"Package 3: Brain MRI Screening", "", "", "", "3499"},
            {"Package 4: Thyroid Profile", "", "", "", "499"},
            {"Package 5: Diabetes Panel", "", "", "", "899"},
            {"Package 6: Liver Function Test", "", "", "", "649"},
            {"Package 7: Kidney Function Test", "", "", "", "599"},
            {"Package 8: Cancer Marker Test", "", "", "", "1999"},
            {"Package 9: Lipid Profile", "", "", "", "549"},
            {"Package 10: Vitamin D Test", "", "", "", "399"},
            {"Package 11: Iron Studies", "", "", "", "449"},
            {"Package 12: Dengue Antigen Test", "", "", "", "799"},
            {"Package 13: CBC + ESR", "", "", "", "499"},
            {"Package 14: Electrolyte Panel", "", "", "", "579"},
            {"Package 15: Urine Routine Examination", "", "", "", "249"},
            {"Package 16: Heart Health Checkup", "", "", "", "1099"}
    };

    private final String[] package_details = {
            "Includes: CBC, LFT, KFT, Lipid Profile, Thyroid Profile, HbA1c, Urine Test, Iron Studies, Vitamin D.",
            "Measures fasting blood glucose level to monitor diabetes risk.",
            "MRI Scan of brain for detecting structural abnormalities, tumors, clots.",
            "T3, T4, TSH levels for assessing thyroid gland function.",
            "FBS, PPBS, HbA1c, Insulin levels to monitor and manage diabetes.",
            "SGOT, SGPT, Bilirubin, Albumin, ALP — detects liver infections or damage.",
            "Urea, Creatinine, Uric Acid — evaluates kidney performance.",
            "PSA, CA-125, CEA markers for early detection of common cancers.",
            "Cholesterol, HDL, LDL, VLDL, Triglycerides for heart health risk.",
            "25-Hydroxy Vitamin D test for bone health and immunity evaluation.",
            "Iron, TIBC, Ferritin — helps detect anemia and iron deficiency.",
            "NS1, IgM, IgG — detects early dengue infection.",
            "Complete Blood Count and ESR to detect infections or inflammation.",
            "Sodium, Potassium, Chloride, Bicarbonate for fluid/electrolyte balance.",
            "Urine test for pH, sugar, proteins, ketones — detects infections/kidney issues.",
            "ECG, Lipid Profile, Troponin I, hs-CRP — evaluates heart attack risk and cholesterol."
    };

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    Button btnGoToCart, btnBack;
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lab_test);

        btnGoToCart = findViewById(R.id.buttonBMCartCheckout);
        btnBack = findViewById(R.id.buttonBMCartBack);
        listView = findViewById(R.id.listViewLT);

        btnBack.setOnClickListener(view ->
                startActivity(new Intent(LabTestActivity.this, HomeActivity.class)));

        list = new ArrayList<>();
        for (int i = 0; i < packages.length; i++) {
            item = new HashMap<>();
            item.put("line1", packages[i][0]);
            item.put("line2", packages[i][1]);
            item.put("line3", packages[i][2]);
            item.put("line4", packages[i][3]);
            item.put("line5", "Total Cost: ₹" + packages[i][4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list, R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        listView.setAdapter(sa);

        listView.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it = new Intent(LabTestActivity.this, LabTestDetailsActivity.class);
            it.putExtra("text1", packages[i][0]);
            it.putExtra("text2", package_details[i]);
            it.putExtra("text3", packages[i][4]);
            startActivity(it);
        });

        btnGoToCart.setOnClickListener(view ->
                startActivity(new Intent(LabTestActivity.this, CartLabActivity.class)));
    }
}
