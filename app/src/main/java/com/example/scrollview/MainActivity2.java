package com.example.scrollview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import android.os.Bundle;
import android.view.MenuItem;

import androidx.fragment.app.Fragment;
import com.example.scrollview.databinding.ActivityMainBinding;
import com.google.android.material.navigation.NavigationBarView;
import android.annotation.SuppressLint;
public class MainActivity2 extends AppCompatActivity {

    ActivityMainBinding binding;
    @SuppressLint("NonConstantResourceId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);


        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationView);

        if (savedInstanceState == null){
            setCurrentFragment(new Fragment());
        }


        bottomNavigationView.setOnItemReselectedListener(new NavigationBarView.OnItemReselectedListener() {
            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

                Fragment selected = null;

              if (item.getItemId()== R.id.home){
                  Fragment fragment = new first();
              }
                if (item.getItemId()== R.id.profile){
                    Fragment fragment = new second();
                }
                if (item.getItemId()== R.id.settings){
                    Fragment fragment = new third();
                }

                return ;
            }
        });

    }
    private void setCurrentFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frame_out, fragment)
                .commit();

    }
}