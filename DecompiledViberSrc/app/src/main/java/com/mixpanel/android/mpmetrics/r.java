package com.mixpanel.android.mpmetrics;

import android.content.Context;
import android.content.SharedPreferences;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

class r
{
  private final Executor a = Executors.newSingleThreadExecutor();

  public Future<SharedPreferences> a(Context paramContext, String paramString, b paramb)
  {
    FutureTask localFutureTask = new FutureTask(new a(paramContext, paramString, paramb));
    this.a.execute(localFutureTask);
    return localFutureTask;
  }

  private static class a
    implements Callable<SharedPreferences>
  {
    private final Context a;
    private final String b;
    private final r.b c;

    public a(Context paramContext, String paramString, r.b paramb)
    {
      this.a = paramContext;
      this.b = paramString;
      this.c = paramb;
    }

    public SharedPreferences a()
    {
      SharedPreferences localSharedPreferences = this.a.getSharedPreferences(this.b, 0);
      if (this.c != null)
        this.c.a(localSharedPreferences);
      return localSharedPreferences;
    }
  }

  static abstract interface b
  {
    public abstract void a(SharedPreferences paramSharedPreferences);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mixpanel.android.mpmetrics.r
 * JD-Core Version:    0.6.2
 */