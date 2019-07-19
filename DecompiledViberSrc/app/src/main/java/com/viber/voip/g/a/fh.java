package com.viber.voip.g.a;

import com.viber.jni.Engine;
import com.viber.jni.secure.TrustPeerController;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class fh
  implements d<TrustPeerController>
{
  private final Provider<Engine> a;

  public static TrustPeerController a(Engine paramEngine)
  {
    return (TrustPeerController)h.a(fg.a(paramEngine), "Cannot return null from a non-@Nullable @Provides method");
  }

  public TrustPeerController a()
  {
    return (TrustPeerController)h.a(fg.a((Engine)this.a.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.fh
 * JD-Core Version:    0.6.2
 */