package android.arch.a.a;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class b extends c
{
  private final Object a = new Object();
  private ExecutorService b = Executors.newFixedThreadPool(2);
  private volatile Handler c;

  public void a(Runnable paramRunnable)
  {
    this.b.execute(paramRunnable);
  }

  public void b(Runnable paramRunnable)
  {
    if (this.c == null);
    synchronized (this.a)
    {
      if (this.c == null)
        this.c = new Handler(Looper.getMainLooper());
      this.c.post(paramRunnable);
      return;
    }
  }

  public boolean b()
  {
    return Looper.getMainLooper().getThread() == Thread.currentThread();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.a.a.b
 * JD-Core Version:    0.6.2
 */