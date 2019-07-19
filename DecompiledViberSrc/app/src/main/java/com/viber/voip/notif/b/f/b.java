package com.viber.voip.notif.b.f;

import android.content.Context;
import com.viber.voip.notif.a.g;
import com.viber.voip.notif.b.f.b.e;
import com.viber.voip.notif.d.f;
import com.viber.voip.notif.d.f.a;
import com.viber.voip.notif.d.f.b;
import com.viber.voip.notif.h.m;
import com.viber.voip.util.da;

public abstract class b extends a
  implements f.b
{
  public b(m paramm, e parame)
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

  public f d(Context paramContext)
  {
    return f.a(new f.b()
    {
      public f.a a(Context paramAnonymousContext)
      {
        if ((b.this.b != null) && (b.this.b.e()))
          return b.this.a(paramAnonymousContext);
        return null;
      }

      public CharSequence f(Context paramAnonymousContext)
      {
        return b.this.f(paramAnonymousContext);
      }
    }
    , paramContext);
  }

  public CharSequence f(Context paramContext)
  {
    if ((this.b != null) && (!da.a(this.b.d())))
      return this.b.d();
    return b(paramContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b
 * JD-Core Version:    0.6.2
 */