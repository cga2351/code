package com.google.android.gms.internal.ads;

public final class zzdgg extends zzdoa<zzdgg, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgg> zzdv;
  private static final zzdgg zzgtm = new zzdgg();

  static
  {
    zzdoa.zza(zzdgg.class, zzgtm);
  }

  public static zzdgg zzbj(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdgg)zzdoa.zza(zzgtm, paramzzdmq);
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdgh.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgg();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        return zza(zzgtm, "", null);
        return zzgtm;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgtm);
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

  public static final class zza extends zzdoa.zza<zzdgg, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgg
 * JD-Core Version:    0.6.2
 */