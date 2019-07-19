package androidx.work.impl;

import android.arch.persistence.room.a.a;
import android.arch.persistence.room.d;
import android.arch.persistence.room.e.a;
import android.arch.persistence.room.e.b;
import android.content.Context;
import androidx.work.impl.b.h;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import java.util.concurrent.TimeUnit;

public abstract class WorkDatabase extends android.arch.persistence.room.e
{
  private static final long d = TimeUnit.DAYS.toMillis(7L);

  public static WorkDatabase a(Context paramContext, boolean paramBoolean)
  {
    if (paramBoolean);
    for (e.a locala1 = d.a(paramContext, WorkDatabase.class).a(); ; locala1 = d.a(paramContext, WorkDatabase.class, "androidx.work.workdb"))
    {
      e.a locala2 = locala1.a(j());
      a[] arrayOfa1 = new a[1];
      arrayOfa1[0] = g.a;
      e.a locala3 = locala2.a(arrayOfa1);
      a[] arrayOfa2 = new a[1];
      arrayOfa2[0] = new g.a(paramContext, 2, 3);
      e.a locala4 = locala3.a(arrayOfa2);
      a[] arrayOfa3 = new a[1];
      arrayOfa3[0] = g.b;
      e.a locala5 = locala4.a(arrayOfa3);
      a[] arrayOfa4 = new a[1];
      arrayOfa4[0] = g.c;
      return (WorkDatabase)locala5.a(arrayOfa4).b().c();
    }
  }

  static e.b j()
  {
    return new e.b()
    {
      public void b(android.arch.persistence.a.b paramAnonymousb)
      {
        super.b(paramAnonymousb);
        paramAnonymousb.a();
        try
        {
          paramAnonymousb.c("UPDATE workspec SET state=0, schedule_requested_at=-1 WHERE state=1");
          paramAnonymousb.c(WorkDatabase.k());
          paramAnonymousb.c();
          return;
        }
        finally
        {
          paramAnonymousb.b();
        }
      }
    };
  }

  static String k()
  {
    return "DELETE FROM workspec WHERE state IN (2, 3, 5) AND (period_start_time + minimum_retention_duration) < " + l() + " AND (SELECT COUNT(*)=0 FROM dependency WHERE     prerequisite_id=id AND     work_spec_id NOT IN         (SELECT id FROM workspec WHERE state IN (2, 3, 5)))";
  }

  static long l()
  {
    return System.currentTimeMillis() - d;
  }

  public abstract k m();

  public abstract androidx.work.impl.b.b n();

  public abstract n o();

  public abstract androidx.work.impl.b.e p();

  public abstract h q();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.WorkDatabase
 * JD-Core Version:    0.6.2
 */