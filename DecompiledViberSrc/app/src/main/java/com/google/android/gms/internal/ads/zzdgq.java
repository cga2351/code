package com.google.android.gms.internal.ads;

public final class zzdgq extends zzdoa<zzdgq, zza>
  implements zzdpl
{
  private static volatile zzdpu<zzdgq> zzdv;
  private static final zzdgq zzguc = new zzdgq();
  private String zzgtz = "";
  private zzdmq zzgua = zzdmq.zzhcr;
  private int zzgub;

  static
  {
    zzdoa.zza(zzdgq.class, zzguc);
  }

  private final void zza(zzb paramzzb)
  {
    if (paramzzb == null)
      throw new NullPointerException();
    this.zzgub = paramzzb.zzac();
  }

  public static zza zzarw()
  {
    return (zza)zzguc.zza(zzdoa.zze.zzhho, null, null);
  }

  public static zzdgq zzarx()
  {
    return zzguc;
  }

  private final void zzbn(zzdmq paramzzdmq)
  {
    if (paramzzdmq == null)
      throw new NullPointerException();
    this.zzgua = paramzzdmq;
  }

  private final void zzgj(String paramString)
  {
    if (paramString == null)
      throw new NullPointerException();
    this.zzgtz = paramString;
  }

  protected final Object zza(int paramInt, Object paramObject1, Object paramObject2)
  {
    Object localObject1;
    switch (zzdgr.zzdi[(paramInt - 1)])
    {
    default:
      throw new UnsupportedOperationException();
    case 1:
      localObject1 = new zzdgq();
    case 2:
    case 3:
    case 4:
    case 5:
      do
      {
        return localObject1;
        return new zza(null);
        Object[] arrayOfObject = { "zzgtz", "zzgua", "zzgub" };
        return zza(zzguc, "", arrayOfObject);
        return zzguc;
        localObject1 = zzdv;
      }
      while (localObject1 != null);
      try
      {
        Object localObject3 = zzdv;
        if (localObject3 == null)
        {
          localObject3 = new zzdoa.zzb(zzguc);
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

  public final String zzart()
  {
    return this.zzgtz;
  }

  public final zzdmq zzaru()
  {
    return this.zzgua;
  }

  public final zzb zzarv()
  {
    zzb localzzb = zzb.zzen(this.zzgub);
    if (localzzb == null)
      localzzb = zzb.zzgui;
    return localzzb;
  }

  public static final class zza extends zzdoa.zza<zzdgq, zza>
    implements zzdpl
  {
    private zza()
    {
      super();
    }

    public final zza zzb(zzdgq.zzb paramzzb)
    {
      zzaxw();
      zzdgq.zza((zzdgq)this.zzhhh, paramzzb);
      return this;
    }

    public final zza zzbo(zzdmq paramzzdmq)
    {
      zzaxw();
      zzdgq.zza((zzdgq)this.zzhhh, paramzzdmq);
      return this;
    }

    public final zza zzgk(String paramString)
    {
      zzaxw();
      zzdgq.zza((zzdgq)this.zzhhh, paramString);
      return this;
    }
  }

  public static enum zzb
    implements zzdod
  {
    private static final zzdoe<zzb> zzeg = new zzdgs();
    private final int value;

    static
    {
      zzb[] arrayOfzzb = new zzb[6];
      arrayOfzzb[0] = zzgud;
      arrayOfzzb[1] = zzgue;
      arrayOfzzb[2] = zzguf;
      arrayOfzzb[3] = zzgug;
      arrayOfzzb[4] = zzguh;
      arrayOfzzb[5] = zzgui;
      zzguj = arrayOfzzb;
    }

    private zzb(int paramInt)
    {
      this.value = paramInt;
    }

    public static zzb zzen(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return null;
      case 0:
        return zzgud;
      case 1:
        return zzgue;
      case 2:
        return zzguf;
      case 3:
        return zzgug;
      case 4:
      }
      return zzguh;
    }

    public final int zzac()
    {
      if (this == zzgui)
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
      return this.value;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzdgq
 * JD-Core Version:    0.6.2
 */