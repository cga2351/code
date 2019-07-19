package c.a.a.a;

import android.content.Context;
import c.a.a.a.a.b.s;
import c.a.a.a.a.c.l;
import java.io.File;
import java.util.Collection;
import java.util.concurrent.ExecutorService;

public abstract class i<Result>
  implements Comparable<i>
{
  c e;
  h<Result> f = new h(this);
  Context g;
  f<Result> h;
  s i;
  final c.a.a.a.a.c.d j = (c.a.a.a.a.c.d)getClass().getAnnotation(c.a.a.a.a.c.d.class);

  public int a(i parami)
  {
    if (b(parami));
    do
    {
      return 1;
      if (parami.b(this))
        return -1;
    }
    while ((u()) && (!parami.u()));
    if ((!u()) && (parami.u()))
      return -1;
    return 0;
  }

  public abstract String a();

  void a(Context paramContext, c paramc, f<Result> paramf, s params)
  {
    this.e = paramc;
    this.g = new d(paramContext, b(), t());
    this.h = paramf;
    this.i = params;
  }

  protected void a(Result paramResult)
  {
  }

  public abstract String b();

  protected void b(Result paramResult)
  {
  }

  boolean b(i parami)
  {
    boolean bool1 = u();
    boolean bool2 = false;
    Class[] arrayOfClass;
    int k;
    if (bool1)
    {
      arrayOfClass = this.j.a();
      k = arrayOfClass.length;
    }
    for (int m = 0; ; m++)
    {
      bool2 = false;
      if (m < k)
      {
        if (arrayOfClass[m].isAssignableFrom(parami.getClass()))
          bool2 = true;
      }
      else
        return bool2;
    }
  }

  protected abstract Result f();

  protected boolean f_()
  {
    return true;
  }

  final void p()
  {
    h localh = this.f;
    ExecutorService localExecutorService = this.e.e();
    Void[] arrayOfVoid = new Void[1];
    arrayOfVoid[0] = ((Void)null);
    localh.a(localExecutorService, arrayOfVoid);
  }

  protected s q()
  {
    return this.i;
  }

  public Context r()
  {
    return this.g;
  }

  public c s()
  {
    return this.e;
  }

  public String t()
  {
    return ".Fabric" + File.separator + b();
  }

  boolean u()
  {
    return this.j != null;
  }

  protected Collection<l> v()
  {
    return this.f.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.i
 * JD-Core Version:    0.6.2
 */