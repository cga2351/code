package com.my.target;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class q
{
  private final Set<p> a = new HashSet();
  private final Set<o> b = new HashSet();
  private final ArrayList<n> c = new ArrayList();
  private final ArrayList<m> d = new ArrayList();

  public static q a()
  {
    return new q();
  }

  public ArrayList<p> a(String paramString)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.a.iterator();
    while (localIterator.hasNext())
    {
      p localp = (p)localIterator.next();
      if (paramString.equals(localp.c()))
        localArrayList.add(localp);
    }
    return localArrayList;
  }

  public void a(p paramp)
  {
    if ((paramp instanceof o))
    {
      this.b.add((o)paramp);
      return;
    }
    if ((paramp instanceof n))
    {
      n localn = (n)paramp;
      if (this.c.isEmpty())
      {
        this.c.add(localn);
        return;
      }
      for (int i = this.c.size(); (i > 0) && (((n)this.c.get(i - 1)).e() < localn.e()); i--);
      this.c.add(i, localn);
      return;
    }
    if ((paramp instanceof m))
    {
      this.d.add((m)paramp);
      return;
    }
    this.a.add(paramp);
  }

  public void a(q paramq, float paramFloat)
  {
    this.a.addAll(paramq.e());
    this.d.addAll(paramq.c());
    if (paramFloat <= 0.0F)
    {
      this.b.addAll(paramq.d());
      this.c.addAll(paramq.b());
    }
    while (true)
    {
      return;
      Iterator localIterator1 = paramq.d().iterator();
      while (localIterator1.hasNext())
      {
        o localo = (o)localIterator1.next();
        float f2 = localo.b();
        if (f2 >= 0.0F)
        {
          localo.a(f2 * paramFloat / 100.0F);
          localo.b(-1.0F);
        }
        a(localo);
      }
      Iterator localIterator2 = paramq.b().iterator();
      while (localIterator2.hasNext())
      {
        n localn = (n)localIterator2.next();
        float f1 = localn.f();
        if (f1 >= 0.0F)
        {
          localn.c(f1 * paramFloat / 100.0F);
          localn.d(-1.0F);
        }
        a(localn);
      }
    }
  }

  public void a(ArrayList<p> paramArrayList)
  {
    this.a.addAll(paramArrayList);
  }

  public ArrayList<n> b()
  {
    return new ArrayList(this.c);
  }

  public void b(ArrayList<o> paramArrayList)
  {
    this.b.addAll(paramArrayList);
  }

  public ArrayList<m> c()
  {
    return new ArrayList(this.d);
  }

  public Set<o> d()
  {
    return new HashSet(this.b);
  }

  public Set<p> e()
  {
    return new HashSet(this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.q
 * JD-Core Version:    0.6.2
 */