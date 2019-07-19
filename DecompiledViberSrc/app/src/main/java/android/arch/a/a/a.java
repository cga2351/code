package android.arch.a.a;

import java.util.concurrent.Executor;

public class a extends c
{
  private static volatile a a;
  private static final Executor d = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      a.a().b(paramAnonymousRunnable);
    }
  };
  private static final Executor e = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      a.a().a(paramAnonymousRunnable);
    }
  };
  private c b = this.c;
  private c c = new b();

  public static a a()
  {
    if (a != null)
      return a;
    try
    {
      if (a == null)
        a = new a();
      return a;
    }
    finally
    {
    }
  }

  public void a(Runnable paramRunnable)
  {
    this.b.a(paramRunnable);
  }

  public void b(Runnable paramRunnable)
  {
    this.b.b(paramRunnable);
  }

  public boolean b()
  {
    return this.b.b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.a.a.a
 * JD-Core Version:    0.6.2
 */