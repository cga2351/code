package com.google.android.gms.internal.ads;

public final class zzbko
{
  private zzbjo zzeon;
  private zzcyd zzfbx;
  private zzble zzfby;
  private zzbkx zzfbz;
  private zzdab zzfca;

  public final zzbko zza(zzbkx paramzzbkx)
  {
    this.zzfbz = ((zzbkx)zzdtn.checkNotNull(paramzzbkx));
    return this;
  }

  public final zzbjn zzaec()
  {
    if (this.zzfbx == null)
      this.zzfbx = new zzcyd();
    zzdtn.zza(this.zzeon, zzbjo.class);
    if (this.zzfby == null)
      this.zzfby = new zzble();
    zzdtn.zza(this.zzfbz, zzbkx.class);
    if (this.zzfca == null)
      this.zzfca = new zzdab();
    return new zzbkd(this.zzfbx, this.zzeon, this.zzfby, this.zzfbz, this.zzfca, null);
  }

  public final zzbko zzc(zzbjo paramzzbjo)
  {
    this.zzeon = ((zzbjo)zzdtn.checkNotNull(paramzzbjo));
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbko
 * JD-Core Version:    0.6.2
 */