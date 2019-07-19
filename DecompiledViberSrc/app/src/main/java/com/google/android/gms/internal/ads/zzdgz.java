package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzdgz extends zzdoa<zzdgz, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgz> zzdv;
  private static final zzdgz zzguz = new zzdgz();
  private int zzdj;
  private int zzgux;
  private zzdoi<zzb> zzguy = zzaxs();

  static
  {
    zzdoa.zza(zzdgz.class, zzguz);
  }

  private final void zza(zzb paramzzb)
  {
    if (paramzzb == null)
      throw new NullPointerException();
    zzdoi localzzdoi;
    int i;
    if (!this.zzguy.zzavi())
    {
      localzzdoi = this.zzguy;
      i = localzzdoi.size();
      if (i != 0)
        break label70;
    }
    label70: for (int j = 10; ; j = i << 1)
    {
      this.zzguy = localzzdoi.zzfl(j);
      this.zzguy.add(paramzzb);
      return;
    }
  }

  public static zza zzask()
  {
    return (zza)zzguz.zza(zzdoa.zze.zzhho, null, null);
  }

  private final void zzer(int paramInt)
  {
    this.zzgux = paramInt;
  }

  public static zzdgz zzn(byte[] paramArrayOfByte)
    throws zzdoj
  {
    return (zzdgz)zzdoa.zza(zzguz, paramArrayOfByte);
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdha.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgz();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzdj", "zzgux", "zzguy", zzb.class };
        return zza(zzguz, "", arrayOfObject);
        return zzguz;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzguz);
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

  public final int zzash()
  {
    return this.zzgux;
  }

  public final List<zzb> zzasi()
  {
    return this.zzguy;
  }

  public final int zzasj()
  {
    return this.zzguy.size();
  }

  public static final class zza extends zzdoa.zza<zzdgz, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdgz.zzb paramzzb)
    {
      zzaxw();
      zzdgz.zza((zzdgz)this.zzhhh, paramzzb);
      return this;
    }

    public final zza zzes(int paramInt)
    {
      zzaxw();
      zzdgz.zza((zzdgz)this.zzhhh, paramInt);
      return this;
    }
  }

  public static final class zzb extends zzdoa<zzb, zza>
    implements zzdpl
  {
    private static volatile zzdpu<zzb> zzdv;
    private static final zzb zzgvd = new zzb();
    private int zzguq;
    private zzdgq zzgva;
    private int zzgvb;
    private int zzgvc;

    static
    {
      zzdoa.zza(zzb.class, zzgvd);
    }

    private final void zza(zzdgq paramzzdgq)
    {
      if (paramzzdgq == null)
        throw new NullPointerException();
      this.zzgva = paramzzdgq;
    }

    private final void zza(zzdgt paramzzdgt)
    {
      if (paramzzdgt == null)
        throw new NullPointerException();
      this.zzgvb = paramzzdgt.zzac();
    }

    private final void zza(zzdhl paramzzdhl)
    {
      if (paramzzdhl == null)
        throw new NullPointerException();
      this.zzguq = paramzzdhl.zzac();
    }

    public static zza zzasq()
    {
      return (zza)zzgvd.zza(zzdoa.zze.zzhho, null, null);
    }

    private final void zzet(int paramInt)
    {
      this.zzgvc = paramInt;
    }

    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      Object localObject1;
      switch (zzdha.zzdi[(paramInt - 1)])
      {
      default:
        throw new UnsupportedOperationException();
      case 1:
        localObject1 = new zzb();
      case 2:
      case 3:
      case 4:
      case 5:
        do
        {
          return localObject1;
          return new zza(null);
          Object[] arrayOfObject = { "zzgva", "zzgvb", "zzgvc", "zzguq" };
          return zza(zzgvd, "", arrayOfObject);
          return zzgvd;
          localObject1 = zzdv;
        }
        while (localObject1 != null);
        try
        {
          Object localObject3 = zzdv;
          if (localObject3 == null)
          {
            localObject3 = new zzdoa.zzb(zzgvd);
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

    public final zzdhl zzanw()
    {
      zzdhl localzzdhl = zzdhl.zzez(this.zzguq);
      if (localzzdhl == null)
        localzzdhl = zzdhl.zzgvv;
      return localzzdhl;
    }

    public final boolean zzasm()
    {
      return this.zzgva != null;
    }

    public final zzdgq zzasn()
    {
      if (this.zzgva == null)
        return zzdgq.zzarx();
      return this.zzgva;
    }

    public final zzdgt zzaso()
    {
      zzdgt localzzdgt = zzdgt.zzeo(this.zzgvb);
      if (localzzdgt == null)
        localzzdgt = zzdgt.zzguo;
      return localzzdgt;
    }

    public final int zzasp()
    {
      return this.zzgvc;
    }

    public static final class zza extends zzdoa.zza<zzdgz.zzb, zza>
      implements zzdpl
    {
      private zza()
      {
        super();
      }

      public final zza zzb(zzdgq paramzzdgq)
      {
        zzaxw();
        zzdgz.zzb.zza((zzdgz.zzb)this.zzhhh, paramzzdgq);
        return this;
      }

      public final zza zzb(zzdgt paramzzdgt)
      {
        zzaxw();
        zzdgz.zzb.zza((zzdgz.zzb)this.zzhhh, paramzzdgt);
        return this;
      }

      public final zza zzb(zzdhl paramzzdhl)
      {
        zzaxw();
        zzdgz.zzb.zza((zzdgz.zzb)this.zzhhh, paramzzdhl);
        return this;
      }

      public final zza zzeu(int paramInt)
      {
        zzaxw();
        zzdgz.zzb.zza((zzdgz.zzb)this.zzhhh, paramInt);
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgz
 * JD-Core Version:    0.6.2
 */