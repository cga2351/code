package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

final class zzf
  implements ServiceConnection
{
  private ComponentName mComponentName;
  private int mState;
  private IBinder zzcy;
  private final Set<ServiceConnection> zzdz;
  private boolean zzea;
  private final GmsClientSupervisor.zza zzeb;

  public zzf(zze paramzze, GmsClientSupervisor.zza paramzza)
  {
    this.zzeb = paramzza;
    this.zzdz = new HashSet();
    this.mState = 2;
  }

  public final IBinder getBinder()
  {
    return this.zzcy;
  }

  public final ComponentName getComponentName()
  {
    return this.mComponentName;
  }

  public final int getState()
  {
    return this.mState;
  }

  public final boolean isBound()
  {
    return this.zzea;
  }

  public final void onServiceConnected(ComponentName paramComponentName, IBinder paramIBinder)
  {
    synchronized (zze.zza(this.zzec))
    {
      zze.zzb(this.zzec).removeMessages(1, this.zzeb);
      this.zzcy = paramIBinder;
      this.mComponentName = paramComponentName;
      Iterator localIterator = this.zzdz.iterator();
      if (localIterator.hasNext())
        ((ServiceConnection)localIterator.next()).onServiceConnected(paramComponentName, paramIBinder);
    }
    this.mState = 1;
  }

  public final void onServiceDisconnected(ComponentName paramComponentName)
  {
    synchronized (zze.zza(this.zzec))
    {
      zze.zzb(this.zzec).removeMessages(1, this.zzeb);
      this.zzcy = null;
      this.mComponentName = paramComponentName;
      Iterator localIterator = this.zzdz.iterator();
      if (localIterator.hasNext())
        ((ServiceConnection)localIterator.next()).onServiceDisconnected(paramComponentName);
    }
    this.mState = 2;
  }

  public final void zza(ServiceConnection paramServiceConnection, String paramString)
  {
    zze.zzd(this.zzec);
    zze.zzc(this.zzec);
    this.zzeb.zzb(zze.zzc(this.zzec));
    this.zzdz.add(paramServiceConnection);
  }

  public final boolean zza(ServiceConnection paramServiceConnection)
  {
    return this.zzdz.contains(paramServiceConnection);
  }

  public final void zzb(ServiceConnection paramServiceConnection, String paramString)
  {
    zze.zzd(this.zzec);
    zze.zzc(this.zzec);
    this.zzdz.remove(paramServiceConnection);
  }

  public final void zze(String paramString)
  {
    this.mState = 3;
    this.zzea = zze.zzd(this.zzec).zza(zze.zzc(this.zzec), paramString, this.zzeb.zzb(zze.zzc(this.zzec)), this, this.zzeb.zzq());
    if (this.zzea)
    {
      Message localMessage = zze.zzb(this.zzec).obtainMessage(1, this.zzeb);
      zze.zzb(this.zzec).sendMessageDelayed(localMessage, zze.zze(this.zzec));
      return;
    }
    this.mState = 2;
    try
    {
      zze.zzd(this.zzec).unbindService(zze.zzc(this.zzec), this);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
  }

  public final void zzf(String paramString)
  {
    zze.zzb(this.zzec).removeMessages(1, this.zzeb);
    zze.zzd(this.zzec).unbindService(zze.zzc(this.zzec), this);
    this.zzea = false;
    this.mState = 2;
  }

  public final boolean zzr()
  {
    return this.zzdz.isEmpty();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.internal.zzf
 * JD-Core Version:    0.6.2
 */