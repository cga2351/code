package com.viber.voip.g.a;

import android.content.Context;
import com.viber.voip.sound.ISoundService;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fs
  implements d<ISoundService>
{
  private final Provider<Context> a;

  public fs(Provider<Context> paramProvider)
  {
    this.a = paramProvider;
  }

  public static fs a(Provider<Context> paramProvider)
  {
    return new fs(paramProvider);
  }

  public ISoundService a()
  {
    return (ISoundService)h.a(fq.a((Context)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fs
 * JD-Core Version:    0.6.2
 */