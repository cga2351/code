package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.util.bx;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class aa
  implements d<bx>
{
  private final Provider<Context> a;

  public aa(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static aa a(Provider<Context> paramProvider)
  {
    return new aa(paramProvider);
  }

  public bx a()
  {
    return (bx)h.a(r.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.aa
 * JD-Core Version:    0.6.2
 */