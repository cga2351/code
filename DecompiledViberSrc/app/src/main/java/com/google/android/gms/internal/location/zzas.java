package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.ContentProviderClient;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.ListenerHolder.ListenerKey;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationListener;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.zzr;
import com.google.android.gms.location.zzu;
import com.google.android.gms.location.zzx;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public final class zzas
{
  private final zzbj<zzao> zzcb;
  private final Context zzcu;
  private ContentProviderClient zzcv = null;
  private boolean zzcw = false;
  private final Map<ListenerHolder.ListenerKey<LocationListener>, zzax> zzcx = new HashMap();
  private final Map<ListenerHolder.ListenerKey<Object>, zzaw> zzcy = new HashMap();
  private final Map<ListenerHolder.ListenerKey<LocationCallback>, zzat> zzcz = new HashMap();

  public zzas(Context paramContext, zzbj<zzao> paramzzbj)
  {
    this.zzcu = paramContext;
    this.zzcb = paramzzbj;
  }

  private final zzax zza(ListenerHolder<LocationListener> paramListenerHolder)
  {
    synchronized (this.zzcx)
    {
      zzax localzzax = (zzax)this.zzcx.get(paramListenerHolder.getListenerKey());
      if (localzzax == null)
        localzzax = new zzax(paramListenerHolder);
      this.zzcx.put(paramListenerHolder.getListenerKey(), localzzax);
      return localzzax;
    }
  }

  private final zzat zzb(ListenerHolder<LocationCallback> paramListenerHolder)
  {
    synchronized (this.zzcz)
    {
      zzat localzzat = (zzat)this.zzcz.get(paramListenerHolder.getListenerKey());
      if (localzzat == null)
        localzzat = new zzat(paramListenerHolder);
      this.zzcz.put(paramListenerHolder.getListenerKey(), localzzat);
      return localzzat;
    }
  }

  public final Location getLastLocation()
    throws RemoteException
  {
    this.zzcb.checkConnected();
    return ((zzao)this.zzcb.getService()).zza(this.zzcu.getPackageName());
  }

  public final void removeAllListeners()
    throws RemoteException
  {
    synchronized (this.zzcx)
    {
      Iterator localIterator1 = this.zzcx.values().iterator();
      while (localIterator1.hasNext())
      {
        zzax localzzax = (zzax)localIterator1.next();
        if (localzzax != null)
          ((zzao)this.zzcb.getService()).zza(zzbf.zza(localzzax, null));
      }
    }
    this.zzcx.clear();
    synchronized (this.zzcz)
    {
      Iterator localIterator2 = this.zzcz.values().iterator();
      while (localIterator2.hasNext())
      {
        zzat localzzat = (zzat)localIterator2.next();
        if (localzzat != null)
          ((zzao)this.zzcb.getService()).zza(zzbf.zza(localzzat, null));
      }
    }
    this.zzcz.clear();
    synchronized (this.zzcy)
    {
      Iterator localIterator3 = this.zzcy.values().iterator();
      while (localIterator3.hasNext())
      {
        zzaw localzzaw = (zzaw)localIterator3.next();
        if (localzzaw != null)
          ((zzao)this.zzcb.getService()).zza(new zzo(2, null, localzzaw.asBinder(), null));
      }
    }
    this.zzcy.clear();
  }

  public final LocationAvailability zza()
    throws RemoteException
  {
    this.zzcb.checkConnected();
    return ((zzao)this.zzcb.getService()).zzb(this.zzcu.getPackageName());
  }

  public final void zza(PendingIntent paramPendingIntent, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    zzao localzzao = (zzao)this.zzcb.getService();
    if (paramzzaj != null);
    for (IBinder localIBinder = paramzzaj.asBinder(); ; localIBinder = null)
    {
      localzzao.zza(new zzbf(2, null, null, paramPendingIntent, null, localIBinder));
      return;
    }
  }

  public final void zza(Location paramLocation)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    ((zzao)this.zzcb.getService()).zza(paramLocation);
  }

  public final void zza(ListenerHolder.ListenerKey<LocationListener> paramListenerKey, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    Preconditions.checkNotNull(paramListenerKey, "Invalid null listener key");
    synchronized (this.zzcx)
    {
      zzax localzzax = (zzax)this.zzcx.remove(paramListenerKey);
      if (localzzax != null)
      {
        localzzax.release();
        ((zzao)this.zzcb.getService()).zza(zzbf.zza(localzzax, paramzzaj));
      }
      return;
    }
  }

  public final void zza(zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    ((zzao)this.zzcb.getService()).zza(paramzzaj);
  }

  public final void zza(zzbd paramzzbd, ListenerHolder<LocationCallback> paramListenerHolder, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    zzat localzzat = zzb(paramListenerHolder);
    zzao localzzao = (zzao)this.zzcb.getService();
    IBinder localIBinder1 = localzzat.asBinder();
    if (paramzzaj != null);
    for (IBinder localIBinder2 = paramzzaj.asBinder(); ; localIBinder2 = null)
    {
      localzzao.zza(new zzbf(1, paramzzbd, null, null, localIBinder1, localIBinder2));
      return;
    }
  }

  public final void zza(LocationRequest paramLocationRequest, PendingIntent paramPendingIntent, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    zzao localzzao = (zzao)this.zzcb.getService();
    zzbd localzzbd = zzbd.zza(paramLocationRequest);
    if (paramzzaj != null);
    for (IBinder localIBinder = paramzzaj.asBinder(); ; localIBinder = null)
    {
      localzzao.zza(new zzbf(1, localzzbd, null, paramPendingIntent, null, localIBinder));
      return;
    }
  }

  public final void zza(LocationRequest paramLocationRequest, ListenerHolder<LocationListener> paramListenerHolder, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    zzax localzzax = zza(paramListenerHolder);
    zzao localzzao = (zzao)this.zzcb.getService();
    zzbd localzzbd = zzbd.zza(paramLocationRequest);
    IBinder localIBinder1 = localzzax.asBinder();
    if (paramzzaj != null);
    for (IBinder localIBinder2 = paramzzaj.asBinder(); ; localIBinder2 = null)
    {
      localzzao.zza(new zzbf(1, localzzbd, localIBinder1, null, null, localIBinder2));
      return;
    }
  }

  public final void zza(boolean paramBoolean)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    ((zzao)this.zzcb.getService()).zza(paramBoolean);
    this.zzcw = paramBoolean;
  }

  public final void zzb()
    throws RemoteException
  {
    if (this.zzcw)
      zza(false);
  }

  public final void zzb(ListenerHolder.ListenerKey<LocationCallback> paramListenerKey, zzaj paramzzaj)
    throws RemoteException
  {
    this.zzcb.checkConnected();
    Preconditions.checkNotNull(paramListenerKey, "Invalid null listener key");
    synchronized (this.zzcz)
    {
      zzat localzzat = (zzat)this.zzcz.remove(paramListenerKey);
      if (localzzat != null)
      {
        localzzat.release();
        ((zzao)this.zzcb.getService()).zza(zzbf.zza(localzzat, paramzzaj));
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.location.zzas
 * JD-Core Version:    0.6.2
 */