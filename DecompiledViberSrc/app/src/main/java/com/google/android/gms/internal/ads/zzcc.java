package com.google.android.gms.internal.ads;

public enum zzcc
  implements zzdod
{
  private static final zzdoe<zzcc> zzeg = new zzcd();
  private final int value;

  static
  {
    zzcc[] arrayOfzzcc = new zzcc[4];
    arrayOfzzcc[0] = zzku;
    arrayOfzzcc[1] = zzkv;
    arrayOfzzcc[2] = zzkw;
    arrayOfzzcc[3] = zzkx;
    zzky = arrayOfzzcc;
  }

  private zzcc(int paramInt)
  {
    this.value = paramInt;
  }

  public static zzdof zzad()
  {
    return zzce.zzei;
  }

  public static zzcc zzk(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return zzku;
    case 1:
      return zzkv;
    case 2:
      return zzkw;
    case 3:
    }
    return zzkx;
  }

  public final int zzac()
  {
    return this.value;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzcc
 * JD-Core Version:    0.6.2
 */