package com.appnexus.opensdk;

import com.appnexus.opensdk.utils.Clog;
import com.appnexus.opensdk.utils.HTTPGet;
import com.appnexus.opensdk.utils.HTTPResponse;

class h extends HTTPGet
{
  private String a;

  h(String paramString)
  {
    this.a = paramString;
  }

  protected String a()
  {
    return this.a;
  }

  protected void a(HTTPResponse paramHTTPResponse)
  {
    if ((paramHTTPResponse != null) && (paramHTTPResponse.getSucceeded()))
      Clog.d(Clog.nativeLogTag, "Clicked tracked");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.h
 * JD-Core Version:    0.6.2
 */