package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.voip.ViberApplication;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cd
  implements d<Engine>
{
  private final Provider<ViberApplication> a;

  public cd(Provider<ViberApplication> paramProvider)
  {
    this.a = paramProvider;
  }

  public static Engine a(ViberApplication paramViberApplication)
  {
    return (Engine)h.a(ca.a(paramViberApplication), "Cannot return null from a non-@Nullable @Provides method");
  }

  public static cd a(Provider<ViberApplication> paramProvider)
  {
    return new cd(paramProvider);
  }

  public Engine a()
  {
    return (Engine)h.a(ca.a((ViberApplication)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cd
 * JD-Core Version:    0.6.2
 */