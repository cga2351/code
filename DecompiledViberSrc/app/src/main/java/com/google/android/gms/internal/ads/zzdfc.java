package com.google.android.gms.internal.ads;

public enum zzdfc
  implements zzdod
{
  private static final zzdoe<zzdfc> zzeg = new zzdfd();
  private final int value;

  static
  {
    zzdfc[] arrayOfzzdfc = new zzdfc[5];
    arrayOfzzdfc[0] = zzgrt;
    arrayOfzzdfc[1] = zzgru;
    arrayOfzzdfc[2] = zzgrv;
    arrayOfzzdfc[3] = zzgrw;
    arrayOfzzdfc[4] = zzgrx;
    zzgry = arrayOfzzdfc;
  }

  private zzdfc(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdfc zzec(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return zzgrt;
    case 1:
      return zzgru;
    case 2:
      return zzgrv;
    case 3:
    }
    return zzgrw;
  }

  public final int zzac()
  {
    if (this == zzgrx)
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfc
 * JD-Core Version:    0.6.2
 */