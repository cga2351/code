package com.google.android.gms.internal.ads;

public final class zzdhd extends zzdoa<zzdhd, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdhd> zzdv;
  private static final zzdhd zzgvi = new zzdhd();
  private int zzgqk;
  private zzdhf zzgvh;

  static
  {
    zzdoa.zza(zzdhd.class, zzgvi);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  private final void zza(zzdhf paramzzdhf)
  {
    if (paramzzdhf == null)
      throw new NullPointerException();
    this.zzgvh = paramzzdhf;
  }

  public static zza zzasx()
  {
    return (zza)zzgvi.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdhd zzbp(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdhd)zzdoa.zza(zzgvi, paramzzdmq);
  }

  public final int getVersion()
  {
    return this.zzgqk;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdhe.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdhd();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgvh" };
        return zza(zzgvi, "", arrayOfObject);
        return zzgvi;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgvi);
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

  public final zzdhf zzasw()
  {
    if (this.zzgvh == null)
      return zzdhf.zzata();
    return this.zzgvh;
  }

  public static final class zza extends zzdoa.zza<zzdhd, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdhf paramzzdhf)
    {
      zzaxw();
      zzdhd.zza((zzdhd)this.zzhhh, paramzzdhf);
      return this;
    }

    public final zza zzex(int paramInt)
    {
      zzaxw();
      zzdhd.zza((zzdhd)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhd
 * JD-Core Version:    0.6.2
 */