package com.viber.liblinkparser;

public class AndroidHttp extends Http
{
  private static Http.DelegateFactory sGlobalDelegateFactory = new DefaultHttpDelegateFactory();

  public static void setGlobalDelegateFactory(Http.DelegateFactory paramDelegateFactory)
  {
    sGlobalDelegateFactory = paramDelegateFactory;
  }

  public Http.Response executeGet(Http.Request paramRequest, Http.Downloader paramDownloader)
  {
    return sGlobalDelegateFactory.createDelegate().executeGet(paramRequest, paramDownloader);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.liblinkparser.AndroidHttp
 * JD-Core Version:    0.6.2
 */