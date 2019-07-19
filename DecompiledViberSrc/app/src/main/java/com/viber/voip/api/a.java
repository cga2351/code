package com.viber.voip.api;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.cv;
import com.viber.voip.util.cv.a;
import me.leolin.shortcutbadger.b;
import me.leolin.shortcutbadger.c;

public class a
  implements cv.a
{
  private static final Logger a = ViberEnv.getLogger();
  private static volatile a b;
  private cv c = cv.a();
  private Context d = ViberApplication.getApplication();
  private int e;
  private a f = new b();

  public static a a()
  {
    a locala1 = b;
    if (locala1 == null)
      try
      {
        a locala2 = b;
        if (locala2 == null)
        {
          locala2 = new a();
          b = locala2;
        }
        return locala2;
      }
      finally
      {
      }
    return locala1;
  }

  private void f()
  {
    this.f.a();
  }

  private int g()
  {
    if (this.e > 999)
      return 999;
    return this.e;
  }

  public void b()
  {
    this.c.a(this);
    this.e = this.c.e();
    f();
  }

  public void c()
  {
    if (!ViberApplication.isActivated())
    {
      this.e = 1;
      f();
    }
  }

  public void d()
  {
    if (!ViberApplication.isActivated())
    {
      this.e = 0;
      f();
    }
  }

  public void e()
  {
    this.e = 0;
    f();
  }

  public void onBadgeValueChanged(int paramInt1, int paramInt2)
  {
    if ((paramInt1 == -1) && (this.e != paramInt2))
    {
      this.e = paramInt2;
      f();
    }
  }

  private static abstract interface a
  {
    public abstract void a();
  }

  class b
    implements a.a
  {
    b()
    {
    }

    public void a()
    {
      try
      {
        c.a(a.a(a.this), a.b(a.this));
        return;
      }
      catch (Throwable localThrowable)
      {
      }
      catch (b localb)
      {
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.api.a
 * JD-Core Version:    0.6.2
 */