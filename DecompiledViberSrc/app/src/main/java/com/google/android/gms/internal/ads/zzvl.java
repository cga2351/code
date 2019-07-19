package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Binder;
import android.os.Handler;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks;
import com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzare
public final class zzvl
{
  private final Object lock = new Object();
  private final Runnable zzbwo = new zzvm(this);

  @GuardedBy("lock")
  private zzvs zzbwp;

  @GuardedBy("lock")
  private zzvw zzbwq;

  @GuardedBy("lock")
  private Context zzlj;

  private final void connect()
  {
    synchronized (this.lock)
    {
      if ((this.zzlj == null) || (this.zzbwp != null))
        return;
      this.zzbwp = zza(new zzvo(this), new zzvp(this));
      this.zzbwp.checkAvailabilityAndConnect();
      return;
    }
  }

  private final void disconnect()
  {
    synchronized (this.lock)
    {
      if (this.zzbwp == null)
        return;
      if ((this.zzbwp.isConnected()) || (this.zzbwp.isConnecting()))
        this.zzbwp.disconnect();
      this.zzbwp = null;
      this.zzbwq = null;
      Binder.flushPendingCommands();
      return;
    }
  }

  @VisibleForTesting
  private final zzvs zza(BaseGmsClient.BaseConnectionCallbacks paramBaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener paramBaseOnConnectionFailedListener)
  {
    try
    {
      zzvs localzzvs = new zzvs(this.zzlj, zzk.zzlu().zzwr(), paramBaseConnectionCallbacks, paramBaseOnConnectionFailedListener);
      return localzzvs;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public final void initialize(Context paramContext)
  {
    if (paramContext == null)
      return;
    synchronized (this.lock)
    {
      if (this.zzlj != null)
        return;
    }
    this.zzlj = paramContext.getApplicationContext();
    zzaci localzzaci1 = zzact.zzctp;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      connect();
    while (true)
    {
      return;
      zzaci localzzaci2 = zzact.zzcto;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci2)).booleanValue())
      {
        zzvn localzzvn = new zzvn(this);
        zzk.zzlj().zza(localzzvn);
      }
    }
  }

  public final zzvq zza(zzvt paramzzvt)
  {
    synchronized (this.lock)
    {
      if (this.zzbwq == null)
      {
        zzvq localzzvq1 = new zzvq();
        return localzzvq1;
      }
    }
    try
    {
      zzvq localzzvq3 = this.zzbwq.zza(paramzzvt);
      return localzzvq3;
      localObject2 = finally;
      throw localObject2;
    }
    catch (RemoteException localRemoteException)
    {
      zzaxa.zzc("Unable to call into cache service.", localRemoteException);
      zzvq localzzvq2 = new zzvq();
      return localzzvq2;
    }
  }

  public final void zzng()
  {
    zzaci localzzaci1 = zzact.zzctq;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue())
      synchronized (this.lock)
      {
        connect();
        zzk.zzlg();
        zzaxj.zzdvx.removeCallbacks(this.zzbwo);
        zzk.zzlg();
        Handler localHandler = zzaxj.zzdvx;
        Runnable localRunnable = this.zzbwo;
        zzaci localzzaci2 = zzact.zzctr;
        localHandler.postDelayed(localRunnable, ((Long)zzyr.zzpe().zzd(localzzaci2)).longValue());
        return;
      }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzvl
 * JD-Core Version:    0.6.2
 */