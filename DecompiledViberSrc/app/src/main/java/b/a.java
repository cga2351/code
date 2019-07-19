package b;

import android.annotation.SuppressLint;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

final class a
{
  static final int a = 1 + e;
  static final int b = 1 + 2 * e;
  private static final a c = new a();
  private static final int e = Runtime.getRuntime().availableProcessors();
  private final Executor d = new a(null);

  public static ExecutorService a()
  {
    ThreadPoolExecutor localThreadPoolExecutor = new ThreadPoolExecutor(a, b, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
    a(localThreadPoolExecutor, true);
    return localThreadPoolExecutor;
  }

  @SuppressLint({"NewApi"})
  public static void a(ThreadPoolExecutor paramThreadPoolExecutor, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 9)
      paramThreadPoolExecutor.allowCoreThreadTimeOut(paramBoolean);
  }

  public static Executor b()
  {
    return c.d;
  }

  private static class a
    implements Executor
  {
    public void execute(Runnable paramRunnable)
    {
      new Handler(Looper.getMainLooper()).post(paramRunnable);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     b.a
 * JD-Core Version:    0.6.2
 */