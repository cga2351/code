package androidx.work.impl.background.systemalarm;

import android.content.Context;
import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.os.PowerManager.WakeLock;
import android.text.TextUtils;
import androidx.work.impl.c;
import androidx.work.impl.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class e
  implements androidx.work.impl.a
{
  static final String a = androidx.work.i.a("SystemAlarmDispatcher");
  final Context b;
  final b c;
  final List<Intent> d;
  Intent e;
  private final g f;
  private final c g;
  private final h h;
  private final Handler i;
  private b j;

  e(Context paramContext)
  {
    this(paramContext, null, null);
  }

  e(Context paramContext, c paramc, h paramh)
  {
    this.b = paramContext.getApplicationContext();
    this.c = new b(this.b);
    this.f = new g();
    if (paramh != null)
    {
      this.h = paramh;
      if (paramc == null)
        break label102;
    }
    while (true)
    {
      this.g = paramc;
      this.g.a(this);
      this.d = new ArrayList();
      this.e = null;
      this.i = new Handler(Looper.getMainLooper());
      return;
      paramh = h.b();
      break;
      label102: paramc = this.h.g();
    }
  }

  private boolean a(String paramString)
  {
    g();
    synchronized (this.d)
    {
      Iterator localIterator = this.d.iterator();
      while (localIterator.hasNext())
        if (paramString.equals(((Intent)localIterator.next()).getAction()))
          return true;
      return false;
    }
  }

  private void f()
  {
    g();
    PowerManager.WakeLock localWakeLock = androidx.work.impl.utils.i.a(this.b, "ProcessCommand");
    try
    {
      localWakeLock.acquire();
      this.h.h().a(new Runnable()
      {
        public void run()
        {
          String str1;
          int i;
          PowerManager.WakeLock localWakeLock;
          synchronized (e.this.d)
          {
            e.this.e = ((Intent)e.this.d.get(0));
            if (e.this.e != null)
            {
              str1 = e.this.e.getAction();
              i = e.this.e.getIntExtra("KEY_START_ID", 0);
              androidx.work.i locali = androidx.work.i.a();
              String str2 = e.a;
              Object[] arrayOfObject1 = new Object[2];
              arrayOfObject1[0] = e.this.e;
              arrayOfObject1[1] = Integer.valueOf(i);
              locali.b(str2, String.format("Processing command %s, %s", arrayOfObject1), new Throwable[0]);
              Context localContext = e.this.b;
              Object[] arrayOfObject2 = new Object[2];
              arrayOfObject2[0] = str1;
              arrayOfObject2[1] = Integer.valueOf(i);
              localWakeLock = androidx.work.impl.utils.i.a(localContext, String.format("%s (%s)", arrayOfObject2));
            }
          }
          try
          {
            androidx.work.i.a().b(e.a, String.format("Acquiring operation wake lock (%s) %s", new Object[] { str1, localWakeLock }), new Throwable[0]);
            localWakeLock.acquire();
            e.this.c.a(e.this.e, i, e.this);
            return;
            localObject1 = finally;
            throw localObject1;
          }
          catch (Throwable localThrowable)
          {
            androidx.work.i.a().e(e.a, "Unexpected error in onHandleIntent", new Throwable[] { localThrowable });
            return;
          }
          finally
          {
            androidx.work.i.a().b(e.a, String.format("Releasing operation wake lock (%s) %s", new Object[] { str1, localWakeLock }), new Throwable[0]);
            localWakeLock.release();
            e.this.a(new e.c(e.this));
          }
        }
      });
      return;
    }
    finally
    {
      localWakeLock.release();
    }
  }

  private void g()
  {
    if (this.i.getLooper().getThread() != Thread.currentThread())
      throw new IllegalStateException("Needs to be invoked on the main thread.");
  }

  void a()
  {
    this.g.b(this);
    this.j = null;
  }

  void a(b paramb)
  {
    if (this.j != null)
    {
      androidx.work.i.a().e(a, "A completion listener for SystemAlarmDispatcher already exists.", new Throwable[0]);
      return;
    }
    this.j = paramb;
  }

  void a(Runnable paramRunnable)
  {
    this.i.post(paramRunnable);
  }

  public void a(String paramString, boolean paramBoolean)
  {
    a(new a(this, b.a(this.b, paramString, paramBoolean), 0));
  }

  public boolean a(Intent paramIntent, int paramInt)
  {
    androidx.work.i locali = androidx.work.i.a();
    String str1 = a;
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = paramIntent;
    arrayOfObject[1] = Integer.valueOf(paramInt);
    locali.b(str1, String.format("Adding command %s (%s)", arrayOfObject), new Throwable[0]);
    g();
    String str2 = paramIntent.getAction();
    if (TextUtils.isEmpty(str2))
      androidx.work.i.a().d(a, "Unknown command. Ignoring", new Throwable[0]);
    while (("ACTION_CONSTRAINTS_CHANGED".equals(str2)) && (a("ACTION_CONSTRAINTS_CHANGED")))
      return false;
    paramIntent.putExtra("KEY_START_ID", paramInt);
    synchronized (this.d)
    {
      boolean bool = this.d.isEmpty();
      int k = 0;
      if (!bool)
        k = 1;
      this.d.add(paramIntent);
      if (k == 0)
        f();
      return true;
    }
  }

  c b()
  {
    return this.g;
  }

  g c()
  {
    return this.f;
  }

  h d()
  {
    return this.h;
  }

  void e()
  {
    androidx.work.i.a().b(a, "Checking if commands are complete.", new Throwable[0]);
    g();
    synchronized (this.d)
    {
      if (this.e == null)
        break label117;
      androidx.work.i locali = androidx.work.i.a();
      String str = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = this.e;
      locali.b(str, String.format("Removing command %s", arrayOfObject), new Throwable[0]);
      if (!((Intent)this.d.remove(0)).equals(this.e))
        throw new IllegalStateException("Dequeue-d command is not the first.");
    }
    this.e = null;
    label117: if ((!this.c.a()) && (this.d.isEmpty()))
    {
      androidx.work.i.a().b(a, "No more commands & intents.", new Throwable[0]);
      if (this.j != null)
        this.j.a();
    }
    while (true)
    {
      return;
      if (!this.d.isEmpty())
        f();
    }
  }

  static class a
    implements Runnable
  {
    private final e a;
    private final Intent b;
    private final int c;

    a(e parame, Intent paramIntent, int paramInt)
    {
      this.a = parame;
      this.b = paramIntent;
      this.c = paramInt;
    }

    public void run()
    {
      this.a.a(this.b, this.c);
    }
  }

  static abstract interface b
  {
    public abstract void a();
  }

  static class c
    implements Runnable
  {
    private final e a;

    c(e parame)
    {
      this.a = parame;
    }

    public void run()
    {
      this.a.e();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     androidx.work.impl.background.systemalarm.e
 * JD-Core Version:    0.6.2
 */