package com.facebook.react.views.webview;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.graphics.Picture;
import android.net.Uri;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.ViewGroup.LayoutParams;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions.Callback;
import android.webkit.JavascriptInterface;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebView.PictureListener;
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
import com.facebook.react.views.webview.events.TopLoadingErrorEvent;
import com.facebook.react.views.webview.events.TopLoadingFinishEvent;
import com.facebook.react.views.webview.events.TopLoadingStartEvent;
import com.facebook.react.views.webview.events.TopMessageEvent;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.annotation.Nullable;
import org.json.JSONException;
import org.json.JSONObject;

@ReactModule(name="RCTWebView")
public class ReactWebViewManager extends SimpleViewManager<WebView>
{
  protected static final String BLANK_URL = "about:blank";
  protected static final String BRIDGE_NAME = "__REACT_WEB_VIEW_BRIDGE";
  public static final int COMMAND_GO_BACK = 1;
  public static final int COMMAND_GO_FORWARD = 2;
  public static final int COMMAND_INJECT_JAVASCRIPT = 6;
  public static final int COMMAND_POST_MESSAGE = 5;
  public static final int COMMAND_RELOAD = 3;
  public static final int COMMAND_STOP_LOADING = 4;
  protected static final String HTML_ENCODING = "UTF-8";
  protected static final String HTML_MIME_TYPE = "text/html";
  protected static final String HTTP_METHOD_POST = "POST";
  private static final String INTENT_URL_PREFIX = "intent://";
  public static final String REACT_CLASS = "RCTWebView";

  @Nullable
  protected WebView.PictureListener mPictureListener;
  protected WebViewConfig mWebViewConfig;

  public ReactWebViewManager()
  {
    this.mWebViewConfig = new WebViewConfig()
    {
      public void configWebView(WebView paramAnonymousWebView)
      {
      }
    };
  }

  public ReactWebViewManager(WebViewConfig paramWebViewConfig)
  {
    this.mWebViewConfig = paramWebViewConfig;
  }

  protected static void dispatchEvent(WebView paramWebView, Event paramEvent)
  {
    ((UIManagerModule)((ReactContext)paramWebView.getContext()).getNativeModule(UIManagerModule.class)).getEventDispatcher().dispatchEvent(paramEvent);
  }

  protected void addEventEmitters(ThemedReactContext paramThemedReactContext, WebView paramWebView)
  {
    paramWebView.setWebViewClient(new ReactWebViewClient());
  }

