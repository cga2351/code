package android.arch.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;

public class p
  implements h
{
  private static final p i = new p();
  private int a = 0;
  private int b = 0;
  private boolean c = true;
  private boolean d = true;
  private Handler e;
  private final i f = new i(this);
  private Runnable g = new Runnable()
  {
    public void run()
    {
      p.a(p.this);
      p.b(p.this);
    }
  };
  private q.a h = new q.a()
  {
    public void a()
    {
    }

    public void b()
    {
      p.this.b();
    }

    public void c()
    {
      p.this.c();
    }
  };

  public static h a()
  {
    return i;
  }

  static void a(Context paramContext)
  {
    i.b(paramContext);
  }

  private void f()
  {
    if (this.b == 0)
    {
      this.c = true;
      this.f.a(e.a.ON_PAUSE);
    }
  }

  private void g()
  {
    if ((this.a == 0) && (this.c))
    {
      this.f.a(e.a.ON_STOP);
      this.d = true;
    }
  }

  void b()
  {
    this.a = (1 + this.a);
    if ((this.a == 1) && (this.d))
    {
      this.f.a(e.a.ON_START);
      this.d = false;
    }
  }

  void b(Context paramContext)
  {
    this.e = new Handler();
    this.f.a(e.a.ON_CREATE);
    ((Application)paramContext.getApplicationContext()).registerActivityLifecycleCallbacks(new c()
    {
      public void onActivityCreated(Activity paramAnonymousActivity, Bundle paramAnonymousBundle)
      {
        q.b(paramAnonymousActivity).a(p.c(p.this));
      }

      public void onActivityPaused(Activity paramAnonymousActivity)
      {
        p.this.d();
      }

      public void onActivityStopped(Activity paramAnonymousActivity)
      {
        p.this.e();
      }
    });
  }

  void c()
  {
    this.b = (1 + this.b);
    if (this.b == 1)
    {
      if (this.c)
      {
        this.f.a(e.a.ON_RESUME);
        this.c = false;
      }
    }
    else
      return;
    this.e.removeCallbacks(this.g);
  }

  void d()
  {
    this.b = (-1 + this.b);
    if (this.b == 0)
      this.e.postDelayed(this.g, 700L);
  }

  void e()
  {
    this.a = (-1 + this.a);
    g();
  }

  public e getLifecycle()
  {
    return this.f;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.arch.lifecycle.p
 * JD-Core Version:    0.6.2
 */