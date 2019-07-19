package com.yandex.metrica.impl;

import android.content.ContentValues;
import android.os.Handler;
import com.yandex.metrica.impl.ob.ab;
import com.yandex.metrica.impl.ob.fh;
import com.yandex.metrica.impl.ob.lr;
import com.yandex.metrica.impl.ob.nc;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class bi<C extends ab> extends bv<C>
{
  private Runnable d = new Runnable()
  {
    public void run()
    {
      bi.this.d();
    }
  };

  public bi(C paramC, nc paramnc, ap paramap)
  {
    super(paramC, paramnc, paramap);
  }

  private void a(bd.a parama, Long paramLong)
  {
    List localList = ((ab)f()).m().a(paramLong);
    if (localList.isEmpty())
      localList.add(m.a);
    Iterator localIterator = localList.iterator();
    while (true)
      if (localIterator.hasNext())
      {
        ContentValues localContentValues = (ContentValues)localIterator.next();
        try
        {
          bd localbd = parama.a((ab)f());
          this.b.a(localbd.a(localContentValues));
        }
        catch (Exception localException)
        {
        }
      }
  }

  void a()
  {
    ((ab)f()).n().removeCallbacks(this.d);
  }

  public void b()
  {
    synchronized (this.a)
    {
      if (!this.c)
      {
        a();
        if (((ab)f()).l().P() > 0)
        {
          long l = TimeUnit.SECONDS.toMillis(((ab)f()).l().P());
          ((ab)f()).n().postDelayed(this.d, l);
        }
      }
      return;
    }
  }

  void c()
  {
    super.c();
    lr locallr = ((ab)f()).l();
    if ((locallr.S()) && (bw.a(locallr.D())))
    {
      a(bc.J(), Long.valueOf(-2L));
      a(bd.N(), null);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.bi
 * JD-Core Version:    0.6.2
 */