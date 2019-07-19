package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.net.http.SslError;
import android.view.KeyEvent;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import javax.annotation.ParametersAreNonnullByDefault;

@zzare
@ParametersAreNonnullByDefault
public class zzbja extends WebViewClient
{
  private static final String[] zzejd = { "UNKNOWN", "HOST_LOOKUP", "UNSUPPORTED_AUTH_SCHEME", "AUTHENTICATION", "PROXY_AUTHENTICATION", "CONNECT", "IO", "TIMEOUT", "REDIRECT_LOOP", "UNSUPPORTED_SCHEME", "FAILED_SSL_HANDSHAKE", "BAD_URL", "FILE", "FILE_NOT_FOUND", "TOO_MANY_REQUESTS" };
  private static final String[] zzeje = { "NOT_YET_VALID", "EXPIRED", "ID_MISMATCH", "UNTRUSTED", "DATE_INVALID", "INVALID" };
  private zzbjf zzems;

  public final void onLoadResource(WebView paramWebView, String paramString)
  {
    if (paramString == null)
      return;
    String str1 = String.valueOf(paramString);
    if (str1.length() != 0);
    for (String str2 = "Loading resource: ".concat(str1); ; str2 = new String("Loading resource: "))
    {
      zzaxa.zzds(str2);
      zzb(new zzbjb(paramString));
      return;
    }
  }

  public final void onPageFinished(WebView paramWebView, String paramString)
  {
    if (paramString == null)
      return;
    zzbjb localzzbjb = new zzbjb(paramString);
    if (this.zzems != null)
    {
      this.zzems.zza(localzzbjb);
      return;
    }
    zza(localzzbjb);
  }

  public final void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    if ((paramInt >= 0) || (-1 + -paramInt >= zzejd.length))
      String.valueOf(paramInt);
  }

  public final void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    if (paramSslError == null)
      return;
    int i = paramSslError.getPrimaryError();
    if ((i < 0) || (i >= zzeje.length))
      String.valueOf(i);
    paramSslError.getUrl();
  }

  @TargetApi(24)
  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      return null;
    return zzd(new zzbjb(paramWebResourceRequest));
  }

  public final WebResourceResponse shouldInterceptRequest(WebView paramWebView, String paramString)
  {
    if (paramString == null)
      return null;
    return zzd(new zzbjb(paramString));
  }

  public final boolean shouldOverrideKeyEvent(WebView paramWebView, KeyEvent paramKeyEvent)
  {
    switch (paramKeyEvent.getKeyCode())
    {
    default:
      return false;
    case 79:
    case 85:
    case 86:
    case 87:
    case 88:
    case 89:
    case 90:
    case 91:
    case 126:
    case 127:
    case 128:
    case 129:
    case 130:
    case 222:
    }
    return true;
  }

  @TargetApi(24)
  public final boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
  {
    if ((paramWebResourceRequest == null) || (paramWebResourceRequest.getUrl() == null))
      return false;
    return zzc(new zzbjb(paramWebResourceRequest));
  }

  public final boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if (paramString == null)
      return false;
    return zzc(new zzbjb(paramString));
  }

  public void zza(zzbjb paramzzbjb)
  {
  }

  final void zza(zzbjf paramzzbjf)
  {
    this.zzems = paramzzbjf;
  }

  public void zzb(zzbjb paramzzbjb)
  {
  }

  public boolean zzc(zzbjb paramzzbjb)
  {
    return false;
  }

  public WebResourceResponse zzd(zzbjb paramzzbjb)
  {
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbja
 * JD-Core Version:    0.6.2
 */