package com.viber.voip.util.k;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.MailTo;
import android.net.Uri;
import android.net.http.SslError;
import android.support.v4.util.ObjectsCompat;
import android.text.TextUtils;
import android.webkit.SslErrorHandler;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.R.anim;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.api.scheme.i;
import com.viber.voip.banner.RemoteSplashActivity;
import com.viber.voip.market.t;
import com.viber.voip.market.u;
import com.viber.voip.util.ViberActionRunner;
import javax.security.cert.CertificateException;

public class b extends WebViewClient
{
  private static final Logger a = ViberEnv.getLogger();
  private Runnable b;

  public b()
  {
  }

  public b(Runnable paramRunnable)
  {
    this.b = paramRunnable;
  }

  private Intent a(String paramString1, String paramString2, String paramString3, String paramString4)
  {
    Intent localIntent = new Intent("android.intent.action.SEND");
    localIntent.putExtra("android.intent.extra.EMAIL", new String[] { paramString1 });
    localIntent.putExtra("android.intent.extra.TEXT", paramString3);
    localIntent.putExtra("android.intent.extra.SUBJECT", paramString2);
    localIntent.putExtra("android.intent.extra.CC", paramString4);
    localIntent.setType("message/rfc822");
    return localIntent;
  }

  private void a(String paramString, int paramInt, CharSequence paramCharSequence)
  {
  }

  private void a(boolean paramBoolean, SslErrorHandler paramSslErrorHandler, SslError paramSslError, Runnable paramRunnable)
  {
    if (paramBoolean)
      paramSslErrorHandler.cancel();
    while (paramRunnable == null)
      return;
    paramRunnable.run();
  }

  private boolean b(String paramString)
  {
    return (paramString.startsWith("http:")) || (paramString.startsWith("https:"));
  }

  private void c(WebView paramWebView, String paramString)
  {
    MailTo localMailTo = MailTo.parse(paramString);
    Intent localIntent = a(localMailTo.getTo(), localMailTo.getSubject(), localMailTo.getBody(), localMailTo.getCc());
    paramWebView.getContext().startActivity(localIntent);
  }

  protected void a(WebView paramWebView, String paramString)
  {
    Context localContext = paramWebView.getContext();
    Uri localUri = Uri.parse(paramString);
    Intent localIntent = new Intent("android.intent.action.VIEW", localUri);
    if (ViberActionRunner.a(localIntent, localContext))
    {
      localContext.startActivity(localIntent);
      if ((localContext instanceof Activity))
      {
        Activity localActivity = (Activity)localContext;
        if (!i.d(localUri))
          localActivity.finish();
        if ((localActivity instanceof RemoteSplashActivity))
          localActivity.overridePendingTransition(0, R.anim.non_flickering_sleep);
      }
    }
  }

  protected void a(String paramString, int paramInt)
  {
    ViberApplication.getInstance().logToCrashlytics(new CertificateException("SslError " + paramInt + " {" + paramString + "}"));
  }

  protected boolean a(String paramString)
  {
    return true;
  }

  protected boolean b(WebView paramWebView, String paramString)
  {
    if (paramWebView != null)
    {
      paramWebView.stopLoading();
      if (paramWebView.canGoBack())
        paramWebView.goBack();
    }
    return true;
  }

  protected boolean c(String paramString)
  {
    return true;
  }

  public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
  {
    if ((b(paramString)) && (!a(paramString)) && (b(paramWebView, paramString)));
    do
    {
      return;
      super.onPageStarted(paramWebView, paramString, paramBitmap);
    }
    while (!paramString.startsWith("viber://"));
    paramWebView.stopLoading();
    a(paramWebView, paramString);
  }

  public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
  {
    super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
    a(paramString2, paramInt, paramString1);
  }

  public void onReceivedError(WebView paramWebView, WebResourceRequest paramWebResourceRequest, WebResourceError paramWebResourceError)
  {
    super.onReceivedError(paramWebView, paramWebResourceRequest, paramWebResourceError);
    if (a.j())
      if (paramWebResourceRequest.getUrl() != null)
        break label41;
    label41: for (String str = "empty"; ; str = paramWebResourceRequest.getUrl().toString())
    {
      a(str, paramWebResourceError.getErrorCode(), paramWebResourceError.getDescription());
      return;
    }
  }

  public void onReceivedSslError(WebView paramWebView, SslErrorHandler paramSslErrorHandler, SslError paramSslError)
  {
    boolean bool1 = u.a();
    boolean bool2;
    if (!ObjectsCompat.equals(paramWebView.getUrl(), paramSslError.getUrl()))
    {
      bool2 = true;
      if ((bool2) && (!bool1))
        break label127;
      switch (paramSslError.getPrimaryError())
      {
      case 3:
      case 4:
      default:
      case 5:
      case 2:
      }
    }
    while (true)
    {
      a(bool2, paramSslErrorHandler, paramSslError, this.b);
      return;
      bool2 = false;
      break;
      c localc = new c(this, bool2, paramSslErrorHandler, paramSslError);
      t.a(paramWebView.getUrl(), paramSslErrorHandler, localc);
      return;
      a(paramWebView.getUrl(), paramSslError.getPrimaryError());
    }
    label127: if ((paramWebView != null) && (paramWebView.getUrl() != null) && (paramWebView.getUrl().contains("www.gettyimages.com")))
    {
      a(paramWebView.getUrl(), paramSslError.getPrimaryError());
      paramSslErrorHandler.proceed();
      return;
    }
    switch (paramSslError.getPrimaryError())
    {
    case 3:
    case 4:
    default:
    case 2:
    case 5:
    }
    while (true)
    {
      a(bool2, paramSslErrorHandler, paramSslError, this.b);
      return;
      a(paramWebView.getUrl(), paramSslError.getPrimaryError());
    }
  }

  public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
  {
    if ((!TextUtils.isEmpty(paramString)) && (paramString.startsWith("viber:")))
    {
      a(paramWebView, paramString);
      return true;
    }
    if ((b(paramString)) && (a(paramString)))
      return false;
    if ((!paramString.startsWith("tel:")) && (!a(paramString)))
      return c(paramString);
    if (paramString.startsWith("mailto:"))
    {
      c(paramWebView, paramString);
      return true;
    }
    Intent localIntent = new Intent("android.intent.action.VIEW").setData(Uri.parse(paramString));
    try
    {
      paramWebView.getContext().startActivity(localIntent);
      return true;
    }
    catch (ActivityNotFoundException localActivityNotFoundException)
    {
    }
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.k.b
 * JD-Core Version:    0.6.2
 */