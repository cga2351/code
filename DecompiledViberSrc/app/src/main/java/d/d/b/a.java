package d.d.b;

import d.d.b;
import d.f.c;
import java.io.Serializable;

public abstract class a
  implements d.f.a, Serializable
{
  public static final Object c = a.a();
  private transient d.f.a a;
  protected final Object b;

  public a()
  {
    this(c);
  }

  protected a(Object paramObject)
  {
    this.b = paramObject;
  }

  public Object a(Object[] paramArrayOfObject)
  {
    return i().a(paramArrayOfObject);
  }

  public c c()
  {
    throw new AbstractMethodError();
  }

  public String d()
  {
    throw new AbstractMethodError();
  }

  public String e()
  {
    throw new AbstractMethodError();
  }

  protected abstract d.f.a f();

  public Object g()
  {
    return this.b;
  }

  public d.f.a h()
  {
    d.f.a locala = this.a;
    if (locala == null)
    {
      locala = f();
      this.a = locala;
    }
    return locala;
  }

  protected d.f.a i()
  {
    d.f.a locala = h();
    if (locala == this)
      throw new b();
    return locala;
  }

  private static class a
    implements Serializable
  {
    private static final a a = new a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     d.d.b.a
 * JD-Core Version:    0.6.2
 */