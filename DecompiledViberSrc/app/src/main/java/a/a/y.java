package a.a;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

public class y
  implements ThreadFactory
{
  private final AtomicInteger a = new AtomicInteger(1);
  private final String b;
  private Thread.UncaughtExceptionHandler c;

  public y()
  {
    this.b = y.class.getSimpleName();
  }

  public y(String paramString)
  {
    this.b = paramString;
  }

  public void a(Thread.UncaughtExceptionHandler paramUncaughtExceptionHandler)
  {
    this.c = paramUncaughtExceptionHandler;
  }

  public Thread newThread(Runnable paramRunnable)
  {
    if (this.c == null)
      throw new IllegalStateException("No UncaughtExceptionHandler. You must call setUncaughtExceptionHandler before creating a new thread");
    Thread localThread = new Thread(paramRunnable, this.b + " #" + this.a.getAndIncrement());
    localThread.setUncaughtExceptionHandler(this.c);
    return localThread;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.y
 * JD-Core Version:    0.6.2
 */