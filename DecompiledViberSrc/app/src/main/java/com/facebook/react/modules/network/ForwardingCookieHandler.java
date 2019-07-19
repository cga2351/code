package com.facebook.react.modules.network;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.ValueCallback;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedAsyncTask;
import com.facebook.react.bridge.GuardedResultAsyncTask;
import com.facebook.react.bridge.ReactContext;
import java.io.IOException;
import java.net.CookieHandler;
import java.net.URI;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

public class ForwardingCookieHandler extends CookieHandler
{
  private static final String COOKIE_HEADER = "Cookie";
  private static final boolean USES_LEGACY_STORE = false;
  private static final String VERSION_ONE_HEADER = "Set-cookie2";
  private static final String VERSION_ZERO_HEADER = "Set-cookie";
  private final ReactContext mContext;

  @Nullable
  private CookieManager mCookieManager;
  private final CookieSaver mCookieSaver;

  static
  {
    if (Build.VERSION.SDK_INT < 21);
    for (boolean bool = true; ; bool = false)
    {
      USES_LEGACY_STORE = bool;
      return;
    }
  }

  public ForwardingCookieHandler(ReactContext paramReactContext)
  {
    this.mContext = paramReactContext;
    this.mCookieSaver = new CookieSaver();
  }

  @TargetApi(21)
  private void addCookieAsync(String paramString1, String paramString2)
  {
    CookieManager localCookieManager = getCookieManager();
    if (localCookieManager != null)
      localCookieManager.setCookie(paramString1, paramString2, null);
  }

  private void addCookies(final String paramString, final List<String> paramList)
  {
    final CookieManager localCookieManager = getCookieManager();
    if (localCookieManager == null)
      return;
    if (USES_LEGACY_STORE)
    {
      runInBackground(new Runnable()
      {
        public void run()
        {
          Iterator localIterator = paramList.iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            localCookieManager.setCookie(paramString, str);
          }
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
        }
      });
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
      addCookieAsync(paramString, (String)localIterator.next());
    localCookieManager.flush();
    this.mCookieSaver.onCookiesModified();
  }

  private void clearCookiesAsync(final Callback paramCallback)
  {
    CookieManager localCookieManager = getCookieManager();
    if (localCookieManager != null)
      localCookieManager.removeAllCookies(new ValueCallback()
      {
        public void onReceiveValue(Boolean paramAnonymousBoolean)
        {
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
          paramCallback.invoke(new Object[] { paramAnonymousBoolean });
        }
      });
  }

  @Nullable
  private CookieManager getCookieManager()
  {
    if (this.mCookieManager == null)
      possiblyWorkaroundSyncManager(this.mContext);
    try
    {
      this.mCookieManager = CookieManager.getInstance();
      if (USES_LEGACY_STORE)
        this.mCookieManager.removeExpiredCookie();
      return this.mCookieManager;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
    }
    return null;
  }

  private static boolean isCookieHeader(String paramString)
  {
    return (paramString.equalsIgnoreCase("Set-cookie")) || (paramString.equalsIgnoreCase("Set-cookie2"));
  }

  private static void possiblyWorkaroundSyncManager(Context paramContext)
  {
    if (USES_LEGACY_STORE)
      CookieSyncManager.createInstance(paramContext).sync();
  }

  private void runInBackground(final Runnable paramRunnable)
  {
    new GuardedAsyncTask(this.mContext)
    {
      protected void doInBackgroundGuarded(Void[] paramAnonymousArrayOfVoid)
      {
        paramRunnable.run();
      }
    }
    .execute(new Void[0]);
  }

  public void clearCookies(final Callback paramCallback)
  {
    if (USES_LEGACY_STORE)
    {
      new GuardedResultAsyncTask(this.mContext)
      {
        protected Boolean doInBackgroundGuarded()
        {
          CookieManager localCookieManager = ForwardingCookieHandler.this.getCookieManager();
          if (localCookieManager != null)
            localCookieManager.removeAllCookie();
          ForwardingCookieHandler.this.mCookieSaver.onCookiesModified();
          return Boolean.valueOf(true);
        }

        protected void onPostExecuteGuarded(Boolean paramAnonymousBoolean)
        {
          paramCallback.invoke(new Object[] { paramAnonymousBoolean });
        }
      }
      .execute(new Void[0]);
      return;
    }
    clearCookiesAsync(paramCallback);
  }

  public void destroy()
  {
    if (USES_LEGACY_STORE)
    {
      CookieManager localCookieManager = getCookieManager();
      if (localCookieManager != null)
        localCookieManager.removeExpiredCookie();
      this.mCookieSaver.persistCookies();
    }
  }

  public Map<String, List<String>> get(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    CookieManager localCookieManager = getCookieManager();
    if (localCookieManager == null)
      return Collections.emptyMap();
    String str = localCookieManager.getCookie(paramURI.toString());
    if (TextUtils.isEmpty(str))
      return Collections.emptyMap();
    return Collections.singletonMap("Cookie", Collections.singletonList(str));
  }

  public void put(URI paramURI, Map<String, List<String>> paramMap)
    throws IOException
  {
    String str1 = paramURI.toString();
    Iterator localIterator = paramMap.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str2 = (String)localEntry.getKey();
      if ((str2 != null) && (isCookieHeader(str2)))
        addCookies(str1, (List)localEntry.getValue());
    }
  }

  private class CookieSaver
  {
    private static final int MSG_PERSIST_COOKIES = 1;
    private static final int TIMEOUT = 30000;
    private final Handler mHandler = new Handler(Looper.getMainLooper(), new Handler.Callback()
    {
      public boolean handleMessage(Message paramAnonymousMessage)
      {
        if (paramAnonymousMessage.what == 1)
        {
          ForwardingCookieHandler.CookieSaver.this.persistCookies();
          return true;
        }
        return false;
      }
    });

    public CookieSaver()
    {
    }

    @TargetApi(21)
    private void flush()
    {
      CookieManager localCookieManager = ForwardingCookieHandler.this.getCookieManager();
      if (localCookieManager != null)
        localCookieManager.flush();
    }

    public void onCookiesModified()
    {
      if (ForwardingCookieHandler.USES_LEGACY_STORE)
        this.mHandler.sendEmptyMessageDelayed(1, 30000L);
    }

    public void persistCookies()
    {
      this.mHandler.removeMessages(1);
      ForwardingCookieHandler.this.runInBackground(new Runnable()
      {
        public void run()
        {
          if (ForwardingCookieHandler.USES_LEGACY_STORE)
          {
            CookieSyncManager.getInstance().sync();
            return;
          }
          ForwardingCookieHandler.CookieSaver.this.flush();
        }
      });
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.network.ForwardingCookieHandler
 * JD-Core Version:    0.6.2
 */