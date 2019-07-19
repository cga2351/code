package com.mopub.volley.toolbox;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.Request;
import com.mopub.volley.Response;
import com.mopub.volley.Response.ErrorListener;
import com.mopub.volley.Response.Listener;
import java.io.UnsupportedEncodingException;

public class StringRequest extends Request<String>
{
  private final Object a = new Object();
  private Response.Listener<String> b;

  public StringRequest(int paramInt, String paramString, Response.Listener<String> paramListener, Response.ErrorListener paramErrorListener)
  {
    super(paramInt, paramString, paramErrorListener);
    this.b = paramListener;
  }

  public StringRequest(String paramString, Response.Listener<String> paramListener, Response.ErrorListener paramErrorListener)
  {
    this(0, paramString, paramListener, paramErrorListener);
  }

  protected Response<String> a(NetworkResponse paramNetworkResponse)
  {
    try
    {
      str = new String(paramNetworkResponse.data, HttpHeaderParser.parseCharset(paramNetworkResponse.headers));
      return Response.success(str, HttpHeaderParser.parseCacheHeaders(paramNetworkResponse));
    }
    catch (UnsupportedEncodingException localUnsupportedEncodingException)
    {
      while (true)
        String str = new String(paramNetworkResponse.data);
    }
  }

  protected void a(String paramString)
  {
    synchronized (this.a)
    {
      Response.Listener localListener = this.b;
      if (localListener != null)
        localListener.onResponse(paramString);
      return;
    }
  }

  public void cancel()
  {
    super.cancel();
    synchronized (this.a)
    {
      this.b = null;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.toolbox.StringRequest
 * JD-Core Version:    0.6.2
 */