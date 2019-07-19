package com.google.android.gms.internal.ads;

public final class zzdfu extends zzdoa<zzdfu, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdfu> zzdv;
  private static final zzdfu zzgsy = new zzdfu();
  private int zzgqk;
  private zzdmq zzgqs = zzdmq.zzhcr;
  private zzdfw zzgsx;

  static
  {
    zzdoa.zza(zzdfu.class, zzgsy);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  private final void zza(zzdfw paramzzdfw)
  {
    if (paramzzdfw == null)
      throw new NullPointerException();
    this.zzgsx = paramzzdfw;
  }

  public static zza zzaqv()
  {
    return (zza)zzgsy.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdfu zzba(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdfu)zzdoa.zza(zzgsy, paramzzdmq);
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
    switch (zzdfv.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdfu();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgsx", "zzgqs" };
        return zza(zzgsy, "", arrayOfObject);
        return zzgsy;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgsy);
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

  public final zzdfw zzaqu()
  {
    if (this.zzgsx == null)
      return zzdfw.zzaqy();
    return this.zzgsx;
  }

  public static final class zza extends zzdoa.zza<zzdfu, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdfw paramzzdfw)
    {
      zzaxw();
      zzdfu.zza((zzdfu)this.zzhhh, paramzzdfw);
      return this;
    }

    public final zza zzbb(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdfu.zza((zzdfu)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzeg(int paramInt)
    {
      zzaxw();
      zzdfu.zza((zzdfu)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfu
 * JD-Core Version:    0.6.2
 */