package com.viber.liblinkparser;

public abstract class Http
{
  public abstract Response executeGet(Request paramRequest, Downloader paramDownloader);

  public static abstract interface Delegate
  {
    public abstract Http.Response executeGet(Http.Request paramRequest, Http.Downloader paramDownloader);
  }

  public static abstract interface DelegateFactory
  {
    public abstract Http.Delegate createDelegate();
  }

  public static abstract interface Downloader
  {
    public abstract boolean onData(byte[] paramArrayOfByte, int paramInt1, int paramInt2);

    public abstract boolean onResponse(Http.Response paramResponse);
  }

  public static class Request
  {
    public final int chunkSize;
    public final Http.RequestHeader[] headers;
    public final int timeout;
    public final String url;

    public Request(String paramString, Http.RequestHeader[] paramArrayOfRequestHeader, int paramInt1, int paramInt2)
    {
      this.url = paramString;
      this.headers = paramArrayOfRequestHeader;
      this.chunkSize = paramInt1;
      this.timeout = paramInt2;
    }
  }

  public static class RequestHeader
  {
    public final String headerName;
    public final String headerValue;

    public RequestHeader(String paramString1, String paramString2)
    {
      this.headerName = paramString1;
      this.headerValue = paramString2;
    }
  }

  public static class Response
  {
    public final int contentLength;
    public final String contentType;
    private String redirectedUrl = "";
    public final int statusCode;

    public Response(String paramString1, int paramInt1, int paramInt2, String paramString2)
    {
      this.redirectedUrl = paramString1;
      this.statusCode = paramInt1;
      this.contentLength = paramInt2;
      this.contentType = paramString2;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.liblinkparser.Http
 * JD-Core Version:    0.6.2
 */