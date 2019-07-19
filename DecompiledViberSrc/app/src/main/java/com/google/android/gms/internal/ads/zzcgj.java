package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Clock;

final class zzcgj extends zzaiq
{
  zzcgj(zzcga paramzzcga, Object paramObject, String paramString, long paramLong, zzbbs paramzzbbs)
  {
  }

  public final void onInitializationFailed(String paramString)
  {
    synchronized (this.zzfvm)
    {
      zzcga.zza(this.zzfvq, this.zzfvn, false, paramString, (int)(zzk.zzln().elapsedRealtime() - this.zzfvo));
      this.zzfvp.set(Boolean.valueOf(false));
      return;
    }
  }

  public final void onInitializationSucceeded()
  {
    synchronized (this.zzfvm)
    {
      zzcga.zza(this.zzfvq, this.zzfvn, true, "", (int)(zzk.zzln().elapsedRealtime() - this.zzfvo));
      this.zzfvp.set(Boolean.valueOf(true));
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcgj
 * JD-Core Version:    0.6.2
 */