package com.google.android.gms.internal.ads;

public final class zzdgo extends zzdoa<zzdgo, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgo> zzdv;
  private static final zzdgo zzgty = new zzdgo();
  private int zzgtw;
  private int zzgtx;

  static
  {
    zzdoa.zza(zzdgo.class, zzgty);
  }

  public static zzdgo zzarr()
  {
    return zzgty;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdgp.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgo();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgtw", "zzgtx" };
        return zza(zzgty, "", arrayOfObject);
        return zzgty;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgty);
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

  public final zzdgi zzarp()
  {
    zzdgi localzzdgi = zzdgi.zzel(this.zzgtw);
    if (localzzdgi == null)
      localzzdgi = zzdgi.zzgtr;
    return localzzdgi;
  }

  public final int zzarq()
  {
    return this.zzgtx;
  }

  public static final class zza extends zzdoa.zza<zzdgo, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgo
 * JD-Core Version:    0.6.2
 */