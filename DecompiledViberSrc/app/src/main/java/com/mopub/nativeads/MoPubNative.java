package com.mopub.nativeads;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Constants;
import com.mopub.common.Preconditions;
import com.mopub.common.VisibleForTesting;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.common.util.ManifestUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.AdLoader;
import com.mopub.network.AdLoader.Listener;
import com.mopub.network.AdResponse;
import com.mopub.network.MoPubNetworkError;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.TreeMap;

public class MoPubNative
{
  static final MoPubNativeNetworkListener a = new MoPubNativeNetworkListener()
  {
    public void onNativeFail(NativeErrorCode paramAnonymousNativeErrorCode)
    {
    }

    public void onNativeLoad(NativeAd paramAnonymousNativeAd)
    {
      paramAnonymousNativeAd.destroy();
    }
  };
  AdRendererRegistry b;
  private final WeakReference<Context> c;
  private final String d;
  private MoPubNativeNetworkListener e;
  private Map<String, Object> f = new TreeMap();
  private AdLoader g;
  private b h;
  private final AdLoader.Listener i;
  private Request j;

  @VisibleForTesting
  public MoPubNative(Context paramContext, String paramString, AdRendererRegistry paramAdRendererRegistry, MoPubNativeNetworkListener paramMoPubNativeNetworkListener)
  {
    Preconditions.checkNotNull(paramContext, "context may not be null.");
    Preconditions.checkNotNull(paramString, "AdUnitId may not be null.");
    Preconditions.checkNotNull(paramAdRendererRegistry, "AdRendererRegistry may not be null.");
    Preconditions.checkNotNull(paramMoPubNativeNetworkListener, "MoPubNativeNetworkListener may not be null.");
    ManifestUtils.checkNativeActivitiesDeclared(paramContext);
    this.c = new WeakReference(paramContext);
    this.d = paramString;
    this.e = paramMoPubNativeNetworkListener;
    this.b = paramAdRendererRegistry;
    this.i = new AdLoader.Listener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        MoPubNative.this.a(paramAnonymousVolleyError);
      }

