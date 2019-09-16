package com.example.mac.homelesscash;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;

public class Preferences {

    public static final String SharedPreferencesTag = "Homeless_Preferences";
    public static final int SharedPreferences_ModeTag = Context.MODE_PRIVATE;

    public static ProgressDialog loading;
    public static boolean isShownLoading = false;

    public static Activity activity;


    public static void showLoading(final Activity activity, final String title, final String message) {
        try {
            if (!isShownLoading) {
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        loading = ProgressDialog.show(activity, title, message, false, false);
                        isShownLoading = true;
                    }
                });

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void dismissLoading() {
        try {
            if (isShownLoading) {

                loading.dismiss();
                isShownLoading = false;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void setActivity(Activity act) {
        activity = act;
    }

    public static Activity getActivity() {
        return activity;
    }

}
