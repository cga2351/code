package a.a;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.BroadcastReceiver.PendingResult;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import com.appboy.receivers.AppboyActionReceiver;
import java.util.concurrent.TimeUnit;

public class gn
{
  private static final String a = com.appboy.f.c.a(gn.class);
  private final Context b;
  private final gp c;
  private final AlarmManager d;
  private final gm e;
  private final BroadcastReceiver f;
  private final PendingIntent g;
  private gw h;
  private long i;
  private boolean j;
  private final cp k;
  private volatile boolean l = false;

  public gn(Context paramContext, final d paramd, gp paramgp, AlarmManager paramAlarmManager, gm paramgm, String paramString)
  {
    this.b = paramContext;
    this.c = paramgp;
    this.d = paramAlarmManager;
    this.e = paramgm;
    this.h = gw.b;
    this.i = -1L;
    this.k = new cp((int)TimeUnit.MINUTES.toMillis(5L));
    Intent localIntent = new Intent("com.appboy.action.receiver.DATA_SYNC").setClass(paramContext, AppboyActionReceiver.class);
    this.g = PendingIntent.getBroadcast(this.b, paramString.hashCode(), localIntent, 134217728);
    this.f = new BroadcastReceiver()
    {
      public void onReceive(final Context paramAnonymousContext, final Intent paramAnonymousIntent)
      {
        new Thread(new Runnable()
        {
          public void run()
          {
            try
            {
              ConnectivityManager localConnectivityManager = (ConnectivityManager)paramAnonymousContext.getSystemService("connectivity");
              gn.a(gn.this).a(paramAnonymousIntent, localConnectivityManager);
              gn.this.c();
              this.c.finish();
              return;
            }
            catch (Exception localException)
            {
              while (true)
              {
                com.appboy.f.c.d(gn.f(), "Failed to process connectivity event.", localException);
                gn.a(gn.this, gn.1.this.a, localException);
              }
            }
          }
        }).start();
      }
    };
    com.appboy.f.c.b(a, "Registered broadcast filters");
  }

  private void a(long paramLong1, long paramLong2)
  {
    this.d.setInexactRepeating(1, paramLong1, paramLong2, this.g);
  }

  private void a(d paramd, Throwable paramThrowable)
  {
    try
    {
      paramd.a(paramThrowable, Throwable.class);
      return;
    }
    catch (Exception localException)
    {
      com.appboy.f.c.d(a, "Failed to log throwable.", localException);
    }
  }

  private void g()
  {
    if (this.g != null)
      this.d.cancel(this.g);
  }

  void a(long paramLong)
  {
    if (this.d == null)
    {
      com.appboy.f.c.b(a, "Alarm manager was null. Ignoring request to reset it.");
      return;
    }
    if (this.i <= 0L)
    {
      com.appboy.f.c.b(a, "Cancelling alarm because delay value was not positive.");
      g();
      return;
    }
    a(paramLong + di.c(), this.i);
  }

  public void a(c paramc)
  {
    paramc.b(new com.appboy.c.c()
    {
      public void a(q paramAnonymousq)
      {
        gn.a(gn.this, gw.a);
        gn.this.c();
      }
    }
    , q.class);
    paramc.b(new com.appboy.c.c()
    {
      public void a(r paramAnonymousr)
      {
        gn.a(gn.this, gw.b);
        gn.this.c();
      }
    }
    , r.class);
    paramc.b(new com.appboy.c.c()
    {
      public void a(g paramAnonymousg)
      {
        gn.this.a(gn.b(gn.this) + gn.c(gn.this).a((int)gn.b(gn.this)));
      }
    }
    , g.class);
    paramc.b(new com.appboy.c.c()
    {
      public void a(h paramAnonymoush)
      {
        if (gn.c(gn.this).b())
        {
          gn.c(gn.this).a();
          com.appboy.f.c.b(gn.f(), "Received successful request flush. Default flush interval reset to " + gn.b(gn.this));
          gn.this.a(gn.b(gn.this));
        }
      }
    }
    , h.class);
  }

  public void a(boolean paramBoolean)
  {
    try
    {
      this.j = paramBoolean;
      c();
      if (paramBoolean)
        b();
      while (true)
      {
        return;
        a();
      }
    }
    finally
    {
    }
  }

  public boolean a()
  {
    boolean bool = true;
    try
    {
      if (this.l)
      {
        com.appboy.f.c.b(a, "The data sync policy is already running. Ignoring request.");
        bool = false;
      }
      while (true)
      {
        return bool;
        com.appboy.f.c.b(a, "Data sync started");
        d();
        a(3000L);
        this.l = true;
      }
    }
    finally
    {
    }
  }

  public boolean b()
  {
    boolean bool = false;
    try
    {
      if (!this.l)
        com.appboy.f.c.b(a, "The data sync policy is not running. Ignoring request.");
      while (true)
      {
        return bool;
        com.appboy.f.c.b(a, "Data sync stopped");
        g();
        e();
        this.l = false;
        bool = true;
      }
    }
    finally
    {
    }
  }

  protected void c()
  {
    long l1 = this.i;
    if ((this.h == gw.b) || (this.j))
      this.i = -1L;
    while (true)
    {
      if (l1 != this.i)
      {
        a(this.i);
        com.appboy.f.c.b(a, "Dispatch state has changed from " + l1 + " to " + this.i + ".");
      }
      return;
      switch (6.a[this.c.a().ordinal()])
      {
      default:
        this.i = this.e.b();
        break;
      case 1:
        this.i = -1L;
        break;
      case 2:
        this.i = this.e.a();
        break;
      case 3:
      case 4:
        this.i = this.e.c();
      }
    }
  }

  protected void d()
  {
    IntentFilter localIntentFilter = new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE");
    this.b.registerReceiver(this.f, localIntentFilter);
  }

  protected void e()
  {
    this.b.unregisterReceiver(this.f);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     a.a.gn
 * JD-Core Version:    0.6.2
 */