package com.google.android.gms.internal.ads;

public final class zzdgx extends zzdoa<zzdgx, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgx> zzdv;
  private static final zzdgx zzguw = new zzdgx();
  private String zzgtz = "";
  private String zzgus = "";
  private int zzgut;
  private boolean zzguu;
  private String zzguv = "";

  static
  {
    zzdoa.zza(zzdgx.class, zzguw);
  }

  public static zza zzasf()
  {
    return (zza)zzguw.zza(zzdoa.zze.zzhho, null, null);
  }

  private final void zzbd(boolean paramBoolean)
  {
    this.zzguu = paramBoolean;
  }

  private final void zzep(int paramInt)
  {
    this.zzgut = paramInt;
  }

  private final void zzgj(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzgtz = paramString;
  }

  private final void zzgl(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzgus = paramString;
  }

  private final void zzgm(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzguv = paramString;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdgy.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgx();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgus", "zzgtz", "zzgut", "zzguu", "zzguv" };
        return zza(zzguw, "", arrayOfObject);
        return zzguw;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzguw);
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

  public final String zzart()
  {
    return this.zzgtz;
  }

  public final String zzasb()
  {
    return this.zzgus;
  }

  public final int zzasc()
  {
    return this.zzgut;
  }

  public final boolean zzasd()
  {
    return this.zzguu;
  }

  public final String zzase()
  {
    return this.zzguv;
  }

  public static final class zza extends zzdoa.zza<zzdgx, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzbe(boolean paramBoolean)
    {
      zzaxw();
      zzdgx.zza((zzdgx)this.zzhhh, true);
      return this;
    }

    public final zza zzeq(int paramInt)
    {
      zzaxw();
      zzdgx.zza((zzdgx)this.zzhhh, 0);
      return this;
    }

    public final zza zzgn(String paramString)
    {
      zzaxw();
      zzdgx.zza((zzdgx)this.zzhhh, paramString);
      return this;
    }

    public final zza zzgo(String paramString)
    {
      zzaxw();
      zzdgx.zzb((zzdgx)this.zzhhh, paramString);
      return this;
    }

    public final zza zzgp(String paramString)
    {
      zzaxw();
      zzdgx.zzc((zzdgx)this.zzhhh, paramString);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgx
 * JD-Core Version:    0.6.2
 */