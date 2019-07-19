package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.util.e.e;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class cw
  implements d<e>
{
  private final Provider<Context> a;

  public cw(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static cw a(Provider<Context> paramProvider)
  {
    return new cw(paramProvider);
  }

  public e a()
  {
    return (e)h.a(ct.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.cw
 * JD-Core Version:    0.6.2
 */