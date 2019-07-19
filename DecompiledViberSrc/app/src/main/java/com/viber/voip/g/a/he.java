package com.viber.voip.g.a;

import com.viber.voip.ViberApplication;
import com.viber.voip.react.ReactContextManager;
import com.viber.voip.user.UserManager;
import com.viber.voip.vln.e;
import dagger.a.c;
import dagger.a.d;
import dagger.a.h;
import javax.inject.Provider;

public final class he
  implements d<e>
{
  private final Provider<ViberApplication> a;
  private final Provider<ReactContextManager> b;
  private final Provider<UserManager> c;

  public he(Provider<ViberApplication> paramProvider, Provider<ReactContextManager> paramProvider1, Provider<UserManager> paramProvider2)
  {
    this.a = paramProvider;
    this.b = paramProvider1;
    this.c = paramProvider2;
  }

  public static he a(Provider<ViberApplication> paramProvider, Provider<ReactContextManager> paramProvider1, Provider<UserManager> paramProvider2)
  {
    return new he(paramProvider, paramProvider1, paramProvider2);
  }

  public e a()
  {
    return (e)h.a(hd.a((ViberApplication)this.a.get(), c.b(this.b), (UserManager)this.c.get()), "Cannot return null from a non-@Nullable @Provides method");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.g.a.he
 * JD-Core Version:    0.6.2
 */