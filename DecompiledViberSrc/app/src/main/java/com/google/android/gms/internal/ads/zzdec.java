package com.google.android.gms.internal.ads;

public final class zzdec extends zzdoa<zzdec, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdec> zzdv;
  private static final zzdec zzgrd = new zzdec();
  private int zzgqu;
  private zzdee zzgrb;

  static
  {
    zzdoa.zza(zzdec.class, zzgrd);
  }

  public static zzdec zzac(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdec)zzdoa.zza(zzgrd, paramzzdmq);
  }

  public static zzdec zzaow()
  {
    return zzgrd;
  }

  public final int getKeySize()
  {
    return this.zzgqu;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzded.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdec();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgrb", "zzgqu" };
        return zza(zzgrd, "", arrayOfObject);
        return zzgrd;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgrd);
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

  public final zzdee zzaos()
  {
    if (this.zzgrb == null)
      return zzdee.zzaoz();
    return this.zzgrb;
  }

  public static final class zza extends zzdoa.zza<zzdec, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdec
 * JD-Core Version:    0.6.2
 */