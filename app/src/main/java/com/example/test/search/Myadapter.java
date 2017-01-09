package com.example.test.search;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by User on 1/7/2017.
 */
public class Myadapter extends BaseAdapter{
    LayoutInflater in;
    ArrayList<get> list;
    public Myadapter(Context applicationContext, ArrayList<get> list1) {
        in= (LayoutInflater) applicationContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        list=list1;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v=in.inflate(R.layout.row,null);
        String text=list.get(position).getEn() +" "+ list.get(position).getType()+" "+list.get(position).getMy();
        TextView tv= (TextView) v.findViewById(R.id.textView);
        tv.setText(text);
        return v;
    }

    public void refresh(ArrayList<get> list1) {
        list=list1;
        notifyDataSetChanged();
    }

}
