package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.util.dv;
import java.util.List;

final class l extends c
{
  private static final Logger d = ViberEnv.getLogger();

  public l(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.b = new f(new a(), 256);
    this.b.b(true);
  }

  protected void b()
  {
    List localList = this.b.a(dv.C.a(this.c));
    this.b.a(localList);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.b.c.a.l
 * JD-Core Version:    0.6.2
 */