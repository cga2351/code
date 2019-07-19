package f;

import java.io.IOException;

public abstract class h
  implements t
{
  private final t delegate;

  public h(t paramt)
  {
    if (paramt == null)
      throw new IllegalArgumentException("delegate == null");
    this.delegate = paramt;
  }

  public void close()
    throws IOException
  {
    this.delegate.close();
  }

  public final t delegate()
  {
    return this.delegate;
  }

  public long read(c paramc, long paramLong)
    throws IOException
  {
    return this.delegate.read(paramc, paramLong);
  }

  public u timeout()
  {
    return this.delegate.timeout();
  }

  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.h
 * JD-Core Version:    0.6.2
 */