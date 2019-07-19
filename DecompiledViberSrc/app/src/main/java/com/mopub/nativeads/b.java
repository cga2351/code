package com.mopub.nativeads;

import android.os.Handler;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.MoPubErrorCode;

final class b
{
  private final Handler a;
  private final Runnable b;
  private CustomEventNative c;
  private CustomEventNative.CustomEventNativeListener d;
  private volatile boolean e;

  b(CustomEventNative.CustomEventNativeListener paramCustomEventNativeListener)
  {
    Preconditions.checkNotNull(paramCustomEventNativeListener);
    this.d = paramCustomEventNativeListener;
    this.e = false;
    this.a = new Handler();
    this.b = new Runnable()
    {
      public void run()
      {
        if (b.a(b.this))
          return;
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("CustomEventNativeAdapter() failed with code " + MoPubErrorCode.NETWORK_TIMEOUT.getIntCode() + " and message " + MoPubErrorCode.NETWORK_TIMEOUT);
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
        b.this.a();
        b.b(b.this).onNativeAdFailed(NativeErrorCode.NETWORK_TIMEOUT);
      }
    };
  }

  private CustomEventNative.CustomEventNativeListener b()
  {
    return new CustomEventNative.CustomEventNativeListener()
    {
      public void onNativeAdFailed(NativeErrorCode paramAnonymousNativeErrorCode)
      {
        if (b.a(b.this))
          return;
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = ("onNativeAdFailed with code " + paramAnonymousNativeErrorCode.getIntCode() + " and message " + paramAnonymousNativeErrorCode);
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
        b.c(b.this);
        b.b(b.this).onNativeAdFailed(paramAnonymousNativeErrorCode);
      }

      public void onNativeAdLoaded(BaseNativeAd paramAnonymousBaseNativeAd)
      {
        if (b.a(b.this))
          return;
        MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "onNativeAdLoaded" });
        b.c(b.this);
        b.b(b.this).onNativeAdLoaded(paramAnonymousBaseNativeAd);
      }
    };
  }

  private void c()
  {
    try
    {
      if (!this.e)
      {
        this.e = true;
        this.a.removeCallbacks(this.b);
        this.c = null;
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  void a()
  {
    try
    {
      if (this.c != null)
        this.c.a();
      c();
      return;
    }
    catch (Exception localException)
    {
      while (true)
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = localException.toString();
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
      }
    }
  }

  // ERROR //
  public void loadNativeAd(android.content.Context paramContext, java.util.Map<java.lang.String, Object> paramMap, com.mopub.network.AdResponse paramAdResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokestatic 25	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   4: aload_2
    //   5: invokestatic 25	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   8: aload_3
    //   9: invokestatic 25	com/mopub/common/Preconditions:checkNotNull	(Ljava/lang/Object;)V
    //   12: aload_3
    //   13: invokevirtual 84	com/mopub/network/AdResponse:getCustomEventClassName	()Ljava/lang/String;
    //   16: astore 4
    //   18: getstatic 67	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   21: astore 5
    //   23: iconst_1
    //   24: anewarray 4	java/lang/Object
    //   27: astore 6
    //   29: aload 6
    //   31: iconst_0
    //   32: aload_3
    //   33: invokevirtual 87	com/mopub/network/AdResponse:getDspCreativeId	()Ljava/lang/String;
    //   36: aastore
    //   37: aload 5
    //   39: aload 6
    //   41: invokestatic 77	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   44: aload_0
    //   45: aload 4
    //   47: invokestatic 93	com/mopub/nativeads/factories/CustomEventNativeFactory:create	(Ljava/lang/String;)Lcom/mopub/nativeads/CustomEventNative;
    //   50: putfield 53	com/mopub/nativeads/b:c	Lcom/mopub/nativeads/CustomEventNative;
    //   53: aload_3
    //   54: invokevirtual 97	com/mopub/network/AdResponse:hasJson	()Z
    //   57: ifeq +16 -> 73
    //   60: aload_2
    //   61: ldc 99
    //   63: aload_3
    //   64: invokevirtual 103	com/mopub/network/AdResponse:getJsonBody	()Lorg/json/JSONObject;
    //   67: invokeinterface 109 3 0
    //   72: pop
    //   73: aload_2
    //   74: ldc 111
    //   76: aload_3
    //   77: invokevirtual 114	com/mopub/network/AdResponse:getClickTrackingUrl	()Ljava/lang/String;
    //   80: invokeinterface 109 3 0
    //   85: pop
    //   86: aload_0
    //   87: getfield 53	com/mopub/nativeads/b:c	Lcom/mopub/nativeads/CustomEventNative;
    //   90: aload_1
    //   91: aload_0
    //   92: invokespecial 116	com/mopub/nativeads/b:b	()Lcom/mopub/nativeads/CustomEventNative$CustomEventNativeListener;
    //   95: aload_2
    //   96: aload_3
    //   97: invokevirtual 120	com/mopub/network/AdResponse:getServerExtras	()Ljava/util/Map;
    //   100: invokevirtual 123	com/mopub/nativeads/CustomEventNative:a	(Landroid/content/Context;Lcom/mopub/nativeads/CustomEventNative$CustomEventNativeListener;Ljava/util/Map;Ljava/util/Map;)V
    //   103: aload_3
    //   104: sipush 30000
    //   107: invokevirtual 127	com/mopub/network/AdResponse:getAdTimeoutMillis	(I)Ljava/lang/Integer;
    //   110: invokevirtual 133	java/lang/Integer:intValue	()I
    //   113: i2l
    //   114: lstore 14
    //   116: aload_0
    //   117: getfield 34	com/mopub/nativeads/b:a	Landroid/os/Handler;
    //   120: aload_0
    //   121: getfield 41	com/mopub/nativeads/b:b	Ljava/lang/Runnable;
    //   124: lload 14
    //   126: invokevirtual 137	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   129: pop
    //   130: return
    //   131: astore 7
    //   133: getstatic 67	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   136: astore 8
    //   138: iconst_1
    //   139: anewarray 4	java/lang/Object
    //   142: astore 9
    //   144: aload 9
    //   146: iconst_0
    //   147: new 139	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   154: ldc 142
    //   156: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   159: getstatic 152	com/mopub/mobileads/MoPubErrorCode:ADAPTER_NOT_FOUND	Lcom/mopub/mobileads/MoPubErrorCode;
    //   162: invokevirtual 155	com/mopub/mobileads/MoPubErrorCode:getIntCode	()I
    //   165: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc 160
    //   170: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: getstatic 152	com/mopub/mobileads/MoPubErrorCode:ADAPTER_NOT_FOUND	Lcom/mopub/mobileads/MoPubErrorCode;
    //   176: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   179: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   182: aastore
    //   183: aload 8
    //   185: aload 9
    //   187: invokestatic 77	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   190: aload_0
    //   191: getfield 27	com/mopub/nativeads/b:d	Lcom/mopub/nativeads/CustomEventNative$CustomEventNativeListener;
    //   194: getstatic 170	com/mopub/nativeads/NativeErrorCode:NATIVE_ADAPTER_NOT_FOUND	Lcom/mopub/nativeads/NativeErrorCode;
    //   197: invokeinterface 176 2 0
    //   202: return
    //   203: astore 11
    //   205: getstatic 67	com/mopub/common/logging/MoPubLog$SdkLogEvent:CUSTOM	Lcom/mopub/common/logging/MoPubLog$SdkLogEvent;
    //   208: astore 12
    //   210: iconst_1
    //   211: anewarray 4	java/lang/Object
    //   214: astore 13
    //   216: aload 13
    //   218: iconst_0
    //   219: new 139	java/lang/StringBuilder
    //   222: dup
    //   223: invokespecial 140	java/lang/StringBuilder:<init>	()V
    //   226: ldc 142
    //   228: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   231: getstatic 152	com/mopub/mobileads/MoPubErrorCode:ADAPTER_NOT_FOUND	Lcom/mopub/mobileads/MoPubErrorCode;
    //   234: invokevirtual 155	com/mopub/mobileads/MoPubErrorCode:getIntCode	()I
    //   237: invokevirtual 158	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   240: ldc 160
    //   242: invokevirtual 146	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   245: getstatic 152	com/mopub/mobileads/MoPubErrorCode:ADAPTER_NOT_FOUND	Lcom/mopub/mobileads/MoPubErrorCode;
    //   248: invokevirtual 163	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   251: invokevirtual 164	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   254: aastore
    //   255: aload 12
    //   257: aload 13
    //   259: invokestatic 77	com/mopub/common/logging/MoPubLog:log	(Lcom/mopub/common/logging/MoPubLog$a;[Ljava/lang/Object;)V
    //   262: aload_0
    //   263: getfield 27	com/mopub/nativeads/b:d	Lcom/mopub/nativeads/CustomEventNative$CustomEventNativeListener;
    //   266: getstatic 170	com/mopub/nativeads/NativeErrorCode:NATIVE_ADAPTER_NOT_FOUND	Lcom/mopub/nativeads/NativeErrorCode;
    //   269: invokeinterface 176 2 0
    //   274: return
    //
    // Exception table:
    //   from	to	target	type
    //   44	53	131	java/lang/Exception
    //   86	130	203	java/lang/Exception
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.b
 * JD-Core Version:    0.6.2
 */