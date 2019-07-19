package com.viber.voip.notif.b.f.b;

import android.content.Context;
import com.viber.voip.messages.d.b;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.model.entity.MessageEntity;
import dagger.a;

public class p
{
  private final a<aj> a;
  private final a<ai> b;
  private final a<b> c;
  private final q d;

  public p(a<aj> parama, a<ai> parama1, a<b> parama2, q paramq)
  {
    this.a = parama;
    this.b = parama1;
    this.c = parama2;
    this.d = paramq;
  }

  private boolean a(com.viber.voip.notif.h.m paramm)
  {
    switch (paramm.c().getMimeType())
    {
    default:
      return false;
    case 7:
    case 8:
    case 9:
    }
    return true;
  }

  public g a(Context paramContext, com.viber.voip.notif.h.d paramd)
  {
    return new c(paramContext, paramd, this.c);
  }

  public g a(Context paramContext, com.viber.voip.notif.h.m paramm, boolean paramBoolean)
  {
    com.viber.voip.model.entity.h localh = paramm.e();
    MessageEntity localMessageEntity = paramm.c();
    boolean bool1 = localh.b();
    int i = localMessageEntity.getMimeType();
    if ((paramBoolean) && (i == 0))
    {
      if (localMessageEntity.isPinMessage())
      {
        if (bool1);
        for (Object localObject2 = new j(this.b, this.c); ; localObject2 = new u())
          return new v(paramContext, paramm, this.a, (h)localObject2);
      }
      if (localMessageEntity.isPoll())
        return new w(paramContext, paramm, this.a, new d());
      if (bool1)
        return new l(paramContext, paramm, this.a, new m(this.b, this.c));
      return new t(paramContext, paramm, this.a, new d());
    }
    if ((paramBoolean) && ((1 == i) || (3 == i) || (1005 == i)))
    {
      if (bool1)
        return new i(paramContext, paramm, this.d.a(i), this.a, new d());
      return new r(paramContext, paramm, this.d.a(i), this.a, new d());
    }
    boolean bool2 = paramm.c().isGifUrlMessage();
    if ((paramBoolean) && (a(paramm)) && (!bool2))
    {
      if (bool1)
      {
        if (paramm.c().isUrlMessage());
        for (Object localObject1 = new n(new x(), this.b, this.c); ; localObject1 = new f(new x()))
          return new l(paramContext, paramm, this.a, (h)localObject1);
      }
      return new t(paramContext, paramm, this.a, new f(new x()));
    }
    if (bool2);
    for (int j = 1005; bool1; j = paramm.c().getMimeType())
      return new k(paramContext, paramm, this.d.a(j), this.a, new d());
    return new s(paramContext, paramm, this.d.a(j), this.a, new d());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.b.f.b.p
 * JD-Core Version:    0.6.2
 */