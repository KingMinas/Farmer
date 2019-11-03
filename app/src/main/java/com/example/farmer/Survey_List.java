package com.example.farmer;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Survey_List extends AppCompatActivity {

    private SearchView searchView;

    DatabaseStartingPage databaseStartingPage;
    ListView listSurveyList;
    ArrayList<String> arrayList;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_survey__list);

        searchView = (SearchView)findViewById(R.id.search_view);
        databaseStartingPage = new DatabaseStartingPage(this);
        listSurveyList = (ListView)findViewById(R.id.surveylist);
        arrayList = new ArrayList<>();

        viewDatas();

        TextView btnback = (TextView)findViewById(R.id.backbtn);
        btnback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Survey_List.this,Dashboard.class);
                startActivity(intent);
                finish();
            }
        });
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                adapter.getFilter().filter(s);
                return false;
            }
        });
    }
    private void viewDatas() {
        Cursor cursor = databaseStartingPage.viewData();

        if(cursor.getCount()==0){
            Toast.makeText(this, "No data Available..", Toast.LENGTH_SHORT).show();
        }else {
            while (cursor.moveToNext()) {

                arrayList.add(cursor.getString(1));
            }
            adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
            listSurveyList.setAdapter(adapter);
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent(Survey_List.this,Dashboard.class);
        startActivity(intent);
        finish();
    }
}
