package com.viber.voip.user.more;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.jni.cdr.ICdrController;
import com.viber.voip.R.attr;
import com.viber.voip.R.layout;
import com.viber.voip.ViberApplication;
import com.viber.voip.analytics.g.a.a;
import com.viber.voip.app.b;
import com.viber.voip.i.c.p;
import com.viber.voip.news.q;
import com.viber.voip.notif.f;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.schedule.d;
import com.viber.voip.schedule.o;
import com.viber.voip.settings.d.ae;
import com.viber.voip.settings.d.bh;
import com.viber.voip.settings.d.bm;
import com.viber.voip.settings.d.bm.a;
import com.viber.voip.stickers.i;
import com.viber.voip.user.ProfileNotification;
import com.viber.voip.user.UserManager;
import com.viber.voip.user.editinfo.UserInfoRepository;
import com.viber.voip.user.more.listitems.creators.AboutItemCreator;
import com.viber.voip.user.more.listitems.creators.AddFriendItemCreator;
import com.viber.voip.user.more.listitems.creators.DesktopAndTabletsItemCreator;
import com.viber.voip.user.more.listitems.creators.DiscoverItemCreator;
import com.viber.voip.user.more.listitems.creators.DividerItemCreator;
import com.viber.voip.user.more.listitems.creators.GetFreeStickersItemCreator;
import com.viber.voip.user.more.listitems.creators.InviteFriendsItemCreator;
import com.viber.voip.user.more.listitems.creators.PreferenceItemCreator;
import com.viber.voip.user.more.listitems.creators.ProfileNotificationItemCreator;
import com.viber.voip.user.more.listitems.creators.RakutenItemCreator;
import com.viber.voip.user.more.listitems.creators.SendLogItemCreator;
import com.viber.voip.user.more.listitems.creators.SettingsItemCreator;
import com.viber.voip.user.more.listitems.creators.StickerMarketItemCreator;
import com.viber.voip.user.more.listitems.creators.ViberNewsItemCreator;
import com.viber.voip.user.more.listitems.creators.ViberOutItemCreator;
import com.viber.voip.user.more.listitems.creators.VlnItemCreator;
import com.viber.voip.user.more.listitems.creators.WalletItemCreator;
import com.viber.voip.user.more.listitems.providers.ProfileBannerProvider;
import com.viber.voip.user.more.listitems.providers.StickerPackagesCountProvider;
import com.viber.voip.user.more.listitems.providers.StickerPackagesTextProvider;
import com.viber.voip.user.more.listitems.providers.ViberOutInfoProvider;
import com.viber.voip.user.more.repository.MoreListItemRepository;
import com.viber.voip.user.more.repository.MoreListItemsSortOrder;
import com.viber.voip.user.viberid.ViberIdTriggerStateHolder;
import com.viber.voip.util.bp;
import com.viber.voip.util.cv;
import com.viber.voip.util.dc;
import com.viber.voip.w;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;

public class MoreFragment extends com.viber.voip.mvp.core.g<MoreViewImpl>
{
  public static final String EXTRA_CDR_ORIGIN = "cdr_origin";
  public static final String EXTRA_SHOW_SHARE = "show_share";

  @Inject
  com.viber.voip.analytics.g mAnalyticsManager;

  @Inject
  cv mBadgesManager;

  @Inject
  w mBadgesUpdater;
  private Callbacks mCallbacks;

  @Inject
  ICdrController mCdrController;

  @Inject
  b mDeviceConfiguration;

  @Inject
  com.viber.voip.util.e.e mImageFetcher;
  private boolean mIsVisible = false;
  private ViberOutInfoProvider mLatestViberOutBalance;
  private MoreListItemsSortOrder mMoreListItemsSortOrder;
  private MoreScreenConfig mMoreScreenConfig;
  private MoreStickerMarketEventsListener mMoreStickerMarketEventsListener;
  private MoreStickerMarketSubTextState mMoreStickerMarketSubTextState;
  private MoreViewImpl mMoreView;

  @Inject
  dagger.a<f> mNotificationManagerWrapper;

  @Inject
  com.viber.voip.analytics.story.g.a mOtherEventsTracker;
  private k mPermissionConfig;

  @Inject
  dagger.a<com.viber.common.permission.c> mPermissionManager;
  private ProfileBannerProvider mProfileBannerProvider;

  @Inject
  ProfileNotification mProfileNotification;

  @Inject
  com.viber.voip.analytics.story.i.c mProfileTracker;

  @Inject
  com.viber.voip.publicaccount.d.a mPublicAccountAccessibilityController;

