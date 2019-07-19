package com.google.android.gms.internal.measurement;

public final class zzfe
{
  public static final class zza extends zzuo<zza, zza>
    implements zzvx
  {
    private static final zza zzauy = new zza();
    private static volatile zzwf<zza> zznw;
    private String zzauw = "";
    private long zzaux;
    private int zznr;

    static
    {
      zzuo.zza(zza.class, zzauy);
    }

    private final void setName(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.zznr = (0x1 | this.zznr);
      this.zzauw = paramString;
    }

    private final void zzam(long paramLong)
    {
      this.zznr = (0x2 | this.zznr);
      this.zzaux = paramLong;
    }

    public static zza zzmn()
    {
      return (zza)zzauy.zza(zzuo.zze.zzbyq, null, null);
    }

    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      Object localObject1;
      switch (zzff.zznq[(paramInt - 1)])
      {
      default:
        throw new UnsupportedOperationException();
      case 1:
        localObject1 = new zza();
      case 2:
      case 3:
      case 4:
      case 5:
        do
        {
          return localObject1;
          return new zza(null);
          Object[] arrayOfObject = { "zznr", "zzauw", "zzaux" };
          return zza(zzauy, "", arrayOfObject);
          return zzauy;
          localObject1 = zznw;
        }
        while (localObject1 != null);
        try
        {
          Object localObject3 = zznw;
          if (localObject3 == null)
          {
            localObject3 = new zzuo.zzb(zzauy);
            zznw = (zzwf)localObject3;
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

    public static final class zza extends zzuo.zza<zzfe.zza, zza>
      implements zzvx
    {
      private zza()
      {
        super();
      }

      public final zza zzan(long paramLong)
      {
        zzwk();
        zzfe.zza.zza((zzfe.zza)this.zzbyj, paramLong);
        return this;
      }

      public final zza zzda(String paramString)
      {
        zzwk();
        zzfe.zza.zza((zzfe.zza)this.zzbyj, paramString);
        return this;
      }
    }
  }

  public static final class zzb extends zzuo<zzb, zza>
    implements zzvx
  {
    private static final zzb zzavb = new zzb();
    private static volatile zzwf<zzb> zznw;
    private int zzauz = 1;
    private zzuu<zzfe.zza> zzava = zzwg();
    private int zznr;

    static
    {
      zzuo.zza(zzb.class, zzavb);
    }

    public static zzwf<zzb> zza()
    {
      return (zzwf)zzavb.zza(zzuo.zze.zzbys, null, null);
    }

    private final void zza(zzfe.zza paramzza)
    {
      if (paramzza == null)
        throw new NullPointerException();
      zzuu localzzuu;
      int i;
      if (!this.zzava.zztz())
      {
        localzzuu = this.zzava;
        i = localzzuu.size();
        if (i != 0)
          break label70;
      }
      label70: for (int j = 10; ; j = i << 1)
      {
        this.zzava = localzzuu.zzal(j);
        this.zzava.add(paramzza);
        return;
      }
    }

    public static zza zzmp()
    {
      return (zza)zzavb.zza(zzuo.zze.zzbyq, null, null);
    }

    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      Object localObject1;
      switch (zzff.zznq[(paramInt - 1)])
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
          Object[] arrayOfObject = new Object[5];
          arrayOfObject[0] = "zznr";
          arrayOfObject[1] = "zzauz";
          arrayOfObject[2] = zzb.zzd();
          arrayOfObject[3] = "zzava";
          arrayOfObject[4] = zzfe.zza.class;
          return zza(zzavb, "", arrayOfObject);
          return zzavb;
          localObject1 = zznw;
        }
        while (localObject1 != null);
        try
        {
          Object localObject3 = zznw;
          if (localObject3 == null)
          {
            localObject3 = new zzuo.zzb(zzavb);
            zznw = (zzwf)localObject3;
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

    public static final class zza extends zzuo.zza<zzfe.zzb, zza>
      implements zzvx
    {
      private zza()
      {
        super();
      }

      public final zza zzb(zzfe.zza paramzza)
      {
        zzwk();
        zzfe.zzb.zza((zzfe.zzb)this.zzbyj, paramzza);
        return this;
      }
    }

    public static enum zzb
      implements zzur
    {
      private static final zzus<zzb> zzoa = new zzfg();
      private final int value;

      static
      {
        zzb[] arrayOfzzb = new zzb[2];
        arrayOfzzb[0] = zzavc;
        arrayOfzzb[1] = zzavd;
      }

      private zzb(int paramInt)
      {
        this.value = paramInt;
      }

      public static zzut zzd()
      {
        return zzfh.zzoc;
      }

      public static zzb zzt(int paramInt)
      {
        switch (paramInt)
        {
        default:
          return null;
        case 1:
          return zzavc;
        case 2:
        }
        return zzavd;
      }

      public final int zzc()
      {
        return this.value;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.measurement.zzfe
 * JD-Core Version:    0.6.2
 */