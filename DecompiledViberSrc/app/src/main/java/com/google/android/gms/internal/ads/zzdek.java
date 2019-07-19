package com.google.android.gms.internal.ads;

public final class zzdek extends zzdoa<zzdek, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdek> zzdv;
  private static final zzdek zzgrj = new zzdek();
  private int zzgre;

  static
  {
    zzdoa.zza(zzdek.class, zzgrj);
  }

  public static zzdek zzapf()
  {
    return zzgrj;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdel.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdek();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgre" };
        return zza(zzgrj, "", arrayOfObject);
        return zzgrj;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgrj);
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

  public static final class zza extends zzdoa.zza<zzdek, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdek
 * JD-Core Version:    0.6.2
 */