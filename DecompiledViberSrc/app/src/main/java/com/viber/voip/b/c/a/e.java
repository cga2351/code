package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.b.c.a.a.h;
import com.viber.voip.b.c.a.a.i;
import com.viber.voip.util.dv;
import java.util.List;

public class e extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public e(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.b = new f(new i(new h(new g(new a()), 3600000L)));
    this.b.a(true);
  }

  protected void b()
  {
    List localList = this.b.a(dv.a.a(this.c));
    this.b.a(localList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.e
 * JD-Core Version:    0.6.2
 */