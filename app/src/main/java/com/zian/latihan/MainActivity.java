package com.zian.latihan;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import java.util.ArrayList;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    Bundle activityState;
    EditText name;
    EditText number;
    EditText email;
    RadioButton prodi;
    RadioGroup radioGroup;
    CheckBox cbPython,cbJava;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            name = findViewById(R.id.etName);
            number = findViewById(R.id.etNumber);
            email = findViewById(R.id.etEmail);
            radioGroup = findViewById(R.id.rgProdi);
            cbPython =(CheckBox) findViewById(R.id.cbPython);
            cbJava = (CheckBox) findViewById(R.id.cbJava);

            Button btnkirim = findViewById(R.id.simpanintent);
            btnkirim.setOnClickListener(v->{

                int radioId = radioGroup.getCheckedRadioButtonId();

                prodi = (RadioButton) findViewById(radioId);

                ArrayList<String> hasilCb = new ArrayList<String>();

                if (cbPython.isChecked()){
                    hasilCb.add("Python");
                }
                if (cbJava.isChecked()){
                    hasilCb.add("Java");
                }

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                intent.putExtra("NAME", Objects.requireNonNull(name.getText()).toString());
                intent.putExtra("NOHANDPHONE", Objects.requireNonNull(number.getText()).toString());
                intent.putExtra("EMAIL", Objects.requireNonNull(email.getText()).toString());
                intent.putExtra("PRODI", Objects.requireNonNull(prodi.getText()).toString());
                intent.putStringArrayListExtra("CHECKBOX",hasilCb);

                startActivity(intent);
            });

            Button simpanBundle = findViewById(R.id.btSimpanBundle);
            simpanBundle.setOnClickListener(v -> {
                String nama = name.getText().toString();
                Integer handphone = Integer.parseInt(number.getText().toString());
                String mail = email.getText().toString();

                ArrayList<String> hasilCb = new ArrayList<String>();
                if (cbPython.isChecked()){
                    hasilCb.add("Python");
                }
                if (cbJava.isChecked()){
                    hasilCb.add("Java");
                }

                int radioId = radioGroup.getCheckedRadioButtonId();

                prodi = (RadioButton) findViewById(radioId);

                Intent intent = new Intent(MainActivity.this, MainActivity2.class);
                Bundle bundle = new Bundle();
                bundle.putString("nama", nama);
                bundle.putString("handphone", handphone.toString());
                bundle.putString("mail", mail);
                bundle.putStringArrayList("hasilCb",hasilCb);
                bundle.putString("prodi",prodi.toString());
                intent.putExtras(bundle);
                startActivity(intent);
                finish();
            });
        }
        public void web(View v){
            Intent intent=new  Intent(Intent.ACTION_VIEW, Uri.parse("https://www.ulbi.ac.id/"));
            startActivity(intent);
        }

        public void telepon(View view) {
            String nomor = "081224122760";
            Intent panggil = new Intent(Intent.ACTION_DIAL);
            panggil.setData(Uri.fromParts("tel", nomor,null));
            startActivity(panggil);
    }
}
