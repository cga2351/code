package com.viber.voip.g.a;

import android.content.Context;
import com.viber.jni.Engine;
import com.viber.voip.backup.c;
import com.viber.voip.backup.g;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class an
  implements d<c>
{
  private final Provider<Context> a;
  private final Provider<Engine> b;
  private final Provider<g> c;

  public an(Provider<Context> paramProvider, Provider<Engine> paramProvider1, Provider<g> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static an a(Provider<Context> paramProvider, Provider<Engine> paramProvider1, Provider<g> paramProvider2)
  {
    return new an(paramProvider, paramProvider1, paramProvider2);
  }

  public c a()
  {
    return (c)h.a(al.a((Context)this.a.get(), (Engine)this.b.get(), (g)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.an
 * JD-Core Version:    0.6.2
 */