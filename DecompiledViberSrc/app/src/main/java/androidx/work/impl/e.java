package androidx.work.impl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.i;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.background.systemalarm.SystemAlarmService;
import androidx.work.impl.background.systemalarm.f;
import androidx.work.impl.background.systemjob.SystemJobService;
import java.util.Iterator;
import java.util.List;

public class e
{
  private static final String a = i.a("Schedulers");

  @SuppressLint({"NewApi"})
  static d a(Context paramContext, h paramh)
  {
    boolean bool = false;
    androidx.work.impl.background.systemjob.b localb;
    if (Build.VERSION.SDK_INT >= 23)
    {
      localb = new androidx.work.impl.background.systemjob.b(paramContext, paramh);
      androidx.work.impl.utils.d.a(paramContext, SystemJobService.class, true);
      i.a().b(a, "Created SystemJobScheduler and enabled SystemJobService", new Throwable[0]);
    }
    f localf;
    for (Object localObject = localb; ; localObject = localf)
    {
      androidx.work.impl.utils.d.a(paramContext, SystemAlarmService.class, bool);
      return localObject;
      localf = new f(paramContext);
      i.a().b(a, "Created SystemAlarmScheduler", new Throwable[0]);
      bool = true;
    }
  }

  public static void a(androidx.work.b paramb, WorkDatabase paramWorkDatabase, List<d> paramList)
  {
    if ((paramList == null) || (paramList.size() == 0));
    while (true)
    {
      return;
      k localk = paramWorkDatabase.m();
      paramWorkDatabase.f();
      List localList;
      try
      {
        localList = localk.a(paramb.f());
        if ((localList != null) && (localList.size() > 0))
        {
          long l = System.currentTimeMillis();
          Iterator localIterator2 = localList.iterator();
          while (localIterator2.hasNext())
            localk.b(((j)localIterator2.next()).a, l);
        }
      }
      finally
      {
        paramWorkDatabase.g();
      }
      paramWorkDatabase.h();
      paramWorkDatabase.g();
      if ((localList != null) && (localList.size() > 0))
      {
        j[] arrayOfj = (j[])localList.toArray(new j[0]);
        Iterator localIterator1 = paramList.iterator();
        while (localIterator1.hasNext())
          ((d)localIterator1.next()).a(arrayOfj);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.e
 * JD-Core Version:    0.6.2
 */