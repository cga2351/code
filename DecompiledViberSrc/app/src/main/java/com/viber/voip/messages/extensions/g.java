package com.viber.voip.messages.extensions;

import com.viber.voip.util.i.e;
import dagger.a.d;
import javax.inject.Provider;

public final class g
  implements d<f>
{
  private final Provider<e> a;

  public g(Provider<e> paramProvider)
  {
    this.a = paramProvider;
  }

  public static g a(Provider<e> paramProvider)
  {
    return new g(paramProvider);
  }

  public f a()
  {
    return new f((e)this.a.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extensions.g
 * JD-Core Version:    0.6.2
 */