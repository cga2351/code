package cga2351.example.com.testpurejava;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.os.PowerManager;
import android.support.v4.app.NotificationCompat;
import android.text.TextUtils;
import android.util.Log;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Timer;
import java.util.TimerTask;

public class TestService extends Service {
    public TestService() {
    }
    int count = 0;
    private PowerManager.WakeLock wakeLock = null;
    ServiceBinder binder = null;

    @Override
    public void onCreate() {
        super.onCreate();

        PowerManager pm = (PowerManager)getSystemService(Context.POWER_SERVICE);
        wakeLock = pm.newWakeLock(PowerManager.SCREEN_DIM_WAKE_LOCK, "testPureJava");
        wakeLock.acquire();
        binder = new ServiceBinder();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        Intent notificationIntent = new Intent(this, MainActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, notificationIntent, 0);

        Notification notification = new NotificationCompat.Builder(this)
                .setContentTitle("TestPureJava")
                .setContentText("TestPureJava")
                .setTicker("TestPureJava")
                .setContentIntent(pendingIntent)
                .setSmallIcon(R.mipmap.ic_launcher_round)
                .build();
        startForeground(1, notification);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d("-mqmsdebug", "test pure java print log");
//                Intent startIntent;
//                switch (count) {
//                    case 0:
//                        startIntent = getPackageManager().getLaunchIntentForPackage("com.nhn.android.search");
//                        startActivity(startIntent);
//                        break;
//                    case 1:
//                        commandRun(true, "ps|grep nhn|awk '{print$2}'|xargs kill -9 $1");
//                        break;
//                    case 2:
//                        startIntent = getPackageManager().getLaunchIntentForPackage("com.android.gallery3d");
//                        startActivity(startIntent);
//                        break;
//                    case 3:
//                        commandRun(true, "ps|grep gallery3d|awk '{print$2}'|xargs kill -9 $1");
//                        break;
//                    case 4:
//                        startIntent = getPackageManager().getLaunchIntentForPackage("com.google.android.youtube");
//                        startActivity(startIntent);
//                        break;
//                    case 5:
//                        commandRun(true, "ps|grep youtube|awk '{print$2}'|xargs kill -9 $1");
//                        break;
//                }
//
//                count++;
//                count %= 6;
            }
        }, 5000, 10000);

        return binder;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        stopForeground(true);
        wakeLock.release();
    }

    public class ServiceBinder extends Binder {

    }

    private static String commandRun(boolean needRoot, String cmd) {
//        return commandRun(cmd, true);

        String tmp = "";
        String error = "";
        String result = "";

        try {
            Process proc = Runtime.getRuntime().exec("su");
            DataOutputStream dos = new DataOutputStream(proc.getOutputStream());
            BufferedReader inputBufferedReader = new BufferedReader(new InputStreamReader(proc.getInputStream(), "UTF-8"));
            BufferedReader errorBufferedReader = new BufferedReader(new InputStreamReader(proc.getErrorStream(), "UTF-8"));

//            dos.writeBytes(Constant.LD_LIBRARY_PATH);
            dos.writeBytes(cmd);
            dos.flush();
            dos.close();

            try {
                try {
                    proc.getOutputStream().close();
                } catch (IOException e) {
                }

                proc.waitFor();
            } catch (InterruptedException e) {
                proc.destroy();
            }

            tmp = errorBufferedReader.readLine();
            while (!TextUtils.isEmpty(tmp)) {
                error += tmp + "\n";
                tmp = errorBufferedReader.readLine();
            }
            Log.d("-mqmsdebug", "cmd:" + cmd + ", error=" + error);

            tmp = inputBufferedReader.readLine();
            while (!TextUtils.isEmpty(tmp)) {
                result += tmp + "\n";
                tmp = inputBufferedReader.readLine();
            }
            Log.d("-mqmsdebug", "cmd:" + cmd + ", result=" + result);

            inputBufferedReader.close();
            errorBufferedReader.close();
            proc.getInputStream().close();
            proc.getErrorStream().close();
        } catch (Exception e) {
            e.printStackTrace();
            Log.d("-mqmsdebug"," # commandRun(IOException): " + e.getMessage());
        }

        return result;
    }
}
