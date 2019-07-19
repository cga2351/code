package com.mopub.network;

import com.mopub.volley.NetworkResponse;
import com.mopub.volley.VolleyError;

public class MoPubNetworkError extends VolleyError
{
  private final Reason a;
  private final Integer b;

  public MoPubNetworkError(Reason paramReason)
  {
    this.a = paramReason;
    this.b = null;
  }

  public MoPubNetworkError(NetworkResponse paramNetworkResponse, Reason paramReason)
  {
    super(paramNetworkResponse);
    this.a = paramReason;
    this.b = null;
  }

  public MoPubNetworkError(String paramString, Reason paramReason)
  {
    this(paramString, paramReason, null);
  }

  public MoPubNetworkError(String paramString, Reason paramReason, Integer paramInteger)
  {
    super(paramString);
    this.a = paramReason;
    this.b = paramInteger;
  }

  public MoPubNetworkError(String paramString, Throwable paramThrowable, Reason paramReason)
  {
    super(paramString, paramThrowable);
    this.a = paramReason;
    this.b = null;
  }

  public MoPubNetworkError(Throwable paramThrowable, Reason paramReason)
  {
    super(paramThrowable);
    this.a = paramReason;
    this.b = null;
  }

  public Reason getReason()
  {
    return this.a;
  }

  public Integer getRefreshTimeMillis()
  {
    return this.b;
  }

  public static enum Reason
  {
    static
    {
      NO_FILL = new Reason("NO_FILL", 1);
      BAD_HEADER_DATA = new Reason("BAD_HEADER_DATA", 2);
      BAD_BODY = new Reason("BAD_BODY", 3);
      TRACKING_FAILURE = new Reason("TRACKING_FAILURE", 4);
      UNSPECIFIED = new Reason("UNSPECIFIED", 5);
      Reason[] arrayOfReason = new Reason[6];
      arrayOfReason[0] = WARMING_UP;
      arrayOfReason[1] = NO_FILL;
      arrayOfReason[2] = BAD_HEADER_DATA;
      arrayOfReason[3] = BAD_BODY;
      arrayOfReason[4] = TRACKING_FAILURE;
      arrayOfReason[5] = UNSPECIFIED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.network.MoPubNetworkError
 * JD-Core Version:    0.6.2
 */