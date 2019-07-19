package androidx.work.impl;

import android.text.TextUtils;
import androidx.work.g;
import androidx.work.i;
import androidx.work.impl.utils.b;
import androidx.work.impl.utils.b.a;
import androidx.work.l;
import androidx.work.n;
import androidx.work.q;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class f extends n
{
  private static final String a = i.a("WorkContinuationImpl");
  private final h b;
  private final String c;
  private final g d;
  private final List<? extends q> e;
  private final List<String> f;
  private final List<String> g;
  private final List<f> h;
  private boolean i;
  private l j;

  f(h paramh, String paramString, g paramg, List<? extends q> paramList)
  {
    this(paramh, paramString, paramg, paramList, null);
  }

  f(h paramh, String paramString, g paramg, List<? extends q> paramList, List<f> paramList1)
  {
    this.b = paramh;
    this.c = paramString;
    this.d = paramg;
    this.e = paramList;
    this.h = paramList1;
    this.f = new ArrayList(this.e.size());
    this.g = new ArrayList();
    if (paramList1 != null)
    {
      Iterator localIterator = paramList1.iterator();
      while (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        this.g.addAll(localf.g);
      }
    }
    for (int k = 0; k < paramList.size(); k++)
    {
      String str = ((q)paramList.get(k)).a();
      this.f.add(str);
      this.g.add(str);
    }
  }

  public static Set<String> a(f paramf)
  {
    HashSet localHashSet = new HashSet();
    List localList = paramf.h();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
        localHashSet.addAll(((f)localIterator.next()).e());
    }
    return localHashSet;
  }

  private static boolean a(f paramf, Set<String> paramSet)
  {
    paramSet.addAll(paramf.e());
    Set localSet = a(paramf);
    Iterator localIterator1 = paramSet.iterator();
    while (localIterator1.hasNext())
      if (localSet.contains((String)localIterator1.next()))
        return true;
    List localList = paramf.h();
    if ((localList != null) && (!localList.isEmpty()))
    {
      Iterator localIterator2 = localList.iterator();
      while (localIterator2.hasNext())
        if (a((f)localIterator2.next(), paramSet))
          return true;
    }
    paramSet.removeAll(paramf.e());
    return false;
  }

  public h a()
  {
    return this.b;
  }

  public String b()
  {
    return this.c;
  }

  public g c()
  {
    return this.d;
  }

  public List<? extends q> d()
  {
    return this.e;
  }

  public List<String> e()
  {
    return this.f;
  }

  public boolean f()
  {
    return this.i;
  }

  public void g()
  {
    this.i = true;
  }

  public List<f> h()
  {
    return this.h;
  }

  public l i()
  {
    if (!this.i)
    {
      b localb = new b(this);
      this.b.h().a(localb);
      this.j = localb.a();
    }
    while (true)
    {
      return this.j;
      i locali = i.a();
      String str = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = TextUtils.join(", ", this.f);
      locali.d(str, String.format("Already enqueued work ids (%s)", arrayOfObject), new Throwable[0]);
    }
  }

  public boolean j()
  {
    return a(this, new HashSet());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.f
 * JD-Core Version:    0.6.2
 */