package pl.droidsonroids.gif;

abstract class n
  implements Runnable
{
  final b c;

  n(b paramb)
  {
    this.c = paramb;
  }

  abstract void a();

  public final void run()
  {
    try
    {
      if (!this.c.a())
        a();
      return;
    }
    catch (Throwable localThrowable)
    {
      Thread.UncaughtExceptionHandler localUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
      if (localUncaughtExceptionHandler != null)
        localUncaughtExceptionHandler.uncaughtException(Thread.currentThread(), localThrowable);
      throw localThrowable;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.n
 * JD-Core Version:    0.6.2
 */