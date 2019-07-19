package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzud
  implements Application.ActivityLifecycleCallbacks
{
  private final Application zzww;
  private final WeakReference<Application.ActivityLifecycleCallbacks> zzwx;
  private boolean zzwy = false;

  public zzud(Application paramApplication, Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.zzwx = new WeakReference(paramActivityLifecycleCallbacks);
    this.zzww = paramApplication;
  }

  private final void zza(zzul paramzzul)
  {
    try
    {
      Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)this.zzwx.get();
      if (localActivityLifecycleCallbacks != null)
      {
        paramzzul.zza(localActivityLifecycleCallbacks);
        return;
      }
      if (!this.zzwy)
      {
        this.zzww.unregisterActivityLifecycleCallbacks(this);
        this.zzwy = true;
        return;
      }
    }
    catch (Exception localException)
    {
      zzaxa.zzc("Error while dispatching lifecycle callback.", localException);
    }
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zza(new zzue(this, paramActivity, paramBundle));
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    zza(new zzuk(this, paramActivity));
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    zza(new zzuh(this, paramActivity));
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    zza(new zzug(this, paramActivity));
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zza(new zzuj(this, paramActivity, paramBundle));
  }

  public final void onActivityStarted(Activity paramActivity)
  {
    zza(new zzuf(this, paramActivity));
  }

  public final void onActivityStopped(Activity paramActivity)
  {
    zza(new zzui(this, paramActivity));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzud
 * JD-Core Version:    0.6.2
 */