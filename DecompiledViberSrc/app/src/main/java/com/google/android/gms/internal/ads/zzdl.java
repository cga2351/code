package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdl extends zzcf<Integer, Long>
{
  public long zzwu = -1L;
  public long zzwv = -1L;

  public zzdl()
  {
  }

  public zzdl(String paramString)
  {
    this();
    zzak(paramString);
  }

  protected final void zzak(String paramString)
  {
    HashMap localHashMap = zzal(paramString);
    if (localHashMap != null)
    {
      this.zzwu = ((Long)localHashMap.get(Integer.valueOf(0))).longValue();
      this.zzwv = ((Long)localHashMap.get(Integer.valueOf(1))).longValue();
    }
  }

  protected final HashMap<Integer, Long> zzca()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), Long.valueOf(this.zzwu));
    localHashMap.put(Integer.valueOf(1), Long.valueOf(this.zzwv));
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdl
 * JD-Core Version:    0.6.2
 */