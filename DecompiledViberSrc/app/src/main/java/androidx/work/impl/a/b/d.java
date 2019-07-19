package androidx.work.impl.a.b;

import android.content.Context;
import androidx.work.i;
import androidx.work.impl.a.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public abstract class d<T>
{
  private static final String b = i.a("ConstraintTracker");
  protected final Context a;
  private final Object c = new Object();
  private final Set<a<T>> d = new LinkedHashSet();
  private T e;

  d(Context paramContext)
  {
    this.a = paramContext.getApplicationContext();
  }

  public void a(a<T> parama)
  {
    synchronized (this.c)
    {
      if (this.d.add(parama))
      {
        if (this.d.size() == 1)
        {
          this.e = c();
          i locali = i.a();
          String str = b;
          Object[] arrayOfObject = new Object[2];
          arrayOfObject[0] = getClass().getSimpleName();
          arrayOfObject[1] = this.e;
          locali.b(str, String.format("%s: initial state = %s", arrayOfObject), new Throwable[0]);
          d();
        }
        parama.a(this.e);
      }
      return;
    }
  }

  public void a(T paramT)
  {
    synchronized (this.c)
    {
      if ((this.e == paramT) || ((this.e != null) && (this.e.equals(paramT))))
        return;
      this.e = paramT;
      Iterator localIterator = new ArrayList(this.d).iterator();
      if (localIterator.hasNext())
        ((a)localIterator.next()).a(this.e);
    }
  }

  public void b(a<T> parama)
  {
    synchronized (this.c)
    {
      if ((this.d.remove(parama)) && (this.d.isEmpty()))
        e();
      return;
    }
  }

  public abstract T c();

  public abstract void d();

  public abstract void e();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.b.d
 * JD-Core Version:    0.6.2
 */