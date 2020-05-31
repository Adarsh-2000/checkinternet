package com.example.checkinternet;

import android.app.Dialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        //internet
        if (isConnectingToInternet( MainActivity.this )) {

        } else {
            final Dialog dialog = new Dialog( MainActivity.this, android.R.style.Theme_Black_NoTitleBar_Fullscreen );
            dialog.setContentView( R.layout.custom_dailog_checkintetnet );
            dialog.show();

            // Internet connecton enable through WIFI
            Button btn_enableConnection = dialog.findViewById( R.id.btn_coonection_enable );
            btn_enableConnection.setOnClickListener( new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    WifiManager wifiManager = (WifiManager) getApplicationContext().getSystemService( Context.WIFI_SERVICE );
                    wifiManager.setWifiEnabled( true );
                    dialog.dismiss();
                }
            } );
        }
    }

    private boolean isConnectingToInternet(MainActivity mainActivity) {
        ConnectivityManager cm = (ConnectivityManager) getSystemService( Context.CONNECTIVITY_SERVICE );
        NetworkInfo netInfo = cm.getActiveNetworkInfo();
        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            return true;
        } else {
            return false;
        }
    }
}


