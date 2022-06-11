package com.example.imagepro;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import android.util.Log;
import androidx.drawerlayout.widget.DrawerLayout;
import org.opencv.android.OpenCVLoader;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.FirebaseApp;

public class MainActivity extends AppCompatActivity {

    static {
        if(OpenCVLoader.initDebug()){
            Log.d("MainActivity: ","Opencv is loaded");
        }
        else {
            Log.d("MainActivity: ","Opencv failed to load");
        }
    }

    NavigationView navigationView;
    ActionBarDrawerToggle actionBarDrawerToggle;
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    private Button camera_button;
    private Button combine_letter_button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        FirebaseApp.initializeApp(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        camera_button=findViewById(R.id.camera_button);
        camera_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CameraActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });
        combine_letter_button=findViewById(R.id.combine_letter_button);
        combine_letter_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,CombineLettersActivity.class).addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP));
            }
        });


    navigationView = findViewById(R.id.navview);
        drawerLayout = findViewById(R.id.drawer);

        //adding customised toolbar
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //toggle button
        actionBarDrawerToggle = new ActionBarDrawerToggle(this , drawerLayout,toolbar,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
 //when an item is selected from menu
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem item) {

                switch (item.getItemId())
                {
                    case R.id.home:

                        Intent newIntent = new Intent(MainActivity.this, Guide.class);
                        startActivity(newIntent);
                        Toast.makeText(getApplicationContext(),"Guide",Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.profile:
                        Toast.makeText(getApplicationContext(),"Interpreter",Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.settings:
                        Intent newIntent1 = new Intent(MainActivity.this, EditProfile.class);
                        startActivity(newIntent1);
                        Toast.makeText(getApplicationContext(),"Settings",Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;

                    case R.id.privacy:
                        Intent intent = new Intent(MainActivity.this, Login.class);
                        startActivity(intent);
                        finish();
                        Toast.makeText(getApplicationContext(),"Logged out",Toast.LENGTH_SHORT).show();
                        //close drawer
                        drawerLayout.closeDrawer(GravityCompat.START);
                        break;


                }

                return true;
            }

        });
    }
}