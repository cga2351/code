package f;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;

public abstract interface s extends Closeable, Flushable
{
  public abstract void close()
    throws IOException;

  public abstract void flush()
    throws IOException;

  public abstract u timeout();

  public abstract void write(c paramc, long paramLong)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.s
 * JD-Core Version:    0.6.2
 */