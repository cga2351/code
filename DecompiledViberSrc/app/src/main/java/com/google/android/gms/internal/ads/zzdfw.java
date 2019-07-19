package com.google.android.gms.internal.ads;

public final class zzdfw extends zzdoa<zzdfw, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdfw> zzdv;
  private static final zzdfw zzgsz = new zzdfw();
  private int zzgqk;
  private zzdmq zzgsh = zzdmq.zzhcr;
  private zzdmq zzgsi = zzdmq.zzhcr;
  private zzdfs zzgsr;

  static
  {
    zzdoa.zza(zzdfw.class, zzgsz);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  public static zza zzaqx()
  {
    return (zza)zzgsz.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdfw zzaqy()
  {
    return zzgsz;
  }

  private final void zzau(zzdmq paramzzdmq)
  {
    if (paramzzdmq == null)
      throw new NullPointerException();
    this.zzgsh = paramzzdmq;
  }

  private final void zzav(zzdmq paramzzdmq)
  {
    if (paramzzdmq == null)
      throw new NullPointerException();
    this.zzgsi = paramzzdmq;
  }

  private final void zzb(zzdfs paramzzdfs)
  {
    if (paramzzdfs == null)
      throw new NullPointerException();
    this.zzgsr = paramzzdfs;
  }

  public static zzdfw zzbc(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdfw)zzdoa.zza(zzgsz, paramzzdmq);
  }

  public final int getVersion()
  {
    return this.zzgqk;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdfx.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdfw();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgsr", "zzgsh", "zzgsi" };
        return zza(zzgsz, "", arrayOfObject);
        return zzgsz;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgsz);
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

  public final zzdmq zzaqf()
  {
    return this.zzgsh;
  }

  public final zzdmq zzaqg()
  {
    return this.zzgsi;
  }

  public final zzdfs zzaqn()
  {
    if (this.zzgsr == null)
      return zzdfs.zzaqs();
    return this.zzgsr;
  }

  public static final class zza extends zzdoa.zza<zzdfw, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzbd(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdfw.zza((zzdfw)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzbe(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdfw.zzb((zzdfw)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzc(zzdfs paramzzdfs)
    {
      zzaxw();
      zzdfw.zza((zzdfw)this.zzhhh, paramzzdfs);
      return this;
    }

    public final zza zzeh(int paramInt)
    {
      zzaxw();
      zzdfw.zza((zzdfw)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfw
 * JD-Core Version:    0.6.2
 */