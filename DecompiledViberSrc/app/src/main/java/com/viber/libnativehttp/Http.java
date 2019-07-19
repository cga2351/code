package com.viber.libnativehttp;

public abstract class Http
{
  public abstract void close(Downloader paramDownloader);

  public abstract void connect(String paramString, Downloader paramDownloader);

  public abstract void executeGet(Request paramRequest, Downloader paramDownloader);

  public abstract void executeHead(Request paramRequest, Downloader paramDownloader);

  public abstract void executePost(Request paramRequest, Downloader paramDownloader);

  public static abstract interface Delegate
  {
    public abstract void close(Http.Downloader paramDownloader, Http paramHttp);

    public abstract void connect(String paramString, Http.Downloader paramDownloader, Http paramHttp);

    public abstract void executeGet(Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp);

    public abstract void executeHead(Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp);

    public abstract void executePost(Http.Request paramRequest, Http.Downloader paramDownloader, Http paramHttp);
  }

  public static abstract interface DelegateFactory
  {
    public abstract Http.Delegate createDelegate();
  }

  public static abstract interface Downloader
  {
    public abstract void onConnected(Http paramHttp);

    public abstract boolean onData(Http paramHttp, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean);

    public abstract void onDisconnected(Http paramHttp);

    public abstract void onHead(Http paramHttp, Http.Response paramResponse);
  }

  public static class Request
  {
    public final int chunkSize;
    public final Http.RequestHeader[] headers;
    public final byte[] postData;
    public final int timeout;
    public final String url;

    public Request(String paramString, Http.RequestHeader[] paramArrayOfRequestHeader, int paramInt1, int paramInt2, byte[] paramArrayOfByte)
    {
      this.url = paramString;
      this.headers = paramArrayOfRequestHeader;
      this.chunkSize = paramInt1;
      this.timeout = paramInt2;
      this.postData = paramArrayOfByte;
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
    public final Http.RequestHeader[] headers;
    public final String redirectedUrl;
    public final int statusCode;

    public Response(String paramString1, int paramInt1, int paramInt2, String paramString2, Http.RequestHeader[] paramArrayOfRequestHeader)
    {
      this.redirectedUrl = paramString1;
      this.statusCode = paramInt1;
      this.contentLength = paramInt2;
      this.contentType = paramString2;
      this.headers = paramArrayOfRequestHeader;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.libnativehttp.Http
 * JD-Core Version:    0.6.2
 */