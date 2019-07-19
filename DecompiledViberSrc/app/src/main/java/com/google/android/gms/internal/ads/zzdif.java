package com.google.android.gms.internal.ads;

public final class zzdif extends zzdoa<zzdif, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdif> zzdv;
  private static final zzdif zzgwz = new zzdif();
  private int zzgqk;
  private zzdmq zzgqs = zzdmq.zzhcr;

  static
  {
    zzdoa.zza(zzdif.class, zzgwz);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  public static zza zzaus()
  {
    return (zza)zzgwz.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdif zzcx(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdif)zzdoa.zza(zzgwz, paramzzdmq);
  }

  private final void zzw(zzdmq paramzzdmq)
  {
    if (paramzzdmq == null)
      throw new NullPointerException();
    this.zzgqs = paramzzdmq;
  }

  public final int getVersion()
  {
    return this.zzgqk;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdig.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdif();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgqs" };
        return zza(zzgwz, "", arrayOfObject);
        return zzgwz;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgwz);
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

  public final zzdmq zzaoi()
  {
    return this.zzgqs;
  }

  public static final class zza extends zzdoa.zza<zzdif, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzcy(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdif.zza((zzdif)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzfe(int paramInt)
    {
      zzaxw();
      zzdif.zza((zzdif)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdif
 * JD-Core Version:    0.6.2
 */