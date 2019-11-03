package com.example.farmer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseStartingPage extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Survey.db";
    public static final String TABLE_NAME = "FIRST";
    public static final String COL_1 = "id";
    public static final String COL_2 = "project_name";
    public static final String COL_3 = "full_name";
    public static final String COL_4 = "dob";
    public static final String COL_5 = "gender";
    public static final String COL_6 = "address";
    public static final String COL_7 = "phone";
    public static final String COL_8 = "email";
    public static final String COL_9 = "province";
    public static final String COL_10 = "district";

    public static final String SECOND_TABLE_NAME = "SECOND";
    public static final String COL_11 = "id";
    public static final String COL_12 = "project_name";
    public static final String COL_13 = "family_members";
    public static final String COL_14 = "higheredu";
    public static final String COL_15 = "haveincome";
    public static final String COL_16 = "jobs";
    public static final String COL_17 = "bussiness";
    public static final String COL_18 = "others";
    public static final String COL_19 = "education";
    public static final String COL_20 = "health";
    public static final String COL_21 = "agriculturalwork";
    public static final String COL_22 = "otherexp";

    public static final String THIRD_TABLE_NAME = "THIRD";
    public static final String COL_23 = "id";
    public static final String COL_24 = "project_name";
    public static final String COL_25 = "use_water_pump";
    public static final String COL_26 = "water_resources";
    public static final String COL_27 = "pump_type";
    public static final String COL_28 = "pump_exp";
    public static final String COL_29 = "boring_size";
    public static final String COL_30 = "land_type";
    public static final String COL_31 = "ownership";
    public static final String COL_32 = "area";

    public static final String FOURTH_TABLE_NAME = "FOURTH";
    public static final String COL_33 = "id";
    public static final String COL_34 = "project_name";
    public static final String COL_35 = "food_crop";
    public static final String COL_36 = "food_area";
    public static final String COL_37 = "vegetable";
    public static final String COL_38 = "veg_area";
    public static final String COL_39 = "livestock";
    public static final String COL_40 = "livestock_type";
    public static final String COL_41 = "livestock_number";
    public static final String COL_42 = "sell_product";
    public static final String COL_43 = "market_distance";

    public DatabaseStartingPage(@Nullable Context context) {
        super(context, DATABASE_NAME, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("create table " + TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,project_name VARCHAR,full_name VARCHAR,dob VARCHAR, gender VARCHAR,address VARCHAR,phone VARCHAR,email VARCHAR,province VARCHAR,district VARCHAR)");

        sqLiteDatabase.execSQL("create table " + SECOND_TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,project_name VARCHAR,family_members VARCHAR,higheredu VARCHAR,haveincome VARCHAR,jobs VARCHAR,bussiness VARCHAR,others VARCHAR,education VARCHAR,health VARCHAR,agriculturalwork VARCHAR,otherexp VARCHAR)");

        sqLiteDatabase.execSQL("create table " + THIRD_TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,project_name VARCHAR,use_water_pump VARCHAR,water_resources VARCHAR,pump_type VARCHAR,pump_exp VARCHAR,boring_size VARCHAR,land_type VARCHAR,ownership VARCHAR,area VARCHAR)");

        sqLiteDatabase.execSQL("create table " + FOURTH_TABLE_NAME + "(id INTEGER PRIMARY KEY AUTOINCREMENT,project_name VARCHAR,food_crop VARCHAR,food_area VARCHAR,vegetable VARCHAR,veg_area VARCHAR,livestock VARCHAR,livestock_type VARCHAR,livestock_number VARCHAR,sell_product VARCHAR,market_distance VARCHAR)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("drop table if exists "+TABLE_NAME);
        sqLiteDatabase.execSQL("drop table if exists "+SECOND_TABLE_NAME);
        sqLiteDatabase.execSQL("drop table if exists "+THIRD_TABLE_NAME);
        sqLiteDatabase.execSQL("drop table if exists "+FOURTH_TABLE_NAME);
    }

    public boolean insertData(String project_name, String full_name, String dob, String gender, String address, String phone, String email, String province, String district){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, project_name);
        contentValues.put(COL_3, full_name);
        contentValues.put(COL_4, dob);
        contentValues.put(COL_5, gender);
        contentValues.put(COL_6, address);
        contentValues.put(COL_7, phone);
        contentValues.put(COL_8, email);
        contentValues.put(COL_9, province);
        contentValues.put(COL_10, district);

        long result = sqLiteDatabase.insert(TABLE_NAME, null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public boolean insertSecondData(String project_name, String family_members, String higheredu, String haveincome, String jobs, String bussiness, String others, String education, String health, String agriculturalwork, String otherexp){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_12, project_name);
        contentValues.put(COL_13, family_members);
        contentValues.put(COL_14, higheredu);
        contentValues.put(COL_15, haveincome);
        contentValues.put(COL_16, jobs);
        contentValues.put(COL_17, bussiness);
        contentValues.put(COL_18, others);
        contentValues.put(COL_19, education);
        contentValues.put(COL_20, health);
        contentValues.put(COL_21, agriculturalwork);
        contentValues.put(COL_22, otherexp);

        long result = sqLiteDatabase.insert(SECOND_TABLE_NAME, null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public boolean insertThirdData(String project_name, String use_water_pump, String water_resources, String pump_type, String pump_exp, String boring_size, String land_type, String ownership, String area){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_24, project_name);
        contentValues.put(COL_25, use_water_pump);
        contentValues.put(COL_26, water_resources);
        contentValues.put(COL_27, pump_type);
        contentValues.put(COL_28, pump_exp);
        contentValues.put(COL_29, boring_size);
        contentValues.put(COL_30, land_type);
        contentValues.put(COL_31, ownership);
        contentValues.put(COL_32, area);

        long result = sqLiteDatabase.insert(THIRD_TABLE_NAME, null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public boolean insertFourthData(String project_name, String food_crop, String food_area, String vegetable, String veg_area, String livestock, String livestock_type, String livestock_number, String sell_product, String market_distance){
        SQLiteDatabase sqLiteDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_34, project_name);
        contentValues.put(COL_35, food_crop);
        contentValues.put(COL_36, food_area);
        contentValues.put(COL_37, vegetable);
        contentValues.put(COL_38, veg_area);
        contentValues.put(COL_39, livestock);
        contentValues.put(COL_40, livestock_type);
        contentValues.put(COL_41, livestock_number);
        contentValues.put(COL_42, sell_product);
        contentValues.put(COL_43, market_distance);

        long result = sqLiteDatabase.insert(FOURTH_TABLE_NAME, null, contentValues);
        if (result==-1)
            return false;
        else
            return true;
    }

    public Cursor viewData(){
        SQLiteDatabase sqLiteDatabase = this.getReadableDatabase();
        String query = "select * from "+TABLE_NAME;
        Cursor cursor = sqLiteDatabase.rawQuery(query, null);
        return cursor;
    }

}
