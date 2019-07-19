package com.google.android.gms.internal.ads;

public final class zzddq extends zzdoa<zzddq, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzddq> zzdv;
  private static final zzddq zzgqn = new zzddq();
  private int zzgqk;
  private zzdea zzgql;
  private zzdgk zzgqm;

  static
  {
    zzdoa.zza(zzddq.class, zzgqn);
  }

  private final void setVersion(int paramInt)
  {
    this.zzgqk = paramInt;
  }

  private final void zza(zzdea paramzzdea)
  {
    if (paramzzdea == null)
      throw new NullPointerException();
    this.zzgql = paramzzdea;
  }

  private final void zza(zzdgk paramzzdgk)
  {
    if (paramzzdgk == null)
      throw new NullPointerException();
    this.zzgqm = paramzzdgk;
  }

  public static zza zzaoc()
  {
    return (zza)zzgqn.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzddq zzu(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzddq)zzdoa.zza(zzgqn, paramzzdmq);
  }

  public final int getVersion()
  {
    return this.zzgqk;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzddr.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzddq();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqk", "zzgql", "zzgqm" };
        return zza(zzgqn, "", arrayOfObject);
        return zzgqn;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgqn);
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

  public final zzdea zzaoa()
  {
    if (this.zzgql == null)
      return zzdea.zzaou();
    return this.zzgql;
  }

  public final zzdgk zzaob()
  {
    if (this.zzgqm == null)
      return zzdgk.zzarl();
    return this.zzgqm;
  }

  public static final class zza extends zzdoa.zza<zzddq, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdea paramzzdea)
    {
      zzaxw();
      zzddq.zza((zzddq)this.zzhhh, paramzzdea);
      return this;
    }

    public final zza zzb(zzdgk paramzzdgk)
    {
      zzaxw();
      zzddq.zza((zzddq)this.zzhhh, paramzzdgk);
      return this;
    }

    public final zza zzdu(int paramInt)
    {
      zzaxw();
      zzddq.zza((zzddq)this.zzhhh, paramInt);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzddq
 * JD-Core Version:    0.6.2
 */