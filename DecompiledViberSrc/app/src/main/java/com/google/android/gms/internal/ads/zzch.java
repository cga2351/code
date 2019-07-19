package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzch extends zzcf<Integer, Object>
{
  public String zzne = "E";
  public long zznf = -1L;
  public String zzng = "E";
  public String zznh = "E";
  public String zzni = "E";

  public zzch()
  {
  }

  public zzch(String paramString)
  {
    this();
    zzak(paramString);
  }

  protected final void zzak(String paramString)
  {
    HashMap localHashMap = zzal(paramString);
    String str1;
    long l;
    label44: String str2;
    label65: String str3;
    if (localHashMap != null)
    {
      if (localHashMap.get(Integer.valueOf(0)) != null)
        break label114;
      str1 = "E";
      this.zzne = str1;
      if (localHashMap.get(Integer.valueOf(1)) != null)
        break label129;
      l = -1L;
      this.zznf = l;
      if (localHashMap.get(Integer.valueOf(2)) != null)
        break label148;
      str2 = "E";
      this.zzng = str2;
      if (localHashMap.get(Integer.valueOf(3)) != null)
        break label164;
      str3 = "E";
      label86: this.zznh = str3;
      if (localHashMap.get(Integer.valueOf(4)) != null)
        break label180;
    }
    label129: label148: label164: label180: for (String str4 = "E"; ; str4 = (String)localHashMap.get(Integer.valueOf(4)))
    {
      this.zzni = str4;
      return;
      label114: str1 = (String)localHashMap.get(Integer.valueOf(0));
      break;
      l = ((Long)localHashMap.get(Integer.valueOf(1))).longValue();
      break label44;
      str2 = (String)localHashMap.get(Integer.valueOf(2));
      break label65;
      str3 = (String)localHashMap.get(Integer.valueOf(3));
      break label86;
    }
  }

  protected final HashMap<Integer, Object> zzca()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put(Integer.valueOf(0), this.zzne);
    localHashMap.put(Integer.valueOf(4), this.zzni);
    localHashMap.put(Integer.valueOf(3), this.zznh);
    localHashMap.put(Integer.valueOf(2), this.zzng);
    localHashMap.put(Integer.valueOf(1), Long.valueOf(this.zznf));
    return localHashMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzch
 * JD-Core Version:    0.6.2
 */