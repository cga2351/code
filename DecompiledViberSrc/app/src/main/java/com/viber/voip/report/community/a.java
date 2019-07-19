package com.viber.voip.report.community;

import com.viber.voip.util.u;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import javax.inject.Inject;

public class a
{
  private final Set<a> a = new HashSet();

  public void a(long paramLong)
  {
    if (!u.a(this.a))
    {
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
        ((a)localIterator.next()).a(paramLong);
    }
  }

  public void a(a parama)
  {
    this.a.add(parama);
  }

  public void b(a parama)
  {
    this.a.remove(parama);
  }

  public static abstract interface a
  {
    public abstract void a(long paramLong);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.report.community.a
 * JD-Core Version:    0.6.2
 */