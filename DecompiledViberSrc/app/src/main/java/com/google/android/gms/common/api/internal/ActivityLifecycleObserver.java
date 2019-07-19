package com.google.android.gms.common.api.internal;

import android.app.Activity;
import com.google.android.gms.common.annotation.KeepForSdk;

@KeepForSdk
public abstract class ActivityLifecycleObserver
{
  @KeepForSdk
  public static final ActivityLifecycleObserver of(Activity paramActivity)
  {
    return new zaa(paramActivity);
  }

  @KeepForSdk
  public abstract ActivityLifecycleObserver onStopCallOnce(Runnable paramRunnable);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.ActivityLifecycleObserver
 * JD-Core Version:    0.6.2
 */