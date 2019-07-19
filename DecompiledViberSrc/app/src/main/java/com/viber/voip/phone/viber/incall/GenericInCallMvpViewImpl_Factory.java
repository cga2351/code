package com.viber.voip.phone.viber.incall;

import com.viber.common.permission.c;
import com.viber.voip.app.b;
import com.viber.voip.phone.viber.InCallFragment;
import com.viber.voip.util.e.e;
import dagger.a.d;
import javax.inject.Provider;

public final class GenericInCallMvpViewImpl_Factory
  implements d<GenericInCallMvpViewImpl>
{
  private final Provider<InCallFragment> callFragmentProvider;
  private final Provider<b> deviceConfigurationProvider;
  private final Provider<e> imageFetcherProvider;
  private final Provider<c> permissionManagerProvider;
  private final Provider<GenericInCallPresenter> presenterProvider;

  public GenericInCallMvpViewImpl_Factory(Provider<InCallFragment> paramProvider, Provider<e> paramProvider1, Provider<c> paramProvider2, Provider<b> paramProvider3, Provider<GenericInCallPresenter> paramProvider4)
  {
    this.callFragmentProvider = paramProvider;
    this.imageFetcherProvider = paramProvider1;
    this.permissionManagerProvider = paramProvider2;
    this.deviceConfigurationProvider = paramProvider3;
    this.presenterProvider = paramProvider4;
  }

  public static GenericInCallMvpViewImpl_Factory create(Provider<InCallFragment> paramProvider, Provider<e> paramProvider1, Provider<c> paramProvider2, Provider<b> paramProvider3, Provider<GenericInCallPresenter> paramProvider4)
  {
    return new GenericInCallMvpViewImpl_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4);
  }

  public GenericInCallMvpViewImpl get()
  {
    return new GenericInCallMvpViewImpl((InCallFragment)this.callFragmentProvider.get(), (e)this.imageFetcherProvider.get(), (c)this.permissionManagerProvider.get(), (b)this.deviceConfigurationProvider.get(), (GenericInCallPresenter)this.presenterProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incall.GenericInCallMvpViewImpl_Factory
 * JD-Core Version:    0.6.2
 */