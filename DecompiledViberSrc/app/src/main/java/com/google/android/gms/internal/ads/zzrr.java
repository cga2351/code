package com.google.android.gms.internal.ads;

public final class zzrr
{
  public final zzrb zzbly;
  public final zzro zzblz;
  public final Object zzbma;
  public final zzlq[] zzbmb;

  public zzrr(zzrb paramzzrb, zzro paramzzro, Object paramObject, zzlq[] paramArrayOfzzlq)
  {
    this.zzbly = paramzzrb;
    this.zzblz = paramzzro;
    this.zzbma = paramObject;
    this.zzbmb = paramArrayOfzzlq;
  }

  public final boolean zza(zzrr paramzzrr, int paramInt)
  {
    if (paramzzrr == null);
    while ((!zzsy.zza(this.zzblz.zzbi(paramInt), paramzzrr.zzblz.zzbi(paramInt))) || (!zzsy.zza(this.zzbmb[paramInt], paramzzrr.zzbmb[paramInt])))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrr
 * JD-Core Version:    0.6.2
 */