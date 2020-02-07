package com.example.sessionandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LandingPAge extends AppCompatActivity {

    TextView result;
    Button logout;
    Session session;
    private static   final String TAG = "LandingPage";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_landing_page);

        result = findViewById(R.id.textView);
        logout  =findViewById(R.id.button2);
        session = new Session(LandingPAge.this);
        result.setText(session.toString());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                session.logout();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
         if(!session.isLoggin()){
             startActivity(new Intent(LandingPAge.this, MainActivity.class));
         }
        Log.v(TAG, "onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();
        if(!session.isLoggin()) {
            startActivity(new Intent(LandingPAge.this, MainActivity.class));
        }
        Log.d(TAG,"onResume invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.d(TAG,"onPause invoked");
    }
    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG,"onStop invoked");
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v(TAG, "onDestroy");
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent startMain = new Intent(Intent.ACTION_MAIN);
        startMain.addCategory(Intent.CATEGORY_HOME);
        startMain.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(startMain);
    }
}
