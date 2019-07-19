package com.viber.voip.banner.a.a;

import android.app.Activity;
import android.os.Handler;
import com.viber.voip.ads.b.b.b.c;
import com.viber.voip.ads.d.i;
import com.viber.voip.av.e;
import com.viber.voip.phone.call.CallInfo;

public class e
  implements d
{
  private final d a;
  private final Handler b;
  private final Handler c;

  public e(d paramd, Handler paramHandler)
  {
    this.a = paramd;
    this.b = av.e.e.a();
    this.c = paramHandler;
  }

  private void a(final a parama)
  {
    this.b.post(new Runnable()
    {
      public void run()
      {
        parama.a(e.a(e.this));
      }
    });
  }

  public void a(Activity paramActivity)
  {
    this.a.a(paramActivity);
  }

  public void a(final String paramString, final CallInfo paramCallInfo)
  {
    a(new a()
    {
      public void a(d paramAnonymousd)
      {
        paramAnonymousd.a(paramString, paramCallInfo);
      }
    });
  }

  public void a(String[] paramArrayOfString)
  {
    this.a.a(paramArrayOfString);
  }

  public void b(Activity paramActivity)
  {
    this.a.b(paramActivity);
  }

  public void d()
  {
    this.a.d();
  }

  public int e()
  {
    return this.a.e();
  }

  public int f()
  {
    return this.a.f();
  }

  public c g()
  {
    return this.a.g();
  }

  public boolean h()
  {
    return this.a.h();
  }

  public boolean i()
  {
    return this.a.i();
  }

  public i j()
  {
    return this.a.j();
  }

  public void k()
  {
    this.c.post(new Runnable()
    {
      public void run()
      {
        e.a(e.this).k();
      }
    });
  }

  public int l()
  {
    return this.a.l();
  }

  private static abstract interface a
  {
    public abstract void a(d paramd);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.a.a.e
 * JD-Core Version:    0.6.2
 */