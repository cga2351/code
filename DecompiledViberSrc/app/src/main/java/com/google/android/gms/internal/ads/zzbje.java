package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.webkit.WebView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.concurrent.GuardedBy;

@zzare
final class zzbje
{

  @VisibleForTesting
  @GuardedBy("InvokeJavascriptWorkaround.class")
  private static Boolean zzemv;

  @TargetApi(19)
  static void zza(WebView paramWebView, String paramString)
  {
    if ((PlatformVersion.isAtLeastKitKat()) && (zzb(paramWebView)))
    {
      paramWebView.evaluateJavascript(paramString, null);
      return;
    }
    String str1 = String.valueOf(paramString);
    if (str1.length() != 0);
    for (String str2 = "javascript:".concat(str1); ; str2 = new String("javascript:"))
    {
      paramWebView.loadUrl(str2);
      return;
    }
  }

  @TargetApi(19)
  private static boolean zzb(WebView paramWebView)
  {
    try
    {
      Boolean localBoolean = zzemv;
      if (localBoolean == null);
      try
      {
        paramWebView.evaluateJavascript("(function(){})()", null);
        zzemv = Boolean.valueOf(true);
        boolean bool = zzemv.booleanValue();
        return bool;
      }
      catch (IllegalStateException localIllegalStateException)
      {
        while (true)
          zzemv = Boolean.valueOf(false);
      }
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbje
 * JD-Core Version:    0.6.2
 */