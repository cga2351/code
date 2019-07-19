package android.arch.lifecycle;

import android.os.Handler;

public class r
{
  private final i a;
  private final Handler b;
  private a c;

  public r(h paramh)
  {
    this.a = new i(paramh);
    this.b = new Handler();
  }

  private void a(e.a parama)
  {
    if (this.c != null)
      this.c.run();
    this.c = new a(this.a, parama);
    this.b.postAtFrontOfQueue(this.c);
  }

  public void a()
  {
    a(e.a.ON_CREATE);
  }

  public void b()
  {
    a(e.a.ON_START);
  }

  public void c()
  {
    a(e.a.ON_START);
  }

  public void d()
  {
    a(e.a.ON_STOP);
    a(e.a.ON_DESTROY);
  }

  public e e()
  {
    return this.a;
  }

  static class a
    implements Runnable
  {
    final e.a a;
    private final i b;
    private boolean c = false;

    a(i parami, e.a parama)
    {
      this.b = parami;
      this.a = parama;
    }

    public void run()
    {
      if (!this.c)
      {
        this.b.a(this.a);
        this.c = true;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.r
 * JD-Core Version:    0.6.2
 */