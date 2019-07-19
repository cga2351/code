package com.mopub.volley.toolbox;

import android.os.Handler;
import android.os.Looper;
import com.mopub.volley.Cache;
import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Request.Priority;
import com.mopub.volley.Response;

public class ClearCacheRequest extends Request<Object>
{
  private final Cache a;
  private final Runnable b;

  public ClearCacheRequest(Cache paramCache, Runnable paramRunnable)
  {
    super(0, null, null);
    this.a = paramCache;
    this.b = paramRunnable;
  }

  protected Response<Object> a(NetworkResponse paramNetworkResponse)
  {
    return null;
  }

  protected void deliverResponse(Object paramObject)
  {
  }

  public Request.Priority getPriority()
  {
    return Request.Priority.IMMEDIATE;
  }

  public boolean isCanceled()
  {
    this.a.clear();
    if (this.b != null)
      new Handler(Looper.getMainLooper()).postAtFrontOfQueue(this.b);
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.ClearCacheRequest
 * JD-Core Version:    0.6.2
 */