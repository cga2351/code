package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.voip.phone.call.CallHandler;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ba
  implements d<CallHandler>
{
  private final Provider<Engine> a;

  public ba(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ba a(Provider<Engine> paramProvider)
  {
    return new ba(paramProvider);
  }

  public static CallHandler a(Engine paramEngine)
  {
    return (CallHandler)h.a(az.a(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public CallHandler a()
  {
    return (CallHandler)h.a(az.a((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ba
 * JD-Core Version:    0.6.2
 */