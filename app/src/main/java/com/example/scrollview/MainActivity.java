package com.example.scrollview;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.app.ActivityCompat;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.graphics.drawable.IconCompat;
import androidx.fragment.app.Fragment;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ClipData;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.media.RouteListingPreference;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.scrollview.databinding.ActivityMainBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;

public class MainActivity extends AppCompatActivity {



    private Button button;
    public View view;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        NotificationManagerCompat notificationManagerCompat;
        Notification notification;

        //for fullscreen

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);






        //games and google maps to next layout
        ImageView icon1 = findViewById(R.id.Games);
        ImageView icon2 = findViewById(R.id.GoogleMap);
        ImageView icon3 = findViewById(R.id.message);
        // Set an OnClickListener on the ImageView
        icon1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the second activity
                Intent intent = new Intent(MainActivity.this, Games.class);
                startActivity(intent);
            }
        });
        ImageView icon = findViewById(R.id.GoogleMap);
        icon2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the second activity
                Intent intent = new Intent(MainActivity.this, GoogleMaps.class);
                startActivity(intent);

            }
        });


        ImageView i = findViewById(R.id.message);
        icon3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to start the second activity
                Intent intent = new Intent(MainActivity.this, Activity_Message.class);
                startActivity(intent);
            }
        });

        //push notification
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.ECLAIR_0_1) {
            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
                NotificationChannel channel = new NotificationChannel("myCh", "My channel", NotificationManager.IMPORTANCE_DEFAULT);

                NotificationManager manager = getSystemService(NotificationManager.class);
                manager.createNotificationChannel(channel);
            }

            //design of push notification

            NotificationCompat.Builder builder = new NotificationCompat.Builder(this, "myCh")
                    .setSmallIcon(android.R.drawable.btn_star_big_on)
                    .setContentTitle("Message Received")
                    .setContentText("Body of message");

            notification = builder.build();
            notificationManagerCompat = NotificationManagerCompat.from(this);

        }

        Button myButton= findViewById(R.id.ButtonNext);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                startActivity(intent);
            }
        });
    }}










