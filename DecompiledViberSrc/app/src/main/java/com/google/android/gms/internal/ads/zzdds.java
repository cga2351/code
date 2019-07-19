package com.google.android.gms.internal.ads;

public final class zzdds extends zzdoa<zzdds, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdds> zzdv;
  private static final zzdds zzgqq = new zzdds();
  private zzdec zzgqo;
  private zzdgm zzgqp;

  static
  {
    zzdoa.zza(zzdds.class, zzgqq);
  }

  public static zzdds zzv(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdds)zzdoa.zza(zzgqq, paramzzdmq);
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzddt.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdds();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqo", "zzgqp" };
        return zza(zzgqq, "", arrayOfObject);
        return zzgqq;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgqq);
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

  public final zzdec zzaoe()
  {
    if (this.zzgqo == null)
      return zzdec.zzaow();
    return this.zzgqo;
  }

  public final zzdgm zzaof()
  {
    if (this.zzgqp == null)
      return zzdgm.zzarn();
    return this.zzgqp;
  }

  public static final class zza extends zzdoa.zza<zzdds, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdds
 * JD-Core Version:    0.6.2
 */