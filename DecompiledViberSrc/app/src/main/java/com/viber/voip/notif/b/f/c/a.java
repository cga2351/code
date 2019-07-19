package com.viber.voip.notif.b.f.c;

import android.content.Context;
import com.viber.voip.R.string;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.d.g.a;
import com.viber.voip.notif.d.g.b;
import com.viber.voip.notif.d.l;
import com.viber.voip.notif.h.b;
import com.viber.voip.notif.h.m;

public class a extends com.viber.voip.notif.b.f.a
  implements g.a
{
  private final com.viber.voip.notif.b.f.b.o h;
  private final b i;

  public a(b paramb, e parame, com.viber.voip.notif.b.f.b.o paramo)
  {
    super(paramb, parame);
    this.i = paramb;
    this.h = paramo;
  }

  protected void a(Context paramContext, com.viber.voip.notif.a.g paramg)
  {
    if (this.a.k() == 1);
    for (int j = 1; ; j = 0)
    {
      if ((j != 0) && (f()))
      {
        if (g())
          a(paramg.a(this.a.c(), R_(), a()));
        com.viber.voip.notif.a.a.a[] arrayOfa = new com.viber.voip.notif.a.a.a[2];
        arrayOfa[0] = paramg.a(this.a, R_(), a());
        arrayOfa[1] = paramg.b(this.a.c(), R_(), a());
        a(arrayOfa);
      }
      return;
    }
  }

  protected void a(Context paramContext, com.viber.voip.notif.c.o paramo)
  {
    super.a(paramContext, paramo);
    a(paramo.a(String.valueOf(this.a.j())));
    if (this.a.k() > 1)
      a(paramo.a(false));
  }

  public void a(Context paramContext, g.b paramb)
  {
    int j = 0;
    int k = this.i.a();
    while (j < k)
    {
      paramb.a(this.h.a(this.i.a(j)).b());
      j++;
    }
  }

  public CharSequence d(Context paramContext)
  {
    return paramContext.getString(R.string.app_name);
  }

  public l g(Context paramContext)
  {
    return com.viber.voip.notif.d.g.a(this, paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c.a
 * JD-Core Version:    0.6.2
 */