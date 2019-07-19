package com.google.android.gms.internal.ads;

public enum zzdge
  implements zzdod
{
  private static final zzdoe<zzdge> zzeg = new zzdgf();
  private final int value;

  static
  {
    zzdge[] arrayOfzzdge = new zzdge[5];
    arrayOfzzdge[0] = zzgtg;
    arrayOfzzdge[1] = zzgth;
    arrayOfzzdge[2] = zzgti;
    arrayOfzzdge[3] = zzgtj;
    arrayOfzzdge[4] = zzgtk;
    zzgtl = arrayOfzzdge;
  }

  private zzdge(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdge zzek(int paramInt)
  {
    switch (paramInt)
    {
    case 1:
    default:
      return null;
    case 0:
      return zzgtg;
    case 2:
      return zzgth;
    case 3:
      return zzgti;
    case 4:
    }
    return zzgtj;
  }

  public final int zzac()
  {
    if (this == zzgtk)
      throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdge
 * JD-Core Version:    0.6.2
 */