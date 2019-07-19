package androidx.work.impl.utils;

import android.os.Build.VERSION;
import android.text.TextUtils;
import androidx.work.c;
import androidx.work.e.a;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.j;
import androidx.work.impl.b.j.a;
import androidx.work.impl.b.k;
import androidx.work.impl.b.m;
import androidx.work.impl.b.n;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.e;
import androidx.work.impl.f;
import androidx.work.impl.workers.ConstraintTrackingWorker;
import androidx.work.l;
import androidx.work.l.a.a;
import androidx.work.o.a;
import androidx.work.q;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class b
  implements Runnable
{
  private static final String a = i.a("EnqueueRunnable");
  private final f b;
  private final androidx.work.impl.b c;

  public b(f paramf)
  {
    this.b = paramf;
    this.c = new androidx.work.impl.b();
  }

  private static void a(j paramj)
  {
    c localc = paramj.j;
    if ((localc.d()) || (localc.e()))
    {
      String str = paramj.c;
      e.a locala = new e.a();
      locala.a(paramj.e).a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME", str);
      paramj.c = ConstraintTrackingWorker.class.getName();
      paramj.e = locala.a();
    }
  }

  private static boolean a(f paramf)
  {
    List localList = paramf.h();
    boolean bool1;
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      bool1 = false;
      if (localIterator.hasNext())
      {
        f localf = (f)localIterator.next();
        if (!localf.f());
        for (boolean bool2 = bool1 | a(localf); ; bool2 = bool1)
        {
          bool1 = bool2;
          break;
          i locali = i.a();
          String str = a;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = TextUtils.join(", ", localf.e());
          locali.d(str, String.format("Already enqueued work ids (%s).", arrayOfObject), new Throwable[0]);
        }
      }
    }
    else
    {
      bool1 = false;
    }
    return bool1 | b(paramf);
  }

  private static boolean a(androidx.work.impl.h paramh, List<? extends q> paramList, String[] paramArrayOfString, String paramString, androidx.work.g paramg)
  {
    long l = System.currentTimeMillis();
    WorkDatabase localWorkDatabase = paramh.d();
    if ((paramArrayOfString != null) && (paramArrayOfString.length > 0));
    int j;
    int k;
    int i11;
    int m;
    j localj2;
    boolean bool3;
    for (int i = 1; ; i = 0)
    {
      j = 0;
      k = 0;
      if (i == 0)
        break label197;
      int i10 = paramArrayOfString.length;
      i11 = 0;
      m = 1;
      if (i11 >= i10)
        break label200;
      String str3 = paramArrayOfString[i11];
      localj2 = localWorkDatabase.m().b(str3);
      if (localj2 != null)
        break;
      i.a().e(a, String.format("Prerequisite %s doesn't exist; not enqueuing", new Object[] { str3 }), new Throwable[0]);
      bool3 = false;
      return bool3;
    }
    o.a locala3 = localj2.b;
    int i12;
    label133: int i14;
    int i13;
    if (locala3 == o.a.c)
    {
      i12 = 1;
      m &= i12;
      if (locala3 != o.a.d)
        break label179;
      int i15 = k;
      i14 = 1;
      i13 = i15;
    }
    label294: 
    while (true)
    {
      i11++;
      j = i14;
      k = i13;
      break;
      i12 = 0;
      break label133;
      label179: if (locala3 == o.a.f)
      {
        i13 = 1;
        i14 = j;
        continue;
        label197: m = 1;
        label200: int n;
        int i1;
        label223: boolean bool1;
        List localList;
        ArrayList localArrayList;
        j.a locala2;
        int i9;
        if (!TextUtils.isEmpty(paramString))
        {
          n = 1;
          if ((n == 0) || (i != 0))
            break label388;
          i1 = 1;
          bool1 = false;
          if (i1 == 0)
            break label926;
          localList = localWorkDatabase.m().c(paramString);
          boolean bool5 = localList.isEmpty();
          bool1 = false;
          if (bool5)
            break label926;
          if (paramg != androidx.work.g.c)
            break label637;
          androidx.work.impl.b.b localb = localWorkDatabase.n();
          localArrayList = new ArrayList();
          Iterator localIterator5 = localList.iterator();
          do
          {
            if (!localIterator5.hasNext())
              break;
            locala2 = (j.a)localIterator5.next();
          }
          while (localb.c(locala2.a));
          if (locala2.b != o.a.c)
            break label394;
          i9 = 1;
          label345: m &= i9;
          if (locala2.b != o.a.d)
            break label400;
          j = 1;
        }
        while (true)
        {
          localArrayList.add(locala2.a);
          break label294;
          n = 0;
          break;
          i1 = 0;
          break label223;
          i9 = 0;
          break label345;
          if (locala2.b == o.a.f)
            k = 1;
        }
        String[] arrayOfString = (String[])localArrayList.toArray(paramArrayOfString);
        int i8;
        boolean bool2;
        int i2;
        int i3;
        int i4;
        if (arrayOfString.length > 0)
        {
          i8 = 1;
          paramArrayOfString = arrayOfString;
          bool2 = false;
          i2 = i8;
          i3 = m;
          i4 = j;
        }
        for (int i5 = k; ; i5 = k)
        {
          Iterator localIterator1 = paramList.iterator();
          bool3 = bool2;
          label473: q localq;
          j localj1;
          if (localIterator1.hasNext())
          {
            localq = (q)localIterator1.next();
            localj1 = localq.b();
            if ((i2 != 0) && (i3 == 0))
              if (i4 != 0)
              {
                localj1.b = o.a.d;
                if ((Build.VERSION.SDK_INT >= 23) && (Build.VERSION.SDK_INT <= 25))
                  a(localj1);
                if (localj1.b != o.a.a)
                  break label919;
              }
          }
          for (boolean bool4 = true; ; bool4 = bool3)
          {
            localWorkDatabase.m().a(localj1);
            if (i2 != 0)
            {
              int i6 = paramArrayOfString.length;
              int i7 = 0;
              while (true)
                if (i7 < i6)
                {
                  String str2 = paramArrayOfString[i7];
                  androidx.work.impl.b.a locala = new androidx.work.impl.b.a(localq.a(), str2);
                  localWorkDatabase.n().a(locala);
                  i7++;
                  continue;
                  i8 = 0;
                  break;
                  label637: if (paramg == androidx.work.g.b)
                  {
                    Iterator localIterator4 = localList.iterator();
                    while (localIterator4.hasNext())
                    {
                      j.a locala1 = (j.a)localIterator4.next();
                      if ((locala1.b == o.a.a) || (locala1.b == o.a.b))
                        return false;
                    }
                  }
                  a.a(paramString, paramh, false).run();
                  bool1 = true;
                  k localk = localWorkDatabase.m();
                  Iterator localIterator3 = localList.iterator();
                  while (localIterator3.hasNext())
                    localk.a(((j.a)localIterator3.next()).a);
                  if (i5 != 0)
                  {
                    localj1.b = o.a.f;
                    break label525;
                  }
                  localj1.b = o.a.e;
                  break label525;
                  if (!localj1.a())
                  {
                    localj1.n = l;
                    break label525;
                  }
                  localj1.n = 0L;
                  break label525;
                }
            }
            Iterator localIterator2 = localq.c().iterator();
            while (localIterator2.hasNext())
            {
              String str1 = (String)localIterator2.next();
              n localn = localWorkDatabase.o();
              m localm = new m(str1, localq.a());
              localn.a(localm);
            }
            if (n != 0)
              localWorkDatabase.q().a(new androidx.work.impl.b.g(paramString, localq.a()));
            bool3 = bool4;
            break label473;
            break;
          }
          bool2 = bool1;
          i2 = i;
          i3 = m;
          i4 = j;
        }
      }
      else
      {
        i13 = k;
        i14 = j;
      }
    }
  }

  private static boolean b(f paramf)
  {
    Set localSet = f.a(paramf);
    boolean bool = a(paramf.a(), paramf.d(), (String[])localSet.toArray(new String[0]), paramf.b(), paramf.c());
    paramf.g();
    return bool;
  }

  public l a()
  {
    return this.c;
  }

  public boolean b()
  {
    WorkDatabase localWorkDatabase = this.b.a().d();
    localWorkDatabase.f();
    try
    {
      boolean bool = a(this.b);
      localWorkDatabase.h();
      return bool;
    }
    finally
    {
      localWorkDatabase.g();
    }
  }

  public void c()
  {
    androidx.work.impl.h localh = this.b.a();
    e.a(localh.e(), localh.d(), localh.f());
  }

  public void run()
  {
    try
    {
      if (this.b.j())
      {
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = this.b;
        throw new IllegalStateException(String.format("WorkContinuation has cycles (%s)", arrayOfObject));
      }
    }
    catch (Throwable localThrowable)
    {
      this.c.a(new l.a.a(localThrowable));
      return;
    }
    if (b())
    {
      d.a(this.b.a().c(), RescheduleReceiver.class, true);
      c();
    }
    this.c.a(l.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.utils.b
 * JD-Core Version:    0.6.2
 */