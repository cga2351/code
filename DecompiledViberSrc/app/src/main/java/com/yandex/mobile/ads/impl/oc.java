package com.yandex.mobile.ads.impl;

import android.os.Process;
import java.util.concurrent.BlockingQueue;

public final class oc extends Thread
{
  private static final boolean a = on.b;
  private final BlockingQueue<oi<?>> b;
  private final BlockingQueue<oi<?>> c;
  private final ob d;
  private final ol e;
  private volatile boolean f = false;

  public oc(BlockingQueue<oi<?>> paramBlockingQueue1, BlockingQueue<oi<?>> paramBlockingQueue2, ob paramob, ol paramol)
  {
    this.b = paramBlockingQueue1;
    this.c = paramBlockingQueue2;
    this.d = paramob;
    this.e = paramol;
  }

  public final void a()
  {
    this.f = true;
    interrupt();
  }

  public final void run()
  {
    if (a)
      on.a("start new dispatcher", new Object[0]);
    Process.setThreadPriority(10);
    this.d.a();
    final oi localoi;
    label65: ob.a locala;
    int i;
    while (true)
    {
      try
      {
        localoi = (oi)this.b.take();
        if (!localoi.j())
          break label65;
        localoi.g();
        continue;
      }
      catch (InterruptedException localInterruptedException)
      {
      }
      if (this.f)
      {
        return;
        locala = this.d.a(localoi.b());
        if (locala == null)
        {
          this.c.put(localoi);
        }
        else
        {
          if (locala.e >= System.currentTimeMillis())
            break label225;
          i = 1;
          label110: if (i == 0)
            break;
          localoi.a(locala);
          this.c.put(localoi);
        }
      }
    }
    ok localok = localoi.a(new oh(locala.a, locala.g));
    if (locala.f < System.currentTimeMillis());
    for (int j = 1; ; j = 0)
    {
      if (j == 0)
      {
        this.e.a(localoi, localok);
        break;
      }
      localoi.a(locala);
      localok.d = true;
      this.e.a(localoi, localok, new Runnable()
      {
        public final void run()
        {
          try
          {
            oc.a(oc.this).put(localoi);
            return;
          }
          catch (InterruptedException localInterruptedException)
          {
          }
        }
      });
      break;
      label225: i = 0;
      break label110;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.oc
 * JD-Core Version:    0.6.2
 */