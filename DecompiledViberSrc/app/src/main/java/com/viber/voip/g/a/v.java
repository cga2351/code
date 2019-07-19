package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.cdr.ICdrController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class v
  implements d<ICdrController>
{
  private final Provider<Engine> a;

  public v(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static ICdrController a(Engine paramEngine)
  {
    return (ICdrController)h.a(r.a(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static v a(Provider<Engine> paramProvider)
  {
    return new v(paramProvider);
  }

  public ICdrController a()
  {
    return (ICdrController)h.a(r.a((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.v
 * JD-Core Version:    0.6.2
 */