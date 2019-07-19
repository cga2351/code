package androidx.work.impl;

import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import androidx.work.R.bool;
import androidx.work.WorkerParameters.a;
import androidx.work.i.a;
import androidx.work.impl.utils.ForceStopRunnable;
import androidx.work.l;
import androidx.work.m;
import androidx.work.o;
import androidx.work.p;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;

public class h extends p
{
  private static h k = null;
  private static h l = null;
  private static final Object m = new Object();
  private Context a;
  private androidx.work.b b;
  private WorkDatabase c;
  private androidx.work.impl.utils.b.a d;
  private List<d> e;
  private c f;
  private androidx.work.impl.utils.e g;
  private boolean h;
  private BroadcastReceiver.PendingResult i;
  private final i j = new i();

  public h(Context paramContext, androidx.work.b paramb, androidx.work.impl.utils.b.a parama)
  {
    this(paramContext, paramb, parama, paramContext.getResources().getBoolean(R.bool.workmanager_test_configuration));
  }

  public h(Context paramContext, androidx.work.b paramb, androidx.work.impl.utils.b.a parama, boolean paramBoolean)
  {
    Context localContext = paramContext.getApplicationContext();
    WorkDatabase localWorkDatabase = WorkDatabase.a(localContext, paramBoolean);
    androidx.work.i.a(new i.a(paramb.c()));
    List localList = a(localContext);
    a(paramContext, paramb, parama, localWorkDatabase, localList, new c(paramContext, paramb, parama, localWorkDatabase, localList));
  }

  private void a(Context paramContext, androidx.work.b paramb, androidx.work.impl.utils.b.a parama, WorkDatabase paramWorkDatabase, List<d> paramList, c paramc)
  {
    Context localContext = paramContext.getApplicationContext();
    this.a = localContext;
    this.b = paramb;
    this.d = parama;
    this.c = paramWorkDatabase;
    this.e = paramList;
    this.f = paramc;
    this.g = new androidx.work.impl.utils.e(this.a);
    this.h = false;
    this.d.a(new ForceStopRunnable(localContext, this));
  }

  private f b(String paramString, androidx.work.f paramf, m paramm)
  {
    if (paramf == androidx.work.f.b);
    for (androidx.work.g localg = androidx.work.g.b; ; localg = androidx.work.g.a)
      return new f(this, paramString, localg, Collections.singletonList(paramm));
  }

  public static h b()
  {
    synchronized (m)
    {
      if (k != null)
      {
        h localh2 = k;
        return localh2;
      }
      h localh1 = l;
      return localh1;
    }
  }

  public static void b(Context paramContext, androidx.work.b paramb)
  {
    synchronized (m)
    {
      if ((k != null) && (l != null))
        throw new IllegalStateException("WorkManager is already initialized.  Did you try to initialize it manually without disabling WorkManagerInitializer? See WorkManager#initialize(Context, Configuration) or the class levelJavadoc for more information.");
    }
    if (k == null)
    {
      Context localContext = paramContext.getApplicationContext();
      if (l == null)
        l = new h(localContext, paramb, new androidx.work.impl.utils.b.b());
      k = l;
    }
  }

  public l a(String paramString)
  {
    androidx.work.impl.utils.a locala = androidx.work.impl.utils.a.a(paramString, this);
    this.d.a(locala);
    return locala.a();
  }

  public l a(String paramString, androidx.work.f paramf, m paramm)
  {
    return b(paramString, paramf, paramm).i();
  }

  public l a(String paramString, androidx.work.g paramg, List<androidx.work.k> paramList)
  {
    return new f(this, paramString, paramg, paramList).i();
  }

  public List<d> a(Context paramContext)
  {
    d[] arrayOfd = new d[2];
    arrayOfd[0] = e.a(paramContext, this);
    arrayOfd[1] = new androidx.work.impl.background.a.a(paramContext, this);
    return Arrays.asList(arrayOfd);
  }

  public void a(BroadcastReceiver.PendingResult paramPendingResult)
  {
    synchronized (m)
    {
      this.i = paramPendingResult;
      if (this.h)
      {
        this.i.finish();
        this.i = null;
      }
      return;
    }
  }

  public void a(String paramString, WorkerParameters.a parama)
  {
    this.d.a(new androidx.work.impl.utils.f(this, paramString, parama));
  }

  public com.google.b.a.a.a<List<o>> b(String paramString)
  {
    androidx.work.impl.utils.g localg = androidx.work.impl.utils.g.a(this, paramString);
    this.d.c().execute(localg);
    return localg.b();
  }

  public Context c()
  {
    return this.a;
  }

  public void c(String paramString)
  {
    a(paramString, null);
  }

  public WorkDatabase d()
  {
    return this.c;
  }

  public void d(String paramString)
  {
    this.d.a(new androidx.work.impl.utils.h(this, paramString));
  }

  public androidx.work.b e()
  {
    return this.b;
  }

  public List<d> f()
  {
    return this.e;
  }

  public c g()
  {
    return this.f;
  }

  public androidx.work.impl.utils.b.a h()
  {
    return this.d;
  }

  public androidx.work.impl.utils.e i()
  {
    return this.g;
  }

  public void j()
  {
    if (Build.VERSION.SDK_INT >= 23)
      androidx.work.impl.background.systemjob.b.a(c());
    d().m().b();
    e.a(e(), d(), f());
  }

  public void k()
  {
    synchronized (m)
    {
      this.h = true;
      if (this.i != null)
      {
        this.i.finish();
        this.i = null;
      }
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.h
 * JD-Core Version:    0.6.2
 */