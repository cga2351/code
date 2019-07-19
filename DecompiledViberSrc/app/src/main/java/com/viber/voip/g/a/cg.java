package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.controller.PhoneController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cg
  implements d<PhoneController>
{
  private final Provider<Engine> a;

  public cg(Provider<Engine> paramProvider)
  {
    this.a = paramProvider;
  }

  public static PhoneController a(Engine paramEngine)
  {
    return (PhoneController)h.a(ca.d(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static cg a(Provider<Engine> paramProvider)
  {
    return new cg(paramProvider);
  }

  public PhoneController a()
  {
    return (PhoneController)h.a(ca.d((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cg
 * JD-Core Version:    0.6.2
 */