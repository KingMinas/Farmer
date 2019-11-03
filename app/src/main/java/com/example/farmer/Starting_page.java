package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Starting_page extends AppCompatActivity implements Create_Dialog.CreateDialogListener{

    private RadioGroup radioGroup;
    private RadioButton radioButton;
    private TextView titletext, tvgender;
    private Button btnnext;
    String gender;
    private EditText etfullname, etdob, etaddress, etphone, etemail, etprovince, etdistrict;

    DatabaseStartingPage databaseStartingPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_page);

        databaseStartingPage = new DatabaseStartingPage(this);

        openDialog();

        etfullname = (EditText)findViewById(R.id.full_name);
        etdob = (EditText)findViewById(R.id.dob);
        etaddress = (EditText)findViewById(R.id.current_address);
        etphone = (EditText)findViewById(R.id.phone);
        etemail = (EditText)findViewById(R.id.email);
        etprovince = (EditText)findViewById(R.id.province);
        etdistrict = (EditText)findViewById(R.id.district);


        radioGroup = (RadioGroup)findViewById(R.id.radio_group);
        titletext = (TextView)findViewById(R.id.textitle);
        tvgender = (TextView)findViewById(R.id.gender);
        btnnext = (Button)findViewById(R.id.next);
        TextView btnback = (TextView)findViewById(R.id.backbtn);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Starting_page.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        btnnext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addData();
            }
        });

    }

    private void addData() {

        if (etfullname.length()==0){
            etfullname.setError("Please enter name");
        }
        else if (etdob.length()==0){
            etdob.setError("Please enter date of birth");
        }
        else if (etaddress.length()==0){
            etaddress.setError("Please enter address");
        }
        else if (etphone.length()==0){
            etphone.setError("Please enter phone number");
        }
        else if (etprovince.length()==0){
            etprovince.setError("Please enter province number");
        }
        else if (etdistrict.length()==0){
            etdistrict.setError("Please enter district name");
        }
        else {
            boolean isInserted = databaseStartingPage.insertData(titletext.getText().toString(),
                    etfullname.getText().toString(),
                    etdob.getText().toString(),
                    gender,
                    etaddress.getText().toString(),
                    etphone.getText().toString(),
                    etemail.getText().toString(),
                    etprovince.getText().toString(),
                    etdistrict.getText().toString()
            );
            if (isInserted = true) {
                Toast.makeText(Starting_page.this, "Data inserted!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Starting_page.this, Second_page.class);
                String title = titletext.getText().toString();
                intent.putExtra("project_name", title);
                startActivity(intent);
                finish();
            } else {
                Toast.makeText(Starting_page.this, "Data insertion fail!", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private void openDialog() {
        Create_Dialog create_dialog = new Create_Dialog();
        create_dialog.show(getSupportFragmentManager(), "create dialog");
    }

    @Override
    public void applyTexts(String name) {
        titletext.setText(name);
    }

    @Override
    public void closeActivity() {
        Intent intent = new Intent(Starting_page.this, Dashboard.class);
        startActivity(intent);
        finish();
    }

    public void checkButton(View view) {
        int checkedid = radioGroup.getCheckedRadioButtonId();
        radioButton = findViewById(checkedid);
        gender = radioButton.getText().toString();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(Starting_page.this,Dashboard.class);
        startActivity(intent);
        finish();
    }
}
