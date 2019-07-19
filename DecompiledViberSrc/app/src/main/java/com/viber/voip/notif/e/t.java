package com.viber.voip.notif.e;

import android.content.Context;
import android.os.Handler;
import android.support.v4.util.CircularArray;
import com.viber.jni.Engine;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.at;
import com.viber.voip.notif.b.f.b.p;
import com.viber.voip.notif.i.k;
import com.viber.voip.registration.af;
import com.viber.voip.settings.d.ag;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.stickers.i;

public class t
{
  private final Context a;
  private final com.viber.voip.notif.d.j b;
  private final dagger.a<com.viber.voip.notif.f> c;
  private final dagger.a<com.viber.voip.notif.h.l> d;

  public t(Context paramContext, com.viber.voip.notif.d.j paramj, dagger.a<com.viber.voip.notif.h.l> parama, dagger.a<com.viber.voip.notif.f> parama1)
  {
    this.a = paramContext;
    this.b = paramj;
    this.c = parama1;
    this.d = parama;
  }

  public b a(Engine paramEngine, com.viber.voip.util.d paramd)
  {
    return new b(this.a, paramEngine, this.b, this.c, paramd);
  }

  public h a(Handler paramHandler, dagger.a<ab> parama, k paramk, com.viber.voip.notif.i.l paraml, dagger.a<com.viber.voip.messages.d.b> parama1, p paramp)
  {
    com.viber.voip.notif.h.e locale = new com.viber.voip.notif.h.e(this.d);
    com.viber.voip.notif.g.e locale1 = new com.viber.voip.notif.g.e();
    return new h(this.a, this.b, locale, parama, paramHandler, this.c, paramk, paraml, new com.viber.voip.notif.g.a(this.a, paramp, parama1), locale1);
  }

  public m a(Handler paramHandler, dagger.a<IRingtonePlayer> parama, com.viber.voip.notif.i.l paraml, dagger.a<at> parama1)
  {
    return new m(this.a, this.b, this.c, paramHandler, parama, paraml, parama1);
  }

  public n a(Handler paramHandler, dagger.a<ak> parama, dagger.a<ab> parama1, com.viber.voip.notif.i.l paraml, k paramk)
  {
    com.viber.voip.notif.g.b localb = new com.viber.voip.notif.g.b();
    com.viber.voip.notif.h.f localf = new com.viber.voip.notif.h.f(parama1, parama, this.d);
    return new n(this.a, this.b, this.c, paramHandler, localb, localf, paramk, parama1, paraml);
  }

  public s a(Handler paramHandler, dagger.a<com.viber.voip.contacts.c.d.m> parama, dagger.a<com.viber.voip.messages.d.b> parama1, dagger.a<ak> parama2, dagger.a<al> parama3, dagger.a<ab> parama4, af paramaf, com.viber.voip.notif.i.l paraml, i parami, k paramk, p paramp, com.viber.voip.c.g paramg)
  {
    com.viber.voip.notif.i.e locale = new com.viber.voip.notif.i.e(this.a);
    com.viber.voip.notif.i.m localm = new com.viber.voip.notif.i.m(parami, paramHandler);
    com.viber.voip.notif.i.d locald = new com.viber.voip.notif.i.d();
    com.viber.voip.notif.i.c localc = new com.viber.voip.notif.i.c();
    com.viber.voip.notif.i.b localb = new com.viber.voip.notif.i.b(parama4, paramHandler);
    CircularArray localCircularArray = new CircularArray(3);
    localCircularArray.addLast(new com.viber.voip.notif.g.g(this.a, parama2, parama4, parama, parama1, paramaf, paramp));
    localCircularArray.addLast(new com.viber.voip.notif.g.c(this.a, parama2, locale, localm, locald, paramp));
    localCircularArray.addLast(new com.viber.voip.notif.g.d(parama4));
    com.viber.voip.notif.g.e locale1 = new com.viber.voip.notif.g.e();
    com.viber.voip.notif.h.j localj = new com.viber.voip.notif.h.j(parama4, parama2, parama3, this.d);
    return new s(this.a, this.b, this.c, paramHandler, localCircularArray, locale1, localj, paramk, parama4, paraml, locale, localm, locald, localb, localc, paramg);
  }

  public u a(Engine paramEngine, Handler paramHandler)
  {
    return new u(this.a, paramEngine, paramHandler, d.ag.e, this.b, this.c);
  }

  public v a()
  {
    return new v(this.a, this.b, this.c);
  }

  public a b()
  {
    return new a(this.a, this.b, this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.notif.e.t
 * JD-Core Version:    0.6.2
 */