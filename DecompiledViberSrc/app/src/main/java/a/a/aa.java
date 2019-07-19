package a.a;

import com.appboy.f.c;

public class aa
  implements Thread.UncaughtExceptionHandler
{
  private static final String a = c.a(aa.class);
  private d b;

  public aa()
  {
  }

  public aa(d paramd)
  {
    this.b = paramd;
  }

  public void a(d paramd)
  {
    this.b = paramd;
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      if (this.b != null)
      {
        c.c(a, "Uncaught exception from thread. Publishing as Throwable event.", paramThrowable);
        this.b.a(paramThrowable, Throwable.class);
      }
      return;
    }
    catch (Exception localException)
    {
      c.c(a, "Failed to log throwable.", localException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.aa
 * JD-Core Version:    0.6.2
 */