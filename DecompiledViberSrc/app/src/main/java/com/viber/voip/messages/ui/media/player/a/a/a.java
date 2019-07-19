package com.viber.voip.messages.ui.media.player.a.a;

import android.os.Handler;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.d.b;
import java.util.concurrent.TimeUnit;

public abstract class a
{
  protected static final long b = TimeUnit.SECONDS.toMillis(2L);
  protected static final long c = TimeUnit.SECONDS.toMillis(2L);
  private final b<a> a;
  protected final Handler d;
  protected final long e;
  protected final long f;
  private final b<a> g;

  public a(long paramLong1, long paramLong2)
  {
    this.e = paramLong1;
    this.f = paramLong2;
    this.a = new a(this, null);
    this.g = new b(this, null);
    this.d = av.a(av.e.a);
  }

  private void a(boolean paramBoolean, long paramLong)
  {
    j();
    if ((paramBoolean) && (!f()))
    {
      this.d.postDelayed(this.a, paramLong);
      return;
    }
    c();
  }

  private void b(boolean paramBoolean, long paramLong)
  {
    j();
    if ((paramBoolean) && (f()))
    {
      this.d.postDelayed(this.g, paramLong);
      return;
    }
    e();
  }

  private void j()
  {
    this.d.removeCallbacks(this.a);
    this.d.removeCallbacks(this.g);
  }

  private void k()
  {
    if (a())
    {
      h();
      if (b())
        d();
    }
  }

  private void l()
  {
    i();
  }

  public final void a(boolean paramBoolean)
  {
    if (f())
    {
      c(paramBoolean);
      return;
    }
    b(paramBoolean);
  }

  protected boolean a()
  {
    return true;
  }

  public final void b(boolean paramBoolean)
  {
    a(paramBoolean, 0L);
  }

  protected boolean b()
  {
    return true;
  }

  protected abstract void c();

  public final void c(boolean paramBoolean)
  {
    b(paramBoolean, 0L);
  }

  public final void d()
  {
    b(true, this.f);
  }

  protected abstract void e();

  public abstract boolean f();

  public void g()
  {
    j();
  }

  protected abstract void h();

  protected abstract void i();

  private static class a extends b<a>
  {
    private a(a parama)
    {
      super();
    }

    public void a(a parama)
    {
      a.a(parama);
    }
  }

  private static class b extends b<a>
  {
    private b(a parama)
    {
      super();
    }

    public void a(a parama)
    {
      a.b(parama);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.media.player.a.a.a
 * JD-Core Version:    0.6.2
 */