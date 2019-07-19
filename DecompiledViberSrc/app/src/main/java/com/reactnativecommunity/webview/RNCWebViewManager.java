package com.reactnativecommunity.webview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager.Request;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Environment;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.URLUtil;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.FileChooserParams;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.ReadableMapKeySetIterator;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.SimpleViewManager;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.annotations.ReactProp;
import com.facebook.react.uimanager.events.ContentSizeChangeEvent;
import com.facebook.react.uimanager.events.Event;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.reactnativecommunity.webview.a.a;
import com.reactnativecommunity.webview.a.c;
import com.reactnativecommunity.webview.a.d;
import com.reactnativecommunity.webview.a.e;
import com.reactnativecommunity.webview.a.f;
import java.io.File;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name="RNCWebView")
public class RNCWebViewManager extends SimpleViewManager<WebView>
{
  protected static final String BLANK_URL = "about:blank";
  public static final int COMMAND_GO_BACK = 1;
  public static final int COMMAND_GO_FORWARD = 2;
  public static final int COMMAND_INJECT_JAVASCRIPT = 6;
  public static final int COMMAND_LOAD_URL = 7;
  public static final int COMMAND_POST_MESSAGE = 5;
  public static final int COMMAND_RELOAD = 3;
  public static final int COMMAND_STOP_LOADING = 4;
  protected static final String HTML_ENCODING = "UTF-8";
  protected static final String HTML_MIME_TYPE = "text/html";
  protected static final String HTTP_METHOD_POST = "POST";
  protected static final String JAVASCRIPT_INTERFACE = "ReactNativeWebView";
  protected static final String REACT_CLASS = "RNCWebView";
  protected b mWebViewConfig;

  public RNCWebViewManager()
  {
    this.mWebViewConfig = new b()
    {
      public void a(WebView paramAnonymousWebView)
      {
      }
    };
  }

  public RNCWebViewManager(b paramb)
  {
    this.mWebViewConfig = paramb;
  }

  protected static void dispatchEvent(WebView paramWebView, Event paramEvent)
  {
    ((UIManagerModule)((ReactContext)paramWebView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(paramEvent);
  }

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, WebView paramWebView)
  {
    paramWebView.setWebViewClient(new b());
  }

  protected a createRNCWebViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new a(paramThemedReactContext);
  }

