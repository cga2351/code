package com.viber.voip.gdpr.a;

import android.content.Context;
import dagger.a.d;
import javax.inject.Provider;

public final class b
  implements d<a>
{
  private final Provider<Context> a;

  public b(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static b a(Provider<Context> paramProvider)
  {
    return new b(paramProvider);
  }

  public a a()
  {
    return new a((Context)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.gdpr.a.b
 * JD-Core Version:    0.6.2
 */