package com.mopub.mraid;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.ConsoleMessage;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebChromeClient;
import android.webkit.WebChromeClient.CustomViewCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.mopub.common.AdReport;
import com.mopub.common.CloseableLayout.ClosePosition;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibilityTracker;
import com.mopub.common.VisibilityTracker.VisibilityTrackerListener;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.BaseWebView;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.mobileads.ViewGestureDetector;
import com.mopub.network.Networking;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Map;
import org.json.JSONObject;

public class MraidBridge
{
  private final AdReport a;
  private final PlacementType b;
  private final MraidNativeCommandHandler c;
  private MraidBridgeListener d;
  private MraidWebView e;
  private ViewGestureDetector f;
  private boolean g;
  private final WebViewClient h = new MraidWebViewClient()
  {
    public void onPageFinished(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      MraidBridge.c(MraidBridge.this);
    }

    public void onReceivedError(WebView paramAnonymousWebView, int paramAnonymousInt, String paramAnonymousString1, String paramAnonymousString2)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("Error: " + paramAnonymousString1);
      MoPubLog.log(localSdkLogEvent, arrayOfObject);
      super.onReceivedError(paramAnonymousWebView, paramAnonymousInt, paramAnonymousString1, paramAnonymousString2);
    }

    public boolean onRenderProcessGone(WebView paramAnonymousWebView, RenderProcessGoneDetail paramAnonymousRenderProcessGoneDetail)
    {
      MraidBridge.this.a(paramAnonymousRenderProcessGoneDetail);
      return true;
    }

