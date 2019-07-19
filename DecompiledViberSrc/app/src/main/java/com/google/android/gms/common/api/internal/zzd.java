package com.google.android.gms.common.api.internal;

import android.os.Bundle;

final class zzd
  implements Runnable
{
  zzd(zzc paramzzc, LifecycleCallback paramLifecycleCallback, String paramString)
  {
  }

  public final void run()
  {
    LifecycleCallback localLifecycleCallback;
    if (zzc.zza(this.zzbk) > 0)
    {
      localLifecycleCallback = this.zzbh;
      if (zzc.zzb(this.zzbk) == null)
        break label118;
    }
    label118: for (Bundle localBundle = zzc.zzb(this.zzbk).getBundle(this.zzbi); ; localBundle = null)
    {
      localLifecycleCallback.onCreate(localBundle);
      if (zzc.zza(this.zzbk) >= 2)
        this.zzbh.onStart();
      if (zzc.zza(this.zzbk) >= 3)
        this.zzbh.onResume();
      if (zzc.zza(this.zzbk) >= 4)
        this.zzbh.onStop();
      if (zzc.zza(this.zzbk) >= 5)
        this.zzbh.onDestroy();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.internal.zzd
 * JD-Core Version:    0.6.2
 */