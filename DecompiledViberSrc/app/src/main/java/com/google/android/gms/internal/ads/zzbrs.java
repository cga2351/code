package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrs extends zzbtr<zzbrv>
{
  private boolean zzfkb = false;

  public zzbrs(Set<zzbuy<zzbrv>> paramSet)
  {
    super(paramSet);
  }

  public final void onAdImpression()
  {
    try
    {
      if (!this.zzfkb)
      {
        zza(zzbrt.zzfka);
        this.zzfkb = true;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbrs
 * JD-Core Version:    0.6.2
 */