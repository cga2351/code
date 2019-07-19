package com.google.android.gms.internal.ads;

public final class zzdgk extends zzdoa<zzdgk, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgk> zzdv;
  private static final zzdgk zzgtu = new zzdgk();
  private int zzgqk;
  private zzdmq zzgqs = zzdmq.zzhcr;
  private zzdgo zzgtt;

  static
  {
    zzdoa.zza(zzdgk.class, zzgtu);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  public static zza zzark()
  {
    return (zza)zzgtu.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdgk zzarl()
  {
    return zzgtu;
  }

  private final void zzb(zzdgo paramzzdgo)
  {
    if (paramzzdgo == null)
      throw new NullPointerException();
    this.zzgtt = paramzzdgo;
  }

  public static zzdgk zzbk(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdgk)zzdoa.zza(zzgtu, paramzzdmq);
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
    switch (zzdgl.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgk();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgtt", "zzgqs" };
        return zza(zzgtu, "", arrayOfObject);
        return zzgtu;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgtu);
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

  public final zzdgo zzarj()
  {
    if (this.zzgtt == null)
      return zzdgo.zzarr();
    return this.zzgtt;
  }

  public static final class zza extends zzdoa.zza<zzdgk, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzbl(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdgk.zza((zzdgk)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzc(zzdgo paramzzdgo)
    {
      zzaxw();
      zzdgk.zza((zzdgk)this.zzhhh, paramzzdgo);
      return this;
    }

    public final zza zzem(int paramInt)
    {
      zzaxw();
      zzdgk.zza((zzdgk)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgk
 * JD-Core Version:    0.6.2
 */