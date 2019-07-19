package com.crashlytics.android.c;

import c.a.a.a.a.g.t;
import c.a.a.a.c;
import c.a.a.a.l;
import java.util.concurrent.atomic.AtomicBoolean;

class s
  implements Thread.UncaughtExceptionHandler
{
  private final a a;
  private final b b;
  private final boolean c;
  private final Thread.UncaughtExceptionHandler d;
  private final AtomicBoolean e;

  public s(a parama, b paramb, boolean paramBoolean, Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.a = parama;
    this.b = paramb;
    this.c = paramBoolean;
    this.d = paramUncaughtExceptionHandler;
    this.e = new AtomicBoolean(false);
  }

  boolean a()
  {
    return this.e.get();
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    this.e.set(true);
    try
    {
      this.a.a(this.b, paramThread, paramThrowable, this.c);
      return;
    }
    catch (Exception localException)
    {
      c.g().e("CrashlyticsCore", "An error occurred in the uncaught exception handler", localException);
      return;
    }
    finally
    {
      c.g().a("CrashlyticsCore", "Crashlytics completed exception processing. Invoking default exception handler.");
      this.d.uncaughtException(paramThread, paramThrowable);
      this.e.set(false);
    }
  }

  static abstract interface a
  {
    public abstract void a(s.b paramb, Thread paramThread, Throwable paramThrowable, boolean paramBoolean);
  }

  static abstract interface b
  {
    public abstract t a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.c.s
 * JD-Core Version:    0.6.2
 */