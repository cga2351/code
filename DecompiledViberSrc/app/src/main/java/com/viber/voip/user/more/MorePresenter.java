package com.viber.voip.user.more;

import android.arch.lifecycle.h;
import android.text.TextUtils;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.id;
import com.viber.voip.analytics.story.StoryConstants.j.a;
import com.viber.voip.analytics.story.StoryConstants.s.a;
import com.viber.voip.analytics.story.StoryConstants.t.a;
import com.viber.voip.analytics.story.i.c;
import com.viber.voip.i.f;
import com.viber.voip.i.f.a;
import com.viber.voip.mvp.core.BaseMvpPresenter;
import com.viber.voip.mvp.core.State;
import com.viber.voip.news.ViberNewsProviderSpec;
import com.viber.voip.news.q;
import com.viber.voip.permissions.n;
import com.viber.voip.publicaccount.d.a.a;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserData.OwnerChangedEvent;
import com.viber.voip.user.editinfo.UserInfoRepository;
import com.viber.voip.user.more.listitems.providers.ProfileBannerProvider;
import com.viber.voip.user.more.repository.MoreListItemRepository;
import com.viber.voip.user.viberid.ViberIdTriggerStateHolder;
import com.viber.voip.user.viberid.ViberIdTriggerStateHolder.ViberIdTriggerStateChangedEvent;
import com.viber.voip.util.ae;
import com.viber.voip.util.cv;
import com.viber.voip.util.cv.a;
import com.viber.voip.util.dd;
import com.viber.voip.vln.e;
import com.viber.voip.w;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