  @Inject
  com.viber.voip.rakuten.a mRakutenController;

  @Inject
  i mStickerController;
  private o mStickerPackagesCountManager;

  @Inject
  UserInfoRepository mUserInfoRepository;

  @Inject
  UserManager mUserManager;
  private ViberIdTriggerStateHolder mViberIdTriggerStateHolder;

  @Inject
  dagger.a<q> mViberNewsManager;

  @Inject
  dagger.a<com.viber.voip.vln.e> mVlnReactContextManager;
  private com.viber.voip.wallet.a mWalletController;

  private List<PreferenceItemCreator> getItemCreators(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList(20);
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return localArrayList;
    localArrayList.add(new ProfileNotificationItemCreator(paramContext, this.mProfileBannerProvider));
    localArrayList.add(new ViberNewsItemCreator(paramContext, this.mBadgesManager, this.mViberNewsManager));
    localArrayList.add(new StickerMarketItemCreator(paramContext, new StickerPackagesCountProvider(this.mStickerPackagesCountManager), new StickerPackagesTextProvider(paramContext, this.mMoreStickerMarketSubTextState)));
    localArrayList.add(new ViberOutItemCreator(paramContext, this.mLatestViberOutBalance));
    localArrayList.add(new VlnItemCreator(paramContext, c.p.a, d.bh.b, d.bh.a, dc.d(localFragmentActivity, R.attr.textBalanceOkItemSettingsColor)));
    localArrayList.add(new DividerItemCreator(paramContext));
    localArrayList.add(new SettingsItemCreator(paramContext, this.mNotificationManagerWrapper));
    localArrayList.add(new GetFreeStickersItemCreator(paramContext, this.mViberIdTriggerStateHolder));
    localArrayList.add(new AddFriendItemCreator(paramContext));
    localArrayList.add(new InviteFriendsItemCreator(paramContext));
    localArrayList.add(new DesktopAndTabletsItemCreator(paramContext));
    localArrayList.add(new AboutItemCreator(paramContext));
    localArrayList.add(new DiscoverItemCreator(paramContext, this.mPublicAccountAccessibilityController));
    localArrayList.add(new RakutenItemCreator(paramContext, this.mRakutenController));
    localArrayList.add(new WalletItemCreator(paramContext, this.mWalletController, d.bm.j, dc.d(localFragmentActivity, R.attr.textWalletItemSettingsColor)));
    localArrayList.add(new SendLogItemCreator(paramContext));
    return localArrayList;
  }

  protected void createViewPresenters(View paramView, Bundle paramBundle)
  {
    FragmentActivity localFragmentActivity = getActivity();
    if (localFragmentActivity == null)
      return;
    Context localContext = bp.c(localFragmentActivity.getApplicationContext());
    MoreVoBalanceInteractor localMoreVoBalanceInteractor = new MoreVoBalanceInteractor(localContext, com.viber.voip.viberout.a.a());
    MoreWalletInteractor localMoreWalletInteractor = new MoreWalletInteractor(this.mWalletController, d.bm.j, d.bm.a.a);
    MoreStickerMarketInteractor localMoreStickerMarketInteractor = new MoreStickerMarketInteractor(this.mStickerController, this.mMoreStickerMarketEventsListener, this.mMoreStickerMarketSubTextState);
    MoreListItemRepository localMoreListItemRepository = new MoreListItemRepository(getItemCreators(localContext), this.mMoreListItemsSortOrder);
    UserInfoRepository localUserInfoRepository = this.mUserInfoRepository;
    com.viber.common.b.a[] arrayOfa = new com.viber.common.b.a[9];
    arrayOfa[0] = d.ae.a;
    arrayOfa[1] = d.bm.b;
    arrayOfa[2] = d.bm.a;
    arrayOfa[3] = d.bm.i;
    arrayOfa[4] = d.bm.j;
    arrayOfa[5] = d.bh.b;
    arrayOfa[6] = d.bh.a;
    arrayOfa[7] = d.ae.a;
    arrayOfa[8] = d.ae.c;
    MorePresenter localMorePresenter = new MorePresenter(localMoreVoBalanceInteractor, localMoreWalletInteractor, localMoreStickerMarketInteractor, localMoreListItemRepository, localUserInfoRepository, new MorePrefsListener(arrayOfa), this.mProfileNotification, this.mPublicAccountAccessibilityController, this.mOtherEventsTracker, this.mProfileTracker, this.mMoreScreenConfig, this.mCdrController, this.mBadgesManager, this.mVlnReactContextManager, com.viber.voip.h.a.b(), new DefaultNameProvider(localContext, dc.d(localFragmentActivity, R.attr.moreEmptyNameColor)), c.p.a, this.mProfileBannerProvider, this.mBadgesUpdater, this.mViberIdTriggerStateHolder, this.mViberNewsManager, this.mIsVisible);
    this.mMoreView = new MoreViewImpl(this, localMorePresenter, new MoreRouterImpl(localFragmentActivity, this.mCallbacks, this.mRakutenController), new MorePermissionHelperImpl(this, this.mPermissionManager, this.mPermissionConfig), paramView, new MoreArguments(localFragmentActivity.getIntent()), this.mProfileBannerProvider, this.mLatestViberOutBalance, this.mImageFetcher, this.mMoreScreenConfig);
    addMvpView(this.mMoreView, localMorePresenter, paramBundle);
  }

