package com.mopub.mobileads;

import android.annotation.SuppressLint;
import android.os.Handler;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mraid.MraidController;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class WebViewCacheService
{

  @VisibleForTesting
  static final a a = new a(null);

  @SuppressLint({"UseSparseArrays"})
  private static final Map<Long, Config> b = Collections.synchronizedMap(new HashMap());
  private static Handler c = new Handler();

  @VisibleForTesting
  static void a()
  {
    try
    {
      Iterator localIterator = b.entrySet().iterator();
      while (localIterator.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)localIterator.next();
        if (((Config)localEntry.getValue()).getWeakInterstitial().get() == null)
        {
          ((Config)localEntry.getValue()).getViewabilityManager().endDisplaySession();
          localIterator.remove();
        }
      }
    }
    finally
    {
    }
    if (!b.isEmpty())
    {
      c.removeCallbacks(a);
      c.postDelayed(a, 900000L);
    }
  }

  @Deprecated
  @VisibleForTesting
  public static void clearAll()
  {
    b.clear();
    c.removeCallbacks(a);
  }

  public static Config popWebViewConfig(Long paramLong)
  {
    Preconditions.checkNotNull(paramLong);
    return (Config)b.remove(paramLong);
  }

  @VisibleForTesting
  public static void storeWebViewConfig(Long paramLong, Interstitial paramInterstitial, BaseWebView paramBaseWebView, ExternalViewabilitySessionManager paramExternalViewabilitySessionManager, MraidController paramMraidController)
  {
    Preconditions.checkNotNull(paramLong);
    Preconditions.checkNotNull(paramInterstitial);
    Preconditions.checkNotNull(paramBaseWebView);
    a();
    if (b.size() >= 50)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to cache web view. Please destroy some via MoPubInterstitial#destroy() and try again." });
      return;
    }
    b.put(paramLong, new Config(paramBaseWebView, paramInterstitial, paramExternalViewabilitySessionManager, paramMraidController));
  }

  public static class Config
  {
    private final BaseWebView a;
    private final WeakReference<Interstitial> b;
    private final ExternalViewabilitySessionManager c;
    private final MraidController d;

    Config(BaseWebView paramBaseWebView, Interstitial paramInterstitial, ExternalViewabilitySessionManager paramExternalViewabilitySessionManager, MraidController paramMraidController)
    {
      this.a = paramBaseWebView;
      this.b = new WeakReference(paramInterstitial);
      this.c = paramExternalViewabilitySessionManager;
      this.d = paramMraidController;
    }

    public MraidController getController()
    {
      return this.d;
    }

    public ExternalViewabilitySessionManager getViewabilityManager()
    {
      return this.c;
    }

    public WeakReference<Interstitial> getWeakInterstitial()
    {
      return this.b;
    }

    public BaseWebView getWebView()
    {
      return this.a;
    }
  }

  private static class a
    implements Runnable
  {
    public void run()
    {
      WebViewCacheService.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mobileads.WebViewCacheService
 * JD-Core Version:    0.6.2
 */