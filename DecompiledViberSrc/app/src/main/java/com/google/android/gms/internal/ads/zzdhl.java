package com.google.android.gms.internal.ads;

public enum zzdhl
  implements zzdod
{
  private static final zzdoe<zzdhl> zzeg = new zzdhm();
  private final int value;

  static
  {
    zzdhl[] arrayOfzzdhl = new zzdhl[6];
    arrayOfzzdhl[0] = zzgvq;
    arrayOfzzdhl[1] = zzgvr;
    arrayOfzzdhl[2] = zzgvs;
    arrayOfzzdhl[3] = zzgvt;
    arrayOfzzdhl[4] = zzgvu;
    arrayOfzzdhl[5] = zzgvv;
    zzgvw = arrayOfzzdhl;
  }

  private zzdhl(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdhl zzez(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return zzgvq;
    case 1:
      return zzgvr;
    case 2:
      return zzgvs;
    case 3:
      return zzgvt;
    case 4:
    }
    return zzgvu;
  }

  public final int zzac()
  {
    if (this == zzgvv)
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhl
 * JD-Core Version:    0.6.2
 */