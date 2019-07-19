package androidx.work.impl;

import android.content.Context;
import android.os.Build.VERSION;
import androidx.work.ListenableWorker;
import androidx.work.ListenableWorker.a;
import androidx.work.ListenableWorker.a.a;
import androidx.work.ListenableWorker.a.b;
import androidx.work.ListenableWorker.a.c;
import androidx.work.WorkerParameters;
import androidx.work.WorkerParameters.a;
import androidx.work.h;
import androidx.work.i;
import androidx.work.impl.b.k;
import androidx.work.impl.b.n;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import androidx.work.impl.utils.a.c;
import androidx.work.o.a;
import androidx.work.s;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;

public class j
  implements Runnable
{
  static final String a = i.a("WorkerWrapper");
  androidx.work.impl.b.j b;
  ListenableWorker c;
  ListenableWorker.a d = ListenableWorker.a.c();
  com.google.b.a.a.a<ListenableWorker.a> e = null;
  private Context f;
  private String g;
  private List<d> h;
  private WorkerParameters.a i;
  private androidx.work.b j;
  private androidx.work.impl.utils.b.a k;
  private WorkDatabase l;
  private k m;
  private androidx.work.impl.b.b n;
  private n o;
  private List<String> p;
  private String q;
  private c<Boolean> r = c.d();
  private volatile boolean s;

  j(a parama)
  {
    this.f = parama.a;
    this.k = parama.c;
    this.g = parama.f;
    this.h = parama.g;
    this.i = parama.h;
    this.c = parama.b;
    this.j = parama.d;
    this.l = parama.e;
    this.m = this.l.m();
    this.n = this.l.n();
    this.o = this.l.o();
  }

  private String a(List<String> paramList)
  {
    StringBuilder localStringBuilder = new StringBuilder("Work [ id=").append(this.g).append(", tags={ ");
    Iterator localIterator = paramList.iterator();
    int i1 = 1;
    if (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      if (i1 != 0)
        i1 = 0;
      while (true)
      {
        localStringBuilder.append(str);
        break;
        localStringBuilder.append(", ");
      }
    }
    localStringBuilder.append(" } ]");
    return localStringBuilder.toString();
  }

  private void a(ListenableWorker.a parama)
  {
    if ((parama instanceof ListenableWorker.a.c))
    {
      i locali3 = i.a();
      String str3 = a;
      Object[] arrayOfObject3 = new Object[1];
      arrayOfObject3[0] = this.q;
      locali3.c(str3, String.format("Worker result SUCCESS for %s", arrayOfObject3), new Throwable[0]);
      if (this.b.a())
      {
        i();
        return;
      }
      j();
      return;
    }
    if ((parama instanceof ListenableWorker.a.b))
    {
      i locali2 = i.a();
      String str2 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.q;
      locali2.c(str2, String.format("Worker result RETRY for %s", arrayOfObject2), new Throwable[0]);
      h();
      return;
    }
    i locali1 = i.a();
    String str1 = a;
    Object[] arrayOfObject1 = new Object[1];
    arrayOfObject1[0] = this.q;
    locali1.c(str1, String.format("Worker result FAILURE for %s", arrayOfObject1), new Throwable[0]);
    if (this.b.a())
    {
      i();
      return;
    }
    c();
  }

  private void a(String paramString)
  {
    LinkedList localLinkedList = new LinkedList();
    localLinkedList.add(paramString);
    while (!localLinkedList.isEmpty())
    {
      String str = (String)localLinkedList.remove();
      if (this.m.f(str) != o.a.f)
        this.m.a(o.a.d, new String[] { str });
      localLinkedList.addAll(this.n.b(str));
    }
  }

  private void b(boolean paramBoolean)
  {
    while (true)
    {
      try
      {
        this.l.f();
        List localList = this.l.m().a();
        if (localList != null)
        {
          boolean bool = localList.isEmpty();
          i1 = 0;
          if (!bool)
          {
            if (i1 != 0)
              androidx.work.impl.utils.d.a(this.f, RescheduleReceiver.class, false);
            this.l.h();
            this.l.g();
            this.r.a(Boolean.valueOf(paramBoolean));
            return;
          }
        }
      }
      finally
      {
        this.l.g();
      }
      int i1 = 1;
    }
  }

  private void d()
  {
    if (f());
    do
    {
      return;
      this.l.f();
      while (true)
      {
        try
        {
          this.b = this.m.b(this.g);
          if (this.b == null)
          {
            i locali6 = i.a();
            String str6 = a;
            Object[] arrayOfObject6 = new Object[1];
            arrayOfObject6[0] = this.g;
            locali6.e(str6, String.format("Didn't find WorkSpec for id %s", arrayOfObject6), new Throwable[0]);
            b(false);
            return;
          }
          if (this.b.b != o.a.a)
          {
            e();
            this.l.h();
            i locali5 = i.a();
            String str5 = a;
            Object[] arrayOfObject5 = new Object[1];
            arrayOfObject5[0] = this.b.c;
            locali5.b(str5, String.format("%s is not in ENQUEUED state. Nothing more to do.", arrayOfObject5), new Throwable[0]);
            return;
          }
          if ((this.b.a()) || (this.b.b()))
          {
            long l1 = System.currentTimeMillis();
            int i1;
            if ((Build.VERSION.SDK_INT < 23) && (this.b.h != this.b.i) && (this.b.n == 0L))
            {
              i1 = 1;
              if ((i1 == 0) && (l1 < this.b.c()))
              {
                i locali4 = i.a();
                String str4 = a;
                Object[] arrayOfObject4 = new Object[1];
                arrayOfObject4[0] = this.b.c;
                locali4.b(str4, String.format("Delaying execution for %s because it is being executed before schedule.", arrayOfObject4), new Throwable[0]);
                b(true);
              }
            }
            else
            {
              i1 = 0;
              continue;
            }
          }
          this.l.h();
          this.l.g();
          if (this.b.a())
          {
            locale = this.b.e;
            WorkerParameters localWorkerParameters = new WorkerParameters(UUID.fromString(this.g), locale, this.p, this.i, this.b.k, this.j.a(), this.k, this.j.b());
            if (this.c == null)
              this.c = this.j.b().b(this.f, this.b.c, localWorkerParameters);
            if (this.c != null)
              break;
            i locali2 = i.a();
            String str2 = a;
            Object[] arrayOfObject2 = new Object[1];
            arrayOfObject2[0] = this.b.c;
            locali2.e(str2, String.format("Could not create Worker %s", arrayOfObject2), new Throwable[0]);
            c();
            return;
          }
        }
        finally
        {
          this.l.g();
        }
        h localh = h.a(this.b.d);
        if (localh == null)
        {
          i locali3 = i.a();
          String str3 = a;
          Object[] arrayOfObject3 = new Object[1];
          arrayOfObject3[0] = this.b.d;
          locali3.e(str3, String.format("Could not create Input Merger %s", arrayOfObject3), new Throwable[0]);
          c();
          return;
        }
        ArrayList localArrayList = new ArrayList();
        localArrayList.add(this.b.e);
        localArrayList.addAll(this.m.h(this.g));
        androidx.work.e locale = localh.a(localArrayList);
      }
      if (this.c.g())
      {
        i locali1 = i.a();
        String str1 = a;
        Object[] arrayOfObject1 = new Object[1];
        arrayOfObject1[0] = this.b.c;
        locali1.e(str1, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", arrayOfObject1), new Throwable[0]);
        c();
        return;
      }
      this.c.h();
      if (!g())
        break;
    }
    while (f());
    final c localc = c.d();
    this.k.a().execute(new Runnable()
    {
      public void run()
      {
        try
        {
          i locali = i.a();
          String str = j.a;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = j.this.b.c;
          locali.b(str, String.format("Starting work for %s", arrayOfObject), new Throwable[0]);
          j.this.e = j.this.c.d();
          localc.a(j.this.e);
          return;
        }
        catch (Throwable localThrowable)
        {
          localc.a(localThrowable);
        }
      }
    });
    localc.a(new Runnable()
    {
      // ERROR //
      @android.annotation.SuppressLint({"SyntheticAccessor"})
      public void run()
      {
        // Byte code:
        //   0: aload_0
        //   1: getfield 23	androidx/work/impl/j$2:a	Landroidx/work/impl/utils/a/c;
        //   4: invokevirtual 43	androidx/work/impl/utils/a/c:get	()Ljava/lang/Object;
        //   7: checkcast 45	androidx/work/ListenableWorker$a
        //   10: astore 10
        //   12: aload 10
        //   14: ifnonnull +59 -> 73
        //   17: invokestatic 50	androidx/work/i:a	()Landroidx/work/i;
        //   20: astore 11
        //   22: getstatic 52	androidx/work/impl/j:a	Ljava/lang/String;
        //   25: astore 12
        //   27: iconst_1
        //   28: anewarray 4	java/lang/Object
        //   31: astore 13
        //   33: aload 13
        //   35: iconst_0
        //   36: aload_0
        //   37: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   40: getfield 55	androidx/work/impl/j:b	Landroidx/work/impl/b/j;
        //   43: getfield 59	androidx/work/impl/b/j:c	Ljava/lang/String;
        //   46: aastore
        //   47: aload 11
        //   49: aload 12
        //   51: ldc 61
        //   53: aload 13
        //   55: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   58: iconst_0
        //   59: anewarray 69	java/lang/Throwable
        //   62: invokevirtual 73	androidx/work/i:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
        //   65: aload_0
        //   66: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   69: invokevirtual 75	androidx/work/impl/j:b	()V
        //   72: return
        //   73: invokestatic 50	androidx/work/i:a	()Landroidx/work/i;
        //   76: astore 14
        //   78: getstatic 52	androidx/work/impl/j:a	Ljava/lang/String;
        //   81: astore 15
        //   83: iconst_2
        //   84: anewarray 4	java/lang/Object
        //   87: astore 16
        //   89: aload 16
        //   91: iconst_0
        //   92: aload_0
        //   93: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   96: getfield 55	androidx/work/impl/j:b	Landroidx/work/impl/b/j;
        //   99: getfield 59	androidx/work/impl/b/j:c	Ljava/lang/String;
        //   102: aastore
        //   103: aload 16
        //   105: iconst_1
        //   106: aload 10
        //   108: aastore
        //   109: aload 14
        //   111: aload 15
        //   113: ldc 77
        //   115: aload 16
        //   117: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   120: iconst_0
        //   121: anewarray 69	java/lang/Throwable
        //   124: invokevirtual 79	androidx/work/i:b	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
        //   127: aload_0
        //   128: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   131: aload 10
        //   133: putfield 82	androidx/work/impl/j:d	Landroidx/work/ListenableWorker$a;
        //   136: goto -71 -> 65
        //   139: astore 6
        //   141: invokestatic 50	androidx/work/i:a	()Landroidx/work/i;
        //   144: astore 7
        //   146: getstatic 52	androidx/work/impl/j:a	Ljava/lang/String;
        //   149: astore 8
        //   151: iconst_1
        //   152: anewarray 4	java/lang/Object
        //   155: astore 9
        //   157: aload 9
        //   159: iconst_0
        //   160: aload_0
        //   161: getfield 25	androidx/work/impl/j$2:b	Ljava/lang/String;
        //   164: aastore
        //   165: aload 7
        //   167: aload 8
        //   169: ldc 84
        //   171: aload 9
        //   173: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   176: iconst_1
        //   177: anewarray 69	java/lang/Throwable
        //   180: dup
        //   181: iconst_0
        //   182: aload 6
        //   184: aastore
        //   185: invokevirtual 86	androidx/work/i:c	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
        //   188: aload_0
        //   189: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   192: invokevirtual 75	androidx/work/impl/j:b	()V
        //   195: return
        //   196: astore_1
        //   197: invokestatic 50	androidx/work/i:a	()Landroidx/work/i;
        //   200: astore_3
        //   201: getstatic 52	androidx/work/impl/j:a	Ljava/lang/String;
        //   204: astore 4
        //   206: iconst_1
        //   207: anewarray 4	java/lang/Object
        //   210: astore 5
        //   212: aload 5
        //   214: iconst_0
        //   215: aload_0
        //   216: getfield 25	androidx/work/impl/j$2:b	Ljava/lang/String;
        //   219: aastore
        //   220: aload_3
        //   221: aload 4
        //   223: ldc 88
        //   225: aload 5
        //   227: invokestatic 67	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
        //   230: iconst_1
        //   231: anewarray 69	java/lang/Throwable
        //   234: dup
        //   235: iconst_0
        //   236: aload_1
        //   237: aastore
        //   238: invokevirtual 73	androidx/work/i:e	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/Throwable;)V
        //   241: aload_0
        //   242: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   245: invokevirtual 75	androidx/work/impl/j:b	()V
        //   248: return
        //   249: astore_2
        //   250: aload_0
        //   251: getfield 21	androidx/work/impl/j$2:c	Landroidx/work/impl/j;
        //   254: invokevirtual 75	androidx/work/impl/j:b	()V
        //   257: aload_2
        //   258: athrow
        //   259: astore_1
        //   260: goto -63 -> 197
        //
        // Exception table:
        //   from	to	target	type
        //   0	12	139	java/util/concurrent/CancellationException
        //   17	65	139	java/util/concurrent/CancellationException
        //   73	136	139	java/util/concurrent/CancellationException
        //   0	12	196	java/lang/InterruptedException
        //   17	65	196	java/lang/InterruptedException
        //   73	136	196	java/lang/InterruptedException
        //   0	12	249	finally
        //   17	65	249	finally
        //   73	136	249	finally
        //   141	188	249	finally
        //   197	241	249	finally
        //   0	12	259	java/util/concurrent/ExecutionException
        //   17	65	259	java/util/concurrent/ExecutionException
        //   73	136	259	java/util/concurrent/ExecutionException
      }
    }
    , this.k.c());
    return;
    e();
  }

  private void e()
  {
    o.a locala = this.m.f(this.g);
    if (locala == o.a.b)
    {
      i locali2 = i.a();
      String str2 = a;
      Object[] arrayOfObject2 = new Object[1];
      arrayOfObject2[0] = this.g;
      locali2.b(str2, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", arrayOfObject2), new Throwable[0]);
      b(true);
      return;
    }
    i locali1 = i.a();
    String str1 = a;
    Object[] arrayOfObject1 = new Object[2];
    arrayOfObject1[0] = this.g;
    arrayOfObject1[1] = locala;
    locali1.b(str1, String.format("Status for %s is %s; not doing any work", arrayOfObject1), new Throwable[0]);
    b(false);
  }

  private boolean f()
  {
    if (this.s)
    {
      i locali = i.a();
      String str = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.q;
      locali.b(str, String.format("Work interrupted for %s", arrayOfObject), new Throwable[0]);
      o.a locala = this.m.f(this.g);
      if (locala == null)
      {
        b(false);
        return true;
      }
      boolean bool1 = locala.a();
      boolean bool2 = false;
      if (!bool1)
        bool2 = true;
      b(bool2);
      return true;
    }
    return false;
  }

  private boolean g()
  {
    boolean bool = true;
    this.l.f();
    while (true)
    {
      try
      {
        if (this.m.f(this.g) == o.a.a)
        {
          k localk = this.m;
          o.a locala = o.a.b;
          String[] arrayOfString = new String[1];
          arrayOfString[0] = this.g;
          localk.a(locala, arrayOfString);
          this.m.d(this.g);
          this.l.h();
          return bool;
        }
      }
      finally
      {
        this.l.g();
      }
      bool = false;
    }
  }

  private void h()
  {
    this.l.f();
    try
    {
      k localk = this.m;
      o.a locala = o.a.a;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.g;
      localk.a(locala, arrayOfString);
      this.m.a(this.g, System.currentTimeMillis());
      if (Build.VERSION.SDK_INT < 23)
        this.m.b(this.g, -1L);
      this.l.h();
      return;
    }
    finally
    {
      this.l.g();
      b(true);
    }
  }

  private void i()
  {
    this.l.f();
    try
    {
      this.m.a(this.g, System.currentTimeMillis());
      k localk = this.m;
      o.a locala = o.a.a;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.g;
      localk.a(locala, arrayOfString);
      this.m.e(this.g);
      if (Build.VERSION.SDK_INT < 23)
        this.m.b(this.g, -1L);
      this.l.h();
      return;
    }
    finally
    {
      this.l.g();
      b(false);
    }
  }

  private void j()
  {
    this.l.f();
    try
    {
      k localk = this.m;
      o.a locala = o.a.c;
      String[] arrayOfString = new String[1];
      arrayOfString[0] = this.g;
      localk.a(locala, arrayOfString);
      androidx.work.e locale = ((ListenableWorker.a.c)this.d).d();
      this.m.a(this.g, locale);
      long l1 = System.currentTimeMillis();
      Iterator localIterator = this.n.b(this.g).iterator();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        if ((this.m.f(str) == o.a.e) && (this.n.a(str)))
        {
          i.a().c(a, String.format("Setting status to enqueued for %s", new Object[] { str }), new Throwable[0]);
          this.m.a(o.a.a, new String[] { str });
          this.m.a(str, l1);
        }
      }
    }
    finally
    {
      this.l.g();
      b(false);
    }
    this.l.h();
    this.l.g();
    b(false);
  }

  private void k()
  {
    if (this.k.b() != Thread.currentThread())
      throw new IllegalStateException("Needs to be executed on the Background executor thread.");
  }

  public com.google.b.a.a.a<Boolean> a()
  {
    return this.r;
  }

  public void a(boolean paramBoolean)
  {
    this.s = true;
    f();
    if (this.e != null)
      this.e.cancel(true);
    if (this.c != null)
      this.c.e();
  }

  void b()
  {
    k();
    boolean bool1 = f();
    boolean bool2 = false;
    if (!bool1);
    try
    {
      this.l.f();
      o.a locala = this.m.f(this.g);
      if (locala == null)
      {
        b(false);
        bool2 = true;
      }
      while (true)
      {
        this.l.h();
        this.l.g();
        if (this.h == null)
          return;
        if (!bool2)
          break;
        Iterator localIterator = this.h.iterator();
        while (localIterator.hasNext())
          ((d)localIterator.next()).a(this.g);
        if (locala == o.a.b)
        {
          a(this.d);
          bool2 = this.m.f(this.g).a();
        }
        else
        {
          boolean bool3 = locala.a();
          bool2 = false;
          if (!bool3)
          {
            h();
            bool2 = false;
          }
        }
      }
    }
    finally
    {
      this.l.g();
    }
    e.a(this.j, this.l, this.h);
  }

  void c()
  {
    this.l.f();
    try
    {
      a(this.g);
      androidx.work.e locale = ((ListenableWorker.a.a)this.d).d();
      this.m.a(this.g, locale);
      this.l.h();
      return;
    }
    finally
    {
      this.l.g();
      b(false);
    }
  }

  public void run()
  {
    this.p = this.o.a(this.g);
    this.q = a(this.p);
    d();
  }

  public static class a
  {
    Context a;
    ListenableWorker b;
    androidx.work.impl.utils.b.a c;
    androidx.work.b d;
    WorkDatabase e;
    String f;
    List<d> g;
    WorkerParameters.a h = new WorkerParameters.a();

    public a(Context paramContext, androidx.work.b paramb, androidx.work.impl.utils.b.a parama, WorkDatabase paramWorkDatabase, String paramString)
    {
      this.a = paramContext.getApplicationContext();
      this.c = parama;
      this.d = paramb;
      this.e = paramWorkDatabase;
      this.f = paramString;
    }

    public a a(WorkerParameters.a parama)
    {
      if (parama != null)
        this.h = parama;
      return this;
    }

    public a a(List<d> paramList)
    {
      this.g = paramList;
      return this;
    }

    public j a()
    {
      return new j(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.j
 * JD-Core Version:    0.6.2
 */