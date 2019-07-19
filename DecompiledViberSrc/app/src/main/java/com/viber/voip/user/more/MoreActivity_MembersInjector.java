package com.viber.voip.user.more;

import android.support.v4.app.Fragment;
import com.viber.voip.vln.e;
import dagger.a;
import dagger.b;
import javax.inject.Provider;

public final class MoreActivity_MembersInjector
  implements b<MoreActivity>
{
  private final Provider<dagger.android.c<Fragment>> mFragmentInjectorProvider;
  private final Provider<e> mVlnReactContextManagerProvider;

  public MoreActivity_MembersInjector(Provider<e> paramProvider, Provider<dagger.android.c<Fragment>> paramProvider1)
  {
    this.mVlnReactContextManagerProvider = paramProvider;
    this.mFragmentInjectorProvider = paramProvider1;
  }

  public static b<MoreActivity> create(Provider<e> paramProvider, Provider<dagger.android.c<Fragment>> paramProvider1)
  {
    return new MoreActivity_MembersInjector(paramProvider, paramProvider1);
  }

  public static void injectMFragmentInjector(MoreActivity paramMoreActivity, dagger.android.c<Fragment> paramc)
  {
    paramMoreActivity.mFragmentInjector = paramc;
  }

  public static void injectMVlnReactContextManager(MoreActivity paramMoreActivity, a<e> parama)
  {
    paramMoreActivity.mVlnReactContextManager = parama;
  }

  public void injectMembers(MoreActivity paramMoreActivity)
  {
    injectMVlnReactContextManager(paramMoreActivity, dagger.a.c.b(this.mVlnReactContextManagerProvider));
    injectMFragmentInjector(paramMoreActivity, (dagger.android.c)this.mFragmentInjectorProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreActivity_MembersInjector
 * JD-Core Version:    0.6.2
 */