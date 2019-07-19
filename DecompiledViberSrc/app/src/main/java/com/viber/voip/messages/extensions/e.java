package com.viber.voip.messages.extensions;

import com.viber.voip.ap.a;
import com.viber.voip.messages.controller.manager.o;
import dagger.a.d;
import javax.inject.Provider;

public final class e
  implements d<c>
{
  private final Provider<ap.a> a;
  private final Provider<f> b;
  private final Provider<i> c;
  private final Provider<o> d;

  public e(Provider<ap.a> paramProvider, Provider<f> paramProvider1, Provider<i> paramProvider2, Provider<o> paramProvider3)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
    this.d = paramProvider3;
  }

  public static e a(Provider<ap.a> paramProvider, Provider<f> paramProvider1, Provider<i> paramProvider2, Provider<o> paramProvider3)
  {
    return new e(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public c a()
  {
    return new c(dagger.a.c.b(this.a), dagger.a.c.b(this.b), (i)this.c.get(), dagger.a.c.b(this.d));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.e
 * JD-Core Version:    0.6.2
 */