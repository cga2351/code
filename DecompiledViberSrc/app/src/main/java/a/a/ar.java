package a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import com.appboy.a;
import com.appboy.f.c;
import java.util.concurrent.TimeUnit;

public class ar
{
  static final long a = TimeUnit.SECONDS.toMillis(10L);
  private static final String b = c.a(ar.class);
  private static final long c = TimeUnit.SECONDS.toMillis(10L);
  private final Object d = new Object();
  private final da e;
  private final d f;
  private final Context g;
  private final AlarmManager h;
  private final int i;
  private final String j;
  private final dd k;
  private volatile bh l;
  private final Handler m;
  private final Runnable n;
  private final boolean o;

  public ar(final Context paramContext, da paramda, d paramd, AlarmManager paramAlarmManager, dd paramdd, int paramInt, boolean paramBoolean)
  {
    this.e = paramda;
    this.f = paramd;
    this.g = paramContext;
    this.h = paramAlarmManager;
    this.i = paramInt;
    this.k = paramdd;
    this.m = do.a();
    this.n = new Runnable()
    {
      public void run()
      {
        c.b(ar.h(), "Requesting data flush on internal session close flush timer.");
        a.a(paramContext).f();
      }
    };
    this.o = paramBoolean;
    BroadcastReceiver local2 = new BroadcastReceiver()
    {
      public void onReceive(Context paramAnonymousContext, Intent paramAnonymousIntent)
      {
        synchronized (ar.a(ar.this))
        {
          try
          {
            ar.b(ar.this);
            return;
          }
          catch (Exception localException1)
          {
            while (true)
              try
              {
                ar.c(ar.this).a(localException1, Throwable.class);
              }
              catch (Exception localException2)
              {
                c.d(ar.h(), "Failed to log throwable.", localException2);
              }
          }
        }
      }
    };
    this.j = (paramContext.getPackageName() + ".intent.APPBOY_SESSION_SHOULD_SEAL");
    paramContext.registerReceiver(local2, new IntentFilter(this.j));
  }

  private void a(long paramLong)
  {
    c.b(b, "Creating a session seal alarm with a delay of " + paramLong + " ms");
    Intent localIntent = new Intent(this.j);
    localIntent.putExtra("session_id", this.l.toString());
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.g, 0, localIntent, 1073741824);
    this.h.set(1, paramLong + di.c(), localPendingIntent);
  }

  static boolean a(bh parambh, int paramInt, boolean paramBoolean)
  {
    long l1 = di.c();
    long l2 = TimeUnit.SECONDS.toMillis(paramInt);
    long l3 = TimeUnit.SECONDS.toMillis(parambh.c().longValue());
    long l4 = TimeUnit.SECONDS.toMillis(()parambh.b());
    if (paramBoolean)
      if (l2 + l4 + a > l1);
    while (l2 + l3 <= l1)
    {
      return true;
      return false;
    }
    return false;
  }

  static long b(bh parambh, int paramInt, boolean paramBoolean)
  {
    long l1 = TimeUnit.SECONDS.toMillis(paramInt);
    if (paramBoolean)
    {
      long l2 = TimeUnit.SECONDS.toMillis(()parambh.b());
      long l3 = di.c();
      l1 = Math.max(a, l1 + l2 - l3);
    }
    return l1;
  }

  private boolean i()
  {
    synchronized (this.d)
    {
      k();
      if ((this.l == null) || (this.l.d()))
      {
        bh localbh = this.l;
        this.l = j();
        if ((localbh != null) && (localbh.d()))
        {
          c.b(b, "Clearing completely dispatched sealed session " + localbh.a());
          this.e.b(localbh);
        }
        return true;
      }
      if (this.l.c() != null)
      {
        this.l.a(null);
        return true;
      }
    }
    return false;
  }

  private bh j()
  {
    bh localbh = new bh(bi.a(), di.b());
    this.k.a(true);
    this.f.a(o.a, o.class);
    c.c(b, "New session created with ID: " + localbh.a());
    return localbh;
  }

  private void k()
  {
    synchronized (this.d)
    {
      if (this.l == null)
      {
        this.l = this.e.a();
        if (this.l != null)
          c.b(b, "Restored session from offline storage: " + this.l.a().toString());
      }
      if ((this.l != null) && (this.l.c() != null) && (!this.l.d()) && (a(this.l, this.i, this.o)))
      {
        c.c(b, "Session [" + this.l.a() + "] being sealed because its end time is over the grace period.");
        e();
        this.e.b(this.l);
        this.l = null;
      }
      return;
    }
  }

  private void l()
  {
    Intent localIntent = new Intent(this.j);
    localIntent.putExtra("session_id", this.l.toString());
    PendingIntent localPendingIntent = PendingIntent.getBroadcast(this.g, 0, localIntent, 1073741824);
    this.h.cancel(localPendingIntent);
  }

  public bh a()
  {
    synchronized (this.d)
    {
      if (i())
        this.e.a(this.l);
      g();
      l();
      this.f.a(q.a, q.class);
      bh localbh = this.l;
      return localbh;
    }
  }

  public bh b()
  {
    synchronized (this.d)
    {
      i();
      this.l.a(Double.valueOf(di.b()));
      this.e.a(this.l);
      f();
      a(b(this.l, this.i, this.o));
      this.f.a(r.a, r.class);
      bh localbh = this.l;
      return localbh;
    }
  }

  public bi c()
  {
    synchronized (this.d)
    {
      k();
      if (this.l == null)
        return null;
      bi localbi = this.l.a();
      return localbi;
    }
  }

  public boolean d()
  {
    while (true)
    {
      synchronized (this.d)
      {
        if ((this.l != null) && (this.l.d()))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  public void e()
  {
    synchronized (this.d)
    {
      if (this.l != null)
      {
        this.l.e();
        this.e.a(this.l);
        this.f.a(new p(this.l), p.class);
      }
      return;
    }
  }

  protected void f()
  {
    g();
    this.m.postDelayed(this.n, c);
  }

  protected void g()
  {
    this.m.removeCallbacks(this.n);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.ar
 * JD-Core Version:    0.6.2
 */