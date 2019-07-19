package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import com.mopub.volley.VolleyLog;
import java.io.UnsupportedEncodingException;

public abstract class JsonRequest<T> extends Request<T>
{
  private static final String a = String.format("application/json; charset=%s", new Object[] { "utf-8" });
  private final Object b = new Object();
  private Response.Listener<T> c;
  private final String d;

  public JsonRequest(int paramInt, String paramString1, String paramString2, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString1, paramErrorListener);
    this.c = paramListener;
    this.d = paramString2;
  }

  @Deprecated
  public JsonRequest(String paramString1, String paramString2, Response.Listener<T> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(-1, paramString1, paramString2, paramListener, paramErrorListener);
  }

  protected abstract Response<T> a(NetworkResponse paramNetworkResponse);

  public void cancel()
  {
    super.cancel();
    synchronized (this.b)
    {
      this.c = null;
      return;
    }
  }

  protected void deliverResponse(T paramT)
  {
    synchronized (this.b)
    {
      Response.Listener localListener = this.c;
      if (localListener != null)
        localListener.onResponse(paramT);
      return;
    }
  }

  public byte[] getBody()
  {
    try
    {
      if (this.d == null)
        return null;
      byte[] arrayOfByte = this.d.getBytes("utf-8");
      return arrayOfByte;
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = this.d;
      arrayOfObject[1] = "utf-8";
      VolleyLog.wtf("Unsupported Encoding while trying to get the bytes of %s using %s", arrayOfObject);
    }
    return null;
  }

  public String getBodyContentType()
  {
    return a;
  }

  @Deprecated
  public byte[] getPostBody()
  {
    return getBody();
  }

  @Deprecated
  public String getPostBodyContentType()
  {
    return getBodyContentType();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.JsonRequest
 * JD-Core Version:    0.6.2
 */