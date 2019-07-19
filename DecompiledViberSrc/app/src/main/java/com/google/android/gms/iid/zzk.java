package com.google.android.gms.iid;

import android.content.BroadcastReceiver.PendingResult;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;

public final class zzk
  implements ServiceConnection
{
  private final Intent zzbp;
  private final ScheduledExecutorService zzbq;
  private final Queue<zzg> zzbr = new ArrayDeque();
  private zzi zzbs;
  private boolean zzbt = false;
  private final Context zzl;

  public zzk(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("EnhancedIntentService")));
  }

  private zzk(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.zzl = paramContext.getApplicationContext();
    this.zzbp = new Intent(paramString).setPackage(this.zzl.getPackageName());
    this.zzbq = paramScheduledExecutorService;
  }

  private final void zzm()
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "flush queue called");
      while (true)
      {
        if (this.zzbr.isEmpty())
          break label196;
        if (Log.isLoggable("EnhancedIntentService", 3))
          Log.d("EnhancedIntentService", "found intent to be delivered");
        if ((this.zzbs == null) || (!this.zzbs.isBinderAlive()))
          break;
        if (Log.isLoggable("EnhancedIntentService", 3))
          Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
        zzg localzzg = (zzg)this.zzbr.poll();
        this.zzbs.zzd(localzzg);
      }
    }
    finally
    {
    }
    boolean bool2;
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      if (this.zzbt)
        break label199;
      bool2 = true;
    }
    while (true)
    {
      Log.d("EnhancedIntentService", 39 + "binder is dead. start connection? " + bool2);
      if (!this.zzbt)
        this.zzbt = true;
      try
      {
        boolean bool1 = ConnectionTracker.getInstance().bindService(this.zzl, this.zzbp, this, 65);
        if (bool1);
        while (true)
        {
          label196: return;
          label199: bool2 = false;
          break;
          Log.e("EnhancedIntentService", "binding to the service failed");
          this.zzbt = false;
          zzn();
        }
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
          Log.e("EnhancedIntentService", "Exception while binding the service", localSecurityException);
      }
    }
  }

  private final void zzn()
  {
    while (!this.zzbr.isEmpty())
      ((zzg)this.zzbr.poll()).finish();
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      this.zzbt = false;
      this.zzbs = ((zzi)paramIBinder);
      if (Log.isLoggable("EnhancedIntentService", 3))
      {
        String str = String.valueOf(paramComponentName);
        Log.d("EnhancedIntentService", 20 + String.valueOf(str).length() + "onServiceConnected: " + str);
      }
      if (paramIBinder == null)
      {
        Log.e("EnhancedIntentService", "Null service connection");
        zzn();
      }
      while (true)
      {
        return;
        zzm();
      }
    }
    finally
    {
    }
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      String str = String.valueOf(paramComponentName);
      Log.d("EnhancedIntentService", 23 + String.valueOf(str).length() + "onServiceDisconnected: " + str);
    }
    zzm();
  }

  public final void zzd(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
      this.zzbr.add(new zzg(paramIntent, paramPendingResult, this.zzbq));
      zzm();
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zzk
 * JD-Core Version:    0.6.2
 */