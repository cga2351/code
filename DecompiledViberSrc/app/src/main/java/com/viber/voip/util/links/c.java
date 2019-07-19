package com.viber.voip.util.links;

import com.viber.liblinkparser.LinkParser.Preview;
import com.viber.voip.util.az;
import com.viber.voip.util.da;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class c
{
  private final az a;
  private final d b;
  private final List<b> c;

  public c(az paramaz, d paramd)
  {
    this.a = paramaz;
    this.b = paramd;
    this.c = new LinkedList();
  }

  private List<b> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList(1);
    while (true)
    {
      ListIterator localListIterator;
      b localb;
      synchronized (this.c)
      {
        localListIterator = this.c.listIterator();
        if (!localListIterator.hasNext())
          break;
        localb = (b)localListIterator.next();
        if (localb.c() == null)
          localListIterator.remove();
      }
      if (paramString.equalsIgnoreCase(localb.a()))
      {
        localArrayList.add(localb);
        localListIterator.remove();
      }
    }
    return localArrayList;
  }

  private void a(final b paramb, final LinkParser.Preview paramPreview)
  {
    this.a.b(new Runnable()
    {
      public void run()
      {
        c.c localc = paramb.c();
        if (localc != null)
          localc.a(paramb.a(), paramb.b(), paramPreview);
      }
    });
  }

  public void a(String paramString, long paramLong, c paramc)
  {
    if (da.a(paramString))
    {
      a(new b(paramLong, paramc, null), null);
      return;
    }
    while (true)
    {
      synchronized (this.c)
      {
        Iterator localIterator = this.c.iterator();
        if (localIterator.hasNext())
        {
          if (!paramString.equalsIgnoreCase(((b)localIterator.next()).a()))
            continue;
          i = 0;
          this.c.add(new b(paramString, paramLong, paramc, null));
          if (i == 0)
            break;
          this.a.a(new a(paramString, null));
          return;
        }
      }
      int i = 1;
    }
  }

  class a
    implements Runnable
  {
    private final String b;

    private a(String arg2)
    {
      Object localObject;
      this.b = localObject;
    }

    public void run()
    {
      LinkParser.Preview localPreview = c.a(c.this).a(this.b);
      Iterator localIterator = c.a(c.this, this.b).iterator();
      while (localIterator.hasNext())
      {
        c.b localb = (c.b)localIterator.next();
        c.a(c.this, localb, localPreview);
      }
    }
  }

  private static class b
  {
    private final String a;
    private final long b;
    private final WeakReference<c.c> c;

    private b(long paramLong, c.c paramc)
    {
      this("", paramLong, paramc);
    }

    private b(String paramString, long paramLong, c.c paramc)
    {
      this.a = paramString;
      this.b = paramLong;
      this.c = new WeakReference(paramc);
    }

    public String a()
    {
      return this.a;
    }

    public long b()
    {
      return this.b;
    }

    public c.c c()
    {
      return (c.c)this.c.get();
    }
  }

  public static abstract interface c
  {
    public abstract void a(String paramString, long paramLong, LinkParser.Preview paramPreview);
  }

  public static abstract interface d
  {
    public abstract LinkParser.Preview a(String paramString);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.links.c
 * JD-Core Version:    0.6.2
 */