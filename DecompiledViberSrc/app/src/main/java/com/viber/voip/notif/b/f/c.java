package com.viber.voip.notif.b.f;

import android.content.Context;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.d.m.a;

public abstract class c extends a
  implements m.a
{
  public c(com.viber.voip.notif.h.m paramm, e parame)
  {
    super(paramm, parame);
  }

  protected void a(Context paramContext, g paramg)
  {
    if (f())
    {
      if (g())
        a(paramg.a(this.a.c(), R_(), a()));
      com.viber.voip.notif.a.a.a[] arrayOfa = new com.viber.voip.notif.a.a.a[2];
      arrayOfa[0] = paramg.a(this.a, R_(), a());
      arrayOfa[1] = paramg.b(this.a.c(), R_(), a());
      a(arrayOfa);
    }
  }

  public CharSequence d(Context paramContext)
  {
    if (this.b != null)
      return this.b.d();
    return null;
  }

  public CharSequence f(Context paramContext)
  {
    return null;
  }

  public com.viber.voip.notif.d.m h(Context paramContext)
  {
    return com.viber.voip.notif.d.m.a(this, paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.c
 * JD-Core Version:    0.6.2
 */