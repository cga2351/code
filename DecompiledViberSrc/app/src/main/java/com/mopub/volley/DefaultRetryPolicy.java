package com.mopub.volley;

public class DefaultRetryPolicy
  implements RetryPolicy
{
  public static final float DEFAULT_BACKOFF_MULT = 1.0F;
  public static final int DEFAULT_MAX_RETRIES = 1;
  public static final int DEFAULT_TIMEOUT_MS = 2500;
  private int a;
  private int b;
  private final int c;
  private final float d;

  public DefaultRetryPolicy()
  {
    this(2500, 1, 1.0F);
  }

  public DefaultRetryPolicy(int paramInt1, int paramInt2, float paramFloat)
  {
    this.a = paramInt1;
    this.c = paramInt2;
    this.d = paramFloat;
  }

  protected boolean a()
  {
    return this.b <= this.c;
  }

  public float getBackoffMultiplier()
  {
    return this.d;
  }

  public int getCurrentRetryCount()
  {
    return this.b;
  }

  public int getCurrentTimeout()
  {
    return this.a;
  }

  public void retry(VolleyError paramVolleyError)
    throws VolleyError
  {
    this.b = (1 + this.b);
    this.a += (int)(this.a * this.d);
    if (!a())
      throw paramVolleyError;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.DefaultRetryPolicy
 * JD-Core Version:    0.6.2
 */