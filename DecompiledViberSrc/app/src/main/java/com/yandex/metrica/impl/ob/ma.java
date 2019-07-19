package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.os.Handler;
import com.yandex.metrica.impl.a;
import com.yandex.metrica.impl.a.a;
import com.yandex.metrica.impl.v;

public class ma
{
  private final lz a;
  private final ge<mb> b;
  private final om c;
  private final Handler d;
  private final a.a e;
  private final a f;
  private final ly g;
  private mm h;
  private boolean i;
  private long j;
  private long k;
  private long l;
  private boolean m;
  private boolean n;
  private boolean o = false;
  private final Object p = new Object();

  public ma(Context paramContext, Handler paramHandler)
  {
    this(paramContext, new lz(paramContext, null, paramHandler), hd.a.a(mb.class).a(paramContext), new om(), paramHandler, v.a().h());
  }

  private ma(Context paramContext, lz paramlz, ge<mb> paramge, om paramom, Handler paramHandler, a parama)
  {
    this(paramlz, paramge, new ly(paramContext, paramge), paramom, paramHandler, parama);
  }

  ma(lz paramlz, ge<mb> paramge, ly paramly, om paramom, Handler paramHandler, a parama)
  {
    this.a = paramlz;
    this.b = paramge;
    this.g = paramly;
    this.c = paramom;
    this.d = paramHandler;
    this.e = new a.a()
    {
      public void a()
      {
        ma.a(ma.this, true);
        ma.b(ma.this).a(ma.a(ma.this));
      }
    };
    this.f = parama;
  }

  public void a()
  {
    while (true)
    {
      synchronized (this.p)
      {
        if ((this.i) && (this.h != null))
        {
          if (!this.m)
            break label100;
          if (!this.n)
            continue;
          if (this.c.a() - this.l >= this.h.d)
            b();
        }
        return;
        if (this.c.a() - this.l < this.h.a)
          continue;
        b();
      }
      label100: if (this.j - this.k >= this.h.b)
        b();
    }
  }

  public void a(mw parammw)
  {
    c();
    b(parammw);
  }

  void b()
  {
    if (!this.o)
    {
      this.f.a(this.h.c, this.d, this.e);
      return;
    }
    this.a.a(this.g);
  }

  public void b(mw parammw)
  {
    int i1 = 0;
    if (parammw == null);
    while (true)
    {
      Object localObject1 = this.p;
      if (parammw != null);
      try
      {
        this.i = parammw.n.e;
        this.h = parammw.z;
        this.j = parammw.A;
        this.k = parammw.B;
        this.a.a(parammw);
        if (i1 != 0)
          a();
        return;
        if (((this.i) || (parammw.n.e != true)) && (this.h != null) && (this.h.equals(parammw.z)) && (this.j == parammw.A) && (this.k == parammw.B))
        {
          boolean bool = this.a.b(parammw);
          i1 = 0;
          if (!bool)
            continue;
        }
        i1 = 1;
      }
      finally
      {
      }
    }
  }

  void c()
  {
    mb localmb = (mb)this.b.a();
    this.l = localmb.c;
    this.m = localmb.d;
    this.n = localmb.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.ma
 * JD-Core Version:    0.6.2
 */