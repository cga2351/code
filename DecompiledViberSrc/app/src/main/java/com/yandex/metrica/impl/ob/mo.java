package com.yandex.metrica.impl.ob;

import com.yandex.metrica.impl.bs;
import com.yandex.metrica.impl.bw;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class mo
{
  private final or<String, mt> a = new or();
  private final HashMap<String, mx> b = new HashMap();
  private final mv c = new mv()
  {
    public List<mt> a(String paramAnonymousString)
    {
      synchronized (mo.a(mo.this))
      {
        Collection localCollection = mo.b(mo.this).a(paramAnonymousString);
        if (localCollection == null)
        {
          ArrayList localArrayList1 = new ArrayList();
          return localArrayList1;
        }
        ArrayList localArrayList2 = new ArrayList(localCollection);
        return localArrayList2;
      }
    }

    public void a(String paramAnonymousString, mq paramAnonymousmq)
    {
      Iterator localIterator = a(paramAnonymousString).iterator();
      while (localIterator.hasNext())
        ((mt)localIterator.next()).a(paramAnonymousmq);
    }

    public void a(String paramAnonymousString, mw paramAnonymousmw)
    {
      Iterator localIterator = a(paramAnonymousString).iterator();
      while (localIterator.hasNext())
        ((mt)localIterator.next()).a(paramAnonymousmw);
    }
  };

  public static final mo a()
  {
    return a.a;
  }

  public bs a(af paramaf, t paramt)
  {
    return b(paramaf, paramt).a();
  }

  public void a(af paramaf)
  {
    synchronized (this.b)
    {
      Collection localCollection = this.a.b(paramaf.b().b(), paramaf.e());
      if (bw.a(localCollection))
        this.b.remove(paramaf.b().b());
      return;
    }
  }

  mx b(af paramaf, t paramt)
  {
    mx localmx1 = (mx)this.b.get(paramaf.b().b());
    if (localmx1 == null);
    while (true)
    {
      mx localmx3;
      synchronized (this.b)
      {
        localmx3 = (mx)this.b.get(paramaf.b().b());
        if (localmx3 == null)
        {
          i = 0;
          localmx2 = c(paramaf, paramt);
          this.b.put(paramaf.b().b(), localmx2);
          if (i != 0)
            localmx2.a(paramt);
          return localmx2;
        }
      }
      mx localmx2 = localmx3;
      int i = 1;
      continue;
      localmx2 = localmx1;
      i = 1;
    }
  }

  mx c(af paramaf, t paramt)
  {
    return new mx(paramaf.c(), paramaf.b().b(), paramt, this.c);
  }

  public mx d(af paramaf, t paramt)
  {
    synchronized (this.b)
    {
      this.a.a(paramaf.b().b(), paramaf.e());
      mx localmx = b(paramaf, paramt);
      return localmx;
    }
  }

  private static final class a
  {
    static final mo a = new mo();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.metrica.impl.ob.mo
 * JD-Core Version:    0.6.2
 */