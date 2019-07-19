package f;

import java.io.EOFException;
import java.io.IOException;
import java.util.zip.DataFormatException;
import java.util.zip.Inflater;

public final class k
  implements t
{
  private final e a;
  private final Inflater b;
  private int c;
  private boolean d;

  k(e parame, Inflater paramInflater)
  {
    if (parame == null)
      throw new IllegalArgumentException("source == null");
    if (paramInflater == null)
      throw new IllegalArgumentException("inflater == null");
    this.a = parame;
    this.b = paramInflater;
  }

  private void b()
    throws IOException
  {
    if (this.c == 0)
      return;
    int i = this.c - this.b.getRemaining();
    this.c -= i;
    this.a.i(i);
  }

  public boolean a()
    throws IOException
  {
    if (!this.b.needsInput())
      return false;
    b();
    if (this.b.getRemaining() != 0)
      throw new IllegalStateException("?");
    if (this.a.f())
      return true;
    p localp = this.a.b().a;
    this.c = (localp.c - localp.b);
    this.b.setInput(localp.a, localp.b, this.c);
    return false;
  }

  public void close()
    throws IOException
  {
    if (this.d)
      return;
    this.b.end();
    this.d = true;
    this.a.close();
  }

  public long read(c paramc, long paramLong)
    throws IOException
  {
    if (paramLong < 0L)
      throw new IllegalArgumentException("byteCount < 0: " + paramLong);
    if (this.d)
      throw new IllegalStateException("closed");
    if (paramLong == 0L)
      return 0L;
    while (true)
    {
      boolean bool = a();
      try
      {
        p localp = paramc.e(1);
        int i = (int)Math.min(paramLong, 8192 - localp.c);
        int j = this.b.inflate(localp.a, localp.c, i);
        if (j > 0)
        {
          localp.c = (j + localp.c);
          paramc.b += j;
          return j;
        }
        if ((this.b.finished()) || (this.b.needsDictionary()))
        {
          b();
          if (localp.b == localp.c)
          {
            paramc.a = localp.c();
            q.a(localp);
          }
        }
        else
        {
          if (!bool)
            continue;
          throw new EOFException("source exhausted prematurely");
        }
      }
      catch (DataFormatException localDataFormatException)
      {
        throw new IOException(localDataFormatException);
      }
    }
    return -1L;
  }

  public u timeout()
  {
    return this.a.timeout();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.k
 * JD-Core Version:    0.6.2
 */