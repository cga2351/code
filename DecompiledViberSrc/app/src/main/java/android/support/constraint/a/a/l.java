package android.support.constraint.a.a;

import java.util.HashSet;
import java.util.Iterator;

public class l
{
  HashSet<l> h = new HashSet(2);
  int i = 0;

  public void a()
  {
  }

  public void a(l paraml)
  {
    this.h.add(paraml);
  }

  public void b()
  {
    this.i = 0;
    this.h.clear();
  }

  public void e()
  {
    this.i = 0;
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
      ((l)localIterator.next()).e();
  }

  public void f()
  {
    this.i = 1;
    Iterator localIterator = this.h.iterator();
    while (localIterator.hasNext())
      ((l)localIterator.next()).a();
  }

  public boolean g()
  {
    return this.i == 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.constraint.a.a.l
 * JD-Core Version:    0.6.2
 */