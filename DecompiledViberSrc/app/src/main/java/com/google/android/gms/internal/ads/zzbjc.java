package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.view.MotionEvent;
import android.webkit.ValueCallback;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@zzare
@ParametersAreNonnullByDefault
public class zzbjc extends zzbiz
  implements zzbjf
{

  @GuardedBy("this")
  private boolean zzela;

  @GuardedBy("this")
  private boolean zzels;
  private final zzbja zzemt;

  public zzbjc(Context paramContext, zzbja paramzzbja)
  {
    super(paramContext);
    zzk.zzlk().zzuz();
    this.zzemt = paramzzbja;
    super.setWebViewClient(paramzzbja);
  }

  private final void zzva()
  {
    try
    {
      if (!this.zzels)
      {
        this.zzels = true;
        zzk.zzlk().zzva();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void destroy()
  {
    try
    {
      boolean bool = this.zzela;
      if (bool);
      while (true)
      {
        return;
        this.zzela = true;
        this.zzemt.zza(this);
        zzaw(false);
        zzaxa.zzds("Initiating WebView self destruct sequence in 3...");
        zzaxa.zzds("Loading blank page in WebView, 2...");
        try
        {
          super.loadUrl("about:blank");
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          zzk.zzlk().zza(localUnsatisfiedLinkError, "AdWebViewImpl.loadUrlUnsafe");
          zzaxa.zze("#007 Could not call remote method.", localUnsatisfiedLinkError);
        }
      }
    }
    finally
    {
    }
  }

  @TargetApi(19)
  public void evaluateJavascript(String paramString, ValueCallback<String> paramValueCallback)
  {
    try
    {
      if (isDestroyed())
      {
        zzaxa.zzep("#004 The webview is destroyed. Ignoring action.");
        if (paramValueCallback != null)
          paramValueCallback.onReceiveValue(null);
      }
      while (true)
      {
        return;
        super.evaluateJavascript(paramString, paramValueCallback);
      }
    }
    finally
    {
    }
  }

  protected void finalize()
    throws Throwable
  {
    try
    {
      try
      {
        if (!isDestroyed())
          zzaw(true);
        zzva();
        return;
      }
      finally
      {
      }
    }
    finally
    {
      super.finalize();
    }
  }

  public final boolean isDestroyed()
  {
    try
    {
      boolean bool = this.zzela;
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void loadData(String paramString1, String paramString2, String paramString3)
  {
    try
    {
      if (!isDestroyed())
        super.loadData(paramString1, paramString2, paramString3);
      while (true)
      {
        return;
        zzaxa.zzep("#004 The webview is destroyed. Ignoring action.");
      }
    }
    finally
    {
    }
  }

  public void loadDataWithBaseURL(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5)
  {
    try
    {
      if (!isDestroyed())
        super.loadDataWithBaseURL(paramString1, paramString2, paramString3, paramString4, paramString5);
      while (true)
      {
        return;
        zzaxa.zzep("#004 The webview is destroyed. Ignoring action.");
      }
    }
    finally
    {
    }
  }

  public void loadUrl(String paramString)
  {
    try
    {
      if (!isDestroyed())
        super.loadUrl(paramString);
      while (true)
      {
        return;
        zzaxa.zzep("#004 The webview is destroyed. Ignoring action.");
      }
    }
    finally
    {
    }
  }

  @TargetApi(21)
  protected void onDraw(Canvas paramCanvas)
  {
    if (isDestroyed())
      return;
    super.onDraw(paramCanvas);
  }

  public void onPause()
  {
    if (isDestroyed())
      return;
    super.onPause();
  }

  public void onResume()
  {
    if (isDestroyed())
      return;
    super.onResume();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    return (!isDestroyed()) && (super.onTouchEvent(paramMotionEvent));
  }

  public void setWebViewClient(WebViewClient paramWebViewClient)
  {
  }

  public void stopLoading()
  {
    if (isDestroyed())
      return;
    super.stopLoading();
  }

  public final void zza(zzbjb paramzzbjb)
  {
    try
    {
      zzaxa.zzds("Blank page loaded, 1...");
      zzaao();
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @VisibleForTesting
  protected void zzaao()
  {
    try
    {
      zzaxa.zzds("Destroying WebView!");
      zzva();
      zzbbn.zzeag.execute(new zzbjd(this));
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @GuardedBy("this")
  protected void zzaw(boolean paramBoolean)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.internal.ads.zzbjc
 * JD-Core Version:    0.6.2
 */