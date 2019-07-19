package com.google.android.gms.internal.ads;

public final class zzdat extends zzdoa<zzdat, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdat> zzdv;
  private static final zzdat zzgoq = new zzdat();
  private int zzdj;
  private String zzdk = "";
  private int zzgon;
  private String zzgoo = "";
  private zzdao zzgop;

  static
  {
    zzdoa.zza(zzdat.class, zzgoq);
  }

  private final void zza(zzdao.zzb paramzzb)
  {
    this.zzgop = ((zzdao)paramzzb.zzaya());
    this.zzdj = (0x8 | this.zzdj);
  }

  private final void zza(zzb paramzzb)
  {
    if (paramzzb == null)
      throw new NullPointerException();
    this.zzdj = (0x1 | this.zzdj);
    this.zzgon = paramzzb.zzac();
  }

  public static zza zzank()
  {
    return (zza)zzgoq.zza(zzdoa.zze.zzhho, null, null);
  }

  private final void zzi(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzdj = (0x2 | this.zzdj);
    this.zzdk = paramString;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdau.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdat();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = new Object[6];
        arrayOfObject[0] = "zzdj";
        arrayOfObject[1] = "zzgon";
        arrayOfObject[2] = zzb.zzad();
        arrayOfObject[3] = "zzdk";
        arrayOfObject[4] = "zzgoo";
        arrayOfObject[5] = "zzgop";
        return zza(zzgoq, "", arrayOfObject);
        return zzgoq;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgoq);
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

  public static final class zza extends zzdoa.zza<zzdat, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdao.zzb paramzzb)
    {
      zzaxw();
      zzdat.zza((zzdat)this.zzhhh, paramzzb);
      return this;
    }

    public final zza zzb(zzdat.zzb paramzzb)
    {
      zzaxw();
      zzdat.zza((zzdat)this.zzhhh, paramzzb);
      return this;
    }

    public final zza zzge(String paramString)
    {
      zzaxw();
      zzdat.zza((zzdat)this.zzhhh, paramString);
      return this;
    }
  }

  public static enum zzb
    implements zzdod
  {
    private static final zzdoe<zzb> zzeg = new zzdav();
    private final int value;

    static
    {
      zzb[] arrayOfzzb = new zzb[2];
      arrayOfzzb[0] = zzgor;
      arrayOfzzb[1] = zzgos;
      zzgot = arrayOfzzb;
    }

    private zzb(int paramInt)
    {
      this.value = paramInt;
    }

    public static zzdof zzad()
    {
      return zzdaw.zzei;
    }

    public static zzb zzdt(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 0:
        return zzgor;
      case 1:
      }
      return zzgos;
    }

    public final int zzac()
    {
      return this.value;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdat
 * JD-Core Version:    0.6.2
 */