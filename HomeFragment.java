package com.adithyakatragadda.demoappwithnavigation;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class HomeFragment extends Fragment {
    ExpandableListView expandableListView;
    Context ctx;


    public HomeFragment(Context ctx) {
        this.ctx = ctx;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);

        expandableListView = (ExpandableListView) v.findViewById(R.id.elv);
        List<String> Heading = new ArrayList<String>();
        List<String> L1 = new ArrayList<String>();
        List<String> L2 = new ArrayList<String>();

        HashMap<String, List<String>> childList = new HashMap<String, List<String>>();

        String headingItems[] = getResources().getStringArray(R.array.header_titles);
        String l1[] = getResources().getStringArray(R.array.h1_story);
        String l2[] = getResources().getStringArray(R.array.h2_story);

        for(String title : headingItems) {
            Heading.add(title);
        }

        for (String title : l1) {
            L1.add(title);
        }

        for (String title : l2) {
            L2.add(title);
        }

        childList.put(Heading.get(0), L1);
        childList.put(Heading.get(1), L2);
        childList.put(Heading.get(2), L2);
        childList.put(Heading.get(3), L2);
        childList.put(Heading.get(4), L2);
        childList.put(Heading.get(5), L2);


        ExpandableLVAdapter myAdapter = new ExpandableLVAdapter(ctx, Heading, childList);
        expandableListView.setAdapter(myAdapter);

        return v;

    }




}
