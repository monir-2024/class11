package com.example.allinoneapp;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    DrawerLayout drawer ;
    MaterialToolbar toolbar ;
    NavigationView navigationview ;
    ImageView google1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        drawer = findViewById(R.id.drawer);
        toolbar = findViewById(R.id.toolbar);
        navigationview = findViewById(R.id.navigationview);
        google1 = findViewById(R.id.google1);



 ///////Drawer lay out start from here /////////////////////////////////////////////////

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                MainActivity.this, drawer,toolbar,R.string.open,R.string.close);
        drawer.addDrawerListener(toggle);

        navigationview.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                if (item.getItemId() == R.id.about) {

                    Intent intent = new Intent(MainActivity.this , aboutus.class);
                    startActivity(intent);

                    drawer.closeDrawer(GravityCompat.START);

                }

                if (item.getItemId() == R.id.Exit) {

                    new AlertDialog.Builder(MainActivity.this)
                            .setMessage("Do You Want to Exit?")
                            .setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    finish();
                                }
                            })

                            .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {

                                    dialog.dismiss();
                                }
                            })

                            .show();

                    drawer.closeDrawer(GravityCompat.START);

                }

                return true;


            }
        });

///////////////////////////////////////////////////////////////////////////////end////

        google1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                webview.url = "https://www.google.com.sa";

                Intent intent = new Intent(MainActivity.this, webview.class);
                startActivity(intent);

            }
        });





    }
}