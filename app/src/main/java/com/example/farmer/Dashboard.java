package com.example.farmer;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;

import java.util.Locale;

public class Dashboard extends AppCompatActivity {

    private CardView cvfirst, cvsecond, cvthird, cvfourth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dashboard);
        loadlocale();

        cvfirst = (CardView)findViewById(R.id.firstcv);
        cvsecond = (CardView)findViewById(R.id.secondcv);
        cvthird = (CardView)findViewById(R.id.thirdcv);
        cvfourth = (CardView)findViewById(R.id.fourthcv);

        cvfourth.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,About_us.class);
                startActivity(intent);
                finish();
            }
        });

        cvfirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Starting_page.class);
                startActivity(intent);
                finish();
            }
        });

        cvsecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Dashboard.this,Survey_List.class);
                startActivity(intent);
                finish();
            }
        });
        cvthird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                changelanguageDialog();
            }
        });

    }

    private void changelanguageDialog() {
        final String[] listItems = {"नेपाली","English"};
        AlertDialog.Builder builder = new AlertDialog.Builder(Dashboard.this);
        builder.setTitle("Change Language");
        builder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i==0){
                    setLocale("ne");
                    recreate();
                }
                else if(i == 1){
                    setLocale("en");
                    recreate();
                }
                dialogInterface.dismiss();
            }
        });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.locale = locale;
        getBaseContext().getResources().updateConfiguration(configuration,getBaseContext().getResources().getDisplayMetrics());

        SharedPreferences.Editor editor = getSharedPreferences("setting",MODE_PRIVATE).edit();
        editor.putString("My_lang",lang);
        editor.apply();
    }
    public void loadlocale(){
        SharedPreferences preferences = getSharedPreferences("setting",MODE_PRIVATE);
        String language = preferences.getString("My_lang","");
        setLocale(language);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }
}