      public void onSuccess(AdResponse paramAnonymousAdResponse)
      {
        MoPubNative.a(MoPubNative.this, paramAnonymousAdResponse);
      }
    };
  }

  public MoPubNative(Context paramContext, String paramString, MoPubNativeNetworkListener paramMoPubNativeNetworkListener)
  {
    this(paramContext, paramString, new AdRendererRegistry(), paramMoPubNativeNetworkListener);
  }

  private void a(RequestParameters paramRequestParameters, Integer paramInteger)
  {
    Context localContext = a();
    if (localContext == null)
      return;
    MoPubLog.log(MoPubLog.AdLogEvent.LOAD_ATTEMPTED, new Object[0]);
    e locale = new e(localContext).withAdUnitId(this.d).a(paramRequestParameters);
    if (paramInteger != null)
      locale.a(paramInteger.intValue());
    String str = locale.generateUrlString(Constants.HOST);
    if (str != null)
    {
      MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.CUSTOM;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = ("MoPubNative Loading ad from: " + str);
      MoPubLog.log(localAdLogEvent, arrayOfObject);
    }
    a(str, null);
  }

  private void a(final AdResponse paramAdResponse)
  {
    Context localContext = a();
    if (localContext == null)
      return;
    CustomEventNative.CustomEventNativeListener local3 = new CustomEventNative.CustomEventNativeListener()
    {
      public void onNativeAdFailed(NativeErrorCode paramAnonymousNativeErrorCode)
      {
        MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.LOAD_FAILED;
        Object[] arrayOfObject = new Object[2];
        arrayOfObject[0] = Integer.valueOf(paramAnonymousNativeErrorCode.getIntCode());
        arrayOfObject[1] = paramAnonymousNativeErrorCode.toString();
        MoPubLog.log(localAdLogEvent, arrayOfObject);
        MoPubNative.a(MoPubNative.this, null);
        MoPubNative.this.a("", paramAnonymousNativeErrorCode);
      }

      public void onNativeAdLoaded(BaseNativeAd paramAnonymousBaseNativeAd)
      {
        MoPubLog.log(MoPubLog.AdLogEvent.LOAD_SUCCESS, new Object[0]);
        MoPubNative.a(MoPubNative.this, null);
        Context localContext = MoPubNative.this.a();
        if (localContext == null)
          return;
        MoPubAdRenderer localMoPubAdRenderer = MoPubNative.this.b.getRendererForAd(paramAnonymousBaseNativeAd);
        if (localMoPubAdRenderer == null)
        {
          onNativeAdFailed(NativeErrorCode.NATIVE_RENDERER_CONFIGURATION_ERROR);
          return;
        }
        if (MoPubNative.a(MoPubNative.this) != null)
          MoPubNative.a(MoPubNative.this).creativeDownloadSuccess();
        MoPubNative.c(MoPubNative.this).onNativeLoad(new NativeAd(localContext, paramAdResponse, MoPubNative.b(MoPubNative.this), paramAnonymousBaseNativeAd, localMoPubAdRenderer));
      }
    };
    if (this.h != null)
    {
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Native adapter is not null." });
      this.h.a();
    }
    this.h = new b(local3);
    this.h.loadNativeAd(localContext, this.f, paramAdResponse);
  }

  @VisibleForTesting
  Context a()
  {
    Context localContext = (Context)this.c.get();
    if (localContext == null)
    {
      destroy();
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Weak reference to Context in MoPubNative became null. This instance of MoPubNative is destroyed and No more requests will be processed." });
    }
    return localContext;
  }

  @VisibleForTesting
  void a(VolleyError paramVolleyError)
  {
    MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Native ad request failed.", paramVolleyError });
    if ((paramVolleyError instanceof MoPubNetworkError))
    {
      MoPubNetworkError localMoPubNetworkError = (MoPubNetworkError)paramVolleyError;
      switch (4.a[localMoPubNetworkError.getReason().ordinal()])
      {
      default:
        this.e.onNativeFail(NativeErrorCode.UNSPECIFIED);
        return;
      case 1:
        this.e.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
        return;
      case 2:
        this.e.onNativeFail(NativeErrorCode.INVALID_RESPONSE);
        return;
      case 3:
        MoPubLog.AdLogEvent localAdLogEvent2 = MoPubLog.AdLogEvent.CUSTOM;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = MoPubErrorCode.WARMUP;
        MoPubLog.log(localAdLogEvent2, arrayOfObject2);
        this.e.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
        return;
      case 4:
      }
      this.e.onNativeFail(NativeErrorCode.EMPTY_AD_RESPONSE);
      return;
    }
    NetworkResponse localNetworkResponse = paramVolleyError.networkResponse;
    if ((localNetworkResponse != null) && (localNetworkResponse.statusCode >= 500) && (localNetworkResponse.statusCode < 600))
    {
      this.e.onNativeFail(NativeErrorCode.SERVER_ERROR_RESPONSE_CODE);
      return;
    }
    if ((localNetworkResponse == null) && (!DeviceUtils.isNetworkAvailable((Context)this.c.get())))
    {
      MoPubLog.AdLogEvent localAdLogEvent1 = MoPubLog.AdLogEvent.CUSTOM;
      Object[] arrayOfObject1 = new Object[1];
      arrayOfObject1[0] = MoPubErrorCode.NO_CONNECTION;
      MoPubLog.log(localAdLogEvent1, arrayOfObject1);
      this.e.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
      return;
    }
    this.e.onNativeFail(NativeErrorCode.UNSPECIFIED);
  }

  void a(String paramString, NativeErrorCode paramNativeErrorCode)
  {
    Context localContext = a();
    if (localContext == null)
      return;
    if ((this.g == null) || (!this.g.hasMoreAds()))
    {
      if (TextUtils.isEmpty(paramString))
      {
        MoPubNativeNetworkListener localMoPubNativeNetworkListener = this.e;
        if (paramNativeErrorCode == null)
          paramNativeErrorCode = NativeErrorCode.INVALID_REQUEST_URL;
        localMoPubNativeNetworkListener.onNativeFail(paramNativeErrorCode);
        return;
      }
      this.g = new AdLoader(paramString, AdFormat.NATIVE, this.d, localContext, this.i);
    }
    this.j = this.g.loadNextAd(paramNativeErrorCode);
  }

  public void destroy()
  {
    this.c.clear();
    if (this.j != null)
    {
      this.j.cancel();
      this.j = null;
    }
    this.g = null;
    this.e = a;
  }

  public void makeRequest()
  {
    makeRequest((RequestParameters)null);
  }

  public void makeRequest(RequestParameters paramRequestParameters)
  {
    makeRequest(paramRequestParameters, null);
  }

  public void makeRequest(RequestParameters paramRequestParameters, Integer paramInteger)
  {
    Context localContext = a();
    if (localContext == null)
      return;
    if (!DeviceUtils.isNetworkAvailable(localContext))
    {
      this.e.onNativeFail(NativeErrorCode.CONNECTION_ERROR);
      return;
    }
    a(paramRequestParameters, paramInteger);
  }

  public void registerAdRenderer(MoPubAdRenderer paramMoPubAdRenderer)
  {
    this.b.registerAdRenderer(paramMoPubAdRenderer);
  }

  public void setLocalExtras(Map<String, Object> paramMap)
  {
    if (paramMap == null)
    {
      this.f = new TreeMap();
      return;
    }
    this.f = new TreeMap(paramMap);
  }

  public static abstract interface MoPubNativeNetworkListener
  {
    public abstract void onNativeFail(NativeErrorCode paramNativeErrorCode);

    public abstract void onNativeLoad(NativeAd paramNativeAd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.MoPubNative
 * JD-Core Version:    0.6.2
 */