package com.yandex.metrica.impl.ob;

import android.content.Context;
import android.text.TextUtils;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class li
{
  private static final EnumSet<b> a = EnumSet.of(b.d, b.e, b.b);
  private static final EnumSet<b> b = EnumSet.of(b.d, b.e);
  private final Set<a> c = new HashSet();
  private lj d;
  private lj e;
  private boolean f;
  private final fy g;
  private b h = b.a;

  public li(Context paramContext)
  {
    this(new fy(fj.a(paramContext).c()));
  }

  li(fy paramfy)
  {
    this.g = paramfy;
    this.f = this.g.d();
    if (!this.f)
    {
      String str = this.g.b();
      if (!TextUtils.isEmpty(str))
        this.d = new lj(str, 0L, 0L);
      this.e = this.g.c();
      this.h = b.values()[this.g.d(0)];
    }
  }

  private void a()
  {
    switch (1.a[this.h.ordinal()])
    {
    default:
      return;
    case 4:
      b(this.e);
      return;
    case 5:
    }
    b(this.d);
  }

  private void a(b paramb)
  {
    if (paramb != this.h)
    {
      this.h = paramb;
      this.g.e(this.h.ordinal()).i();
      a();
    }
  }

  private void b(lj paramlj)
  {
    if (paramlj != null);
    while (true)
    {
      try
      {
        if ((!this.c.isEmpty()) && (!this.f))
        {
          i = 0;
          Iterator localIterator = this.c.iterator();
          if (localIterator.hasNext())
          {
            if (!((a)localIterator.next()).a(paramlj))
              break label112;
            j = 1;
            break label115;
          }
          if (i != 0)
          {
            this.f = true;
            this.g.e().f().i();
            this.c.clear();
          }
        }
        return;
      }
      finally
      {
      }
      label112: int j = i;
      label115: int i = j;
    }
  }

  public void a(a parama)
  {
    try
    {
      if (!this.f)
      {
        this.c.add(parama);
        a();
      }
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(lj paramlj)
  {
    try
    {
      b localb;
      if (!b.contains(this.h))
      {
        this.e = paramlj;
        this.g.a(paramlj).i();
        switch (1.a[this.h.ordinal()])
        {
        default:
          localb = this.h;
        case 1:
        case 2:
        }
      }
      while (true)
      {
        a(localb);
        return;
        if (paramlj == null)
        {
          localb = b.c;
        }
        else
        {
          localb = b.d;
          continue;
          if (paramlj == null)
            localb = b.e;
          else
            localb = b.d;
        }
      }
    }
    finally
    {
    }
  }

  public void a(String paramString)
  {
    try
    {
      b localb;
      if ((!a.contains(this.h)) && (!TextUtils.isEmpty(paramString)))
      {
        this.d = new lj(paramString, 0L, 0L);
        this.g.a(paramString).i();
        switch (1.a[this.h.ordinal()])
        {
        case 2:
        default:
          localb = this.h;
        case 1:
        case 3:
        }
      }
      while (true)
      {
        a(localb);
        return;
        localb = b.b;
        continue;
        localb = b.e;
      }
    }
    finally
    {
    }
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

  public static abstract interface a
  {
    public abstract boolean a(lj paramlj);
  }

  private static enum b
  {
    static
    {
      b[] arrayOfb = new b[5];
      arrayOfb[0] = a;
      arrayOfb[1] = b;
      arrayOfb[2] = c;
      arrayOfb[3] = d;
      arrayOfb[4] = e;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.li
 * JD-Core Version:    0.6.2
 */