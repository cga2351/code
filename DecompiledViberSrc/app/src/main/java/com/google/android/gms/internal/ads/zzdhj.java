package com.google.android.gms.internal.ads;

public final class zzdhj extends zzdoa<zzdhj, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdhj> zzdv;
  private static final zzdhj zzgvp = new zzdhj();
  private String zzgvn = "";
  private zzdgv zzgvo;

  static
  {
    zzdoa.zza(zzdhj.class, zzgvp);
  }

  public static zzdhj zzath()
  {
    return zzgvp;
  }

  public static zzdhj zzbs(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdhj)zzdoa.zza(zzgvp, paramzzdmq);
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdhk.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdhj();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgvn", "zzgvo" };
        return zza(zzgvp, "", arrayOfObject);
        return zzgvp;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgvp);
          zzdv = (zzdpu)localObject3;
        }
        return localObject3;
      }
      finally
      {
      }
    case 6:
      return Byte.valueOf((byte)1);
    case 7:
    }
    return null;
  }

  public final String zzatf()
  {
    return this.zzgvn;
  }

  public final zzdgv zzatg()
  {
    if (this.zzgvo == null)
      return zzdgv.zzarz();
    return this.zzgvo;
  }

  public static final class zza extends zzdoa.zza<zzdhj, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhj
 * JD-Core Version:    0.6.2
 */