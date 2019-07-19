package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdx extends zzcf<Integer, Long>
{
  public Long zzxd;
  public Long zzxe;

  public zzdx()
  {
  }

  public zzdx(String paramString)
  {
    zzak(paramString);
  }

  protected final void zzak(String paramString)
  {
    HashMap localHashMap = zzal(paramString);
    if (localHashMap != null)
    {
      this.zzxd = ((Long)localHashMap.get(Integer.valueOf(0)));
      this.zzxe = ((Long)localHashMap.get(Integer.valueOf(1)));
    }
  }

  protected final HashMap<Integer, Long> zzca()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), this.zzxd);
    localHashMap.put(Integer.valueOf(1), this.zzxe);
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdx
 * JD-Core Version:    0.6.2
 */