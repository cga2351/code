package com.viber.voip.g.a;

import com.viber.voip.api.a.a.a;
import com.viber.voip.report.a.b;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fc
  implements d<b>
{
  private final Provider<a> a;

  public fc(Provider<a> paramProvider)
  {
    this.a = paramProvider;
  }

  public static fc a(Provider<a> paramProvider)
  {
    return new fc(paramProvider);
  }

  public b a()
  {
    return (b)h.a(fb.a((a)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fc
 * JD-Core Version:    0.6.2
 */