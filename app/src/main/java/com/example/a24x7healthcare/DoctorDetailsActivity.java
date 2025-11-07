package com.example.a24x7healthcare;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class DoctorDetailsActivity extends AppCompatActivity {

    // Updated doctor details with Delhi-based doctors integrated into existing lists

    // Doctor Details 1 (Including Delhi doctors)
    private final String[][] doctorDetails1 = {
            {"Doctor Name : Ajit Saste", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name : Prasad Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name : Swapnil Kale", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name : Deepak Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898888888", "500"},
            {"Doctor Name : Fasih Naqvi", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name : Rajesh Sharma", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9123456789", "700"},
            {"Doctor Name : Bushra Khan", "Hospital Address : Delhi", "Exp : 12yrs", "Mobile No:9134567890", "800"},
            {"Doctor Name : Arsalan Abdul Wafi", "Hospital Address : Noida", "Exp : 6yrs", "Mobile No:9145678901", "600"},
            {"Doctor Name : Seema Verma", "Hospital Address : Delhi", "Exp : 9yrs", "Mobile No:9156789012", "750"},
            {"Doctor Name : Vikram Singh", "Hospital Address : Delhi", "Exp : 15yrs", "Mobile No:9167890123", "1000"},
            {"Doctor Name : Priya Agarwal", "Hospital Address : Delhi", "Exp : 7yrs", "Mobile No:9178901234", "650"},
            {"Doctor Name : Harish Kumar", "Hospital Address : Delhi", "Exp : 5yrs", "Mobile No:9189012345", "550"},
            {"Doctor Name : Meenal Sharma", "Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9190123456", "700"},
            {"Doctor Name : Ravi Gupta", "Hospital Address : Delhi", "Exp : 14yrs", "Mobile No:9201234567", "850"},
            {"Doctor Name : Nisha Rani", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9212345678", "750"}
    };

    // Doctor Details 2 (Including Delhi doctors)
    private final String[][] doctorDetails2 = {
            {"Doctor Name : Neelam Patil", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name : Kaif Siddiqui", "Hospital Address : Lucknow", "Exp : 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name : Manisha Kate", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name : Mayuri Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name : Minakshi Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "800"},
            {"Doctor Name : Pankaj Soni", "Hospital Address : Delhi", "Exp : 12yrs", "Mobile No:9223456789", "900"},
            {"Doctor Name : Priya Malik", "Hospital Address : Delhi", "Exp : 11yrs", "Mobile No:9234567890", "800"},
            {"Doctor Name : Manoj Bhatia", "Hospital Address : Delhi", "Exp : 13yrs", "Mobile No:9245678901", "950"},
            {"Doctor Name : Alok Tiwari", "Hospital Address : Delhi", "Exp : 7yrs", "Mobile No:9256789012", "650"},
            {"Doctor Name : Rupal Joshi", "Hospital Address : Delhi", "Exp : 9yrs", "Mobile No:9267890123", "700"},
            {"Doctor Name : Shubham Sharma", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9278901234", "750"},
            {"Doctor Name : Rajeev Kumar", "Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9289012345", "650"},
            {"Doctor Name : Varsha Verma", "Hospital Address : Delhi", "Exp : 6yrs", "Mobile No:9290123456", "600"},
            {"Doctor Name : Amit Bansal", "Hospital Address : Delhi", "Exp : 12yrs", "Mobile No:9301234567", "850"},
            {"Doctor Name : Kiran Yadav", "Hospital Address : Delhi", "Exp : 14yrs", "Mobile No:9312345678", "900"}
    };

    // Doctor Details 3 (Including Delhi doctors)
    private final String[][] doctorDetails3 = {
            {"Doctor Name : Seema Patil", "Hospital Address : Pimpri", "Exp : 4yrs", "Mobile No:9898989898", "200"},
            {"Doctor Name : Pankaj Parab", "Hospital Address : Nigdi", "Exp : 5yrs", "Mobile No:7898989898", "300"},
            {"Doctor Name : Manish Jain", "Hospital Address : Pune", "Exp : 7yrs", "Mobile No:6898989898", "300"},
            {"Doctor Name : Vishal Deshmukh", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name : Shrikant Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "600"},
            {"Doctor Name : Seema Rani", "Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9323456789", "650"},
            {"Doctor Name : Rahul Yadav", "Hospital Address : Delhi", "Exp : 5yrs", "Mobile No:9334567890", "550"},
            {"Doctor Name : Sarfaraz Ali", "Hospital Address : Gujarat", "Exp : 10yrs", "Mobile No:9345678901", "750"},
            {"Doctor Name : Ramesh Kumar", "Hospital Address : Delhi", "Exp : 9yrs", "Mobile No:9356789012", "700"},
            {"Doctor Name : Gaurav Soni", "Hospital Address : Delhi", "Exp : 12yrs", "Mobile No:9367890123", "850"},
            {"Doctor Name : Tanya Sharma", "Hospital Address : Delhi", "Exp : 6yrs", "Mobile No:9378901234", "600"},
            {"Doctor Name : Rajesh Joshi", "Hospital Address : Delhi", "Exp : 7yrs", "Mobile No:9389012345", "700"},
            {"Doctor Name : Pradeep Bansal", "Hospital Address : Delhi", "Exp : 5yrs", "Mobile No:9390123456", "650"},
            {"Doctor Name : Shilpa Gupta", "Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9401234567", "750"},
            {"Doctor Name : Mohit Chauhan", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9412345678", "800"}
    };

    // Doctor Details 4 (Including Delhi doctors)
    private final String[][] doctorDetails4 = {
            {"Doctor Name : Atul Gawade", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "600"},
            {"Doctor Name : Moti Lal", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "900"},
            {"Doctor Name : Naseem Akhtar", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "300"},
            {"Doctor Name : Deepak Kumar", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "500"},
            {"Doctor Name : Ankul Panda", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "600"},
            {"Doctor Name : Harvinder Singh", "Hospital Address : Delhi", "Exp : 12yrs", "Mobile No:9423456789", "900"},
            {"Doctor Name : Sunita Arora", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9434567890", "850"},
            {"Doctor Name : Ahad Abbasi", "Hospital Address : Delhi", "Exp : 6yrs", "Mobile No:9445678901", "700"},
            {"Doctor Name : Shubhi Rani", "Hospital Address : Delhi", "Exp : 9yrs", "Mobile No:9456789012", "750"},
            {"Doctor Name : Vikrant Gupta", "Hospital Address : Delhi", "Exp : 5yrs", "Mobile No:9467890123", "600"},
            {"Doctor Name : Neha Joshi", "Hospital Address : Delhi", "Exp : 7yrs", "Mobile No:9478901234", "700"},
            {"Doctor Name : Laxmi Kumari", "Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9489012345", "650"},
            {"Doctor Name : Sadiq Khan", "Hospital Address : Delhi", "Exp : 14yrs", "Mobile No:9490123456", "950"},
            {"Doctor Name : Meena Sharma", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9501234567", "800"},
            {"Doctor Name : Boria Majumdar", "Hospital Address : Kolkata", "Exp : 11yrs", "Mobile No:9512345678", "850"}
    };

    // Doctor Details 5 (Including Delhi doctors)
    private final String[][] doctorDetails5 = {
            {"Doctor Name : Nilesh Borate", "Hospital Address : Pimpri", "Exp : 5yrs", "Mobile No:9898989898", "1600"},
            {"Doctor Name : Pankaj Pawar", "Hospital Address : Nigdi", "Exp : 15yrs", "Mobile No:7898989898", "1900"},
            {"Doctor Name : Rahul Rawat", "Hospital Address : Pune", "Exp : 8yrs", "Mobile No:8898989898", "1300"},
            {"Doctor Name : Deepak Kumar", "Hospital Address : Chinchwad", "Exp : 6yrs", "Mobile No:9898000000", "1500"},
            {"Doctor Name : Manoj Dimri", "Hospital Address : Katraj", "Exp : 7yrs", "Mobile No:7798989898", "1800"},
            {"Doctor Name : Rajesh Sharma", "Hospital Address : Delhi", "Exp : 13yrs", "Mobile No:9523456789", "900"},
            {"Doctor Name : Maria Jameel", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9534567890", "850"},
            {"Doctor Name : Reena Gupta", "Hospital Address : Delhi", "Exp : 6yrs", "Mobile No:9545678901", "700"},
            {"Doctor Name : Rahul Chauhan", "Hospital Address : Delhi", "Exp : 5yrs", "Mobile No:9556789012", "650"},
            {"Doctor Name : Nisha Yadav", "Hospital Address : Delhi", "Exp : 8yrs", "Mobile No:9567890123", "750"},
            {"Doctor Name : Lajwanti Bansal", "Hospital Address : Delhi", "Exp : 7yrs", "Mobile No:9578901234", "800"},
            {"Doctor Name : Ramesh Gupta", "Hospital Address : Delhi", "Exp : 9yrs", "Mobile No:9589012345", "850"},
            {"Doctor Name : Gagan Mehra", "Hospital Address : Delhi", "Exp : 10yrs", "Mobile No:9590123456", "900"},
            {"Doctor Name : Asha Yadav", "Hospital Address : Delhi", "Exp : 11yrs", "Mobile No:9601234567", "950"},
            {"Doctor Name : Renu Sharma", "Hospital Address : Delhi", "Exp : 12yrs", "Mobile No:9612345678", "1000"}
    };

    TextView tv;
    Button btn;
    String[][] doctor_details = {};
    ArrayList<HashMap<String, String>> list;
    HashMap<String, String> item;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doctor_details);

        tv = findViewById(R.id.textViewDDTitle);
        btn = findViewById(R.id.buttonLtGoToCart);

        Intent it = getIntent();
        String title = it.getStringExtra("name");
        tv.setText(title);

        // Load doctor details based on the title
        if ("Family Physicians".equals(title))
            doctor_details = doctorDetails1;
        else if ("Dietician".equals(title))
            doctor_details = doctorDetails2;
        else if ("Dentist".equals(title))
            doctor_details = doctorDetails3;
        else if ("Surgeon".equals(title))
            doctor_details = doctorDetails4;
        else
            doctor_details = doctorDetails5;

        btn.setOnClickListener(v ->
                startActivity(new Intent(DoctorDetailsActivity.this, FindDoctorActivity.class)));

        list = new ArrayList<>();
        for (String[] doctorDetail : doctor_details) {
            item = new HashMap<>();
            item.put("line1", doctorDetail[0]);
            item.put("line2", doctorDetail[1]);
            item.put("line3", doctorDetail[2]);
            item.put("line4", doctorDetail[3]);
            item.put("line5", "Cons Fees " + doctorDetail[4] + "/-");
            list.add(item);
        }

        sa = new SimpleAdapter(this, list,
                R.layout.multi_lines,
                new String[]{"line1", "line2", "line3", "line4", "line5"},
                new int[]{R.id.line_a, R.id.line_b, R.id.line_c, R.id.line_d, R.id.line_e}
        );

        ListView lst = findViewById(R.id.listViewDD);
        lst.setAdapter(sa);

        lst.setOnItemClickListener((adapterView, view, i, l) -> {
            Intent it1 = new Intent(DoctorDetailsActivity.this, BookAppointmentActivity.class);
            it1.putExtra("text1", title);
            it1.putExtra("text2", doctor_details[i][0]);
            it1.putExtra("text3", doctor_details[i][1]);
            it1.putExtra("text4", doctor_details[i][3]);
            it1.putExtra("text5", doctor_details[i][4]);
            startActivity(it1);
        });
    }
}
