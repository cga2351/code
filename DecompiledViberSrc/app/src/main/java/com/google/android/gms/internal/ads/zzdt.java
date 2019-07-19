package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;

final class zzdt
  implements zzdu
{
  zzdt(zzdm paramzzdm, Activity paramActivity)
  {
  }

  public final void zza(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    paramActivityLifecycleCallbacks.onActivityDestroyed(this.val$activity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdt
 * JD-Core Version:    0.6.2
 */