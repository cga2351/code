package androidx.work.impl.background.systemjob;

import android.app.job.JobInfo;
import android.app.job.JobScheduler;
import android.content.Context;
import android.os.Build.VERSION;
import android.os.PersistableBundle;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.b.e;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import androidx.work.impl.utils.c;
import androidx.work.o.a;
import java.util.Iterator;
import java.util.List;

public class b
  implements androidx.work.impl.d
{
  private static final String a = i.a("SystemJobScheduler");
  private final JobScheduler b;
  private final h c;
  private final c d;
  private final a e;

  public b(Context paramContext, h paramh)
  {
    this(paramContext, paramh, (JobScheduler)paramContext.getSystemService("jobscheduler"), new a(paramContext));
  }

  public b(Context paramContext, h paramh, JobScheduler paramJobScheduler, a parama)
  {
    this.c = paramh;
    this.b = paramJobScheduler;
    this.d = new c(paramContext);
    this.e = parama;
  }

  private static JobInfo a(JobScheduler paramJobScheduler, String paramString)
  {
    List localList = paramJobScheduler.getAllPendingJobs();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        JobInfo localJobInfo = (JobInfo)localIterator.next();
        PersistableBundle localPersistableBundle = localJobInfo.getExtras();
        if ((localPersistableBundle != null) && (localPersistableBundle.containsKey("EXTRA_WORK_SPEC_ID")) && (paramString.equals(localPersistableBundle.getString("EXTRA_WORK_SPEC_ID"))))
          return localJobInfo;
      }
    }
    return null;
  }

  public static void a(Context paramContext)
  {
    JobScheduler localJobScheduler = (JobScheduler)paramContext.getSystemService("jobscheduler");
    if (localJobScheduler != null)
    {
      List localList = localJobScheduler.getAllPendingJobs();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          JobInfo localJobInfo = (JobInfo)localIterator.next();
          if (localJobInfo.getExtras().containsKey("EXTRA_WORK_SPEC_ID"))
            localJobScheduler.cancel(localJobInfo.getId());
        }
      }
    }
  }

  public void a(j paramj, int paramInt)
  {
    JobInfo localJobInfo = this.e.a(paramj, paramInt);
    i locali = i.a();
    String str = a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramj.a;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    locali.b(str, String.format("Scheduling work ID %s Job ID %s", arrayOfObject), new Throwable[0]);
    this.b.schedule(localJobInfo);
  }

  public void a(String paramString)
  {
    List localList = this.b.getAllPendingJobs();
    if (localList != null)
    {
      Iterator localIterator = localList.iterator();
      do
      {
        JobInfo localJobInfo;
        do
        {
          if (!localIterator.hasNext())
            break;
          localJobInfo = (JobInfo)localIterator.next();
        }
        while (!paramString.equals(localJobInfo.getExtras().getString("EXTRA_WORK_SPEC_ID")));
        this.c.d().p().b(paramString);
        this.b.cancel(localJobInfo.getId());
      }
      while (Build.VERSION.SDK_INT == 23);
    }
  }

  public void a(j[] paramArrayOfj)
  {
    WorkDatabase localWorkDatabase = this.c.d();
    int i = paramArrayOfj.length;
    int j = 0;
    while (j < i)
    {
      j localj1 = paramArrayOfj[j];
      localWorkDatabase.f();
      try
      {
        j localj2 = localWorkDatabase.m().b(localj1.a);
        if (localj2 == null)
        {
          i.a().d(a, "Skipping scheduling " + localj1.a + " because it's no longer in the DB", new Throwable[0]);
          localWorkDatabase.g();
        }
        androidx.work.impl.b.d locald1;
        while (true)
        {
          j++;
          break;
          if (localj2.b != o.a.a)
          {
            i.a().d(a, "Skipping scheduling " + localj1.a + " because it is no longer enqueued", new Throwable[0]);
            localWorkDatabase.g();
          }
          else
          {
            locald1 = localWorkDatabase.p().a(localj1.a);
            if ((locald1 == null) || (a(this.b, localj1.a) == null))
              break label247;
            i locali = i.a();
            String str = a;
            Object[] arrayOfObject = new Object[1];
            arrayOfObject[0] = localj1.a;
            locali.b(str, String.format("Skipping scheduling %s because JobScheduler is aware of it already.", arrayOfObject), new Throwable[0]);
            localWorkDatabase.g();
          }
        }
        label247: if (locald1 != null);
        int k;
        for (int m = locald1.b; ; m = k)
        {
          if (locald1 == null)
          {
            androidx.work.impl.b.d locald2 = new androidx.work.impl.b.d(localj1.a, m);
            this.c.d().p().a(locald2);
          }
          a(localj1, m);
          if (Build.VERSION.SDK_INT == 23)
            a(localj1, this.d.a(this.c.e().d(), this.c.e().e()));
          localWorkDatabase.h();
          localWorkDatabase.g();
          break;
          k = this.d.a(this.c.e().d(), this.c.e().e());
        }
      }
      finally
      {
        localWorkDatabase.g();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemjob.b
 * JD-Core Version:    0.6.2
 */