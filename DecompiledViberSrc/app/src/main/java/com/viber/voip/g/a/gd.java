package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.av.f;
import com.viber.voip.util.az;
import java.util.concurrent.ScheduledExecutorService;

public abstract class gd
{
  static Handler a()
  {
    return av.a(av.e.a);
  }

  static az a(Handler paramHandler1, Handler paramHandler2)
  {
    return new az(paramHandler1, paramHandler2);
  }

  static Handler b()
  {
    return av.a(av.e.d);
  }

  static Handler c()
  {
    return av.a(av.e.e);
  }

  static Handler d()
  {
    return av.a(av.e.f);
  }

  static Handler e()
  {
    return av.a(av.e.g);
  }

  static Handler f()
  {
    return av.a(av.e.i);
  }

  static Handler g()
  {
    return av.a(av.e.j);
  }

  static ScheduledExecutorService h()
  {
    return av.f.d;
  }

  static ScheduledExecutorService i()
  {
    return av.f.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gd
 * JD-Core Version:    0.6.2
 */