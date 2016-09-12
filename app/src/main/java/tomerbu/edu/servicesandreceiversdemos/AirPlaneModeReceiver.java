package tomerbu.edu.servicesandreceiversdemos;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AirPlaneModeReceiver extends BroadcastReceiver {
    public AirPlaneModeReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent reddit = new Intent(context, DemoIntentService.class);
        context.startService(reddit);





 /*
     Bundle extras = intent.getExtras();
     for (String key : extras.keySet()) {
            Log.e("Ness", key);
            Log.e("Ness", extras.get(key).toString()*//*Value*//*);
        }*/

        //Utils.showFab = !intent.getBooleanExtra("state", false);

        if (intent.getBooleanExtra("state", false)){
            Utils.showFab = false;
        }
        else {
            Utils.showFab = true;
        }

    }
}
