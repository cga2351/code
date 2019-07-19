package g;

import g.b.w;
import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

final class a extends e.a
{
  public e<ResponseBody, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, m paramm)
  {
    if (paramType == ResponseBody.class)
    {
      if (o.a(paramArrayOfAnnotation, w.class))
        return c.a;
      return a.a;
    }
    if (paramType == Void.class)
      return e.a;
    return null;
  }

  public e<?, RequestBody> a(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, m paramm)
  {
    if (RequestBody.class.isAssignableFrom(o.a(paramType)))
      return b.a;
    return null;
  }

  static final class a
    implements e<ResponseBody, ResponseBody>
  {
    static final a a = new a();

    public ResponseBody a(ResponseBody paramResponseBody)
      throws IOException
    {
      try
      {
        ResponseBody localResponseBody = o.a(paramResponseBody);
        return localResponseBody;
      }
      finally
      {
        paramResponseBody.close();
      }
    }
  }

  static final class b
    implements e<RequestBody, RequestBody>
  {
    static final b a = new b();

    public RequestBody a(RequestBody paramRequestBody)
      throws IOException
    {
      return paramRequestBody;
    }
  }

  static final class c
    implements e<ResponseBody, ResponseBody>
  {
    static final c a = new c();

    public ResponseBody a(ResponseBody paramResponseBody)
      throws IOException
    {
      return paramResponseBody;
    }
  }

  static final class d
    implements e<Object, String>
  {
    static final d a = new d();

    public String b(Object paramObject)
    {
      return paramObject.toString();
    }
  }

  static final class e
    implements e<ResponseBody, Void>
  {
    static final e a = new e();

    public Void a(ResponseBody paramResponseBody)
      throws IOException
    {
      paramResponseBody.close();
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.a
 * JD-Core Version:    0.6.2
 */