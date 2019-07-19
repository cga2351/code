package android.support.v7.recyclerview.a;

import android.support.v7.d.c.c;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public final class a<T>
{
  private final Executor a;
  private final Executor b;
  private final c.c<T> c;

  a(Executor paramExecutor1, Executor paramExecutor2, c.c<T> paramc)
  {
    this.a = paramExecutor1;
    this.b = paramExecutor2;
    this.c = paramc;
  }

  public Executor a()
  {
    return this.a;
  }

  public Executor b()
  {
    return this.b;
  }

  public c.c<T> c()
  {
    return this.c;
  }

  public static final class a<T>
  {
    private static final Object d = new Object();
    private static Executor e = null;
    private Executor a;
    private Executor b;
    private final c.c<T> c;

    public a(c.c<T> paramc)
    {
      this.c = paramc;
    }

    public a<T> a(Executor paramExecutor)
    {
      this.b = paramExecutor;
      return this;
    }

    public a<T> a()
    {
      if (this.b == null);
      synchronized (d)
      {
        if (e == null)
          e = Executors.newFixedThreadPool(2);
        this.b = e;
        return new a(this.a, this.b, this.c);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.recyclerview.a.a
 * JD-Core Version:    0.6.2
 */