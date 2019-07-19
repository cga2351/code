package com.viber.voip.g.a.a.b;

import android.content.Context;
import dagger.a.h;
import javax.inject.Provider;

public final class r
  implements dagger.a.d<com.viber.voip.vln.d>
{
  private final Provider<Context> a;

  public static com.viber.voip.vln.d a(Context paramContext)
  {
    return (com.viber.voip.vln.d)h.a(p.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }

  public com.viber.voip.vln.d a()
  {
    return (com.viber.voip.vln.d)h.a(p.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.b.r
 * JD-Core Version:    0.6.2
 */