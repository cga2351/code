package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.util.cn;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class gr
  implements d<cn>
{
  private final Provider<Context> a;

  public gr(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static gr a(Provider<Context> paramProvider)
  {
    return new gr(paramProvider);
  }

  public static cn a(Context paramContext)
  {
    return (cn)h.a(go.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }

  public cn a()
  {
    return (cn)h.a(go.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.gr
 * JD-Core Version:    0.6.2
 */