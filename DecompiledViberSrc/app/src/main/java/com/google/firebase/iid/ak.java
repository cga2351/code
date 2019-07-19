package com.google.firebase.iid;

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

public final class ak
  implements ServiceConnection
{
  private final Context a;
  private final Intent b;
  private final ScheduledExecutorService c;
  private final Queue<ag> d = new ArrayDeque();
  private ai e;
  private boolean f = false;

  public ak(Context paramContext, String paramString)
  {
    this(paramContext, paramString, new ScheduledThreadPoolExecutor(0, new NamedThreadFactory("Firebase-FirebaseInstanceIdServiceConnection")));
  }

  private ak(Context paramContext, String paramString, ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = paramContext.getApplicationContext();
    this.b = new Intent(paramString).setPackage(this.a.getPackageName());
    this.c = paramScheduledExecutorService;
  }

  private final void a()
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "flush queue called");
      while (true)
      {
        if (this.d.isEmpty())
          break label196;
        if (Log.isLoggable("EnhancedIntentService", 3))
          Log.d("EnhancedIntentService", "found intent to be delivered");
        if ((this.e == null) || (!this.e.isBinderAlive()))
          break;
        if (Log.isLoggable("EnhancedIntentService", 3))
          Log.d("EnhancedIntentService", "binder is alive, sending the intent.");
        ag localag = (ag)this.d.poll();
        this.e.a(localag);
      }
    }
    finally
    {
    }
    boolean bool2;
    if (Log.isLoggable("EnhancedIntentService", 3))
    {
      if (this.f)
        break label199;
      bool2 = true;
    }
    while (true)
    {
      Log.d("EnhancedIntentService", 39 + "binder is dead. start connection? " + bool2);
      if (!this.f)
        this.f = true;
      try
      {
        boolean bool1 = ConnectionTracker.getInstance().bindService(this.a, this.b, this, 65);
        if (bool1);
        while (true)
        {
          label196: return;
          label199: bool2 = false;
          break;
          Log.e("EnhancedIntentService", "binding to the service failed");
          this.f = false;
          b();
        }
      }
      catch (SecurityException localSecurityException)
      {
        while (true)
          Log.e("EnhancedIntentService", "Exception while binding the service", localSecurityException);
      }
    }
  }

  private final void b()
  {
    while (!this.d.isEmpty())
      ((ag)this.d.poll()).a();
  }

  public final void a(Intent paramIntent, BroadcastReceiver.PendingResult paramPendingResult)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "new intent queued in the bind-strategy delivery");
      this.d.add(new ag(paramIntent, paramPendingResult, this.c));
      a();
      return;
    }
    finally
    {
    }
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
      {
        String str2 = String.valueOf(paramComponentName);
        Log.d("EnhancedIntentService", 20 + String.valueOf(str2).length() + "onServiceConnected: " + str2);
      }
      this.f = false;
      if (!(paramIBinder instanceof ai))
      {
        String str1 = String.valueOf(paramIBinder);
        Log.e("EnhancedIntentService", 28 + String.valueOf(str1).length() + "Invalid service connection: " + str1);
        b();
      }
      while (true)
      {
        return;
        this.e = ((ai)paramIBinder);
        a();
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
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.ak
 * JD-Core Version:    0.6.2
 */