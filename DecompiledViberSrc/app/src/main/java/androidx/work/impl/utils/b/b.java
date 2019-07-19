package androidx.work.impl.utils.b;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class b
  implements a
{
  volatile Thread a;
  private final Handler b = new Handler(Looper.getMainLooper());
  private final Executor c = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      b.this.b(paramAnonymousRunnable);
    }
  };
  private final ThreadFactory d = new ThreadFactory()
  {
    private int b = 0;

    public Thread newThread(Runnable paramAnonymousRunnable)
    {
      Thread localThread = Executors.defaultThreadFactory().newThread(paramAnonymousRunnable);
      localThread.setName("WorkManager-WorkManagerTaskExecutor-thread-" + this.b);
      this.b = (1 + this.b);
      b.this.a = localThread;
      return localThread;
    }
  };
  private final ExecutorService e = Executors.newSingleThreadExecutor(this.d);

  public Executor a()
  {
    return this.c;
  }

  public void a(Runnable paramRunnable)
  {
    this.e.execute(paramRunnable);
  }

  public Thread b()
  {
    return this.a;
  }

  public void b(Runnable paramRunnable)
  {
    this.b.post(paramRunnable);
  }

  public Executor c()
  {
    return this.e;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.b.b
 * JD-Core Version:    0.6.2
 */