package com.my.target;

import android.os.Handler;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.WeakHashMap;

public class bh
{
  public static final bh a = new bh(1000);
  private static final Handler b = new Handler(Looper.getMainLooper());
  private final int c;
  private final WeakHashMap<Runnable, Boolean> d = new WeakHashMap();
  private final Runnable e = new Runnable()
  {
    public void run()
    {
      bh.a(bh.this);
    }
  };

  private bh(int paramInt)
  {
    this.c = paramInt;
  }

  public static final bh a(int paramInt)
  {
    return new bh(paramInt);
  }

  private void a()
  {
    try
    {
      Iterator localIterator = new HashSet(this.d.keySet()).iterator();
      while (localIterator.hasNext())
        ((Runnable)localIterator.next()).run();
    }
    finally
    {
    }
    if (this.d.keySet().size() > 0)
      b();
  }

  private void b()
  {
    b.postDelayed(this.e, this.c);
  }

  public void a(Runnable paramRunnable)
  {
    try
    {
      int i = this.d.size();
      if ((this.d.put(paramRunnable, Boolean.valueOf(true)) == null) && (i == 0))
        b();
      return;
    }
    finally
    {
    }
  }

  public void b(Runnable paramRunnable)
  {
    try
    {
      this.d.remove(paramRunnable);
      if (this.d.size() == 0)
        b.removeCallbacks(this.e);
      return;
    }
    finally
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bh
 * JD-Core Version:    0.6.2
 */