  protected void initModelComponent(View paramView, Bundle paramBundle)
  {
    Context localContext = paramView.getContext();
    ProfileNotification localProfileNotification = this.mProfileNotification;
    if ((this.mMoreScreenConfig.isTablet()) && (this.mMoreScreenConfig.isMoreTab()));
    for (boolean bool = true; ; bool = false)
    {
      this.mProfileBannerProvider = new ProfileBannerProvider(localContext, localProfileNotification, bool);
      this.mViberIdTriggerStateHolder = new ViberIdTriggerStateHolder(ViberApplication.getInstance().getViberIdController(), UserManager.from(null).getUserData(), com.viber.voip.h.a.b());
      this.mLatestViberOutBalance = new ViberOutInfoProvider();
      this.mWalletController = ViberApplication.getInstance().getWalletController();
      this.mStickerPackagesCountManager = d.a().c();
      this.mMoreStickerMarketSubTextState = new MoreStickerMarketSubTextState(d.ae.c);
      this.mMoreStickerMarketEventsListener = new MoreStickerMarketEventsListener(paramView.getContext().getApplicationContext(), new IntentFilter("com.viber.voip.stickers.notification.UPDATE_STICKER_PACKAGES_COUNT_ACTION"), this.mStickerPackagesCountManager);
      this.mMoreListItemsSortOrder = new MoreListItemsSortOrder(MoreScreenProductsOrder.Helper.fromBucket(this.mAnalyticsManager.a(a.a.i, false)));
      return;
    }
  }

  public void onAttach(Context paramContext)
  {
    dagger.android.support.a.a(this);
    super.onAttach(paramContext);
    FragmentActivity localFragmentActivity = getActivity();
    if (!(localFragmentActivity instanceof Callbacks))
    {
      Fragment localFragment2 = getParentFragment();
      if (!(localFragment2 instanceof Callbacks))
        throw new ClassCastException("MoreFragment.Callbacks is not implemented!");
      this.mCallbacks = ((Callbacks)localFragment2);
    }
    while (!(localFragmentActivity instanceof l))
    {
      Fragment localFragment1 = getParentFragment();
      if (!(localFragment1 instanceof l))
      {
        throw new ClassCastException("PermissionConfigProvider is not implemented!");
        this.mCallbacks = ((Callbacks)paramContext);
      }
      else
      {
        this.mPermissionConfig = ((l)localFragment1).getPermissionConfigForFragment(this);
        return;
      }
    }
    this.mPermissionConfig = ((l)paramContext).getPermissionConfigForFragment(this);
  }

  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    this.mMoreScreenConfig = new MoreScreenConfig(getActivity(), this.mDeviceConfiguration);
    if (((this.mMoreScreenConfig.isDialog()) || (this.mMoreScreenConfig.isMoreActivity())) && (this.mMoreScreenConfig.isLandscape()));
    for (int i = R.layout.fragment_more_landscape; ; i = R.layout.fragment_more)
      return paramLayoutInflater.inflate(i, paramViewGroup, false);
  }

  public void onDestroy()
  {
    super.onDestroy();
    this.mCallbacks = null;
  }

  public void onDestroyView()
  {
    super.onDestroyView();
    if (this.mMoreView != null)
      this.mMoreView.onDestroyView();
  }

  public void onDetach()
  {
    super.onDetach();
    this.mCallbacks = null;
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    this.mIsVisible = paramBoolean;
    super.onFragmentVisibilityChanged(paramBoolean);
  }

  public void reloadFromArguments(Intent paramIntent)
  {
    if (this.mMoreView != null)
      this.mMoreView.reloadFromArguments(paramIntent);
  }

  public static abstract interface Callbacks
  {
    public abstract void onClickOpenSettings(Intent paramIntent);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreFragment
 * JD-Core Version:    0.6.2
 */