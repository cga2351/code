package g;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import javax.annotation.Nullable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public abstract interface e<F, T>
{
  public abstract T a(F paramF)
    throws IOException;

  public static abstract class a
  {
    @Nullable
    public e<ResponseBody, ?> a(Type paramType, Annotation[] paramArrayOfAnnotation, m paramm)
    {
      return null;
    }

    @Nullable
    public e<?, RequestBody> a(Type paramType, Annotation[] paramArrayOfAnnotation1, Annotation[] paramArrayOfAnnotation2, m paramm)
    {
      return null;
    }

    @Nullable
    public e<?, String> b(Type paramType, Annotation[] paramArrayOfAnnotation, m paramm)
    {
      return null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.e
 * JD-Core Version:    0.6.2
 */