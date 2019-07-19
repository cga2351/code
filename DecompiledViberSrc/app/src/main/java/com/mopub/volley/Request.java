package com.mopub.volley;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public abstract class Request<T>
  implements Comparable<Request<T>>
{
  private final VolleyLog.a a;
  private final int b;
  private final String c;
  private final int d;
  private final Object e;
  private Response.ErrorListener f;
  private Integer g;
  private RequestQueue h;
  private boolean i;
  private boolean j;
  private boolean k;
  private boolean l;
  private RetryPolicy m;
  private Cache.Entry n;
  private Object o;
  private a p;

  public Request(int paramInt, String paramString, Response.ErrorListener paramErrorListener)
  {
    if (VolleyLog.a.ENABLED);
    for (VolleyLog.a locala = new VolleyLog.a(); ; locala = null)
    {
      this.a = locala;
      this.e = new Object();
      this.i = true;
      this.j = false;
      this.k = false;
      this.l = false;
      this.n = null;
      this.b = paramInt;
      this.c = paramString;
      this.f = paramErrorListener;
      setRetryPolicy(new DefaultRetryPolicy());
      this.d = a(paramString);
      return;
    }
  }

  @Deprecated
  public Request(String paramString, Response.ErrorListener paramErrorListener)
  {
    this(-1, paramString, paramErrorListener);
  }

  private static int a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      Uri localUri = Uri.parse(paramString);
      if (localUri != null)
      {
        String str = localUri.getHost();
        if (str != null)
          return str.hashCode();
      }
    }
    return 0;
  }

  private byte[] a(Map<String, String> paramMap, String paramString)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    while (true)
    {
      Map.Entry localEntry;
      try
      {
        Iterator localIterator = paramMap.entrySet().iterator();
        if (!localIterator.hasNext())
          break;
        localEntry = (Map.Entry)localIterator.next();
        if ((localEntry.getKey() == null) || (localEntry.getValue() == null))
        {
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = localEntry.getKey();
          arrayOfObject[1] = localEntry.getValue();
          throw new IllegalArgumentException(String.format("Request#getParams() or Request#getPostParams() returned a map containing a null key or value: (%s, %s). All keys and values must be non-null.", arrayOfObject));
        }
      }
      catch (UnsupportedEncodingException localUnsupportedEncodingException)
      {
        throw new RuntimeException("Encoding not supported: " + paramString, localUnsupportedEncodingException);
      }
      localStringBuilder.append(URLEncoder.encode((String)localEntry.getKey(), paramString));
      localStringBuilder.append('=');
      localStringBuilder.append(URLEncoder.encode((String)localEntry.getValue(), paramString));
      localStringBuilder.append('&');
    }
    byte[] arrayOfByte = localStringBuilder.toString().getBytes(paramString);
    return arrayOfByte;
  }

  protected abstract Response<T> a(NetworkResponse paramNetworkResponse);

  protected VolleyError a(VolleyError paramVolleyError)
  {
    return paramVolleyError;
  }

  protected Map<String, String> a()
    throws AuthFailureError
  {
    return null;
  }

  void a(int paramInt)
  {
    if (this.h != null)
      this.h.a(this, paramInt);
  }

  void a(a parama)
  {
    synchronized (this.e)
    {
      this.p = parama;
      return;
    }
  }

  void a(Response<?> paramResponse)
  {
    synchronized (this.e)
    {
      a locala = this.p;
      if (locala != null)
        locala.onResponseReceived(this, paramResponse);
      return;
    }
  }

  public void addMarker(String paramString)
  {
    if (VolleyLog.a.ENABLED)
      this.a.add(paramString, Thread.currentThread().getId());
  }

  @Deprecated
  protected Map<String, String> b()
    throws AuthFailureError
  {
    return a();
  }

  void b(final String paramString)
  {
    if (this.h != null)
      this.h.a(this);
    final long l1;
    if (VolleyLog.a.ENABLED)
    {
      l1 = Thread.currentThread().getId();
      if (Looper.myLooper() != Looper.getMainLooper())
        new Handler(Looper.getMainLooper()).post(new Runnable()
        {
          public void run()
          {
            Request.a(Request.this).add(paramString, l1);
            Request.a(Request.this).finish(Request.this.toString());
          }
        });
    }
    else
    {
      return;
    }
    this.a.add(paramString, l1);
    this.a.finish(toString());
  }

  @Deprecated
  protected String c()
  {
    return d();
  }

  public void cancel()
  {
    synchronized (this.e)
    {
      this.j = true;
      this.f = null;
      return;
    }
  }

  public int compareTo(Request<T> paramRequest)
  {
    Priority localPriority1 = getPriority();
    Priority localPriority2 = paramRequest.getPriority();
    if (localPriority1 == localPriority2)
      return this.g.intValue() - paramRequest.g.intValue();
    return localPriority2.ordinal() - localPriority1.ordinal();
  }

  protected String d()
  {
    return "UTF-8";
  }

  public void deliverError(VolleyError paramVolleyError)
  {
    synchronized (this.e)
    {
      Response.ErrorListener localErrorListener = this.f;
      if (localErrorListener != null)
        localErrorListener.onErrorResponse(paramVolleyError);
      return;
    }
  }

  protected abstract void deliverResponse(T paramT);

  void e()
  {
    synchronized (this.e)
    {
      a locala = this.p;
      if (locala != null)
        locala.onNoUsableResponseReceived(this);
      return;
    }
  }

  public byte[] getBody()
    throws AuthFailureError
  {
    Map localMap = a();
    if ((localMap != null) && (localMap.size() > 0))
      return a(localMap, d());
    return null;
  }

  public String getBodyContentType()
  {
    return "application/x-www-form-urlencoded; charset=" + d();
  }

  public Cache.Entry getCacheEntry()
  {
    return this.n;
  }

  public String getCacheKey()
  {
    String str = getUrl();
    int i1 = getMethod();
    if ((i1 == 0) || (i1 == -1))
      return str;
    return Integer.toString(i1) + '-' + str;
  }

  public Response.ErrorListener getErrorListener()
  {
    synchronized (this.e)
    {
      Response.ErrorListener localErrorListener = this.f;
      return localErrorListener;
    }
  }

  public Map<String, String> getHeaders()
    throws AuthFailureError
  {
    return Collections.emptyMap();
  }

  public int getMethod()
  {
    return this.b;
  }

  @Deprecated
  public byte[] getPostBody()
    throws AuthFailureError
  {
    Map localMap = b();
    if ((localMap != null) && (localMap.size() > 0))
      return a(localMap, c());
    return null;
  }

  @Deprecated
  public String getPostBodyContentType()
  {
    return getBodyContentType();
  }

  public Priority getPriority()
  {
    return Priority.NORMAL;
  }

  public RetryPolicy getRetryPolicy()
  {
    return this.m;
  }

  public final int getSequence()
  {
    if (this.g == null)
      throw new IllegalStateException("getSequence called before setSequence");
    return this.g.intValue();
  }

  public Object getTag()
  {
    return this.o;
  }

  public final int getTimeoutMs()
  {
    return getRetryPolicy().getCurrentTimeout();
  }

  public int getTrafficStatsTag()
  {
    return this.d;
  }

  public String getUrl()
  {
    return this.c;
  }

  public boolean hasHadResponseDelivered()
  {
    synchronized (this.e)
    {
      boolean bool = this.k;
      return bool;
    }
  }

  public boolean isCanceled()
  {
    synchronized (this.e)
    {
      boolean bool = this.j;
      return bool;
    }
  }

  public void markDelivered()
  {
    synchronized (this.e)
    {
      this.k = true;
      return;
    }
  }

  public Request<?> setCacheEntry(Cache.Entry paramEntry)
  {
    this.n = paramEntry;
    return this;
  }

  public Request<?> setRequestQueue(RequestQueue paramRequestQueue)
  {
    this.h = paramRequestQueue;
    return this;
  }

  public Request<?> setRetryPolicy(RetryPolicy paramRetryPolicy)
  {
    this.m = paramRetryPolicy;
    return this;
  }

  public final Request<?> setSequence(int paramInt)
  {
    this.g = Integer.valueOf(paramInt);
    return this;
  }

  public final Request<?> setShouldCache(boolean paramBoolean)
  {
    this.i = paramBoolean;
    return this;
  }

  public final Request<?> setShouldRetryServerErrors(boolean paramBoolean)
  {
    this.l = paramBoolean;
    return this;
  }

  public Request<?> setTag(Object paramObject)
  {
    this.o = paramObject;
    return this;
  }

  public final boolean shouldCache()
  {
    return this.i;
  }

  public final boolean shouldRetryServerErrors()
  {
    return this.l;
  }

  public String toString()
  {
    String str1 = "0x" + Integer.toHexString(getTrafficStatsTag());
    StringBuilder localStringBuilder = new StringBuilder();
    if (isCanceled());
    for (String str2 = "[X] "; ; str2 = "[ ] ")
      return str2 + getUrl() + " " + str1 + " " + getPriority() + " " + this.g;
  }

  public static abstract interface Method
  {
    public static final int DELETE = 3;
    public static final int DEPRECATED_GET_OR_POST = -1;
    public static final int GET = 0;
    public static final int HEAD = 4;
    public static final int OPTIONS = 5;
    public static final int PATCH = 7;
    public static final int POST = 1;
    public static final int PUT = 2;
    public static final int TRACE = 6;
  }

  public static enum Priority
  {
    static
    {
      HIGH = new Priority("HIGH", 2);
      IMMEDIATE = new Priority("IMMEDIATE", 3);
      Priority[] arrayOfPriority = new Priority[4];
      arrayOfPriority[0] = LOW;
      arrayOfPriority[1] = NORMAL;
      arrayOfPriority[2] = HIGH;
      arrayOfPriority[3] = IMMEDIATE;
    }
  }

  static abstract interface a
  {
    public abstract void onNoUsableResponseReceived(Request<?> paramRequest);

    public abstract void onResponseReceived(Request<?> paramRequest, Response<?> paramResponse);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.Request
 * JD-Core Version:    0.6.2
 */