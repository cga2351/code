package com.viber.voip.g.a;

import android.content.Context;
import com.viber.provider.b;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.storage.repository.p;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class dh
  implements d<p>
{
  private final Provider<b> a;
  private final Provider<Context> b;
  private final Provider<ab> c;

  public dh(Provider<b> paramProvider, Provider<Context> paramProvider1, Provider<ab> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static dh a(Provider<b> paramProvider, Provider<Context> paramProvider1, Provider<ab> paramProvider2)
  {
    return new dh(paramProvider, paramProvider1, paramProvider2);
  }

  public p a()
  {
    return (p)h.a(df.a(c.b(this.a), (Context)this.b.get(), (ab)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.dh
 * JD-Core Version:    0.6.2
 */