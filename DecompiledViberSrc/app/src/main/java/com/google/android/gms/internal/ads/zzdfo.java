package com.google.android.gms.internal.ads;

public final class zzdfo extends zzdoa<zzdfo, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdfo> zzdv;
  private static final zzdfo zzgsq = new zzdfo();
  private zzdgv zzgsp;

  static
  {
    zzdoa.zza(zzdfo.class, zzgsq);
  }

  public static zzdfo zzaql()
  {
    return zzgsq;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdfp.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdfo();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgsp" };
        return zza(zzgsq, "", arrayOfObject);
        return zzgsq;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgsq);
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

  public final zzdgv zzaqk()
  {
    if (this.zzgsp == null)
      return zzdgv.zzarz();
    return this.zzgsp;
  }

  public static final class zza extends zzdoa.zza<zzdfo, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfo
 * JD-Core Version:    0.6.2
 */