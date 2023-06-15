package com.example.letcommute;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;

import com.example.letcommute.Fragments.DatabaseFragment;
import com.example.letcommute.Fragments.DistressFragment;
import com.example.letcommute.Fragments.GuidelineFragment;
import com.example.letcommute.Fragments.HomeFragment;
import com.example.letcommute.Fragments.TrackFragment;
import com.example.letcommute.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ResponderHomeActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener{

    BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_responder_home);
        bottomNavigationView = findViewById(R.id.bottonnav);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);
        loadFragment(new DistressFragment());
        Intent intent = getIntent();
        getSupportActionBar().setTitle("Good evening, " + intent.getStringExtra("username_key"));
    }
    void loadFragment(Fragment fragment) {
        //to attach fragment
        getSupportFragmentManager().beginTransaction().replace(R.id.relativelayout, fragment).commit();
    }
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        Fragment fragment = null;
        switch (item.getItemId()) {
            case R.id.navDistress:
                fragment = new DistressFragment();
                break;

            case R.id.navCrimebase:
                fragment = new DatabaseFragment();
                break;

            case R.id.navSignout:{
                AlertDialog alertDialog = new AlertDialog.Builder(ResponderHomeActivity.this).create();
                alertDialog.setTitle("Sign Out");
                alertDialog.setMessage("\nAre you sure you want to sign out?");
                alertDialog.setButton(AlertDialog.BUTTON_POSITIVE, "YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                finish();
                                dialog.dismiss();
                            }
                        });
                alertDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "CANCEL",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.show();
            }

        }
        if (fragment != null) {
            loadFragment(fragment);
        }
        return true;
    }
}