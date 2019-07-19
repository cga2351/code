package com.iab.omid.library.appnexus.walking.a;

import java.util.ArrayDeque;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class c
  implements b.a
{
  private final BlockingQueue<Runnable> a = new LinkedBlockingQueue();
  private final ThreadPoolExecutor b = new ThreadPoolExecutor(1, 1, 1L, TimeUnit.SECONDS, this.a);
  private final ArrayDeque<b> c = new ArrayDeque();
  private b d = null;

  private void a()
  {
    this.d = ((b)this.c.poll());
    if (this.d != null)
      this.d.a(this.b);
  }

  public void a(b paramb)
  {
    this.d = null;
    a();
  }

  public void b(b paramb)
  {
    paramb.a(this);
    this.c.add(paramb);
    if (this.d == null)
      a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.walking.a.c
 * JD-Core Version:    0.6.2
 */