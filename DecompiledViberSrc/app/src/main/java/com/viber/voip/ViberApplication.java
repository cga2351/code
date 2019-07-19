package com.viber.voip;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.Application.ActivityLifecycleCallbacks;
import android.app.Service;
import android.app.backup.BackupManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.telephony.TelephonyManager;
import android.widget.Toast;
import com.jakewharton.processphoenix.ProcessPhoenix;
import com.squareup.leakcanary.RefWatcher;
import com.viber.common.dialogs.h.a;
import com.viber.common.dialogs.l.a;
import com.viber.dexshared.Logger;
import com.viber.dexshared.LoggerFactoryHelper;
import com.viber.jni.Engine;
import com.viber.jni.EngineDelegatesManager;
import com.viber.jni.PhoneControllerDelegate;
import com.viber.jni.PhoneControllerDelegateAdapter;
import com.viber.jni.ViberInInfo;
import com.viber.jni.apps.AppDetailsReceiverListener;
import com.viber.jni.apps.AppsAuthentucatorListener;
import com.viber.jni.apps.AppsBlockerListener;
import com.viber.jni.apps.AppsControllerDelegate.AppDetailsReceiver;
import com.viber.jni.apps.AppsControllerDelegate.Authenticator;
import com.viber.jni.apps.AppsControllerDelegate.Blocker;
import com.viber.jni.apps.AppsControllerDelegate.Support;
import com.viber.jni.apps.AppsControllerDelegate.UserAppsReceiver;
import com.viber.jni.apps.AppsSupportListener;
import com.viber.jni.apps.AppsUserAppsReceiverListener;
import com.viber.jni.banner.BannerDelegate;
import com.viber.jni.banner.BannerListener;
import com.viber.jni.block.BlockControllerDelegate.BlockPgInvites;
import com.viber.jni.block.BlockPgInvitesListener;
import com.viber.jni.connection.ConnectionDelegate;
import com.viber.jni.connection.ConnectionListener;
import com.viber.jni.controller.PhoneController;
import com.viber.jni.dialer.DialerCallbackListener;
import com.viber.jni.dialer.DialerController;
import com.viber.jni.dialer.DialerControllerDelegate.DialerCallback;
import com.viber.jni.dialer.DialerControllerDelegate.DialerLocalCallState;
import com.viber.jni.dialer.DialerLocalCallStateListener;
import com.viber.jni.messenger.MessageSenderListener;
import com.viber.jni.mustupgrade.MustUpgradeDelegate;
import com.viber.jni.mustupgrade.MustUpgradeListener;
import com.viber.jni.remoteconfig.RemoteConfigDelegate;
import com.viber.jni.remoteconfig.RemoteConfigListener;
import com.viber.jni.secure.MustSecureDelegate;
import com.viber.jni.secure.MustSecureListener;
import com.viber.jni.secure.SecurePrimaryActivationDelegate;
import com.viber.jni.secure.SecurePrimaryActivationListener;
import com.viber.jni.spam.BlockedUserSplashDelegate;
import com.viber.jni.spam.BlockedUserSplashDelegateImpl;
import com.viber.jni.spam.BlockedUserSplashListener;
import com.viber.jni.viberout.ViberOutBalanceDelegate;
import com.viber.jni.viberout.ViberOutBalanceListener;
import com.viber.jni.wallet.WalletControllerListener;
import com.viber.voip.app.b.a;
import com.viber.voip.i.c.o;
import com.viber.voip.messages.controller.bn;
import com.viber.voip.messages.controller.bs;
import com.viber.voip.messages.controller.manager.ab;
import com.viber.voip.messages.controller.manager.ak;
import com.viber.voip.messages.controller.manager.al;
import com.viber.voip.messages.controller.manager.at;
import com.viber.voip.messages.ui.ai;
import com.viber.voip.messages.ui.aj;
import com.viber.voip.notif.b.f.b.q;
import com.viber.voip.notif.e.n;
import com.viber.voip.notif.e.t;
import com.viber.voip.notif.e.u;
import com.viber.voip.notif.e.v;
import com.viber.voip.phone.MinimizedCallManager;
import com.viber.voip.phone.PhoneApp;
import com.viber.voip.phone.PhoneFragmentActivity;
import com.viber.voip.phone.call.CallHandler;
import com.viber.voip.phone.call.CallHandler.CallInfoReadyListener;
import com.viber.voip.phone.call.CallInfo;
import com.viber.voip.phone.call.CallInfo.CallType;
import com.viber.voip.phone.call.CallerInfo;
import com.viber.voip.phone.call.WearCallNotifier;
import com.viber.voip.phone.viber.conference.ConferenceCallsRepository;
import com.viber.voip.phone.viber.conference.ConferenceParticipantsRepository;
import com.viber.voip.pixie.PixieController;
import com.viber.voip.registration.ActivationController;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.registration.HardwareParametersImpl;
import com.viber.voip.registration.RegistrationReminderMessageReceiver;
import com.viber.voip.registration.ae;
import com.viber.voip.registration.af;
import com.viber.voip.settings.b.e.a.a;
import com.viber.voip.settings.d.ad;
import com.viber.voip.settings.d.ad.a;
import com.viber.voip.settings.d.af;
import com.viber.voip.settings.d.ai;
import com.viber.voip.settings.d.b;
import com.viber.voip.settings.d.f;
import com.viber.voip.settings.d.n;
import com.viber.voip.settings.d.p;
import com.viber.voip.settings.d.x;
import com.viber.voip.sound.ISoundService;
import com.viber.voip.sound.tones.IRingtonePlayer;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.ac;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.aq;
import com.viber.voip.ui.dialogs.ViberDialogHandlers.z;
import com.viber.voip.ui.dialogs.ad;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.viberid.ViberIdController;
import com.viber.voip.user.viberid.ViberIdControllerImpl;
import com.viber.voip.user.viberid.ViberIdDialogController;
import com.viber.voip.user.viberid.ViberIdPromoStickerPackHelper;
import com.viber.voip.util.UpdateLastOnlineStatusReceiver;
import com.viber.voip.util.ViberActionRunner;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.aq;
import com.viber.voip.util.cv;
import com.viber.voip.util.da;
import com.viber.voip.util.dd;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import javax.inject.Inject;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class ViberApplication
{
  private static final int EXIT_PROGRESS_DELAY = 2000;
  private static Logger lazilyInitializedL;
  private static volatile Boolean mHasMicrophone = null;
  private static ViberApplication mInstance = null;
  private static com.viber.common.b.g preferencesStorageInstance;
  private static Application sApplication;
  private static HashMap<String, com.viber.common.b.g> sPreferencesCategories = new HashMap(10);
  private com.viber.voip.e.a.c BT;
  private ActivationController activationController;
  private com.viber.voip.b.d cacheManager;
  private final AtomicReference<com.viber.voip.registration.l> countryCodeManager = new AtomicReference();
  private final AtomicReference<com.viber.voip.registration.o> devicesManager = new AtomicReference();
  private final AtomicReference<com.viber.voip.messages.extras.a.e> facebookManager = new AtomicReference();
  private HardwareParameters hardwareParameters;
  private final AtomicReference<com.viber.voip.messages.extras.b.a> locationManager = new AtomicReference();

  @Inject
  dagger.android.c<Activity> mActivityInjector;
  private com.viber.voip.analytics.d.a mAnalyticsAppForegroundChangeListener;
  private com.viber.voip.util.d mAppBackgroundChecker;
  com.viber.voip.g.a mAppComponent;

  @Inject
  dagger.a<com.viber.voip.backup.c> mBackupBackgroundListener;

  @Inject
  dagger.a<com.viber.voip.backup.h> mBackupMetadataController;
  private a mCallBackListener;
  private dagger.a<com.viber.voip.registration.changephonenumber.d> mChangePhoneNumberController;

  @Inject
  dagger.a<com.viber.voip.messages.extensions.d.b> mChatExSuggestionsManager;

  @Inject
  com.viber.voip.messages.extensions.c mChatExtensionConfig;

  @Inject
  dagger.a<com.viber.voip.messages.extensions.f> mChatExtensionQueryHelper;
  private com.viber.voip.messages.extensions.h mChatExtensionsNewDetailsChecker;
  private o mClientBaseFactory;

  @Inject
  bf mComponentsManager;

  @Inject
  dagger.a<ConferenceCallsRepository> mConferenceCallsRepository;

  @Inject
  dagger.a<ConferenceParticipantsRepository> mConferenceParticipantsRepository;

  @Inject
  com.viber.voip.gdpr.a.a mConsentController;
  private dagger.a<com.viber.voip.contacts.c.d.g> mContactsManagerLazy;
  private com.viber.voip.contacts.c.d.l mContactsMidToEMidMapper;

  @Inject
  dagger.a<com.viber.voip.contacts.c.d.m> mContactsQueryHelper;
  private dagger.a<com.viber.voip.contacts.c.d.m> mContactsQueryHelperLazy;
  private com.viber.voip.contacts.c.d.g mCurrentContactsManager;

  @Inject
  com.viber.voip.app.b mDeviceConfiguration;
  private com.viber.voip.util.ap mDownloadValve;

  @Inject
  dagger.a<com.viber.voip.j.a.a.c> mEmailsAbStatisticsManager;

  @Inject
  dagger.a<ai> mEmoticonHelper;

  @Inject
  dagger.a<aj> mEmoticonStore;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.c> mEndCallEventCollector;

  @Inject
  dagger.a<com.viber.voip.engagement.b> mEngagementMediaPreloader;
  private Engine mEngine;
  private com.viber.voip.fcm.c mFcmTokenController;
  private com.firebase.jobdispatcher.e mFirebaseJobDispatcher;

  @Inject
  dagger.android.c<Fragment> mFragmentInjector;
  private com.viber.voip.gdpr.c mGdprTrackingOptionsWatcher;

  @Inject
  EventBus mGlobalEventBus;

  @Inject
  dagger.a<com.google.d.f> mGson;
  private com.viber.voip.c.g mHandledCloudMessagesHolder = new com.viber.voip.c.g();

  @Inject
  dagger.a<com.viber.voip.util.e.e> mImageFetcher;
  private boolean mInitApplicationCalled;
  private com.viber.backup.a.e mKeychainBackupMgr;

  @Inject
  dagger.a<com.viber.voip.l.a> mLanguageUpdateController;
  private ax mLifecycleListener;
  private com.viber.voip.storage.c mMediaMountManager;

  @Inject
  dagger.a<bn> mMessageControllerUtils;

  @Inject
  dagger.a<ab> mMessageQueryHelper;

  @Inject
  dagger.a<com.viber.voip.messages.k> mMessagesManager;

  @Inject
  dagger.a<com.viber.voip.analytics.story.e.c> mMessagesTracker;

  @Inject
  dagger.a<com.viber.voip.notif.f> mNotificationManagerWrapper;
  private com.viber.voip.notif.g mNotifier;

  @Inject
  dagger.a<com.viber.voip.analytics.story.f.d> mOnboardingTracker;

  @Inject
  dagger.a<com.viber.voip.analytics.story.g.a> mOtherEventsTracker;

  @Inject
  dagger.a<ak> mParticipantInfoQueryHelperImpl;

  @Inject
  dagger.a<com.viber.voip.messages.d.b> mParticipantManager;

  @Inject
  dagger.a<al> mParticipantQueryHelper;

  @Inject
  dagger.a<com.viber.common.permission.c> mPermissionManager;

  @Inject
  dagger.a<com.viber.voip.analytics.story.h.c> mPermissionsTracker;
  private com.viber.voip.messages.ui.media.player.d.e mPlayerWindowManager;
  private com.viber.voip.calls.h mRecentsLettersToNumbersManager;

  @Inject
  dagger.a<com.viber.voip.banner.i> mRemoteSplashDisplayController;
  private com.viber.voip.registration.ah mRequestCreator;
  private com.viber.voip.fcm.f mRetrieveDataOnRestrictBGHandler;

  @Inject
  dagger.a<IRingtonePlayer> mRingtonePlayer;

  @Inject
  dagger.android.c<Service> mServiceInjector;

  @Inject
  dagger.a<ISoundService> mSoundService;

  @Inject
  dagger.a<at> mSyncDataBetweenDevicesManager;

  @Inject
  dagger.a<cv> mTabBadgesManager;

  @Inject
  dagger.a<com.viber.voip.ui.j.av> mThemeController;
  private com.viber.voip.notif.h mUpdateViberManager;

  @Inject
  dagger.a<com.viber.voip.analytics.story.b.a.h> mUserStartsCallEventCollector;

  @Inject
  dagger.a<com.viber.voip.messages.extras.c.a> mVKManager;
  private dagger.a<ViberIdControllerImpl> mViberIdController;
  private ViberInInfo mViberInInfo = new ViberInInfo();
  private com.viber.voip.wallet.a mWalletController;
  private bt mZeroRateCarrierStateChangeListener;
  private PhoneApp phoneApp;
  private volatile boolean preEngineInitStarted;

  @Inject
  dagger.a<RefWatcher> refWatcher;

  protected static Logger L()
  {
    if (lazilyInitializedL == null)
      lazilyInitializedL = ViberEnv.getLogger();
    return lazilyInitializedL;
  }

  private void applyWifiPolicy()
  {
    if (!"pref_wifi_policy_use_device_settings".equals(d.af.d.d()));
    for (boolean bool = true; ; bool = false)
    {
      getPhoneApp().lockWifi(bool);
      return;
    }
  }

  private void checkKeyChainWasSaved()
  {
    if ("mounted".equals(com.viber.voip.util.upload.o.e()))
    {
      boolean bool = com.viber.voip.registration.ao.f();
      synchronized (getActivationController())
      {
        String str1 = ???.getDeviceKey();
        if ((str1 != null) && (!da.a(str1)))
        {
          String str3 = ???.getKeyChainDeviceKey();
          if ((str3 == null) || (!str1.equals(str3)))
          {
            ???.setKeyChainDeviceKey(str1);
            L();
          }
        }
        if (bool)
        {
          str2 = e.a.a.c.d();
          if ((str2 != null) && (!da.a(str2)) && (!str2.equals(???.getKeyChainUDID())))
          {
            ???.setKeyChainUDID(str2);
            L();
          }
          com.viber.voip.registration.s.f();
          return;
        }
        String str2 = com.viber.voip.settings.b.e.a.l.d();
      }
    }
  }

  private void createChangePhoneNumberControllerLazy()
  {
    this.mChangePhoneNumberController = new com.viber.voip.g.b.b()
    {
      protected com.viber.voip.registration.changephonenumber.d a()
      {
        com.viber.voip.contacts.c.d.g localg = ViberApplication.this.getContactManager();
        com.viber.voip.messages.controller.manager.o localo = com.viber.voip.messages.controller.manager.o.a();
        ak localak = ak.a();
        Engine localEngine = ViberApplication.this.getEngine(false);
        PhoneController localPhoneController = localEngine.getPhoneController();
        UserManager localUserManager = ViberApplication.this.getUserManager();
        Handler localHandler = av.e.f.a();
        com.viber.voip.registration.changephonenumber.m localm = new com.viber.voip.registration.changephonenumber.m(localPhoneController, localUserManager, localak, localg.d(), (com.viber.voip.backup.h)ViberApplication.this.mBackupMetadataController.get(), com.viber.voip.billing.g.a(), com.viber.voip.viberout.a.a(), (com.viber.voip.analytics.story.g.a)ViberApplication.this.mOtherEventsTracker.get());
        ae localae = new ae(localEngine, av.e.g.a(), ViberApplication.this.getRequestCreator());
        com.viber.voip.registration.changephonenumber.l locall = new com.viber.voip.registration.changephonenumber.l(localHandler);
        com.viber.voip.registration.changephonenumber.d locald = new com.viber.voip.registration.changephonenumber.d(localPhoneController, new com.viber.voip.registration.changephonenumber.i(ViberApplication.this.getApplicationContext(), localPhoneController, localUserManager, localae, com.viber.voip.rakuten.a.a(), localm), locall, localak, new com.viber.voip.g.b.b()
        {
          protected bs a()
          {
            return new bs(ViberApplication.this.getApplicationContext());
          }
        }
        , new com.viber.voip.messages.controller.manager.z(), localg.c(), localo, av.e.d.a());
        locald.a(localg, localo);
        return locald;
      }
    };
  }

  private com.viber.voip.registration.l createCountryCodeManager()
  {
    return new com.viber.voip.registration.l(new com.viber.voip.registration.k(getApplicationContext()), getHardwareParameters(), null);
  }

  private void createViberIdControllerLazy()
  {
    this.mViberIdController = new com.viber.voip.g.b.b()
    {
      protected ViberIdControllerImpl a()
      {
        Engine localEngine = ViberApplication.this.getEngine(false);
        UserManager localUserManager = ViberApplication.this.getUserManager();
        ViberIdControllerImpl localViberIdControllerImpl = new ViberIdControllerImpl(ViberApplication.this.getApplicationContext(), localEngine.getExchanger(), localEngine.getPhoneController(), av.e.d.a(), com.viber.voip.h.a.b(), localUserManager.getUserData(), localUserManager.getRegistrationValues(), c.o.a, new com.viber.voip.g.b.b()
        {
          protected bs a()
          {
            return new bs(ViberApplication.this.getApplicationContext());
          }
        }
        , new ViberIdPromoStickerPackHelper(), new ViberIdDialogController(ViberApplication.this.getAppBackgroundChecker()), (com.viber.voip.analytics.story.g.a)ViberApplication.this.mOtherEventsTracker.get());
        localViberIdControllerImpl.init(localEngine.getExchanger(), localEngine.getDelegatesManager().getViberIdVersionListener());
        return localViberIdControllerImpl;
      }
    };
  }

  private void debugApplyStrictMode()
  {
  }

  @SuppressLint({"NewApi"})
  private void doInitApplication()
  {
    this.BT.a("APP START", "doInitApplication");
    Engine localEngine = getEngine(true);
    com.viber.voip.schedule.p.a(getApplicationContext());
    av.e.a.a().postDelayed(new Runnable()
    {
      public void run()
      {
        ViberApplication.this.initWebViewDebug();
      }
    }
    , 100L);
    L();
    if (!localEngine.isReady())
    {
      com.viber.voip.ui.dialogs.k.t().a(new ViberDialogHandlers.aq()).d();
      return;
    }
    boolean bool = isActivated();
    if (bool)
      localEngine.initService();
    debugApplyStrictMode();
    if (d.ad.I.d())
    {
      getRecentLetterManager().a();
      d.ad.I.a(false);
    }
    checkKeyChainWasSaved();
    com.viber.voip.api.a.a().b();
    getRecentCallsManager();
    if (com.viber.voip.settings.b.e.a.s.d())
      earlyPrepareAssets();
    MinimizedCallManager.getInstance().init();
    com.viber.voip.billing.l.a().b();
    com.viber.voip.b.c.a.h.a(getApplicationContext());
    this.mUpdateViberManager.b();
    getRingtonePlayer().init();
    if (com.viber.common.d.a.c())
    {
      CallHandler localCallHandler = localEngine.getCallHandler();
      localCallHandler.getCallNotifier().a(new WearCallNotifier(getApplicationContext(), localCallHandler, (ConferenceCallsRepository)this.mConferenceCallsRepository.get(), new com.viber.voip.util.i.c()));
    }
    applyWifiPolicy();
    com.viber.voip.backgrounds.b localb = com.viber.voip.backgrounds.b.a();
    localb.b();
    localb.a(false);
    getParticipantManager().a().b();
    getNotifier().a(this.mEngine.getCallHandler().getCallNotifier(), com.viber.voip.messages.controller.manager.o.a(), new com.viber.voip.notif.d(getApplicationContext()), com.viber.voip.h.a.b(), (ConferenceCallsRepository)this.mConferenceCallsRepository.get());
    getMessagesManager().p().a();
    getMessagesManager().q().a();
    aq.a();
    com.viber.voip.util.d.c(new com.viber.service.a(getApplicationContext(), localEngine));
    getApplicationContext().registerReceiver(new UpdateLastOnlineStatusReceiver(av.a(av.e.b)), UpdateLastOnlineStatusReceiver.a);
    getMessagesManager().w().a();
    getSoundService();
    ((ConferenceCallsRepository)this.mConferenceCallsRepository.get()).invalidate();
    this.mChatExtensionConfig.a();
    if (bool)
      ((com.viber.voip.messages.extensions.d.b)this.mChatExSuggestionsManager.get()).b();
    if (!com.viber.common.d.a.g())
      logToCrashlytics("Application. init finished");
    this.BT.b("APP START", "doInitApplication");
  }

  private void doShowDialog(int paramInt, String paramString)
  {
    CallInfo localCallInfo = getInstance().getEngine(true).getCurrentCall();
    CallerInfo localCallerInfo;
    if (localCallInfo != null)
    {
      localCallerInfo = localCallInfo.getCallerInfo();
      switch (paramInt)
      {
      default:
        showUnknownDialog(paramInt, paramString);
      case 1:
      case 3:
      case 2:
      }
    }
    do
    {
      do
      {
        return;
        localCallerInfo = null;
        break;
        showSwitchToGSMDialog(paramString);
        return;
      }
      while (localCallerInfo == null);
      Bundle localBundle = new Bundle();
      localBundle.putString("context_member_id", localCallerInfo.getMemberId());
      localBundle.putString("context_number", paramString);
      com.viber.voip.ui.dialogs.b.c().a(localBundle).a(new ViberDialogHandlers.ac()).d();
      return;
    }
    while (localCallerInfo == null);
    l.a locala = com.viber.voip.ui.dialogs.e.a(localCallerInfo.getMemberId(), localCallerInfo.getPhoneNumber(), localCallerInfo.getName());
    Object[] arrayOfObject = new Object[2];
    arrayOfObject[0] = localCallerInfo.getName();
    arrayOfObject[1] = localCallerInfo.getName();
    locala.b(-1, arrayOfObject).d();
  }

  public static void exit(Activity paramActivity, final boolean paramBoolean)
  {
    L();
    int i;
    if ((paramActivity != null) && (!paramActivity.isFinishing()))
    {
      i = 2000;
      if (paramBoolean)
        ad.a(R.string.dialog_c4_message).b(false).a(paramActivity);
    }
    while (true)
    {
      av.e.a.a().postDelayed(new Runnable()
      {
        public void run()
        {
          com.viber.voip.analytics.g localg = com.viber.voip.analytics.g.a();
          com.viber.voip.analytics.d.a locala = ViberApplication.getInstance().mAnalyticsAppForegroundChangeListener;
          if (locala != null)
            locala.a();
          ViberApplication.requestEngineShutdown();
          localg.a(false);
          if (this.a != null);
          try
          {
            this.a.finishAffinity();
            label41: if (paramBoolean)
              ViberActionRunner.a(ViberApplication.getApplication());
            ViberApplication.finish();
            return;
          }
          catch (Exception localException)
          {
            break label41;
          }
        }
      }
      , i);
      return;
      ad.a(R.string.dialog_c3_message).d(R.string.dialog_c3_title).b(false).a(paramActivity);
      continue;
      i = 0;
    }
  }

  public static boolean externalStorageMounted(Context paramContext, boolean paramBoolean)
  {
    if (!"mounted".equals(com.viber.voip.util.upload.o.e()))
    {
      if (paramBoolean)
        Toast.makeText(paramContext, R.string.dialog_337_message, 0).show();
      return false;
    }
    return true;
  }

  private void extraSetup()
  {
  }

  public static void finish()
  {
    L();
    if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
    {
      com.viber.voip.stickers.i.a().s();
      com.viber.voip.schedule.d.a().d();
      com.viber.voip.notif.g.a(getApplication()).h();
      av.b();
    }
    ViberEnv.getLoggerFactory().finish();
    System.runFinalizersOnExit(true);
    System.exit(0);
  }

  public static Application getApplication()
  {
    return sApplication;
  }

  private Context getApplicationContext()
  {
    return sApplication.getApplicationContext();
  }

  public static ViberApplication getInstance()
  {
    return mInstance;
  }

  private com.viber.voip.l.a getLanguageUpdateController()
  {
    return (com.viber.voip.l.a)this.mLanguageUpdateController.get();
  }

  public static Context getLocalizedContext()
  {
    return getInstance().getLocaleDataCache().a();
  }

  public static Resources getLocalizedResources()
  {
    return getInstance().getLocaleDataCache().a().getResources();
  }

  public static boolean hasMicrophone()
  {
    if (mHasMicrophone == null)
      mHasMicrophone = Boolean.valueOf(getApplication().getPackageManager().hasSystemFeature("android.hardware.microphone"));
    return mHasMicrophone.booleanValue();
  }

  public static ViberApplication init(Application paramApplication)
  {
    sApplication = paramApplication;
    mInstance = new ViberApplication();
    return mInstance;
  }

  private void initAnalytics()
  {
    com.viber.voip.analytics.g.a();
    this.mZeroRateCarrierStateChangeListener = new bt();
    this.mZeroRateCarrierStateChangeListener.a();
    ((com.viber.common.permission.c)this.mPermissionManager.get()).a((com.viber.common.permission.b)this.mPermissionsTracker.get());
    com.viber.voip.analytics.story.f.d locald = (com.viber.voip.analytics.story.f.d)this.mOnboardingTracker.get();
    if (!da.a(getUserManager().getRegistrationValues().l()));
    for (boolean bool = true; ; bool = false)
    {
      locald.c(bool);
      if (this.mAnalyticsAppForegroundChangeListener != null)
      {
        com.viber.voip.analytics.d.a.a locala = new com.viber.voip.analytics.d.a.a(av.e.f.a(), (com.viber.voip.analytics.story.f.d)this.mOnboardingTracker.get(), (com.viber.voip.analytics.story.g.a)this.mOtherEventsTracker.get(), getUserManager().getRegistrationValues(), com.viber.voip.analytics.g.a().k());
        this.mAnalyticsAppForegroundChangeListener.a(locala);
      }
      return;
    }
  }

  private void initClientBaseFactory()
  {
    L();
    try
    {
      this.mClientBaseFactory = ((o)Class.forName("com.viber.voip.internal.ClientBaseFactoryImpl").newInstance());
      return;
    }
    catch (Exception localException)
    {
      logToCrashlytics(localException);
      throw new RuntimeException(localException);
    }
  }

  private void initContactsMidToEMidMapper()
  {
    Engine localEngine = getEngine(false);
    this.mContactsMidToEMidMapper = new com.viber.voip.contacts.c.d.l(getEngine(false).getExchanger(), d.p.s, getContactManager(), localEngine.getPhoneController(), av.e.c.a());
    this.mContactsMidToEMidMapper.a(com.viber.voip.messages.controller.manager.o.a(), localEngine.getDelegatesManager().getConnectionListener());
  }

  private void initLazyDependencies(boolean paramBoolean)
  {
    new com.viber.voip.g.b.c(new az(this, paramBoolean));
    new com.viber.voip.g.b.c(new ba(this));
  }

  private void initMessagesBackup()
  {
    getApplication().registerActivityLifecycleCallbacks((Application.ActivityLifecycleCallbacks)this.mBackupBackgroundListener.get());
    this.mBackupMetadataController.get();
  }

  private static void initPreferencesStorage(Context paramContext)
  {
    try
    {
      com.viber.voip.e.a.e.b().a("APP START", "initPreferencesStorage");
      preferencesStorageInstance = initPreferencesStorageForCategory(paramContext.getApplicationContext(), null);
      com.viber.voip.e.a.e.b().b("APP START", "initPreferencesStorage");
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private static com.viber.common.b.g initPreferencesStorageForCategory(Context paramContext, String paramString)
  {
    try
    {
      L();
      com.viber.voip.settings.c localc = new com.viber.voip.settings.c(paramContext.getApplicationContext(), av.a(av.e.f), paramString);
      return localc;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  @TargetApi(19)
  private void initWebViewDebug()
  {
  }

  public static boolean isActivated()
  {
    boolean bool = com.viber.voip.settings.b.e.a.m.d();
    if (bool);
    return bool;
  }

  @Deprecated
  public static boolean isTablet(Context paramContext)
  {
    return mInstance.mDeviceConfiguration.a(paramContext);
  }

  @Deprecated
  public static com.viber.common.b.g preferences()
  {
    if ((preferencesStorageInstance == null) && (sApplication != null))
      initPreferencesStorage(sApplication);
    return preferencesStorageInstance;
  }

  @Deprecated
  public static com.viber.common.b.g preferences(Context paramContext)
  {
    if (preferencesStorageInstance == null)
      initPreferencesStorage(paramContext);
    return preferencesStorageInstance;
  }

  @Deprecated
  public static com.viber.common.b.g preferences(String paramString)
  {
    if (paramString == null)
    {
      if ((preferencesStorageInstance == null) && (sApplication != null))
        initPreferencesStorage(sApplication);
      return preferencesStorageInstance;
    }
    synchronized (sPreferencesCategories)
    {
      com.viber.common.b.g localg1 = (com.viber.common.b.g)sPreferencesCategories.get(paramString);
      if (localg1 != null)
        return localg1;
    }
    com.viber.common.b.g localg2 = initPreferencesStorageForCategory(sApplication, paramString);
    if (localg2 != null)
      sPreferencesCategories.put(paramString, localg2);
    return localg2;
  }

  private void registerPhoneControllerListeners(Engine paramEngine)
  {
    paramEngine.addInitializedListener(getAppBackgroundChecker());
    L();
    EngineDelegatesManager localEngineDelegatesManager = paramEngine.getDelegatesManager();
    this.mCallBackListener = new a(null);
    MustUpgradeListener localMustUpgradeListener = localEngineDelegatesManager.getMustUpgradeListener();
    MustUpgradeDelegate[] arrayOfMustUpgradeDelegate = new MustUpgradeDelegate[1];
    arrayOfMustUpgradeDelegate[0] = new am();
    localMustUpgradeListener.registerDelegate(arrayOfMustUpgradeDelegate);
    PhoneControllerDelegate[] arrayOfPhoneControllerDelegate1 = new PhoneControllerDelegate[1];
    arrayOfPhoneControllerDelegate1[0] = this.mCallBackListener;
    localEngineDelegatesManager.registerDelegate(arrayOfPhoneControllerDelegate1);
    ConnectionListener localConnectionListener = localEngineDelegatesManager.getConnectionListener();
    ConnectionDelegate[] arrayOfConnectionDelegate = new ConnectionDelegate[1];
    arrayOfConnectionDelegate[0] = this.mCallBackListener;
    localConnectionListener.registerDelegate(arrayOfConnectionDelegate);
    DialerCallbackListener localDialerCallbackListener = localEngineDelegatesManager.getDialerCallbackListener();
    DialerControllerDelegate.DialerCallback[] arrayOfDialerCallback = new DialerControllerDelegate.DialerCallback[1];
    arrayOfDialerCallback[0] = this.mCallBackListener;
    localDialerCallbackListener.registerDelegate(arrayOfDialerCallback);
    DialerLocalCallStateListener localDialerLocalCallStateListener = localEngineDelegatesManager.getDialerLocalCallStateListener();
    DialerControllerDelegate.DialerLocalCallState[] arrayOfDialerLocalCallState = new DialerControllerDelegate.DialerLocalCallState[1];
    arrayOfDialerLocalCallState[0] = new com.viber.voip.viberout.d();
    localDialerLocalCallStateListener.registerDelegate(arrayOfDialerLocalCallState);
    if (com.viber.voip.registration.ao.f())
    {
      MustSecureListener localMustSecureListener = localEngineDelegatesManager.getMustSecureListener();
      MustSecureDelegate[] arrayOfMustSecureDelegate = new MustSecureDelegate[1];
      arrayOfMustSecureDelegate[0] = new com.viber.voip.registration.b.a();
      localMustSecureListener.registerDelegate(arrayOfMustSecureDelegate);
    }
    while (true)
    {
      ViberOutBalanceListener localViberOutBalanceListener = localEngineDelegatesManager.getViberOutBalanceListener();
      ViberOutBalanceDelegate[] arrayOfViberOutBalanceDelegate = new ViberOutBalanceDelegate[1];
      arrayOfViberOutBalanceDelegate[0] = com.viber.voip.viberout.c.a();
      localViberOutBalanceListener.registerDelegate(arrayOfViberOutBalanceDelegate);
      PhoneControllerDelegate[] arrayOfPhoneControllerDelegate2 = new PhoneControllerDelegate[1];
      arrayOfPhoneControllerDelegate2[0] = com.viber.service.a.a.a();
      localEngineDelegatesManager.registerDelegate(arrayOfPhoneControllerDelegate2);
      localEngineDelegatesManager.getMessageSenderListener().registerDelegate(com.viber.service.a.a.a(), av.e.d.a());
      com.viber.voip.apps.a.a locala = new com.viber.voip.apps.a.a(paramEngine.getUserManager().getAppsController());
      localEngineDelegatesManager.getAppsAuthenticatorListener().registerDelegate(new AppsControllerDelegate.Authenticator[] { locala });
      localEngineDelegatesManager.getAppsUserAppsReceiverListener().registerDelegate(new AppsControllerDelegate.UserAppsReceiver[] { locala });
      localEngineDelegatesManager.getAppDetailsReceiverListener().registerDelegate(new AppsControllerDelegate.AppDetailsReceiver[] { locala });
      localEngineDelegatesManager.getAppsBlockerListener().registerDelegate(new AppsControllerDelegate.Blocker[] { locala });
      localEngineDelegatesManager.getAppsSupportListener().registerDelegate(new AppsControllerDelegate.Support[] { locala });
      com.viber.voip.block.a.a locala1 = new com.viber.voip.block.a.a();
      localEngineDelegatesManager.getBlockPgInvitesListener().registerDelegate(new BlockControllerDelegate.BlockPgInvites[] { locala1 });
      BannerListener localBannerListener = localEngineDelegatesManager.getBannerListener();
      BannerDelegate[] arrayOfBannerDelegate = new BannerDelegate[1];
      arrayOfBannerDelegate[0] = new com.viber.voip.banner.b.a(getApplicationContext());
      localBannerListener.registerDelegate(arrayOfBannerDelegate);
      getMessagesManager();
      getLocationManager();
      localEngineDelegatesManager.getWalletControllerListener().registerDelegate(getWalletController(), av.e.a.a());
      com.viber.voip.i.j localj = new com.viber.voip.i.j(getChatExtensionsNewDetailsChecker(), this.mUpdateViberManager, this.mChatExtensionConfig);
      localEngineDelegatesManager.getRemoteConfigListener().registerDelegate(new RemoteConfigDelegate[] { localj });
      com.viber.voip.h.a.b().register(localj);
      BlockedUserSplashListener localBlockedUserSplashListener = localEngineDelegatesManager.getBlockedUserSplashListener();
      BlockedUserSplashDelegate[] arrayOfBlockedUserSplashDelegate = new BlockedUserSplashDelegate[1];
      arrayOfBlockedUserSplashDelegate[0] = new BlockedUserSplashDelegateImpl(getApplicationContext());
      localBlockedUserSplashListener.registerDelegate(arrayOfBlockedUserSplashDelegate);
      paramEngine.addCallInfoListener(new CallHandler.CallInfoReadyListener()
      {
        public void onCallInfoReady(CallInfo paramAnonymousCallInfo)
        {
          if (paramAnonymousCallInfo.getType() == CallInfo.CallType.OUTGOING)
            if (com.viber.voip.analytics.a.j.a(paramAnonymousCallInfo))
            {
              if (!paramAnonymousCallInfo.isViberOut())
                break label98;
              com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.f);
            }
          while (true)
          {
            if ((ViberApplication.isTablet(null)) && (paramAnonymousCallInfo.getCallerInfo() != null))
            {
              if (paramAnonymousCallInfo.isConference())
                break;
              ViberApplication.this.getApplicationContext().startActivity(com.viber.voip.messages.m.a(paramAnonymousCallInfo.getCallerInfo().getMemberId(), paramAnonymousCallInfo.getCallerInfo().getPhoneNumber(), paramAnonymousCallInfo.getCallerInfo().getName(), false, false, false, false).addFlags(268435456));
            }
            return;
            label98: if (paramAnonymousCallInfo.isOutgoingVideoCall())
            {
              com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.e);
            }
            else
            {
              com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.c);
              com.viber.voip.analytics.g.a().a(com.viber.voip.analytics.a.i.d);
            }
          }
          ViberApplication.this.getApplicationContext().startActivity(ViberActionRunner.ab.a(ViberApplication.this.getApplicationContext()).addFlags(268435456));
        }
      });
      this.mTabBadgesManager.get();
      return;
      SecurePrimaryActivationListener localSecurePrimaryActivationListener = localEngineDelegatesManager.getSecurePrimaryActivationListener();
      SecurePrimaryActivationDelegate[] arrayOfSecurePrimaryActivationDelegate = new SecurePrimaryActivationDelegate[1];
      arrayOfSecurePrimaryActivationDelegate[0] = new com.viber.voip.registration.b.b(getApplicationContext(), com.viber.voip.analytics.g.a().c().b(), this.mNotifier.a());
      localSecurePrimaryActivationListener.registerDelegate(arrayOfSecurePrimaryActivationDelegate);
    }
  }

  static void requestEngineShutdown()
  {
    ViberApplication localViberApplication = getInstance();
    if ((localViberApplication.mEngine != null) && (localViberApplication.mEngine.isReady()))
    {
      localViberApplication.getFirebaseJobDispatcher().a("keep_alive");
      L();
      localViberApplication.mEngine.getPhoneController().requestShutdown();
    }
  }

  public dagger.android.b<Activity> activityInjector()
  {
    return this.mActivityInjector;
  }

  public void earlyPrepareAssets()
  {
    com.viber.voip.stickers.i.a();
    aj.b().g();
  }

  public ActivationController getActivationController()
  {
    if (this.activationController == null);
    try
    {
      if (this.activationController == null)
      {
        final UserManager localUserManager = getEngine(false).getUserManager();
        final Context localContext = getApplicationContext();
        com.viber.voip.backup.s locals = new com.viber.voip.backup.s(localContext, this.mPermissionManager, new com.viber.voip.g.b.b()
        {
          protected com.viber.voip.backup.a.c a()
          {
            com.viber.voip.backup.a.h localh = new com.viber.voip.backup.a.h(localUserManager.getRegistrationValues());
            com.viber.backup.a.d locald = com.viber.backup.a.d.a(localContext);
            com.viber.backup.drive.a locala = new com.viber.backup.drive.a(d.x.a);
            com.viber.voip.backup.b.b localb = new com.viber.voip.backup.b.b(localContext, locala);
            return new com.viber.voip.backup.a.i(localContext, new com.viber.voip.backup.a.d(localContext, localh, com.viber.voip.backup.f.b()), com.viber.voip.backup.f.b(), locald, localb, av.a(av.e.k));
          }
        }
        , com.viber.voip.backup.f.b());
        com.viber.voip.g.b.b local11 = new com.viber.voip.g.b.b()
        {
          protected com.viber.voip.analytics.story.f.d a()
          {
            return com.viber.voip.analytics.g.a().c().b();
          }
        };
        this.activationController = ActivationController.getInstance(getApplicationContext(), this, av.a(av.e.f), localUserManager, locals, local11);
      }
      return this.activationController;
    }
    finally
    {
    }
  }

  public String getActivityOnForeground()
  {
    return getAppBackgroundChecker().c();
  }

  @Deprecated
  public com.viber.voip.util.d getAppBackgroundChecker()
  {
    if (this.mAppBackgroundChecker == null);
    try
    {
      if (this.mAppBackgroundChecker == null)
        this.mAppBackgroundChecker = new com.viber.voip.util.d(getApplicationContext());
      return this.mAppBackgroundChecker;
    }
    finally
    {
    }
  }

  public com.viber.voip.g.a getAppComponent()
  {
    return this.mAppComponent;
  }

  public com.viber.voip.backgrounds.c.e getBackgroundDownloadTaskController()
  {
    return this.mClientBaseFactory.a();
  }

  @Deprecated
  public com.viber.voip.backup.c getBackupBackgroundListener()
  {
    return (com.viber.voip.backup.c)this.mBackupBackgroundListener.get();
  }

  public com.viber.backup.a.e getBackupManager()
  {
    if (this.mKeychainBackupMgr == null);
    try
    {
      if (this.mKeychainBackupMgr == null)
      {
        Context localContext = getApplicationContext();
        com.viber.backup.a.g localg = new com.viber.backup.a.g(new BackupManager(localContext));
        com.viber.backup.drive.a locala = new com.viber.backup.drive.a(d.x.a);
        com.viber.backup.drive.e locale = new com.viber.backup.drive.e(localContext, new com.viber.voip.backup.a.d(localContext, new com.viber.backup.drive.c(), locala), av.a(av.e.k));
        com.viber.voip.backup.b.b localb = new com.viber.voip.backup.b.b(localContext, locala);
        com.viber.backup.a.d locald = com.viber.backup.a.d.a(localContext);
        this.mKeychainBackupMgr = new com.viber.backup.a.e(localg, new com.viber.backup.a.a(localContext, locale, com.viber.common.permission.c.a(localContext), localb, locald));
      }
      return this.mKeychainBackupMgr;
    }
    finally
    {
    }
  }

  @Deprecated
  public com.viber.voip.backup.h getBackupMetadataController()
  {
    return (com.viber.voip.backup.h)this.mBackupMetadataController.get();
  }

  public com.viber.voip.b.d getCacheManager()
  {
    if (this.cacheManager == null)
      this.cacheManager = new com.viber.voip.b.a.a();
    return this.cacheManager;
  }

  public com.viber.voip.registration.changephonenumber.d getChangePhoneNumberController()
  {
    if (this.mChangePhoneNumberController == null)
      createChangePhoneNumberControllerLazy();
    return (com.viber.voip.registration.changephonenumber.d)this.mChangePhoneNumberController.get();
  }

  @Deprecated
  public dagger.a<com.viber.voip.messages.extensions.d.b> getChatExSuggestionsManager()
  {
    return this.mChatExSuggestionsManager;
  }

  @Deprecated
  public com.viber.voip.messages.extensions.c getChatExtensionConfig()
  {
    return this.mChatExtensionConfig;
  }

  @Deprecated
  public dagger.a<com.viber.voip.messages.extensions.f> getChatExtensionQueryHelper()
  {
    return this.mChatExtensionQueryHelper;
  }

  public final com.viber.voip.messages.extensions.h getChatExtensionsNewDetailsChecker()
  {
    if (this.mChatExtensionsNewDetailsChecker == null)
      this.mChatExtensionsNewDetailsChecker = new com.viber.voip.messages.extensions.h(av.e.g.a(), d.n.b, d.n.f, d.ad.a.a, this.mChatExtensionConfig);
    return this.mChatExtensionsNewDetailsChecker;
  }

  public bf getComponentsManager()
  {
    return this.mComponentsManager;
  }

  public com.viber.voip.contacts.c.d.g getContactManager()
  {
    if (this.mCurrentContactsManager == null)
      com.viber.voip.e.a.e.b().a("APP START", "getContactManager");
    com.viber.voip.contacts.c.d.g localg1;
    if (com.viber.voip.registration.ao.f())
      localg1 = com.viber.voip.contacts.c.d.b.b.a(getApplicationContext(), this);
    while (true)
    {
      com.viber.voip.e.a.e.b().a("APP START", "getContactManager", "create ContactsManagerBaseImpl");
      com.viber.voip.messages.controller.manager.o localo;
      com.viber.voip.messages.d.b localb;
      if (localg1 != this.mCurrentContactsManager)
      {
        localo = com.viber.voip.messages.controller.manager.o.a();
        localb = com.viber.voip.messages.d.c.c();
      }
      try
      {
        if (localg1 == this.mCurrentContactsManager)
        {
          com.viber.voip.contacts.c.d.g localg2 = this.mCurrentContactsManager;
          return localg2;
          localg1 = com.viber.voip.contacts.c.d.a.b.a(getApplicationContext(), this);
          continue;
        }
        if (this.mCurrentContactsManager != null)
          this.mCurrentContactsManager.a();
        this.mCurrentContactsManager = localg1;
        localb.a(localg1);
        com.viber.voip.registration.changephonenumber.d locald = getChangePhoneNumberController();
        if (locald != null)
          locald.a(this.mCurrentContactsManager, localo);
        this.mCurrentContactsManager.a(new com.viber.voip.contacts.c.d.d(d.p.v, av.e.c.a(), new com.viber.voip.g.b.b()
        {
          protected com.viber.voip.contacts.c.f.b.f a()
          {
            return com.viber.voip.contacts.c.f.b.f.a(ViberApplication.getApplication());
          }
        }));
        com.viber.voip.e.a.e.b().c("APP START", "getContactManager");
        return this.mCurrentContactsManager;
      }
      finally
      {
      }
    }
  }

  public com.viber.voip.registration.l getCountryCodeManager()
  {
    if (this.countryCodeManager.get() == null)
      this.countryCodeManager.compareAndSet(null, createCountryCodeManager());
    return (com.viber.voip.registration.l)this.countryCodeManager.get();
  }

  public com.viber.a.a getCrashHandler()
  {
    return com.viber.a.a.a();
  }

  public String getCurrentSystemLanguage()
  {
    return getLanguageUpdateController().a();
  }

  public com.viber.voip.registration.o getDevicesManager()
  {
    if (this.devicesManager.get() == null)
      this.devicesManager.compareAndSet(null, new com.viber.voip.registration.o(getApplicationContext()));
    return (com.viber.voip.registration.o)this.devicesManager.get();
  }

  public com.viber.voip.util.ap getDownloadValve()
  {
    if (this.mDownloadValve == null);
    try
    {
      if (this.mDownloadValve == null)
        this.mDownloadValve = new com.viber.voip.util.ap();
      return this.mDownloadValve;
    }
    finally
    {
    }
  }

  public dagger.a<com.viber.voip.analytics.story.b.a.c> getEndCallEventCollector()
  {
    return this.mEndCallEventCollector;
  }

  @Deprecated
  public Engine getEngine(boolean paramBoolean)
  {
    if (this.mEngine == null)
      com.viber.common.d.i.a();
    try
    {
      if (this.mEngine == null)
        this.mEngine = new Engine(getApplicationContext(), this);
      if (paramBoolean)
      {
        if (!this.mEngine.isReady())
          this.mEngine.init();
        if ((!this.mEngine.isInitialized()) && (isActivated()))
          this.mEngine.initService();
      }
      return this.mEngine;
    }
    finally
    {
    }
  }

  @Deprecated
  public com.viber.voip.messages.extras.a.e getFacebookManager()
  {
    return getFacebookManager(true);
  }

  public com.viber.voip.messages.extras.a.e getFacebookManager(boolean paramBoolean)
  {
    if ((this.facebookManager.get() == null) && (paramBoolean));
    synchronized (this.facebookManager)
    {
      com.viber.voip.messages.extras.a.e locale = new com.viber.voip.messages.extras.a.e(getApplicationContext().getString(R.string.facebook_app_id));
      locale.a(new com.viber.voip.messages.extras.a.a(this));
      locale.a(new com.viber.voip.messages.extras.a.b(getApplicationContext()));
      this.facebookManager.compareAndSet(null, locale);
      return (com.viber.voip.messages.extras.a.e)this.facebookManager.get();
    }
  }

  public com.viber.voip.fcm.c getFcmTokenController()
  {
    if (this.mFcmTokenController == null);
    try
    {
      if (this.mFcmTokenController == null)
        this.mFcmTokenController = new com.viber.voip.fcm.c(getApplicationContext(), getEngine(false), com.viber.voip.h.a.b());
      return this.mFcmTokenController;
    }
    finally
    {
    }
  }

  public com.firebase.jobdispatcher.e getFirebaseJobDispatcher()
  {
    if (this.mFirebaseJobDispatcher == null)
      this.mFirebaseJobDispatcher = new com.firebase.jobdispatcher.e(new com.firebase.jobdispatcher.g(getApplicationContext()));
    return this.mFirebaseJobDispatcher;
  }

  @Deprecated
  public dagger.a<com.google.d.f> getGson()
  {
    return this.mGson;
  }

  public com.viber.voip.c.g getHandledCloudMessagesHolder()
  {
    return this.mHandledCloudMessagesHolder;
  }

  @Deprecated
  public HardwareParameters getHardwareParameters()
  {
    if (this.hardwareParameters == null)
      this.hardwareParameters = new HardwareParametersImpl(getApplicationContext());
    return this.hardwareParameters;
  }

  public com.viber.voip.util.e.e getImageFetcher()
  {
    return (com.viber.voip.util.e.e)this.mImageFetcher.get();
  }

  @Deprecated
  public dagger.a<ConferenceCallsRepository> getLazyConferenceCallsRepository()
  {
    return this.mConferenceCallsRepository;
  }

  @Deprecated
  public dagger.a<ConferenceParticipantsRepository> getLazyConferenceParticipantsRepository()
  {
    return this.mConferenceParticipantsRepository;
  }

  @Deprecated
  public dagger.a<com.viber.voip.contacts.c.d.g> getLazyContactManager()
  {
    if (this.mContactsManagerLazy == null)
      this.mContactsManagerLazy = new com.viber.voip.g.b.b()
      {
        protected com.viber.voip.contacts.c.d.g a()
        {
          return ViberApplication.this.getContactManager();
        }
      };
    return this.mContactsManagerLazy;
  }

  public dagger.a<com.viber.voip.contacts.c.d.m> getLazyContactsQueryHelper()
  {
    if (this.mContactsQueryHelperLazy == null)
      this.mContactsQueryHelperLazy = new com.viber.voip.g.b.b()
      {
        protected com.viber.voip.contacts.c.d.m a()
        {
          return ViberApplication.this.getContactManager().c();
        }
      };
    return this.mContactsQueryHelperLazy;
  }

  @Deprecated
  public dagger.a<bn> getLazyMessageControllerUtils()
  {
    return this.mMessageControllerUtils;
  }

  @Deprecated
  public dagger.a<com.viber.voip.messages.k> getLazyMessagesManager()
  {
    return this.mMessagesManager;
  }

  @Deprecated
  public dagger.a<com.viber.voip.analytics.story.e.c> getLazyMessagesTracker()
  {
    return this.mMessagesTracker;
  }

  @Deprecated
  public dagger.a<com.viber.voip.analytics.story.b.a.h> getLazyUserStartsCallEventCollector()
  {
    return this.mUserStartsCallEventCollector;
  }

  public com.viber.voip.l.b getLocaleDataCache()
  {
    return getLanguageUpdateController().a(getApplicationContext());
  }

  public com.viber.voip.messages.extras.b.a getLocationManager()
  {
    if ((this.locationManager.get() == null) && (com.viber.voip.o.a.a == com.viber.voip.o.a.a()))
      this.locationManager.set(new com.viber.voip.messages.extras.b.d(d.f.e));
    return (com.viber.voip.messages.extras.b.a)this.locationManager.get();
  }

  public com.viber.voip.storage.c getMediaMountManager()
  {
    if (this.mMediaMountManager == null)
      this.mMediaMountManager = new com.viber.voip.storage.c();
    return this.mMediaMountManager;
  }

  @Deprecated
  public com.viber.voip.messages.k getMessagesManager()
  {
    return (com.viber.voip.messages.k)this.mMessagesManager.get();
  }

  public int getNetworkInfo()
  {
    int i = ((TelephonyManager)getApplicationContext().getSystemService("phone")).getNetworkType();
    L();
    switch (i)
    {
    default:
      return 0;
    case 7:
      return 2751;
    case 4:
      return 2000;
    case 2:
      return 2750;
    case 14:
      return 3004;
    case 5:
      return 3001;
    case 6:
      return 3002;
    case 12:
      return 3003;
    case 1:
      return 2500;
    case 8:
      return 3500;
    case 10:
      return 3006;
    case 15:
      return 3502;
    case 9:
      return 3501;
    case 11:
      return 2001;
    case 13:
      return 4000;
    case 3:
      return 3000;
    case 0:
    }
    return 0;
  }

  @Deprecated
  public dagger.a<com.viber.voip.notif.f> getNotificationManagerWrapper()
  {
    return this.mNotificationManagerWrapper;
  }

  public com.viber.voip.notif.g getNotifier()
  {
    Engine localEngine;
    Handler localHandler;
    com.viber.voip.stickers.i locali;
    com.viber.voip.stickers.b localb;
    if (this.mNotifier == null)
    {
      this.BT.a("APP START", "getNotifier");
      localEngine = getEngine(false);
      localHandler = av.e.d.a();
      locali = com.viber.voip.stickers.i.a();
      localb = com.viber.voip.stickers.b.e();
    }
    try
    {
      if (this.mNotifier == null)
      {
        dd.b();
        com.viber.voip.notif.i.l locall = new com.viber.voip.notif.i.l(this.mRingtonePlayer, localb);
        com.viber.voip.notif.d.j localj = new com.viber.voip.notif.d.j(new com.viber.voip.notif.d.i(getApplicationContext(), locall), new com.viber.voip.notif.c.o(), new com.viber.voip.notif.a.g(), new com.viber.voip.notif.f.f(getApplicationContext(), this.mParticipantManager, getCacheManager()), new com.viber.voip.notif.d.a(getApplicationContext()));
        com.viber.voip.g.b.b local2 = new com.viber.voip.g.b.b()
        {
          protected com.viber.voip.notif.h.l a()
          {
            return new com.viber.voip.notif.h.l(com.viber.voip.flatbuffers.b.e.a().a());
          }
        };
        com.viber.voip.notif.i.k localk = new com.viber.voip.notif.i.k(getApplicationContext(), localHandler);
        t localt = new t(getApplicationContext(), localj, local2, this.mNotificationManagerWrapper);
        v localv = localt.a();
        com.viber.voip.notif.e.m localm = localt.a(localHandler, this.mRingtonePlayer, locall, this.mSyncDataBetweenDevicesManager);
        com.viber.voip.notif.e.b localb1 = localt.a(localEngine, getAppBackgroundChecker());
        u localu = localt.a(localEngine, av.a(av.e.d));
        com.viber.voip.notif.b.f.b.p localp = new com.viber.voip.notif.b.f.b.p(this.mEmoticonStore, this.mEmoticonHelper, this.mParticipantManager, new q());
        com.viber.voip.notif.e.s locals = localt.a(localHandler, this.mContactsQueryHelper, this.mParticipantManager, this.mParticipantInfoQueryHelperImpl, this.mParticipantQueryHelper, this.mMessageQueryHelper, new af(), locall, locali, localk, localp, this.mHandledCloudMessagesHolder);
        n localn = localt.a(localHandler, this.mParticipantInfoQueryHelperImpl, this.mMessageQueryHelper, locall, localk);
        com.viber.voip.notif.e.a locala = localt.b();
        com.viber.voip.notif.e.h localh = localt.a(localHandler, this.mMessageQueryHelper, localk, locall, this.mParticipantManager, localp);
        Context localContext = getApplicationContext();
        dagger.a locala1 = this.mNotificationManagerWrapper;
        com.viber.voip.banner.notificationsoff.c localc = new com.viber.voip.banner.notificationsoff.c(getApplicationContext(), this.mNotificationManagerWrapper, av.e.a.a());
        this.mNotifier = new com.viber.voip.notif.g(localContext, locala1, localv, localm, localb1, localu, locals, localn, locala, localh, localc, localk);
      }
      this.BT.b("APP START", "getNotifier");
      return this.mNotifier;
    }
    finally
    {
    }
  }

  public com.viber.voip.messages.d.b getParticipantManager()
  {
    return (com.viber.voip.messages.d.b)this.mParticipantManager.get();
  }

  @Deprecated
  public com.viber.common.permission.c getPermissionManager()
  {
    return (com.viber.common.permission.c)this.mPermissionManager.get();
  }

  public PhoneApp getPhoneApp()
  {
    if (this.phoneApp == null)
      this.phoneApp = new PhoneApp(getApplicationContext());
    return this.phoneApp;
  }

  public final com.viber.voip.messages.ui.media.player.d.e getPlayerWindowManager()
  {
    if (this.mPlayerWindowManager == null)
      this.mPlayerWindowManager = new com.viber.voip.messages.ui.media.player.d.e(getApplication(), getEngine(false), getAppBackgroundChecker(), com.viber.voip.analytics.g.a(), av.e.a.a(), getMessagesManager(), com.viber.voip.h.a.b(), this.mChatExtensionConfig, this.mMessagesTracker);
    return this.mPlayerWindowManager;
  }

  public com.viber.voip.calls.d getRecentCallsManager()
  {
    return com.viber.voip.calls.e.a(this);
  }

  public com.viber.voip.calls.h getRecentLetterManager()
  {
    if (this.mRecentsLettersToNumbersManager == null)
      this.mRecentsLettersToNumbersManager = new com.viber.voip.calls.h(getApplicationContext());
    return this.mRecentsLettersToNumbersManager;
  }

  public RefWatcher getRefWatcher()
  {
    return (RefWatcher)this.refWatcher.get();
  }

  public com.viber.voip.registration.ah getRequestCreator()
  {
    if (this.mRequestCreator == null)
      this.mRequestCreator = new com.viber.voip.registration.ah(this, getApplicationContext(), getHardwareParameters(), getUserManager().getRegistrationValues(), getFcmTokenController());
    return this.mRequestCreator;
  }

  public com.viber.voip.fcm.f getRetrieveDataOnRestrictBGHandler(com.viber.voip.c.a parama)
  {
    Engine localEngine;
    EventBus localEventBus;
    com.viber.voip.notif.e.m localm;
    if ((this.mRetrieveDataOnRestrictBGHandler == null) && (parama != null))
    {
      localEngine = getEngine(false);
      localEventBus = com.viber.voip.h.a.b();
      localm = getNotifier().a();
    }
    try
    {
      if (this.mRetrieveDataOnRestrictBGHandler == null)
        this.mRetrieveDataOnRestrictBGHandler = new com.viber.voip.fcm.f(getApplicationContext(), localEventBus, localm, localEngine.getDelegatesManager().getServiceStateListener(), localEngine.getDelegatesManager().getMessengerRecentMessagesEndedListener(), localEngine.getPhoneController(), parama);
      return this.mRetrieveDataOnRestrictBGHandler;
    }
    finally
    {
    }
  }

  public IRingtonePlayer getRingtonePlayer()
  {
    return (IRingtonePlayer)this.mRingtonePlayer.get();
  }

  public dagger.a<IRingtonePlayer> getRingtonePlayerLazy()
  {
    return this.mRingtonePlayer;
  }

  public ISoundService getSoundService()
  {
    return (ISoundService)this.mSoundService.get();
  }

  public <T> T getSystemService(String paramString)
  {
    return sApplication.getSystemService(paramString);
  }

  @Deprecated
  public dagger.a<com.viber.voip.ui.j.av> getThemeController()
  {
    return this.mThemeController;
  }

  public com.viber.voip.notif.h getUpdateViberManager()
  {
    return this.mUpdateViberManager;
  }

  @Deprecated
  public UserManager getUserManager()
  {
    return getEngine(false).getUserManager();
  }

  @Deprecated
  public com.viber.voip.messages.extras.c.a getVKManager()
  {
    return (com.viber.voip.messages.extras.c.a)this.mVKManager.get();
  }

  public ViberIdController getViberIdController()
  {
    if (this.mViberIdController == null)
      createViberIdControllerLazy();
    return (ViberIdController)this.mViberIdController.get();
  }

  public ViberInInfo getViberInInfo()
  {
    L();
    return this.mViberInInfo;
  }

  public com.viber.voip.wallet.a getWalletController()
  {
    if (this.mWalletController == null)
    {
      Engine localEngine = getEngine(false);
      this.mWalletController = new com.viber.voip.wallet.a(getApplicationContext(), localEngine.getPhoneController(), localEngine.getWalletController(), getContactManager(), getUserManager());
    }
    return this.mWalletController;
  }

  public void handleUnknownDialog(String paramString)
  {
    getEngine(true).getDialerController().handleDialogReply(2, paramString);
  }

  public void initApplication()
  {
    boolean bool = true;
    if (this.mInitApplicationCalled)
    {
      L();
      return;
    }
    this.mInitApplicationCalled = bool;
    if (!getInstance().getEngine(false).isReady());
    ay localay;
    Handler localHandler;
    while (true)
    {
      localay = new ay(this);
      localHandler = av.e.b.a();
      if (!bool)
        break;
      localHandler.postDelayed(localay, 100L);
      return;
      bool = false;
    }
    localHandler.post(localay);
  }

  public boolean isActivityOnForeground(String[] paramArrayOfString)
  {
    String str = getActivityOnForeground();
    boolean bool = false;
    int i;
    if (str != null)
      i = paramArrayOfString.length;
    for (int j = 0; ; j++)
    {
      bool = false;
      if (j < i)
      {
        if (str.equals(paramArrayOfString[j]))
          bool = true;
      }
      else
      {
        L();
        return bool;
      }
    }
  }

  public boolean isConnectivityTestOn()
  {
    boolean bool = d.af.g.d();
    L();
    return bool;
  }

  public boolean isInitApplicationCalled()
  {
    return this.mInitApplicationCalled;
  }

  public boolean isOnForeground()
  {
    return getAppBackgroundChecker().b();
  }

  public void logToCrashlytics(String paramString)
  {
    if ((!da.b(paramString)) && (c.a.a.a.c.i()))
      com.crashlytics.android.a.a(paramString);
  }

  public void logToCrashlytics(Throwable paramThrowable)
  {
    if (c.a.a.a.c.i())
      com.crashlytics.android.a.a(paramThrowable);
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    if (com.viber.voip.o.a.b())
    {
      getLanguageUpdateController().a(paramConfiguration);
      this.countryCodeManager.set(null);
    }
  }

  public void onCreate()
  {
    if (ProcessPhoenix.a(getApplicationContext()));
    boolean bool1;
    do
    {
      return;
      bk.a(getApplicationContext());
      this.BT = com.viber.voip.e.a.e.b();
      this.BT.a("APP START", "Application onCreate");
      this.BT.a("APP START", "total", "Application onCreate start");
      new com.viber.voip.g.b.b(false, true)
      {
        protected com.viber.voip.ui.j.av a()
        {
          return (com.viber.voip.ui.j.av)ViberApplication.this.mThemeController.get();
        }
      };
      L();
      this.BT.a("APP START", "Application mGlobalEventBus.register");
      this.mGlobalEventBus.register(this);
      this.BT.b("APP START", "Application mGlobalEventBus.register");
      bool1 = isTablet(getApplicationContext());
      this.BT.a("APP START", "Application onCreate", "phase 0");
      boolean bool2 = isActivated();
      ap.b().a();
      initClientBaseFactory();
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
      {
        av.a(getEngine(false), bool2);
        initLazyDependencies(bool1);
        com.viber.voip.flatbuffers.b.e.a(getApplicationContext(), com.viber.voip.flatbuffers.b.e.a.valueOf(d.ai.a.d()));
        this.mUpdateViberManager = com.viber.voip.notif.h.a();
        getChatExtensionsNewDetailsChecker().a();
        this.BT.a("APP START", "Application onCreate", "engine created");
      }
      if (com.viber.voip.o.a.a() != com.viber.voip.o.a.a)
        ViberEnv.getPixieController().init();
      com.viber.a.a.a().b();
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
        av.e.b.a().post(new Runnable()
        {
          public void run()
          {
            com.viber.common.d.i.a();
            ViberEnv.getPixieController().init();
          }
        });
      this.mLifecycleListener = new ax(getActivationController(), getAppBackgroundChecker());
      getApplication().registerActivityLifecycleCallbacks(this.mLifecycleListener);
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
      {
        this.mAnalyticsAppForegroundChangeListener = new com.viber.voip.analytics.d.a(av.e.a.a(), new com.viber.voip.util.i.a());
        getApplication().registerActivityLifecycleCallbacks(this.mAnalyticsAppForegroundChangeListener);
      }
      this.BT.a("APP START", "Application onCreate", "lifecycleListener registred");
    }
    while (com.viber.voip.o.a.a() != com.viber.voip.o.a.a);
    this.mComponentsManager.a(bool1);
    this.BT.a("APP START", "Application onCreate", "initiateComponents done");
    this.mRemoteSplashDisplayController.get();
    getRefWatcher();
    com.viber.voip.util.k.a.a();
    extraSetup();
    this.mVKManager.get();
    this.BT.b("APP START", "Application onCreate");
    this.BT.a("APP START", "total", "Application onCreate end");
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onEvent(b.a parama)
  {
    if (!parama.b)
      this.mComponentsManager.a(parama.a);
  }

  public void onLowMemory()
  {
    L();
    getCacheManager().b();
  }

  public void onOutOfMemory()
  {
    L();
    getCacheManager().a();
  }

  public void onTerminate()
  {
    L();
    try
    {
      if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
      {
        getContactManager().a();
        getRecentCallsManager().a();
        com.viber.voip.stickers.i.a().s();
        com.viber.voip.schedule.d.a().d();
      }
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public void onTrimMemory(int paramInt)
  {
    L();
    if (com.viber.voip.o.a.a() == com.viber.voip.o.a.a)
    {
      getAppBackgroundChecker().a(paramInt);
      com.viber.voip.stickers.i.a().r();
    }
    getCacheManager().a(paramInt);
  }

  public void preEngineInit(Engine paramEngine)
  {
    this.BT.a("APP START", "preEngineInit");
    if (this.preEngineInitStarted)
      return;
    this.preEngineInitStarted = true;
    dd.b();
    ((ConferenceCallsRepository)this.mConferenceCallsRepository.get()).initialize();
    ((ConferenceParticipantsRepository)this.mConferenceParticipantsRepository.get()).initialize();
    initAnalytics();
    com.viber.voip.memberid.d.a(getApplicationContext(), this, paramEngine);
    getNotifier();
    this.BT.a("APP START", "registerPhoneControllerListeners");
    registerPhoneControllerListeners(paramEngine);
    this.BT.b("APP START", "registerPhoneControllerListeners");
    com.viber.voip.publicaccount.d.a.a();
    initMessagesBackup();
    getViberIdController();
    getChangePhoneNumberController();
    initContactsMidToEMidMapper();
    getFacebookManager();
    getLanguageUpdateController();
    ((com.viber.voip.engagement.b)this.mEngagementMediaPreloader.get()).a();
    this.mGdprTrackingOptionsWatcher = new com.viber.voip.gdpr.c(com.viber.voip.gdpr.f.a(getApplicationContext()), new com.viber.voip.gdpr.b(), getEngine(false).getCdrController(), this.mConsentController, com.viber.voip.h.a.b());
    this.mGdprTrackingOptionsWatcher.a();
    getSoundService();
    this.BT.b("APP START", "preEngineInit");
  }

  public dagger.android.b<Service> serviceInjector()
  {
    return this.mServiceInjector;
  }

  public void setActivated(boolean paramBoolean)
  {
    L();
    com.viber.voip.settings.b.e.a.m.a(paramBoolean);
    Engine localEngine = getEngine(true);
    PhoneController localPhoneController = localEngine.getPhoneController();
    if (!paramBoolean)
    {
      this.activationController.clearState();
      localPhoneController.resetDeviceKey();
      localPhoneController.disconnect();
      localEngine.removeDelegate(this.mCallBackListener);
      this.mUpdateViberManager.j();
    }
    while (true)
    {
      com.viber.voip.analytics.g.a().a(paramBoolean);
      return;
      getEngine(true).getPhoneController().resetDeviceKey();
      localPhoneController.setDeviceKey(com.viber.voip.util.z.b(this.activationController.getDeviceKey()));
      if (c.a.a.a.c.i())
        com.crashlytics.android.a.a("country_code", this.activationController.getCountryCodeInt());
      localEngine.registerDelegate(this.mCallBackListener);
      d.b.c.b();
      RegistrationReminderMessageReceiver.b(getApplicationContext());
      av.a(av.e.b).post(new bb(this));
    }
  }

  public void setConnectivityTestMode(boolean paramBoolean)
  {
    L();
    d.af.g.a(paramBoolean);
  }

  @Deprecated
  public boolean shouldBlockAllActivities()
  {
    return ((com.viber.voip.backup.c)this.mBackupBackgroundListener.get()).a();
  }

  protected void showSwitchToGSMDialog(String paramString)
  {
    ViberDialogHandlers.z localz = new ViberDialogHandlers.z();
    localz.a = paramString;
    com.viber.voip.ui.dialogs.b.b().a(localz).d();
  }

  public void showToast(int paramInt)
  {
    showToast(getApplicationContext().getString(paramInt));
  }

  public void showToast(final String paramString)
  {
    av.a(av.e.a).post(new Runnable()
    {
      public void run()
      {
        Toast.makeText(ViberApplication.this.getApplicationContext(), paramString, 0).show();
      }
    });
  }

  protected void showUnknownDialog(int paramInt, String paramString)
  {
    String[] arrayOfString = new String[1];
    arrayOfString[0] = PhoneFragmentActivity.class.getName();
    if ((isActivityOnForeground(arrayOfString)) && (isOnForeground()))
    {
      com.viber.voip.ui.dialogs.b.a(paramString).d();
      return;
    }
    handleUnknownDialog(paramString);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.mFragmentInjector;
  }

  private class a extends PhoneControllerDelegateAdapter
    implements ConnectionDelegate, DialerControllerDelegate.DialerCallback
  {
    private int b = 0;

    private a()
    {
    }

    public void hideCallBack()
    {
      ViberApplication.L();
    }

    public void onConnect()
    {
      ViberApplication.L();
      if (this.b > 0)
        ViberApplication.this.getActivationController().reportActivationParams("Invalid deactivation. User was deactivated by mistake");
    }

    public void onConnectionStateChange(int paramInt)
    {
    }

    public void onShouldRegister()
    {
      ViberApplication.L();
      this.b = (1 + this.b);
      if (this.b <= 1)
      {
        ViberApplication.this.getEngine(true).getPhoneController().disconnect();
        ViberApplication.this.getEngine(true).getPhoneController().setDeviceKey(com.viber.voip.util.z.b(ViberApplication.this.activationController.getDeviceKey()));
        ViberApplication.this.getEngine(true).getPhoneController().connect();
        return;
      }
      ActivationController localActivationController = ViberApplication.this.getActivationController();
      localActivationController.reportActivationParams("ShouldRegister");
      localActivationController.deactivatedFromServer(new bc(this));
    }

    public void showCallBack(int paramInt1, int paramInt2)
    {
      ViberApplication.L();
    }

    public void showCallBlocked(int paramInt1, int paramInt2)
    {
      ViberApplication.L();
    }

    public void showDialog(int paramInt, String paramString)
    {
      ViberApplication.L();
      ViberApplication.this.doShowDialog(paramInt, paramString);
    }

    public void switchToGSM(String paramString)
    {
      ViberApplication.L();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.ViberApplication
 * JD-Core Version:    0.6.2
 */