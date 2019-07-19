package com.google.android.gms.internal.ads;

public final class zzdfq extends zzdoa<zzdfq, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdfq> zzdv;
  private static final zzdfq zzgss = new zzdfq();
  private zzdfs zzgsr;

  static
  {
    zzdoa.zza(zzdfq.class, zzgss);
  }

  public static zzdfq zzaz(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdfq)zzdoa.zza(zzgss, paramzzdmq);
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdfr.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdfq();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgsr" };
        return zza(zzgss, "", arrayOfObject);
        return zzgss;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgss);
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

  public final zzdfs zzaqn()
  {
    if (this.zzgsr == null)
      return zzdfs.zzaqs();
    return this.zzgsr;
  }

  public static final class zza extends zzdoa.zza<zzdfq, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfq
 * JD-Core Version:    0.6.2
 */