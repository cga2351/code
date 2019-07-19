package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.b.c.a.a.h;
import com.viber.voip.util.dv;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class i extends c
{
  protected static final Logger d = ViberEnv.getLogger();
  public static final long e = TimeUnit.DAYS.toMillis(60L);

  public i(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.b = new f(new h(new g(new a()), e), 256);
  }

  protected void b()
  {
    if (this.a);
    List localList;
    do
    {
      return;
      localList = this.b.a(dv.u.a(this.c));
    }
    while (this.a);
    this.b.a(localList);
  }

  public void d()
  {
    this.a = true;
    if (this.b != null)
      this.b.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.i
 * JD-Core Version:    0.6.2
 */