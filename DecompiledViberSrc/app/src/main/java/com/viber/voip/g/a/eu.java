package com.viber.voip.g.a;

import android.content.Context;
import com.viber.common.permission.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class eu
  implements d<c>
{
  private final Provider<Context> a;

  public eu(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static eu a(Provider<Context> paramProvider)
  {
    return new eu(paramProvider);
  }

  public c a()
  {
    return (c)h.a(et.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.eu
 * JD-Core Version:    0.6.2
 */