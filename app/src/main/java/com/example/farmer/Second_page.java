package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class Second_page extends AppCompatActivity {

    private Button btnnext;
    String title, incomechoice;
    private TextView titletext;
    private RadioGroup radioGroup;
    private RadioButton radioButton,rb_yes,rb_no;
    private EditText etfamily,ethighedu,etjob,etbussiness,etotherincome,eteducation,ethealth,etagriculturalwork,etotherexp;

    DatabaseStartingPage databaseStartingPage;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second_page);

        databaseStartingPage = new DatabaseStartingPage(this);

        etfamily = (EditText)findViewById(R.id.earn_family);
        ethighedu = (EditText)findViewById(R.id.higheducation);
        etjob = (EditText)findViewById(R.id.jobs);
        etbussiness = (EditText)findViewById(R.id.business);
        etotherincome = (EditText)findViewById(R.id.income_others);
        eteducation = (EditText)findViewById(R.id.education);
        ethealth = (EditText)findViewById(R.id.health);
        etagriculturalwork = (EditText)findViewById(R.id.agrecultural_work);
        etotherexp = (EditText)findViewById(R.id.expenditure_others);

        radioGroup = (RadioGroup)findViewById(R.id.radio_income);

        titletext = (TextView)findViewById(R.id.textitle);
        title = getIntent().getExtras().getString("project_name");
        titletext.setText(title);

        btnnext = (Button)findViewById(R.id.next);
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });
    }

    private void addData() {

        if (etfamily.length()==0){
            etfamily.setError("Please enter family");
        }
        else if (ethighedu.length()==0){
            ethighedu.setError("Please enter higher education");
        }

        else{
        boolean isInserted = databaseStartingPage.insertSecondData(titletext.getText().toString(),
                etfamily.getText().toString(),
                ethighedu.getText().toString(),
                incomechoice,
                etjob.getText().toString(),
                etbussiness.getText().toString(),
                etotherincome.getText().toString(),
                eteducation.getText().toString(),
                ethealth.getText().toString(),
                etagriculturalwork.getText().toString(),
                etotherexp.getText().toString()
        );
        if (isInserted = true) {
            Toast.makeText(Second_page.this, "Data inserted!", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(Second_page.this, Third_page.class);
            intent.putExtra("project_name",title);
            startActivity(intent);
            startActivity(intent);
            finish();

        } else {
            Toast.makeText(Second_page.this, "Data insertion fail!", Toast.LENGTH_SHORT).show();
        }

    }
    }

    public void checkRadioButton(View view) {
        int checkedid = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(checkedid);
        incomechoice = radioButton.getText().toString();

        rb_yes = (RadioButton)findViewById(R.id.radio_yes);
        rb_no = (RadioButton)findViewById(R.id.radio_no);

        if (rb_yes.isChecked()){
            etjob.setEnabled(true);
            etbussiness.setEnabled(true);
            etotherincome.setEnabled(true);
        }
        else if (rb_no.isChecked()){
            etjob.setEnabled(false);
            etbussiness.setEnabled(false);
            etotherincome.setEnabled(false);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
