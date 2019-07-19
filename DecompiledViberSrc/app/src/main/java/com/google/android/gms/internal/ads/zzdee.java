package com.google.android.gms.internal.ads;

public final class zzdee extends zzdoa<zzdee, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdee> zzdv;
  private static final zzdee zzgrf = new zzdee();
  private int zzgre;

  static
  {
    zzdoa.zza(zzdee.class, zzgrf);
  }

  public static zzdee zzaoz()
  {
    return zzgrf;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdef.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdee();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgre" };
        return zza(zzgrf, "", arrayOfObject);
        return zzgrf;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgrf);
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

  public final int zzaoy()
  {
    return this.zzgre;
  }

  public static final class zza extends zzdoa.zza<zzdee, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdee
 * JD-Core Version:    0.6.2
 */