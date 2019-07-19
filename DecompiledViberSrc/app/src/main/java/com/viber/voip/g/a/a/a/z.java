package com.viber.voip.g.a.a.a;

import com.viber.voip.invitelinks.f;
import com.viber.voip.messages.ui.forward.ForwardActivity;
import com.viber.voip.messages.ui.forward.ForwardPresenter;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class z
  implements d<ForwardPresenter>
{
  private final Provider<ForwardActivity> a;
  private final Provider<f> b;

  public z(Provider<ForwardActivity> paramProvider, Provider<f> paramProvider1)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
  }

  public static z a(Provider<ForwardActivity> paramProvider, Provider<f> paramProvider1)
  {
    return new z(paramProvider, paramProvider1);
  }

  public ForwardPresenter a()
  {
    return (ForwardPresenter)h.a(y.a((ForwardActivity)this.a.get(), c.b(this.b)), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.a.a.z
 * JD-Core Version:    0.6.2
 */