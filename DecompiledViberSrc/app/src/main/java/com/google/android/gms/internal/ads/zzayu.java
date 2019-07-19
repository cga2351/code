package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

public final class zzayu
{
  private final List<String> zzdxg = new ArrayList();
  private final List<Double> zzdxh = new ArrayList();
  private final List<Double> zzdxi = new ArrayList();

  public final zzayu zza(String paramString, double paramDouble1, double paramDouble2)
  {
    for (int i = 0; i < this.zzdxg.size(); i++)
    {
      double d1 = ((Double)this.zzdxi.get(i)).doubleValue();
      double d2 = ((Double)this.zzdxh.get(i)).doubleValue();
      if ((paramDouble1 < d1) || ((d1 == paramDouble1) && (paramDouble2 < d2)))
        break;
    }
    this.zzdxg.add(i, paramString);
    this.zzdxi.add(i, Double.valueOf(paramDouble1));
    this.zzdxh.add(i, Double.valueOf(paramDouble2));
    return this;
  }

  public final zzayr zzwq()
  {
    return new zzayr(this, null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayu
 * JD-Core Version:    0.6.2
 */