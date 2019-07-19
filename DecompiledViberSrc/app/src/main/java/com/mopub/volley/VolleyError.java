package com.mopub.volley;

public class VolleyError extends Exception
{
  private long a;
  public final NetworkResponse networkResponse;

  public VolleyError()
  {
    this.networkResponse = null;
  }

  public VolleyError(NetworkResponse paramNetworkResponse)
  {
    this.networkResponse = paramNetworkResponse;
  }

  public VolleyError(String paramString)
  {
    super(paramString);
    this.networkResponse = null;
  }

  public VolleyError(String paramString, Throwable paramThrowable)
  {
    super(paramString, paramThrowable);
    this.networkResponse = null;
  }

  public VolleyError(Throwable paramThrowable)
  {
    super(paramThrowable);
    this.networkResponse = null;
  }

  void a(long paramLong)
  {
    this.a = paramLong;
  }

  public long getNetworkTimeMs()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.VolleyError
 * JD-Core Version:    0.6.2
 */