package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzeg extends zzcf<Integer, Long>
{
  public Long zzyn;
  public Long zzyo;
  public Long zzyp;
  public Long zzyq;

  public zzeg()
  {
  }

  public zzeg(String paramString)
  {
    zzak(paramString);
  }

  protected final void zzak(String paramString)
  {
    HashMap localHashMap = zzal(paramString);
    if (localHashMap != null)
    {
      this.zzyn = ((Long)localHashMap.get(Integer.valueOf(0)));
      this.zzyo = ((Long)localHashMap.get(Integer.valueOf(1)));
      this.zzyp = ((Long)localHashMap.get(Integer.valueOf(2)));
      this.zzyq = ((Long)localHashMap.get(Integer.valueOf(3)));
    }
  }

  protected final HashMap<Integer, Long> zzca()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), this.zzyn);
    localHashMap.put(Integer.valueOf(1), this.zzyo);
    localHashMap.put(Integer.valueOf(2), this.zzyp);
    localHashMap.put(Integer.valueOf(3), this.zzyq);
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzeg
 * JD-Core Version:    0.6.2
 */