package com.crashlytics.android.a;

import android.content.Context;
import c.a.a.a.a.d.d;
import c.a.a.a.a.e.e;
import c.a.a.a.a.g.b;
import c.a.a.a.c;
import c.a.a.a.i;
import c.a.a.a.l;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledExecutorService;

class f
  implements d
{
  final ScheduledExecutorService a;
  ac b = new n();
  private final i c;
  private final Context d;
  private final g e;
  private final ag f;
  private final e g;
  private final r h;

  public f(i parami, Context paramContext, g paramg, ag paramag, e parame, ScheduledExecutorService paramScheduledExecutorService, r paramr)
  {
    this.c = parami;
    this.d = paramContext;
    this.e = paramg;
    this.f = paramag;
    this.g = parame;
    this.a = paramScheduledExecutorService;
    this.h = paramr;
  }

  private void a(Runnable paramRunnable)
  {
    try
    {
      this.a.submit(paramRunnable).get();
      return;
    }
    catch (Exception localException)
    {
      c.g().e("Answers", "Failed to run events task", localException);
    }
  }

  private void b(Runnable paramRunnable)
  {
    try
    {
      this.a.submit(paramRunnable);
      return;
    }
    catch (Exception localException)
    {
      c.g().e("Answers", "Failed to submit events task", localException);
    }
  }

  public void a()
  {
    b(new Runnable()
    {
      public void run()
      {
        try
        {
          ac localac = f.this.b;
          f.this.b = new n();
          localac.b();
          return;
        }
        catch (Exception localException)
        {
          c.g().e("Answers", "Failed to disable events", localException);
        }
      }
    });
  }

  public void a(final b paramb, final String paramString)
  {
    b(new Runnable()
    {
      public void run()
      {
        try
        {
          f.this.b.a(paramb, paramString);
          return;
        }
        catch (Exception localException)
        {
          c.g().e("Answers", "Failed to set analytics settings data", localException);
        }
      }
    });
  }

  public void a(ad.a parama)
  {
    a(parama, false, false);
  }

  void a(final ad.a parama, boolean paramBoolean1, final boolean paramBoolean2)
  {
    Runnable local6 = new Runnable()
    {
      public void run()
      {
        try
        {
          f.this.b.a(parama);
          if (paramBoolean2)
            f.this.b.c();
          return;
        }
        catch (Exception localException)
        {
          c.g().e("Answers", "Failed to process event", localException);
        }
      }
    };
    if (paramBoolean1)
    {
      a(local6);
      return;
    }
    b(local6);
  }

  public void a(String paramString)
  {
    b(new Runnable()
    {
      public void run()
      {
        try
        {
          f.this.b.a();
          return;
        }
        catch (Exception localException)
        {
          c.g().e("Answers", "Failed to send events files", localException);
        }
      }
    });
  }

  public void b()
  {
    b(new Runnable()
    {
      public void run()
      {
        try
        {
          ae localae = f.a(f.this).a();
          z localz = f.b(f.this).a();
          localz.a(f.this);
          f.this.b = new o(f.c(f.this), f.d(f.this), f.this.a, localz, f.e(f.this), localae, f.f(f.this));
          return;
        }
        catch (Exception localException)
        {
          c.g().e("Answers", "Failed to enable events", localException);
        }
      }
    });
  }

  public void b(ad.a parama)
  {
    a(parama, false, true);
  }

  public void c()
  {
    b(new Runnable()
    {
      public void run()
      {
        try
        {
          f.this.b.c();
          return;
        }
        catch (Exception localException)
        {
          c.g().e("Answers", "Failed to flush events", localException);
        }
      }
    });
  }

  public void c(ad.a parama)
  {
    a(parama, true, false);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.crashlytics.android.a.f
 * JD-Core Version:    0.6.2
 */