package com.google.a.a.b.c;

import com.google.a.a.c.e;
import com.google.a.a.c.g;
import com.google.a.a.c.h;
import com.google.a.a.c.i;
import com.google.a.a.c.m;
import com.google.a.a.c.p;
import com.google.a.a.c.q;
import com.google.a.a.c.r;
import com.google.a.a.c.s;
import com.google.a.a.c.w;
import com.google.a.a.c.y;
import com.google.a.a.f.f;
import com.google.a.a.f.z;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public final class b
{
  String a = "*";
  com.google.a.a.f.ab b = com.google.a.a.f.ab.a;
  private a c = a.a;
  private final com.google.a.a.c.b d;
  private final q e;
  private final w f;
  private i g;
  private long h;
  private boolean i;
  private String j = "POST";
  private m k = new m();
  private p l;
  private InputStream m;
  private boolean n;
  private c o;
  private long p;
  private int q = 10485760;
  private Byte r;
  private long s;
  private int t;
  private byte[] u;
  private boolean v;

  public b(com.google.a.a.c.b paramb, w paramw, r paramr)
  {
    this.d = ((com.google.a.a.c.b)z.a(paramb));
    this.f = ((w)z.a(paramw));
    if (paramr == null);
    for (q localq = paramw.a(); ; localq = paramw.a(paramr))
    {
      this.e = localq;
      return;
    }
  }

  private s a(p paramp)
    throws IOException
  {
    new com.google.a.a.b.b().b(paramp);
    paramp.a(false);
    return paramp.o();
  }

  private void a(a parama)
    throws IOException
  {
    this.c = parama;
    if (this.o != null)
      this.o.a(this);
  }

  private long b(String paramString)
  {
    if (paramString == null)
      return 0L;
    return 1L + Long.parseLong(paramString.substring(1 + paramString.indexOf('-')));
  }

  private s b(h paramh)
    throws IOException
  {
    a(a.d);
    Object localObject1 = this.d;
    if (this.g != null)
    {
      com.google.a.a.c.ab localab = new com.google.a.a.c.ab();
      i[] arrayOfi = new i[2];
      arrayOfi[0] = this.g;
      arrayOfi[1] = this.d;
      localObject1 = localab.a(Arrays.asList(arrayOfi));
      paramh.d("uploadType", "multipart");
    }
    while (true)
    {
      p localp = this.e.a(this.j, paramh, (i)localObject1);
      localp.g().putAll(this.k);
      s locals = b(localp);
      try
      {
        if (b())
          this.p = c();
        a(a.e);
        return locals;
        paramh.d("uploadType", "media");
      }
      finally
      {
        locals.i();
      }
    }
  }

  private s b(p paramp)
    throws IOException
  {
    if ((!this.v) && (!(paramp.d() instanceof e)))
      paramp.a(new g());
    return a(paramp);
  }

  private boolean b()
    throws IOException
  {
    return c() >= 0L;
  }

  private long c()
    throws IOException
  {
    if (!this.i)
    {
      this.h = this.d.a();
      this.i = true;
    }
    return this.h;
  }

  private s c(h paramh)
    throws IOException
  {
    s locals = d(paramh);
    if (!locals.c());
    h localh;
    do
    {
      return locals;
      while (true)
      {
        try
        {
          localh = new h(locals.b().e());
          locals.i();
          this.m = this.d.b();
          if ((!this.m.markSupported()) && (b()))
            this.m = new BufferedInputStream(this.m);
          this.l = this.e.a(localh, null);
          d();
          new d(this, this.l);
          if (b())
          {
            locals = a(this.l);
            try
            {
              if (!locals.c())
                break;
              this.p = c();
              if (this.d.c())
                this.m.close();
              a(a.e);
              return locals;
            }
            finally
            {
              locals.i();
            }
          }
        }
        finally
        {
          locals.i();
        }
        locals = b(this.l);
      }
    }
    while (locals.d() != 308);
    String str = locals.b().e();
    if (str != null)
      localh = new h(str);
    long l1 = b(locals.b().f());
    long l2 = l1 - this.p;
    boolean bool1;
    label271: long l3;
    boolean bool2;
    if ((l2 >= 0L) && (l2 <= this.t))
    {
      bool1 = true;
      z.b(bool1);
      l3 = this.t - l2;
      if (!b())
        break label362;
      if (l3 > 0L)
      {
        this.m.reset();
        if (l2 != this.m.skip(l2))
          break label356;
        bool2 = true;
        label325: z.b(bool2);
      }
    }
    while (true)
    {
      this.p = l1;
      a(a.d);
      locals.i();
      break;
      bool1 = false;
      break label271;
      label356: bool2 = false;
      break label325;
      label362: if (l3 == 0L)
        this.u = null;
    }
  }

  private s d(h paramh)
    throws IOException
  {
    a(a.b);
    paramh.d("uploadType", "resumable");
    Object localObject1;
    if (this.g == null)
      localObject1 = new e();
    while (true)
    {
      p localp = this.e.a(this.j, paramh, (i)localObject1);
      this.k.a("X-Upload-Content-Type", this.d.d());
      if (b())
        this.k.a("X-Upload-Content-Length", Long.valueOf(c()));
      localp.g().putAll(this.k);
      s locals = b(localp);
      try
      {
        return locals;
        localObject1 = this.g;
      }
      finally
      {
        locals.i();
      }
    }
  }

  private void d()
    throws IOException
  {
    if (b());
    Object localObject;
    String str3;
    for (int i1 = (int)Math.min(this.q, c() - this.p); b(); i1 = this.q)
    {
      this.m.mark(i1);
      InputStream localInputStream = f.a(this.m, i1);
      localObject = new y(this.d.d(), localInputStream).b(true).a(i1).c(false);
      this.a = String.valueOf(c());
      this.t = i1;
      this.l.a((i)localObject);
      if (i1 != 0)
        break label424;
      m localm2 = this.l.g();
      String str2 = String.valueOf(this.a);
      if (str2.length() == 0)
        break label409;
      str3 = "bytes */".concat(str2);
      label149: localm2.d(str3);
      return;
    }
    int i5;
    label185: int i3;
    int i2;
    if (this.u == null)
      if (this.r == null)
      {
        i5 = i1 + 1;
        this.u = new byte[i1 + 1];
        if (this.r == null)
          break label520;
        this.u[0] = this.r.byteValue();
        i3 = i5;
        i2 = 0;
      }
    while (true)
    {
      label219: int i4 = f.a(this.m, this.u, i1 + 1 - i3, i3);
      if (i4 < i3)
      {
        i1 = i2 + Math.max(0, i4);
        if (this.r != null)
        {
          i1++;
          this.r = null;
        }
        if (this.a.equals("*"))
          this.a = String.valueOf(this.p + i1);
      }
      while (true)
      {
        localObject = new com.google.a.a.c.d(this.d.d(), this.u, 0, i1);
        this.s = (this.p + i1);
        break;
        i5 = i1;
        break label185;
        i2 = (int)(this.s - this.p);
        System.arraycopy(this.u, this.t - i2, this.u, 0, i2);
        if (this.r != null)
          this.u[i2] = this.r.byteValue();
        i3 = i1 - i2;
        break label219;
        this.r = Byte.valueOf(this.u[i1]);
      }
      label409: str3 = new String("bytes */");
      break label149;
      label424: m localm1 = this.l.g();
      long l1 = this.p;
      long l2 = this.p + i1 - 1L;
      String str1 = String.valueOf(String.valueOf(this.a));
      localm1.d(48 + str1.length() + "bytes " + l1 + "-" + l2 + "/" + str1);
      return;
      label520: i3 = i5;
      i2 = 0;
    }
  }

  public b a(i parami)
  {
    this.g = parami;
    return this;
  }

  public b a(m paramm)
  {
    this.k = paramm;
    return this;
  }

  public b a(String paramString)
  {
    if ((paramString.equals("POST")) || (paramString.equals("PUT")) || (paramString.equals("PATCH")));
    for (boolean bool = true; ; bool = false)
    {
      z.a(bool);
      this.j = paramString;
      return this;
    }
  }

  public b a(boolean paramBoolean)
  {
    this.n = paramBoolean;
    return this;
  }

  public s a(h paramh)
    throws IOException
  {
    if (this.c == a.a);
    for (boolean bool = true; ; bool = false)
    {
      z.a(bool);
      if (!this.n)
        break;
      return b(paramh);
    }
    return c(paramh);
  }

  void a()
    throws IOException
  {
    z.a(this.l, "The current request should not be null");
    this.l.a(new e());
    m localm = this.l.g();
    String str1 = String.valueOf(this.a);
    if (str1.length() != 0);
    for (String str2 = "bytes */".concat(str1); ; str2 = new String("bytes */"))
    {
      localm.d(str2);
      return;
    }
  }

  public b b(boolean paramBoolean)
  {
    this.v = paramBoolean;
    return this;
  }

  public static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.a.a.b.c.b
 * JD-Core Version:    0.6.2
 */