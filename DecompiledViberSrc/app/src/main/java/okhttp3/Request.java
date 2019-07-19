package okhttp3;

import java.net.URL;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.http.HttpMethod;

public final class Request
{

  @Nullable
  final RequestBody body;
  private volatile CacheControl cacheControl;
  final Headers headers;
  final String method;
  final Object tag;
  final HttpUrl url;

  Request(Builder paramBuilder)
  {
    this.url = paramBuilder.url;
    this.method = paramBuilder.method;
    this.headers = paramBuilder.headers.build();
    this.body = paramBuilder.body;
    if (paramBuilder.tag != null);
    for (Object localObject = paramBuilder.tag; ; localObject = this)
    {
      this.tag = localObject;
      return;
    }
  }

  @Nullable
  public RequestBody body()
  {
    return this.body;
  }

  public CacheControl cacheControl()
  {
    CacheControl localCacheControl1 = this.cacheControl;
    if (localCacheControl1 != null)
      return localCacheControl1;
    CacheControl localCacheControl2 = CacheControl.parse(this.headers);
    this.cacheControl = localCacheControl2;
    return localCacheControl2;
  }

  @Nullable
  public String header(String paramString)
  {
    return this.headers.get(paramString);
  }

  public List<String> headers(String paramString)
  {
    return this.headers.values(paramString);
  }

  public Headers headers()
  {
    return this.headers;
  }

  public boolean isHttps()
  {
    return this.url.isHttps();
  }

  public String method()
  {
    return this.method;
  }

  public Builder newBuilder()
  {
    return new Builder(this);
  }

  public Object tag()
  {
    return this.tag;
  }

  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder().append("Request{method=").append(this.method).append(", url=").append(this.url).append(", tag=");
    if (this.tag != this);
    for (Object localObject = this.tag; ; localObject = null)
      return localObject + '}';
  }

  public HttpUrl url()
  {
    return this.url;
  }

  public static class Builder
  {
    RequestBody body;
    Headers.Builder headers;
    String method;
    Object tag;
    HttpUrl url;

    public Builder()
    {
      this.method = "GET";
      this.headers = new Headers.Builder();
    }

    Builder(Request paramRequest)
    {
      this.url = paramRequest.url;
      this.method = paramRequest.method;
      this.body = paramRequest.body;
      this.tag = paramRequest.tag;
      this.headers = paramRequest.headers.newBuilder();
    }

    public Builder addHeader(String paramString1, String paramString2)
    {
      this.headers.add(paramString1, paramString2);
      return this;
    }

    public Request build()
    {
      if (this.url == null)
        throw new IllegalStateException("url == null");
      return new Request(this);
    }

    public Builder cacheControl(CacheControl paramCacheControl)
    {
      String str = paramCacheControl.toString();
      if (str.isEmpty())
        return removeHeader("Cache-Control");
      return header("Cache-Control", str);
    }

    public Builder delete()
    {
      return delete(Util.EMPTY_REQUEST);
    }

    public Builder delete(@Nullable RequestBody paramRequestBody)
    {
      return method("DELETE", paramRequestBody);
    }

    public Builder get()
    {
      return method("GET", null);
    }

    public Builder head()
    {
      return method("HEAD", null);
    }

    public Builder header(String paramString1, String paramString2)
    {
      this.headers.set(paramString1, paramString2);
      return this;
    }

    public Builder headers(Headers paramHeaders)
    {
      this.headers = paramHeaders.newBuilder();
      return this;
    }

    public Builder method(String paramString, @Nullable RequestBody paramRequestBody)
    {
      if (paramString == null)
        throw new NullPointerException("method == null");
      if (paramString.length() == 0)
        throw new IllegalArgumentException("method.length() == 0");
      if ((paramRequestBody != null) && (!HttpMethod.permitsRequestBody(paramString)))
        throw new IllegalArgumentException("method " + paramString + " must not have a request body.");
      if ((paramRequestBody == null) && (HttpMethod.requiresRequestBody(paramString)))
        throw new IllegalArgumentException("method " + paramString + " must have a request body.");
      this.method = paramString;
      this.body = paramRequestBody;
      return this;
    }

    public Builder patch(RequestBody paramRequestBody)
    {
      return method("PATCH", paramRequestBody);
    }

    public Builder post(RequestBody paramRequestBody)
    {
      return method("POST", paramRequestBody);
    }

    public Builder put(RequestBody paramRequestBody)
    {
      return method("PUT", paramRequestBody);
    }

    public Builder removeHeader(String paramString)
    {
      this.headers.removeAll(paramString);
      return this;
    }

    public Builder tag(Object paramObject)
    {
      this.tag = paramObject;
      return this;
    }

    public Builder url(String paramString)
    {
      if (paramString == null)
        throw new NullPointerException("url == null");
      if (paramString.regionMatches(true, 0, "ws:", 0, 3))
        paramString = "http:" + paramString.substring(3);
      HttpUrl localHttpUrl;
      while (true)
      {
        localHttpUrl = HttpUrl.parse(paramString);
        if (localHttpUrl != null)
          break;
        throw new IllegalArgumentException("unexpected url: " + paramString);
        if (paramString.regionMatches(true, 0, "wss:", 0, 4))
          paramString = "https:" + paramString.substring(4);
      }
      return url(localHttpUrl);
    }

    public Builder url(URL paramURL)
    {
      if (paramURL == null)
        throw new NullPointerException("url == null");
      HttpUrl localHttpUrl = HttpUrl.get(paramURL);
      if (localHttpUrl == null)
        throw new IllegalArgumentException("unexpected url: " + paramURL);
      return url(localHttpUrl);
    }

    public Builder url(HttpUrl paramHttpUrl)
    {
      if (paramHttpUrl == null)
        throw new NullPointerException("url == null");
      this.url = paramHttpUrl;
      return this;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.Request
 * JD-Core Version:    0.6.2
 */