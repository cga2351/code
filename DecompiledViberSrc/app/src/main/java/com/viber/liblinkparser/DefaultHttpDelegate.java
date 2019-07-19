package com.viber.liblinkparser;

import com.viber.common.a.e;
import com.viber.common.a.f;
import java.io.InputStream;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.OkHttpClient.Builder;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.Response;
import okhttp3.ResponseBody;

public class DefaultHttpDelegate
  implements Http.Delegate
{
  private static final int DEFAULT_BUFFER_SIZE = 1024;
  private static final String HEADER_CONTENT_LENGTH = "Content-Length";
  private static AtomicInteger requestId = new AtomicInteger();

  private static long getContentLength(Response paramResponse)
  {
    return Long.parseLong(paramResponse.header("Content-Length", "0"));
  }

  protected OkHttpClient createOkHttpClient()
  {
    return new OkHttpClient();
  }

  public Http.Response executeGet(Http.Request paramRequest, Http.Downloader paramDownloader)
  {
    e locale = f.a("AndroidHttp[" + requestId.incrementAndGet() + "]");
    try
    {
      Object[] arrayOfObject1 = new Object[2];
      arrayOfObject1[0] = paramRequest.url;
      arrayOfObject1[1] = paramDownloader;
      locale.b("executeGet url:?, listener:?", arrayOfObject1);
      URL localURL = new URL(paramRequest.url);
      OkHttpClient.Builder localBuilder = createOkHttpClient().newBuilder();
      localBuilder.connectTimeout(paramRequest.timeout, TimeUnit.SECONDS);
      Request.Builder localBuilder1 = new Request.Builder().url(localURL);
      if (paramRequest.headers != null)
        for (Http.RequestHeader localRequestHeader : paramRequest.headers)
        {
          Object[] arrayOfObject7 = new Object[2];
          arrayOfObject7[0] = localRequestHeader.headerName;
          arrayOfObject7[1] = localRequestHeader.headerValue;
          locale.b("executeGet header ?: ?", arrayOfObject7);
          localBuilder1.header(localRequestHeader.headerName, localRequestHeader.headerValue);
        }
      Response localResponse = localBuilder.build().newCall(localBuilder1.build()).execute();
      long l = getContentLength(localResponse);
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = paramRequest.url;
      locale.b("executeGet conn.getURL: ?", arrayOfObject2);
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = Integer.valueOf(localResponse.code());
      locale.b("executeGet responseCode: ?", arrayOfObject3);
      Object[] arrayOfObject4 = new Object[1];
      arrayOfObject4[0] = Long.valueOf(l);
      locale.b("executeGet contentLength: ?", arrayOfObject4);
      Object[] arrayOfObject5 = new Object[1];
      arrayOfObject5[0] = localResponse.body().contentType();
      locale.b("executeGet contentType: ?", arrayOfObject5);
      Headers localHeaders = localResponse.headers();
      for (int i = 0; i < localHeaders.size(); i++)
      {
        Object[] arrayOfObject6 = new Object[2];
        arrayOfObject6[0] = localHeaders.name(i);
        arrayOfObject6[1] = localHeaders.value(i);
        locale.b("executeGet response header ?: ?", arrayOfObject6);
      }
      Http.Response localResponse1 = new Http.Response(localResponse.request().url().toString(), localResponse.code(), (int)l, localResponse.body().contentType().toString());
      if (!paramDownloader.onResponse(localResponse1))
        return localResponse1;
      locale.b("executeGet start reading response data", new Object[0]);
      int j = paramRequest.chunkSize;
      if (j <= 0)
        j = 1024;
      InputStream localInputStream = localResponse.body().byteStream();
      byte[] arrayOfByte = new byte[j];
      int k;
      do
        k = localInputStream.read(arrayOfByte);
      while ((k > 0) && (paramDownloader.onData(arrayOfByte, 0, k)));
      localInputStream.close();
      locale.b("executeGet end reading response data", new Object[0]);
      return localResponse1;
    }
    catch (Exception localException)
    {
      locale.a(localException, "executeGet exception", new Object[0]);
      locale.b("executeGet done", new Object[0]);
    }
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.liblinkparser.DefaultHttpDelegate
 * JD-Core Version:    0.6.2
 */