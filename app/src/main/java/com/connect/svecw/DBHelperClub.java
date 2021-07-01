package com.connect.svecw;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import java.util.ArrayList;
import java.util.List;


public class DBHelperClub extends SQLiteOpenHelper {

    public static final String DATABASE_NAME = "Club.db";
    public static final int DATABASE_VERSION = 2;
    public static final String TABLE_NAME="CLUB_TABLE";
    public DBHelperClub(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context,DATABASE_NAME, null,DATABASE_VERSION);
    }
    private SQLiteDatabase db;


    public void queryData(String sql){

        SQLiteDatabase database=getWritableDatabase();
        database.execSQL(sql);


    }

    public void insertData(String name,String C_manager, String contact, String uid,byte[] image){

        SQLiteDatabase database=getWritableDatabase();
        String sql="INSERT INTO "+TABLE_NAME+" VALUES (null,?, ? , ?, ?, ?)";

        SQLiteStatement statement=database.compileStatement(sql);
        statement.clearBindings();


        statement.bindString(1,name);
        statement.bindString(2,C_manager);
        statement.bindString(3,contact);
        statement.bindString(4,uid);
        statement.bindBlob(5,image);

        statement.executeInsert();



    }
    public String searchPass(String name){

        SQLiteDatabase db=this.getReadableDatabase();
        String query="SELECT name ,u_id  FROM "+TABLE_NAME;
        Cursor cursor=db.rawQuery(query,null);
        String a,b;
        b="NOT FOUND IN DIRECTORY";
        if(cursor.moveToFirst()){

            do{
                a=cursor.getString(0);

                if(a.equals(name)){
                    b=cursor.getString(1);
                    break;
                }
            }
            while(cursor.moveToNext());
        }

        return b;
    }


    public void updateData(int id,String name,String C_manager,String contact, String uid,byte[] image){
        SQLiteDatabase database=getWritableDatabase();
        String sql="UPDATE CLUB_TABLE SET name = ? , C_manager = ? , contact  = ?, uid = ?, image =? WHERE Id = ?";
        SQLiteStatement statement=database.compileStatement(sql);

        statement.bindString(1,name);
        statement.bindString(2,C_manager);
        statement.bindString(3,contact);
        statement.bindString(4,uid);
        statement.bindBlob(5,image);
        statement.bindDouble(6,(double)id);

        statement.execute();
        database.close();


    }

    public void deleteData(int id){

        SQLiteDatabase database=getWritableDatabase();
        String sql="DELETE FROM CLUB_TABLE WHERE Id = ?";
        SQLiteStatement statement=database.compileStatement(sql);

        statement.clearBindings();
        statement.bindDouble(1,(double)id);

        statement.execute();
        database.close();



    }
    public Cursor getData(String sql){

        SQLiteDatabase database=getReadableDatabase();
         return  database.rawQuery(sql,null);
    }

    public List<String> getAllLabels(){
        List<String> labels = new ArrayList<String>();

        String selectQuery = "SELECT * FROM CLUB_TABLE";

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                labels.add(cursor.getString(1));
            } while (cursor.moveToNext());
        }

        // closing connection
        cursor.close();
        db.close();

        // returning lables
        return labels;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