class MorePresenter extends BaseMvpPresenter<MoreView, State>
  implements f.a, a.a, MorePermissionHelper.PermissionsGrantedListener, MorePrefsListener.PreferencesChangedListener, MoreStickerMarketEventsListener.NewStickerPackageCountChangedListener, MoreVoBalanceInteractor.ViberOutBalanceTextChangedListener, cv.a
{
  private final w mBadgesUpdater;
  private final ICdrController mCdrController;
  private int mCdrOrigin = 1;
  private final DefaultNameProvider mDefaultNameProvider;
  private final EventBus mEventBus;
  private boolean mIsBadgeDisplayed;
  private boolean mIsFirstStart = true;
  private boolean mIsVisible = false;
  private final MoreListItemRepository mMoreListItemRepository;
  private final MorePrefsListener mMorePrefsListener;
  private final MoreScreenConfig mMoreScreenConfig;
  private final MoreStickerMarketInteractor mMoreStickerMarketInteractor;
  private final MoreVoBalanceInteractor mMoreVoBalanceInteractor;
  private final MoreWalletInteractor mMoreWalletInteractor;
  private final com.viber.voip.analytics.story.g.a mOtherEventsTracker;
  private final ProfileBannerProvider mProfileBannerProvider;
  private final ProfileNotification mProfileNotification;
  private final c mProfileTracker;
  private final com.viber.voip.publicaccount.d.a mPublicAccountAccessibilityController;
  private final cv mTabBadgesManager;
  private final UserInfoRepository mUserInfoRepository;
  private final ViberIdTriggerStateHolder mViberIdTriggerStateHolder;
  private final dagger.a<q> mViberNewsManager;
  private final f mVlnFeature;
  private final dagger.a<e> mVlnReactContextManager;

  MorePresenter(MoreVoBalanceInteractor paramMoreVoBalanceInteractor, MoreWalletInteractor paramMoreWalletInteractor, MoreStickerMarketInteractor paramMoreStickerMarketInteractor, MoreListItemRepository paramMoreListItemRepository, UserInfoRepository paramUserInfoRepository, MorePrefsListener paramMorePrefsListener, ProfileNotification paramProfileNotification, com.viber.voip.publicaccount.d.a parama, com.viber.voip.analytics.story.g.a parama1, c paramc, MoreScreenConfig paramMoreScreenConfig, ICdrController paramICdrController, cv paramcv, dagger.a<e> parama2, EventBus paramEventBus, DefaultNameProvider paramDefaultNameProvider, f paramf, ProfileBannerProvider paramProfileBannerProvider, w paramw, ViberIdTriggerStateHolder paramViberIdTriggerStateHolder, dagger.a<q> parama3, boolean paramBoolean)
  {
    this.mMoreVoBalanceInteractor = paramMoreVoBalanceInteractor;
    this.mMoreWalletInteractor = paramMoreWalletInteractor;
    this.mMoreStickerMarketInteractor = paramMoreStickerMarketInteractor;
    this.mMoreListItemRepository = paramMoreListItemRepository;
    this.mUserInfoRepository = paramUserInfoRepository;
    this.mMorePrefsListener = paramMorePrefsListener;
    this.mProfileNotification = paramProfileNotification;
    this.mPublicAccountAccessibilityController = parama;
    this.mOtherEventsTracker = parama1;
    this.mProfileTracker = paramc;
    this.mMoreScreenConfig = paramMoreScreenConfig;
    this.mCdrController = paramICdrController;
    this.mTabBadgesManager = paramcv;
    this.mVlnReactContextManager = parama2;
    this.mEventBus = paramEventBus;
    this.mDefaultNameProvider = paramDefaultNameProvider;
    this.mVlnFeature = paramf;
    this.mProfileBannerProvider = paramProfileBannerProvider;
    this.mBadgesUpdater = paramw;
    this.mViberIdTriggerStateHolder = paramViberIdTriggerStateHolder;
    this.mViberNewsManager = parama3;
    this.mIsVisible = paramBoolean;
  }

  private void checkInviteAction(boolean paramBoolean)
  {
    if ((this.mMoreScreenConfig.isTablet()) && (paramBoolean))
      openShareScreenSafe();
  }

  private List<String> createNotificationList()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mMoreListItemRepository.obtainFilteredListItems(MorePresenter..Lambda.0.$instance).iterator();
    while (localIterator.hasNext())
    {
      String str2 = StoryConstants.s.a.a(((com.viber.voip.settings.a.a)localIterator.next()).a());
      if (!TextUtils.isEmpty(str2))
        localArrayList.add(str2);
    }
    if (this.mProfileNotification.showBanner())
    {
      String str1 = StoryConstants.s.a.b(this.mProfileBannerProvider.getProfileBannerType());
      if (!TextUtils.isEmpty(str1))
        localArrayList.add(str1);
    }
    return localArrayList;
  }

  private boolean isAnyNotificationDisplayed()
  {
    Iterator localIterator = this.mMoreListItemRepository.obtainFilteredListItems(MorePresenter..Lambda.1.$instance).iterator();
    while (localIterator.hasNext())
      if (!TextUtils.isEmpty(StoryConstants.s.a.a(((com.viber.voip.settings.a.a)localIterator.next()).a())))
        return true;
    if (this.mProfileNotification.showBanner())
    {
      if (!TextUtils.isEmpty(StoryConstants.s.a.b(this.mProfileBannerProvider.getProfileBannerType())));
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    return false;
  }

  private void onScreenOpened(State paramState)
  {
    if (paramState == null)
      this.mMoreStickerMarketInteractor.setMoreScreenOpened();
    this.mCdrController.handleReportScreenDisplay(8, this.mCdrOrigin);
  }

  private void openAddContactSafe()
  {
    ((MoreView)this.mView).requestPermissionsWithCheck(1, n.k);
  }

  private void openShareScreenSafe()
  {
    if (this.mMoreScreenConfig.isTablet())
    {
      this.mOtherEventsTracker.a(ae.b(), "More", 1.0D);
      ((MoreView)this.mView).openInviteScreenNative();
      return;
    }
    ((MoreView)this.mView).requestPermissionsWithCheck(4, n.j);
  }

  private void openWallet()
  {
    if (this.mMoreWalletInteractor.isViberWalletAvailable())
    {
      ((MoreView)this.mView).openWalletHomePage();
      return;
    }
    if (this.mMoreWalletInteractor.isWesternUnionWalletAvailable())
    {
      ((MoreView)this.mView).openWalletWuSelectionPage();
      return;
    }
    this.mMoreWalletInteractor.resetNewFeature();
    ((MoreView)this.mView).openRakutenBankApp();
  }

  private void setProfileData()
  {
    if ((this.mMoreScreenConfig.isTablet()) && (this.mMoreScreenConfig.isMoreTab()))
      return;
    ((MoreView)this.mView).setUserPhoneNumber(this.mUserInfoRepository.getPhoneNumberWithPlus());
    ((MoreView)this.mView).setUserName(this.mUserInfoRepository.getNameOrDefault(this.mDefaultNameProvider));
    ((MoreView)this.mView).setUserPhoto(this.mUserInfoRepository.getImageUri());
  }

  private void showQrCodeScannerSafe()
  {
    ((MoreView)this.mView).requestPermissionsWithCheck(0, n.a);
  }

  protected State getSaveState()
  {
    return new MoreState()
    {
    };
  }

  public void onBadgeValueChanged(int paramInt1, int paramInt2)
  {
    if (paramInt1 == 2)
      dd.a(new MorePresenter..Lambda.2(this));
  }

  void onEditOptionItemSelected()
  {
    this.mProfileTracker.a("Edit Pen", isAnyNotificationDisplayed());
    ((MoreView)this.mView).openEditInfo("More Screen - Pen", 0);
  }

  public void onFeatureStateChanged(f paramf)
  {
    if (paramf.c().equals(this.mVlnFeature.c()))
      dd.a(new MorePresenter..Lambda.3(this));
  }

  void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    this.mIsVisible = paramBoolean;
    if (paramBoolean)
    {
      if ((this.mMoreScreenConfig.isTablet()) && (this.mVlnFeature.e()))
        ((e)this.mVlnReactContextManager.get()).a();
      ((MoreView)this.mView).adjustTopBar();
      setProfileData();
      localc = this.mProfileTracker;
      str = ae.b();
      localList = createNotificationList();
      if ((this.mIsBadgeDisplayed) || (this.mBadgesUpdater.b()))
      {
        bool = true;
        localc.a(str, localList, bool);
        this.mIsBadgeDisplayed = false;
        onScreenOpened(null);
      }
    }
    while ((!this.mMoreScreenConfig.isTablet()) || (!this.mVlnFeature.e()))
      while (true)
      {
        c localc;
        String str;
        List localList;
        return;
        boolean bool = false;
      }
    ((e)this.mVlnReactContextManager.get()).b();
  }

  public void onNewStickerPackageCountChanged(int paramInt)
  {
    ((MoreView)this.mView).updateVisibleItem(R.id.market);
  }

  void onNotificationBannerClicked()
  {
    int i = this.mProfileBannerProvider.getProfileBannerType();
    String str1 = StoryConstants.t.a.a(i);
    String str2 = StoryConstants.j.a.a(i);
    if (i == 1);
    for (int j = 1; ; j = 0)
    {
      if (!TextUtils.isEmpty(str1))
        this.mProfileTracker.a(str1, isAnyNotificationDisplayed());
      ((MoreView)this.mView).openEditInfo(str2, j);
      return;
    }
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onOwnerChanged(UserData.OwnerChangedEvent paramOwnerChangedEvent)
  {
    setProfileData();
  }

  public void onPermissionsGranted(int paramInt, String[] paramArrayOfString, Object paramObject)
  {
    switch (paramInt)
    {
    case 2:
    case 3:
    default:
      return;
    case 0:
      ((MoreView)this.mView).openQRScanner();
      return;
    case 1:
      ((MoreView)this.mView).openAddContact();
      return;
    case 4:
    }
    ((MoreView)this.mView).openShareViber();
  }

  void onPrefItemClick(com.viber.voip.settings.a.a parama)
  {
    if (parama == null);
    int i;
    do
    {
      ViberNewsProviderSpec localViberNewsProviderSpec;
      do
      {
        return;
        i = parama.a();
        String str = StoryConstants.t.a.b(i);
        if (!TextUtils.isEmpty(str))
          this.mProfileTracker.a(str, isAnyNotificationDisplayed());
        if (i == R.id.discover)
        {
          ((MoreView)this.mView).openPublicAccounts();
          return;
        }
        if (i != R.id.news)
          break;
        localViberNewsProviderSpec = ((q)this.mViberNewsManager.get()).a();
      }
      while (!localViberNewsProviderSpec.isNewsProviderExists());
      this.mOtherEventsTracker.a("More screen", ae.b(), localViberNewsProviderSpec.getUrl());
      this.mCdrController.handleReportScreenDisplay(6, 1);
      ((MoreView)this.mView).openViberNews();
      return;
      if (i == R.id.share)
      {
        openShareScreenSafe();
        return;
      }
      if (i == R.id.viber_out)
      {
        this.mCdrController.handleReportVoDisplay(1);
        ((MoreView)this.mView).openViberOut();
        return;
      }
      if (i == R.id.viber_local_number)
      {
        ((MoreView)this.mView).openVln(this.mUserInfoRepository.getMemberId(), this.mUserInfoRepository.getPhoneNumber());
        return;
      }
      if (i == R.id.rakuten_account)
      {
        ((MoreView)this.mView).openRakutenAccount();
        return;
      }
      if (i == R.id.market)
      {
        this.mMoreStickerMarketInteractor.setMoreStickerMarketOpened();
        ((MoreView)this.mView).openStickerMarket();
        return;
      }
      if (i == R.id.add_friend)
      {
        openAddContactSafe();
        return;
      }
      if (i == R.id.get_free_stickers)
      {
        ((MoreView)this.mView).openGetFreeStickers();
        return;
      }
      if (i == R.id.settings)
      {
        ((MoreView)this.mView).openSettings();
        return;
      }
      if (i == R.id.desktop_and_tablets)
      {
        ((MoreView)this.mView).openDesktopAndTablets();
        return;
      }
      if (i == R.id.about)
      {
        ((MoreView)this.mView).openAbout();
        return;
      }
      if (i == R.id.send_log)
      {
        ((MoreView)this.mView).openSendLog();
        return;
      }
    }
    while (i != R.id.open_wallet);
    openWallet();
  }

  public void onPreferencesChanged(com.viber.common.b.a parama)
  {
    if (parama.c().equals(this.mProfileNotification.getExpirationPrefKey()))
    {
      ((MoreView)this.mView).bindNotificationBanner();
      return;
    }
    if (parama.c().equals(this.mMoreStickerMarketInteractor.getStatePrefKey()))
    {
      ((MoreView)this.mView).updateVisibleItem(R.id.market);
      return;
    }
    ((MoreView)this.mView).updateVisibleItems();
  }

  void onQrCodeOptionItemSelected()
  {
    this.mProfileTracker.a("QR Code", isAnyNotificationDisplayed());
    showQrCodeScannerSafe();
  }

  public void onStart(h paramh)
  {
    super.onStart(paramh);
    this.mVlnFeature.a(this);
    this.mTabBadgesManager.a(this);
    this.mPublicAccountAccessibilityController.a(this);
    this.mMorePrefsListener.register(this);
    this.mMoreVoBalanceInteractor.fetchBalance(this);
    this.mMoreStickerMarketInteractor.register(this);
    this.mViberIdTriggerStateHolder.register(this);
    if (!this.mEventBus.isRegistered(this))
      this.mEventBus.register(this);
    ((MoreView)this.mView).registerPermissionsGrantedListener(this);
    if ((this.mIsVisible) && (this.mIsFirstStart))
    {
      this.mIsFirstStart = false;
      ((MoreView)this.mView).adjustTopBar();
    }
    ((MoreView)this.mView).updateVisibleItems();
    ((MoreView)this.mView).bindNotificationBanner();
    setProfileData();
  }

  public void onStop(h paramh)
  {
    super.onStop(paramh);
    this.mVlnFeature.b(this);
    this.mTabBadgesManager.b(this);
    this.mPublicAccountAccessibilityController.b(this);
    this.mMorePrefsListener.unregister();
    this.mMoreVoBalanceInteractor.stopBalanceFetching();
    this.mEventBus.unregister(this);
    this.mMoreStickerMarketInteractor.unregister();
    this.mViberIdTriggerStateHolder.unregister();
    ((MoreView)this.mView).unregisterPermissionsGrantedListener();
  }

  void onSubtitleClicked()
  {
    ((MoreView)this.mView).openEditInfo("More Screen - Name", 0);
  }

  void onTitleClicked()
  {
    ((MoreView)this.mView).openEditInfo("More Screen - Name", 0);
  }

  void onUserPhotoClicked()
  {
    this.mProfileTracker.a("Profile Picture", isAnyNotificationDisplayed());
    ((MoreView)this.mView).openEditInfo("More Screen - Photo", 0);
  }

  @Subscribe(threadMode=ThreadMode.MAIN)
  public void onViberIdTriggerStateChanged(ViberIdTriggerStateHolder.ViberIdTriggerStateChangedEvent paramViberIdTriggerStateChangedEvent)
  {
    ((MoreView)this.mView).updateVisibleItems();
  }

  public void onViberOutBalanceTextChanged(CharSequence paramCharSequence)
  {
    ((MoreView)this.mView).updateViberOutBalanceText(paramCharSequence);
    ((MoreView)this.mView).updateVisibleItem(R.id.viber_out);
  }

  public void onVibesStateChanged(int paramInt)
  {
    ((MoreView)this.mView).updateVisibleItems();
  }

  protected void onViewAttached(State paramState)
  {
    super.onViewAttached(paramState);
    ((MoreView)this.mView).setItems(this.mMoreListItemRepository.obtainListItems());
    ((MoreView)this.mView).setEditMenuItemVisibility(this.mMoreScreenConfig.isEditOptionsItemVisible());
    this.mIsBadgeDisplayed = this.mBadgesUpdater.b();
    this.mProfileNotification.resetBadge();
    if (this.mUserInfoRepository.isViberImageRemoved())
      com.viber.voip.contacts.c.a.a(this.mUserInfoRepository.getPhoneNumberWithPlus(), null);
    if (!this.mMoreScreenConfig.isMoreTab())
      onScreenOpened(paramState);
  }

  void reloadFromArguments(MoreArguments paramMoreArguments)
  {
    this.mCdrOrigin = paramMoreArguments.getCdrOrigin();
    checkInviteAction(paramMoreArguments.showShare());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MorePresenter
 * JD-Core Version:    0.6.2
 */