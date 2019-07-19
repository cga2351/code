package com.viber.voip.block;

import android.os.Handler;
import com.viber.voip.av.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class l
  implements k
{
  private Set<k.b> a = new HashSet();
  private Set<k.b> b = new HashSet();
  private final Object c = new Object();

  private void a(Set<k.b> paramSet, k.c paramc)
  {
    synchronized (this.c)
    {
      HashSet localHashSet = new HashSet(paramSet);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        paramc.a((k.b)localIterator.next());
    }
  }

  public void a(k.b paramb)
  {
    synchronized (this.c)
    {
      if ((paramb instanceof k.e))
      {
        this.b.add(paramb);
        return;
      }
      this.a.add(paramb);
    }
  }

  public void a(k.c paramc)
  {
    a(this.a, paramc);
    av.e.f.a().postDelayed(new m(this, paramc), 500L);
  }

  public void b(k.b paramb)
  {
    synchronized (this.c)
    {
      if ((paramb instanceof k.e))
      {
        this.b.remove(paramb);
        return;
      }
      this.a.remove(paramb);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.block.l
 * JD-Core Version:    0.6.2
 */