package com.mopub.network;

import android.content.Context;
import android.os.Handler;
import android.text.TextUtils;
import com.mopub.common.AdFormat;
import com.mopub.common.Preconditions;
import com.mopub.common.logging.MoPubLog;
import com.mopub.common.logging.MoPubLog.AdLogEvent;
import com.mopub.common.logging.MoPubLog.SdkLogEvent;
import com.mopub.mobileads.MoPubError;
import com.mopub.volley.Request;
import com.mopub.volley.RequestQueue;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.VolleyError;
import java.lang.ref.WeakReference;

public class AdLoader
{
  protected MultiAdResponse a;
  protected AdResponse b = null;
  private final MultiAdRequest.Listener c;
  private final WeakReference<Context> d;
  private final Listener e;
  private MultiAdRequest f;
  private final Object g = new Object();
  private a h;
  private volatile boolean i;
  private volatile boolean j;
  private boolean k;
  private Handler l;

  public AdLoader(String paramString1, AdFormat paramAdFormat, String paramString2, Context paramContext, Listener paramListener)
  {
    if (!TextUtils.isEmpty(paramString1));
    for (boolean bool = true; ; bool = false)
    {
      Preconditions.checkArgument(bool);
      Preconditions.checkNotNull(paramAdFormat);
      Preconditions.checkNotNull(paramContext);
      Preconditions.checkNotNull(paramListener);
      this.d = new WeakReference(paramContext);
      this.e = paramListener;
      this.l = new Handler();
      this.c = new MultiAdRequest.Listener()
      {
        public void onErrorResponse(VolleyError paramAnonymousVolleyError)
        {
          MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.RESPONSE_RECEIVED;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = paramAnonymousVolleyError.getMessage();
          MoPubLog.log(localAdLogEvent, arrayOfObject);
          AdLoader.a(AdLoader.this, true);
          AdLoader.b(AdLoader.this, false);
          AdLoader.a(AdLoader.this, paramAnonymousVolleyError);
        }

        public void onSuccessResponse(MultiAdResponse paramAnonymousMultiAdResponse)
        {
          synchronized (AdLoader.a(AdLoader.this))
          {
            AdLoader.b(AdLoader.this, false);
            AdLoader.this.a = paramAnonymousMultiAdResponse;
            if (AdLoader.this.a.hasNext())
              AdLoader.a(AdLoader.this, AdLoader.this.a.next());
            return;
          }
        }
      };
      this.i = false;
      this.j = false;
      this.f = new MultiAdRequest(paramString1, paramAdFormat, paramString2, paramContext, this.c);
      return;
    }
  }

  private Request<?> a(MultiAdRequest paramMultiAdRequest, Context paramContext)
  {
    Preconditions.checkNotNull(paramMultiAdRequest);
    if (paramContext == null)
      return null;
    String str = "<no body>";
    if (paramMultiAdRequest.getBody() != null)
      str = new String(paramMultiAdRequest.getBody());
    MoPubLog.AdLogEvent localAdLogEvent = MoPubLog.AdLogEvent.REQUESTED;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramMultiAdRequest.getUrl();
    arrayOfObject[1] = str;
    MoPubLog.log(localAdLogEvent, arrayOfObject);
    this.i = true;
    MoPubRequestQueue localMoPubRequestQueue = Networking.getRequestQueue(paramContext);
    this.f = paramMultiAdRequest;
    localMoPubRequestQueue.add(paramMultiAdRequest);
    return paramMultiAdRequest;
  }

  private void a(MoPubError paramMoPubError)
  {
    if (paramMoPubError == null)
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Must provide error code to report creative download error" });
    Context localContext;
    do
    {
      return;
      localContext = (Context)this.d.get();
      if ((localContext == null) || (this.b == null))
      {
        MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Cannot send creative mFailed analytics." });
        return;
      }
    }
    while (this.h == null);
    this.h.a(localContext, paramMoPubError);
    this.h.b(localContext, paramMoPubError);
  }

