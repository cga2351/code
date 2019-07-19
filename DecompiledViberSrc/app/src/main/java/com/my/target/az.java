package com.my.target;

import android.content.Context;
import android.os.Looper;
import java.util.Iterator;
import java.util.List;

public abstract class az<T extends l>
{
  protected final a<T> a;
  protected final z b;
  protected String c;
  private b<T> d;

  public az(a<T> parama, z paramz)
  {
    this.a = parama;
    this.b = paramz;
  }

  public az<T> a(Context paramContext)
  {
    dq.a(new Runnable()
    {
      public void run()
      {
        l locall = az.this.b(this.a);
        az.this.a(locall, az.this.c);
      }
    });
    return this;
  }

  public final az<T> a(b<T> paramb)
  {
    this.d = paramb;
    return this;
  }

  protected T a(f paramf, T paramT, by<T> paramby, s params, Context paramContext)
  {
    params.c(paramf.f(), paramContext);
    if (!params.c())
      return paramT;
    bi.a(paramf.b("serviceRequested"), paramContext);
    if (paramT != null);
    for (int i = paramT.a(); ; i = 0)
    {
      String str = (String)params.d();
      l locall;
      if (str != null)
        locall = paramby.a(str, paramf, paramT, this.b, paramContext);
      for (Object localObject = a(paramf.g(), locall, paramby, params, paramContext); ; localObject = paramT)
      {
        int j = 0;
        if (localObject != null)
          j = ((l)localObject).a();
        if (i == j)
        {
          bi.a(paramf.b("serviceAnswerEmpty"), paramContext);
          f localf = paramf.e();
          if (localf != null)
            localObject = a(localf, (l)localObject, paramby, params, paramContext);
        }
        return localObject;
      }
    }
  }

  protected T a(T paramT, Context paramContext)
  {
    if (paramT != null)
    {
      cu localcu = this.a.c();
      if (localcu != null)
        paramT = localcu.a(paramT, this.b, paramContext);
    }
    return paramT;
  }

  protected T a(List<f> paramList, T paramT, by<T> paramby, s params, Context paramContext)
  {
    if (paramList.size() > 0)
    {
      Iterator localIterator = paramList.iterator();
      for (localObject = paramT; localIterator.hasNext(); localObject = a((f)localIterator.next(), (l)localObject, paramby, params, paramContext));
    }
    Object localObject = paramT;
    return localObject;
  }

  protected String a(f paramf, s params, Context paramContext)
  {
    params.c(paramf.f(), paramContext);
    if (params.c())
      return (String)params.d();
    this.c = params.e();
    return null;
  }

  protected void a(final T paramT, final String paramString)
  {
    if (this.d == null)
      return;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      this.d.a(paramT, paramString);
      this.d = null;
      return;
    }
    dq.c(new Runnable()
    {
      public void run()
      {
        if (az.a(az.this) != null)
        {
          az.a(az.this).a(paramT, paramString);
          az.a(az.this, null);
        }
      }
    });
  }

  protected T b(Context paramContext)
  {
    f localf = this.a.d().b(this.b, paramContext);
    s locals = s.a();
    String str = a(localf, locals, paramContext);
    if (str == null)
      return null;
    by localby = this.a.b();
    l locall = localby.a(str, localf, null, this.b, paramContext);
    if (this.a.a())
      locall = a(localf.g(), locall, localby, locals, paramContext);
    return a(locall, paramContext);
  }

  public static abstract interface a<T extends l>
  {
    public abstract boolean a();

    public abstract by<T> b();

    public abstract cu<T> c();

    public abstract do d();
  }

  public static abstract interface b<T extends l>
  {
    public abstract void a(T paramT, String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.az
 * JD-Core Version:    0.6.2
 */