package com.google.firebase.messaging;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.KeyguardManager;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Process;
import android.os.SystemClock;
import android.support.v4.app.NotificationCompat.BigPictureStyle;
import android.support.v4.app.NotificationCompat.Builder;
import android.util.Log;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.tasks.Tasks;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

final class e
{
  private final Executor a;
  private final Context b;
  private final d c;
  private final Bundle d;

  public e(Context paramContext, Bundle paramBundle, Executor paramExecutor)
  {
    this.a = paramExecutor;
    this.b = paramContext;
    this.d = paramBundle;
    this.c = new d(paramContext, paramContext.getPackageName());
  }

  final boolean a()
  {
    if ("1".equals(d.a(this.d, "gcm.n.noui")))
      return true;
    int i;
    if (!((KeyguardManager)this.b.getSystemService("keyguard")).inKeyguardRestrictedInputMode())
    {
      if (!PlatformVersion.isAtLeastLollipop())
        SystemClock.sleep(10L);
      int j = Process.myPid();
      List localList = ((ActivityManager)this.b.getSystemService("activity")).getRunningAppProcesses();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (true)
          if (localIterator.hasNext())
          {
            ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = (ActivityManager.RunningAppProcessInfo)localIterator.next();
            if (localRunningAppProcessInfo.pid == j)
              if (localRunningAppProcessInfo.importance == 100)
                i = 1;
          }
      }
    }
    while (i != 0)
    {
      return false;
      i = 0;
      continue;
      i = 0;
    }
    h localh = h.a(d.a(this.d, "gcm.n.image"));
    if (localh != null)
      localh.a(this.a);
    f localf = this.c.a(this.d);
    NotificationCompat.Builder localBuilder = localf.a;
    if (localh != null);
    try
    {
      Bitmap localBitmap = (Bitmap)Tasks.await(localh.a(), 5L, TimeUnit.SECONDS);
      localBuilder.setLargeIcon(localBitmap);
      localBuilder.setStyle(new NotificationCompat.BigPictureStyle().bigPicture(localBitmap).bigLargeIcon(null));
      label240: if (Log.isLoggable("FirebaseMessaging", 3))
        Log.d("FirebaseMessaging", "Showing notification");
      ((NotificationManager)this.b.getSystemService("notification")).notify(localf.b, 0, localf.a.build());
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      while (true)
      {
        Log.w("FirebaseMessaging", "Interrupted while downloading image, showing notification without it");
        localh.close();
        Thread.currentThread().interrupt();
      }
    }
    catch (TimeoutException localTimeoutException)
    {
      while (true)
      {
        Log.w("FirebaseMessaging", "Failed to download image in time, showing notification without it");
        localh.close();
      }
    }
    catch (ExecutionException localExecutionException)
    {
      break label240;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.messaging.e
 * JD-Core Version:    0.6.2
 */