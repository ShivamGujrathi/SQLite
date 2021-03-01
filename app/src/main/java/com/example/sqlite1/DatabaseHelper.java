package com.example.sqlite1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "employeedatabase";
    private static final String TABLE_NAME = "Employee";
    private static String ID = "id";
    private static String name = "name";
    private static String email = "email";
    private static String phone = "phone";
    private static String address = "address";
    private SQLiteDatabase sqLiteDatabase;
    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + ID + " INTEGER PRIMARY KEY AUTOINCREMENT," + name + " TEXT NOT NULL," + email + " TEXT NOT NULL," + phone + " TEXT NOT NULL ," + address + " TEXT NOT NULL);";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);

    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(sqLiteDatabase);

    }

    public void addEmployee(EmployeeModel employeeModel) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.name, employeeModel.getName());
        contentValues.put(DatabaseHelper.email, employeeModel.getEmail());
        contentValues.put(DatabaseHelper.phone, employeeModel.getPhone());
        contentValues.put(DatabaseHelper.address, employeeModel.getAddress());
        sqLiteDatabase = this.getWritableDatabase();
        sqLiteDatabase.insert(DatabaseHelper.TABLE_NAME, null, contentValues);

    }

    public List<EmployeeModel> getEmployeeList() {
        String sql = "select * from " + TABLE_NAME;
        sqLiteDatabase = this.getReadableDatabase();
        List<EmployeeModel> stroreemployee = new ArrayList<>();
        Cursor cursor = sqLiteDatabase.rawQuery(sql, null);

        while (cursor.moveToNext()) {
            int id = Integer.parseInt(cursor.getString(0));
//            String name = cursor.getString(1);
//            String email = cursor.getString(2);
//            String phone = cursor.getString(3);
//            String address = cursor.getString(4);
            stroreemployee.add(new EmployeeModel(id, cursor.getString(1), cursor.getString(2), cursor.getString(3), cursor.getString(4)));
        }

        cursor.close();
        return stroreemployee;
    }
}
