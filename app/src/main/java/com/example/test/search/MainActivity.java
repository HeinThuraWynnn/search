package com.example.test.search;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lv;
    ImageButton btn;
    EditText ed;
    ArrayList <get> list;
    Myadapter adapter;
    Database mdb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mdb= new Database(getApplicationContext());
        mdb.copy_to_internal();
        lv= (ListView) findViewById(R.id.lv);
        btn= (ImageButton) findViewById(R.id.imageButton);
        ed= (EditText) findViewById(R.id.editText);
        list= new ArrayList<>();
        adapter=new Myadapter(getApplicationContext(),list);
        lv.setAdapter(adapter);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String  str=ed.getText().toString();
                list=mdb.get_select_data(str);
                adapter.refresh(list);
            }
        });


    }
}
