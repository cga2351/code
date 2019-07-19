package com.google.android.gms.internal.ads;

public enum zzdgi
  implements zzdod
{
  private static final zzdoe<zzdgi> zzeg = new zzdgj();
  private final int value;

  static
  {
    zzdgi[] arrayOfzzdgi = new zzdgi[5];
    arrayOfzzdgi[0] = zzgtn;
    arrayOfzzdgi[1] = zzgto;
    arrayOfzzdgi[2] = zzgtp;
    arrayOfzzdgi[3] = zzgtq;
    arrayOfzzdgi[4] = zzgtr;
    zzgts = arrayOfzzdgi;
  }

  private zzdgi(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdgi zzel(int paramInt)
  {
    switch (paramInt)
    {
    case 2:
    default:
      return null;
    case 0:
      return zzgtn;
    case 1:
      return zzgto;
    case 3:
      return zzgtp;
    case 4:
    }
    return zzgtq;
  }

  public final int zzac()
  {
    if (this == zzgtr)
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgi
 * JD-Core Version:    0.6.2
 */