package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.im2.Im2Exchanger;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ce
  implements d<Im2Exchanger>
{
  private final Provider<Engine> a;

  public ce(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static Im2Exchanger a(Engine paramEngine)
  {
    return (Im2Exchanger)h.a(ca.c(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static ce a(Provider<Engine> paramProvider)
  {
    return new ce(paramProvider);
  }

  public Im2Exchanger a()
  {
    return (Im2Exchanger)h.a(ca.c((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ce
 * JD-Core Version:    0.6.2
 */