package com.google.android.gms.internal.ads;

public final class zzdes extends zzdoa<zzdes, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdes> zzdv;
  private static final zzdes zzgro = new zzdes();
  private int zzgqk;
  private zzdmq zzgqs = zzdmq.zzhcr;

  static
  {
    zzdoa.zza(zzdes.class, zzgro);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  public static zzdes zzaj(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdes)zzdoa.zza(zzgro, paramzzdmq);
  }

  public static zza zzapn()
  {
    return (zza)zzgro.zza(zzdoa.zze.zzhho, null, null);
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
    switch (zzdet.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdes();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgqs" };
        return zza(zzgro, "", arrayOfObject);
        return zzgro;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgro);
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

  public static final class zza extends zzdoa.zza<zzdes, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzak(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdes.zza((zzdes)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzdz(int paramInt)
    {
      zzaxw();
      zzdes.zza((zzdes)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdes
 * JD-Core Version:    0.6.2
 */