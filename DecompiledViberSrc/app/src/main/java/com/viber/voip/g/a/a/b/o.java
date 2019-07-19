package com.viber.voip.g.a.a.b;

import android.content.Context;
import com.viber.provider.b;
import com.viber.voip.storage.repository.r;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class o
  implements d<r>
{
  private final Provider<b> a;
  private final Provider<Context> b;

  public o(Provider<b> paramProvider, Provider<Context> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static o a(Provider<b> paramProvider, Provider<Context> paramProvider1)
  {
    return new o(paramProvider, paramProvider1);
  }

  public r a()
  {
    return (r)h.a(n.a(c.b(this.a), (Context)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.o
 * JD-Core Version:    0.6.2
 */