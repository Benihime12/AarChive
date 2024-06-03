package com.example.aarchive;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<String> {

    private Context mContext;
    private List<String> mItems;
    private int mResource;

    public CustomAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
        mContext = context;
        mItems = items;
        mResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
        }

        TextView textView = convertView.findViewById(R.id.item_text);
        textView.setText(mItems.get(position));


        return convertView;
    }
}
