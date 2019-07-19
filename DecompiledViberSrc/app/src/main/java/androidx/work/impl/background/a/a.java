package androidx.work.impl.background.a;

import android.content.Context;
import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.i;
import androidx.work.impl.b.j;
import androidx.work.impl.h;
import androidx.work.o.a;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class a
  implements androidx.work.impl.a, androidx.work.impl.a.c, androidx.work.impl.d
{
  private static final String a = i.a("GreedyScheduler");
  private h b;
  private androidx.work.impl.a.d c;
  private List<j> d = new ArrayList();
  private boolean e;
  private final Object f;

  public a(Context paramContext, h paramh)
  {
    this.b = paramh;
    this.c = new androidx.work.impl.a.d(paramContext, this);
    this.f = new Object();
  }

  private void a()
  {
    if (!this.e)
    {
      this.b.g().a(this);
      this.e = true;
    }
  }

  private void b(String paramString)
  {
    while (true)
    {
      int j;
      synchronized (this.f)
      {
        int i = this.d.size();
        j = 0;
        if (j < i)
        {
          if (((j)this.d.get(j)).a.equals(paramString))
          {
            i.a().b(a, String.format("Stopping tracking for %s", new Object[] { paramString }), new Throwable[0]);
            this.d.remove(j);
            this.c.a(this.d);
          }
        }
        else
          return;
      }
      j++;
    }
  }

  public void a(String paramString)
  {
    a();
    i.a().b(a, String.format("Cancelling work ID %s", new Object[] { paramString }), new Throwable[0]);
    this.b.d(paramString);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    b(paramString);
  }

  public void a(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      i.a().b(a, String.format("Constraints met: Scheduling work ID %s", new Object[] { str }), new Throwable[0]);
      this.b.c(str);
    }
  }

  public void a(j[] paramArrayOfj)
  {
    a();
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    int i = paramArrayOfj.length;
    int j = 0;
    if (j < i)
    {
      j localj = paramArrayOfj[j];
      if ((localj.b == o.a.a) && (!localj.a()) && (localj.g == 0L) && (!localj.b()))
      {
        if (!localj.d())
          break label131;
        if ((Build.VERSION.SDK_INT < 24) || (!localj.j.i()))
        {
          localArrayList1.add(localj);
          localArrayList2.add(localj.a);
        }
      }
      while (true)
      {
        j++;
        break;
        label131: i locali2 = i.a();
        String str2 = a;
        Object[] arrayOfObject2 = new Object[1];
        arrayOfObject2[0] = localj.a;
        locali2.b(str2, String.format("Starting work for %s", arrayOfObject2), new Throwable[0]);
        this.b.c(localj.a);
      }
    }
    synchronized (this.f)
    {
      if (!localArrayList1.isEmpty())
      {
        i locali1 = i.a();
        String str1 = a;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = TextUtils.join(",", localArrayList2);
        locali1.b(str1, String.format("Starting tracking for [%s]", arrayOfObject1), new Throwable[0]);
        this.d.addAll(localArrayList1);
        this.c.a(this.d);
      }
      return;
    }
  }

  public void b(List<String> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      i.a().b(a, String.format("Constraints not met: Cancelling work ID %s", new Object[] { str }), new Throwable[0]);
      this.b.d(str);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.a.a
 * JD-Core Version:    0.6.2
 */