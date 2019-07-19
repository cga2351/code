package com.mopub.mraid;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.webkit.WebSettings;
import com.mopub.common.ExternalViewabilitySessionManager;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdapterLogEvent;
import com.mopub.common.util.JavaScriptWebViewCallbacks;
import com.mopub.mobileads.AdViewController;
import com.mopub.mobileads.CustomEventBanner;
import com.mopub.mobileads.InternalCustomEventBannerListener;
import com.mopub.mobileads.MoPubErrorCode;
import java.lang.ref.WeakReference;
import java.util.Map;

class MraidBanner extends CustomEventBanner
{
  public static final String ADAPTER_NAME = MraidBanner.class.getSimpleName();
  private MraidController a;
  private InternalCustomEventBannerListener b;
  private MraidWebViewDebugListener c;
  private ExternalViewabilitySessionManager d;
  private boolean e = false;

  private boolean a(Map<String, String> paramMap)
  {
    return paramMap.containsKey("html-response-body");
  }

  protected void a()
  {
    if (this.d != null)
    {
      this.d.endDisplaySession();
      this.d = null;
    }
    if (this.a != null)
    {
      this.a.setMraidListener(null);
      this.a.destroy();
    }
  }

  // ERROR //
  protected void a(final Context paramContext, com.mopub.mobileads.CustomEventBanner.CustomEventBannerListener paramCustomEventBannerListener, Map<String, Object> paramMap, Map<String, String> paramMap1)
  {
    // Byte code:
    //   0: aload_0
    //   1: aload_2
    //   2: checkcast 69	com/mopub/mobileads/InternalCustomEventBannerListener
    //   5: putfield 37	com/mopub/mraid/MraidBanner:b	Lcom/mopub/mobileads/InternalCustomEventBannerListener;
    //   8: getstatic 75	com/mopub/common/logging/MoPubLog$AdapterLogEvent:LOAD_ATTEMPTED	Lcom/mopub/common/logging/MoPubLog$AdapterLogEvent;
    //   11: astore 8
    //   13: iconst_1
    //   14: anewarray 77	java/lang/Object
    //   17: astore 9
    //   19: aload 9
    //   21: iconst_0
    //   22: getstatic 26	com/mopub/mraid/MraidBanner:ADAPTER_NAME	Ljava/lang/String;
    //   25: aastore
    //   26: aload 8
    //   28: aload 9
    //   30: invokestatic 83	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   33: aload_0
    //   34: aload 4
    //   36: invokespecial 85	com/mopub/mraid/MraidBanner:a	(Ljava/util/Map;)Z
    //   39: ifeq +171 -> 210
    //   42: aload 4
    //   44: ldc 40
    //   46: invokeinterface 89 2 0
    //   51: checkcast 91	java/lang/String
    //   54: astore 12
    //   56: aload_3
    //   57: ldc 93
    //   59: invokeinterface 89 2 0
    //   64: astore 13
    //   66: aload 13
    //   68: instanceof 95
    //   71: ifeq +15 -> 86
    //   74: aload_0
    //   75: aload 13
    //   77: checkcast 95	java/lang/Boolean
    //   80: invokevirtual 99	java/lang/Boolean:booleanValue	()Z
    //   83: putfield 31	com/mopub/mraid/MraidBanner:e	Z
    //   86: aload_0
    //   87: aload_1
    //   88: aload_3
    //   89: ldc 101
    //   91: invokeinterface 89 2 0
    //   96: checkcast 103	com/mopub/common/AdReport
    //   99: getstatic 109	com/mopub/mraid/PlacementType:INLINE	Lcom/mopub/mraid/PlacementType;
    //   102: invokestatic 115	com/mopub/mobileads/factories/MraidControllerFactory:create	(Landroid/content/Context;Lcom/mopub/common/AdReport;Lcom/mopub/mraid/PlacementType;)Lcom/mopub/mraid/MraidController;
    //   105: putfield 55	com/mopub/mraid/MraidBanner:a	Lcom/mopub/mraid/MraidController;
    //   108: aload_0
    //   109: getfield 55	com/mopub/mraid/MraidBanner:a	Lcom/mopub/mraid/MraidController;
    //   112: aload_0
    //   113: getfield 117	com/mopub/mraid/MraidBanner:c	Lcom/mopub/mraid/MraidWebViewDebugListener;
    //   116: invokevirtual 121	com/mopub/mraid/MraidController:setDebugListener	(Lcom/mopub/mraid/MraidWebViewDebugListener;)V
    //   119: aload_0
    //   120: getfield 55	com/mopub/mraid/MraidBanner:a	Lcom/mopub/mraid/MraidController;
    //   123: new 123	com/mopub/mraid/MraidBanner$1
    //   126: dup
    //   127: aload_0
    //   128: invokespecial 126	com/mopub/mraid/MraidBanner$1:<init>	(Lcom/mopub/mraid/MraidBanner;)V
    //   131: invokevirtual 61	com/mopub/mraid/MraidController:setMraidListener	(Lcom/mopub/mraid/MraidController$MraidListener;)V
    //   134: aload_0
    //   135: getfield 55	com/mopub/mraid/MraidBanner:a	Lcom/mopub/mraid/MraidController;
    //   138: aload 12
    //   140: new 128	com/mopub/mraid/MraidBanner$2
    //   143: dup
    //   144: aload_0
    //   145: aload_1
    //   146: invokespecial 131	com/mopub/mraid/MraidBanner$2:<init>	(Lcom/mopub/mraid/MraidBanner;Landroid/content/Context;)V
    //   149: invokevirtual 135	com/mopub/mraid/MraidController:fillContent	(Ljava/lang/String;Lcom/mopub/mraid/MraidController$MraidWebViewCacheListener;)V
    //   152: return
    //   153: astore 5
    //   155: getstatic 138	com/mopub/common/logging/MoPubLog$AdapterLogEvent:LOAD_FAILED	Lcom/mopub/common/logging/MoPubLog$AdapterLogEvent;
    //   158: astore 6
    //   160: iconst_3
    //   161: anewarray 77	java/lang/Object
    //   164: astore 7
    //   166: aload 7
    //   168: iconst_0
    //   169: getstatic 26	com/mopub/mraid/MraidBanner:ADAPTER_NAME	Ljava/lang/String;
    //   172: aastore
    //   173: aload 7
    //   175: iconst_1
    //   176: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   179: invokevirtual 148	com/mopub/mobileads/MoPubErrorCode:getIntCode	()I
    //   182: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   185: aastore
    //   186: aload 7
    //   188: iconst_2
    //   189: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   192: aastore
    //   193: aload 6
    //   195: aload 7
    //   197: invokestatic 83	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   200: aload_2
    //   201: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   204: invokeinterface 160 2 0
    //   209: return
    //   210: getstatic 138	com/mopub/common/logging/MoPubLog$AdapterLogEvent:LOAD_FAILED	Lcom/mopub/common/logging/MoPubLog$AdapterLogEvent;
    //   213: astore 10
    //   215: iconst_3
    //   216: anewarray 77	java/lang/Object
    //   219: astore 11
    //   221: aload 11
    //   223: iconst_0
    //   224: getstatic 26	com/mopub/mraid/MraidBanner:ADAPTER_NAME	Ljava/lang/String;
    //   227: aastore
    //   228: aload 11
    //   230: iconst_1
    //   231: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   234: invokevirtual 148	com/mopub/mobileads/MoPubErrorCode:getIntCode	()I
    //   237: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   240: aastore
    //   241: aload 11
    //   243: iconst_2
    //   244: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   247: aastore
    //   248: aload 10
    //   250: aload 11
    //   252: invokestatic 83	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   255: aload_0
    //   256: getfield 37	com/mopub/mraid/MraidBanner:b	Lcom/mopub/mobileads/InternalCustomEventBannerListener;
    //   259: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   262: invokeinterface 161 2 0
    //   267: return
    //   268: astore 14
    //   270: getstatic 138	com/mopub/common/logging/MoPubLog$AdapterLogEvent:LOAD_FAILED	Lcom/mopub/common/logging/MoPubLog$AdapterLogEvent;
    //   273: astore 15
    //   275: iconst_3
    //   276: anewarray 77	java/lang/Object
    //   279: astore 16
    //   281: aload 16
    //   283: iconst_0
    //   284: getstatic 26	com/mopub/mraid/MraidBanner:ADAPTER_NAME	Ljava/lang/String;
    //   287: aastore
    //   288: aload 16
    //   290: iconst_1
    //   291: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   294: invokevirtual 148	com/mopub/mobileads/MoPubErrorCode:getIntCode	()I
    //   297: invokestatic 154	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   300: aastore
    //   301: aload 16
    //   303: iconst_2
    //   304: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   307: aastore
    //   308: aload 15
    //   310: aload 16
    //   312: invokestatic 83	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   315: aload_0
    //   316: getfield 37	com/mopub/mraid/MraidBanner:b	Lcom/mopub/mobileads/InternalCustomEventBannerListener;
    //   319: getstatic 144	com/mopub/mobileads/MoPubErrorCode:MRAID_LOAD_ERROR	Lcom/mopub/mobileads/MoPubErrorCode;
    //   322: invokeinterface 161 2 0
    //   327: return
    //
    // Exception table:
    //   from	to	target	type
    //   0	8	153	java/lang/ClassCastException
    //   86	108	268	java/lang/ClassCastException
  }

  protected void b()
  {
    if (this.a == null);
    do
    {
      return;
      this.a.loadJavascript(JavaScriptWebViewCallbacks.WEB_VIEW_DID_APPEAR.getJavascript());
    }
    while ((!this.e) || (this.d == null));
    Activity localActivity = (Activity)this.a.g().get();
    if (localActivity != null)
    {
      this.d.startDeferredDisplaySession(localActivity);
      return;
    }
    MoPubLog.AdapterLogEvent localAdapterLogEvent = MoPubLog.AdapterLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = ADAPTER_NAME;
    arrayOfObject[1] = "Lost the activity for deferred Viewability tracking. Dropping session.";
    MoPubLog.log(localAdapterLogEvent, arrayOfObject);
  }

  @VisibleForTesting
  public void setDebugListener(MraidWebViewDebugListener paramMraidWebViewDebugListener)
  {
    this.c = paramMraidWebViewDebugListener;
    if (this.a != null)
      this.a.setDebugListener(paramMraidWebViewDebugListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.mraid.MraidBanner
 * JD-Core Version:    0.6.2
 */