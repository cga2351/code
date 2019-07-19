package com.google.android.gms.internal.ads;

public final class zzdao extends zzdoa<zzdao, zzb>
  implements zzdpl
{
  private static volatile zzdpu<zzdao> zzdv;
  private static final zzdoh<Integer, zza> zzgof = new zzdap();
  private static final zzdao zzgoj = new zzdao();
  private int zzdj;
  private zzdog zzgoe = zzaxr();
  private String zzgog = "";
  private String zzgoh = "";
  private String zzgoi = "";

  static
  {
    zzdoa.zza(zzdao.class, zzgoj);
  }

  private final void zza(zza paramzza)
  {
    if (paramzza == null)
      throw new NullPointerException();
    zzdog localzzdog;
    int i;
    if (!this.zzgoe.zzavi())
    {
      localzzdog = this.zzgoe;
      i = localzzdog.size();
      if (i != 0)
        break label70;
    }
    label70: for (int j = 10; ; j = i << 1)
    {
      this.zzgoe = localzzdog.zzgo(j);
      this.zzgoe.zzgp(paramzza.zzac());
      return;
    }
  }

  public static zzb zzani()
  {
    return (zzb)zzgoj.zza(zzdoa.zze.zzhho, null, null);
  }

  private final void zzgc(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzdj = (0x1 | this.zzdj);
    this.zzgog = paramString;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdaq.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdao();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zzb(null);
        Object[] arrayOfObject = new Object[6];
        arrayOfObject[0] = "zzdj";
        arrayOfObject[1] = "zzgoe";
        arrayOfObject[2] = zza.zzad();
        arrayOfObject[3] = "zzgog";
        arrayOfObject[4] = "zzgoh";
        arrayOfObject[5] = "zzgoi";
        return zza(zzgoj, "", arrayOfObject);
        return zzgoj;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgoj);
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

  public static enum zza
    implements zzdod
  {
    private static final zzdoe<zza> zzeg = new zzdar();
    private final int value;

    static
    {
      zza[] arrayOfzza = new zza[2];
      arrayOfzza[0] = zzgok;
      arrayOfzza[1] = zzgol;
      zzgom = arrayOfzza;
    }

    private zza(int paramInt)
    {
      this.value = paramInt;
    }

    public static zzdof zzad()
    {
      return zzdas.zzei;
    }

    public static zza zzds(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 1:
        return zzgok;
      case 2:
      }
      return zzgol;
    }

    public final int zzac()
    {
      return this.value;
    }
  }

  public static final class zzb extends zzdoa.zza<zzdao, zzb>
    implements zzdpl
  {
    private zzb()
    {
      super();
    }

    public final zzb zzb(zzdao.zza paramzza)
    {
      zzaxw();
      zzdao.zza((zzdao)this.zzhhh, paramzza);
      return this;
    }

    public final zzb zzgd(String paramString)
    {
      zzaxw();
      zzdao.zza((zzdao)this.zzhhh, paramString);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdao
 * JD-Core Version:    0.6.2
 */