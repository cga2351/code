package androidx.work.impl.workers;

import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.a;
import androidx.work.WorkerParameters;
import androidx.work.e;
import androidx.work.i;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.a.d;
import androidx.work.impl.b.j;
import androidx.work.impl.b.k;
import androidx.work.impl.h;
import androidx.work.s;
import com.google.b.a.a.a;
import java.util.Collections;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public class ConstraintTrackingWorker extends ListenableWorker
  implements androidx.work.impl.a.c
{
  private static final String d = i.a("ConstraintTrkngWrkr");
  final Object a;
  volatile boolean b;
  androidx.work.impl.utils.a.c<ListenableWorker.a> c;
  private WorkerParameters e;
  private ListenableWorker f;

  public ConstraintTrackingWorker(Context paramContext, WorkerParameters paramWorkerParameters)
  {
    super(paramContext, paramWorkerParameters);
    this.e = paramWorkerParameters;
    this.a = new Object();
    this.b = false;
    this.c = androidx.work.impl.utils.a.c.d();
  }

  public void a(List<String> paramList)
  {
  }

  public void b(List<String> paramList)
  {
    i.a().b(d, String.format("Constraints changed for %s", new Object[] { paramList }), new Throwable[0]);
    synchronized (this.a)
    {
      this.b = true;
      return;
    }
  }

  public a<ListenableWorker.a> d()
  {
    i().execute(new Runnable()
    {
      public void run()
      {
        ConstraintTrackingWorker.this.k();
      }
    });
    return this.c;
  }

  public void f()
  {
    super.f();
    if (this.f != null)
      this.f.e();
  }

  void k()
  {
    String str = c().a("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
    if (TextUtils.isEmpty(str))
    {
      i.a().e(d, "No worker to delegate to.", new Throwable[0]);
      l();
      return;
    }
    this.f = j().b(a(), str, this.e);
    if (this.f == null)
    {
      i.a().b(d, "No worker to delegate to.", new Throwable[0]);
      l();
      return;
    }
    j localj = n().m().b(b().toString());
    if (localj == null)
    {
      l();
      return;
    }
    d locald = new d(a(), this);
    locald.a(Collections.singletonList(localj));
    if (locald.a(b().toString()))
    {
      i.a().b(d, String.format("Constraints met for delegate %s", new Object[] { str }), new Throwable[0]);
      try
      {
        final a locala = this.f.d();
        locala.a(new Runnable()
        {
          public void run()
          {
            synchronized (ConstraintTrackingWorker.this.a)
            {
              if (ConstraintTrackingWorker.this.b)
              {
                ConstraintTrackingWorker.this.m();
                return;
              }
              ConstraintTrackingWorker.this.c.a(locala);
            }
          }
        }
        , i());
        return;
      }
      catch (Throwable localThrowable)
      {
        i.a().b(d, String.format("Delegated worker %s threw exception in startWork.", new Object[] { str }), new Throwable[] { localThrowable });
      }
      while (true)
      {
        synchronized (this.a)
        {
          if (this.b)
          {
            i.a().b(d, "Constraints were unmet, Retrying.", new Throwable[0]);
            m();
            return;
          }
        }
        l();
      }
    }
    i.a().b(d, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[] { str }), new Throwable[0]);
    m();
  }

  void l()
  {
    this.c.a(ListenableWorker.a.c());
  }

  void m()
  {
    this.c.a(ListenableWorker.a.b());
  }

  public WorkDatabase n()
  {
    return h.b().d();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.workers.ConstraintTrackingWorker
 * JD-Core Version:    0.6.2
 */