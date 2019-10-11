package com.example.mac.homelesscash;

import android.Manifest;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.app.TaskStackBuilder;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.service.notification.StatusBarNotification;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;

import org.altbeacon.beacon.Beacon;
import org.altbeacon.beacon.BeaconConsumer;
import org.altbeacon.beacon.BeaconManager;
import org.altbeacon.beacon.BeaconParser;
import org.altbeacon.beacon.RangeNotifier;
import org.altbeacon.beacon.Region;
import org.altbeacon.beacon.startup.BootstrapNotifier;
import org.altbeacon.beacon.startup.RegionBootstrap;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Random;

public class backgroundScanner extends Service implements BeaconConsumer {

    private static final String TAG = "BEACON_PROJECT";
    public int serviceNotificationID = 9999;
    private BeaconManager beaconManager;
    //private Service service;

    /* Called once when intent links to backgroundScanner, initialises notification and beaconManager
    to start searching for iBeacon's with below beaconLayout */
    @Override
    public void onCreate() {
        super.onCreate();

        this.beaconManager = BeaconManager.getInstanceForApplication(this);
        this.beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));

        this.beaconManager.bind(this);

        Notification.Builder newBuilder = new Notification.Builder(this);
        newBuilder.setSmallIcon(R.drawable.black_scanner2);
        newBuilder.setContentTitle("Scanning for Beacons");
        newBuilder.setContentText("Homeless cash project is on the lookout");
        Intent always_on_intent = new Intent(this, HomePage.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, always_on_intent, PendingIntent.FLAG_UPDATE_CURRENT);

        newBuilder.setContentIntent(pendingIntent);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            Log.d("notification_channel", "was created");
            NotificationChannel channel = new NotificationChannel("BackgroundScanner", "Setup for foreground service", NotificationManager.IMPORTANCE_DEFAULT);
            channel.setDescription("Foreground service launched when accessing login class");
            NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(channel);
            newBuilder.setChannelId(channel.getId());
            newBuilder.setAutoCancel(true);
            //notificationManager.notify(456, newBuilder.build());
        }


        /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            service.startForegroundService(intent);
        } else {
            service.startService(intent);
        } */

        startForeground(serviceNotificationID, newBuilder.build());

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        return START_STICKY;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onBeaconServiceConnect() {
        RangeNotifier rangeNotifier = new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    Log.d("Beacon_Range", "didRangeBeaconsInRegion called with beacon count:  " + beacons.size());
                    Beacon beacon = beacons.iterator().next();
                    notifyUser(beacon.getId1().toString());
                }
            }
        };

        try {
            beaconManager.startRangingBeaconsInRegion(new Region("MyRangeID", null, null, null));
            beaconManager.addRangeNotifier(rangeNotifier);
//            beaconManager.startRangingBeaconsInRegion(new Region("MyRangeID", null, null, null));
//            beaconManager.addRangeNotifier(rangeNotifier);


        } catch (RemoteException e) {
            Log.d(TAG, e.toString());
        }


    }




    private void notifyUser(String s) {

        int exists = 0;
        int notificationID = 1000;
        String homelesscashUUID = "e2c56db5";
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        Log.d("ID", s);
        //if (s.substring(0,8).equals(homelesscashUUID)) {
            if (Build.VERSION.SDK_INT >= 23) {
                try {
                    StatusBarNotification[] notifications = notificationManager.getActiveNotifications();
                    for (StatusBarNotification notification : notifications) {
                        if (notification.getId() == notificationID) {
                            exists = 1;
                        }
                    }
                    if (exists == 0) {
                        //Log.d("ENTERED", "no current notification");

                        Notification.Builder newBuilder = new Notification.Builder(this);
                        newBuilder.setSmallIcon(R.drawable.black_scanner2);
                        newBuilder.setContentTitle("Signal Found");
                        newBuilder.setContentText("There are possibly homeless nearby! Click here to donate now!");
                        Intent always_on_intent = new Intent(this, ibeacon_scan.class);
                        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, always_on_intent, PendingIntent.FLAG_UPDATE_CURRENT);

                        newBuilder.setContentIntent(pendingIntent);
                        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                            //Log.d("notification_channel", "was created");
                            NotificationChannel channel = new NotificationChannel("BackgroundScannerNotify", "notifyUser", NotificationManager.IMPORTANCE_DEFAULT);
                            channel.setDescription("Posted when beacon detected");
                            notificationManager.createNotificationChannel(channel);
                            newBuilder.setChannelId(channel.getId());
                            notificationManager.notify(notificationID, newBuilder.build());

                        }


                    }

                } catch (Throwable e) {
                    Log.w(TAG, e);
                }

            }
        }

    //}

    @Override
    public void onDestroy() {
        super.onDestroy();
        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= 23) {
            try {
                StatusBarNotification[] notifications = notificationManager.getActiveNotifications();
                for (StatusBarNotification notification : notifications) {
                    if (notification.getId() == serviceNotificationID) {
                        stopForeground(true);
                    } else {
                        //do nothing since no foreground service exists... (technically redundant)
                    }
                }
            } catch (Throwable e) {
                Log.d("ERROR:", "Unable to determine notification existence in OnDestroy() for backGroundScanner");
            }
        }
    }
}