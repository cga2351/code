package com.google.android.gms.internal.ads;

final class zzbgn
  implements zzbdp
{
  zzbgn(zzbgm paramzzbgm)
  {
  }

  public final void zzl(String paramString1, String paramString2)
  {
    zzbgm localzzbgm = this.zzeis;
    String str1 = String.valueOf(paramString1);
    if (str1.length() != 0);
    for (String str2 = "ExoPlayer caching failed. Type: ".concat(str1); ; str2 = new String("ExoPlayer caching failed. Type: "))
    {
      zzbgm.zza(localzzbgm, str2);
      zzaxa.zzep(46 + String.valueOf(paramString1).length() + String.valueOf(paramString2).length() + "ExoPlayer failed during precache: " + paramString1 + " Exception: " + paramString2);
      this.zzeis.abort();
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgn
 * JD-Core Version:    0.6.2
 */