package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.Uri;

@zzare
@TargetApi(16)
public final class zzbgi extends zzbgm
{
  private final String mimeType = null;

  public zzbgi(zzbdg paramzzbdg, String paramString)
  {
    super(paramzzbdg);
  }

  protected final zzhn zzfa(String paramString)
  {
    zzjt localzzjt = new zzjt(this.mContext, this.zzdyd);
    zzaci localzzaci1 = zzact.zzcts;
    if (((Boolean)zzyr.zzpe().zzd(localzzaci1)).booleanValue());
    for (Object localObject1 = new zzbei(this.mContext, localzzjt, new zzbgj(this)); ; localObject1 = localzzjt)
    {
      if ("video/webm".equals(this.mimeType));
      for (Object localObject2 = new zzjg(); ; localObject2 = new zziv())
      {
        Uri localUri = Uri.parse(paramString);
        zzaci localzzaci2 = zzact.zzclx;
        return new zzig(localUri, (zzjp)localObject1, (zzid)localObject2, 2, ((Integer)zzyr.zzpe().zzd(localzzaci2)).intValue());
      }
    }
  }

  protected final int zzzw()
  {
    return 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbgi
 * JD-Core Version:    0.6.2
 */