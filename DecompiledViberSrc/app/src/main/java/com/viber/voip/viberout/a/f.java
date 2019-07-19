package com.viber.voip.viberout.a;

import android.os.Handler;
import com.viber.jni.viberout.ViberOutBalanceListener;
import dagger.a.d;
import javax.inject.Provider;

public final class f
  implements d<e>
{
  private final Provider<ViberOutBalanceListener> a;
  private final Provider<Handler> b;

  public f(Provider<ViberOutBalanceListener> paramProvider, Provider<Handler> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static f a(Provider<ViberOutBalanceListener> paramProvider, Provider<Handler> paramProvider1)
  {
    return new f(paramProvider, paramProvider1);
  }

  public e a()
  {
    return new e((ViberOutBalanceListener)this.a.get(), (Handler)this.b.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.a.f
 * JD-Core Version:    0.6.2
 */