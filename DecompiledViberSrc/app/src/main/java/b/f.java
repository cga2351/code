package b;

import java.io.Closeable;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ScheduledFuture;

public class f
  implements Closeable
{
  private final Object a;
  private final List<e> b;
  private ScheduledFuture<?> c;
  private boolean d;
  private boolean e;

  private void b()
  {
    if (this.e)
      throw new IllegalStateException("Object already closed");
  }

  private void c()
  {
    if (this.c != null)
    {
      this.c.cancel(true);
      this.c = null;
    }
  }

  void a(e parame)
  {
    synchronized (this.a)
    {
      b();
      this.b.remove(parame);
      return;
    }
  }

  public boolean a()
  {
    synchronized (this.a)
    {
      b();
      boolean bool = this.d;
      return bool;
    }
  }

  public void close()
  {
    synchronized (this.a)
    {
      if (this.e)
        return;
      c();
      Iterator localIterator = this.b.iterator();
      if (localIterator.hasNext())
        ((e)localIterator.next()).close();
    }
    this.b.clear();
    this.e = true;
  }

  public String toString()
  {
    Locale localLocale = Locale.US;
    Object[] arrayOfObject = new Object[3];
    arrayOfObject[0] = getClass().getName();
    arrayOfObject[1] = Integer.toHexString(hashCode());
    arrayOfObject[2] = Boolean.toString(a());
    return String.format(localLocale, "%s@%s[cancellationRequested=%s]", arrayOfObject);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.f
 * JD-Core Version:    0.6.2
 */