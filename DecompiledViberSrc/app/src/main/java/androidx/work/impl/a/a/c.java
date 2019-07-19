package androidx.work.impl.a.a;

import androidx.work.impl.a.a;
import androidx.work.impl.a.b.d;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class c<T>
  implements a<T>
{
  private final List<String> a = new ArrayList();
  private T b;
  private d<T> c;
  private a d;

  c(d<T> paramd)
  {
    this.c = paramd;
  }

  private void b()
  {
    if ((this.a.isEmpty()) || (this.d == null))
      return;
    if ((this.b == null) || (b(this.b)))
    {
      this.d.c(this.a);
      return;
    }
    this.d.b(this.a);
  }

  public void a()
  {
    if (!this.a.isEmpty())
    {
      this.a.clear();
      this.c.b(this);
    }
  }

  public void a(a parama)
  {
    if (this.d != parama)
    {
      this.d = parama;
      b();
    }
  }

  public void a(T paramT)
  {
    this.b = paramT;
    b();
  }

  public void a(List<j> paramList)
  {
    this.a.clear();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      j localj = (j)localIterator.next();
      if (a(localj))
        this.a.add(localj.a);
    }
    if (this.a.isEmpty())
      this.c.b(this);
    while (true)
    {
      b();
      return;
      this.c.a(this);
    }
  }

  abstract boolean a(j paramj);

  public boolean a(String paramString)
  {
    return (this.b != null) && (b(this.b)) && (this.a.contains(paramString));
  }

  abstract boolean b(T paramT);

  public static abstract interface a
  {
    public abstract void b(List<String> paramList);

    public abstract void c(List<String> paramList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.a.c
 * JD-Core Version:    0.6.2
 */