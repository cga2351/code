package g;

import f.c;
import f.d;
import java.io.IOException;
import javax.annotation.Nullable;
import okhttp3.FormBody.Builder;
import okhttp3.Headers;
import okhttp3.HttpUrl;
import okhttp3.HttpUrl.Builder;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.MultipartBody.Builder;
import okhttp3.MultipartBody.Part;
import okhttp3.Request;
import okhttp3.Request.Builder;
import okhttp3.RequestBody;

final class k
{
  private static final char[] a = { 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 65, 66, 67, 68, 69, 70 };
  private final String b;
  private final HttpUrl c;

  @Nullable
  private String d;

  @Nullable
  private HttpUrl.Builder e;
  private final Request.Builder f;

  @Nullable
  private MediaType g;
  private final boolean h;

  @Nullable
  private MultipartBody.Builder i;

  @Nullable
  private FormBody.Builder j;

  @Nullable
  private RequestBody k;

  k(String paramString1, HttpUrl paramHttpUrl, @Nullable String paramString2, @Nullable Headers paramHeaders, @Nullable MediaType paramMediaType, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    this.b = paramString1;
    this.c = paramHttpUrl;
    this.d = paramString2;
    this.f = new Request.Builder();
    this.g = paramMediaType;
    this.h = paramBoolean1;
    if (paramHeaders != null)
      this.f.headers(paramHeaders);
    if (paramBoolean2)
      this.j = new FormBody.Builder();
    while (!paramBoolean3)
      return;
    this.i = new MultipartBody.Builder();
    this.i.setType(MultipartBody.FORM);
  }

  private static String a(String paramString, boolean paramBoolean)
  {
    int m = paramString.length();
    int n = 0;
    while (true)
    {
      int i1;
      if (n < m)
      {
        i1 = paramString.codePointAt(n);
        if ((i1 < 32) || (i1 >= 127) || (" \"<>^`{}|\\?#".indexOf(i1) != -1) || ((!paramBoolean) && ((i1 == 47) || (i1 == 37))))
        {
          c localc = new c();
          localc.a(paramString, 0, n);
          a(localc, paramString, n, m, paramBoolean);
          paramString = localc.r();
        }
      }
      else
      {
        return paramString;
      }
      n += Character.charCount(i1);
    }
  }

  private static void a(c paramc, String paramString, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    c localc = null;
    if (paramInt1 < paramInt2)
    {
      int m = paramString.codePointAt(paramInt1);
      if ((paramBoolean) && ((m == 9) || (m == 10) || (m == 12) || (m == 13)));
      while (true)
      {
        paramInt1 += Character.charCount(m);
        break;
        if ((m < 32) || (m >= 127) || (" \"<>^`{}|\\?#".indexOf(m) != -1) || ((!paramBoolean) && ((m == 47) || (m == 37))))
        {
          if (localc == null)
            localc = new c();
          localc.a(m);
          while (!localc.f())
          {
            int n = 0xFF & localc.i();
            paramc.b(37);
            paramc.b(a[(0xF & n >> 4)]);
            paramc.b(a[(n & 0xF)]);
          }
        }
        else
        {
          paramc.a(m);
        }
      }
    }
  }

  Request a()
  {
    HttpUrl.Builder localBuilder = this.e;
    HttpUrl localHttpUrl;
    Object localObject;
    label38: MediaType localMediaType;
    if (localBuilder != null)
    {
      localHttpUrl = localBuilder.build();
      localObject = this.k;
      if (localObject == null)
      {
        if (this.j == null)
          break label142;
        localObject = this.j.build();
      }
      localMediaType = this.g;
      if (localMediaType != null)
      {
        if (localObject == null)
          break label178;
        localObject = new a((RequestBody)localObject, localMediaType);
      }
    }
    while (true)
    {
      return this.f.url(localHttpUrl).method(this.b, (RequestBody)localObject).build();
      localHttpUrl = this.c.resolve(this.d);
      if (localHttpUrl != null)
        break;
      throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
      label142: if (this.i != null)
      {
        localObject = this.i.build();
        break label38;
      }
      if (!this.h)
        break label38;
      localObject = RequestBody.create(null, new byte[0]);
      break label38;
      label178: this.f.addHeader("Content-Type", localMediaType.toString());
    }
  }

  void a(Object paramObject)
  {
    this.d = paramObject.toString();
  }

  void a(String paramString1, String paramString2)
  {
    if ("Content-Type".equalsIgnoreCase(paramString1))
    {
      MediaType localMediaType = MediaType.parse(paramString2);
      if (localMediaType == null)
        throw new IllegalArgumentException("Malformed content type: " + paramString2);
      this.g = localMediaType;
      return;
    }
    this.f.addHeader(paramString1, paramString2);
  }

  void a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (this.d == null)
      throw new AssertionError();
    this.d = this.d.replace("{" + paramString1 + "}", a(paramString2, paramBoolean));
  }

  void a(Headers paramHeaders, RequestBody paramRequestBody)
  {
    this.i.addPart(paramHeaders, paramRequestBody);
  }

  void a(MultipartBody.Part paramPart)
  {
    this.i.addPart(paramPart);
  }

  void a(RequestBody paramRequestBody)
  {
    this.k = paramRequestBody;
  }

  void b(String paramString1, @Nullable String paramString2, boolean paramBoolean)
  {
    if (this.d != null)
    {
      this.e = this.c.newBuilder(this.d);
      if (this.e == null)
        throw new IllegalArgumentException("Malformed URL. Base: " + this.c + ", Relative: " + this.d);
      this.d = null;
    }
    if (paramBoolean)
    {
      this.e.addEncodedQueryParameter(paramString1, paramString2);
      return;
    }
    this.e.addQueryParameter(paramString1, paramString2);
  }

  void c(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.j.addEncoded(paramString1, paramString2);
      return;
    }
    this.j.add(paramString1, paramString2);
  }

  private static class a extends RequestBody
  {
    private final RequestBody a;
    private final MediaType b;

    a(RequestBody paramRequestBody, MediaType paramMediaType)
    {
      this.a = paramRequestBody;
      this.b = paramMediaType;
    }

    public long contentLength()
      throws IOException
    {
      return this.a.contentLength();
    }

    public MediaType contentType()
    {
      return this.b;
    }

    public void writeTo(d paramd)
      throws IOException
    {
      this.a.writeTo(paramd);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.k
 * JD-Core Version:    0.6.2
 */