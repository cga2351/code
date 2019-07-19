package com.google.android.gms.internal.ads;

public final class zzdhh extends zzdoa<zzdhh, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdhh> zzdv;
  private static final zzdhh zzgvm = new zzdhh();
  private int zzgqk;
  private zzdhj zzgvl;

  static
  {
    zzdoa.zza(zzdhh.class, zzgvm);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  private final void zza(zzdhj paramzzdhj)
  {
    if (paramzzdhj == null)
      throw new NullPointerException();
    this.zzgvl = paramzzdhj;
  }

  public static zza zzatd()
  {
    return (zza)zzgvm.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdhh zzbr(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdhh)zzdoa.zza(zzgvm, paramzzdmq);
  }

  public final int getVersion()
  {
    return this.zzgqk;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdhi.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdhh();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgvl" };
        return zza(zzgvm, "", arrayOfObject);
        return zzgvm;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgvm);
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

  public final zzdhj zzatc()
  {
    if (this.zzgvl == null)
      return zzdhj.zzath();
    return this.zzgvl;
  }

  public static final class zza extends zzdoa.zza<zzdhh, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdhj paramzzdhj)
    {
      zzaxw();
      zzdhh.zza((zzdhh)this.zzhhh, paramzzdhj);
      return this;
    }

    public final zza zzey(int paramInt)
    {
      zzaxw();
      zzdhh.zza((zzdhh)this.zzhhh, 0);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhh
 * JD-Core Version:    0.6.2
 */