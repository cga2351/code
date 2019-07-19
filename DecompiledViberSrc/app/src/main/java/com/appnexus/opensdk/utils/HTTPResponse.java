package com.appnexus.opensdk.utils;

import java.util.List;
import java.util.Map;

public class HTTPResponse
{
  private boolean a;
  private String b;
  private Map<String, List<String>> c;
  private HttpErrorCode d;

  public HTTPResponse()
  {
  }

  public HTTPResponse(boolean paramBoolean, String paramString, Map<String, List<String>> paramMap)
  {
    this.a = paramBoolean;
    this.b = paramString;
    this.c = paramMap;
  }

  public HttpErrorCode getErrorCode()
  {
    return this.d;
  }

  public Map<String, List<String>> getHeaders()
  {
    return this.c;
  }

  public String getResponseBody()
  {
    return this.b;
  }

  public boolean getSucceeded()
  {
    return this.a;
  }

  public void setErrorCode(HttpErrorCode paramHttpErrorCode)
  {
    this.d = paramHttpErrorCode;
  }

  public void setHeaders(Map<String, List<String>> paramMap)
  {
    this.c = paramMap;
  }

  public void setResponseBody(String paramString)
  {
    this.b = paramString;
  }

  public void setSucceeded(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.HTTPResponse
 * JD-Core Version:    0.6.2
 */