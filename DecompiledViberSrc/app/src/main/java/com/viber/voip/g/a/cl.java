package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.contacts.c.d.n;
import com.viber.voip.contacts.c.f.b.f;
import com.viber.voip.i.c.c;
import com.viber.voip.i.c.i;
import com.viber.voip.i.c.j;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.settings.d.at;
import com.viber.voip.settings.d.bf;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.r;
import com.viber.voip.settings.d.t;
import com.viber.voip.settings.d.v;
import com.viber.voip.util.d;
import javax.inject.Singleton;
import org.greenrobot.eventbus.EventBus;

public abstract class cl
{
  @Singleton
  static com.viber.voip.engagement.a a(EventBus paramEventBus, f paramf, n paramn, CallHandler paramCallHandler, Handler paramHandler)
  {
    return new com.viber.voip.engagement.a(paramf, paramEventBus, paramn, paramCallHandler, paramHandler, c.i.b, d.at.c, d.t.g, d.t.h, d.t.i, d.r.h, d.t.j, cm.a);
  }

  @Singleton
  static com.viber.voip.r.a a(Handler paramHandler, d paramd, dagger.a<com.viber.voip.engagement.a> parama)
  {
    return new com.viber.voip.r.a(paramHandler, paramd, parama, d.f.a, d.v.h, d.bf.m, d.at.a, d.at.b, d.at.c, d.at.d, c.c.b, c.j.c, c.i.b);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cl
 * JD-Core Version:    0.6.2
 */