package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import com.google.android.gms.internal.gcm.zzg;
import com.google.android.gms.stats.GCoreWakefulBroadcastReceiver;
import java.util.concurrent.ExecutorService;

public abstract class zze extends Service
{
  private final Object lock = new Object();
  final ExecutorService zzbb = zzg.zzaa().zzd(new NamedThreadFactory("EnhancedIntentService"), 9);
  private Binder zzbc;
  private int zzbd;
  private int zzbe = 0;

  private final void zzf(Intent paramIntent)
  {
    if (paramIntent != null)
      GCoreWakefulBroadcastReceiver.completeWakefulIntent(paramIntent);
    synchronized (this.lock)
    {
      this.zzbe = (-1 + this.zzbe);
      if (this.zzbe == 0)
        stopSelfResult(this.zzbd);
      return;
    }
  }

  public abstract void handleIntent(Intent paramIntent);

  public final IBinder onBind(Intent paramIntent)
  {
    try
    {
      if (Log.isLoggable("EnhancedIntentService", 3))
        Log.d("EnhancedIntentService", "Service received bind request");
      if (this.zzbc == null)
        this.zzbc = new zzi(this);
      Binder localBinder = this.zzbc;
      return localBinder;
    }
    finally
    {
    }
  }

  public final int onStartCommand(Intent paramIntent, int paramInt1, int paramInt2)
  {
    synchronized (this.lock)
    {
      this.zzbd = paramInt2;
      this.zzbe = (1 + this.zzbe);
      if (paramIntent == null)
      {
        zzf(paramIntent);
        return 2;
      }
    }
    this.zzbb.execute(new zzf(this, paramIntent, paramIntent));
    return 3;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.iid.zze
 * JD-Core Version:    0.6.2
 */