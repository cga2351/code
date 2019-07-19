package com.google.android.gms.internal.ads;

import java.util.Map;

public final class zzazb extends zzr<zzp>
{
  private final Map<String, String> zzab = null;
  private final zzbbs<zzp> zzdxq;
  private final zzazy zzdxr;

  public zzazb(String paramString, zzbbs<zzp> paramzzbbs)
  {
    this(paramString, null, paramzzbbs);
  }

  private zzazb(String paramString, Map<String, String> paramMap, zzbbs<zzp> paramzzbbs)
  {
    super(0, paramString, new zzazc(paramzzbbs));
    this.zzdxq = paramzzbbs;
    this.zzdxr = new zzazy();
    this.zzdxr.zza(paramString, "GET", null, null);
  }

  protected final zzy<zzp> zza(zzp paramzzp)
  {
    return zzy.zza(paramzzp, zzaq.zzb(paramzzp));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzazb
 * JD-Core Version:    0.6.2
 */