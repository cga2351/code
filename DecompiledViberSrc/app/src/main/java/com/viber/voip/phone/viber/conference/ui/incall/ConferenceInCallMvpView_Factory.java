package com.viber.voip.phone.viber.conference.ui.incall;

import com.viber.voip.analytics.story.b.c;
import com.viber.voip.phone.viber.InCallFragment;
import com.viber.voip.util.e.e;
import dagger.a.d;
import javax.inject.Provider;

public final class ConferenceInCallMvpView_Factory
  implements d<ConferenceInCallMvpView>
{
  private final Provider<InCallFragment> callFragmentProvider;
  private final Provider<c> callsTrackerProvider;
  private final Provider<e> imageFetcherProvider;
  private final Provider<ConferenceInCallPresenter> presenterProvider;

  public ConferenceInCallMvpView_Factory(Provider<InCallFragment> paramProvider, Provider<e> paramProvider1, Provider<ConferenceInCallPresenter> paramProvider2, Provider<c> paramProvider3)
  {
    this.callFragmentProvider = paramProvider;
    this.imageFetcherProvider = paramProvider1;
    this.presenterProvider = paramProvider2;
    this.callsTrackerProvider = paramProvider3;
  }

  public static ConferenceInCallMvpView_Factory create(Provider<InCallFragment> paramProvider, Provider<e> paramProvider1, Provider<ConferenceInCallPresenter> paramProvider2, Provider<c> paramProvider3)
  {
    return new ConferenceInCallMvpView_Factory(paramProvider, paramProvider1, paramProvider2, paramProvider3);
  }

  public static ConferenceInCallMvpView newConferenceInCallMvpView(InCallFragment paramInCallFragment, e parame, ConferenceInCallPresenter paramConferenceInCallPresenter, c paramc)
  {
    return new ConferenceInCallMvpView(paramInCallFragment, parame, paramConferenceInCallPresenter, paramc);
  }

  public ConferenceInCallMvpView get()
  {
    return new ConferenceInCallMvpView((InCallFragment)this.callFragmentProvider.get(), (e)this.imageFetcherProvider.get(), (ConferenceInCallPresenter)this.presenterProvider.get(), (c)this.callsTrackerProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallMvpView_Factory
 * JD-Core Version:    0.6.2
 */