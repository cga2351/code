package b;

import java.io.Closeable;

public class e
  implements Closeable
{
  private final Object a;
  private f b;
  private Runnable c;
  private boolean d;

  public void close()
  {
    synchronized (this.a)
    {
      if (this.d)
        return;
      this.d = true;
      this.b.a(this);
      this.b = null;
      this.c = null;
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.e
 * JD-Core Version:    0.6.2
 */