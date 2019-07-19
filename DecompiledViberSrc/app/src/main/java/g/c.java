package g;

import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;

public abstract interface c<R, T>
{
  public abstract T a(b<R> paramb);

  public abstract Type a();

  public static abstract class a
  {
    protected static Class<?> a(Type paramType)
    {
      return o.a(paramType);
    }

    @Nullable
    public abstract c<?, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, m paramm);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.c
 * JD-Core Version:    0.6.2
 */