package com.zian.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    TextView hasilname;
    TextView hasilnumber;
    TextView hasilemail;
    TextView hasilcb;
    TextView hasilRb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ArrayList<String> hasilCbList = new ArrayList<String>();

        hasilname = findViewById(R.id.tvHasilName);
        hasilnumber = findViewById(R.id.tvHasilNumber);
        hasilemail = findViewById(R.id.tvHasilEmail);
        hasilcb = findViewById(R.id.tvHasilcb);
        hasilRb = findViewById(R.id.tvHasilRb);

        hasilname.setText(getIntent().getStringExtra("NAME"));
        hasilnumber.setText(getIntent().getStringExtra("NOHANDPHONE"));
        hasilemail.setText(getIntent().getStringExtra("EMAIL"));
        hasilRb.setText(getIntent().getStringExtra("PRODI"));

        hasilCbList = getIntent().getStringArrayListExtra("CHECKBOX");
        hasilcb.setText("");

        for (int i = 0;i<hasilCbList.size();i++){
            hasilcb.append(hasilCbList.get(i)+", ");
        }

//        Bundle extras = getIntent().getExtras();
//        hasilname.setText(extras.getString("nama"));
//        hasilnumber.setText(extras.getString("handphone"));
//        hasilemail.setText(extras.getString("mail"));
//        hasilRb.setText(extras.getString("prodi"));
//        hasilcb.setText(extras.getString("prodi"));

        Button btnkembali = findViewById(R.id.btKembali);
        btnkembali.setOnClickListener(v-> {
            Intent intent = new Intent(MainActivity2.this, MainActivity.class);
            startActivity(intent);

        });
    }
}