package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.backup.auto.a;
import com.viber.voip.backup.g;
import com.viber.voip.util.cj;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class am
  implements d<a>
{
  private final Provider<Context> a;
  private final Provider<g> b;
  private final Provider<cj> c;

  public am(Provider<Context> paramProvider, Provider<g> paramProvider1, Provider<cj> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static am a(Provider<Context> paramProvider, Provider<g> paramProvider1, Provider<cj> paramProvider2)
  {
    return new am(paramProvider, paramProvider1, paramProvider2);
  }

  public a a()
  {
    return (a)h.a(al.a((Context)this.a.get(), (g)this.b.get(), (cj)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.am
 * JD-Core Version:    0.6.2
 */