package f;

import java.io.Closeable;
import java.io.IOException;

public abstract interface t extends Closeable
{
  public abstract void close()
    throws IOException;

  public abstract long read(c paramc, long paramLong)
    throws IOException;

  public abstract u timeout();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.t
 * JD-Core Version:    0.6.2
 */