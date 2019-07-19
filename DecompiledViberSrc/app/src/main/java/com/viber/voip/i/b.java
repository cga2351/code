package com.viber.voip.i;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public abstract class b
  implements d
{
  private final Set<d.a> a = new HashSet(1);

  public void a(d.a parama)
  {
    synchronized (this.a)
    {
      this.a.add(parama);
      return;
    }
  }

  protected void b()
  {
    synchronized (this.a)
    {
      ArrayList localArrayList = new ArrayList(this.a);
      Iterator localIterator = localArrayList.iterator();
      if (localIterator.hasNext())
        ((d.a)localIterator.next()).b();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.i.b
 * JD-Core Version:    0.6.2
 */