package com.google.android.gms.internal.ads;

public final class zzdgv extends zzdoa<zzdgv, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgv> zzdv;
  private static final zzdgv zzgur = new zzdgv();
  private String zzgtz = "";
  private zzdmq zzgua = zzdmq.zzhcr;
  private int zzguq;

  static
  {
    zzdoa.zza(zzdgv.class, zzgur);
  }

  public static zzdgv zzarz()
  {
    return zzgur;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdgw.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgv();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgtz", "zzgua", "zzguq" };
        return zza(zzgur, "", arrayOfObject);
        return zzgur;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgur);
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

  public final zzdmq zzaru()
  {
    return this.zzgua;
  }

  public static final class zza extends zzdoa.zza<zzdgv, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgv
 * JD-Core Version:    0.6.2
 */