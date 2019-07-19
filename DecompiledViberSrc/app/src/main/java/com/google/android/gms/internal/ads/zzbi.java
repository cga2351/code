package com.google.android.gms.internal.ads;

public final class zzbi
{
  public static final class zza extends zzdoa<zza, zza>
    implements zzdpl
  {
    private static final zza zzdu = new zza();
    private static volatile zzdpu<zza> zzdv;
    private int zzdj;
    private String zzdk = "";
    private long zzdl;
    private String zzdm = "";
    private String zzdn = "";
    private String zzdo = "";
    private long zzdp;
    private long zzdq;
    private String zzdr = "";
    private long zzds;
    private String zzdt = "";

    static
    {
      zzdoa.zza(zza.class, zzdu);
    }

    private final void zzc(long paramLong)
    {
      this.zzdj = (0x2 | this.zzdj);
      this.zzdl = paramLong;
    }

    private final void zzi(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.zzdj = (0x1 | this.zzdj);
      this.zzdk = paramString;
    }

    private final void zzj(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.zzdj = (0x4 | this.zzdj);
      this.zzdm = paramString;
    }

    private final void zzk(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException();
      this.zzdj = (0x8 | this.zzdj);
      this.zzdn = paramString;
    }

    public static zza zzs()
    {
      return (zza)zzdu.zza(zzdoa.zze.zzhho, null, null);
    }

    protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
    {
      Object localObject1;
      switch (zzbj.zzdi[(paramInt - 1)])
      {
      default:
        throw new UnsupportedOperationException();
      case 1:
        localObject1 = new zza();
      case 2:
      case 3:
      case 4:
      case 5:
        do
        {
          return localObject1;
          return new zza(null);
          Object[] arrayOfObject = { "zzdj", "zzdk", "zzdl", "zzdm", "zzdn", "zzdo", "zzdp", "zzdq", "zzdr", "zzds", "zzdt" };
          return zza(zzdu, "", arrayOfObject);
          return zzdu;
          localObject1 = zzdv;
        }
        while (localObject1 != null);
        try
        {
          Object localObject3 = zzdv;
          if (localObject3 == null)
          {
            localObject3 = new zzdoa.zzb(zzdu);
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

    public static final class zza extends zzdoa.zza<zzbi.zza, zza>
      implements zzdpl
    {
      private zza()
      {
        super();
      }

      public final zza zzd(long paramLong)
      {
        zzaxw();
        zzbi.zza.zza((zzbi.zza)this.zzhhh, paramLong);
        return this;
      }

      public final zza zzl(String paramString)
      {
        zzaxw();
        zzbi.zza.zza((zzbi.zza)this.zzhhh, paramString);
        return this;
      }

      public final zza zzm(String paramString)
      {
        zzaxw();
        zzbi.zza.zzb((zzbi.zza)this.zzhhh, paramString);
        return this;
      }

      public final zza zzn(String paramString)
      {
        zzaxw();
        zzbi.zza.zzc((zzbi.zza)this.zzhhh, paramString);
        return this;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbi
 * JD-Core Version:    0.6.2
 */