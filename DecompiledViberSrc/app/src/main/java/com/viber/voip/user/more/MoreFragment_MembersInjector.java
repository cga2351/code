package com.viber.voip.user.more;

import com.viber.jni.cdr.ICdrController;
import com.viber.voip.analytics.g;
import com.viber.voip.news.q;
import com.viber.voip.notif.f;
import com.viber.voip.stickers.i;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.editinfo.UserInfoRepository;
import com.viber.voip.util.cv;
import com.viber.voip.w;
import javax.inject.Provider;

public final class MoreFragment_MembersInjector
  implements dagger.b<MoreFragment>
{
  private final Provider<g> mAnalyticsManagerProvider;
  private final Provider<cv> mBadgesManagerProvider;
  private final Provider<w> mBadgesUpdaterProvider;
  private final Provider<ICdrController> mCdrControllerProvider;
  private final Provider<com.viber.voip.app.b> mDeviceConfigurationProvider;
  private final Provider<com.viber.voip.util.e.e> mImageFetcherProvider;
  private final Provider<f> mNotificationManagerWrapperProvider;
  private final Provider<com.viber.voip.analytics.story.g.a> mOtherEventsTrackerProvider;
  private final Provider<com.viber.common.permission.c> mPermissionManagerProvider;
  private final Provider<ProfileNotification> mProfileNotificationProvider;
  private final Provider<com.viber.voip.analytics.story.i.c> mProfileTrackerProvider;
  private final Provider<com.viber.voip.publicaccount.d.a> mPublicAccountAccessibilityControllerProvider;
  private final Provider<com.viber.voip.rakuten.a> mRakutenControllerProvider;
  private final Provider<i> mStickerControllerProvider;
  private final Provider<UserInfoRepository> mUserInfoRepositoryProvider;
  private final Provider<UserManager> mUserManagerProvider;
  private final Provider<q> mViberNewsManagerProvider;
  private final Provider<com.viber.voip.vln.e> mVlnReactContextManagerProvider;

  public MoreFragment_MembersInjector(Provider<com.viber.voip.app.b> paramProvider, Provider<UserManager> paramProvider1, Provider<ProfileNotification> paramProvider2, Provider<com.viber.voip.rakuten.a> paramProvider3, Provider<com.viber.voip.publicaccount.d.a> paramProvider4, Provider<ICdrController> paramProvider5, Provider<cv> paramProvider6, Provider<f> paramProvider7, Provider<com.viber.common.permission.c> paramProvider8, Provider<com.viber.voip.vln.e> paramProvider9, Provider<g> paramProvider10, Provider<com.viber.voip.analytics.story.g.a> paramProvider11, Provider<com.viber.voip.analytics.story.i.c> paramProvider12, Provider<UserInfoRepository> paramProvider13, Provider<com.viber.voip.util.e.e> paramProvider14, Provider<i> paramProvider15, Provider<w> paramProvider16, Provider<q> paramProvider17)
  {
    this.mDeviceConfigurationProvider = paramProvider;
    this.mUserManagerProvider = paramProvider1;
    this.mProfileNotificationProvider = paramProvider2;
    this.mRakutenControllerProvider = paramProvider3;
    this.mPublicAccountAccessibilityControllerProvider = paramProvider4;
    this.mCdrControllerProvider = paramProvider5;
    this.mBadgesManagerProvider = paramProvider6;
    this.mNotificationManagerWrapperProvider = paramProvider7;
    this.mPermissionManagerProvider = paramProvider8;
    this.mVlnReactContextManagerProvider = paramProvider9;
    this.mAnalyticsManagerProvider = paramProvider10;
    this.mOtherEventsTrackerProvider = paramProvider11;
    this.mProfileTrackerProvider = paramProvider12;
    this.mUserInfoRepositoryProvider = paramProvider13;
    this.mImageFetcherProvider = paramProvider14;
    this.mStickerControllerProvider = paramProvider15;
    this.mBadgesUpdaterProvider = paramProvider16;
    this.mViberNewsManagerProvider = paramProvider17;
  }

  public static dagger.b<MoreFragment> create(Provider<com.viber.voip.app.b> paramProvider, Provider<UserManager> paramProvider1, Provider<ProfileNotification> paramProvider2, Provider<com.viber.voip.rakuten.a> paramProvider3, Provider<com.viber.voip.publicaccount.d.a> paramProvider4, Provider<ICdrController> paramProvider5, Provider<cv> paramProvider6, Provider<f> paramProvider7, Provider<com.viber.common.permission.c> paramProvider8, Provider<com.viber.voip.vln.e> paramProvider9, Provider<g> paramProvider10, Provider<com.viber.voip.analytics.story.g.a> paramProvider11, Provider<com.viber.voip.analytics.story.i.c> paramProvider12, Provider<UserInfoRepository> paramProvider13, Provider<com.viber.voip.util.e.e> paramProvider14, Provider<i> paramProvider15, Provider<w> paramProvider16, Provider<q> paramProvider17)
  {
    return new MoreFragment_MembersInjector(paramProvider, paramProvider1, paramProvider2, paramProvider3, paramProvider4, paramProvider5, paramProvider6, paramProvider7, paramProvider8, paramProvider9, paramProvider10, paramProvider11, paramProvider12, paramProvider13, paramProvider14, paramProvider15, paramProvider16, paramProvider17);
  }

  public static void injectMAnalyticsManager(MoreFragment paramMoreFragment, g paramg)
  {
    paramMoreFragment.mAnalyticsManager = paramg;
  }

  public static void injectMBadgesManager(MoreFragment paramMoreFragment, cv paramcv)
  {
    paramMoreFragment.mBadgesManager = paramcv;
  }

  public static void injectMBadgesUpdater(MoreFragment paramMoreFragment, w paramw)
  {
    paramMoreFragment.mBadgesUpdater = paramw;
  }

  public static void injectMCdrController(MoreFragment paramMoreFragment, ICdrController paramICdrController)
  {
    paramMoreFragment.mCdrController = paramICdrController;
  }

  public static void injectMDeviceConfiguration(MoreFragment paramMoreFragment, com.viber.voip.app.b paramb)
  {
    paramMoreFragment.mDeviceConfiguration = paramb;
  }

  public static void injectMImageFetcher(MoreFragment paramMoreFragment, com.viber.voip.util.e.e parame)
  {
    paramMoreFragment.mImageFetcher = parame;
  }

  public static void injectMNotificationManagerWrapper(MoreFragment paramMoreFragment, dagger.a<f> parama)
  {
    paramMoreFragment.mNotificationManagerWrapper = parama;
  }

  public static void injectMOtherEventsTracker(MoreFragment paramMoreFragment, com.viber.voip.analytics.story.g.a parama)
  {
    paramMoreFragment.mOtherEventsTracker = parama;
  }

  public static void injectMPermissionManager(MoreFragment paramMoreFragment, dagger.a<com.viber.common.permission.c> parama)
  {
    paramMoreFragment.mPermissionManager = parama;
  }

  public static void injectMProfileNotification(MoreFragment paramMoreFragment, ProfileNotification paramProfileNotification)
  {
    paramMoreFragment.mProfileNotification = paramProfileNotification;
  }

  public static void injectMProfileTracker(MoreFragment paramMoreFragment, com.viber.voip.analytics.story.i.c paramc)
  {
    paramMoreFragment.mProfileTracker = paramc;
  }

  public static void injectMPublicAccountAccessibilityController(MoreFragment paramMoreFragment, com.viber.voip.publicaccount.d.a parama)
  {
    paramMoreFragment.mPublicAccountAccessibilityController = parama;
  }

  public static void injectMRakutenController(MoreFragment paramMoreFragment, com.viber.voip.rakuten.a parama)
  {
    paramMoreFragment.mRakutenController = parama;
  }

  public static void injectMStickerController(MoreFragment paramMoreFragment, i parami)
  {
    paramMoreFragment.mStickerController = parami;
  }

  public static void injectMUserInfoRepository(MoreFragment paramMoreFragment, UserInfoRepository paramUserInfoRepository)
  {
    paramMoreFragment.mUserInfoRepository = paramUserInfoRepository;
  }

  public static void injectMUserManager(MoreFragment paramMoreFragment, UserManager paramUserManager)
  {
    paramMoreFragment.mUserManager = paramUserManager;
  }

  public static void injectMViberNewsManager(MoreFragment paramMoreFragment, dagger.a<q> parama)
  {
    paramMoreFragment.mViberNewsManager = parama;
  }

  public static void injectMVlnReactContextManager(MoreFragment paramMoreFragment, dagger.a<com.viber.voip.vln.e> parama)
  {
    paramMoreFragment.mVlnReactContextManager = parama;
  }

  public void injectMembers(MoreFragment paramMoreFragment)
  {
    injectMDeviceConfiguration(paramMoreFragment, (com.viber.voip.app.b)this.mDeviceConfigurationProvider.get());
    injectMUserManager(paramMoreFragment, (UserManager)this.mUserManagerProvider.get());
    injectMProfileNotification(paramMoreFragment, (ProfileNotification)this.mProfileNotificationProvider.get());
    injectMRakutenController(paramMoreFragment, (com.viber.voip.rakuten.a)this.mRakutenControllerProvider.get());
    injectMPublicAccountAccessibilityController(paramMoreFragment, (com.viber.voip.publicaccount.d.a)this.mPublicAccountAccessibilityControllerProvider.get());
    injectMCdrController(paramMoreFragment, (ICdrController)this.mCdrControllerProvider.get());
    injectMBadgesManager(paramMoreFragment, (cv)this.mBadgesManagerProvider.get());
    injectMNotificationManagerWrapper(paramMoreFragment, dagger.a.c.b(this.mNotificationManagerWrapperProvider));
    injectMPermissionManager(paramMoreFragment, dagger.a.c.b(this.mPermissionManagerProvider));
    injectMVlnReactContextManager(paramMoreFragment, dagger.a.c.b(this.mVlnReactContextManagerProvider));
    injectMAnalyticsManager(paramMoreFragment, (g)this.mAnalyticsManagerProvider.get());
    injectMOtherEventsTracker(paramMoreFragment, (com.viber.voip.analytics.story.g.a)this.mOtherEventsTrackerProvider.get());
    injectMProfileTracker(paramMoreFragment, (com.viber.voip.analytics.story.i.c)this.mProfileTrackerProvider.get());
    injectMUserInfoRepository(paramMoreFragment, (UserInfoRepository)this.mUserInfoRepositoryProvider.get());
    injectMImageFetcher(paramMoreFragment, (com.viber.voip.util.e.e)this.mImageFetcherProvider.get());
    injectMStickerController(paramMoreFragment, (i)this.mStickerControllerProvider.get());
    injectMBadgesUpdater(paramMoreFragment, (w)this.mBadgesUpdaterProvider.get());
    injectMViberNewsManager(paramMoreFragment, dagger.a.c.b(this.mViberNewsManagerProvider));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreFragment_MembersInjector
 * JD-Core Version:    0.6.2
 */