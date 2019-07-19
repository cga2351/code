package com.mopub.volley;

public class NetworkError extends VolleyError
{
  public NetworkError()
  {
  }

  public NetworkError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }

  public NetworkError(Throwable paramThrowable)
  {
    super(paramThrowable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.NetworkError
 * JD-Core Version:    0.6.2
 */