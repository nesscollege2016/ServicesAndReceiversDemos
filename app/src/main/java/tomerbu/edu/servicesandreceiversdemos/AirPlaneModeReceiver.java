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
    }
}
