package com.viber.voip.storage;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class c
{
  private List<a> a = new ArrayList();

  public void a()
  {
    Iterator localIterator = new ArrayList(this.a).iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).g();
  }

  public void a(a parama)
  {
    if (!this.a.contains(parama))
      this.a.add(parama);
  }

  public void b()
  {
    Iterator localIterator = new ArrayList(this.a).iterator();
    while (localIterator.hasNext())
      ((a)localIterator.next()).o();
  }

  public void b(a parama)
  {
    this.a.remove(parama);
  }

  public static abstract interface a
  {
    public abstract void g();

    public abstract void o();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.storage.c
 * JD-Core Version:    0.6.2
 */