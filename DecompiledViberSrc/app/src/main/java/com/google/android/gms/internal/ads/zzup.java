package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

@TargetApi(14)
final class zzup
  implements Application.ActivityLifecycleCallbacks
{
  private boolean foreground = true;
  private final Object lock = new Object();
  private boolean zzbuu = false;

  @GuardedBy("lock")
  private final List<zzur> zzbuv = new ArrayList();

  @GuardedBy("lock")
  private final List<zzve> zzbuw = new ArrayList();
  private Runnable zzbux;
  private long zzbuy;
  private Context zzlj;
  private boolean zzxs = false;
  private Activity zzzd;

  private final void setActivity(Activity paramActivity)
  {
    synchronized (this.lock)
    {
      if (!paramActivity.getClass().getName().startsWith("com.google.android.gms.ads"))
        this.zzzd = paramActivity;
      return;
    }
  }

  public final Activity getActivity()
  {
    return this.zzzd;
  }

  public final Context getContext()
  {
    return this.zzlj;
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    synchronized (this.lock)
    {
      if (this.zzzd == null)
        return;
      if (this.zzzd.equals(paramActivity))
        this.zzzd = null;
      Iterator localIterator = this.zzbuw.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          zzve localzzve = (zzve)localIterator.next();
          try
          {
            if (localzzve.zza(paramActivity))
              localIterator.remove();
          }
          catch (Exception localException)
          {
            zzk.zzlk().zza(localException, "AppActivityTracker.ActivityListener.onActivityDestroyed");
            zzbae.zzc("", localException);
          }
        }
    }
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    setActivity(paramActivity);
    synchronized (this.lock)
    {
      Iterator localIterator = this.zzbuw.iterator();
      while (true)
        if (localIterator.hasNext())
        {
          zzve localzzve = (zzve)localIterator.next();
          try
          {
            localzzve.onActivityPaused(paramActivity);
          }
          catch (Exception localException)
          {
            zzk.zzlk().zza(localException, "AppActivityTracker.ActivityListener.onActivityPaused");
            zzbae.zzc("", localException);
          }
        }
    }
    this.zzbuu = true;
    if (this.zzbux != null)
      zzaxj.zzdvx.removeCallbacks(this.zzbux);
    Handler localHandler = zzaxj.zzdvx;
    zzuq localzzuq = new zzuq(this);
    this.zzbux = localzzuq;
    localHandler.postDelayed(localzzuq, this.zzbuy);
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    setActivity(paramActivity);
    this.zzbuu = false;
    boolean bool = this.foreground;
    int i = 0;
    if (!bool)
      i = 1;
    this.foreground = true;
    if (this.zzbux != null)
      zzaxj.zzdvx.removeCallbacks(this.zzbux);
    synchronized (this.lock)
    {
      Iterator localIterator1 = this.zzbuw.iterator();
      while (true)
        if (localIterator1.hasNext())
        {
          zzve localzzve = (zzve)localIterator1.next();
          try
          {
            localzzve.onActivityResumed(paramActivity);
          }
          catch (Exception localException2)
          {
            zzk.zzlk().zza(localException2, "AppActivityTracker.ActivityListener.onActivityResumed");
            zzbae.zzc("", localException2);
          }
        }
    }
    if (i != 0)
    {
      Iterator localIterator2 = this.zzbuv.iterator();
      while (localIterator2.hasNext())
      {
        zzur localzzur = (zzur)localIterator2.next();
        try
        {
          localzzur.zzp(true);
        }
        catch (Exception localException1)
        {
          zzbae.zzc("", localException1);
        }
      }
    }
    zzaxa.zzdp("App is still foreground.");
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public final void onActivityStarted(Activity paramActivity)
  {
    setActivity(paramActivity);
  }

  public final void onActivityStopped(Activity paramActivity)
  {
  }

  public final void zza(Application paramApplication, Context paramContext)
  {
    if (!this.zzxs)
    {
      paramApplication.registerActivityLifecycleCallbacks(this);
      if ((paramContext instanceof Activity))
        setActivity((Activity)paramContext);
      this.zzlj = paramApplication;
      zzaci localzzaci = zzact.zzcoy;
      this.zzbuy = ((Long)zzyr.zzpe().zzd(localzzaci)).longValue();
      this.zzxs = true;
    }
  }

  public final void zza(zzur paramzzur)
  {
    synchronized (this.lock)
    {
      this.zzbuv.add(paramzzur);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzup
 * JD-Core Version:    0.6.2
 */