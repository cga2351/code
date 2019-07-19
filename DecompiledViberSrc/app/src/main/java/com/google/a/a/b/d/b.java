package com.google.a.a.b.d;

import com.google.a.a.c.ac;
import com.google.a.a.c.e;
import com.google.a.a.c.g;
import com.google.a.a.c.h;
import com.google.a.a.c.i;
import com.google.a.a.c.m;
import com.google.a.a.c.p;
import com.google.a.a.c.q;
import com.google.a.a.c.s;
import com.google.a.a.c.t;
import com.google.a.a.c.u;
import com.google.a.a.f.n;
import com.google.a.a.f.z;
import java.io.IOException;

public abstract class b<T> extends n
{
  private final a c;
  private final String d;
  private final String e;
  private final i f;
  private m g = new m();
  private m h;
  private int i = -1;
  private String j;
  private boolean k;
  private Class<T> l;
  private com.google.a.a.b.c.b m;
  private com.google.a.a.b.c.a n;

  protected b(a parama, String paramString1, String paramString2, i parami, Class<T> paramClass)
  {
    this.l = ((Class)z.a(paramClass));
    this.c = ((a)z.a(parama));
    this.d = ((String)z.a(paramString1));
    this.e = ((String)z.a(paramString2));
    this.f = parami;
    String str1 = parama.d();
    if (str1 != null)
    {
      m localm = this.g;
      String str2 = String.valueOf(String.valueOf(str1));
      String str3 = String.valueOf(String.valueOf("Google-API-Java-Client"));
      localm.k(1 + str2.length() + str3.length() + str2 + " " + str3);
      return;
    }
    this.g.k("Google-API-Java-Client");
  }

  private p a(boolean paramBoolean)
    throws IOException
  {
    boolean bool1;
    if (this.m == null)
    {
      bool1 = true;
      z.a(bool1);
      boolean bool2;
      if (paramBoolean)
      {
        boolean bool3 = this.d.equals("GET");
        bool2 = false;
        if (!bool3);
      }
      else
      {
        bool2 = true;
      }
      z.a(bool2);
      if (!paramBoolean)
        break label213;
    }
    label213: for (String str = "HEAD"; ; str = this.d)
    {
      final p localp = b().e().a(str, f(), this.f);
      new com.google.a.a.b.b().b(localp);
      localp.a(b().g());
      if ((this.f == null) && ((this.d.equals("POST")) || (this.d.equals("PUT")) || (this.d.equals("PATCH"))))
        localp.a(new e());
      localp.g().putAll(this.g);
      if (!this.k)
        localp.a(new g());
      localp.a(new u()
      {
        public void a(s paramAnonymouss)
          throws IOException
        {
          if (this.a != null)
            this.a.a(paramAnonymouss);
          if ((!paramAnonymouss.c()) && (localp.n()))
            throw b.this.a(paramAnonymouss);
        }
      });
      return localp;
      bool1 = false;
      break;
    }
  }

  private s b(boolean paramBoolean)
    throws IOException
  {
    s locals;
    if (this.m == null)
      locals = a(paramBoolean).o();
    boolean bool;
    do
    {
      this.h = locals.b();
      this.i = locals.d();
      this.j = locals.e();
      return locals;
      h localh = f();
      bool = b().e().a(this.d, localh, this.f).n();
      locals = this.m.a(this.g).b(this.k).a(localh);
      locals.f().a(b().g());
    }
    while ((!bool) || (locals.c()));
    throw a(locals);
  }

  public b<T> a(String paramString, Object paramObject)
  {
    return (b)super.c(paramString, paramObject);
  }

  protected IOException a(s params)
  {
    return new t(params);
  }

  public final String a()
  {
    return this.e;
  }

  protected final void a(com.google.a.a.c.b paramb)
  {
    q localq = this.c.e();
    this.m = new com.google.a.a.b.c.b(paramb, localq.a(), localq.b());
    this.m.a(this.d);
    if (this.f != null)
      this.m.a(this.f);
  }

  public a b()
  {
    return this.c;
  }

  public final com.google.a.a.b.c.b d()
  {
    return this.m;
  }

  protected final void e()
  {
    q localq = this.c.e();
    this.n = new com.google.a.a.b.c.a(localq.a(), localq.b());
  }

  public h f()
  {
    return new h(ac.a(this.c.c(), this.e, this, true));
  }

  public s g()
    throws IOException
  {
    return b(false);
  }

  protected s h()
    throws IOException
  {
    a("alt", "media");
    return g();
  }

  public T i()
    throws IOException
  {
    return g().a(this.l);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.d.b
 * JD-Core Version:    0.6.2
 */