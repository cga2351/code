package com.my.target;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public abstract class dq
{
  private static final Executor a = Executors.newSingleThreadExecutor();
  private static final Executor b = Executors.newSingleThreadExecutor();
  private static final Executor c = new Executor()
  {
    public void execute(Runnable paramAnonymousRunnable)
    {
      dq.a().post(paramAnonymousRunnable);
    }
  };
  private static final Handler d = new Handler(Looper.getMainLooper());

  public static void a(Runnable paramRunnable)
  {
    a.execute(paramRunnable);
  }

  public static void b(Runnable paramRunnable)
  {
    b.execute(paramRunnable);
  }

  public static void c(Runnable paramRunnable)
  {
    c.execute(paramRunnable);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dq
 * JD-Core Version:    0.6.2
 */