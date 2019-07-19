package com.viber.voip.g.a;

import android.content.Context;
import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.ConversationsScreenScrollCdrController;
import com.viber.voip.i.c.b;
import com.viber.voip.messages.controller.GroupController;
import com.viber.voip.messages.controller.ai;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.bv;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ah;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.messages.controller.r;
import com.viber.voip.messages.d.b;
import com.viber.voip.q.i;
import javax.inject.Singleton;

public abstract class dj
{
  @Singleton
  static ConversationsScreenScrollCdrController a(Handler paramHandler1, Handler paramHandler2, dagger.a<z> parama, ICdrController paramICdrController, com.viber.voip.util.d paramd)
  {
    ConversationsScreenScrollCdrController localConversationsScreenScrollCdrController = new ConversationsScreenScrollCdrController(c.b.o, c.b.p, paramHandler1, paramHandler2, parama, paramICdrController);
    paramd.a(localConversationsScreenScrollCdrController, paramHandler2);
    return localConversationsScreenScrollCdrController;
  }

  static bs a(Context paramContext)
  {
    return new bs(paramContext);
  }

  static com.viber.voip.messages.controller.manager.k a(com.viber.voip.messages.k paramk)
  {
    return paramk.a();
  }

  static b a()
  {
    return com.viber.voip.messages.d.c.c();
  }

  static com.viber.voip.messages.controller.a b(com.viber.voip.messages.k paramk)
  {
    return paramk.z();
  }

  static bv b()
  {
    return o.a();
  }

  static ai c(com.viber.voip.messages.k paramk)
  {
    return paramk.c();
  }

  static o c()
  {
    return o.a();
  }

  @Singleton
  static ab d()
  {
    return ab.b();
  }

  static com.viber.voip.messages.controller.manager.c d(com.viber.voip.messages.k paramk)
  {
    return paramk.t();
  }

  static i e(com.viber.voip.messages.k paramk)
  {
    return paramk.m();
  }

  static com.viber.voip.u.d f(com.viber.voip.messages.k paramk)
  {
    return paramk.n();
  }

  static GroupController g(com.viber.voip.messages.k paramk)
  {
    return paramk.d();
  }

  static com.viber.voip.messages.controller.publicaccount.d h(com.viber.voip.messages.k paramk)
  {
    return paramk.h();
  }

  static com.viber.voip.messages.controller.a.a i(com.viber.voip.messages.k paramk)
  {
    return paramk.w();
  }

  static r j(com.viber.voip.messages.k paramk)
  {
    return paramk.y();
  }

  static com.viber.voip.invitelinks.d k(com.viber.voip.messages.k paramk)
  {
    return paramk.u();
  }

  static ah l(com.viber.voip.messages.k paramk)
  {
    return paramk.p();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dj
 * JD-Core Version:    0.6.2
 */