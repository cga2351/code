package com.google.android.gms.common.api;

public class ApiException extends Exception
{
  protected final Status mStatus;

  public ApiException(Status paramStatus)
  {
  }

  public int getStatusCode()
  {
    return this.mStatus.getStatusCode();
  }

  @Deprecated
  public String getStatusMessage()
  {
    return this.mStatus.getStatusMessage();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.google.android.gms.common.api.ApiException
 * JD-Core Version:    0.6.2
 */