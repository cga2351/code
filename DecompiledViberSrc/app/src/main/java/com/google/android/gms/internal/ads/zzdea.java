package com.google.android.gms.internal.ads;

public final class zzdea extends zzdoa<zzdea, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdea> zzdv;
  private static final zzdea zzgrc = new zzdea();
  private int zzgqk;
  private zzdmq zzgqs = zzdmq.zzhcr;
  private zzdee zzgrb;

  static
  {
    zzdoa.zza(zzdea.class, zzgrc);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  public static zzdea zzaa(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdea)zzdoa.zza(zzgrc, paramzzdmq);
  }

  public static zza zzaot()
  {
    return (zza)zzgrc.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdea zzaou()
  {
    return zzgrc;
  }

  private final void zzb(zzdee paramzzdee)
  {
    if (paramzzdee == null)
      throw new NullPointerException();
    this.zzgrb = paramzzdee;
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
    switch (zzdeb.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdea();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgrb", "zzgqs" };
        return zza(zzgrc, "", arrayOfObject);
        return zzgrc;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgrc);
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

  public final zzdee zzaos()
  {
    if (this.zzgrb == null)
      return zzdee.zzaoz();
    return this.zzgrb;
  }

  public static final class zza extends zzdoa.zza<zzdea, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzab(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdea.zza((zzdea)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzc(zzdee paramzzdee)
    {
      zzaxw();
      zzdea.zza((zzdea)this.zzhhh, paramzzdee);
      return this;
    }

    public final zza zzdw(int paramInt)
    {
      zzaxw();
      zzdea.zza((zzdea)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdea
 * JD-Core Version:    0.6.2
 */