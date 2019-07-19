package g.a.a;

import com.google.d.f;
import com.google.d.w;
import g.e;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
import okhttp3.MediaType;
import okhttp3.RequestBody;

final class b<T>
  implements e<T, RequestBody>
{
  private static final MediaType a = MediaType.parse("application/json; charset=UTF-8");
  private static final Charset b = Charset.forName("UTF-8");
  private final f c;
  private final w<T> d;

  b(f paramf, w<T> paramw)
  {
    this.c = paramf;
    this.d = paramw;
  }

  public RequestBody b(T paramT)
    throws IOException
  {
    f.c localc = new f.c();
    OutputStreamWriter localOutputStreamWriter = new OutputStreamWriter(localc.c(), b);
    com.google.d.d.c localc1 = this.c.a(localOutputStreamWriter);
    this.d.a(localc1, paramT);
    localc1.close();
    return RequestBody.create(a, localc.q());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     g.a.a.b
 * JD-Core Version:    0.6.2
 */