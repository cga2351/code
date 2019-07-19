package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.RemoteException;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzdq;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@VisibleForTesting
public final class zzeb extends zzf
{
  private final zzes zzase;
  private zzaj zzasf;
  private volatile Boolean zzasg;
  private final zzy zzash;
  private final zzfi zzasi;
  private final List<Runnable> zzasj = new ArrayList();
  private final zzy zzask;

  protected zzeb(zzbw paramzzbw)
  {
    super(paramzzbw);
    this.zzasi = new zzfi(paramzzbw.zzbx());
    this.zzase = new zzes(this);
    this.zzash = new zzec(this, paramzzbw);
    this.zzask = new zzek(this, paramzzbw);
  }

  private final void onServiceDisconnected(ComponentName paramComponentName)
  {
    zzaf();
    if (this.zzasf != null)
    {
      this.zzasf = null;
      zzgt().zzjo().zzg("Disconnected from device MeasurementService", paramComponentName);
      zzaf();
      zzdj();
    }
  }

  private final void zzcy()
  {
    zzaf();
    this.zzasi.start();
    this.zzash.zzh(((Long)zzai.zzaka.get()).longValue());
  }

  private final void zzcz()
  {
    zzaf();
    if (!isConnected())
      return;
    zzgt().zzjo().zzby("Inactivity, disconnecting from the service");
    disconnect();
  }

  private final void zzf(Runnable paramRunnable)
    throws IllegalStateException
  {
    zzaf();
    if (isConnected())
    {
      paramRunnable.run();
      return;
    }
    if (this.zzasj.size() >= 1000L)
    {
      zzgt().zzjg().zzby("Discarding data. Max runnable queue size reached");
      return;
    }
    this.zzasj.add(paramRunnable);
    this.zzask.zzh(60000L);
    zzdj();
  }

  private final zzk zzl(boolean paramBoolean)
  {
    zzgw();
    zzam localzzam = zzgk();
    if (paramBoolean);
    for (String str = zzgt().zzjq(); ; str = null)
      return localzzam.zzbs(str);
  }

  private final boolean zzlh()
  {
    zzgw();
    return true;
  }

