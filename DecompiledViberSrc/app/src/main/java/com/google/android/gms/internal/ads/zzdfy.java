package com.google.android.gms.internal.ads;

public final class zzdfy extends zzdoa<zzdfy, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdfy> zzdv;
  private static final zzdfy zzgtc = new zzdfy();
  private int zzgqy;
  private int zzgta;
  private zzdmq zzgtb = zzdmq.zzhcr;

  static
  {
    zzdoa.zza(zzdfy.class, zzgtc);
  }

  public static zzdfy zzarc()
  {
    return zzgtc;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdfz.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdfy();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgta", "zzgqy", "zzgtb" };
        return zza(zzgtc, "", arrayOfObject);
        return zzgtc;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzgtc);
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

  public final zzdgi zzaoo()
  {
    zzdgi localzzdgi = zzdgi.zzel(this.zzgqy);
    if (localzzdgi == null)
      localzzdgi = zzdgi.zzgtr;
    return localzzdgi;
  }

  public final zzdge zzara()
  {
    zzdge localzzdge = zzdge.zzek(this.zzgta);
    if (localzzdge == null)
      localzzdge = zzdge.zzgtk;
    return localzzdge;
  }

  public final zzdmq zzarb()
  {
    return this.zzgtb;
  }

  public static final class zza extends zzdoa.zza<zzdfy, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdfy
 * JD-Core Version:    0.6.2
 */