package com.viber.voip.notif.g;

import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.model.entity.MessageEntity;
import com.viber.voip.notif.b.f.e.c;
import com.viber.voip.notif.h.b;
import com.viber.voip.notif.h.m;

public class d
  implements f
{
  private final dagger.a<ab> a;

  public d(dagger.a<ab> parama)
  {
    this.a = parama;
  }

  public boolean a(m paramm)
  {
    return (2 == paramm.i()) && (1002 == paramm.c().getMimeType());
  }

  public com.viber.voip.notif.d.e b(b paramb, e parame)
  {
    if (!a(paramb))
      return null;
    if (paramb.k() == 1)
      return b(paramb, parame);
    return new com.viber.voip.notif.b.f.e.a(paramb);
  }

  public com.viber.voip.notif.d.e b(m paramm, e parame)
  {
    if (!a(paramm))
      return null;
    return new c(paramm, this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.g.d
 * JD-Core Version:    0.6.2
 */