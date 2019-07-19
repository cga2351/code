package com.viber.voip.user.more;

import android.support.v4.app.Fragment;
import com.viber.voip.vln.e;
import dagger.b;
import javax.inject.Provider;

public final class MoreDialogActivity_MembersInjector
  implements b<MoreDialogActivity>
{
  private final Provider<dagger.android.c<Fragment>> mFragmentInjectorProvider;
  private final Provider<e> mVlnReactContextManagerProvider;

  public MoreDialogActivity_MembersInjector(Provider<e> paramProvider, Provider<dagger.android.c<Fragment>> paramProvider1)
  {
    this.mVlnReactContextManagerProvider = paramProvider;
    this.mFragmentInjectorProvider = paramProvider1;
  }

  public static b<MoreDialogActivity> create(Provider<e> paramProvider, Provider<dagger.android.c<Fragment>> paramProvider1)
  {
    return new MoreDialogActivity_MembersInjector(paramProvider, paramProvider1);
  }

  public void injectMembers(MoreDialogActivity paramMoreDialogActivity)
  {
    MoreActivity_MembersInjector.injectMVlnReactContextManager(paramMoreDialogActivity, dagger.a.c.b(this.mVlnReactContextManagerProvider));
    MoreActivity_MembersInjector.injectMFragmentInjector(paramMoreDialogActivity, (dagger.android.c)this.mFragmentInjectorProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreDialogActivity_MembersInjector
 * JD-Core Version:    0.6.2
 */