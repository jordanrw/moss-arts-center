package com.mossartscenter.mossartscenterpatrons;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.mossartscenter.mossartscenterpatrons.Fragments.CalendarFragment;
import com.mossartscenter.mossartscenterpatrons.Fragments.HistoryFragment;
import com.mossartscenter.mossartscenterpatrons.Fragments.HomeFragment;
import com.mossartscenter.mossartscenterpatrons.Fragments.SettingsFragment;
import com.mossartscenter.mossartscenterpatrons.Fragments.SuggestionsFragment;
import com.mossartscenter.mossartscenterpatrons.Fragments.TicketsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(com.mossartscenter.mossartscenterpatrons.R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(com.mossartscenter.mossartscenterpatrons.R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(com.mossartscenter.mossartscenterpatrons.R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
            this, drawer, toolbar, com.mossartscenter.mossartscenterpatrons.R.string.navigation_drawer_open, com.mossartscenter.mossartscenterpatrons.R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(com.mossartscenter.mossartscenterpatrons.R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.getMenu().getItem(0).setChecked(true);

        // Load the Home Fragment
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        HomeFragment homeFrag = new HomeFragment();
        transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, homeFrag);
        transaction.commit();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(com.mossartscenter.mossartscenterpatrons.R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        // Fragment manager
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        if (id == com.mossartscenter.mossartscenterpatrons.R.id.nav_home) {
            HomeFragment homeFrag = new HomeFragment();
            transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, homeFrag);
            transaction.commit();
            getSupportActionBar().setTitle("Moss Arts Center");
        } else if (id == com.mossartscenter.mossartscenterpatrons.R.id.nav_calendar) {
            CalendarFragment calendarFrag = new CalendarFragment();
            transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, calendarFrag);
            transaction.commit();
            getSupportActionBar().setTitle("Calendar");
        } else if (id == com.mossartscenter.mossartscenterpatrons.R.id.nav_tickets) {
            TicketsFragment ticketsFrag = new TicketsFragment();
            transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, ticketsFrag);
            transaction.commit();
            getSupportActionBar().setTitle("Tickets");
        } else if (id == com.mossartscenter.mossartscenterpatrons.R.id.nav_suggestions) {
            SuggestionsFragment suggestionsFrag = new SuggestionsFragment();
            transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, suggestionsFrag);
            transaction.commit();
            getSupportActionBar().setTitle("Suggestions");
        } else if (id == com.mossartscenter.mossartscenterpatrons.R.id.nav_history) {
            HistoryFragment historyFrag = new HistoryFragment();
            transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, historyFrag);
            transaction.commit();
            getSupportActionBar().setTitle("History");
        } else if (id == com.mossartscenter.mossartscenterpatrons.R.id.nav_settings) {
            SettingsFragment settingsFrag = new SettingsFragment();
            transaction.replace(com.mossartscenter.mossartscenterpatrons.R.id.fragment_container, settingsFrag);
            transaction.commit();
            getSupportActionBar().setTitle("Settings");
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(com.mossartscenter.mossartscenterpatrons.R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
