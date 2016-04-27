package com.adithyakatragadda.demoappwithnavigation;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.TextView;

import java.util.HashMap;
import java.util.List;

/**
 * Created by adithyakatragadda on 4/26/16.
 */
public class ExpandableLVAdapter extends BaseExpandableListAdapter {

    private List<String> listHead_titles;
    private HashMap<String, List<String>> hashChild_titles;
    private Context ctx;

    ExpandableLVAdapter(Context ctx, List<String> listHead_titles, HashMap<String, List<String>> hashChild_titles) {
        this.ctx = ctx;
        this.listHead_titles = listHead_titles;
        this.hashChild_titles = hashChild_titles;
    }

    @Override
    public int getGroupCount() {
        return listHead_titles.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return hashChild_titles.get(listHead_titles.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return listHead_titles.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return hashChild_titles.get(listHead_titles.get(groupPosition)).get(childPosition);
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
            LayoutInflater layout_inflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layout_inflater.inflate(R.layout.elv_parentlayout, null);
        }

        TextView tv = (TextView)convertView.findViewById(R.id.tv_heading_parent);
        tv.setTypeface(null, Typeface.BOLD);
        tv.setText(title);

        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String title = (String)this.getChild(groupPosition, childPosition);
        if(convertView == null) {
            LayoutInflater layout_inflater = (LayoutInflater)this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layout_inflater.inflate(R.layout.elv_chiledlayout, null);
        }

        TextView tv = (TextView)convertView.findViewById(R.id.tv_chiled_elv);
        tv.setText(title);

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
