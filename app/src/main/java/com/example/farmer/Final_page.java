package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewParent;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Final_page extends AppCompatActivity{

    private Button btnsave;
    String title,food,vegitable,livestock,livestock_rb,marketdist;
    private TextView titletext;
    private Spinner spinner1,spinner2,spinner3;
    private EditText editText1,editText2,editText3,editText4;
    private RadioGroup radioGroup1,radioGroup2;
    private RadioButton radioButton1,radioButton2,rb_yes,rb_no;

    DatabaseStartingPage databaseStartingPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_final_page);

        databaseStartingPage = new DatabaseStartingPage(this);

        spinner1 = (Spinner)findViewById(R.id.spinner_food);
        spinner2 = (Spinner)findViewById(R.id.spinner_vegitable);
        spinner3 = (Spinner)findViewById(R.id.spinner_livestock);
        editText1 = (EditText)findViewById(R.id.areaofland);
        editText2 = (EditText)findViewById(R.id.areaoflandveg);
        editText3 = (EditText)findViewById(R.id.nofanimal);
        editText4 = (EditText)findViewById(R.id.nearmarket);
        radioGroup1 = (RadioGroup)findViewById(R.id.radio_group1);
        radioGroup2 = (RadioGroup)findViewById(R.id.radio_group2);

        titletext = (TextView)findViewById(R.id.textitle);
        title = getIntent().getExtras().getString("project_name");
        titletext.setText(title);
        btnsave = (Button)findViewById(R.id.next);
        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                food = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                vegitable = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        spinner3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                livestock = adapterView.getItemAtPosition(i).toString();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    private void addData() {
        boolean isInserted = databaseStartingPage.insertFourthData(titletext.getText().toString(),
                food,
                editText1.getText().toString(),
                vegitable,
                editText2.getText().toString(),
                livestock_rb,
                livestock,
                editText3.getText().toString(),
                marketdist,
                editText4.getText().toString()
        );
        if (isInserted = true) {
            Toast.makeText(Final_page.this, "Data inserted!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Final_page.this, Survey_List.class);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(Final_page.this, "Data insertion fail!", Toast.LENGTH_SHORT).show();
        }
    }

    public void livestock(View view) {
        int livestocks = radioGroup1.getCheckedRadioButtonId();
        radioButton1 = findViewById(livestocks);
        livestock_rb = radioButton1.getText().toString();
    }
    public void marketdistance(View view) {
        int distance = radioGroup2.getCheckedRadioButtonId();
        radioButton2 = findViewById(distance);
        marketdist = radioButton2.getText().toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
