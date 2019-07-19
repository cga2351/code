package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.sound.tones.IRingtonePlayer;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fr
  implements d<IRingtonePlayer>
{
  private final Provider<Context> a;

  public fr(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static fr a(Provider<Context> paramProvider)
  {
    return new fr(paramProvider);
  }

  public IRingtonePlayer a()
  {
    return (IRingtonePlayer)h.a(fq.b((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fr
 * JD-Core Version:    0.6.2
 */