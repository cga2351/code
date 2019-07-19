package com.google.android.gms.internal.ads;

public final class zzdeu extends zzdoa<zzdeu, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdeu> zzdv;
  private static final zzdeu zzgrp = new zzdeu();
  private int zzgqu;

  static
  {
    zzdoa.zza(zzdeu.class, zzgrp);
  }

  public static zzdeu zzal(zzdmq paramzzdmq)
    throws zzdoj
  {
    return (zzdeu)zzdoa.zza(zzgrp, paramzzdmq);
  }

  public final int getKeySize()
  {
    return this.zzgqu;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdev.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdeu();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgqu" };
        return zza(zzgrp, "", arrayOfObject);
        return zzgrp;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgrp);
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

  public static final class zza extends zzdoa.zza<zzdeu, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdeu
 * JD-Core Version:    0.6.2
 */