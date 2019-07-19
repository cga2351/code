package com.google.android.gms.internal.ads;

public final class zzdgm extends zzdoa<zzdgm, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgm> zzdv;
  private static final zzdgm zzgtv = new zzdgm();
  private int zzgqu;
  private zzdgo zzgtt;

  static
  {
    zzdoa.zza(zzdgm.class, zzgtv);
  }

  public static zzdgm zzarn()
  {
    return zzgtv;
  }

  public static zzdgm zzbm(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdgm)zzdoa.zza(zzgtv, paramzzdmq);
  }

  public final int getKeySize()
  {
    return this.zzgqu;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdgn.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgm();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgtt", "zzgqu" };
        return zza(zzgtv, "", arrayOfObject);
        return zzgtv;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgtv);
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

  public final zzdgo zzarj()
  {
    if (this.zzgtt == null)
      return zzdgo.zzarr();
    return this.zzgtt;
  }

  public static final class zza extends zzdoa.zza<zzdgm, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgm
 * JD-Core Version:    0.6.2
 */