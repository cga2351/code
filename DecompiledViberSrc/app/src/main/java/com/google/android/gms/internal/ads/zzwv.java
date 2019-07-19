package com.google.android.gms.internal.ads;

public enum zzwv
  implements zzdod
{
  private static final zzdoe<zzwv> zzeg = new zzww();
  private final int value;

  static
  {
    zzwv[] arrayOfzzwv = new zzwv[3];
    arrayOfzzwv[0] = zzcaj;
    arrayOfzzwv[1] = zzcak;
    arrayOfzzwv[2] = zzcal;
  }

  private zzwv(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdof zzad()
  {
    return zzwx.zzei;
  }

  public static zzwv zzca(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return zzcaj;
    case 1:
      return zzcak;
    case 1000:
    }
    return zzcal;
  }

  public final int zzac()
  {
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzwv
 * JD-Core Version:    0.6.2
 */