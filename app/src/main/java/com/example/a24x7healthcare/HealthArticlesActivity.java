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

public class HealthArticlesActivity extends AppCompatActivity {
    private String[][] health_details =
            {
                    {"Walking Daily", "", "", "Click More Details"},
                    {"Home care of COVID-19", "", "", "Click More Details"},
                    {"Stop Smoking", "", "", "Click More Details"},
                    {"Menstrual Cramps", "", "", "Click More Details"},
                    {"Healthy Gut", "", "", "Click More Details"},
                    {"Managing Stress", "", "", "Click More Details"},
                    {"Balanced Diet", "", "", "Click More Details"},
                    {"Exercise for Heart Health", "", "", "Click More Details"},
                    {"Mental Health Awareness", "", "", "Click More Details"},
                    {"Diabetes Management", "", "", "Click More Details"},
                    {"Hypertension Prevention", "", "", "Click More Details"},
                    {"Importance of Sleep", "", "", "Click More Details"},
                    {"Preventing Obesity", "", "", "Click More Details"},
                    {"Breast Cancer Awareness", "", "", "Click More Details"},
                    {"Healthy Skin Tips", "", "", "Click More Details"},
                    {"Flu Vaccination", "", "", "Click More Details"},
                    {"Managing Anxiety", "", "", "Click More Details"},
                    {"Healthy Aging", "", "", "Click More Details"},
                    {"Cholesterol Management", "", "", "Click More Details"},
            };

    private int[] images = {
            R.drawable.health1,
            R.drawable.health2,
            R.drawable.health3,
            R.drawable.health4,
            R.drawable.health5,
            R.drawable.health6, // New image added for new articles
            R.drawable.health7,
            R.drawable.health8,
            R.drawable.health9,
            R.drawable.health10,
            R.drawable.health11,
            R.drawable.health12,
            R.drawable.health13,
            R.drawable.health14,
            R.drawable.health15,
            R.drawable.health16,
            R.drawable.health17,
            R.drawable.health18,
            R.drawable.health19,
    };

    HashMap<String, String> item;
    ArrayList<HashMap<String, String>> list;
    SimpleAdapter sa;

    Button btnBack;
    ListView lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_articles);

        lst = findViewById(R.id.listViewHA);
        btnBack = findViewById(R.id.buttonBackHA);

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(HealthArticlesActivity.this, HomeActivity.class));
            }
        });
        list = new ArrayList<>();
        for (int i = 0; i < health_details.length; i++) {
            item = new HashMap<String, String>();
            item.put("Line1", health_details[i][0]);
            item.put("Line2", health_details[i][1]);
            item.put("Line3", health_details[i][2]);
            item.put("Line4", health_details[i][3]);
            item.put("Line5", "");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"Line1", "Line2", "Line3", "Line4", "Line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e});

        lst.setAdapter(sa);

        lst.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent it = new Intent(HealthArticlesActivity.this, HealthArticlesDetailsActivity.class);
                it.putExtra("text1", health_details[i][0]);
                it.putExtra("text2", images[i]);
                startActivity(it);
            }
        });
    }
}
