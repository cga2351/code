package com.mopub.network;

import com.mopub.volley.VolleyError;

public abstract class BackoffPolicy
{
  protected int a;
  protected int b;
  protected int c;

  public abstract void backoff(VolleyError paramVolleyError)
    throws VolleyError;

  public int getBackoffMs()
  {
    return this.a;
  }

  public int getRetryCount()
  {
    return this.b;
  }

  public boolean hasAttemptRemaining()
  {
    return this.b < this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.BackoffPolicy
 * JD-Core Version:    0.6.2
 */