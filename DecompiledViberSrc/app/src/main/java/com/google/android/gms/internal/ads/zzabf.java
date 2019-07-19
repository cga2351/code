package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.AdapterStatus.State;

final class zzabf
  implements AdapterStatus
{
  zzabf(zzabc paramzzabc)
  {
  }

  public final String getDescription()
  {
    return "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time.";
  }

  public final AdapterStatus.State getInitializationState()
  {
    return AdapterStatus.State.READY;
  }

  public final int getLatency()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzabf
 * JD-Core Version:    0.6.2
 */