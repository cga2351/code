package com.google.android.gms.internal.ads;

public final class zzdeg extends zzdoa<zzdeg, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdeg> zzdv;
  private static final zzdeg zzgrh = new zzdeg();
  private int zzgqk;
  private zzdmq zzgqs = zzdmq.zzhcr;
  private zzdek zzgrg;

  static
  {
    zzdoa.zza(zzdeg.class, zzgrh);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  private final void zza(zzdek paramzzdek)
  {
    if (paramzzdek == null)
      throw new NullPointerException();
    this.zzgrg = paramzzdek;
  }

  public static zzdeg zzad(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdeg)zzdoa.zza(zzgrh, paramzzdmq);
  }

  public static zza zzapc()
  {
    return (zza)zzgrh.zza(zzdoa.zze.zzhho, null, null);
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
    switch (zzdeh.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdeg();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgrg", "zzgqs" };
        return zza(zzgrh, "", arrayOfObject);
        return zzgrh;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgrh);
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

  public final zzdek zzapb()
  {
    if (this.zzgrg == null)
      return zzdek.zzapf();
    return this.zzgrg;
  }

  public static final class zza extends zzdoa.zza<zzdeg, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzae(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdeg.zza((zzdeg)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzb(zzdek paramzzdek)
    {
      zzaxw();
      zzdeg.zza((zzdeg)this.zzhhh, paramzzdek);
      return this;
    }

    public final zza zzdx(int paramInt)
    {
      zzaxw();
      zzdeg.zza((zzdeg)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdeg
 * JD-Core Version:    0.6.2
 */