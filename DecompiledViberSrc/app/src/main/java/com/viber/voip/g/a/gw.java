package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.voip.user.OnlineUserActivityHelper;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gw
  implements d<OnlineUserActivityHelper>
{
  private final Provider<Engine> a;

  public static OnlineUserActivityHelper a(Engine paramEngine)
  {
    return (OnlineUserActivityHelper)h.a(gv.b(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public OnlineUserActivityHelper a()
  {
    return (OnlineUserActivityHelper)h.a(gv.b((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gw
 * JD-Core Version:    0.6.2
 */