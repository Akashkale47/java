package com.example.akashkale.aaplibusaurangabad;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;

public class DashBoardActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    BottomNavigationView bottomNavigationView;

    private static final String TAG = "DashBoardActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dash_board);

        bottomNavigationView = findViewById(R.id.bnBar);

        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        bottomNavigationView.setSelectedItemId(R.id.navigation_Timetable);

    }

    Timetable timetable = new Timetable();
    Trackbus trackbus = new Trackbus();
    Help help = new Help();

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

      switch (menuItem.getItemId())
      {
          case R.id.navigation_Timetable:
              getSupportFragmentManager().beginTransaction().replace(R.id.flBottom,timetable).commit();
              return true;
          case R.id.navigation_Trackbus:
              getSupportFragmentManager().beginTransaction().replace(R.id.flBottom,trackbus).commit();
              return true;
          case R.id.navigation_Help:
              getSupportFragmentManager().beginTransaction().replace(R.id.flBottom,help).commit();
              return true;
      }
        return false;
    }
}
