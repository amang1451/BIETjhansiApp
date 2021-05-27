package com.example.bietjhansiapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.bietjhansiapp.ebook.EbookActivity;
import com.example.bietjhansiapp.ui.about.AboutFragment;
import com.example.bietjhansiapp.ui.faculty.FacultyFragment;
import com.example.bietjhansiapp.ui.gallery.GalleryFragment;
import com.example.bietjhansiapp.ui.home.HomeFragment;
import com.example.bietjhansiapp.ui.notice.NoticeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.navigation.NavigationView;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;
//    private NavController navController;
    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle actionBarDrawerToggle;
    private NavigationView navigationView;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private int checkedItem;
    private String selected;

    private final String CHECKEDITEM="checked item";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomNavigationView=findViewById(R.id.bottomNavigationView);


        drawerLayout=findViewById(R.id.drawerLayout);
        navigationView=findViewById(R.id.navigationView);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,R.string.open,R.string.close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
        Objects.requireNonNull(getSupportActionBar()).setDisplayHomeAsUpEnabled(true);
        navigationView.setNavigationItemSelectedListener(this);

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,new HomeFragment()).commit();
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

//        navController=Navigation.findNavController(this,R.id.frameLayout);
//
//        NavigationUI.setupWithNavController(bottomNavigationView,navController);

        sharedPreferences=this.getSharedPreferences("themes", Context.MODE_PRIVATE);
        editor=sharedPreferences.edit();
        switch(getCheckedItem()){
            case 0:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                break;
            case 1:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                break;
            case 2:
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                break;
        }
    }

    //Bottom navigation bar
    private BottomNavigationView.OnNavigationItemSelectedListener navListener=
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragement=null;
                    switch(item.getItemId()){
                        case R.id.homeNavigation:
                            selectedFragement=new HomeFragment();
                            break;
                        case R.id.facultyNavigation:
                            selectedFragement=new FacultyFragment();
                            break;
                        case R.id.noticeNavigation:
                            selectedFragement=new NoticeFragment();
                            break;
                        case R.id.galleryNavigation:
                            selectedFragement=new GalleryFragment();
                            break;
                        case R.id.aboutNavigation:
                            selectedFragement=new AboutFragment();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout,selectedFragement).commit();
                    return true;
                }
            };

    // navigation drawer
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(actionBarDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        return true;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId())
        {
            case R.id.navigationVideo:
//                Toast.makeText(this, "Video Lectures", Toast.LENGTH_SHORT).show();
                Uri video=Uri.parse("https://www.youtube.com/c/DrAtul/featured");
                Intent videointent=new Intent(Intent.ACTION_VIEW,video);
                if(videointent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(videointent);
                }
                break;
            case R.id.navigationDevelopers:
                Toast.makeText(this, "Developers", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationEbook:
                startActivity(new Intent(this, EbookActivity.class));
                break;
            case R.id.navigationRate:
                Toast.makeText(this, "Rate Us", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationShare:
                Toast.makeText(this, "Share", Toast.LENGTH_SHORT).show();
                break;
            case R.id.navigationWebsite:
                Uri website=Uri.parse("http://bietjhs.ac.in");
                Intent intent=new Intent(Intent.ACTION_VIEW,website);
                if(intent.resolveActivity(getPackageManager())!=null)
                {
                    startActivity(intent);
                }
                break;
            case R.id.navigationTheme:
                showDialog();
                break;
        }
        return true;
    }

    private void showDialog() {
        String[] themes=this.getResources().getStringArray(R.array.theme);

        MaterialAlertDialogBuilder builder=new MaterialAlertDialogBuilder(this);
        builder.setTitle("Select Theme");
        builder.setSingleChoiceItems(R.array.theme, getCheckedItem(), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                selected=themes[which];
                checkedItem=which;
            }
        });

        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(selected==null)
                {
                    selected=themes[which];
                    checkedItem=which;
                }
                switch(checkedItem){
                    case 0:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM);
                        break;
                    case 1:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                        break;
                    case 2:
                        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                        break;

                }
                setCheckedItem(checkedItem);
            }
        });

        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog dialog=builder.create();
        dialog.show();
    }

    private int getCheckedItem(){
        return sharedPreferences.getInt(CHECKEDITEM,0);
    }

    private void setCheckedItem(int i)
    {
        editor.putInt(CHECKEDITEM,i);
        editor.apply();
    }

    // Activity life cycle on back pressed
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }

    }
}