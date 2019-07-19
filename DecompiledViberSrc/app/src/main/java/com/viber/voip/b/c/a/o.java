package com.viber.voip.b.c.a;

import android.content.Context;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.b.c.a.a.a;
import com.viber.voip.b.c.a.a.g;
import com.viber.voip.b.c.a.a.h;
import com.viber.voip.util.dv;
import java.util.Arrays;
import java.util.List;

public class o extends c
{
  private static final Logger d = ViberEnv.getLogger();
  private static final String[] e = arrayOfString;

  static
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = dv.j.a();
  }

  public o(Context paramContext)
  {
    super(paramContext);
  }

  public void a()
  {
    this.b = new f(new h(new g(new com.viber.voip.b.c.a.a.f(new a(), Arrays.asList(e), null, null)), 1209600000L));
    this.b.b(false);
  }

  protected void b()
  {
    if (this.a);
    List localList;
    do
    {
      return;
      localList = this.b.a(dv.g.a(this.c));
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
 * Qualified Name:     com.viber.voip.b.c.a.o
 * JD-Core Version:    0.6.2
 */