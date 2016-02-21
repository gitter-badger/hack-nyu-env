package com.example.aaronwalker.myfootprintpal;

import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by miles on 2/20/16.
 */
public class MyAdapter extends BaseExpandableListAdapter {
    private List<String> header_titles;
    private HashMap<String, List<String>> child_titles;
    private Context ctx;
    MyAdapter(Context ctx, List<String> header_titles, HashMap<String, List<String>> child_titles)
    {
        this.ctx = ctx;
        this.header_titles = header_titles;
        this.child_titles = child_titles;
    }
    @Override
    public int getGroupCount() {
        return header_titles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return child_titles.get(header_titles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return header_titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return child_titles.get(header_titles.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String title = (String)this.getGroup(groupPosition);
        if(convertView == null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.parent_layout, null);
        }
        TextView textView = (TextView)convertView.findViewById(R.id.heading_item);
        textView.setTypeface(null, Typeface.BOLD);
        textView.setText(title);

        return convertView;
    }

    @Override
    public View getChildView(final int groupPosition, final int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String)this.getChild(groupPosition, childPosition);
        if(convertView==null) {
            LayoutInflater layoutInflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.child_layout, null);
        }
        Button button = (Button) convertView.findViewById(R.id.child_item);
        button.setText(title);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                switch((groupPosition)) {
                    case 0:
                        if (childPosition == 0) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Water");
                            v.getContext().startActivity(intent);
                        }
                        else if (childPosition == 1) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Electricity");
                            v.getContext().startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Waste");
                            v.getContext().startActivity(intent);
                        }
                        break;
                    case 1:
                        if (childPosition == 0) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Car");
                            v.getContext().startActivity(intent);
                        }
                        else if (childPosition == 1) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Public");
                            v.getContext().startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Human");
                            v.getContext().startActivity(intent);
                        }
                        break;
                    case 2:
                        if (childPosition == 0) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Heavy");
                            v.getContext().startActivity(intent);
                        }
                        else if (childPosition == 1) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Pescatarian");
                            v.getContext().startActivity(intent);
                        }
                        else if (childPosition == 2) {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Vegitarian");
                            v.getContext().startActivity(intent);
                        }
                        else {
                            Intent intent = new Intent("com.example.aaronwalker.myfootprintpal.Vegan");
                            v.getContext().startActivity(intent);
                        }
                        break;
                    default:
                        break;
                }
            }
        });
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
