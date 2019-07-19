package g.a.a;

import com.google.d.f;
import com.google.d.w;
import g.e;
import g.e.a;
import g.m;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public final class a extends e.a
{
  private final f a;

  private a(f paramf)
  {
    this.a = paramf;
  }

  public static a a()
  {
    return a(new f());
  }

  public static a a(f paramf)
  {
    if (paramf == null)
      throw new NullPointerException("gson == null");
    return new a(paramf);
  }

  public e<ResponseBody, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, m paramm)
  {
    w localw = this.a.a(com.google.d.c.a.get(paramType));
    return new c(this.a, localw);
  }

  public e<?, RequestBody> a(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, m paramm)
  {
    w localw = this.a.a(com.google.d.c.a.get(paramType));
    return new b(this.a, localw);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.a.a.a
 * JD-Core Version:    0.6.2
 */