  @TargetApi(21)
  protected WebView createViewInstance(final ThemedReactContext paramThemedReactContext)
  {
    a locala = createRNCWebViewInstance(paramThemedReactContext);
    locala.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        return true;
      }

      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }

      public void onProgressChanged(WebView paramAnonymousWebView, int paramAnonymousInt)
      {
        super.onProgressChanged(paramAnonymousWebView, paramAnonymousInt);
        WritableMap localWritableMap = Arguments.createMap();
        localWritableMap.putDouble("target", paramAnonymousWebView.getId());
        localWritableMap.putString("title", paramAnonymousWebView.getTitle());
        localWritableMap.putBoolean("canGoBack", paramAnonymousWebView.canGoBack());
        localWritableMap.putBoolean("canGoForward", paramAnonymousWebView.canGoForward());
        localWritableMap.putDouble("progress", paramAnonymousInt / 100.0F);
        RNCWebViewManager.dispatchEvent(paramAnonymousWebView, new c(paramAnonymousWebView.getId(), localWritableMap));
      }

      @TargetApi(21)
      public boolean onShowFileChooser(WebView paramAnonymousWebView, ValueCallback<Uri[]> paramAnonymousValueCallback, WebChromeClient.FileChooserParams paramAnonymousFileChooserParams)
      {
        int i = 1;
        String[] arrayOfString = paramAnonymousFileChooserParams.getAcceptTypes();
        if (paramAnonymousFileChooserParams.getMode() == i);
        while (true)
        {
          Intent localIntent = paramAnonymousFileChooserParams.createIntent();
          return RNCWebViewManager.this.getModule(paramThemedReactContext).startPhotoPickerIntent(paramAnonymousValueCallback, localIntent, arrayOfString, i);
          int j = 0;
        }
      }
    });
    paramThemedReactContext.addLifecycleEventListener(locala);
    this.mWebViewConfig.a(locala);
    WebSettings localWebSettings = locala.getSettings();
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setAllowContentAccess(false);
    if (Build.VERSION.SDK_INT >= 16)
    {
      localWebSettings.setAllowFileAccessFromFileURLs(false);
      setAllowUniversalAccessFromFileURLs(locala, false);
    }
    setMixedContentMode(locala, "never");
    locala.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setGeolocationEnabled(locala, Boolean.valueOf(false));
    locala.setDownloadListener(new DownloadListener()
    {
      public void onDownloadStart(String paramAnonymousString1, String paramAnonymousString2, String paramAnonymousString3, String paramAnonymousString4, long paramAnonymousLong)
      {
        RNCWebViewModule localRNCWebViewModule = RNCWebViewManager.this.getModule(paramThemedReactContext);
        DownloadManager.Request localRequest = new DownloadManager.Request(Uri.parse(paramAnonymousString1));
        String str1 = URLUtil.guessFileName(paramAnonymousString1, paramAnonymousString3, paramAnonymousString4);
        String str2 = "Downloading " + str1;
        try
        {
          URL localURL = new URL(paramAnonymousString1);
          String str3 = localURL.getProtocol() + "://" + localURL.getHost();
          String str4 = CookieManager.getInstance().getCookie(str3);
          localRequest.addRequestHeader("Cookie", str4);
          System.out.println("Got cookie for DownloadManager: " + str4);
          localRequest.addRequestHeader("User-Agent", paramAnonymousString2);
          localRequest.setTitle(str1);
          localRequest.setDescription(str2);
          localRequest.allowScanningByMediaScanner();
          localRequest.setNotificationVisibility(1);
          localRequest.setDestinationInExternalPublicDir(Environment.DIRECTORY_DOWNLOADS, str1);
          localRNCWebViewModule.setDownloadRequest(localRequest);
          if (localRNCWebViewModule.grantFileDownloaderPermissions())
            localRNCWebViewModule.downloadFile();
          return;
        }
        catch (MalformedURLException localMalformedURLException)
        {
          while (true)
          {
            System.out.println("Error getting cookie for DownloadManager: " + localMalformedURLException.toString());
            localMalformedURLException.printStackTrace();
          }
        }
      }
    });
    return locala;
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("goBack", Integer.valueOf(1), "goForward", Integer.valueOf(2), "reload", Integer.valueOf(3), "stopLoading", Integer.valueOf(4), "postMessage", Integer.valueOf(5), "injectJavaScript", Integer.valueOf(6), "loadUrl", Integer.valueOf(7));
  }

  public Map getExportedCustomDirectEventTypeConstants()
  {
    Object localObject = super.getExportedCustomDirectEventTypeConstants();
    if (localObject == null)
      localObject = MapBuilder.newHashMap();
    ((Map)localObject).put("topLoadingProgress", MapBuilder.of("registrationName", "onLoadingProgress"));
    ((Map)localObject).put("topShouldStartLoadWithRequest", MapBuilder.of("registrationName", "onShouldStartLoadWithRequest"));
    return localObject;
  }

  public RNCWebViewModule getModule(ReactContext paramReactContext)
  {
    return (RNCWebViewModule)paramReactContext.getNativeModule(RNCWebViewModule.class);
  }

  public String getName()
  {
    return "RNCWebView";
  }

  public void onDropViewInstance(WebView paramWebView)
  {
    super.onDropViewInstance(paramWebView);
    ((ThemedReactContext)paramWebView.getContext()).removeLifecycleEventListener((a)paramWebView);
    ((a)paramWebView).b();
  }

  public void receiveCommand(WebView paramWebView, int paramInt, @Nullable ReadableArray paramReadableArray)
  {
    switch (paramInt)
    {
    default:
      return;
    case 1:
      paramWebView.goBack();
      return;
    case 2:
      paramWebView.goForward();
      return;
    case 3:
      paramWebView.reload();
      return;
    case 4:
      paramWebView.stopLoading();
      return;
    case 5:
      try
      {
        a locala = (a)paramWebView;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", paramReadableArray.getString(0));
        locala.a("(function () {var event;var data = " + localJSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
        return;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
    case 6:
      ((a)paramWebView).a(paramReadableArray.getString(0));
      return;
    case 7:
    }
    if (paramReadableArray == null)
      throw new RuntimeException("Arguments for loading an url are null!");
    paramWebView.loadUrl(paramReadableArray.getString(0));
  }

  @ReactProp(name="allowFileAccess")
  public void setAllowFileAccess(WebView paramWebView, @Nullable Boolean paramBoolean)
  {
    WebSettings localWebSettings = paramWebView.getSettings();
    if ((paramBoolean != null) && (paramBoolean.booleanValue()));
    for (boolean bool = true; ; bool = false)
    {
      localWebSettings.setAllowFileAccess(bool);
      return;
    }
  }

  @ReactProp(name="allowUniversalAccessFromFileURLs")
  public void setAllowUniversalAccessFromFileURLs(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setAllowUniversalAccessFromFileURLs(paramBoolean);
  }

  @ReactProp(name="cacheEnabled")
  public void setCacheEnabled(WebView paramWebView, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Context localContext = paramWebView.getContext();
      if (localContext != null)
      {
        paramWebView.getSettings().setAppCachePath(localContext.getCacheDir().getAbsolutePath());
        paramWebView.getSettings().setCacheMode(-1);
        paramWebView.getSettings().setAppCacheEnabled(true);
      }
      return;
    }
    paramWebView.getSettings().setCacheMode(2);
    paramWebView.getSettings().setAppCacheEnabled(false);
  }

  @ReactProp(name="domStorageEnabled")
  public void setDomStorageEnabled(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setDomStorageEnabled(paramBoolean);
  }

  @ReactProp(name="geolocationEnabled")
  public void setGeolocationEnabled(WebView paramWebView, @Nullable Boolean paramBoolean)
  {
    WebSettings localWebSettings = paramWebView.getSettings();
    if ((paramBoolean != null) && (paramBoolean.booleanValue()));
    for (boolean bool = true; ; bool = false)
    {
      localWebSettings.setGeolocationEnabled(bool);
      return;
    }
  }

  @ReactProp(name="androidHardwareAccelerationDisabled")
  public void setHardwareAccelerationDisabled(WebView paramWebView, boolean paramBoolean)
  {
    if (paramBoolean)
      paramWebView.setLayerType(1, null);
  }

  @ReactProp(name="injectedJavaScript")
  public void setInjectedJavaScript(WebView paramWebView, @Nullable String paramString)
  {
    ((a)paramWebView).setInjectedJavaScript(paramString);
  }

  @ReactProp(name="javaScriptEnabled")
  public void setJavaScriptEnabled(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setJavaScriptEnabled(paramBoolean);
  }

  @ReactProp(name="mediaPlaybackRequiresUserAction")
  @TargetApi(17)
  public void setMediaPlaybackRequiresUserAction(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setMediaPlaybackRequiresUserGesture(paramBoolean);
  }

  @ReactProp(name="messagingEnabled")
  public void setMessagingEnabled(WebView paramWebView, boolean paramBoolean)
  {
    ((a)paramWebView).setMessagingEnabled(paramBoolean);
  }

  @ReactProp(name="mixedContentMode")
  public void setMixedContentMode(WebView paramWebView, @Nullable String paramString)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      if ((paramString != null) && (!"never".equals(paramString)))
        break label30;
      paramWebView.getSettings().setMixedContentMode(1);
    }
    label30: 
    do
    {
      return;
      if ("always".equals(paramString))
      {
        paramWebView.getSettings().setMixedContentMode(0);
        return;
      }
    }
    while (!"compatibility".equals(paramString));
    paramWebView.getSettings().setMixedContentMode(2);
  }

  @ReactProp(name="onContentSizeChange")
  public void setOnContentSizeChange(WebView paramWebView, boolean paramBoolean)
  {
    ((a)paramWebView).setSendContentSizeChangeEvents(paramBoolean);
  }

  @ReactProp(name="overScrollMode")
  public void setOverScrollMode(WebView paramWebView, String paramString)
  {
    int i = -1;
    Integer localInteger;
    switch (paramString.hashCode())
    {
    default:
      switch (i)
      {
      default:
        localInteger = Integer.valueOf(0);
      case 0:
      case 1:
      }
      break;
    case 104712844:
    case 951530617:
    case -1414557169:
    }
    while (true)
    {
      paramWebView.setOverScrollMode(localInteger.intValue());
      return;
      if (!paramString.equals("never"))
        break;
      i = 0;
      break;
      if (!paramString.equals("content"))
        break;
      i = 1;
      break;
      if (!paramString.equals("always"))
        break;
      i = 2;
      break;
      localInteger = Integer.valueOf(2);
      continue;
      localInteger = Integer.valueOf(1);
    }
  }

  @ReactProp(name="saveFormDataDisabled")
  public void setSaveFormDataDisabled(WebView paramWebView, boolean paramBoolean)
  {
    WebSettings localWebSettings = paramWebView.getSettings();
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      localWebSettings.setSaveFormData(bool);
      return;
    }
  }

  @ReactProp(name="scalesPageToFit")
  public void setScalesPageToFit(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.getSettings().setLoadWithOverviewMode(paramBoolean);
    paramWebView.getSettings().setUseWideViewPort(paramBoolean);
  }

  @ReactProp(name="showsHorizontalScrollIndicator")
  public void setShowsHorizontalScrollIndicator(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.setHorizontalScrollBarEnabled(paramBoolean);
  }

  @ReactProp(name="showsVerticalScrollIndicator")
  public void setShowsVerticalScrollIndicator(WebView paramWebView, boolean paramBoolean)
  {
    paramWebView.setVerticalScrollBarEnabled(paramBoolean);
  }

  @ReactProp(name="source")
  public void setSource(WebView paramWebView, @Nullable ReadableMap paramReadableMap)
  {
    String str1;
    String str4;
    if (paramReadableMap != null)
    {
      String str5;
      if (paramReadableMap.hasKey("html"))
      {
        str5 = paramReadableMap.getString("html");
        if (paramReadableMap.hasKey("baseUrl"))
          paramWebView.loadDataWithBaseURL(paramReadableMap.getString("baseUrl"), str5, "text/html", "UTF-8", null);
      }
      String str2;
      do
      {
        return;
        paramWebView.loadData(str5, "text/html; charset=UTF-8", null);
        return;
        if (!paramReadableMap.hasKey("uri"))
          break;
        str1 = paramReadableMap.getString("uri");
        str2 = paramWebView.getUrl();
      }
      while ((str2 != null) && (str2.equals(str1)));
      if ((paramReadableMap.hasKey("method")) && (paramReadableMap.getString("method").equalsIgnoreCase("POST")))
      {
        if (!paramReadableMap.hasKey("body"))
          break label346;
        str4 = paramReadableMap.getString("body");
      }
    }
    while (true)
    {
      try
      {
        byte[] arrayOfByte2 = str4.getBytes("UTF-8");
        arrayOfByte1 = arrayOfByte2;
        if (arrayOfByte1 == null)
          arrayOfByte1 = new byte[0];
        paramWebView.postUrl(str1, arrayOfByte1);
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        arrayOfByte1 = str4.getBytes();
        continue;
      }
      HashMap localHashMap = new HashMap();
      if (paramReadableMap.hasKey("headers"))
      {
        ReadableMap localReadableMap = paramReadableMap.getMap("headers");
        ReadableMapKeySetIterator localReadableMapKeySetIterator = localReadableMap.keySetIterator();
        while (localReadableMapKeySetIterator.hasNextKey())
        {
          String str3 = localReadableMapKeySetIterator.nextKey();
          if ("user-agent".equals(str3.toLowerCase(Locale.ENGLISH)))
          {
            if (paramWebView.getSettings() != null)
              paramWebView.getSettings().setUserAgentString(localReadableMap.getString(str3));
          }
          else
            localHashMap.put(str3, localReadableMap.getString(str3));
        }
      }
      paramWebView.loadUrl(str1, localHashMap);
      return;
      paramWebView.loadUrl("about:blank");
      return;
      label346: byte[] arrayOfByte1 = null;
    }
  }

  @ReactProp(name="textZoom")
  public void setTextZoom(WebView paramWebView, int paramInt)
  {
    paramWebView.getSettings().setTextZoom(paramInt);
  }

  @ReactProp(name="thirdPartyCookiesEnabled")
  public void setThirdPartyCookiesEnabled(WebView paramWebView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
      CookieManager.getInstance().setAcceptThirdPartyCookies(paramWebView, paramBoolean);
  }

  @ReactProp(name="urlPrefixesForDefaultIntent")
  public void setUrlPrefixesForDefaultIntent(WebView paramWebView, @Nullable ReadableArray paramReadableArray)
  {
    b localb = ((a)paramWebView).getRNCWebViewClient();
    if ((localb != null) && (paramReadableArray != null))
      localb.a(paramReadableArray);
  }

  @ReactProp(name="userAgent")
  public void setUserAgent(WebView paramWebView, @Nullable String paramString)
  {
    if (paramString != null)
      paramWebView.getSettings().setUserAgentString(paramString);
  }

  protected static class a extends WebView
    implements LifecycleEventListener
  {

    @Nullable
    protected String a;
    protected boolean b = false;

    @Nullable
    protected RNCWebViewManager.b c;
    protected boolean d = false;

    public a(ThemedReactContext paramThemedReactContext)
    {
      super();
    }

    protected a a(a parama)
    {
      return new a(parama);
    }

    public void a()
    {
      if ((getSettings().getJavaScriptEnabled()) && (this.a != null) && (!TextUtils.isEmpty(this.a)))
        a("(function() {\n" + this.a + ";\n})();");
    }

    protected void a(String paramString)
    {
      if (Build.VERSION.SDK_INT >= 19)
      {
        evaluateJavascript(paramString, null);
        return;
      }
      try
      {
        loadUrl("javascript:" + URLEncoder.encode(paramString, "UTF-8"));
        return;
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException(localUnsupportedEncodingException);
      }
    }

    protected void b()
    {
      setWebViewClient(null);
      destroy();
    }

    public void b(String paramString)
    {
      RNCWebViewManager.dispatchEvent(this, new e(getId(), paramString));
    }

    @Nullable
    public RNCWebViewManager.b getRNCWebViewClient()
    {
      return this.c;
    }

    public void onHostDestroy()
    {
      b();
    }

    public void onHostPause()
    {
    }

    public void onHostResume()
    {
    }

    protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
    {
      super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
      if (this.d)
        RNCWebViewManager.dispatchEvent(this, new ContentSizeChangeEvent(getId(), paramInt1, paramInt2));
    }

    public void setInjectedJavaScript(@Nullable String paramString)
    {
      this.a = paramString;
    }

    @SuppressLint({"AddJavascriptInterface"})
    public void setMessagingEnabled(boolean paramBoolean)
    {
      if (this.b == paramBoolean)
        return;
      this.b = paramBoolean;
      if (paramBoolean)
      {
        addJavascriptInterface(a(this), "ReactNativeWebView");
        return;
      }
      removeJavascriptInterface("ReactNativeWebView");
    }

    public void setSendContentSizeChangeEvents(boolean paramBoolean)
    {
      this.d = paramBoolean;
    }

    public void setWebViewClient(WebViewClient paramWebViewClient)
    {
      super.setWebViewClient(paramWebViewClient);
      this.c = ((RNCWebViewManager.b)paramWebViewClient);
    }

    protected class a
    {
      RNCWebViewManager.a a;

      a(RNCWebViewManager.a arg2)
      {
        Object localObject;
        this.a = localObject;
      }

      @JavascriptInterface
      public void postMessage(String paramString)
      {
        this.a.b(paramString);
      }
    }
  }

  protected static class b extends WebViewClient
  {
    protected boolean a = false;

    @Nullable
    protected ReadableArray b;

    protected void a(WebView paramWebView, String paramString)
    {
      RNCWebViewManager.dispatchEvent(paramWebView, new com.reactnativecommunity.webview.a.b(paramWebView.getId(), b(paramWebView, paramString)));
    }

    public void a(ReadableArray paramReadableArray)
    {
      this.b = paramReadableArray;
    }

    protected WritableMap b(WebView paramWebView, String paramString)
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("target", paramWebView.getId());
      localWritableMap.putString("url", paramString);
      if ((!this.a) && (paramWebView.getProgress() != 100));
      for (boolean bool = true; ; bool = false)
      {
        localWritableMap.putBoolean("loading", bool);
        localWritableMap.putString("title", paramWebView.getTitle());
        localWritableMap.putBoolean("canGoBack", paramWebView.canGoBack());
        localWritableMap.putBoolean("canGoForward", paramWebView.canGoForward());
        return localWritableMap;
      }
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!this.a)
      {
        ((RNCWebViewManager.a)paramWebView).a();
        a(paramWebView, paramString);
      }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.a = false;
      RNCWebViewManager.dispatchEvent(paramWebView, new d(paramWebView.getId(), b(paramWebView, paramString)));
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this.a = true;
      a(paramWebView, paramString2);
      WritableMap localWritableMap = b(paramWebView, paramString2);
      localWritableMap.putDouble("code", paramInt);
      localWritableMap.putString("description", paramString1);
      RNCWebViewManager.dispatchEvent(paramWebView, new a(paramWebView.getId(), localWritableMap));
    }

    @TargetApi(24)
    public boolean shouldOverrideUrlLoading(WebView paramWebView, WebResourceRequest paramWebResourceRequest)
    {
      return shouldOverrideUrlLoading(paramWebView, paramWebResourceRequest.getUrl().toString());
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      RNCWebViewManager.dispatchEvent(paramWebView, new f(paramWebView.getId(), b(paramWebView, paramString)));
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.webview.RNCWebViewManager
 * JD-Core Version:    0.6.2
 */