package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzk;
import java.io.File;
import java.util.Collections;
import java.util.Map;

@zzare
@TargetApi(11)
public class zzbib extends zzbhb
{
  public zzbib(zzbha paramzzbha, zzwh paramzzwh, boolean paramBoolean)
  {
    super(paramzzbha, paramzzwh, paramBoolean);
  }

  protected final WebResourceResponse zza(WebView paramWebView, String paramString, Map<String, String> paramMap)
  {
    if (!(paramWebView instanceof zzbha))
    {
      zzaxa.zzep("Tried to intercept request from a WebView that wasn't an AdWebView.");
      return null;
    }
    zzbha localzzbha = (zzbha)paramWebView;
    if (this.zzejo != null)
      this.zzejo.zza(paramString, paramMap, 1);
    if (!"mraid.js".equalsIgnoreCase(new File(paramString).getName()))
    {
      if (paramMap == null)
        paramMap = Collections.emptyMap();
      return super.zzd(paramString, paramMap);
    }
    if (localzzbha.zzaai() != null)
      localzzbha.zzaai().zzth();
    String str;
    if (localzzbha.zzaag().zzabx())
    {
      zzaci localzzaci3 = zzact.zzcmv;
      str = (String)zzyr.zzpe().zzd(localzzaci3);
    }
    while (true)
    {
      zzk.zzlg();
      return zzaxj.zzd(localzzbha.getContext(), localzzbha.zzyh().zzbsy, str);
      if (localzzbha.zzaan())
      {
        zzaci localzzaci2 = zzact.zzcmu;
        str = (String)zzyr.zzpe().zzd(localzzaci2);
      }
      else
      {
        zzaci localzzaci1 = zzact.zzcmt;
        str = (String)zzyr.zzpe().zzd(localzzaci1);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbib
 * JD-Core Version:    0.6.2
 */