package androidx.work.impl.a;

import android.content.Context;
import androidx.work.i;
import androidx.work.impl.a.a.a;
import androidx.work.impl.a.a.b;
import androidx.work.impl.a.a.c.a;
import androidx.work.impl.a.a.e;
import androidx.work.impl.a.a.f;
import androidx.work.impl.a.a.g;
import androidx.work.impl.a.a.h;
import androidx.work.impl.b.j;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class d
  implements c.a
{
  private static final String a = i.a("WorkConstraintsTracker");
  private final c b;
  private final androidx.work.impl.a.a.c[] c;
  private final Object d;

  public d(Context paramContext, c paramc)
  {
    Context localContext = paramContext.getApplicationContext();
    this.b = paramc;
    androidx.work.impl.a.a.c[] arrayOfc = new androidx.work.impl.a.a.c[7];
    arrayOfc[0] = new a(localContext);
    arrayOfc[1] = new b(localContext);
    arrayOfc[2] = new h(localContext);
    arrayOfc[3] = new androidx.work.impl.a.a.d(localContext);
    arrayOfc[4] = new g(localContext);
    arrayOfc[5] = new f(localContext);
    arrayOfc[6] = new e(localContext);
    this.c = arrayOfc;
    this.d = new Object();
  }

  public void a()
  {
    synchronized (this.d)
    {
      androidx.work.impl.a.a.c[] arrayOfc = this.c;
      int i = arrayOfc.length;
      for (int j = 0; j < i; j++)
        arrayOfc[j].a();
      return;
    }
  }

  public void a(List<j> paramList)
  {
    int i = 0;
    synchronized (this.d)
    {
      androidx.work.impl.a.a.c[] arrayOfc1 = this.c;
      int j = arrayOfc1.length;
      for (int k = 0; k < j; k++)
        arrayOfc1[k].a(null);
      androidx.work.impl.a.a.c[] arrayOfc2 = this.c;
      int m = arrayOfc2.length;
      for (int n = 0; n < m; n++)
        arrayOfc2[n].a(paramList);
      androidx.work.impl.a.a.c[] arrayOfc3 = this.c;
      int i1 = arrayOfc3.length;
      while (i < i1)
      {
        arrayOfc3[i].a(this);
        i++;
      }
      return;
    }
  }

  public boolean a(String paramString)
  {
    while (true)
    {
      int j;
      synchronized (this.d)
      {
        androidx.work.impl.a.a.c[] arrayOfc = this.c;
        int i = arrayOfc.length;
        j = 0;
        if (j < i)
        {
          androidx.work.impl.a.a.c localc = arrayOfc[j];
          if (localc.a(paramString))
          {
            i locali = i.a();
            String str = a;
            Object[] arrayOfObject = new Object[2];
            arrayOfObject[0] = paramString;
            arrayOfObject[1] = localc.getClass().getSimpleName();
            locali.b(str, String.format("Work %s constrained by %s", arrayOfObject), new Throwable[0]);
            return false;
          }
        }
        else
        {
          return true;
        }
      }
      j++;
    }
  }

  public void b(List<String> paramList)
  {
    ArrayList localArrayList;
    synchronized (this.d)
    {
      localArrayList = new ArrayList();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if (a(str))
        {
          i.a().b(a, String.format("Constraints met for %s", new Object[] { str }), new Throwable[0]);
          localArrayList.add(str);
        }
      }
    }
    if (this.b != null)
      this.b.a(localArrayList);
  }

  public void c(List<String> paramList)
  {
    synchronized (this.d)
    {
      if (this.b != null)
        this.b.b(paramList);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.a.d
 * JD-Core Version:    0.6.2
 */