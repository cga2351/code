package com.google.android.gms.internal.ads;

public enum zzdgt
  implements zzdod
{
  private static final zzdoe<zzdgt> zzeg = new zzdgu();
  private final int value;

  static
  {
    zzdgt[] arrayOfzzdgt = new zzdgt[5];
    arrayOfzzdgt[0] = zzguk;
    arrayOfzzdgt[1] = zzgul;
    arrayOfzzdgt[2] = zzgum;
    arrayOfzzdgt[3] = zzgun;
    arrayOfzzdgt[4] = zzguo;
    zzgup = arrayOfzzdgt;
  }

  private zzdgt(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdgt zzeo(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return zzguk;
    case 1:
      return zzgul;
    case 2:
      return zzgum;
    case 3:
    }
    return zzgun;
  }

  public final int zzac()
  {
    if (this == zzguo)
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgt
 * JD-Core Version:    0.6.2
 */