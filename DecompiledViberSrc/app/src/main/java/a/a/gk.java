package a.a;

import com.appboy.a.b;
import java.util.concurrent.ThreadFactory;

public class gk
  implements gq
{
  private static final String a = com.appboy.f.c.a(gk.class);
  private final b b;
  private final cj c;
  private final go d;
  private final Object e = new Object();
  private volatile boolean f = false;
  private volatile Thread g;
  private volatile boolean h = true;
  private ck i;
  private boolean j = false;

  public gk(b paramb, d paramd, cj paramcj, go paramgo, ThreadFactory paramThreadFactory, boolean paramBoolean)
  {
    this.b = paramb;
    this.c = paramcj;
    this.d = paramgo;
    this.g = paramThreadFactory.newThread(new a(null));
    this.i = new ck(paramd);
    this.j = paramBoolean;
  }

  private void b(ch paramch)
  {
    if ((paramch.h()) || (this.j))
    {
      this.i.a(paramch);
      return;
    }
    this.c.a(paramch);
  }

  private cc c()
  {
    return new cc(this.b.a());
  }

  private void c(ch paramch)
  {
    if ((paramch.h()) || (this.j))
    {
      this.i.b(paramch);
      return;
    }
    this.c.b(paramch);
  }

  public void a()
  {
    synchronized (this.e)
    {
      if (this.f)
      {
        com.appboy.f.c.b(a, "Automatic request execution start was previously requested, continuing without action.");
        return;
      }
      if (this.g != null)
        this.g.start();
      this.f = true;
      return;
    }
  }

  public void a(be parambe)
  {
    this.d.a(parambe);
  }

  public void a(bi parambi)
  {
    this.d.a(parambi);
  }

  public void a(c paramc)
  {
    synchronized (this.e)
    {
      this.h = false;
      this.g.interrupt();
      this.g = null;
      if (!this.d.a())
        this.d.a(c());
      ch localch = this.d.c();
      if (localch != null)
        c(localch);
      paramc.a();
      return;
    }
  }

  public void a(ch paramch)
  {
    this.d.a(paramch);
  }

  public void b(be parambe)
  {
    this.d.b(parambe);
  }

  class a
    implements Runnable
  {
    private a()
    {
    }

    public void run()
    {
      while (gk.a(gk.this))
        try
        {
          ch localch = gk.b(gk.this).b();
          gk.a(gk.this, localch);
        }
        catch (InterruptedException localInterruptedException)
        {
          com.appboy.f.c.e(gk.b(), "Automatic thread interrupted! [" + localInterruptedException.getMessage() + "]");
        }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gk
 * JD-Core Version:    0.6.2
 */