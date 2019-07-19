package com.google.android.gms.internal.ads;

public final class zzdfs extends zzdoa<zzdfs, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdfs> zzdv;
  private static final zzdfs zzgsw = new zzdfs();
  private zzdfy zzgst;
  private zzdfo zzgsu;
  private int zzgsv;

  static
  {
    zzdoa.zza(zzdfs.class, zzgsw);
  }

  public static zzdfs zzaqs()
  {
    return zzgsw;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdft.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdfs();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgst", "zzgsu", "zzgsv" };
        return zza(zzgsw, "", arrayOfObject);
        return zzgsw;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgsw);
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

  public final zzdfy zzaqp()
  {
    if (this.zzgst == null)
      return zzdfy.zzarc();
    return this.zzgst;
  }

  public final zzdfo zzaqq()
  {
    if (this.zzgsu == null)
      return zzdfo.zzaql();
    return this.zzgsu;
  }

  public final zzdfc zzaqr()
  {
    zzdfc localzzdfc = zzdfc.zzec(this.zzgsv);
    if (localzzdfc == null)
      localzzdfc = zzdfc.zzgrx;
    return localzzdfc;
  }

  public static final class zza extends zzdoa.zza<zzdfs, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfs
 * JD-Core Version:    0.6.2
 */