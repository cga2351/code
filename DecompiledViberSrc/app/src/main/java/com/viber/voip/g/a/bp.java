package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.contacts.c.f.b.f;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class bp
  implements d<f>
{
  private final Provider<Context> a;

  public bp(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bp a(Provider<Context> paramProvider)
  {
    return new bp(paramProvider);
  }

  public f a()
  {
    return (f)h.a(bk.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.bp
 * JD-Core Version:    0.6.2
 */