package com.mopub.common;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.Intents;
import com.mopub.exceptions.IntentNotResolvableException;
import com.mopub.exceptions.UrlParseException;
import com.mopub.network.TrackingRequest;
import java.net.URISyntaxException;
import java.util.List;

public enum UrlAction
{
  private final boolean a;

  static
  {
    // Byte code:
    //   0: new 24	com/mopub/common/UrlAction$1
    //   3: dup
    //   4: ldc 25
    //   6: iconst_0
    //   7: iconst_0
    //   8: invokespecial 29	com/mopub/common/UrlAction$1:<init>	(Ljava/lang/String;IZ)V
    //   11: putstatic 31	com/mopub/common/UrlAction:HANDLE_MOPUB_SCHEME	Lcom/mopub/common/UrlAction;
    //   14: new 33	com/mopub/common/UrlAction$3
    //   17: dup
    //   18: ldc 34
    //   20: iconst_1
    //   21: iconst_0
    //   22: invokespecial 35	com/mopub/common/UrlAction$3:<init>	(Ljava/lang/String;IZ)V
    //   25: putstatic 37	com/mopub/common/UrlAction:IGNORE_ABOUT_SCHEME	Lcom/mopub/common/UrlAction;
    //   28: new 39	com/mopub/common/UrlAction$4
    //   31: dup
    //   32: ldc 40
    //   34: iconst_2
    //   35: iconst_1
    //   36: invokespecial 41	com/mopub/common/UrlAction$4:<init>	(Ljava/lang/String;IZ)V
    //   39: putstatic 43	com/mopub/common/UrlAction:HANDLE_PHONE_SCHEME	Lcom/mopub/common/UrlAction;
    //   42: new 45	com/mopub/common/UrlAction$5
    //   45: dup
    //   46: ldc 46
    //   48: iconst_3
    //   49: iconst_1
    //   50: invokespecial 47	com/mopub/common/UrlAction$5:<init>	(Ljava/lang/String;IZ)V
    //   53: putstatic 49	com/mopub/common/UrlAction:OPEN_NATIVE_BROWSER	Lcom/mopub/common/UrlAction;
    //   56: new 51	com/mopub/common/UrlAction$6
    //   59: dup
    //   60: ldc 52
    //   62: iconst_4
    //   63: iconst_1
    //   64: invokespecial 53	com/mopub/common/UrlAction$6:<init>	(Ljava/lang/String;IZ)V
    //   67: putstatic 55	com/mopub/common/UrlAction:OPEN_APP_MARKET	Lcom/mopub/common/UrlAction;
    //   70: new 57	com/mopub/common/UrlAction$7
    //   73: dup
    //   74: ldc 58
    //   76: iconst_5
    //   77: iconst_1
    //   78: invokespecial 59	com/mopub/common/UrlAction$7:<init>	(Ljava/lang/String;IZ)V
    //   81: putstatic 61	com/mopub/common/UrlAction:OPEN_IN_APP_BROWSER	Lcom/mopub/common/UrlAction;
    //   84: new 63	com/mopub/common/UrlAction$8
    //   87: dup
    //   88: ldc 64
    //   90: bipush 6
    //   92: iconst_1
    //   93: invokespecial 65	com/mopub/common/UrlAction$8:<init>	(Ljava/lang/String;IZ)V
    //   96: putstatic 67	com/mopub/common/UrlAction:HANDLE_SHARE_TWEET	Lcom/mopub/common/UrlAction;
    //   99: new 69	com/mopub/common/UrlAction$9
    //   102: dup
    //   103: ldc 70
    //   105: bipush 7
    //   107: iconst_1
    //   108: invokespecial 71	com/mopub/common/UrlAction$9:<init>	(Ljava/lang/String;IZ)V
    //   111: putstatic 73	com/mopub/common/UrlAction:FOLLOW_DEEP_LINK_WITH_FALLBACK	Lcom/mopub/common/UrlAction;
    //   114: new 75	com/mopub/common/UrlAction$10
    //   117: dup
    //   118: ldc 76
    //   120: bipush 8
    //   122: iconst_1
    //   123: invokespecial 77	com/mopub/common/UrlAction$10:<init>	(Ljava/lang/String;IZ)V
    //   126: putstatic 79	com/mopub/common/UrlAction:FOLLOW_DEEP_LINK	Lcom/mopub/common/UrlAction;
    //   129: new 81	com/mopub/common/UrlAction$2
    //   132: dup
    //   133: ldc 82
    //   135: bipush 9
    //   137: iconst_0
    //   138: invokespecial 83	com/mopub/common/UrlAction$2:<init>	(Ljava/lang/String;IZ)V
    //   141: putstatic 85	com/mopub/common/UrlAction:NOOP	Lcom/mopub/common/UrlAction;
    //   144: bipush 10
    //   146: anewarray 2	com/mopub/common/UrlAction
    //   149: astore_0
    //   150: aload_0
    //   151: iconst_0
    //   152: getstatic 31	com/mopub/common/UrlAction:HANDLE_MOPUB_SCHEME	Lcom/mopub/common/UrlAction;
    //   155: aastore
    //   156: aload_0
    //   157: iconst_1
    //   158: getstatic 37	com/mopub/common/UrlAction:IGNORE_ABOUT_SCHEME	Lcom/mopub/common/UrlAction;
    //   161: aastore
    //   162: aload_0
    //   163: iconst_2
    //   164: getstatic 43	com/mopub/common/UrlAction:HANDLE_PHONE_SCHEME	Lcom/mopub/common/UrlAction;
    //   167: aastore
    //   168: aload_0
    //   169: iconst_3
    //   170: getstatic 49	com/mopub/common/UrlAction:OPEN_NATIVE_BROWSER	Lcom/mopub/common/UrlAction;
    //   173: aastore
    //   174: aload_0
    //   175: iconst_4
    //   176: getstatic 55	com/mopub/common/UrlAction:OPEN_APP_MARKET	Lcom/mopub/common/UrlAction;
    //   179: aastore
    //   180: aload_0
    //   181: iconst_5
    //   182: getstatic 61	com/mopub/common/UrlAction:OPEN_IN_APP_BROWSER	Lcom/mopub/common/UrlAction;
    //   185: aastore
    //   186: aload_0
    //   187: bipush 6
    //   189: getstatic 67	com/mopub/common/UrlAction:HANDLE_SHARE_TWEET	Lcom/mopub/common/UrlAction;
    //   192: aastore
    //   193: aload_0
    //   194: bipush 7
    //   196: getstatic 73	com/mopub/common/UrlAction:FOLLOW_DEEP_LINK_WITH_FALLBACK	Lcom/mopub/common/UrlAction;
    //   199: aastore
    //   200: aload_0
    //   201: bipush 8
    //   203: getstatic 79	com/mopub/common/UrlAction:FOLLOW_DEEP_LINK	Lcom/mopub/common/UrlAction;
    //   206: aastore
    //   207: aload_0
    //   208: bipush 9
    //   210: getstatic 85	com/mopub/common/UrlAction:NOOP	Lcom/mopub/common/UrlAction;
    //   213: aastore
    //   214: aload_0
    //   215: putstatic 87	com/mopub/common/UrlAction:b	[Lcom/mopub/common/UrlAction;
    //   218: return
  }

  private UrlAction(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }

  protected abstract void a(Context paramContext, Uri paramUri, UrlHandler paramUrlHandler, String paramString)
    throws IntentNotResolvableException;

  public void handleUrl(UrlHandler paramUrlHandler, Context paramContext, Uri paramUri, boolean paramBoolean, String paramString)
    throws IntentNotResolvableException
  {
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Ad event URL: " + paramUri);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
    if ((this.a) && (!paramBoolean))
      throw new IntentNotResolvableException("Attempted to handle action without user interaction.");
    a(paramContext, paramUri, paramUrlHandler, paramString);
  }

  public abstract boolean shouldTryHandlingUrl(Uri paramUri);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.UrlAction
 * JD-Core Version:    0.6.2
 */