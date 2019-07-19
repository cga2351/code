package com.google.firebase.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.content.WakefulBroadcastReceiver;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.firebase_messaging.zza;
import com.google.android.gms.internal.firebase_messaging.zzb;
import com.google.android.gms.internal.firebase_messaging.zzf;
import java.util.concurrent.ExecutorService;

public abstract class zzc extends Service
{
  final ExecutorService a;
  private Binder b;
  private final Object c;
  private int d;
  private int e;

  public zzc()
  {
    zzb localzzb = zza.zza();
    String str1 = String.valueOf(getClass().getSimpleName());
    if (str1.length() != 0);
    for (String str2 = "Firebase-".concat(str1); ; str2 = new String("Firebase-"))
    {
      this.a = localzzb.zza(new NamedThreadFactory(str2), zzf.zze);
      this.c = new Object();
      this.e = 0;
      return;
    }
  }

  private final void d(Intent paramIntent)
  {
    if (paramIntent != null)
      WakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
    synchronized (this.c)
    {
      this.e = (-1 + this.e);
      if (this.e == 0)
        stopSelfResult(this.d);
      return;
    }
  }

  protected Intent a(Intent paramIntent)
  {
    return paramIntent;
  }

  public abstract void b(Intent paramIntent);

  public boolean c(Intent paramIntent)
  {
    return false;
  }

  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "Service received bind request");
      if (this.b == null)
        this.b = new ai(this);
      Binder localBinder = this.b;
      return localBinder;
    }
    finally
    {
    }
  }

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    Intent localIntent;
    synchronized (this.c)
    {
      this.d = paramInt2;
      this.e = (1 + this.e);
      localIntent = a(paramIntent);
      if (localIntent == null)
      {
        d(paramIntent);
        return 2;
      }
    }
    if (c(localIntent))
    {
      d(paramIntent);
      return 2;
    }
    this.a.execute(new ad(this, localIntent, paramIntent));
    return 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.firebase.iid.zzc
 * JD-Core Version:    0.6.2
 */