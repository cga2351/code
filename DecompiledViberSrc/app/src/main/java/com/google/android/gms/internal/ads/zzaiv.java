package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.AdapterStatus.State;

public final class zzaiv
  implements AdapterStatus
{
  private final String description;
  private final int zzdbc;
  private final AdapterStatus.State zzdbd;

  public zzaiv(AdapterStatus.State paramState, String paramString, int paramInt)
  {
    this.zzdbd = paramState;
    this.description = paramString;
    this.zzdbc = paramInt;
  }

  public final String getDescription()
  {
    return this.description;
  }

  public final AdapterStatus.State getInitializationState()
  {
    return this.zzdbd;
  }

  public final int getLatency()
  {
    return this.zzdbc;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzaiv
 * JD-Core Version:    0.6.2
 */