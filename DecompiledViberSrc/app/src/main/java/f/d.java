package f;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.WritableByteChannel;

public abstract interface d extends s, WritableByteChannel
{
  public abstract long a(t paramt)
    throws IOException;

  public abstract c b();

  public abstract d b(String paramString)
    throws IOException;

  public abstract d c(f paramf)
    throws IOException;

  public abstract d c(byte[] paramArrayOfByte)
    throws IOException;

  public abstract d c(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
    throws IOException;

  public abstract OutputStream c();

  public abstract d e()
    throws IOException;

  public abstract void flush()
    throws IOException;

  public abstract d g(int paramInt)
    throws IOException;

  public abstract d h(int paramInt)
    throws IOException;

  public abstract d i(int paramInt)
    throws IOException;

  public abstract d m(long paramLong)
    throws IOException;

  public abstract d n(long paramLong)
    throws IOException;

  public abstract d y()
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.d
 * JD-Core Version:    0.6.2
 */