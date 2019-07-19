package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;
import java.lang.ref.WeakReference;

final class zzdm
  implements Application.ActivityLifecycleCallbacks
{
  private final Application zzww;
  private final WeakReference<Application.ActivityLifecycleCallbacks> zzwx;
  private boolean zzwy = false;

  public zzdm(Application paramApplication, Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    this.zzwx = new WeakReference(paramActivityLifecycleCallbacks);
    this.zzww = paramApplication;
  }

  private final void zza(zzdu paramzzdu)
  {
    try
    {
      Application.ActivityLifecycleCallbacks localActivityLifecycleCallbacks = (Application.ActivityLifecycleCallbacks)this.zzwx.get();
      if (localActivityLifecycleCallbacks != null)
      {
        paramzzdu.zza(localActivityLifecycleCallbacks);
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
    }
  }

  public final void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    zza(new zzdn(this, paramActivity, paramBundle));
  }

  public final void onActivityDestroyed(Activity paramActivity)
  {
    zza(new zzdt(this, paramActivity));
  }

  public final void onActivityPaused(Activity paramActivity)
  {
    zza(new zzdq(this, paramActivity));
  }

  public final void onActivityResumed(Activity paramActivity)
  {
    zza(new zzdp(this, paramActivity));
  }

  public final void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle)
  {
    zza(new zzds(this, paramActivity, paramBundle));
  }

  public final void onActivityStarted(Activity paramActivity)
  {
    zza(new zzdo(this, paramActivity));
  }

  public final void onActivityStopped(Activity paramActivity)
  {
    zza(new zzdr(this, paramActivity));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdm
 * JD-Core Version:    0.6.2
 */