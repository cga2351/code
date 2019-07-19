package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Build.VERSION;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.google.android.gms.ads.internal.zzk;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
class zzbiz extends WebView
{
  public zzbiz(Context paramContext)
  {
    super(paramContext);
    setBackgroundColor(0);
    WebSettings localWebSettings = getSettings();
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setSavePassword(false);
    localWebSettings.setSupportMultipleWindows(true);
    localWebSettings.setJavaScriptCanOpenWindowsAutomatically(true);
    if (Build.VERSION.SDK_INT >= 21)
      localWebSettings.setMixedContentMode(2);
    zzk.zzli().zza(getContext(), localWebSettings);
    removeJavascriptInterface("accessibility");
    removeJavascriptInterface("accessibilityTraversal");
    try
    {
      getSettings().setJavaScriptEnabled(true);
      setLayerType(1, null);
      return;
    }
    catch (NullPointerException localNullPointerException)
    {
      while (true)
        zzaxa.zzc("Unable to enable Javascript.", localNullPointerException);
    }
  }

  public void addJavascriptInterface(Object paramObject, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 17)
    {
      super.addJavascriptInterface(paramObject, paramString);
      return;
    }
    zzaxa.zzds("Ignore addJavascriptInterface due to low Android version.");
  }

  public void loadUrl(String paramString)
  {
    try
    {
      super.loadUrl(paramString);
      return;
    }
    catch (Exception localException)
    {
      zzk.zzlk().zza(localException, "CoreWebView.loadUrl");
      zzaxa.zze("#007 Could not call remote method.", localException);
      return;
    }
    catch (NoClassDefFoundError localNoClassDefFoundError)
    {
      break label7;
    }
    catch (IncompatibleClassChangeError localIncompatibleClassChangeError)
    {
      label7: break label7;
    }
  }

  public void zzco(String paramString)
  {
    zzbje.zza(this, paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbiz
 * JD-Core Version:    0.6.2
 */