package com.viber.voip;

import android.app.Activity;
import android.app.Service;
import android.support.v4.app.Fragment;
import com.squareup.leakcanary.RefWatcher;
import com.viber.voip.analytics.story.f.d;
import com.viber.voip.banner.i;
import com.viber.voip.contacts.c.d.m;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.at;
import com.viber.voip.messages.k;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.cv;
import com.viber.voip.util.e.e;
import org.greenrobot.eventbus.EventBus;

public final class bd
  implements dagger.b<ViberApplication>
{
  public static void A(ViberApplication paramViberApplication, dagger.a<com.viber.voip.j.a.a.c> parama)
  {
    paramViberApplication.mEmailsAbStatisticsManager = parama;
  }

  public static void B(ViberApplication paramViberApplication, dagger.a<e> parama)
  {
    paramViberApplication.mImageFetcher = parama;
  }

  public static void C(ViberApplication paramViberApplication, dagger.a<k> parama)
  {
    paramViberApplication.mMessagesManager = parama;
  }

  public static void D(ViberApplication paramViberApplication, dagger.a<bn> parama)
  {
    paramViberApplication.mMessageControllerUtils = parama;
  }

  public static void E(ViberApplication paramViberApplication, dagger.a<at> parama)
  {
    paramViberApplication.mSyncDataBetweenDevicesManager = parama;
  }

  public static void F(ViberApplication paramViberApplication, dagger.a<ConferenceCallsRepository> parama)
  {
    paramViberApplication.mConferenceCallsRepository = parama;
  }

  public static void G(ViberApplication paramViberApplication, dagger.a<ConferenceParticipantsRepository> parama)
  {
    paramViberApplication.mConferenceParticipantsRepository = parama;
  }

  public static void H(ViberApplication paramViberApplication, dagger.a<ISoundService> parama)
  {
    paramViberApplication.mSoundService = parama;
  }

  public static void I(ViberApplication paramViberApplication, dagger.a<IRingtonePlayer> parama)
  {
    paramViberApplication.mRingtonePlayer = parama;
  }

  public static void J(ViberApplication paramViberApplication, dagger.a<RefWatcher> parama)
  {
    paramViberApplication.refWatcher = parama;
  }

  public static void a(ViberApplication paramViberApplication, com.viber.voip.app.b paramb)
  {
    paramViberApplication.mDeviceConfiguration = paramb;
  }

  public static void a(ViberApplication paramViberApplication, bf parambf)
  {
    paramViberApplication.mComponentsManager = parambf;
  }

  public static void a(ViberApplication paramViberApplication, com.viber.voip.gdpr.a.a parama)
  {
    paramViberApplication.mConsentController = parama;
  }

  public static void a(ViberApplication paramViberApplication, com.viber.voip.messages.extensions.c paramc)
  {
    paramViberApplication.mChatExtensionConfig = paramc;
  }

  public static void a(ViberApplication paramViberApplication, dagger.a<com.viber.voip.messages.extras.c.a> parama)
  {
    paramViberApplication.mVKManager = parama;
  }

  public static void a(ViberApplication paramViberApplication, dagger.android.c<Activity> paramc)
  {
    paramViberApplication.mActivityInjector = paramc;
  }

  public static void a(ViberApplication paramViberApplication, EventBus paramEventBus)
  {
    paramViberApplication.mGlobalEventBus = paramEventBus;
  }

  public static void b(ViberApplication paramViberApplication, dagger.a<com.viber.voip.backup.h> parama)
  {
    paramViberApplication.mBackupMetadataController = parama;
  }

  public static void b(ViberApplication paramViberApplication, dagger.android.c<Fragment> paramc)
  {
    paramViberApplication.mFragmentInjector = paramc;
  }

  public static void c(ViberApplication paramViberApplication, dagger.a<com.viber.voip.backup.c> parama)
  {
    paramViberApplication.mBackupBackgroundListener = parama;
  }

  public static void c(ViberApplication paramViberApplication, dagger.android.c<Service> paramc)
  {
    paramViberApplication.mServiceInjector = paramc;
  }

  public static void d(ViberApplication paramViberApplication, dagger.a<com.viber.voip.l.a> parama)
  {
    paramViberApplication.mLanguageUpdateController = parama;
  }

  public static void e(ViberApplication paramViberApplication, dagger.a<com.viber.voip.engagement.b> parama)
  {
    paramViberApplication.mEngagementMediaPreloader = parama;
  }

  public static void f(ViberApplication paramViberApplication, dagger.a<com.viber.common.permission.c> parama)
  {
    paramViberApplication.mPermissionManager = parama;
  }

  public static void g(ViberApplication paramViberApplication, dagger.a<i> parama)
  {
    paramViberApplication.mRemoteSplashDisplayController = parama;
  }

  public static void h(ViberApplication paramViberApplication, dagger.a<cv> parama)
  {
    paramViberApplication.mTabBadgesManager = parama;
  }

  public static void i(ViberApplication paramViberApplication, dagger.a<com.viber.voip.messages.d.b> parama)
  {
    paramViberApplication.mParticipantManager = parama;
  }

  public static void j(ViberApplication paramViberApplication, dagger.a<ab> parama)
  {
    paramViberApplication.mMessageQueryHelper = parama;
  }

  public static void k(ViberApplication paramViberApplication, dagger.a<al> parama)
  {
    paramViberApplication.mParticipantQueryHelper = parama;
  }

  public static void l(ViberApplication paramViberApplication, dagger.a<ak> parama)
  {
    paramViberApplication.mParticipantInfoQueryHelperImpl = parama;
  }

  public static void m(ViberApplication paramViberApplication, dagger.a<com.viber.voip.messages.extensions.f> parama)
  {
    paramViberApplication.mChatExtensionQueryHelper = parama;
  }

  public static void n(ViberApplication paramViberApplication, dagger.a<aj> parama)
  {
    paramViberApplication.mEmoticonStore = parama;
  }

  public static void o(ViberApplication paramViberApplication, dagger.a<ai> parama)
  {
    paramViberApplication.mEmoticonHelper = parama;
  }

  public static void p(ViberApplication paramViberApplication, dagger.a<m> parama)
  {
    paramViberApplication.mContactsQueryHelper = parama;
  }

  public static void q(ViberApplication paramViberApplication, dagger.a<com.viber.voip.notif.f> parama)
  {
    paramViberApplication.mNotificationManagerWrapper = parama;
  }

  public static void r(ViberApplication paramViberApplication, dagger.a<com.google.d.f> parama)
  {
    paramViberApplication.mGson = parama;
  }

  public static void s(ViberApplication paramViberApplication, dagger.a<com.viber.voip.messages.extensions.d.b> parama)
  {
    paramViberApplication.mChatExSuggestionsManager = parama;
  }

  public static void t(ViberApplication paramViberApplication, dagger.a<d> parama)
  {
    paramViberApplication.mOnboardingTracker = parama;
  }

  public static void u(ViberApplication paramViberApplication, dagger.a<com.viber.voip.analytics.story.g.a> parama)
  {
    paramViberApplication.mOtherEventsTracker = parama;
  }

  public static void v(ViberApplication paramViberApplication, dagger.a<com.viber.voip.analytics.story.h.c> parama)
  {
    paramViberApplication.mPermissionsTracker = parama;
  }

  public static void w(ViberApplication paramViberApplication, dagger.a<com.viber.voip.analytics.story.b.a.h> parama)
  {
    paramViberApplication.mUserStartsCallEventCollector = parama;
  }

  public static void x(ViberApplication paramViberApplication, dagger.a<com.viber.voip.analytics.story.b.a.c> parama)
  {
    paramViberApplication.mEndCallEventCollector = parama;
  }

  public static void y(ViberApplication paramViberApplication, dagger.a<com.viber.voip.analytics.story.e.c> parama)
  {
    paramViberApplication.mMessagesTracker = parama;
  }

  public static void z(ViberApplication paramViberApplication, dagger.a<av> parama)
  {
    paramViberApplication.mThemeController = parama;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.bd
 * JD-Core Version:    0.6.2
 */