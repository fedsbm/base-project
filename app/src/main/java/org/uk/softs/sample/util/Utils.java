package org.uk.softs.sample.util;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Base64;

import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;

/**
 * Utility static methods, that are app wide.
 */

public class Utils {

    public static String getBase64String(String value) {
        try {
            return Base64.encodeToString(value.getBytes("UTF-8"), Base64.NO_WRAP);
        } catch (UnsupportedEncodingException e) {
            return "";
        }
    }

    public static String decodeBase64(String base64) {

        String text = "";

        byte[] data = Base64.decode(base64, Base64.DEFAULT);
        try {
            text = new String(data, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return text;
    }

    public static String encode2Base64(String password) {
        String base64String;
        try {
            byte[] data = password.getBytes("UTF-8");
            base64String = Base64.encodeToString(data, Base64.DEFAULT);
        } catch (UnsupportedEncodingException ex) {
            throw new RuntimeException(ex);
        }
        return base64String.replace("\n", "");
    }

    public static String getReadableDayPostfix(int day) {
        switch (day) {
            case 1:
            case 21:
            case 31:
                return "st";
            case 2:
            case 22:
                return "nd";
            case 3:
            case 23:
                return "rd";
            default:
                return "th";
        }
    }

    public static boolean isNetworkConnectionAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        if (networkInfo == null) {
            return false;
        }
        return networkInfo.isConnectedOrConnecting();
    }

    private static boolean isResponseServerError(int httpResponseStatus) {
        boolean serverError = false;

        if (httpResponseStatus == HttpURLConnection.HTTP_INTERNAL_ERROR ||
                httpResponseStatus == HttpURLConnection.HTTP_NOT_IMPLEMENTED ||
                httpResponseStatus == HttpURLConnection.HTTP_BAD_GATEWAY ||
                httpResponseStatus == HttpURLConnection.HTTP_GATEWAY_TIMEOUT) {
            serverError = true;
        }
        return serverError;
    }

    public static boolean isAllTrue(boolean[] array) {
        for (boolean b : array) {
            if (!b) {
                return false;
            }
        }
        return true;
    }


//    /**
//     * Returns the last known location based on the available data.
//     *
//     * @return the last known location or NULL.
//     */
//    public static Location getLastKnownLocation(Context ctx) {
//
//        LocationManager locationManager = (LocationManager) ctx.getSystemService(Context.LOCATION_SERVICE);
//
//        if (locationManager != null) {
//            if (ActivityCompat.checkSelfPermission(ctx, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
//                return null;
//            }
//
//            //Attempt to retrieve the last known location.
//            if (locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER)) {
//                return locationManager.getLastKnownLocation(LocationManager.NETWORK_PROVIDER);
//            } else if (locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)) {
//                return locationManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
//            } else {
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }


}
