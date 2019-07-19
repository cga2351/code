package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzdw extends zzcf<Integer, Object>
{
  public Long zzxa;
  public Boolean zzxb;
  public Boolean zzxc;

  public zzdw()
  {
  }

  public zzdw(String paramString)
  {
    zzak(paramString);
  }

  protected final void zzak(String paramString)
  {
    HashMap localHashMap = zzal(paramString);
    if (localHashMap != null)
    {
      this.zzxa = ((Long)localHashMap.get(Integer.valueOf(0)));
      this.zzxb = ((Boolean)localHashMap.get(Integer.valueOf(1)));
      this.zzxc = ((Boolean)localHashMap.get(Integer.valueOf(2)));
    }
  }

  protected final HashMap<Integer, Object> zzca()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), this.zzxa);
    localHashMap.put(Integer.valueOf(1), this.zzxb);
    localHashMap.put(Integer.valueOf(2), this.zzxc);
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdw
 * JD-Core Version:    0.6.2
 */