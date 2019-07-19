package com.viber.voip;

import android.content.Context;
import dagger.a.d;
import javax.inject.Provider;

public final class bg
  implements d<bf>
{
  private final Provider<Context> a;

  public bg(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static bg a(Provider<Context> paramProvider)
  {
    return new bg(paramProvider);
  }

  public bf a()
  {
    return new bf((Context)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bg
 * JD-Core Version:    0.6.2
 */