package com.viber.voip.g.a;

import android.os.Handler;
import com.viber.voip.react.ReactContextManager;
import dagger.a.h;
import java.util.Map;
import javax.inject.Provider;

public final class fa
  implements dagger.a.d<ReactContextManager>
{
  private final Provider<Map<String, com.viber.voip.react.d>> a;
  private final Provider<Handler> b;

  public fa(Provider<Map<String, com.viber.voip.react.d>> paramProvider, Provider<Handler> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static fa a(Provider<Map<String, com.viber.voip.react.d>> paramProvider, Provider<Handler> paramProvider1)
  {
    return new fa(paramProvider, paramProvider1);
  }

  public ReactContextManager a()
  {
    return (ReactContextManager)h.a(ez.a((Map)this.a.get(), (Handler)this.b.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fa
 * JD-Core Version:    0.6.2
 */