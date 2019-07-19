package com.yandex.metrica;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private final Handler a;
  private long b;
  private Set<Object> c = new HashSet();
  private final Runnable d = new Runnable()
  {
    public void run()
    {
      a.a(a.this);
    }
  };
  private boolean e = true;

  public a(long paramLong)
  {
    this(paramLong, new Handler(Looper.getMainLooper()));
  }

  a(long paramLong, Handler paramHandler)
  {
    this.a = paramHandler;
    this.b = paramLong;
  }

  public void a()
  {
    if (this.e)
    {
      this.e = false;
      this.a.removeCallbacks(this.d);
      Iterator localIterator = new HashSet(this.c).iterator();
      while (localIterator.hasNext())
        localIterator.next();
    }
  }

  public void b()
  {
    if (!this.e)
    {
      this.e = true;
      this.a.postDelayed(this.d, this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.a
 * JD-Core Version:    0.6.2
 */