  private final void zzlj()
  {
    zzaf();
    zzgt().zzjo().zzg("Processing queued up service tasks", Integer.valueOf(this.zzasj.size()));
    Iterator localIterator = this.zzasj.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      try
      {
        localRunnable.run();
      }
      catch (Exception localException)
      {
        zzgt().zzjg().zzg("Task exception while flushing queue", localException);
      }
    }
    this.zzasj.clear();
    this.zzask.cancel();
  }

  public final void disconnect()
  {
    zzaf();
    zzcl();
    this.zzase.zzlk();
    try
    {
      ConnectionTracker.getInstance().unbindService(getContext(), this.zzase);
      label29: this.zzasf = null;
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
      break label29;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      break label29;
    }
  }

  public final void getAppInstanceId(zzdq paramzzdq)
  {
    zzaf();
    zzcl();
    zzf(new zzeg(this, zzl(false), paramzzdq));
  }

  public final boolean isConnected()
  {
    zzaf();
    zzcl();
    return this.zzasf != null;
  }

  protected final void resetAnalyticsData()
  {
    zzaf();
    zzgg();
    zzcl();
    zzk localzzk = zzl(false);
    if (zzlh())
      zzgn().resetAnalyticsData();
    zzf(new zzee(this, localzzk));
  }

  public final void zza(zzdq paramzzdq, zzag paramzzag, String paramString)
  {
    zzaf();
    zzcl();
    if (zzgr().zzs(12451000) != 0)
    {
      zzgt().zzjj().zzby("Not bundling data. Service unavailable or out of date");
      zzgr().zza(paramzzdq, new byte[0]);
      return;
    }
    zzf(new zzej(this, paramzzag, paramString, paramzzdq));
  }

  protected final void zza(zzdq paramzzdq, String paramString1, String paramString2, boolean paramBoolean)
  {
    zzaf();
    zzcl();
    zzf(new zzeq(this, paramString1, paramString2, paramBoolean, zzl(false), paramzzdq));
  }

  @VisibleForTesting
  protected final void zza(zzaj paramzzaj)
  {
    zzaf();
    Preconditions.checkNotNull(paramzzaj);
    this.zzasf = paramzzaj;
    zzcy();
    zzlj();
  }

  @VisibleForTesting
  final void zza(zzaj paramzzaj, AbstractSafeParcelable paramAbstractSafeParcelable, zzk paramzzk)
  {
    zzaf();
    zzgg();
    zzcl();
    boolean bool = zzlh();
    int i = 0;
    int j = 100;
    ArrayList localArrayList1;
    List localList;
    if ((i < 1001) && (j == 100))
    {
      localArrayList1 = new ArrayList();
      if (!bool)
        break label304;
      localList = zzgn().zzr(100);
      if (localList == null)
        break label304;
      localArrayList1.addAll(localList);
    }
    label304: for (j = localList.size(); ; j = 0)
    {
      if ((paramAbstractSafeParcelable != null) && (j < 100))
        localArrayList1.add(paramAbstractSafeParcelable);
      ArrayList localArrayList2 = (ArrayList)localArrayList1;
      int k = localArrayList2.size();
      int m = 0;
      while (m < k)
      {
        Object localObject = localArrayList2.get(m);
        m++;
        AbstractSafeParcelable localAbstractSafeParcelable = (AbstractSafeParcelable)localObject;
        if ((localAbstractSafeParcelable instanceof zzag))
          try
          {
            paramzzaj.zza((zzag)localAbstractSafeParcelable, paramzzk);
          }
          catch (RemoteException localRemoteException3)
          {
            zzgt().zzjg().zzg("Failed to send event to the service", localRemoteException3);
          }
        else if ((localAbstractSafeParcelable instanceof zzfu))
          try
          {
            paramzzaj.zza((zzfu)localAbstractSafeParcelable, paramzzk);
          }
          catch (RemoteException localRemoteException2)
          {
            zzgt().zzjg().zzg("Failed to send attribute to the service", localRemoteException2);
          }
        else if ((localAbstractSafeParcelable instanceof zzo))
          try
          {
            paramzzaj.zza((zzo)localAbstractSafeParcelable, paramzzk);
          }
          catch (RemoteException localRemoteException1)
          {
            zzgt().zzjg().zzg("Failed to send conditional property to the service", localRemoteException1);
          }
        else
          zzgt().zzjg().zzby("Discarding data. Unrecognized parcel type.");
      }
      i++;
      break;
      return;
    }
  }

  protected final void zza(zzdx paramzzdx)
  {
    zzaf();
    zzcl();
    zzf(new zzei(this, paramzzdx));
  }

  public final void zza(AtomicReference<String> paramAtomicReference)
  {
    zzaf();
    zzcl();
    zzf(new zzef(this, paramAtomicReference, zzl(false)));
  }

  protected final void zza(AtomicReference<List<zzo>> paramAtomicReference, String paramString1, String paramString2, String paramString3)
  {
    zzaf();
    zzcl();
    zzf(new zzeo(this, paramAtomicReference, paramString1, paramString2, paramString3, zzl(false)));
  }

  protected final void zza(AtomicReference<List<zzfu>> paramAtomicReference, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    zzaf();
    zzcl();
    zzf(new zzep(this, paramAtomicReference, paramString1, paramString2, paramString3, paramBoolean, zzl(false)));
  }

  protected final void zza(AtomicReference<List<zzfu>> paramAtomicReference, boolean paramBoolean)
  {
    zzaf();
    zzcl();
    zzf(new zzed(this, paramAtomicReference, zzl(false), paramBoolean));
  }

  protected final void zzb(zzfu paramzzfu)
  {
    zzaf();
    zzcl();
    if ((zzlh()) && (zzgn().zza(paramzzfu)));
    for (boolean bool = true; ; bool = false)
    {
      zzf(new zzer(this, bool, paramzzfu, zzl(true)));
      return;
    }
  }

  protected final void zzc(zzag paramzzag, String paramString)
  {
    Preconditions.checkNotNull(paramzzag);
    zzaf();
    zzcl();
    boolean bool1 = zzlh();
    if ((bool1) && (zzgn().zza(paramzzag)));
    for (boolean bool2 = true; ; bool2 = false)
    {
      zzf(new zzem(this, bool1, bool2, paramzzag, zzl(true), paramString));
      return;
    }
  }

  protected final void zzd(zzo paramzzo)
  {
    Preconditions.checkNotNull(paramzzo);
    zzaf();
    zzcl();
    zzgw();
    if (zzgn().zzc(paramzzo));
    for (boolean bool = true; ; bool = false)
    {
      zzf(new zzen(this, true, bool, new zzo(paramzzo), zzl(true), paramzzo));
      return;
    }
  }

  final void zzdj()
  {
    int i = 1;
    zzaf();
    zzcl();
    if (isConnected());
    do
    {
      return;
      int k;
      if (this.zzasg == null)
      {
        zzaf();
        zzcl();
        Boolean localBoolean1 = zzgu().zzjx();
        if ((localBoolean1 != null) && (localBoolean1.booleanValue()))
        {
          k = i;
          this.zzasg = Boolean.valueOf(k);
        }
      }
      else
      {
        if (!this.zzasg.booleanValue())
          continue;
        this.zzase.zzll();
        return;
      }
      zzgw();
      int n;
      if (zzgk().zzje() == i)
      {
        n = i;
        k = i;
      }
      while (true)
      {
        if ((k == 0) && (zzgv().zzif()))
        {
          zzgt().zzjg().zzby("No way to upload. Consider using the full version of Analytics");
          n = 0;
        }
        if (n == 0)
          break;
        zzgu().zzg(k);
        break;
        zzgt().zzjo().zzby("Checking service availability");
        int j = zzgr().zzs(12451000);
        int m;
        switch (j)
        {
        default:
          zzgt().zzjj().zzg("Unexpected service status", Integer.valueOf(j));
          m = 0;
          n = 0;
          break;
        case 0:
          zzgt().zzjo().zzby("Service available");
          n = i;
          m = i;
          break;
        case 1:
          zzgt().zzjo().zzby("Service missing");
          n = i;
          m = 0;
          break;
        case 18:
          zzgt().zzjj().zzby("Service updating");
          n = i;
          m = i;
          break;
        case 2:
          zzgt().zzjn().zzby("Service container out of date");
          if (zzgr().zzml() < 14500)
          {
            n = i;
            m = 0;
          }
          else
          {
            Boolean localBoolean2 = zzgu().zzjx();
            if ((localBoolean2 == null) || (localBoolean2.booleanValue()));
            for (m = i; ; m = 0)
            {
              n = 0;
              break;
            }
          }
          break;
        case 3:
          zzgt().zzjj().zzby("Service disabled");
          m = 0;
          n = 0;
          break;
        case 9:
          zzgt().zzjj().zzby("Service invalid");
          m = 0;
          n = 0;
        }
      }
    }
    while (zzgv().zzif());
    zzgw();
    List localList = getContext().getPackageManager().queryIntentServices(new Intent().setClassName(getContext(), "com.google.android.gms.measurement.AppMeasurementService"), 65536);
    if ((localList != null) && (localList.size() > 0));
    while (i != 0)
    {
      Intent localIntent = new Intent("com.google.android.gms.measurement.START");
      Context localContext = getContext();
      zzgw();
      localIntent.setComponent(new ComponentName(localContext, "com.google.android.gms.measurement.AppMeasurementService"));
      this.zzase.zzb(localIntent);
      return;
      i = 0;
    }
    zzgt().zzjg().zzby("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
  }

  protected final boolean zzgy()
  {
    return false;
  }

  protected final void zzld()
  {
    zzaf();
    zzcl();
    zzf(new zzeh(this, zzl(true)));
  }

  protected final void zzlg()
  {
    zzaf();
    zzcl();
    zzf(new zzel(this, zzl(true)));
  }

  final Boolean zzli()
  {
    return this.zzasg;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.measurement.internal.zzeb
 * JD-Core Version:    0.6.2
 */