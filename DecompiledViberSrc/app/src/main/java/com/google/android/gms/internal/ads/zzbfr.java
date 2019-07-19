package com.google.android.gms.internal.ads;

import android.os.Handler;
import com.google.android.gms.ads.internal.zzk;

@zzare
public final class zzbfr extends zzaww
{
  final zzbdg zzebv;
  private final String zzech;
  private final String[] zzeci;
  final zzbfu zzehs;

  zzbfr(zzbdg paramzzbdg, zzbfu paramzzbfu, String paramString, String[] paramArrayOfString)
  {
    this.zzebv = paramzzbdg;
    this.zzehs = paramzzbfu;
    this.zzech = paramString;
    this.zzeci = paramArrayOfString;
    zzk.zzmc().zza(this);
  }

  public final void zzto()
  {
    try
    {
      this.zzehs.zze(this.zzech, this.zzeci);
      return;
    }
    finally
    {
      zzaxj.zzdvx.post(new zzbfs(this));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbfr
 * JD-Core Version:    0.6.2
 */