package com.mopub.volley;

import android.content.Intent;

public class AuthFailureError extends VolleyError
{
  private Intent a;

  public AuthFailureError()
  {
  }

  public AuthFailureError(Intent paramIntent)
  {
    this.a = paramIntent;
  }

  public AuthFailureError(NetworkResponse paramNetworkResponse)
  {
    super(paramNetworkResponse);
  }

  public AuthFailureError(String paramString)
  {
    super(paramString);
  }

  public AuthFailureError(String paramString, Exception paramException)
  {
    super(paramString, paramException);
  }

  public String getMessage()
  {
    if (this.a != null)
      return "User needs to (re)enter credentials.";
    return super.getMessage();
  }

  public Intent getResolutionIntent()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.volley.AuthFailureError
 * JD-Core Version:    0.6.2
 */