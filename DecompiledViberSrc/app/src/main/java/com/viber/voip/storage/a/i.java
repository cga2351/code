package com.viber.voip.storage.a;

import android.os.Handler;
import android.support.v4.util.LongSparseArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.storage.repository.p.a;
import com.viber.voip.util.cl;

public class i
{
  static final a a = (a)cl.b(a.class);
  private static final Logger b = ViberEnv.getLogger();
  private final e c;
  private final Handler d;
  private final f e;
  private final Object f = new Object();
  private final LongSparseArray<c> g = new LongSparseArray(1);
  private final c.a h = new j(this);

  public i(e parame, Handler paramHandler1, Handler paramHandler2)
  {
    this.c = parame;
    this.d = paramHandler1;
    this.e = new f(paramHandler2);
  }

  private void b(c paramc)
  {
    synchronized (this.f)
    {
      this.g.remove(paramc.a());
      return;
    }
  }

  public void a(a parama, a parama1)
  {
    synchronized (this.f)
    {
      c localc1 = (c)this.g.get(parama.a());
      a locala = this.e.a(parama1);
      if (this.g.get(parama.a()) != null)
      {
        localc1.a(locala);
        return;
      }
      c localc2 = this.c.a(parama, locala, this.h);
      this.g.put(parama.a(), localc2);
      this.d.post(localc2);
    }
  }

  public boolean a(long paramLong, a parama)
  {
    while (true)
    {
      synchronized (this.f)
      {
        c localc = (c)this.g.get(paramLong);
        if (localc != null)
        {
          localc.a(parama);
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);

    public abstract void a(p.a parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.a.i
 * JD-Core Version:    0.6.2
 */