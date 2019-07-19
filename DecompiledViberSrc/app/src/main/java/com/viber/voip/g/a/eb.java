package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.jni.cdr.ICdrController;
import com.viber.jni.cdr.entity.ConversationsScreenScrollCdrController;
import com.viber.voip.messages.controller.manager.z;
import dagger.a.c;
import dagger.a.h;
import javax.inject.Provider;

public final class eb
  implements dagger.a.d<ConversationsScreenScrollCdrController>
{
  private final Provider<Handler> a;
  private final Provider<Handler> b;
  private final Provider<z> c;
  private final Provider<ICdrController> d;
  private final Provider<com.viber.voip.util.d> e;

  public eb(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<z> paramProvider, Provider<ICdrController> paramProvider3, Provider<com.viber.voip.util.d> paramProvider4)
  {
    this.a = paramProvider1;
    this.b = paramProvider2;
    this.c = paramProvider;
    this.d = paramProvider3;
    this.e = paramProvider4;
  }

  public static eb a(Provider<Handler> paramProvider1, Provider<Handler> paramProvider2, Provider<z> paramProvider, Provider<ICdrController> paramProvider3, Provider<com.viber.voip.util.d> paramProvider4)
  {
    return new eb(paramProvider1, paramProvider2, paramProvider, paramProvider3, paramProvider4);
  }

  public ConversationsScreenScrollCdrController a()
  {
    return (ConversationsScreenScrollCdrController)h.a(dj.a((Handler)this.a.get(), (Handler)this.b.get(), c.b(this.c), (ICdrController)this.d.get(), (com.viber.voip.util.d)this.e.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.eb
 * JD-Core Version:    0.6.2
 */