package com.mopub.network;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build.VERSION;
import android.os.Looper;
import android.support.v4.util.LruCache;
import android.text.TextUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.volley.toolbox.BasicNetwork;
import com.mopub.volley.toolbox.DiskBasedCache;
import com.mopub.volley.toolbox.HurlStack.UrlRewriter;
import com.mopub.volley.toolbox.ImageLoader;
import com.mopub.volley.toolbox.ImageLoader.ImageCache;
import java.io.File;

public class Networking
{
  private static final String a;
  private static volatile MoPubRequestQueue b;
  private static volatile String c;
  private static volatile MaxWidthImageLoader d;
  private static boolean e;
  private static HurlStack.UrlRewriter f;

  static
  {
    Object localObject = "";
    try
    {
      String str = System.getProperty("http.agent", "");
      localObject = str;
      a = (String)localObject;
      e = false;
      return;
    }
    catch (SecurityException localSecurityException)
    {
      while (true)
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Unable to get system user agent." });
    }
  }

  @VisibleForTesting
  public static void clearForTesting()
  {
    try
    {
      b = null;
      d = null;
      c = null;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static String getBaseUrlScheme()
  {
    if (shouldUseHttps())
      return "https";
    return "http";
  }

  public static String getCachedUserAgent()
  {
    String str = c;
    if (str == null)
      str = a;
    return str;
  }

  public static ImageLoader getImageLoader(Context paramContext)
  {
    MaxWidthImageLoader localMaxWidthImageLoader1 = d;
    if (localMaxWidthImageLoader1 == null)
      try
      {
        MaxWidthImageLoader localMaxWidthImageLoader2 = d;
        if (localMaxWidthImageLoader2 == null)
        {
          localMaxWidthImageLoader2 = new MaxWidthImageLoader(getRequestQueue(paramContext), paramContext, new ImageLoader.ImageCache()
          {
            public Bitmap getBitmap(String paramAnonymousString)
            {
              return (Bitmap)this.a.get(paramAnonymousString);
            }

            public void putBitmap(String paramAnonymousString, Bitmap paramAnonymousBitmap)
            {
              this.a.put(paramAnonymousString, paramAnonymousBitmap);
            }
          });
          d = localMaxWidthImageLoader2;
        }
        return localMaxWidthImageLoader2;
      }
      finally
      {
      }
    return localMaxWidthImageLoader1;
  }

  public static MoPubRequestQueue getRequestQueue()
  {
    return b;
  }

  public static MoPubRequestQueue getRequestQueue(Context paramContext)
  {
    MoPubRequestQueue localMoPubRequestQueue1 = b;
    if (localMoPubRequestQueue1 == null)
      try
      {
        MoPubRequestQueue localMoPubRequestQueue2 = b;
        if (localMoPubRequestQueue2 == null)
        {
          CustomSSLSocketFactory localCustomSSLSocketFactory = CustomSSLSocketFactory.getDefault(10000);
          BasicNetwork localBasicNetwork = new BasicNetwork(new RequestQueueHttpStack(getUserAgent(paramContext.getApplicationContext()), getUrlRewriter(paramContext), localCustomSSLSocketFactory));
          File localFile = new File(paramContext.getCacheDir().getPath() + File.separator + "mopub-volley-cache");
          localMoPubRequestQueue2 = new MoPubRequestQueue(new DiskBasedCache(localFile, (int)DeviceUtils.diskCacheSizeBytes(localFile, 10485760L)), localBasicNetwork);
          b = localMoPubRequestQueue2;
          localMoPubRequestQueue2.start();
        }
        return localMoPubRequestQueue2;
      }
      finally
      {
      }
    return localMoPubRequestQueue1;
  }

  public static String getScheme()
  {
    return "https";
  }

  public static HurlStack.UrlRewriter getUrlRewriter(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    if (f == null)
      f = new PlayServicesUrlRewriter();
    return f;
  }

  public static String getUserAgent(Context paramContext)
  {
    Preconditions.checkNotNull(paramContext);
    String str1 = c;
    if (!TextUtils.isEmpty(str1))
      return str1;
    if (Looper.myLooper() != Looper.getMainLooper())
      return a;
    Object localObject = a;
    try
    {
      String str3;
      if (Build.VERSION.SDK_INT >= 17)
        str3 = WebSettings.getDefaultUserAgent(paramContext);
      String str2;
      for (localObject = str3; ; localObject = str2)
      {
        c = (String)localObject;
        return localObject;
        str2 = new WebView(paramContext).getSettings().getUserAgentString();
      }
    }
    catch (Exception localException)
    {
      while (true)
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Failed to get a user agent. Defaulting to the system user agent." });
    }
  }

  @VisibleForTesting
  public static void setImageLoaderForTesting(MaxWidthImageLoader paramMaxWidthImageLoader)
  {
    try
    {
      d = paramMaxWidthImageLoader;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @VisibleForTesting
  public static void setRequestQueueForTesting(MoPubRequestQueue paramMoPubRequestQueue)
  {
    try
    {
      b = paramMoPubRequestQueue;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @VisibleForTesting
  public static void setUserAgentForTesting(String paramString)
  {
    try
    {
      c = paramString;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public static boolean shouldUseHttps()
  {
    return e;
  }

  public static void useHttps(boolean paramBoolean)
  {
    e = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.Networking
 * JD-Core Version:    0.6.2
 */