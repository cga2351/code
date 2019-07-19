package com.google.android.gms.internal.ads;

public abstract class zzrp
{
  private zzrq zzblx;

  protected final void invalidate()
  {
    if (this.zzblx != null)
      this.zzblx.zzgv();
  }

  public abstract zzrr zza(zzlp[] paramArrayOfzzlp, zzrb paramzzrb)
    throws zzku;

  public final void zza(zzrq paramzzrq)
  {
    this.zzblx = paramzzrq;
  }

  public abstract void zzd(Object paramObject);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzrp
 * JD-Core Version:    0.6.2
 */