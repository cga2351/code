package com.viber.voip.g.a;

import com.viber.voip.messages.k;
import com.viber.voip.q.i;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class ea
  implements d<i>
{
  private final Provider<k> a;

  public static i a(k paramk)
  {
    return (i)h.a(dj.e(paramk), "Cannot return null from a non-@Nullable @Provides method");
  }

  public i a()
  {
    return (i)h.a(dj.e((k)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.ea
 * JD-Core Version:    0.6.2
 */