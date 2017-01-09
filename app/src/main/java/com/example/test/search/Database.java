package com.example.test.search;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by User on 1/7/2017.
 */
public class Database extends SQLiteOpenHelper {
    Context con;
    SQLiteDatabase mdb;
    String path="data/data/com.example.test.search/databases/";
    public Database(Context applicationContext) {
        super(applicationContext,"dic.db",null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void copy_to_internal() {
        File file=new File(path);

        if (!file.exists()){
            file.mkdir();
            copydatabase();
        }
    }

    private void copydatabase() {
        try {
            InputStream input=con.getAssets().open("dic.db");
            FileOutputStream output=new FileOutputStream(path+"dic.db");
            byte[] bb=new byte[1024];
            while (true){
                int i=input.read(bb);
                if(i<=0){
                    output.flush();
                    output.close();
                    input.close();
                    return;
                }
                output.write(bb,0,i);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public ArrayList<get> get_select_data(String str) {
        ArrayList<get> list=new ArrayList<>();
        mdb=getReadableDatabase();
        String sql="SELECT * FROM dic WHERE en LIKE '%"+str+"%' OR my LIKE '%"+str+"%'";
        Cursor c=mdb.rawQuery(sql,null);
        if (c.moveToFirst()){
            do {
                get eg=new get();
                eg.setEn(c.getString(0));
                eg.setType(c.getString(1));
                eg.setMy(c.getString(2));
            }while (c.moveToNext());
        }
        return list;
    }
}
