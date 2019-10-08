package com.example.mac.homelesscash;


import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.icu.text.IDNA;
import android.os.Build;
import android.os.RemoteException;
//import android.support.v7.app.AlertDialog;
import androidx.appcompat.app.AlertDialog;
//import android.support.v7.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.altbeacon.beacon.*;
import java.util.*;
import java.lang.Math;

public class ibeacon_scan extends AppCompatActivity implements BeaconConsumer {
    private static final String TAG = "BEACON_PROJECT";
    private ArrayList<String> beaconList;
    private ListView beaconListView;
    private ArrayAdapter<String> adapter;
    private BeaconManager beaconManager;
    private FirebaseDatabase firebaseDatabase;      // database object
    private DatabaseReference databaseReference;    // reference object
    private ValueEventListener valueEventListener;
    public static Donor donor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ibeacon_scan);
        this.beaconList = new ArrayList<String>();
        this.beaconListView = (ListView) findViewById(R.id.listView);
        this.adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, this.beaconList);
        this.beaconListView.setAdapter(adapter);
        this.beaconManager = BeaconManager.getInstanceForApplication(this);
        this.beaconManager.getBeaconParsers().add(new BeaconParser().setBeaconLayout("m:2-3=0215,i:4-19,i:20-21,i:22-23,p:24-24"));
        //set up a parser that will look for Bluetooth packets
        // that match the layout. Not all Bluetooth devices are iBeacons, so specifying to only scan for hardware that meets the specification.
        this.beaconManager.bind(this);


        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (this.checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {  //Grant location access
                final AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("We need location access");
                builder.setMessage("Please click allow to grant location services");
                builder.setOnDismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        requestPermissions(new String[]{Manifest.permission.ACCESS_COARSE_LOCATION}, 1);
                    }
                });
                builder.show();
            }
        }
        beaconListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Object itemString = beaconListView.getItemAtPosition(i);
                Intent openDonationPage = new Intent(ibeacon_scan.this, Donate.class);
                openDonationPage.putExtra("what?", (String) itemString);
                startActivity(openDonationPage);
            }
        });
    }


    // read from Firebase
        /*valueEventListener = new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                donor = dataSnapshot.getValue(Donor.class);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            }
        };
        //databaseReference.addValueEventListener(valueEventListener);*/


    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.beaconManager.unbind(this);
    }

    // this is only temporate for demo
    private ArrayList<String> homelessNames = new ArrayList<>(Arrays.asList("Jack London",
            "Harry Potter", "Jon Snow", "Will Sim", "David Bakeham", "Jay Chou",
            "Rainee Young", "Edd Stark", "Angela Chang", "November Rain", "Ron Wesley",
            "Alan Walker", "Lily Potter"));
    private Random rand = new Random();

    @Override
    //define a listener for beacons that are in range and define which beacons to listen for.
    public void onBeaconServiceConnect() {
        this.beaconManager.setRangeNotifier(new RangeNotifier() {
            @Override
            public void didRangeBeaconsInRegion(Collection<Beacon> beacons, Region region) {
                if (beacons.size() > 0) {
                    beaconList.clear();
                    for (Iterator<Beacon> iterator = beacons.iterator(); iterator.hasNext();) {
                        Beacon beacon = iterator.next();

                        if (!beaconList.contains(beacon.getId1().toString())) {
                            double distance_num = Math.floor(beacon.getDistance()*100)/100;
                            String distance = Double.toString(distance_num);
                            rand.setSeed(beacon.hashCode());
                            String name = homelessNames.get(rand.nextInt(homelessNames.size()));
                            String uuid = beacon.getId1().toString();
//                            String major = beacon.getId2().toString();
//                            String minor = beacon.getId3().toString();
                            String toDisplay = name + "  ---- Distance: " + distance + "m  "; // FIXME: distance not very accurate
                            beaconList.add(toDisplay);
                        }
                    }
                    runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            adapter.notifyDataSetChanged();
                        }
                    });
                }
            }
        });
        try {
            this.beaconManager.startRangingBeaconsInRegion(new Region("MyRegionId", null, null, null));
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

}