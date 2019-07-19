package androidx.work.impl.utils;

import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.k;
import androidx.work.impl.c;
import androidx.work.impl.d;
import androidx.work.impl.e;
import androidx.work.impl.h;
import androidx.work.l;
import androidx.work.l.a.a;
import androidx.work.o.a;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public abstract class a
  implements Runnable
{
  private final androidx.work.impl.b a = new androidx.work.impl.b();

  public static a a(final String paramString, h paramh)
  {
    return new a()
    {
      void b()
      {
        WorkDatabase localWorkDatabase = this.a.d();
        localWorkDatabase.f();
        try
        {
          Iterator localIterator = localWorkDatabase.m().i(paramString).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            a(this.a, str);
          }
        }
        finally
        {
          localWorkDatabase.g();
        }
        localWorkDatabase.h();
        localWorkDatabase.g();
        a(this.a);
      }
    };
  }

  public static a a(final String paramString, h paramh, final boolean paramBoolean)
  {
    return new a()
    {
      void b()
      {
        WorkDatabase localWorkDatabase = this.a.d();
        localWorkDatabase.f();
        try
        {
          Iterator localIterator = localWorkDatabase.m().j(paramString).iterator();
          while (localIterator.hasNext())
          {
            String str = (String)localIterator.next();
            a(this.a, str);
          }
        }
        finally
        {
          localWorkDatabase.g();
        }
        localWorkDatabase.h();
        localWorkDatabase.g();
        if (paramBoolean)
          a(this.a);
      }
    };
  }

  private void a(WorkDatabase paramWorkDatabase, String paramString)
  {
    k localk = paramWorkDatabase.m();
    androidx.work.impl.b.b localb = paramWorkDatabase.n();
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    while (!localLinkedList.isEmpty())
    {
      String str = (String)localLinkedList.remove();
      o.a locala = localk.f(str);
      if ((locala != o.a.c) && (locala != o.a.d))
        localk.a(o.a.f, new String[] { str });
      localLinkedList.addAll(localb.b(str));
    }
  }

  public l a()
  {
    return this.a;
  }

  void a(h paramh)
  {
    e.a(paramh.e(), paramh.d(), paramh.f());
  }

  void a(h paramh, String paramString)
  {
    a(paramh.d(), paramString);
    paramh.g().c(paramString);
    Iterator localIterator = paramh.f().iterator();
    while (localIterator.hasNext())
      ((d)localIterator.next()).a(paramString);
  }

  abstract void b();

  public void run()
  {
    try
    {
      b();
      this.a.a(l.a);
      return;
    }
    catch (Throwable localThrowable)
    {
      this.a.a(new l.a.a(localThrowable));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.a
 * JD-Core Version:    0.6.2
 */