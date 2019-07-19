package com.google.android.gms.internal.ads;

public final class zzdhf extends zzdoa<zzdhf, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdhf> zzdv;
  private static final zzdhf zzgvk = new zzdhf();
  private String zzgvj = "";

  static
  {
    zzdoa.zza(zzdhf.class, zzgvk);
  }

  public static zzdhf zzata()
  {
    return zzgvk;
  }

  public static zzdhf zzbq(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdhf)zzdoa.zza(zzgvk, paramzzdmq);
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdhg.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdhf();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgvj" };
        return zza(zzgvk, "", arrayOfObject);
        return zzgvk;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgvk);
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

  public final String zzasz()
  {
    return this.zzgvj;
  }

  public static final class zza extends zzdoa.zza<zzdhf, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhf
 * JD-Core Version:    0.6.2
 */