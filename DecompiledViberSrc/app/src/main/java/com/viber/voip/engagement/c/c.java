package com.viber.voip.engagement.c;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.cl;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private static final a b = (a)cl.b(a.class);
  private Handler c;
  private Handler d;
  private a e;
  private a f = b;
  private b g;

  public c(a parama, Handler paramHandler1, Handler paramHandler2)
  {
    this.c = paramHandler1;
    this.d = paramHandler2;
    this.e = parama;
  }

  private void a(final com.viber.voip.engagement.data.a parama)
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        c.a(c.this).a(parama);
      }
    });
  }

  private void e()
  {
    com.viber.voip.engagement.data.a locala = this.e.a();
    if (locala != null)
    {
      a(locala);
      return;
    }
    f();
  }

  private void f()
  {
    this.d.post(new Runnable()
    {
      public void run()
      {
        c.a(c.this).f();
      }
    });
  }

  public void a()
  {
    c();
    this.g = new b();
    this.c.post(this.g);
  }

  public void a(a parama)
  {
    this.f = parama;
  }

  public com.viber.voip.engagement.data.a b()
  {
    return this.e.a();
  }

  public void c()
  {
    if (this.g != null)
    {
      this.c.removeCallbacks(this.g);
      this.g = null;
    }
  }

  public void d()
  {
    c();
    this.f = b;
  }

  public static abstract interface a
  {
    public abstract void a(com.viber.voip.engagement.data.a parama);

    public abstract void f();
  }

  class b
    implements Runnable
  {
    b()
    {
    }

    public void run()
    {
      c.b(c.this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.c.c
 * JD-Core Version:    0.6.2
 */