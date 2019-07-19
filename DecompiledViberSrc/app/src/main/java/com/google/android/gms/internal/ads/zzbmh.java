package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import java.util.Map;

public final class zzbmh
{
  private final String zzbsx;
  private final zzalz zzffj;
  private zzbmm zzffk;
  private final zzahn<Object> zzffl = new zzbmi(this);
  private final zzahn<Object> zzffm = new zzbmj(this);

  public zzbmh(String paramString, zzalz paramzzalz)
  {
    this.zzbsx = paramString;
    this.zzffj = paramzzalz;
  }

  private final boolean zzl(Map<String, String> paramMap)
  {
    if (paramMap == null)
      return false;
    String str = (String)paramMap.get("hashCode");
    return (!TextUtils.isEmpty(str)) && (str.equals(this.zzbsx));
  }

  public final void zza(zzbmm paramzzbmm)
  {
    this.zzffj.zzc("/updateActiveView", this.zzffl);
    this.zzffj.zzc("/untrackActiveViewUnit", this.zzffm);
    this.zzffk = paramzzbmm;
  }

  public final void zzafc()
  {
    this.zzffj.zzd("/updateActiveView", this.zzffl);
    this.zzffj.zzd("/untrackActiveViewUnit", this.zzffm);
  }

  public final void zzd(zzbha paramzzbha)
  {
    paramzzbha.zza("/updateActiveView", this.zzffl);
    paramzzbha.zza("/untrackActiveViewUnit", this.zzffm);
  }

  public final void zze(zzbha paramzzbha)
  {
    paramzzbha.zzb("/updateActiveView", this.zzffl);
    paramzzbha.zzb("/untrackActiveViewUnit", this.zzffm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbmh
 * JD-Core Version:    0.6.2
 */