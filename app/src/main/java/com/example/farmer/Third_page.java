package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Third_page extends AppCompatActivity {

    private RadioGroup radioGroup1, radioGroup2, radioGroup3, radioGroup4, radioGroup5;
    private RadioButton radioButton1, radioButton2, radioButton3, radioButton4, radioButton5, rb_yes, rb_no, rb_river, rb_canal, rb_waterboring, rb_diesel, rb_electricity;
    private Button btnext;
    String title, usewater, water_resource, pump_type, land_type, ownership;
    private TextView titletext;
    private EditText etpumpexp, etboringsize, etlandarea;

    DatabaseStartingPage databaseStartingPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third_page);

        databaseStartingPage = new DatabaseStartingPage(this);

        radioGroup1 = (RadioGroup) findViewById(R.id.radio_g);
        radioGroup2 = (RadioGroup) findViewById(R.id.radio_g2);
        radioGroup3 = (RadioGroup) findViewById(R.id.radio_g3);
        radioGroup4 = (RadioGroup) findViewById(R.id.radio_g4);
        radioGroup5 = (RadioGroup) findViewById(R.id.radio_g5);
        etpumpexp = (EditText) findViewById(R.id.monthlykharcha);
        etboringsize = (EditText) findViewById(R.id.boringsize);
        etlandarea = (EditText) findViewById(R.id.areaofland);

        rb_yes = (RadioButton) findViewById(R.id.yes);
        rb_no = (RadioButton) findViewById(R.id.no);
        rb_river = (RadioButton) findViewById(R.id.river);
        rb_canal = (RadioButton) findViewById(R.id.canal);
        rb_waterboring = (RadioButton) findViewById(R.id.waterboring);
        rb_diesel = (RadioButton) findViewById(R.id.diesel);
        rb_electricity = (RadioButton) findViewById(R.id.electricity);

        titletext = (TextView) findViewById(R.id.textitle);
        title = getIntent().getExtras().getString("project_name");
        titletext.setText(title);
        btnext = (Button) findViewById(R.id.next);
        btnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();

            }
        });
    }

    private void addData() {
        boolean isInserted = databaseStartingPage.insertThirdData(titletext.getText().toString(),
                usewater,
                water_resource,
                pump_type,
                etpumpexp.getText().toString(),
                etboringsize.getText().toString(),
                land_type,
                ownership,
                etlandarea.getText().toString()
        );
        if (isInserted = true) {
            Toast.makeText(Third_page.this, "Data inserted!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Third_page.this, Final_page.class);
            intent.putExtra("project_name", title);
            startActivity(intent);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(Third_page.this, "Data insertion fail!", Toast.LENGTH_SHORT).show();
        }
    }

    public void usingwaterpump(View view) {
        int checkedid = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = findViewById(checkedid);
        usewater = radioButton1.getText().toString();

        if (rb_yes.isChecked()) {
            rb_river.setEnabled(true);
            rb_canal.setEnabled(true);
            rb_waterboring.setEnabled(true);
            rb_diesel.setEnabled(true);
            rb_electricity.setEnabled(true);
            etpumpexp.setEnabled(true);
            etboringsize.setEnabled(true);
        } else if (rb_no.isChecked()) {
            rb_river.setEnabled(false);
            rb_canal.setEnabled(false);
            rb_waterboring.setEnabled(false);
            rb_diesel.setEnabled(false);
            rb_electricity.setEnabled(false);
            etpumpexp.setEnabled(false);
            etboringsize.setEnabled(false);
        }

    }

    public void waterresources(View view) {
            int checkedid2 = radioGroup2.getCheckedRadioButtonId();
            radioButton2 = findViewById(checkedid2);
            water_resource = radioButton2.getText().toString();
    }
        public void pumptype (View view){
            int checkedid3 = radioGroup3.getCheckedRadioButtonId();
            radioButton3 = findViewById(checkedid3);
            pump_type = radioButton3.getText().toString();
    }

        public void landtype (View view){
            int checkedid4 = radioGroup4.getCheckedRadioButtonId();
            radioButton4 = findViewById(checkedid4);
            land_type = radioButton4.getText().toString();
        }
        public void ownership (View view){
            int checkedid5 = radioGroup5.getCheckedRadioButtonId();
            radioButton5 = findViewById(checkedid5);
            ownership = radioButton5.getText().toString();
        }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
