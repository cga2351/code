package com.google.android.gms.common.api.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningAppProcessInfo;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.os.Bundle;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.util.PlatformVersion;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.annotation.concurrent.GuardedBy;

@KeepForSdk
public final class BackgroundDetector
  implements Application.ActivityLifecycleCallbacks, ComponentCallbacks2
{
  private static final BackgroundDetector zzas = new BackgroundDetector();
  private final AtomicBoolean zzat = new AtomicBoolean();
  private final AtomicBoolean zzau = new AtomicBoolean();

  @GuardedBy("sInstance")
  private final ArrayList<BackgroundStateChangeListener> zzav = new ArrayList();

  @GuardedBy("sInstance")
  private boolean zzaw = false;

  @KeepForSdk
  public static BackgroundDetector getInstance()
  {
    return zzas;
  }

  @KeepForSdk
  public static void initialize(Application paramApplication)
  {
    synchronized (zzas)
    {
      if (!zzas.zzaw)
      {
        paramApplication.registerActivityLifecycleCallbacks(zzas);
        paramApplication.registerComponentCallbacks(zzas);
        zzas.zzaw = true;
      }
      return;
    }
  }

  private final void onBackgroundStateChanged(boolean paramBoolean)
  {
    synchronized (zzas)
    {
      ArrayList localArrayList = (ArrayList)this.zzav;
      int i = localArrayList.size();
      int j = 0;
      if (j < i)
      {
        Object localObject2 = localArrayList.get(j);
        j++;
        ((BackgroundStateChangeListener)localObject2).onBackgroundStateChanged(paramBoolean);
      }
    }
  }

  @KeepForSdk
  public final void addListener(BackgroundStateChangeListener paramBackgroundStateChangeListener)
  {
    synchronized (zzas)
    {
      this.zzav.add(paramBackgroundStateChangeListener);
      return;
    }
  }

  @KeepForSdk
  public final boolean isInBackground()
  {
    return this.zzat.get();
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    boolean bool = this.zzat.compareAndSet(true, false);
    this.zzau.set(true);
    if (bool)
      onBackgroundStateChanged(false);
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
  }

  public final void onActivityPaused(Activity paramActivity)
  {
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    boolean bool = this.zzat.compareAndSet(true, false);
    this.zzau.set(true);
    if (bool)
      onBackgroundStateChanged(false);
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
  }

  public final void onActivityStarted(Activity paramActivity)
  {
  }

  public final void onActivityStopped(Activity paramActivity)
  {
  }

  public final void onConfigurationChanged(Configuration paramConfiguration)
  {
  }

  public final void onLowMemory()
  {
  }

  public final void onTrimMemory(int paramInt)
  {
    if ((paramInt == 20) && (this.zzat.compareAndSet(false, true)))
    {
      this.zzau.set(true);
      onBackgroundStateChanged(true);
    }
  }

  @TargetApi(16)
  @KeepForSdk
  public final boolean readCurrentStateIfPossible(boolean paramBoolean)
  {
    if (!this.zzau.get())
    {
      if (!PlatformVersion.isAtLeastJellyBean())
        break label61;
      ActivityManager.RunningAppProcessInfo localRunningAppProcessInfo = new ActivityManager.RunningAppProcessInfo();
      ActivityManager.getMyMemoryState(localRunningAppProcessInfo);
      if ((!this.zzau.getAndSet(true)) && (localRunningAppProcessInfo.importance > 100))
        this.zzat.set(true);
    }
    paramBoolean = isInBackground();
    label61: return paramBoolean;
  }

  @KeepForSdk
  public static abstract interface BackgroundStateChangeListener
  {
    @KeepForSdk
    public abstract void onBackgroundStateChanged(boolean paramBoolean);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.BackgroundDetector
 * JD-Core Version:    0.6.2
 */