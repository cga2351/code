package com.yandex.metrica.impl.ob;

import android.os.Bundle;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

public class eu
{
  private final ScheduledExecutorService a;

  public eu()
  {
    this(Executors.newSingleThreadScheduledExecutor(new od("YMM-CSE")));
  }

  eu(ScheduledExecutorService paramScheduledExecutorService)
  {
    this.a = paramScheduledExecutorService;
  }

  public ScheduledExecutorService a()
  {
    return this.a;
  }

  public void a(fa paramfa, Bundle paramBundle)
  {
    this.a.execute(new a(paramfa, paramBundle));
  }

  public void a(fa paramfa, Bundle paramBundle, ez paramez)
  {
    this.a.execute(new a(paramfa, paramBundle, paramez));
  }

  public static class a
    implements Runnable
  {
    private final fa a;
    private final Bundle b;
    private final ez c;

    public a(fa paramfa, Bundle paramBundle)
    {
      this(paramfa, paramBundle, null);
    }

    public a(fa paramfa, Bundle paramBundle, ez paramez)
    {
      this.a = paramfa;
      this.b = paramBundle;
      this.c = paramez;
    }

    public void run()
    {
      try
      {
        this.a.a(this.b, this.c);
        return;
      }
      catch (Exception localException)
      {
        while (this.c == null);
        this.c.a();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.eu
 * JD-Core Version:    0.6.2
 */