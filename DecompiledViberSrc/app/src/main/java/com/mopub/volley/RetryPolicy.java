package com.mopub.volley;

public abstract interface RetryPolicy
{
  public abstract int getCurrentRetryCount();

  public abstract int getCurrentTimeout();

  public abstract void retry(VolleyError paramVolleyError)
    throws VolleyError;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.RetryPolicy
 * JD-Core Version:    0.6.2
 */