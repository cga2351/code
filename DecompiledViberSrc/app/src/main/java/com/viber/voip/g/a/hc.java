package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.voip.user.UserManager;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class hc
  implements d<UserManager>
{
  private final Provider<Engine> a;

  public hc(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static hc a(Provider<Engine> paramProvider)
  {
    return new hc(paramProvider);
  }

  public static UserManager a(Engine paramEngine)
  {
    return (UserManager)h.a(gv.a(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public UserManager a()
  {
    return (UserManager)h.a(gv.a((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.hc
 * JD-Core Version:    0.6.2
 */