    public boolean shouldOverrideUrlLoading(WebView paramAnonymousWebView, String paramAnonymousString)
    {
      return MraidBridge.this.b(paramAnonymousString);
    }
  };

  MraidBridge(AdReport paramAdReport, PlacementType paramPlacementType)
  {
    this(paramAdReport, paramPlacementType, new MraidNativeCommandHandler());
  }

  @VisibleForTesting
  MraidBridge(AdReport paramAdReport, PlacementType paramPlacementType, MraidNativeCommandHandler paramMraidNativeCommandHandler)
  {
    this.a = paramAdReport;
    this.b = paramPlacementType;
    this.c = paramMraidNativeCommandHandler;
  }

  private int a(int paramInt1, int paramInt2, int paramInt3)
    throws a
  {
    if ((paramInt1 < paramInt2) || (paramInt1 > paramInt3))
      throw new a("Integer parameter out of range: " + paramInt1);
    return paramInt1;
  }

  private CloseableLayout.ClosePosition a(String paramString, CloseableLayout.ClosePosition paramClosePosition)
    throws a
  {
    if (TextUtils.isEmpty(paramString))
      return paramClosePosition;
    if (paramString.equals("top-left"))
      return CloseableLayout.ClosePosition.TOP_LEFT;
    if (paramString.equals("top-right"))
      return CloseableLayout.ClosePosition.TOP_RIGHT;
    if (paramString.equals("center"))
      return CloseableLayout.ClosePosition.CENTER;
    if (paramString.equals("bottom-left"))
      return CloseableLayout.ClosePosition.BOTTOM_LEFT;
    if (paramString.equals("bottom-right"))
      return CloseableLayout.ClosePosition.BOTTOM_RIGHT;
    if (paramString.equals("top-center"))
      return CloseableLayout.ClosePosition.TOP_CENTER;
    if (paramString.equals("bottom-center"))
      return CloseableLayout.ClosePosition.BOTTOM_CENTER;
    throw new a("Invalid close position: " + paramString);
  }

  private String a(Rect paramRect)
  {
    return paramRect.left + "," + paramRect.top + "," + paramRect.width() + "," + paramRect.height();
  }

  private URI a(String paramString, URI paramURI)
    throws a
  {
    if (paramString == null)
      return paramURI;
    return f(paramString);
  }

  private void a(MraidJavascriptCommand paramMraidJavascriptCommand)
  {
    a("window.mraidbridge.nativeCallComplete(" + JSONObject.quote(paramMraidJavascriptCommand.a()) + ")");
  }

  private void a(MraidJavascriptCommand paramMraidJavascriptCommand, String paramString)
  {
    a("window.mraidbridge.notifyErrorEvent(" + JSONObject.quote(paramMraidJavascriptCommand.a()) + ", " + JSONObject.quote(paramString) + ")");
  }

  private boolean a(String paramString, boolean paramBoolean)
    throws a
  {
    if (paramString == null)
      return paramBoolean;
    return e(paramString);
  }

  private String b(Rect paramRect)
  {
    return paramRect.width() + "," + paramRect.height();
  }

  private int c(String paramString)
    throws a
  {
    try
    {
      int i = Integer.parseInt(paramString, 10);
      return i;
    }
    catch (NumberFormatException localNumberFormatException)
    {
    }
    throw new a("Invalid numeric parameter: " + paramString);
  }

  private b d(String paramString)
    throws a
  {
    if ("portrait".equals(paramString))
      return b.PORTRAIT;
    if ("landscape".equals(paramString))
      return b.LANDSCAPE;
    if ("none".equals(paramString))
      return b.NONE;
    throw new a("Invalid orientation: " + paramString);
  }

  private boolean e(String paramString)
    throws a
  {
    if ("true".equals(paramString))
      return true;
    if ("false".equals(paramString))
      return false;
    throw new a("Invalid boolean parameter: " + paramString);
  }

  private URI f(String paramString)
    throws a
  {
    if (paramString == null)
      throw new a("Parameter cannot be null");
    try
    {
      URI localURI = new URI(paramString);
      return localURI;
    }
    catch (URISyntaxException localURISyntaxException)
    {
    }
    throw new a("Invalid URL parameter: " + paramString);
  }

  @VisibleForTesting
  private void g()
  {
    if (this.g);
    do
    {
      return;
      this.g = true;
    }
    while (this.d == null);
    this.d.onPageLoaded();
  }

  void a()
  {
    if (this.e != null)
    {
      this.e.destroy();
      this.e = null;
    }
  }

  @TargetApi(26)
  @VisibleForTesting
  void a(RenderProcessGoneDetail paramRenderProcessGoneDetail)
  {
    if ((paramRenderProcessGoneDetail != null) && (paramRenderProcessGoneDetail.didCrash()));
    for (MoPubErrorCode localMoPubErrorCode = MoPubErrorCode.RENDER_PROCESS_GONE_WITH_CRASH; ; localMoPubErrorCode = MoPubErrorCode.RENDER_PROCESS_GONE_UNSPECIFIED)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { localMoPubErrorCode });
      a();
      if (this.d != null)
        this.d.onRenderProcessGone(localMoPubErrorCode);
      return;
    }
  }

  void a(MraidBridgeListener paramMraidBridgeListener)
  {
    this.d = paramMraidBridgeListener;
  }

  void a(MraidWebView paramMraidWebView)
  {
    this.e = paramMraidWebView;
    this.e.getSettings().setJavaScriptEnabled(true);
    if ((Build.VERSION.SDK_INT >= 17) && (this.b == PlacementType.INTERSTITIAL))
      paramMraidWebView.getSettings().setMediaPlaybackRequiresUserGesture(false);
    this.e.setScrollContainer(false);
    this.e.setVerticalScrollBarEnabled(false);
    this.e.setHorizontalScrollBarEnabled(false);
    this.e.setBackgroundColor(0);
    this.e.setWebViewClient(this.h);
    this.e.setWebChromeClient(new WebChromeClient()
    {
      public boolean onConsoleMessage(ConsoleMessage paramAnonymousConsoleMessage)
      {
        if (MraidBridge.a(MraidBridge.this) != null)
          return MraidBridge.a(MraidBridge.this).onConsoleMessage(paramAnonymousConsoleMessage);
        return super.onConsoleMessage(paramAnonymousConsoleMessage);
      }

      public boolean onJsAlert(WebView paramAnonymousWebView, String paramAnonymousString1, String paramAnonymousString2, JsResult paramAnonymousJsResult)
      {
        if (MraidBridge.a(MraidBridge.this) != null)
          return MraidBridge.a(MraidBridge.this).onJsAlert(paramAnonymousString2, paramAnonymousJsResult);
        return super.onJsAlert(paramAnonymousWebView, paramAnonymousString1, paramAnonymousString2, paramAnonymousJsResult);
      }

      public void onShowCustomView(View paramAnonymousView, WebChromeClient.CustomViewCallback paramAnonymousCustomViewCallback)
      {
        super.onShowCustomView(paramAnonymousView, paramAnonymousCustomViewCallback);
      }
    });
    this.f = new ViewGestureDetector(this.e.getContext(), this.e, this.a);
    this.e.setOnTouchListener(new View.OnTouchListener()
    {
      public boolean onTouch(View paramAnonymousView, MotionEvent paramAnonymousMotionEvent)
      {
        MraidBridge.b(MraidBridge.this).onTouchEvent(paramAnonymousMotionEvent);
        switch (paramAnonymousMotionEvent.getAction())
        {
        default:
        case 0:
        case 1:
        }
        while (true)
        {
          return false;
          if (!paramAnonymousView.hasFocus())
            paramAnonymousView.requestFocus();
        }
      }
    });
    this.e.setVisibilityChangedListener(new MraidBridge.MraidWebView.OnVisibilityChangedListener()
    {
      public void onVisibilityChanged(boolean paramAnonymousBoolean)
      {
        if (MraidBridge.a(MraidBridge.this) != null)
          MraidBridge.a(MraidBridge.this).onVisibilityChanged(paramAnonymousBoolean);
      }
    });
  }

  @VisibleForTesting
  void a(final MraidJavascriptCommand paramMraidJavascriptCommand, Map<String, String> paramMap)
    throws a
  {
    if ((paramMraidJavascriptCommand.a(this.b)) && (!c()))
      throw new a("Cannot execute this command unless the user clicks");
    if (this.d == null)
      throw new a("Invalid state to execute this command");
    if (this.e == null)
      throw new a("The current WebView is being destroyed");
    switch (6.a[paramMraidJavascriptCommand.ordinal()])
    {
    default:
      return;
    case 1:
      this.d.onClose();
      return;
    case 2:
      int i = a(c((String)paramMap.get("width")), 0, 100000);
      int j = a(c((String)paramMap.get("height")), 0, 100000);
      int k = a(c((String)paramMap.get("offsetX")), -100000, 100000);
      int m = a(c((String)paramMap.get("offsetY")), -100000, 100000);
      CloseableLayout.ClosePosition localClosePosition = a((String)paramMap.get("customClosePosition"), CloseableLayout.ClosePosition.TOP_RIGHT);
      boolean bool4 = a((String)paramMap.get("allowOffscreen"), true);
      this.d.onResize(i, j, k, m, localClosePosition, bool4);
      return;
    case 3:
      URI localURI4 = a((String)paramMap.get("url"), null);
      boolean bool3 = a((String)paramMap.get("shouldUseCustomClose"), false);
      this.d.onExpand(localURI4, bool3);
      return;
    case 4:
      boolean bool2 = a((String)paramMap.get("shouldUseCustomClose"), false);
      this.d.onUseCustomClose(bool2);
      return;
    case 5:
      URI localURI3 = f((String)paramMap.get("url"));
      this.d.onOpen(localURI3);
      return;
    case 6:
      boolean bool1 = e((String)paramMap.get("allowOrientationChange"));
      b localb = d((String)paramMap.get("forceOrientation"));
      this.d.onSetOrientationProperties(bool1, localb);
      return;
    case 7:
      URI localURI2 = f((String)paramMap.get("uri"));
      this.d.onPlayVideo(localURI2);
      return;
    case 8:
      URI localURI1 = f((String)paramMap.get("uri"));
      this.c.a(this.e.getContext(), localURI1.toString(), new MraidNativeCommandHandler.c()
      {
        public void onFailure(a paramAnonymousa)
        {
          MraidBridge.a(MraidBridge.this, paramMraidJavascriptCommand, paramAnonymousa.getMessage());
        }
      });
      return;
    case 9:
      this.c.a(this.e.getContext(), paramMap);
      return;
    case 10:
    }
    throw new a("Unspecified MRAID Javascript command");
  }

  void a(PlacementType paramPlacementType)
  {
    a("mraidbridge.setPlacementType(" + JSONObject.quote(paramPlacementType.a()) + ")");
  }

  void a(ViewState paramViewState)
  {
    a("mraidbridge.setState(" + JSONObject.quote(paramViewState.toJavascriptString()) + ")");
  }

  void a(String paramString)
  {
    if (this.e == null)
    {
      MoPubLog.SdkLogEvent localSdkLogEvent2 = MoPubLog.SdkLogEvent.CUSTOM;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = ("Attempted to inject Javascript into MRAID WebView while was not attached:\n\t" + paramString);
      MoPubLog.log(localSdkLogEvent2, arrayOfObject2);
      return;
    }
    MoPubLog.SdkLogEvent localSdkLogEvent1 = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = ("Injecting Javascript into MRAID WebView:\n\t" + paramString);
    MoPubLog.log(localSdkLogEvent1, arrayOfObject1);
    this.e.loadUrl("javascript:" + paramString);
  }

  void a(boolean paramBoolean)
  {
    a("mraidbridge.setIsViewable(" + paramBoolean + ")");
  }

  void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5)
  {
    a("mraidbridge.setSupports(" + paramBoolean1 + "," + paramBoolean2 + "," + paramBoolean3 + "," + paramBoolean4 + "," + paramBoolean5 + ")");
  }

  void b()
  {
    a("mraidbridge.notifyReadyEvent();");
  }

  // ERROR //
  @VisibleForTesting
  boolean b(String paramString)
  {
    // Byte code:
    //   0: new 224	java/net/URI
    //   3: dup
    //   4: aload_1
    //   5: invokespecial 225	java/net/URI:<init>	(Ljava/lang/String;)V
    //   8: pop
    //   9: aload_1
    //   10: invokestatic 490	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   13: astore_3
    //   14: aload_3
    //   15: invokevirtual 493	android/net/Uri:getScheme	()Ljava/lang/String;
    //   18: astore 4
    //   20: aload_3
    //   21: invokevirtual 496	android/net/Uri:getHost	()Ljava/lang/String;
    //   24: astore 5
    //   26: ldc_w 498
    //   29: aload 4
    //   31: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   34: ifeq +98 -> 132
    //   37: ldc_w 500
    //   40: aload 5
    //   42: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   45: ifeq +29 -> 74
    //   48: aload_0
    //   49: getfield 43	com/mopub/mraid/MraidBridge:b	Lcom/mopub/mraid/PlacementType;
    //   52: getstatic 503	com/mopub/mraid/PlacementType:INLINE	Lcom/mopub/mraid/PlacementType;
    //   55: if_acmpne +19 -> 74
    //   58: aload_0
    //   59: getfield 123	com/mopub/mraid/MraidBridge:d	Lcom/mopub/mraid/MraidBridge$MraidBridgeListener;
    //   62: ifnull +12 -> 74
    //   65: aload_0
    //   66: getfield 123	com/mopub/mraid/MraidBridge:d	Lcom/mopub/mraid/MraidBridge$MraidBridgeListener;
    //   69: invokeinterface 506 1 0
    //   74: iconst_1
    //   75: ireturn
    //   76: astore 12
    //   78: getstatic 263	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   81: astore 13
    //   83: iconst_1
    //   84: anewarray 4	java/lang/Object
    //   87: astore 14
    //   89: aload 14
    //   91: iconst_0
    //   92: new 50	java/lang/StringBuilder
    //   95: dup
    //   96: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   99: ldc_w 508
    //   102: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: aload_1
    //   106: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   109: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: aastore
    //   113: aload 13
    //   115: aload 14
    //   117: invokestatic 269	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   120: aload_0
    //   121: getstatic 512	com/mopub/mraid/MraidJavascriptCommand:UNSPECIFIED	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   124: ldc_w 514
    //   127: invokespecial 150	com/mopub/mraid/MraidBridge:a	(Lcom/mopub/mraid/MraidJavascriptCommand;Ljava/lang/String;)V
    //   130: iconst_1
    //   131: ireturn
    //   132: aload_0
    //   133: invokevirtual 356	com/mopub/mraid/MraidBridge:c	()Z
    //   136: ifeq +60 -> 196
    //   139: ldc_w 516
    //   142: aload 4
    //   144: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   147: ifne +49 -> 196
    //   150: new 50	java/lang/StringBuilder
    //   153: dup
    //   154: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   157: ldc_w 518
    //   160: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload_1
    //   164: ldc_w 520
    //   167: invokestatic 526	java/net/URLEncoder:encode	(Ljava/lang/String;Ljava/lang/String;)Ljava/lang/String;
    //   170: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   176: invokestatic 490	android/net/Uri:parse	(Ljava/lang/String;)Landroid/net/Uri;
    //   179: astore_3
    //   180: aload_3
    //   181: invokevirtual 496	android/net/Uri:getHost	()Ljava/lang/String;
    //   184: astore 5
    //   186: aload_3
    //   187: invokevirtual 493	android/net/Uri:getScheme	()Ljava/lang/String;
    //   190: astore 11
    //   192: aload 11
    //   194: astore 4
    //   196: ldc_w 516
    //   199: aload 4
    //   201: invokevirtual 82	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   204: ifeq +100 -> 304
    //   207: aload 5
    //   209: invokestatic 529	com/mopub/mraid/MraidJavascriptCommand:a	(Ljava/lang/String;)Lcom/mopub/mraid/MraidJavascriptCommand;
    //   212: astore 6
    //   214: aload_0
    //   215: aload 6
    //   217: aload_3
    //   218: invokestatic 535	com/mopub/network/MoPubRequestUtils:getQueryParamMap	(Landroid/net/Uri;)Ljava/util/Map;
    //   221: invokevirtual 537	com/mopub/mraid/MraidBridge:a	(Lcom/mopub/mraid/MraidJavascriptCommand;Ljava/util/Map;)V
    //   224: aload_0
    //   225: aload 6
    //   227: invokespecial 539	com/mopub/mraid/MraidBridge:a	(Lcom/mopub/mraid/MraidJavascriptCommand;)V
    //   230: iconst_1
    //   231: ireturn
    //   232: astore 8
    //   234: getstatic 263	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   237: astore 9
    //   239: iconst_1
    //   240: anewarray 4	java/lang/Object
    //   243: astore 10
    //   245: aload 10
    //   247: iconst_0
    //   248: new 50	java/lang/StringBuilder
    //   251: dup
    //   252: invokespecial 51	java/lang/StringBuilder:<init>	()V
    //   255: ldc_w 541
    //   258: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   261: aload_1
    //   262: invokevirtual 57	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: invokevirtual 64	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   268: aastore
    //   269: aload 9
    //   271: aload 10
    //   273: invokestatic 269	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   276: aload_0
    //   277: getstatic 544	com/mopub/mraid/MraidJavascriptCommand:OPEN	Lcom/mopub/mraid/MraidJavascriptCommand;
    //   280: ldc_w 546
    //   283: invokespecial 150	com/mopub/mraid/MraidBridge:a	(Lcom/mopub/mraid/MraidJavascriptCommand;Ljava/lang/String;)V
    //   286: iconst_0
    //   287: ireturn
    //   288: astore 7
    //   290: aload_0
    //   291: aload 6
    //   293: aload 7
    //   295: invokevirtual 551	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   298: invokespecial 150	com/mopub/mraid/MraidBridge:a	(Lcom/mopub/mraid/MraidJavascriptCommand;Ljava/lang/String;)V
    //   301: goto -77 -> 224
    //   304: iconst_0
    //   305: ireturn
    //   306: astore 7
    //   308: goto -18 -> 290
    //
    // Exception table:
    //   from	to	target	type
    //   0	9	76	java/net/URISyntaxException
    //   150	192	232	java/io/UnsupportedEncodingException
    //   214	224	288	com/mopub/mraid/a
    //   214	224	306	java/lang/IllegalArgumentException
  }

  boolean c()
  {
    ViewGestureDetector localViewGestureDetector = this.f;
    return (localViewGestureDetector != null) && (localViewGestureDetector.isClicked());
  }

  boolean d()
  {
    MraidWebView localMraidWebView = this.e;
    return (localMraidWebView != null) && (localMraidWebView.isMraidViewable());
  }

  boolean e()
  {
    return this.e != null;
  }

  boolean f()
  {
    return this.g;
  }

  public void notifyScreenMetrics(c paramc)
  {
    a("mraidbridge.setScreenSize(" + b(paramc.a()) + ");mraidbridge.setMaxSize(" + b(paramc.c()) + ");mraidbridge.setCurrentPosition(" + a(paramc.d()) + ");mraidbridge.setDefaultPosition(" + a(paramc.f()) + ")");
    a("mraidbridge.notifySizeChangeEvent(" + b(paramc.d()) + ")");
  }

  public void setContentHtml(String paramString)
  {
    if (this.e == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MRAID bridge called setContentHtml before WebView was attached" });
      return;
    }
    this.g = false;
    this.e.loadDataWithBaseURL(Networking.getBaseUrlScheme() + "://" + Constants.HOST + "/", paramString, "text/html", "UTF-8", null);
  }

  public void setContentUrl(String paramString)
  {
    if (this.e == null)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "MRAID bridge called setContentHtml while WebView was not attached" });
      return;
    }
    this.g = false;
    this.e.loadUrl(paramString);
  }

  public static abstract interface MraidBridgeListener
  {
    public abstract void onClose();

    public abstract boolean onConsoleMessage(ConsoleMessage paramConsoleMessage);

    public abstract void onExpand(URI paramURI, boolean paramBoolean)
      throws a;

    public abstract boolean onJsAlert(String paramString, JsResult paramJsResult);

    public abstract void onOpen(URI paramURI);

    public abstract void onPageFailedToLoad();

    public abstract void onPageLoaded();

    public abstract void onPlayVideo(URI paramURI);

    public abstract void onRenderProcessGone(MoPubErrorCode paramMoPubErrorCode);

    public abstract void onResize(int paramInt1, int paramInt2, int paramInt3, int paramInt4, CloseableLayout.ClosePosition paramClosePosition, boolean paramBoolean)
      throws a;

    public abstract void onSetOrientationProperties(boolean paramBoolean, b paramb)
      throws a;

    public abstract void onUseCustomClose(boolean paramBoolean);

    public abstract void onVisibilityChanged(boolean paramBoolean);
  }

  public static class MraidWebView extends BaseWebView
  {
    private OnVisibilityChangedListener b;
    private VisibilityTracker c;
    private boolean d;

    public MraidWebView(Context paramContext)
    {
      super();
      if (Build.VERSION.SDK_INT <= 22)
      {
        if (getVisibility() == 0);
        for (boolean bool = true; ; bool = false)
        {
          this.d = bool;
          return;
        }
      }
      this.c = new VisibilityTracker(paramContext);
      VisibilityTracker.VisibilityTrackerListener local1 = new VisibilityTracker.VisibilityTrackerListener()
      {
        public void onVisibilityChanged(List<View> paramAnonymousList1, List<View> paramAnonymousList2)
        {
          Preconditions.checkNotNull(paramAnonymousList1);
          Preconditions.checkNotNull(paramAnonymousList2);
          MraidBridge.MraidWebView.a(MraidBridge.MraidWebView.this, paramAnonymousList1.contains(MraidBridge.MraidWebView.this));
        }
      };
      this.c.setVisibilityTrackerListener(local1);
    }

    private void setMraidViewable(boolean paramBoolean)
    {
      if (this.d == paramBoolean);
      do
      {
        return;
        this.d = paramBoolean;
      }
      while (this.b == null);
      this.b.onVisibilityChanged(paramBoolean);
    }

    public void destroy()
    {
      super.destroy();
      this.c = null;
      this.b = null;
    }

    public boolean isMraidViewable()
    {
      return this.d;
    }

    protected void onVisibilityChanged(View paramView, int paramInt)
    {
      super.onVisibilityChanged(paramView, paramInt);
      if (this.c == null)
      {
        boolean bool = false;
        if (paramInt == 0)
          bool = true;
        setMraidViewable(bool);
        return;
      }
      if (paramInt == 0)
      {
        this.c.clear();
        this.c.addView(paramView, this, 0, 0, Integer.valueOf(1));
        return;
      }
      this.c.removeView(this);
      setMraidViewable(false);
    }

    void setVisibilityChangedListener(OnVisibilityChangedListener paramOnVisibilityChangedListener)
    {
      this.b = paramOnVisibilityChangedListener;
    }

    public static abstract interface OnVisibilityChangedListener
    {
      public abstract void onVisibilityChanged(boolean paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidBridge
 * JD-Core Version:    0.6.2
 */