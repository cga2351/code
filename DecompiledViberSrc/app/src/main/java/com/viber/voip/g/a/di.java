package com.viber.voip.g.a;

import com.google.d.f;
import com.viber.voip.messages.controller.manager.o;
import com.viber.voip.messages.controller.manager.z;
import com.viber.voip.storage.repository.u;
import dagger.a;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class di
  implements d<u>
{
  private final Provider<z> a;
  private final Provider<o> b;
  private final Provider<f> c;

  public di(Provider<z> paramProvider, Provider<o> paramProvider1, Provider<f> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static di a(Provider<z> paramProvider, Provider<o> paramProvider1, Provider<f> paramProvider2)
  {
    return new di(paramProvider, paramProvider1, paramProvider2);
  }

  public static u a(z paramz, a<o> parama, f paramf)
  {
    return (u)h.a(df.a(paramz, parama, paramf), "Cannot return null from a non-@Nullable @Provides method");
  }

  public u a()
  {
    return (u)h.a(df.a((z)this.a.get(), c.b(this.b), (f)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.di
 * JD-Core Version:    0.6.2
 */