package androidx.work.impl;

import android.content.Context;
import androidx.work.WorkerParameters.a;
import androidx.work.b;
import androidx.work.i;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public class c
  implements a
{
  private static final String a = i.a("Processor");
  private Context b;
  private b c;
  private androidx.work.impl.utils.b.a d;
  private WorkDatabase e;
  private Map<String, j> f;
  private List<d> g;
  private Set<String> h;
  private final List<a> i;
  private final Object j;

  public c(Context paramContext, b paramb, androidx.work.impl.utils.b.a parama, WorkDatabase paramWorkDatabase, List<d> paramList)
  {
    this.b = paramContext;
    this.c = paramb;
    this.d = parama;
    this.e = paramWorkDatabase;
    this.f = new HashMap();
    this.g = paramList;
    this.h = new HashSet();
    this.i = new ArrayList();
    this.j = new Object();
  }

  public void a(a parama)
  {
    synchronized (this.j)
    {
      this.i.add(parama);
      return;
    }
  }

  public void a(String paramString, boolean paramBoolean)
  {
    synchronized (this.j)
    {
      this.f.remove(paramString);
      i locali = i.a();
      String str = a;
      Object[] arrayOfObject = new Object[3];
      arrayOfObject[0] = getClass().getSimpleName();
      arrayOfObject[1] = paramString;
      arrayOfObject[2] = Boolean.valueOf(paramBoolean);
      locali.b(str, String.format("%s %s executed; reschedule = %s", arrayOfObject), new Throwable[0]);
      Iterator localIterator = this.i.iterator();
      if (localIterator.hasNext())
        ((a)localIterator.next()).a(paramString, paramBoolean);
    }
  }

  public boolean a(String paramString)
  {
    return a(paramString, null);
  }

  public boolean a(String paramString, WorkerParameters.a parama)
  {
    synchronized (this.j)
    {
      if (this.f.containsKey(paramString))
      {
        i.a().b(a, String.format("Work %s is already enqueued for processing", new Object[] { paramString }), new Throwable[0]);
        return false;
      }
      j localj = new j.a(this.b, this.c, this.d, this.e, paramString).a(this.g).a(parama).a();
      com.google.b.a.a.a locala = localj.a();
      locala.a(new a(this, paramString, locala), this.d.a());
      this.f.put(paramString, localj);
      this.d.c().execute(localj);
      i locali = i.a();
      String str = a;
      Object[] arrayOfObject = new Object[2];
      arrayOfObject[0] = getClass().getSimpleName();
      arrayOfObject[1] = paramString;
      locali.b(str, String.format("%s: processing %s", arrayOfObject), new Throwable[0]);
      return true;
    }
  }

  public void b(a parama)
  {
    synchronized (this.j)
    {
      this.i.remove(parama);
      return;
    }
  }

  public boolean b(String paramString)
  {
    synchronized (this.j)
    {
      i.a().b(a, String.format("Processor stopping %s", new Object[] { paramString }), new Throwable[0]);
      j localj = (j)this.f.remove(paramString);
      if (localj != null)
      {
        localj.a(false);
        i.a().b(a, String.format("WorkerWrapper stopped for %s", new Object[] { paramString }), new Throwable[0]);
        return true;
      }
      i.a().b(a, String.format("WorkerWrapper could not be found for %s", new Object[] { paramString }), new Throwable[0]);
      return false;
    }
  }

  public boolean c(String paramString)
  {
    synchronized (this.j)
    {
      i.a().b(a, String.format("Processor cancelling %s", new Object[] { paramString }), new Throwable[0]);
      this.h.add(paramString);
      j localj = (j)this.f.remove(paramString);
      if (localj != null)
      {
        localj.a(true);
        i.a().b(a, String.format("WorkerWrapper cancelled for %s", new Object[] { paramString }), new Throwable[0]);
        return true;
      }
      i.a().b(a, String.format("WorkerWrapper could not be found for %s", new Object[] { paramString }), new Throwable[0]);
      return false;
    }
  }

  public boolean d(String paramString)
  {
    synchronized (this.j)
    {
      boolean bool = this.h.contains(paramString);
      return bool;
    }
  }

  public boolean e(String paramString)
  {
    synchronized (this.j)
    {
      boolean bool = this.f.containsKey(paramString);
      return bool;
    }
  }

  private static class a
    implements Runnable
  {
    private a a;
    private String b;
    private com.google.b.a.a.a<Boolean> c;

    a(a parama, String paramString, com.google.b.a.a.a<Boolean> parama1)
    {
      this.a = parama;
      this.b = paramString;
      this.c = parama1;
    }

    public void run()
    {
      try
      {
        boolean bool2 = ((Boolean)this.c.get()).booleanValue();
        bool1 = bool2;
        this.a.a(this.b, bool1);
        return;
      }
      catch (InterruptedException localInterruptedException)
      {
        while (true)
          boolean bool1 = true;
      }
      catch (ExecutionException localExecutionException)
      {
        label36: break label36;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.c
 * JD-Core Version:    0.6.2
 */