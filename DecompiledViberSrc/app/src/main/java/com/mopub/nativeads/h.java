package com.mopub.nativeads;

import android.content.Context;
import android.os.Handler;
import com.mopub.common.Constants;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.common.util.DeviceUtils;
import com.mopub.mobileads.MoPubErrorCode;
import com.mopub.network.MoPubNetworkError;
import com.mopub.network.MoPubNetworkError.Reason;
import com.mopub.network.Networking;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyError;

class h
  implements PositioningSource
{
  private int a = 300000;
  private final Context b;
  private final Handler c;
  private final Runnable d;
  private final Response.Listener<MoPubNativeAdPositioning.MoPubClientPositioning> e;
  private final Response.ErrorListener f;
  private PositioningSource.PositioningListener g;
  private int h;
  private String i;
  private PositioningRequest j;

  h(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new Handler();
    this.d = new Runnable()
    {
      public void run()
      {
        h.a(h.this);
      }
    };
    this.e = new Response.Listener()
    {
      public void onResponse(MoPubNativeAdPositioning.MoPubClientPositioning paramAnonymousMoPubClientPositioning)
      {
        h.a(h.this, paramAnonymousMoPubClientPositioning);
      }
    };
    this.f = new Response.ErrorListener()
    {
      public void onErrorResponse(VolleyError paramAnonymousVolleyError)
      {
        if ((!(paramAnonymousVolleyError instanceof MoPubNetworkError)) || (((MoPubNetworkError)paramAnonymousVolleyError).getReason().equals(MoPubNetworkError.Reason.WARMING_UP)))
        {
          MoPubLog.log(MoPubLog.SdkLogEvent.ERROR, new Object[] { "Failed to load positioning data", paramAnonymousVolleyError });
          if ((paramAnonymousVolleyError.networkResponse == null) && (!DeviceUtils.isNetworkAvailable(h.b(h.this))))
          {
            MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = String.valueOf(MoPubErrorCode.NO_CONNECTION);
            MoPubLog.log(localSdkLogEvent, arrayOfObject);
          }
        }
        h.c(h.this);
      }
    };
  }

  private void a()
  {
    MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = ("Loading positioning from: " + this.i);
    MoPubLog.log(localSdkLogEvent, arrayOfObject);
    this.j = new PositioningRequest(this.b, this.i, this.e, this.f);
    Networking.getRequestQueue(this.b).add(this.j);
  }

  private void a(MoPubNativeAdPositioning.MoPubClientPositioning paramMoPubClientPositioning)
  {
    if (this.g != null)
      this.g.onLoad(paramMoPubClientPositioning);
    this.g = null;
    this.h = 0;
  }

  private void b()
  {
    int k = (int)(1000.0D * Math.pow(2.0D, 1 + this.h));
    if (k >= this.a)
    {
      MoPubLog.log(MoPubLog.SdkLogEvent.CUSTOM, new Object[] { "Error downloading positioning information" });
      if (this.g != null)
        this.g.onFailed();
      this.g = null;
      return;
    }
    this.h = (1 + this.h);
    this.c.postDelayed(this.d, k);
  }

  public void loadPositions(String paramString, PositioningSource.PositioningListener paramPositioningListener)
  {
    if (this.j != null)
    {
      this.j.cancel();
      this.j = null;
    }
    if (this.h > 0)
    {
      this.c.removeCallbacks(this.d);
      this.h = 0;
    }
    this.g = paramPositioningListener;
    this.i = new g(this.b).withAdUnitId(paramString).generateUrlString(Constants.HOST);
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.h
 * JD-Core Version:    0.6.2
 */