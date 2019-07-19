package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

@zzare
public final class zzayr
{
  private final String[] zzdwy;
  private final double[] zzdwz;
  private final double[] zzdxa;
  private final int[] zzdxb;
  private int zzdxc;

  private zzayr(zzayu paramzzayu)
  {
    int i = zzayu.zza(paramzzayu).size();
    this.zzdwy = ((String[])zzayu.zzb(paramzzayu).toArray(new String[i]));
    this.zzdwz = zzd(zzayu.zza(paramzzayu));
    this.zzdxa = zzd(zzayu.zzc(paramzzayu));
    this.zzdxb = new int[i];
    this.zzdxc = 0;
  }

  private static double[] zzd(List<Double> paramList)
  {
    double[] arrayOfDouble = new double[paramList.size()];
    for (int i = 0; i < arrayOfDouble.length; i++)
      arrayOfDouble[i] = ((Double)paramList.get(i)).doubleValue();
    return arrayOfDouble;
  }

  public final void zza(double paramDouble)
  {
    this.zzdxc = (1 + this.zzdxc);
    for (int i = 0; i < this.zzdxa.length; i++)
    {
      if ((this.zzdxa[i] <= paramDouble) && (paramDouble < this.zzdwz[i]))
      {
        int[] arrayOfInt = this.zzdxb;
        arrayOfInt[i] = (1 + arrayOfInt[i]);
      }
      if (paramDouble < this.zzdxa[i])
        break;
    }
  }

  public final List<zzayt> zzwp()
  {
    ArrayList localArrayList = new ArrayList(this.zzdwy.length);
    for (int i = 0; i < this.zzdwy.length; i++)
      localArrayList.add(new zzayt(this.zzdwy[i], this.zzdxa[i], this.zzdwz[i], this.zzdxb[i] / this.zzdxc, this.zzdxb[i]));
    return localArrayList;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzayr
 * JD-Core Version:    0.6.2
 */