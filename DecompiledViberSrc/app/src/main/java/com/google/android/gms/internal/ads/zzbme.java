package com.google.android.gms.internal.ads;

public final class zzbme
  implements zzbrn
{
  private final zzcxn zzffb;
  private final zzcxt zzffc;
  private final zzdad zzffd;

  public zzbme(zzcxt paramzzcxt, zzdad paramzzdad)
  {
    this.zzffc = paramzzcxt;
    this.zzffd = paramzzdad;
    this.zzffb = paramzzcxt.zzgky.zzgku;
  }

  public final void onAdFailedToLoad(int paramInt)
  {
    this.zzffd.zza(this.zzffc, null, this.zzffb.zzdfj);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbme
 * JD-Core Version:    0.6.2
 */