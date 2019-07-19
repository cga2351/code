package com.google.android.gms.internal.ads;

final class zzcog
  implements zzbsm
{
  zzcog(zzcod paramzzcod, zzbbs paramzzbbs, zzcjx paramzzcjx)
  {
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    try
    {
      zzaci localzzaci = zzact.zzcvk;
      if (((Boolean)zzyr.zzpe().zzd(localzzaci)).booleanValue())
        paramInt = 3;
      zzbbs localzzbbs = this.zzgck;
      String str = this.zzgbz.zzfir;
      localzzbbs.setException(new zzcmv(23 + String.valueOf(str).length() + "adapter " + str + " failed to load", paramInt));
      return;
    }
    finally
    {
    }
  }

  public final void onAdLoaded()
  {
    try
    {
      this.zzgck.set(null);
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
 * Qualified Name:     com.google.android.gms.internal.ads.zzcog
 * JD-Core Version:    0.6.2
 */