  protected ReactWebView createReactWebViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactWebView(paramThemedReactContext);
  }

  @TargetApi(21)
  protected WebView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    ReactWebView localReactWebView = createReactWebViewInstance(paramThemedReactContext);
    localReactWebView.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        return true;
      }

      public void onGeolocationPermissionsShowPrompt(String paramAnonymousString, GeolocationPermissions.Callback paramAnonymousCallback)
      {
        paramAnonymousCallback.invoke(paramAnonymousString, true, false);
      }
    });
    paramThemedReactContext.addLifecycleEventListener(localReactWebView);
    this.mWebViewConfig.configWebView(localReactWebView);
    WebSettings localWebSettings = localReactWebView.getSettings();
    localWebSettings.setBuiltInZoomControls(true);
    localWebSettings.setDisplayZoomControls(false);
    localWebSettings.setDomStorageEnabled(true);
    localWebSettings.setAllowFileAccess(false);
    localWebSettings.setAllowContentAccess(false);
    localWebSettings.setAllowFileAccessFromFileURLs(false);
    setAllowUniversalAccessFromFileURLs(localReactWebView, false);
    setMixedContentMode(localReactWebView, "never");
    localReactWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    setGeolocationEnabled(localReactWebView, Boolean.valueOf(false));
    return localReactWebView;
  }

  @Nullable
  public Map<String, Integer> getCommandsMap()
  {
    return MapBuilder.of("goBack", Integer.valueOf(1), "goForward", Integer.valueOf(2), "reload", Integer.valueOf(3), "stopLoading", Integer.valueOf(4), "postMessage", Integer.valueOf(5), "injectJavaScript", Integer.valueOf(6));
  }

  public String getName()
  {
    return "RCTWebView";
  }

  protected WebView.PictureListener getPictureListener()
  {
    if (this.mPictureListener == null)
      this.mPictureListener = new WebView.PictureListener()
      {
        public void onNewPicture(WebView paramAnonymousWebView, Picture paramAnonymousPicture)
        {
          ReactWebViewManager.dispatchEvent(paramAnonymousWebView, new ContentSizeChangeEvent(paramAnonymousWebView.getId(), paramAnonymousWebView.getWidth(), paramAnonymousWebView.getContentHeight()));
        }
      };
    return this.mPictureListener;
  }

  public void onDropViewInstance(WebView paramWebView)
  {
    super.onDropViewInstance(paramWebView);
    ((ThemedReactContext)paramWebView.getContext()).removeLifecycleEventListener((ReactWebView)paramWebView);
    ((ReactWebView)paramWebView).cleanupCallbacksAndDestroy();
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
        ReactWebView localReactWebView = (ReactWebView)paramWebView;
        JSONObject localJSONObject = new JSONObject();
        localJSONObject.put("data", paramReadableArray.getString(0));
        localReactWebView.evaluateJavascriptWithFallback("(function () {var event;var data = " + localJSONObject.toString() + ";try {event = new MessageEvent('message', data);} catch (e) {event = document.createEvent('MessageEvent');event.initMessageEvent('message', true, true, data.data, data.origin, data.lastEventId, data.source);}document.dispatchEvent(event);})();");
        return;
      }
      catch (JSONException localJSONException)
      {
        throw new RuntimeException(localJSONException);
      }
    case 6:
    }
    ((ReactWebView)paramWebView).evaluateJavascriptWithFallback(paramReadableArray.getString(0));
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

  @ReactProp(name="injectedJavaScript")
  public void setInjectedJavaScript(WebView paramWebView, @Nullable String paramString)
  {
    ((ReactWebView)paramWebView).setInjectedJavaScript(paramString);
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
    ((ReactWebView)paramWebView).setMessagingEnabled(paramBoolean);
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
    if (paramBoolean)
    {
      paramWebView.setPictureListener(getPictureListener());
      return;
    }
    paramWebView.setPictureListener(null);
  }

  @ReactProp(name="originWhitelist")
  public void setOriginWhitelist(WebView paramWebView, @Nullable ReadableArray paramReadableArray)
  {
    ReactWebViewClient localReactWebViewClient = ((ReactWebView)paramWebView).getReactWebViewClient();
    if ((localReactWebViewClient != null) && (paramReadableArray != null))
    {
      LinkedList localLinkedList = new LinkedList();
      for (int i = 0; i < paramReadableArray.size(); i++)
        localLinkedList.add(Pattern.compile(paramReadableArray.getString(i)));
      localReactWebViewClient.setOriginWhitelist(localLinkedList);
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
    WebSettings localWebSettings = paramWebView.getSettings();
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      localWebSettings.setUseWideViewPort(bool);
      return;
    }
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
        paramWebView.loadData(str5, "text/html", "UTF-8");
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

  @ReactProp(name="thirdPartyCookiesEnabled")
  public void setThirdPartyCookiesEnabled(WebView paramWebView, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 21)
      CookieManager.getInstance().setAcceptThirdPartyCookies(paramWebView, paramBoolean);
  }

  @ReactProp(name="urlPrefixesForDefaultIntent")
  public void setUrlPrefixesForDefaultIntent(WebView paramWebView, @Nullable ReadableArray paramReadableArray)
  {
    ReactWebViewClient localReactWebViewClient = ((ReactWebView)paramWebView).getReactWebViewClient();
    if ((localReactWebViewClient != null) && (paramReadableArray != null))
      localReactWebViewClient.setUrlPrefixesForDefaultIntent(paramReadableArray);
  }

  @ReactProp(name="userAgent")
  public void setUserAgent(WebView paramWebView, @Nullable String paramString)
  {
    if (paramString != null)
      paramWebView.getSettings().setUserAgentString(paramString);
  }

  @ReactProp(defaultBoolean=true, name="hardwareAccelerationEnabledExperimental")
  public void sethardwareAccelerationEnabledExperimental(WebView paramWebView, boolean paramBoolean)
  {
    if (!paramBoolean)
      paramWebView.setLayerType(1, null);
  }

  protected static class ReactWebView extends WebView
    implements LifecycleEventListener
  {

    @Nullable
    protected String injectedJS;

    @Nullable
    protected ReactWebViewManager.ReactWebViewClient mReactWebViewClient;
    protected boolean messagingEnabled = false;

    public ReactWebView(ThemedReactContext paramThemedReactContext)
    {
      super();
    }

    public void callInjectedJavaScript()
    {
      if ((getSettings().getJavaScriptEnabled()) && (this.injectedJS != null) && (!TextUtils.isEmpty(this.injectedJS)))
        evaluateJavascriptWithFallback("(function() {\n" + this.injectedJS + ";\n})();");
    }

    protected void cleanupCallbacksAndDestroy()
    {
      setWebViewClient(null);
      destroy();
    }

    protected ReactWebViewBridge createReactWebViewBridge(ReactWebView paramReactWebView)
    {
      return new ReactWebViewBridge(paramReactWebView);
    }

    protected void evaluateJavascriptWithFallback(String paramString)
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

    @Nullable
    public ReactWebViewManager.ReactWebViewClient getReactWebViewClient()
    {
      return this.mReactWebViewClient;
    }

    public void linkBridge()
    {
      if (this.messagingEnabled)
        evaluateJavascriptWithFallback("(window.originalPostMessage = window.postMessage,window.postMessage = function(data) {__REACT_WEB_VIEW_BRIDGE.postMessage(String(data));})");
    }

    public void onHostDestroy()
    {
      cleanupCallbacksAndDestroy();
    }

    public void onHostPause()
    {
    }

    public void onHostResume()
    {
    }

    public void onMessage(String paramString)
    {
      ReactWebViewManager.dispatchEvent(this, new TopMessageEvent(getId(), paramString));
    }

    public void setInjectedJavaScript(@Nullable String paramString)
    {
      this.injectedJS = paramString;
    }

    public void setMessagingEnabled(boolean paramBoolean)
    {
      if (this.messagingEnabled == paramBoolean)
        return;
      this.messagingEnabled = paramBoolean;
      if (paramBoolean)
      {
        addJavascriptInterface(createReactWebViewBridge(this), "__REACT_WEB_VIEW_BRIDGE");
        linkBridge();
        return;
      }
      removeJavascriptInterface("__REACT_WEB_VIEW_BRIDGE");
    }

    public void setWebViewClient(WebViewClient paramWebViewClient)
    {
      super.setWebViewClient(paramWebViewClient);
      this.mReactWebViewClient = ((ReactWebViewManager.ReactWebViewClient)paramWebViewClient);
    }

    protected class ReactWebViewBridge
    {
      ReactWebViewManager.ReactWebView mContext;

      ReactWebViewBridge(ReactWebViewManager.ReactWebView arg2)
      {
        Object localObject;
        this.mContext = localObject;
      }

      @JavascriptInterface
      public void postMessage(String paramString)
      {
        this.mContext.onMessage(paramString);
      }
    }
  }

  protected static class ReactWebViewClient extends WebViewClient
  {
    protected boolean mLastLoadFailed = false;

    @Nullable
    protected List<Pattern> mOriginWhitelist;

    @Nullable
    protected ReadableArray mUrlPrefixesForDefaultIntent;

    // ERROR //
    private void launchIntent(android.content.Context paramContext, String paramString)
    {
      // Byte code:
      //   0: aload_2
      //   1: ldc 26
      //   3: invokevirtual 32	java/lang/String:startsWith	(Ljava/lang/String;)Z
      //   6: ifeq +84 -> 90
      //   9: aload_2
      //   10: iconst_1
      //   11: invokestatic 38	android/content/Intent:parseUri	(Ljava/lang/String;I)Landroid/content/Intent;
      //   14: astore 10
      //   16: aload 10
      //   18: astore_3
      //   19: aload_3
      //   20: ifnull +97 -> 117
      //   23: aload_3
      //   24: ldc 40
      //   26: invokevirtual 44	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
      //   29: pop
      //   30: aload_3
      //   31: aconst_null
      //   32: invokevirtual 48	android/content/Intent:setComponent	(Landroid/content/ComponentName;)Landroid/content/Intent;
      //   35: pop
      //   36: aload_3
      //   37: aconst_null
      //   38: invokevirtual 52	android/content/Intent:setSelector	(Landroid/content/Intent;)V
      //   41: aload_1
      //   42: invokevirtual 58	android/content/Context:getPackageManager	()Landroid/content/pm/PackageManager;
      //   45: aload_3
      //   46: ldc 59
      //   48: invokevirtual 65	android/content/pm/PackageManager:resolveActivity	(Landroid/content/Intent;I)Landroid/content/pm/ResolveInfo;
      //   51: ifnull +44 -> 95
      //   54: aload_1
      //   55: aload_3
      //   56: invokevirtual 68	android/content/Context:startActivity	(Landroid/content/Intent;)V
      //   59: aload_3
      //   60: ldc 69
      //   62: invokevirtual 73	android/content/Intent:setFlags	(I)Landroid/content/Intent;
      //   65: pop
      //   66: aload_3
      //   67: ldc 40
      //   69: invokevirtual 44	android/content/Intent:addCategory	(Ljava/lang/String;)Landroid/content/Intent;
      //   72: pop
      //   73: aload_1
      //   74: aload_3
      //   75: invokevirtual 68	android/content/Context:startActivity	(Landroid/content/Intent;)V
      //   78: return
      //   79: astore 9
      //   81: ldc 75
      //   83: ldc 77
      //   85: aload 9
      //   87: invokestatic 83	com/facebook/common/logging/FLog:e	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   90: aconst_null
      //   91: astore_3
      //   92: goto -73 -> 19
      //   95: new 34	android/content/Intent
      //   98: dup
      //   99: ldc 85
      //   101: aload_3
      //   102: ldc 87
      //   104: invokevirtual 91	android/content/Intent:getStringExtra	(Ljava/lang/String;)Ljava/lang/String;
      //   107: invokestatic 97	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   110: invokespecial 100	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
      //   113: astore_3
      //   114: goto -55 -> 59
      //   117: new 34	android/content/Intent
      //   120: dup
      //   121: ldc 85
      //   123: aload_2
      //   124: invokestatic 97	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
      //   127: invokespecial 100	android/content/Intent:<init>	(Ljava/lang/String;Landroid/net/Uri;)V
      //   130: astore_3
      //   131: goto -72 -> 59
      //   134: astore 4
      //   136: ldc 75
      //   138: new 102	java/lang/StringBuilder
      //   141: dup
      //   142: invokespecial 103	java/lang/StringBuilder:<init>	()V
      //   145: ldc 105
      //   147: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   150: aload_2
      //   151: invokevirtual 109	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   154: invokevirtual 113	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   157: aload 4
      //   159: invokestatic 116	com/facebook/common/logging/FLog:w	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
      //   162: return
      //
      // Exception table:
      //   from	to	target	type
      //   9	16	79	java/net/URISyntaxException
      //   59	78	134	android/content/ActivityNotFoundException
    }

    private boolean shouldHandleURL(List<Pattern> paramList, String paramString)
    {
      Uri localUri = Uri.parse(paramString);
      String str1;
      if (localUri.getScheme() != null)
      {
        str1 = localUri.getScheme();
        if (localUri.getAuthority() == null)
          break label106;
      }
      label106: for (String str2 = localUri.getAuthority(); ; str2 = "")
      {
        String str3 = str1 + "://" + str2;
        Iterator localIterator = paramList.iterator();
        do
          if (!localIterator.hasNext())
            break;
        while (!((Pattern)localIterator.next()).matcher(str3).matches());
        return true;
        str1 = "";
        break;
      }
      return false;
    }

    protected WritableMap createWebViewEvent(WebView paramWebView, String paramString)
    {
      WritableMap localWritableMap = Arguments.createMap();
      localWritableMap.putDouble("target", paramWebView.getId());
      localWritableMap.putString("url", paramString);
      if ((!this.mLastLoadFailed) && (paramWebView.getProgress() != 100));
      for (boolean bool = true; ; bool = false)
      {
        localWritableMap.putBoolean("loading", bool);
        localWritableMap.putString("title", paramWebView.getTitle());
        localWritableMap.putBoolean("canGoBack", paramWebView.canGoBack());
        localWritableMap.putBoolean("canGoForward", paramWebView.canGoForward());
        return localWritableMap;
      }
    }

    protected void emitFinishEvent(WebView paramWebView, String paramString)
    {
      ReactWebViewManager.dispatchEvent(paramWebView, new TopLoadingFinishEvent(paramWebView.getId(), createWebViewEvent(paramWebView, paramString)));
    }

    public void onPageFinished(WebView paramWebView, String paramString)
    {
      super.onPageFinished(paramWebView, paramString);
      if (!this.mLastLoadFailed)
      {
        ReactWebViewManager.ReactWebView localReactWebView = (ReactWebViewManager.ReactWebView)paramWebView;
        localReactWebView.callInjectedJavaScript();
        localReactWebView.linkBridge();
        emitFinishEvent(paramWebView, paramString);
      }
    }

    public void onPageStarted(WebView paramWebView, String paramString, Bitmap paramBitmap)
    {
      super.onPageStarted(paramWebView, paramString, paramBitmap);
      this.mLastLoadFailed = false;
      ReactWebViewManager.dispatchEvent(paramWebView, new TopLoadingStartEvent(paramWebView.getId(), createWebViewEvent(paramWebView, paramString)));
    }

    public void onReceivedError(WebView paramWebView, int paramInt, String paramString1, String paramString2)
    {
      super.onReceivedError(paramWebView, paramInt, paramString1, paramString2);
      this.mLastLoadFailed = true;
      emitFinishEvent(paramWebView, paramString2);
      WritableMap localWritableMap = createWebViewEvent(paramWebView, paramString2);
      localWritableMap.putDouble("code", paramInt);
      localWritableMap.putString("description", paramString1);
      ReactWebViewManager.dispatchEvent(paramWebView, new TopLoadingErrorEvent(paramWebView.getId(), localWritableMap));
    }

    public void setOriginWhitelist(List<Pattern> paramList)
    {
      this.mOriginWhitelist = paramList;
    }

    public void setUrlPrefixesForDefaultIntent(ReadableArray paramReadableArray)
    {
      this.mUrlPrefixesForDefaultIntent = paramReadableArray;
    }

    public boolean shouldOverrideUrlLoading(WebView paramWebView, String paramString)
    {
      if (paramString.equals("about:blank"))
        return false;
      if ((this.mUrlPrefixesForDefaultIntent != null) && (this.mUrlPrefixesForDefaultIntent.size() > 0))
      {
        Iterator localIterator = this.mUrlPrefixesForDefaultIntent.toArrayList().iterator();
        while (localIterator.hasNext())
          if (paramString.startsWith((String)localIterator.next()))
          {
            launchIntent(paramWebView.getContext(), paramString);
            return true;
          }
      }
      if ((this.mOriginWhitelist != null) && (shouldHandleURL(this.mOriginWhitelist, paramString)))
        return false;
      launchIntent(paramWebView.getContext(), paramString);
      return true;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.webview.ReactWebViewManager
 * JD-Core Version:    0.6.2
 */