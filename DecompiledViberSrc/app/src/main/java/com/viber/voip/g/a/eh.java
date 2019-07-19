package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.util.cj;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class eh
  implements d<cj>
{
  private final Provider<Context> a;

  public eh(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static eh a(Provider<Context> paramProvider)
  {
    return new eh(paramProvider);
  }

  public static cj a(Context paramContext)
  {
    return (cj)h.a(ec.a(paramContext), "Cannot return null from a non-@Nullable @Provides method");
  }

  public cj a()
  {
    return (cj)h.a(ec.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.eh
 * JD-Core Version:    0.6.2
 */