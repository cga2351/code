package com.google.android.gms.internal.ads;

import java.util.List;

public final class zzdhn extends zzdoa<zzdhn, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdhn> zzdv;
  private static final zzdhn zzgvz = new zzdhn();
  private int zzdj;
  private String zzgvx = "";
  private zzdoi<zzdgx> zzgvy = zzaxs();

  static
  {
    zzdoa.zza(zzdhn.class, zzgvz);
  }

  private final void zza(zzdgx paramzzdgx)
  {
    if (paramzzdgx == null)
      throw new NullPointerException();
    zzdoi localzzdoi;
    int i;
    if (!this.zzgvy.zzavi())
    {
      localzzdoi = this.zzgvy;
      i = localzzdoi.size();
      if (i != 0)
        break label70;
    }
    label70: for (int j = 10; ; j = i << 1)
    {
      this.zzgvy = localzzdoi.zzfl(j);
      this.zzgvy.add(paramzzdgx);
      return;
    }
  }

  public static zza zzatk()
  {
    return (zza)zzgvz.zza(zzdoa.zze.zzhho, null, null);
  }

  private final void zzgr(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzgvx = paramString;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdho.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdhn();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzdj", "zzgvx", "zzgvy", zzdgx.class };
        return zza(zzgvz, "", arrayOfObject);
        return zzgvz;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgvz);
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

  public final List<zzdgx> zzatj()
  {
    return this.zzgvy;
  }

  public static final class zza extends zzdoa.zza<zzdhn, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdgx paramzzdgx)
    {
      zzaxw();
      zzdhn.zza((zzdhn)this.zzhhh, paramzzdgx);
      return this;
    }

    public final zza zzgs(String paramString)
    {
      zzaxw();
      zzdhn.zza((zzdhn)this.zzhhh, paramString);
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdhn
 * JD-Core Version:    0.6.2
 */