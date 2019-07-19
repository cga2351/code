package com.viber.voip.notif.g;

import android.content.Context;
import android.support.v4.util.CircularArray;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.c.i;
import com.viber.voip.notif.b.f.c.j;
import com.viber.voip.notif.b.f.c.k;
import com.viber.voip.notif.b.f.c.l;
import com.viber.voip.notif.b.f.c.n;
import com.viber.voip.notif.b.f.c.q;
import com.viber.voip.notif.d.d.a;

public class c
  implements f
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final dagger.a<ak> c;
  private final com.viber.voip.notif.a d;
  private final com.viber.voip.notif.i.e e;
  private final com.viber.voip.notif.i.m f;
  private final com.viber.voip.notif.i.d g;
  private final com.viber.voip.notif.b.f.b.p h;

  public c(Context paramContext, dagger.a<ak> parama, com.viber.voip.notif.i.e parame, com.viber.voip.notif.i.m paramm, com.viber.voip.notif.i.d paramd, com.viber.voip.notif.b.f.b.p paramp)
  {
    this.b = paramContext;
    this.c = parama;
    this.d = new com.viber.voip.notif.a(paramContext);
    this.e = parame;
    this.f = paramm;
    this.g = paramd;
    this.h = paramp;
  }

  private CircularArray<d.a> a(CircularArray<com.viber.voip.notif.h.b> paramCircularArray, e parame)
  {
    int i = paramCircularArray.size();
    CircularArray localCircularArray = new CircularArray(i);
    int j = 0;
    if (j < i)
    {
      com.viber.voip.notif.h.b localb = (com.viber.voip.notif.h.b)paramCircularArray.get(j);
      if (localb.k() > 1);
      label109: 
      while (true)
      {
        j++;
        break;
        if (localb.j() == 1);
        for (com.viber.voip.notif.d.c localc = a(localb, parame); ; localc = a(localb, parame))
        {
          if (localc == null)
            break label109;
          localCircularArray.addLast(new d.a(localc, (int)localb.e().getId()));
          break;
        }
      }
    }
    return localCircularArray;
  }

  private com.viber.voip.notif.b.f.b.e a(com.viber.voip.notif.h.m paramm, boolean paramBoolean)
  {
    return this.h.a(this.b, paramm, paramBoolean).a(paramBoolean);
  }

  private boolean b(com.viber.voip.notif.h.m paramm)
  {
    return (4 == paramm.i()) || (paramm.c().isUnsent());
  }

  public com.viber.voip.notif.d.c a(com.viber.voip.notif.h.b paramb, e parame)
  {
    if (b(paramb))
      return a(paramb, parame);
    if (!a(paramb))
      return null;
    if ((paramb.k() == 1) && (parame.a(paramb)))
      return new l(paramb);
    if ((paramb.k() == 1) && (paramb.h()))
      return new k(paramb);
    final boolean bool = parame.a();
    com.viber.voip.notif.b.f.b.o local1 = new com.viber.voip.notif.b.f.b.o()
    {
      public com.viber.voip.notif.b.f.b.e a(com.viber.voip.notif.h.m paramAnonymousm)
      {
        return c.a(c.this, paramAnonymousm, bool);
      }
    };
    if (paramb.k() > 1)
    {
      CircularArray localCircularArray = a(paramb.b(), parame);
      if (localCircularArray.size() < 2);
      return new com.viber.voip.notif.d.d(new com.viber.voip.notif.b.f.c.b(paramb, local1), localCircularArray, "bundled_message_group", com.viber.voip.notif.c.d);
    }
    return new com.viber.voip.notif.b.f.c.a(paramb, a(paramb, bool), local1);
  }

  public com.viber.voip.notif.d.c a(com.viber.voip.notif.h.m paramm, e parame)
  {
    if (!a(paramm))
      return null;
    if (4 == paramm.i())
      return new com.viber.voip.notif.b.f.c.f(paramm);
    if (paramm.c().isUnsent())
      return new com.viber.voip.notif.b.f.c.o(paramm, this.c);
    if (parame.a(paramm))
      return new l(paramm);
    if (paramm.h())
      return new k(paramm);
    com.viber.voip.notif.b.f.b.e locale = a(paramm, parame.a());
    switch (paramm.c().getMimeType())
    {
    default:
      return new n(paramm, locale);
    case 0:
      return new n(paramm, locale);
    case 4:
      return new com.viber.voip.notif.b.f.c.m(paramm, locale, this.f);
    case 5:
      return new com.viber.voip.notif.b.f.c.h(paramm, locale, this.g, this.d);
    case 1:
      return new com.viber.voip.notif.b.f.c.g(paramm, locale, this.e);
    case 1005:
      return new com.viber.voip.notif.b.f.c.e(paramm, locale);
    case 10:
      return new com.viber.voip.notif.b.f.c.c(paramm, locale);
    case 3:
      return new com.viber.voip.notif.b.f.c.p(paramm, locale);
    case 2:
    case 1009:
      return new i(paramm, locale);
    case 14:
    case 1010:
      return new q(paramm, locale);
    case 1006:
    }
    return new j(paramm, locale);
  }

  public boolean a(com.viber.voip.notif.h.m paramm)
  {
    return (3 == paramm.i()) || (4 == paramm.i());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.g.c
 * JD-Core Version:    0.6.2
 */