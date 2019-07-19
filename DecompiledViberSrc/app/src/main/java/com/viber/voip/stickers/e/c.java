package com.viber.voip.stickers.e;

import android.os.Handler;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class c
{
  private static final Logger a = ViberEnv.getLogger();
  private final Handler b = av.a(av.e.a);
  private Set<a> c = new HashSet();
  private Set<d> d = new HashSet();
  private Set<g> e = new HashSet();
  private Set<f> f = new HashSet();
  private Set<e> g = new HashSet();
  private Runnable h = null;

  public static c a()
  {
    return a.a();
  }

  public void a(final int paramInt)
  {
    final Set localSet = c();
    this.b.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
          ((d)localIterator.next()).a(paramInt);
      }
    });
  }

  public void a(a parama)
  {
    try
    {
      this.c.add(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(d paramd)
  {
    try
    {
      this.d.add(paramd);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(f paramf)
  {
    try
    {
      this.f.add(paramf);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(g paramg)
  {
    try
    {
      this.e.add(paramg);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(final List<com.viber.voip.stickers.entity.a> paramList1, final List<com.viber.voip.stickers.entity.a> paramList2)
  {
    final Set localSet = b();
    if (this.h != null)
      this.b.removeCallbacks(this.h);
    this.h = new Runnable()
    {
      public void run()
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
          ((a)localIterator.next()).onStickerPackageChanged(paramList1, paramList2);
        c.a(c.this, null);
      }
    };
    this.b.postDelayed(this.h, 200L);
  }

  public Set<a> b()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.c);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void b(final int paramInt)
  {
    final Set localSet = d();
    this.b.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
          ((g)localIterator.next()).a(paramInt);
      }
    });
  }

  public void b(a parama)
  {
    try
    {
      this.c.remove(parama);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Set<d> c()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.d);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void c(final int paramInt)
  {
    final Set localSet = e();
    this.b.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
          ((f)localIterator.next()).a(paramInt);
      }
    });
  }

  public Set<g> d()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.e);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void d(final int paramInt)
  {
    final Set localSet = f();
    this.b.post(new Runnable()
    {
      public void run()
      {
        Iterator localIterator = localSet.iterator();
        while (localIterator.hasNext())
          ((e)localIterator.next()).a(paramInt);
      }
    });
  }

  public Set<f> e()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.f);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Set<e> f()
  {
    try
    {
      HashSet localHashSet = new HashSet(this.g);
      return localHashSet;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static class a
  {
    private static final c a = new c(null);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.stickers.e.c
 * JD-Core Version:    0.6.2
 */