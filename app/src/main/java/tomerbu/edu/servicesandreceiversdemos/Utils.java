package tomerbu.edu.servicesandreceiversdemos;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by dev on 9/12/2016.
 */
public class Utils {

    public static boolean hasInternet(Context context){
    /*
        LayoutInflater inflater = (LayoutInflater)
                context.
                        getSystemService(Context.
                                LAYOUT_INFLATER_SERVICE);

        */
        ConnectivityManager cm = (ConnectivityManager)
                context.
                        getSystemService(Context.
                                CONNECTIVITY_SERVICE);

        NetworkInfo info = cm.getActiveNetworkInfo();

        return info != null && info.isConnected();
    }

    public static boolean hasWIFI(Context context){

        ConnectivityManager cm = (ConnectivityManager)
                context.
                        getSystemService(Context.
                                CONNECTIVITY_SERVICE);

        NetworkInfo info = cm.getActiveNetworkInfo();

        return info != null&&
                info.isConnected() &&
                info.getType() == ConnectivityManager.TYPE_WIFI;
    }

    public static boolean showFab = true;
}