  private void a(AdResponse paramAdResponse)
  {
    Preconditions.checkNotNull(paramAdResponse);
    Context localContext = (Context)this.d.get();
    this.h = new a(paramAdResponse);
    this.h.a(localContext);
    if (this.e != null)
    {
      this.b = paramAdResponse;
      this.e.onSuccess(paramAdResponse);
    }
  }

  private void a(VolleyError paramVolleyError)
  {
    Preconditions.checkNotNull(paramVolleyError);
    this.b = null;
    if (this.e != null)
    {
      if ((paramVolleyError instanceof MoPubNetworkError))
        this.e.onErrorResponse(paramVolleyError);
    }
    else
      return;
    this.e.onErrorResponse(new MoPubNetworkError(paramVolleyError.getMessage(), paramVolleyError.getCause(), MoPubNetworkError.Reason.UNSPECIFIED));
  }

  public void creativeDownloadSuccess()
  {
    this.k = true;
    if (this.h == null)
    {
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Response analytics should not be null here" });
      return;
    }
    Context localContext = (Context)this.d.get();
    if ((localContext == null) || (this.b == null))
    {
      MoPubLog.log(MoPubLog.AdLogEvent.CUSTOM, new Object[] { "Cannot send 'x-after-load-url' analytics." });
      return;
    }
    this.h.a(localContext, null);
    this.h.b(localContext);
  }

  public boolean hasMoreAds()
  {
    if (this.j);
    MultiAdResponse localMultiAdResponse;
    do
    {
      do
        return false;
      while (this.k);
      localMultiAdResponse = this.a;
    }
    while ((localMultiAdResponse != null) && (!localMultiAdResponse.hasNext()) && (localMultiAdResponse.a()));
    return true;
  }

  public boolean isFailed()
  {
    return this.j;
  }

  public boolean isRunning()
  {
    return this.i;
  }

  public Request<?> loadNextAd(MoPubError paramMoPubError)
  {
    if (this.i)
      return this.f;
    if (this.j)
    {
      this.l.post(new Runnable()
      {
        public void run()
        {
          AdLoader.a(AdLoader.this, new MoPubNetworkError(MoPubNetworkError.Reason.UNSPECIFIED));
        }
      });
      return null;
    }
    synchronized (this.g)
    {
      if (this.a != null)
        break label164;
      if (RequestRateTracker.getInstance().a(this.f.b))
      {
        MoPubLog.SdkLogEvent localSdkLogEvent = MoPubLog.SdkLogEvent.CUSTOM;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = (this.f.b + " is blocked by request rate limiting.");
        MoPubLog.log(localSdkLogEvent, arrayOfObject);
        this.l.post(new Runnable()
        {
          public void run()
          {
            AdLoader.a(AdLoader.this, new MoPubNetworkError(MoPubNetworkError.Reason.NO_FILL));
          }
        });
        return null;
      }
    }
    Request localRequest2 = a(this.f, (Context)this.d.get());
    return localRequest2;
    label164: if (paramMoPubError != null)
      a(paramMoPubError);
    if (this.a.hasNext())
    {
      final AdResponse localAdResponse = this.a.next();
      this.l.post(new Runnable()
      {
        public void run()
        {
          AdLoader.a(AdLoader.this, localAdResponse);
        }
      });
      MultiAdRequest localMultiAdRequest = this.f;
      return localMultiAdRequest;
    }
    if (!this.a.a())
    {
      this.f = new MultiAdRequest(this.a.getFailURL(), this.f.a, this.f.b, (Context)this.d.get(), this.c);
      Request localRequest1 = a(this.f, (Context)this.d.get());
      return localRequest1;
    }
    this.l.post(new Runnable()
    {
      public void run()
      {
        AdLoader.a(AdLoader.this, new MoPubNetworkError(MoPubNetworkError.Reason.NO_FILL));
      }
    });
    return null;
  }

  public static abstract interface Listener extends Response.ErrorListener
  {
    public abstract void onSuccess(AdResponse paramAdResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.AdLoader
 * JD-Core Version:    0.6.2
 */