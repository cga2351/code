package f;

import java.io.IOException;
import java.io.InputStream;
import java.nio.channels.ReadableByteChannel;
import java.nio.charset.Charset;

public abstract interface e extends t, ReadableByteChannel
{
  public abstract long a(byte paramByte)
    throws IOException;

  public abstract long a(f paramf, long paramLong)
    throws IOException;

  public abstract long a(s params)
    throws IOException;

  public abstract String a(Charset paramCharset)
    throws IOException;

  public abstract void a(long paramLong)
    throws IOException;

  public abstract void a(c paramc, long paramLong)
    throws IOException;

  public abstract void a(byte[] paramArrayOfByte)
    throws IOException;

  public abstract boolean a(long paramLong, f paramf)
    throws IOException;

  public abstract long b(f paramf)
    throws IOException;

  public abstract c b();

  public abstract boolean b(long paramLong)
    throws IOException;

  public abstract f d(long paramLong)
    throws IOException;

  public abstract String f(long paramLong)
    throws IOException;

  public abstract boolean f()
    throws IOException;

  public abstract InputStream g();

  public abstract byte[] h(long paramLong)
    throws IOException;

  public abstract byte i()
    throws IOException;

  public abstract void i(long paramLong)
    throws IOException;

  public abstract short j()
    throws IOException;

  public abstract int k()
    throws IOException;

  public abstract long l()
    throws IOException;

  public abstract short m()
    throws IOException;

  public abstract int n()
    throws IOException;

  public abstract long o()
    throws IOException;

  public abstract long p()
    throws IOException;

  public abstract String r()
    throws IOException;

  public abstract String s()
    throws IOException;

  public abstract byte[] u()
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.e
 * JD-Core Version:    0.6.2
 */