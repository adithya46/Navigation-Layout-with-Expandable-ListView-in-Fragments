package com.adithyakatragadda.demoappwithnavigation;

import android.content.Context;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    DrawerLayout dl;
    Toolbar toolBar;
    ActionBarDrawerToggle abdt;

    FragmentTransaction ft;

    NavigationView nv;

    Context ctx;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolBar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolBar);

        ctx = this;

        dl = (DrawerLayout) findViewById(R.id.drawer_layout);

        abdt = new ActionBarDrawerToggle(this, dl, toolBar, R.string.drawer_open, R.string.drawe_close);

        dl.setDrawerListener(abdt);

        ft = getSupportFragmentManager().beginTransaction();
        ft.add(R.id.fl_main_container, new HomeFragment(ctx));
        ft.commit();

        getSupportActionBar().setTitle("Home");

        nv = (NavigationView)findViewById(R.id.nv_view);
        nv.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.home_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Home");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.news_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new NewsFrag());
                        ft.commit();
                        getSupportActionBar().setTitle("News");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.spotes_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Sports");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.health_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Health");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.art_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Art");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.travel_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Travel");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.tech_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Tech");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

                    case R.id.business_id:
                        ft = getSupportFragmentManager().beginTransaction();
                        ft.replace(R.id.fl_main_container, new HomeFragment(ctx));
                        ft.commit();
                        getSupportActionBar().setTitle("Business");
                        item.setChecked(true);
                        dl.closeDrawers();
                        break;

//                    case R.id.exit_id:
//                        finish();
//                        break;
                }

                return true;
            }
        });
    }

    protected void onPostCreate(Bundle saveInstanceState) {
        super.onPostCreate(saveInstanceState);
        abdt.syncState();
    }
}
