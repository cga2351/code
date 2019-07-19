package pl.droidsonroids.gif;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

class m extends n
{
  m(b paramb)
  {
    super(paramb);
  }

  public void a()
  {
    long l = this.c.f.a(this.c.e);
    if (l >= 0L)
    {
      this.c.c = (l + SystemClock.uptimeMillis());
      if ((this.c.isVisible()) && (this.c.b) && (!this.c.h))
      {
        this.c.a.remove(this);
        this.c.j = this.c.a.schedule(this, l, TimeUnit.MILLISECONDS);
      }
      if ((!this.c.g.isEmpty()) && (this.c.i() == -1 + this.c.f.q()))
        this.c.i.sendEmptyMessageAtTime(this.c.j(), this.c.c);
    }
    while (true)
    {
      if ((this.c.isVisible()) && (!this.c.i.hasMessages(-1)))
        this.c.i.sendEmptyMessageAtTime(-1, 0L);
      return;
      this.c.c = -9223372036854775808L;
      this.c.b = false;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.m
 * JD-Core Version:    0.6.2
 */