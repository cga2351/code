package com.google.android.gms.internal.ads;

public final class zzdhb extends zzdoa<zzdhb, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdhb> zzdv;
  private static final zzdhb zzgvf = new zzdhb();
  private int zzdj;
  private int zzgux;
  private zzdoi<zzb> zzgve = zzaxs();

  static
  {
    zzdoa.zza(zzdhb.class, zzgvf);
  }

  private final void zza(zzb paramzzb)
  {
    if (paramzzb == null)
      throw new NullPointerException();
    zzdoi localzzdoi;
    int i;
    if (!this.zzgve.zzavi())
    {
      localzzdoi = this.zzgve;
      i = localzzdoi.size();
      if (i != 0)
        break label70;
    }
    label70: for (int j = 10; ; j = i << 1)
    {
      this.zzgve = localzzdoi.zzfl(j);
      this.zzgve.add(paramzzb);
      return;
    }
  }

  public static zza zzass()
  {
    return (zza)zzgvf.zza(zzdoa.zze.zzhho, null, null);
  }

  private final void zzer(int paramInt)
  {
    this.zzgux = paramInt;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdhc.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdhb();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzdj", "zzgux", "zzgve", zzb.class };
        return zza(zzgvf, "", arrayOfObject);
        return zzgvf;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgvf);
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

  public static final class zza extends zzdoa.zza<zzdhb, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdhb.zzb paramzzb)
    {
      zzaxw();
      zzdhb.zza((zzdhb)this.zzhhh, paramzzb);
      return this;
    }

    public final zza zzev(int paramInt)
    {
      zzaxw();
      zzdhb.zza((zzdhb)this.zzhhh, paramInt);
      return this;
    }
  }

  public static final class zzb extends zzdoa<zzb, zza>
    implements zzdpl
  {
    private static volatile zzdpu<zzb> zzdv;
    private static final zzb zzgvg = new zzb();
    private String zzgtz = "";
    private int zzguq;
    private int zzgvb;
    private int zzgvc;

    static
    {
      zzdoa.zza(zzb.class, zzgvg);
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

    public static zza zzasu()
    {
      return (zza)zzgvg.zza(zzdoa.zze.zzhho, null, null);
    }

    private final void zzet(int paramInt)
    {
      this.zzgvc = paramInt;
    }

    private final void zzgj(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.zzgtz = paramString;
    }

    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      Object localObject1;
      switch (zzdhc.zzdi[(paramInt - 1)])
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
          Object[] arrayOfObject = { "zzgtz", "zzgvb", "zzgvc", "zzguq" };
          return zza(zzgvg, "", arrayOfObject);
          return zzgvg;
          localObject1 = zzdv;
        }
        while (localObject1 != null);
        try
        {
          Object localObject3 = zzdv;
          if (localObject3 == null)
          {
            localObject3 = new zzdoa.zzb(zzgvg);
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

    public static final class zza extends zzdoa.zza<zzdhb.zzb, zza>
      implements zzdpl
    {
      private zza()
      {
        super();
      }

      public final zza zzc(zzdgt paramzzdgt)
      {
        zzaxw();
        zzdhb.zzb.zza((zzdhb.zzb)this.zzhhh, paramzzdgt);
        return this;
      }

      public final zza zzc(zzdhl paramzzdhl)
      {
        zzaxw();
        zzdhb.zzb.zza((zzdhb.zzb)this.zzhhh, paramzzdhl);
        return this;
      }

      public final zza zzew(int paramInt)
      {
        zzaxw();
        zzdhb.zzb.zza((zzdhb.zzb)this.zzhhh, paramInt);
        return this;
      }

      public final zza zzgq(String paramString)
      {
        zzaxw();
        zzdhb.zzb.zza((zzdhb.zzb)this.zzhhh, paramString);
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhb
 * JD-Core Version:    0.6.2
 */