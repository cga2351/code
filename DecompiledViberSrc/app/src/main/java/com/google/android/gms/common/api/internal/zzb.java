package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzb
  implements Runnable
{
  zzb(zza paramzza, LifecycleCallback paramLifecycleCallback, String paramString)
  {
  }

  public final void run()
  {
    LifecycleCallback localLifecycleCallback;
    if (zza.zza(this.zzbj) > 0)
    {
      localLifecycleCallback = this.zzbh;
      if (zza.zzb(this.zzbj) == null)
        break label118;
    }
    label118: for (Bundle localBundle = zza.zzb(this.zzbj).getBundle(this.zzbi); ; localBundle = null)
    {
      localLifecycleCallback.onCreate(localBundle);
      if (zza.zza(this.zzbj) >= 2)
        this.zzbh.onStart();
      if (zza.zza(this.zzbj) >= 3)
        this.zzbh.onResume();
      if (zza.zza(this.zzbj) >= 4)
        this.zzbh.onStop();
      if (zza.zza(this.zzbj) >= 5)
        this.zzbh.onDestroy();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzb
 * JD-Core Version:    0.6.2
 */