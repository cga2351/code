package com.viber.voip.phone.viber;

import com.viber.voip.phone.viber.conference.ui.incall.ConferenceInCallMvpView;
import com.viber.voip.phone.viber.incall.GenericInCallMvpViewImpl;
import dagger.a;
import dagger.b;
import javax.inject.Provider;

public final class InCallFragment_MembersInjector
  implements b<InCallFragment>
{
  private final Provider<com.viber.voip.analytics.story.b.c> mCallsTrackerProvider;
  private final Provider<ConferenceInCallMvpView> mConferenceInCallViewProvider;
  private final Provider<GenericInCallMvpViewImpl> mGenericInCallMvpViewProvider;

  public InCallFragment_MembersInjector(Provider<ConferenceInCallMvpView> paramProvider, Provider<GenericInCallMvpViewImpl> paramProvider1, Provider<com.viber.voip.analytics.story.b.c> paramProvider2)
  {
    this.mConferenceInCallViewProvider = paramProvider;
    this.mGenericInCallMvpViewProvider = paramProvider1;
    this.mCallsTrackerProvider = paramProvider2;
  }

  public static b<InCallFragment> create(Provider<ConferenceInCallMvpView> paramProvider, Provider<GenericInCallMvpViewImpl> paramProvider1, Provider<com.viber.voip.analytics.story.b.c> paramProvider2)
  {
    return new InCallFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }

  public static void injectMCallsTracker(InCallFragment paramInCallFragment, a<com.viber.voip.analytics.story.b.c> parama)
  {
    paramInCallFragment.mCallsTracker = parama;
  }

  public static void injectMConferenceInCallView(InCallFragment paramInCallFragment, a<ConferenceInCallMvpView> parama)
  {
    paramInCallFragment.mConferenceInCallView = parama;
  }

  public static void injectMGenericInCallMvpView(InCallFragment paramInCallFragment, a<GenericInCallMvpViewImpl> parama)
  {
    paramInCallFragment.mGenericInCallMvpView = parama;
  }

  public void injectMembers(InCallFragment paramInCallFragment)
  {
    injectMConferenceInCallView(paramInCallFragment, dagger.a.c.b(this.mConferenceInCallViewProvider));
    injectMGenericInCallMvpView(paramInCallFragment, dagger.a.c.b(this.mGenericInCallMvpViewProvider));
    injectMCallsTracker(paramInCallFragment, dagger.a.c.b(this.mCallsTrackerProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.InCallFragment_MembersInjector
 * JD-Core Version:    0.6.2
 */