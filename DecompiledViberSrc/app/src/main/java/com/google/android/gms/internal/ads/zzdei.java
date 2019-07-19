package com.google.android.gms.internal.ads;

public final class zzdei extends zzdoa<zzdei, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdei> zzdv;
  private static final zzdei zzgri = new zzdei();
  private int zzgqu;
  private zzdek zzgrg;

  static
  {
    zzdoa.zza(zzdei.class, zzgri);
  }

  public static zzdei zzaf(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdei)zzdoa.zza(zzgri, paramzzdmq);
  }

  public final int getKeySize()
  {
    return this.zzgqu;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdej.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdei();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgrg", "zzgqu" };
        return zza(zzgri, "", arrayOfObject);
        return zzgri;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgri);
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

  public final zzdek zzapb()
  {
    if (this.zzgrg == null)
      return zzdek.zzapf();
    return this.zzgrg;
  }

  public static final class zza extends zzdoa.zza<zzdei, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdei
 * JD-Core Version:    0.6.2
 */