package com.arenaplan.pdv.get.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.arenaplan.pdv.get.ArenaplanPdvApplication;
import com.arenaplan.pdv.get.R;
import com.arenaplan.pdv.get.login.LoginActivity;
import com.arenaplan.pdv.get.setup.ui.SetUpActivity;

public class SplashActivity extends AppCompatActivity {


    ArenaplanPdvApplication mApplication;
    private static int SPLASH_TIME_OUT = 3000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mApplication =   (ArenaplanPdvApplication)getApplicationContext();
        verificaSetUp();

    }

    private void verificaSetUp() {

        if( mApplication.getSetUp() != null
                && mApplication.getSetUp().getT_login() != null
                &&  mApplication.getSetUp().getT_login().length() > 0) {
            setContentView(R.layout.activity_splash);

            Handler handle = new Handler();
            handle.postDelayed(new Runnable() {
                @Override public void run() {
                    abriTelaLogin();
                }
            }, 2000);


            //abriTelaLogin();
        } else {
            setContentView(R.layout.activity_splash);
            Handler handle = new Handler();
            handle.postDelayed(new Runnable() {
                @Override public void run() {
                    abriTelaSetUp();
                }
            }, 2000);

            //abriTelaSetUp();
        }
    }

    private void abriTelaSetUp() {

        Intent intent = new Intent(this, SetUpActivity.class);
        startActivity(intent);
        finish();
    }

    private void abriTelaLogin() {

        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
