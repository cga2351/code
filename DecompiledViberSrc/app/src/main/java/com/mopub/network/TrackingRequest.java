package com.mopub.network;

import android.content.Context;
import android.text.TextUtils;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.VastErrorCode;
import com.mopub.mobileads.VastMacroHelper;
import com.mopub.mobileads.VastTracker;
import com.mopub.volley.DefaultRetryPolicy;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;
import com.mopub.volley.toolbox.HttpHeaderParser;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TrackingRequest extends MoPubRequest<Void>
{
  private final Listener a;

  private TrackingRequest(Context paramContext, String paramString, Listener paramListener)
  {
    super(paramContext, paramString, paramListener);
    this.a = paramListener;
    setShouldCache(false);
    setRetryPolicy(new DefaultRetryPolicy(2500, 0, 1.0F));
  }

  public static void makeTrackingHttpRequest(Iterable<String> paramIterable, Context paramContext)
  {
    makeTrackingHttpRequest(paramIterable, paramContext, null);
  }

  public static void makeTrackingHttpRequest(Iterable<String> paramIterable, Context paramContext, Listener paramListener)
  {
    if ((paramIterable == null) || (paramContext == null));
    while (true)
    {
      return;
      MoPubRequestQueue localMoPubRequestQueue = Networking.getRequestQueue(paramContext);
      Iterator localIterator = paramIterable.iterator();
      while (localIterator.hasNext())
      {
        final String str = (String)localIterator.next();
        if (!TextUtils.isEmpty(str))
          localMoPubRequestQueue.add(new TrackingRequest(paramContext, str, new Listener()
          {
            public void onErrorResponse(VolleyError paramAnonymousVolleyError)
            {
              MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = ("Failed to hit tracking endpoint: " + str);
              MoPubLog.log(localSdkLogEvent, arrayOfObject);
              if (this.a != null)
                this.a.onErrorResponse(paramAnonymousVolleyError);
            }

            public void onResponse(String paramAnonymousString)
            {
              MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
              Object[] arrayOfObject = new Object[1];
              arrayOfObject[0] = ("Successfully hit tracking endpoint: " + paramAnonymousString);
              MoPubLog.log(localSdkLogEvent, arrayOfObject);
              if (this.a != null)
                this.a.onResponse(paramAnonymousString);
            }
          }));
      }
    }
  }

  public static void makeTrackingHttpRequest(String paramString, Context paramContext)
  {
    makeTrackingHttpRequest(paramString, paramContext, null);
  }

  public static void makeTrackingHttpRequest(String paramString, Context paramContext, Listener paramListener)
  {
    if (!TextUtils.isEmpty(paramString))
      makeTrackingHttpRequest(Arrays.asList(new String[] { paramString }), paramContext, paramListener);
  }

  public static void makeVastTrackingHttpRequest(List<VastTracker> paramList, VastErrorCode paramVastErrorCode, Integer paramInteger, String paramString, Context paramContext)
  {
    Preconditions.checkNotNull(paramList);
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      VastTracker localVastTracker = (VastTracker)localIterator.next();
      if ((localVastTracker != null) && ((!localVastTracker.isTracked()) || (localVastTracker.isRepeatable())))
      {
        localArrayList.add(localVastTracker.getContent());
        localVastTracker.setTracked();
      }
    }
    makeTrackingHttpRequest(new VastMacroHelper(localArrayList).withErrorCode(paramVastErrorCode).withContentPlayHead(paramInteger).withAssetUri(paramString).getUris(), paramContext);
  }

  protected Response<Void> a(NetworkResponse paramNetworkResponse)
  {
    if (paramNetworkResponse.statusCode != 200)
      return Response.error(new MoPubNetworkError("Failed to log tracking request. Response code: " + paramNetworkResponse.statusCode + " for url: " + getUrl(), MoPubNetworkError.Reason.TRACKING_FAILURE));
    return Response.success(null, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
  }

  public void deliverResponse(Void paramVoid)
  {
    if (this.a != null)
      this.a.onResponse(getUrl());
  }

  public static abstract interface Listener extends Response.ErrorListener
  {
    public abstract void onResponse(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.TrackingRequest
 * JD-Core Version:    0.6.2
 */