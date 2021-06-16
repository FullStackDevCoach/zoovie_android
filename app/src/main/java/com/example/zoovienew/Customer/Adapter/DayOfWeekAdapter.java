package com.example.zoovienew.Customer.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

import com.example.zoovienew.R;

import java.util.ArrayList;

public class DayOfWeekAdapter  extends BaseAdapter {

    private Context mContext;
    private ArrayList<String> mData;
    private LayoutInflater mInflater;

    public DayOfWeekAdapter(Context context, ArrayList<String> data) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mData = data;
    }
    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;

        if (convertView == null) {
            holder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.item_dayofweek, parent, false);
            holder.name = (AppCompatTextView) convertView.findViewById(R.id.tv_day_name);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.name.setText(mData.get(position));

        convertView.setTag(holder);

        return convertView;
    }

    public class ViewHolder {
        AppCompatTextView name;
    }
}