package com.viber.voip.apps;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class g
  implements f
{
  private static volatile g a;
  private Set<f.a> b = new HashSet();
  private Set<f.c> c = new HashSet();
  private Set<f.b> d = new HashSet();

  public static g a()
  {
    if (a == null);
    try
    {
      if (a == null)
        a = new g();
      return a;
    }
    finally
    {
    }
  }

  private Set<f.a> b()
  {
    return new HashSet(this.b);
  }

  private Set<f.c> c()
  {
    return new HashSet(this.c);
  }

  private Set<f.b> d()
  {
    return new HashSet(this.d);
  }

  public void a(int paramInt)
  {
    Iterator localIterator = d().iterator();
    while (localIterator.hasNext())
      ((f.b)localIterator.next()).a(paramInt);
  }

  public void a(int paramInt1, int paramInt2, String paramString)
  {
    Iterator localIterator = b().iterator();
    while (localIterator.hasNext())
      ((f.a)localIterator.next()).a(paramInt1, paramInt2, paramString);
  }

  public void a(int paramInt, List<b> paramList, boolean paramBoolean)
  {
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext())
      ((f.c)localIterator.next()).a(paramInt, paramList, paramBoolean);
  }

  public void a(f.a parama)
  {
    this.b.add(parama);
  }

  public void b(f.a parama)
  {
    this.b.remove(parama);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.apps.g
 * JD-Core Version:    0.6.2
 */