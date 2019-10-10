package com.example.mac.homelesscash;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.util.Log;

public class AutoStart extends BroadcastReceiver {

    /* On boot phone will launch single instance of backgroundScanner if
    Bluetooth is turned on, otherwise will turn on from bluetooth being turned on */
    @Override
    public void onReceive(Context context, Intent i) {
        Intent intent = new Intent(context, backgroundScanner.class);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
        Log.d("AUTOSTART", "LAUNCHED!");
    }
}
