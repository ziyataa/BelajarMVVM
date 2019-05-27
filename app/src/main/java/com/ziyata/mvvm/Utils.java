package com.ziyata.mvvm;

import android.app.AlertDialog;
import android.content.Context;

import com.ziyata.mvvm.network.ApiClient;
import com.ziyata.mvvm.network.ApiInterfaces;

public class Utils {

    private static AlertDialog alertDialog;

    public static ApiInterfaces geClient() {
        return ApiClient.create().create(ApiInterfaces.class);
    }

    public static AlertDialog getAlertDialog(String title, String message, Context context) {
        if (alertDialog == null) {
            alertDialog = new AlertDialog.Builder(context)
                    .setTitle(title)
                    .setMessage(message)
                    .show();
            }

        return alertDialog;
    }

    public static void cancelAlert() {
        if (alertDialog.isShowing()) {
            alertDialog.cancel();
        }
    }
}
