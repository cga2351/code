package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.internal.ads.zzaci;
import com.google.android.gms.internal.ads.zzacq;
import com.google.android.gms.internal.ads.zzact;
import com.google.android.gms.internal.ads.zzare;
import com.google.android.gms.internal.ads.zzaxa;
import com.google.android.gms.internal.ads.zzaxh;
import com.google.android.gms.internal.ads.zzazu;
import com.google.android.gms.internal.ads.zzbaj;
import com.google.android.gms.internal.ads.zzdc;
import com.google.android.gms.internal.ads.zzdg;
import com.google.android.gms.internal.ads.zzyr;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicReference;

@zzare
public final class zzg
  implements zzdc, Runnable
{
  private final List<Object[]> zzbrb = new Vector();
  private final AtomicReference<zzdc> zzbrc = new AtomicReference();
  private zzbaj zzbrd;
  private CountDownLatch zzbre = new CountDownLatch(1);
  private Context zzlj;

  public zzg(Context paramContext, zzbaj paramzzbaj)
  {
    this.zzlj = paramContext;
    this.zzbrd = paramzzbaj;
    zzyr.zzpa();
    if (zzazu.zzwy())
    {
      zzaxh.zzc(this);
      return;
    }
    run();
  }

  private static Context zze(Context paramContext)
  {
    Context localContext = paramContext.getApplicationContext();
    if (localContext == null)
      return paramContext;
    return localContext;
  }

  private final boolean zzla()
  {
    try
    {
      this.zzbre.await();
      return true;
    }
    catch (InterruptedException localInterruptedException)
    {
      zzaxa.zzd("Interrupted during GADSignals creation.", localInterruptedException);
    }
    return false;
  }

  private final void zzlb()
  {
    if (this.zzbrb.isEmpty())
      return;
    Iterator localIterator = this.zzbrb.iterator();
    while (localIterator.hasNext())
    {
      Object[] arrayOfObject = (Object[])localIterator.next();
      if (arrayOfObject.length == 1)
        ((Runnable)this.zzbrc.get()).zza((MotionEvent)arrayOfObject[0]);
      else if (arrayOfObject.length == 3)
        ((Runnable)this.zzbrc.get()).zza(((Integer)arrayOfObject[0]).intValue(), ((Integer)arrayOfObject[1]).intValue(), ((Integer)arrayOfObject[2]).intValue());
    }
    this.zzbrb.clear();
  }

  public final void run()
  {
    while (true)
    {
      try
      {
        if (!this.zzbrd.zzdzg)
          break label113;
        i = 1;
        zzaci localzzaci = zzact.zzcpc;
        if ((!((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue()) && (i != 0))
        {
          bool = true;
          zzdg localzzdg = zzdg.zza(this.zzbrd.zzbsy, zze(this.zzlj), bool);
          this.zzbrc.set(localzzdg);
          return;
        }
      }
      finally
      {
        this.zzbre.countDown();
        this.zzlj = null;
        this.zzbrd = null;
      }
      boolean bool = false;
      continue;
      label113: int i = 0;
    }
  }

  public final String zza(Context paramContext)
  {
    if (zzla())
    {
      zzdc localzzdc = (Runnable)this.zzbrc.get();
      if (localzzdc != null)
      {
        zzlb();
        return localzzdc.zza(zze(paramContext));
      }
    }
    return "";
  }

  public final String zza(Context paramContext, String paramString, View paramView)
  {
    return zza(paramContext, paramString, paramView, null);
  }

  public final String zza(Context paramContext, String paramString, View paramView, Activity paramActivity)
  {
    if (zzla())
    {
      zzdc localzzdc = (Runnable)this.zzbrc.get();
      if (localzzdc != null)
      {
        zzlb();
        return localzzdc.zza(zze(paramContext), paramString, paramView, paramActivity);
      }
    }
    return "";
  }

  public final void zza(int paramInt1, int paramInt2, int paramInt3)
  {
    zzdc localzzdc = (Runnable)this.zzbrc.get();
    if (localzzdc != null)
    {
      zzlb();
      localzzdc.zza(paramInt1, paramInt2, paramInt3);
      return;
    }
    List localList = this.zzbrb;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = Integer.valueOf(paramInt1);
    arrayOfObject[1] = Integer.valueOf(paramInt2);
    arrayOfObject[2] = Integer.valueOf(paramInt3);
    localList.add(arrayOfObject);
  }

  public final void zza(MotionEvent paramMotionEvent)
  {
    zzdc localzzdc = (Runnable)this.zzbrc.get();
    if (localzzdc != null)
    {
      zzlb();
      localzzdc.zza(paramMotionEvent);
      return;
    }
    this.zzbrb.add(new Object[] { paramMotionEvent });
  }

  public final void zzb(View paramView)
  {
    zzdc localzzdc = (Runnable)this.zzbrc.get();
    if (localzzdc != null)
      localzzdc.zzb(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.ads.internal.zzg
 * JD-Core Version:    0.6.2
 */