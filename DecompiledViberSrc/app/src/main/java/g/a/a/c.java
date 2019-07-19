package g.a.a;

import com.google.d.d.a;
import com.google.d.f;
import com.google.d.w;
import g.e;
import java.io.IOException;
import okhttp3.ResponseBody;

final class c<T>
  implements e<ResponseBody, T>
{
  private final f a;
  private final w<T> b;

  c(f paramf, w<T> paramw)
  {
    this.a = paramf;
    this.b = paramw;
  }

  public T a(ResponseBody paramResponseBody)
    throws IOException
  {
    a locala = this.a.a(paramResponseBody.charStream());
    try
    {
      Object localObject2 = this.b.b(locala);
      return localObject2;
    }
    finally
    {
      paramResponseBody.close();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.a.a.c
 * JD-Core Version:    0.6.2
 */