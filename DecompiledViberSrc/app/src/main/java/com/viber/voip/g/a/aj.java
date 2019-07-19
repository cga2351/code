package com.viber.voip.g.a;

import android.app.KeyguardManager;
import android.content.Context;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class aj
  implements d<KeyguardManager>
{
  private final Provider<Context> a;

  public aj(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static aj a(Provider<Context> paramProvider)
  {
    return new aj(paramProvider);
  }

  public KeyguardManager a()
  {
    return (KeyguardManager)h.a(ag.b((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.aj
 * JD-Core Version:    0.6.2
 */