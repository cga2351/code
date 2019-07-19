package f;

import java.io.IOException;

public abstract class g
  implements s
{
  private final s delegate;

  public g(s params)
  {
    if (params == null)
      throw new IllegalArgumentException("delegate == null");
    this.delegate = params;
  }

  public void close()
    throws IOException
  {
    this.delegate.close();
  }

  public final s delegate()
  {
    return this.delegate;
  }

  public void flush()
    throws IOException
  {
    this.delegate.flush();
  }

  public u timeout()
  {
    return this.delegate.timeout();
  }

  public String toString()
  {
    return getClass().getSimpleName() + "(" + this.delegate.toString() + ")";
  }

  public void write(c paramc, long paramLong)
    throws IOException
  {
    this.delegate.write(paramc, paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     f.g
 * JD-Core Version:    0.6.2
 */