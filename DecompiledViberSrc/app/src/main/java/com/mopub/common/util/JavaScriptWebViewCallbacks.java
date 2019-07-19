package com.mopub.common.util;

public enum JavaScriptWebViewCallbacks
{
  private String a;

  static
  {
    JavaScriptWebViewCallbacks[] arrayOfJavaScriptWebViewCallbacks = new JavaScriptWebViewCallbacks[2];
    arrayOfJavaScriptWebViewCallbacks[0] = WEB_VIEW_DID_APPEAR;
    arrayOfJavaScriptWebViewCallbacks[1] = WEB_VIEW_DID_CLOSE;
  }

  private JavaScriptWebViewCallbacks(String paramString)
  {
    this.a = paramString;
  }

  public String getJavascript()
  {
    return this.a;
  }

  public String getUrl()
  {
    return "javascript:" + this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.util.JavaScriptWebViewCallbacks
 * JD-Core Version:    0.6.2
 */