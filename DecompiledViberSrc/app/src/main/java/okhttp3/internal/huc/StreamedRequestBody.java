package okhttp3.internal.huc;

import f.c;
import f.d;
import f.l;
import f.m;
import f.t;
import java.io.IOException;
import okhttp3.internal.http.UnrepeatableRequestBody;

final class StreamedRequestBody extends OutputStreamRequestBody
  implements UnrepeatableRequestBody
{
  private final m pipe = new m(8192L);

  StreamedRequestBody(long paramLong)
  {
    initOutputStream(l.a(this.pipe.b()), paramLong);
  }

  public void writeTo(d paramd)
    throws IOException
  {
    c localc = new c();
    while (this.pipe.a().read(localc, 8192L) != -1L)
      paramd.write(localc, localc.a());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     okhttp3.internal.huc.StreamedRequestBody
 * JD-Core Version:    0.6.2
 */