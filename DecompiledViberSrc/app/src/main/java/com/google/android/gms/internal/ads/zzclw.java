package com.google.android.gms.internal.ads;

import java.util.List;
import org.json.JSONObject;

public final class zzclw
  implements zzclv<zzbym>
{
  private final zzbbm zzfqw;
  private final zzbxn zzgav;
  private final zzcap zzgaw;

  public zzclw(zzbxn paramzzbxn, zzbbm paramzzbbm, zzcap paramzzcap)
  {
    this.zzgav = paramzzbxn;
    this.zzfqw = paramzzbbm;
    this.zzgaw = paramzzcap;
  }

  private final zzbbi<zzbym> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl, JSONObject paramJSONObject)
  {
    zzbbi localzzbbi1 = this.zzgav.zzadc().zzamr();
    zzbbi localzzbbi2 = this.zzgaw.zza(paramzzcxt, paramzzcxl, paramJSONObject);
    return zzbas.zza(new zzbbi[] { localzzbbi1, localzzbbi2 }).zza(new zzcmb(this, localzzbbi2, localzzbbi1, paramzzcxt, paramzzcxl, paramJSONObject), this.zzfqw);
  }

  public final boolean zza(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    return (paramzzcxl.zzgke != null) && (paramzzcxl.zzgke.zzfmo != null);
  }

  public final zzbbi<List<zzbbi<zzbym>>> zzb(zzcxt paramzzcxt, zzcxl paramzzcxl)
  {
    zzbbi localzzbbi = this.zzgav.zzadc().zzamr();
    this.zzgav.zzadc().zza(localzzbbi);
    return zzbas.zza(zzbas.zza(localzzbbi, new zzclx(this, paramzzcxl), this.zzfqw), new zzcly(this, paramzzcxt, paramzzcxl), this.zzfqw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzclw
 * JD-Core Version:    0.6.2
 */