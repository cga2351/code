package com.viber.voip.ads.b.c.b.a;

import android.os.Handler;
import android.support.v4.util.Pair;
import com.viber.common.a.e;
import com.viber.voip.ViberEnv;
import com.viber.voip.av.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public abstract class a<LIST, ADAPTER>
  implements c
{
  private static final e d = ViberEnv.getLogger();
  private static final long e = TimeUnit.SECONDS.toMillis(1L);
  private static final long f = TimeUnit.SECONDS.toMillis(2L);
  protected final LIST a;
  protected final ADAPTER b;
  protected int c = 0;
  private Handler g = av.e.f.a();
  private List<Runnable> h = Collections.synchronizedList(new ArrayList());
  private final d i;

  a(d paramd, LIST paramLIST, ADAPTER paramADAPTER)
  {
    this.i = paramd;
    this.a = paramLIST;
    this.b = paramADAPTER;
    a();
    b();
    c();
    e();
  }

  private void a(Pair<com.viber.voip.ads.b.c.c.c, Boolean> paramPair)
  {
    boolean bool;
    if ((paramPair != null) && (paramPair.first != null) && (!this.i.a(((com.viber.voip.ads.b.c.c.c)paramPair.first).a().f(), 1)))
    {
      if (paramPair.second == null)
        break label112;
      bool = ((Boolean)paramPair.second).booleanValue();
      if (!bool)
        break label117;
    }
    label112: label117: for (long l = e; ; l = f)
    {
      a locala = new a(((com.viber.voip.ads.b.c.c.c)paramPair.first).a(), l);
      this.h.add(locala);
      this.g.postDelayed(locala, l);
      return;
      bool = false;
      break;
    }
  }

  protected abstract Pair<com.viber.voip.ads.b.c.c.c, Boolean> a(LIST paramLIST);

  protected abstract void a();

  protected abstract void b();

  void b(LIST paramLIST)
  {
    a(a(paramLIST));
  }

  protected abstract void c();

  protected abstract void d();

  protected abstract void e();

  protected abstract void f();

  public void g()
  {
    j();
  }

  public void h()
  {
    j();
    f();
    d();
  }

  public void i()
  {
    b(this.a);
  }

  void j()
  {
    ArrayList localArrayList = new ArrayList(this.h);
    this.h.clear();
    Iterator localIterator = localArrayList.iterator();
    while (localIterator.hasNext())
    {
      Runnable localRunnable = (Runnable)localIterator.next();
      this.g.removeCallbacks(localRunnable);
    }
  }

  private class a
    implements Runnable
  {
    private com.viber.voip.ads.b.b.b.a b;
    private long c;

    a(com.viber.voip.ads.b.b.b.a paramLong, long arg3)
    {
      this.b = paramLong;
      Object localObject;
      this.c = localObject;
    }

    public void run()
    {
      a.a(a.this).c(this.b, a.this.c);
      a.b(a.this).remove(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ads.b.c.b.a.a
 * JD-Core Version:    0.6.2
 */