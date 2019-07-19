package okhttp3.internal.http;

import f.j;
import f.l;
import java.io.IOException;
import java.util.List;
import okhttp3.Cookie;
import okhttp3.CookieJar;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Util;
import okhttp3.internal.Version;

public final class BridgeInterceptor
  implements Interceptor
{
  private final CookieJar cookieJar;

  public BridgeInterceptor(CookieJar paramCookieJar)
  {
    this.cookieJar = paramCookieJar;
  }

  private String cookieHeader(List<Cookie> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int i = paramList.size();
    for (int j = 0; j < i; j++)
    {
      if (j > 0)
        localStringBuilder.append("; ");
      Cookie localCookie = (Cookie)paramList.get(j);
      localStringBuilder.append(localCookie.name()).append('=').append(localCookie.value());
    }
    return localStringBuilder.toString();
  }

  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Request localRequest = paramChain.request();
    Request.Builder localBuilder = localRequest.newBuilder();
    RequestBody localRequestBody = localRequest.body();
    if (localRequestBody != null)
    {
      MediaType localMediaType = localRequestBody.contentType();
      if (localMediaType != null)
        localBuilder.header("Content-Type", localMediaType.toString());
      long l = localRequestBody.contentLength();
      if (l == -1L)
        break label370;
      localBuilder.header("Content-Length", Long.toString(l));
      localBuilder.removeHeader("Transfer-Encoding");
    }
    while (true)
    {
      if (localRequest.header("Host") == null)
        localBuilder.header("Host", Util.hostHeader(localRequest.url(), false));
      if (localRequest.header("Connection") == null)
        localBuilder.header("Connection", "Keep-Alive");
      String str1 = localRequest.header("Accept-Encoding");
      int i = 0;
      if (str1 == null)
      {
        String str2 = localRequest.header("Range");
        i = 0;
        if (str2 == null)
        {
          i = 1;
          localBuilder.header("Accept-Encoding", "gzip");
        }
      }
      List localList = this.cookieJar.loadForRequest(localRequest.url());
      if (!localList.isEmpty())
        localBuilder.header("Cookie", cookieHeader(localList));
      if (localRequest.header("User-Agent") == null)
        localBuilder.header("User-Agent", Version.userAgent());
      Response localResponse = paramChain.proceed(localBuilder.build());
      HttpHeaders.receiveHeaders(this.cookieJar, localRequest.url(), localResponse.headers());
      Response.Builder localBuilder1 = localResponse.newBuilder().request(localRequest);
      if ((i != 0) && ("gzip".equalsIgnoreCase(localResponse.header("Content-Encoding"))) && (HttpHeaders.hasBody(localResponse)))
      {
        j localj = new j(localResponse.body().source());
        localBuilder1.headers(localResponse.headers().newBuilder().removeAll("Content-Encoding").removeAll("Content-Length").build());
        localBuilder1.body(new RealResponseBody(localResponse.header("Content-Type"), -1L, l.a(localj)));
      }
      return localBuilder1.build();
      label370: localBuilder.header("Transfer-Encoding", "chunked");
      localBuilder.removeHeader("Content-Length");
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.http.BridgeInterceptor
 * JD-Core Version:    0.6.2
 */