package com.arenaplan.pdv.get.util;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.getnet.posdigital.PosDigital;

public abstract class BaseActivity extends AppCompatActivity{


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        connectPosDigitalService();
    }

    private PosDigital.BindCallback bindCallback = new PosDigital.BindCallback() {
        @Override
        public void onError(Exception e) {
            if(PosDigital.getInstance().isInitiated()){
                PosDigital.unregister(BaseActivity.this.getApplicationContext());
                connectPosDigitalService();
            }
        }

        @Override
        public void onConnected() {
            Log.i("Connection", "onConnected");
        }

        @Override
        public void onDisconnected() {

        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        connectPosDigitalService();
    }

    protected void  connectPosDigitalService() {
        PosDigital.register(BaseActivity.this.getApplicationContext(), bindCallback);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            if (PosDigital.getInstance().isInitiated()) {
                PosDigital.unregister(BaseActivity.this.getApplicationContext());
            }
        } catch (Exception e) {
            Log.e("Connection", "Erro de exception no Destroy da Activity");
        }
    }

    protected void AbreTelaParcelamento(Bundle savedInstanceState) {

    }
}
