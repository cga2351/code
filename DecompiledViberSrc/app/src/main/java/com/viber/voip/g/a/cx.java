package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.util.e.g;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cx
  implements d<g>
{
  private final Provider<Context> a;

  public cx(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static cx a(Provider<Context> paramProvider)
  {
    return new cx(paramProvider);
  }

  public g a()
  {
    return (g)h.a(ct.b((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cx
 * JD-Core Version:    0.6.2
 */