package okhttp3.internal.cache;

import f.c;
import f.d;
import f.e;
import f.l;
import f.s;
import f.t;
import f.u;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Headers;
import okhttp3.Headers.Builder;
import okhttp3.Interceptor;
import okhttp3.Interceptor.Chain;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Response.Builder;
import okhttp3.ResponseBody;
import okhttp3.internal.Internal;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.HttpMethod;
import okhttp3.internal.http.RealResponseBody;

public final class CacheInterceptor
  implements Interceptor
{
  final InternalCache cache;

  public CacheInterceptor(InternalCache paramInternalCache)
  {
    this.cache = paramInternalCache;
  }

  private Response cacheWritingResponse(final CacheRequest paramCacheRequest, Response paramResponse)
    throws IOException
  {
    if (paramCacheRequest == null);
    s locals;
    do
    {
      return paramResponse;
      locals = paramCacheRequest.body();
    }
    while (locals == null);
    t local1 = new t()
    {
      boolean cacheRequestClosed;

      public void close()
        throws IOException
      {
        if ((!this.cacheRequestClosed) && (!Util.discard(this, 100, TimeUnit.MILLISECONDS)))
        {
          this.cacheRequestClosed = true;
          paramCacheRequest.abort();
        }
        this.val$source.close();
      }

      public long read(c paramAnonymousc, long paramAnonymousLong)
        throws IOException
      {
        long l;
        try
        {
          l = this.val$source.read(paramAnonymousc, paramAnonymousLong);
          if (l == -1L)
          {
            if (!this.cacheRequestClosed)
            {
              this.cacheRequestClosed = true;
              this.val$cacheBody.close();
            }
            return -1L;
          }
        }
        catch (IOException localIOException)
        {
          if (!this.cacheRequestClosed)
          {
            this.cacheRequestClosed = true;
            paramCacheRequest.abort();
          }
          throw localIOException;
        }
        paramAnonymousc.a(this.val$cacheBody.b(), paramAnonymousc.a() - l, l);
        this.val$cacheBody.y();
        return l;
      }

      public u timeout()
      {
        return this.val$source.timeout();
      }
    };
    String str = paramResponse.header("Content-Type");
    long l = paramResponse.body().contentLength();
    return paramResponse.newBuilder().body(new RealResponseBody(str, l, l.a(local1))).build();
  }

  private static Headers combine(Headers paramHeaders1, Headers paramHeaders2)
  {
    int i = 0;
    Headers.Builder localBuilder = new Headers.Builder();
    int j = paramHeaders1.size();
    int k = 0;
    if (k < j)
    {
      String str2 = paramHeaders1.name(k);
      String str3 = paramHeaders1.value(k);
      if (("Warning".equalsIgnoreCase(str2)) && (str3.startsWith("1")));
      while (true)
      {
        k++;
        break;
        if ((isContentSpecificHeader(str2)) || (!isEndToEnd(str2)) || (paramHeaders2.get(str2) == null))
          Internal.instance.addLenient(localBuilder, str2, str3);
      }
    }
    int m = paramHeaders2.size();
    while (i < m)
    {
      String str1 = paramHeaders2.name(i);
      if ((!isContentSpecificHeader(str1)) && (isEndToEnd(str1)))
        Internal.instance.addLenient(localBuilder, str1, paramHeaders2.value(i));
      i++;
    }
    return localBuilder.build();
  }

  static boolean isContentSpecificHeader(String paramString)
  {
    return ("Content-Length".equalsIgnoreCase(paramString)) || ("Content-Encoding".equalsIgnoreCase(paramString)) || ("Content-Type".equalsIgnoreCase(paramString));
  }

  static boolean isEndToEnd(String paramString)
  {
    return (!"Connection".equalsIgnoreCase(paramString)) && (!"Keep-Alive".equalsIgnoreCase(paramString)) && (!"Proxy-Authenticate".equalsIgnoreCase(paramString)) && (!"Proxy-Authorization".equalsIgnoreCase(paramString)) && (!"TE".equalsIgnoreCase(paramString)) && (!"Trailers".equalsIgnoreCase(paramString)) && (!"Transfer-Encoding".equalsIgnoreCase(paramString)) && (!"Upgrade".equalsIgnoreCase(paramString));
  }

  private static Response stripBody(Response paramResponse)
  {
    if ((paramResponse != null) && (paramResponse.body() != null))
      paramResponse = paramResponse.newBuilder().body(null).build();
    return paramResponse;
  }

  public Response intercept(Interceptor.Chain paramChain)
    throws IOException
  {
    Response localResponse1;
    Request localRequest;
    Response localResponse2;
    Response localResponse4;
    if (this.cache != null)
    {
      localResponse1 = this.cache.get(paramChain.request());
      CacheStrategy localCacheStrategy = new CacheStrategy.Factory(System.currentTimeMillis(), paramChain.request(), localResponse1).get();
      localRequest = localCacheStrategy.networkRequest;
      localResponse2 = localCacheStrategy.cacheResponse;
      if (this.cache != null)
        this.cache.trackResponse(localCacheStrategy);
      if ((localResponse1 != null) && (localResponse2 == null))
        Util.closeQuietly(localResponse1.body());
      if ((localRequest != null) || (localResponse2 != null))
        break label163;
      localResponse4 = new Response.Builder().request(paramChain.request()).protocol(Protocol.HTTP_1_1).code(504).message("Unsatisfiable Request (only-if-cached)").body(Util.EMPTY_RESPONSE).sentRequestAtMillis(-1L).receivedResponseAtMillis(System.currentTimeMillis()).build();
    }
    label163: label346: 
    do
    {
      do
      {
        return localResponse4;
        localResponse1 = null;
        break;
        if (localRequest == null)
          return localResponse2.newBuilder().cacheResponse(stripBody(localResponse2)).build();
        Response localResponse3;
        try
        {
          localResponse3 = paramChain.proceed(localRequest);
          if ((localResponse3 == null) && (localResponse1 != null))
            Util.closeQuietly(localResponse1.body());
          if (localResponse2 == null)
            break label346;
          if (localResponse3.code() == 304)
          {
            Response localResponse5 = localResponse2.newBuilder().headers(combine(localResponse2.headers(), localResponse3.headers())).sentRequestAtMillis(localResponse3.sentRequestAtMillis()).receivedResponseAtMillis(localResponse3.receivedResponseAtMillis()).cacheResponse(stripBody(localResponse2)).networkResponse(stripBody(localResponse3)).build();
            localResponse3.body().close();
            this.cache.trackConditionalCacheHit();
            this.cache.update(localResponse2, localResponse5);
            return localResponse5;
          }
        }
        finally
        {
          if ((0 == 0) && (localResponse1 != null))
            Util.closeQuietly(localResponse1.body());
        }
        Util.closeQuietly(localResponse2.body());
        localResponse4 = localResponse3.newBuilder().cacheResponse(stripBody(localResponse2)).networkResponse(stripBody(localResponse3)).build();
      }
      while (this.cache == null);
      if ((HttpHeaders.hasBody(localResponse4)) && (CacheStrategy.isCacheable(localResponse4, localRequest)))
        return cacheWritingResponse(this.cache.put(localResponse4), localResponse4);
    }
    while (!HttpMethod.invalidatesCache(localRequest.method()));
    try
    {
      this.cache.remove(localRequest);
      return localResponse4;
    }
    catch (IOException localIOException)
    {
    }
    return localResponse4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.cache.CacheInterceptor
 * JD-Core Version:    0.6.2
 */