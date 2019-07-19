package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.util.Clock;

@zzare
final class zzawl
{
  private long zzdtg = -1L;
  private long zzdth = -1L;

  public zzawl(zzawk paramzzawk)
  {
  }

  public final Bundle toBundle()
  {
    Bundle localBundle = new Bundle();
    localBundle.putLong("topen", this.zzdtg);
    localBundle.putLong("tclose", this.zzdth);
    return localBundle;
  }

  public final long zzun()
  {
    return this.zzdth;
  }

  public final void zzuo()
  {
    this.zzdth = zzawk.zza(this.zzdti).elapsedRealtime();
  }

  public final void zzup()
  {
    this.zzdtg = zzawk.zza(this.zzdti).elapsedRealtime();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzawl
 * JD-Core Version:    0.6.2
 */