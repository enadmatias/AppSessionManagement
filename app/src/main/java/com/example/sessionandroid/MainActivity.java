package com.example.sessionandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import static android.webkit.ConsoleMessage.MessageLevel.LOG;

public class MainActivity extends AppCompatActivity {
    EditText username , password;
    Button  btn_login;
    Intent intent;
    Session session;
    private static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        username = findViewById(R.id.editText);
        password = findViewById(R.id.editText2);
        session = new Session(MainActivity.this);
        intent = new Intent(MainActivity.this, LandingPAge.class);

        btn_login = findViewById(R.id.button);

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String uname = username.getText().toString();
                String pwd = password.getText().toString();
                if(uname.equals("suresh") && pwd.equals("dasari")){
                  session.createSession(uname, pwd);
                  if(session.isLoggin()){
                     onStart();
                     MainActivity.this.finish();
                  }

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Credentials are not valid",Toast.LENGTH_SHORT).show();
                }
            }

        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(session.isLoggin())
        {
            startActivity(new Intent(MainActivity.this, LandingPAge.class));
        }

        Log.v(TAG, "onstart");
    }
    @Override
    protected void onResume() {
        super.onResume();

        Log.d(TAG,"onResume invoked");
    }

    @Override
    protected void onStop() {
        super.onStop();


        Log.d(TAG,"onStop invoked");
    }

    @Override
    protected void onPause() {
        super.onPause();
        if(session.isLoggin())
        { startActivity(new Intent(MainActivity.this, LandingPAge.class));
        }
        Log.d(TAG,"onPause invoked");
    }

    @Override
    protected void onRestart() {
        super.onRestart();

        Log.d(TAG,"onRestart invoked");
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
