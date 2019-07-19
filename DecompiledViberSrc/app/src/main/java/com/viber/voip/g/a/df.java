package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.google.d.f;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.notif.g;
import com.viber.voip.storage.a.e;
import com.viber.voip.storage.a.i;
import com.viber.voip.storage.repository.p;
import com.viber.voip.storage.repository.t;
import com.viber.voip.storage.repository.u;
import javax.inject.Singleton;

public abstract class df
{
  @Singleton
  static i a(p paramp, u paramu, com.viber.voip.analytics.story.g.a parama, dagger.a<g> parama1, Handler paramHandler1, Handler paramHandler2)
  {
    com.viber.voip.storage.a.b localb = new com.viber.voip.storage.a.b(null);
    return new i(new e(paramp, paramu, new com.viber.voip.util.i.a(), parama, localb), paramHandler1, paramHandler2);
  }

  static p a(dagger.a<com.viber.provider.b> parama, Context paramContext, ab paramab)
  {
    return new p(new t(parama), new com.viber.voip.storage.repository.o(paramContext), paramab);
  }

  static u a(z paramz, dagger.a<com.viber.voip.messages.controller.manager.o> parama, f paramf)
  {
    return new u(paramz, parama, paramf);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.df
 * JD-Core Version:    0.6.2
 */