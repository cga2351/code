package c.a.a.a.a.c;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

public class j
  implements b<l>, i, l
{
  private final List<l> a = new ArrayList();
  private final AtomicBoolean b = new AtomicBoolean(false);
  private final AtomicReference<Throwable> c = new AtomicReference(null);

  public static boolean a(Object paramObject)
  {
    try
    {
      b localb = (b)paramObject;
      l locall = (l)paramObject;
      i locali = (i)paramObject;
      return (localb != null) && (locall != null) && (locali != null);
    }
    catch (ClassCastException localClassCastException)
    {
    }
    return false;
  }

  public void a(l paraml)
  {
    try
    {
      this.a.add(paraml);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public void a(Throwable paramThrowable)
  {
    this.c.set(paramThrowable);
  }

  public e b()
  {
    return e.b;
  }

  public void b(boolean paramBoolean)
  {
    try
    {
      this.b.set(paramBoolean);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public Collection<l> c()
  {
    try
    {
      Collection localCollection = Collections.unmodifiableCollection(this.a);
      return localCollection;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  public int compareTo(Object paramObject)
  {
    return e.a(this, paramObject);
  }

  public boolean d()
  {
    Iterator localIterator = c().iterator();
    while (localIterator.hasNext())
      if (!((l)localIterator.next()).f())
        return false;
    return true;
  }

  public boolean f()
  {
    return this.b.get();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     c.a.a.a.a.c.j
 * JD-Core Version:    0.6.2
 */