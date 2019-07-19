package com.viber.voip.g.a;

import android.content.Context;
import com.viber.provider.b;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bt
  implements d<b>
{
  private final Provider<Context> a;

  public bt(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bt a(Provider<Context> paramProvider)
  {
    return new bt(paramProvider);
  }

  public b a()
  {
    return (b)h.a(bq.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bt
 * JD-Core Version:    0.6.2
 */