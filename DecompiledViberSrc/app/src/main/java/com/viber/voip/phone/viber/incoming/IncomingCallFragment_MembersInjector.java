package com.viber.voip.phone.viber.incoming;

import dagger.b;
import javax.inject.Provider;

public final class IncomingCallFragment_MembersInjector
  implements b<IncomingCallFragment>
{
  private final Provider<com.viber.voip.analytics.story.b.a.a> mActOnIncomingCallEventCollectorProvider;
  private final Provider<com.viber.voip.analytics.story.b.c> mCallsTrackerProvider;
  private final Provider<com.viber.common.permission.c> mPermissionManagerProvider;

  public IncomingCallFragment_MembersInjector(Provider<com.viber.voip.analytics.story.b.c> paramProvider, Provider<com.viber.voip.analytics.story.b.a.a> paramProvider1, Provider<com.viber.common.permission.c> paramProvider2)
  {
    this.mCallsTrackerProvider = paramProvider;
    this.mActOnIncomingCallEventCollectorProvider = paramProvider1;
    this.mPermissionManagerProvider = paramProvider2;
  }

  public static b<IncomingCallFragment> create(Provider<com.viber.voip.analytics.story.b.c> paramProvider, Provider<com.viber.voip.analytics.story.b.a.a> paramProvider1, Provider<com.viber.common.permission.c> paramProvider2)
  {
    return new IncomingCallFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2);
  }

  public static void injectMActOnIncomingCallEventCollector(IncomingCallFragment paramIncomingCallFragment, dagger.a<com.viber.voip.analytics.story.b.a.a> parama)
  {
    paramIncomingCallFragment.mActOnIncomingCallEventCollector = parama;
  }

  public static void injectMCallsTracker(IncomingCallFragment paramIncomingCallFragment, dagger.a<com.viber.voip.analytics.story.b.c> parama)
  {
    paramIncomingCallFragment.mCallsTracker = parama;
  }

  public static void injectMPermissionManager(IncomingCallFragment paramIncomingCallFragment, com.viber.common.permission.c paramc)
  {
    paramIncomingCallFragment.mPermissionManager = paramc;
  }

  public void injectMembers(IncomingCallFragment paramIncomingCallFragment)
  {
    injectMCallsTracker(paramIncomingCallFragment, dagger.a.c.b(this.mCallsTrackerProvider));
    injectMActOnIncomingCallEventCollector(paramIncomingCallFragment, dagger.a.c.b(this.mActOnIncomingCallEventCollectorProvider));
    injectMPermissionManager(paramIncomingCallFragment, (com.viber.common.permission.c)this.mPermissionManagerProvider.get());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.viber.incoming.IncomingCallFragment_MembersInjector
 * JD-Core Version:    0.6.2
 */