package tomerbu.edu.servicesandreceiversdemos;

import android.app.IntentService;
import android.app.Notification;
import android.app.NotificationManager;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

//Runs on a background thread
public class DemoIntentService extends IntentService {

    private static final int NOTE_ID = 0;

    public DemoIntentService() {
        super("DemoIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        sendNotification();
        //once finished - will auto close the service.
        try {
            URL url = new URL("https://www.reddit.com/.json");
            URLConnection con = url.openConnection();
            InputStream in = con.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            String line = null;
            StringBuilder builder = new StringBuilder();

            while ((line = reader.readLine())!=null){
                builder.append(line);
            }

          sendNotification();

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void sendNotification() {
        //Notification.Builder
        //NotificationManager (System Service)


        NotificationCompat.Builder builder = new NotificationCompat.
                Builder(this);

        builder.setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("Hello")
                .setContentText("This is the message Content text");

        Notification notification = builder.build();

        NotificationManager notificationManager = (NotificationManager)
                getSystemService(NOTIFICATION_SERVICE);


        notificationManager.notify(NOTE_ID, notification);
    }
}