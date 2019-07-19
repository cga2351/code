package com.viber.voip.user.more;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import com.viber.voip.R.attr;
import com.viber.voip.R.id;
import com.viber.voip.R.menu;
import com.viber.voip.mvp.core.d;
import com.viber.voip.settings.a.a;
import com.viber.voip.user.more.listitems.providers.ProfileBannerProvider;
import com.viber.voip.user.more.listitems.providers.ViberOutInfoProvider;
import com.viber.voip.util.dc;
import com.viber.voip.util.e.e;
import java.util.List;

class MoreViewImpl extends d<MorePresenter>
  implements MorePreferenceAdapter.MorePrefListener, MoreView
{
  private boolean mEditMenuVisible = true;
  private final MoreFragment mFragment;
  private MoreHeader mMoreHeader;
  private final MorePermissionHelper mMorePermissionHelper;
  private final MoreRouter mMoreRouter;
  private final MoreNotificationBanner mNotificationBanner;
  private final MorePreferenceAdapter mPreferenceAdapter;
  private final ViberOutInfoProvider mViberOutInfoProvider;

  MoreViewImpl(MoreFragment paramMoreFragment, MorePresenter paramMorePresenter, MoreRouter paramMoreRouter, MorePermissionHelper paramMorePermissionHelper, View paramView, MoreArguments paramMoreArguments, ProfileBannerProvider paramProfileBannerProvider, ViberOutInfoProvider paramViberOutInfoProvider, e parame, MoreScreenConfig paramMoreScreenConfig)
  {
    super(paramMorePresenter, paramView);
    this.mFragment = paramMoreFragment;
    this.mMoreRouter = paramMoreRouter;
    this.mMorePermissionHelper = paramMorePermissionHelper;
    this.mViberOutInfoProvider = paramViberOutInfoProvider;
    this.mFragment.setHasOptionsMenu(true);
    paramMorePresenter.reloadFromArguments(paramMoreArguments);
    RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(R.id.more_list);
    localRecyclerView.setHasFixedSize(true);
    if ((!paramMoreScreenConfig.isTablet()) || (paramMoreScreenConfig.isDialog()));
    for (this.mMoreHeader = new MoreHeaderImpl(paramMoreFragment, paramMorePresenter, paramView, localRecyclerView, parame, paramMoreScreenConfig); ; this.mMoreHeader = new MoreHeader()
    {
      public void adjustTopBar()
      {
        MoreHeader..CC.adjustTopBar(this);
      }

      public void destroy()
      {
        MoreHeader..CC.destroy(this);
      }

      public void init()
      {
        MoreHeader..CC.init(this);
      }

      public void setUserName(CharSequence paramAnonymousCharSequence)
      {
        MoreHeader..CC.setUserName(this, paramAnonymousCharSequence);
      }

      public void setUserPhoneNumber(CharSequence paramAnonymousCharSequence)
      {
        MoreHeader..CC.setUserPhoneNumber(this, paramAnonymousCharSequence);
      }

      public void setUserPhoto(Uri paramAnonymousUri)
      {
        MoreHeader..CC.setUserPhoto(this, paramAnonymousUri);
      }
    })
    {
      this.mMoreHeader.init();
      this.mPreferenceAdapter = new MorePreferenceAdapter(this, dc.d(paramView.getContext(), R.attr.unreadBadgeBackgroundTintBottomBadgeColor));
      localRecyclerView.setAdapter(this.mPreferenceAdapter);
      this.mNotificationBanner = new MoreNotificationBanner(paramView.findViewById(R.id.notificationBannerView), this.mPreferenceAdapter, paramProfileBannerProvider);
      this.mNotificationBanner.setClickListener(new MoreViewImpl..Lambda.0(this));
      return;
    }
  }

  public void adjustTopBar()
  {
    this.mMoreHeader.adjustTopBar();
  }

  public void bindNotificationBanner()
  {
    this.mNotificationBanner.bind();
  }

  public boolean onCreateOptionsMenu(Menu paramMenu, MenuInflater paramMenuInflater)
  {
    paramMenuInflater.inflate(R.menu.menu_more, paramMenu);
    paramMenu.findItem(R.id.menu_edit).setVisible(this.mEditMenuVisible);
    return true;
  }

  void onDestroyView()
  {
    this.mMoreHeader.destroy();
  }

  public void onFragmentVisibilityChanged(boolean paramBoolean)
  {
    ((MorePresenter)this.mPresenter).onFragmentVisibilityChanged(paramBoolean);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    int i = paramMenuItem.getItemId();
    if (i == R.id.menu_edit)
    {
      ((MorePresenter)this.mPresenter).onEditOptionItemSelected();
      return true;
    }
    if (i == R.id.menu_qr_code)
    {
      ((MorePresenter)this.mPresenter).onQrCodeOptionItemSelected();
      return true;
    }
    return false;
  }

  public void onPrefItemClick(int paramInt)
  {
    FragmentActivity localFragmentActivity = this.mFragment.getActivity();
    if ((localFragmentActivity == null) || (localFragmentActivity.isFinishing()))
      return;
    ((MorePresenter)this.mPresenter).onPrefItemClick(this.mPreferenceAdapter.getItemById(paramInt));
  }

  public void openAbout()
  {
    this.mMoreRouter.openAbout();
  }

  public void openAddContact()
  {
    this.mMoreRouter.openAddContact();
  }

  public void openDesktopAndTablets()
  {
    this.mMoreRouter.openDesktopAndTablets();
  }

  public void openEditInfo(String paramString, int paramInt)
  {
    this.mMoreRouter.openEditInfo(paramString, paramInt);
  }

  public void openGetFreeStickers()
  {
    this.mMoreRouter.openGetFreeStickers();
  }

  public void openInviteScreenNative()
  {
    this.mMoreRouter.openInviteScreenNative();
  }

  public void openPublicAccounts()
  {
    this.mMoreRouter.openPublicAccounts();
  }

  public void openQRScanner()
  {
    this.mMoreRouter.openQRScanner();
  }

  public void openRakutenAccount()
  {
    this.mMoreRouter.openRakutenAccount();
  }

  public void openRakutenBankApp()
  {
    this.mMoreRouter.openRakutenBankApp();
  }

  public void openSendLog()
  {
    this.mMoreRouter.openSendLog();
  }

  public void openSettings()
  {
    this.mMoreRouter.openSettings();
  }

  public void openShareViber()
  {
    this.mMoreRouter.openShareViber();
  }

  public void openStickerMarket()
  {
    this.mMoreRouter.openStickerMarket();
  }

  public void openViberNews()
  {
    this.mMoreRouter.openViberNews();
  }

  public void openViberOut()
  {
    this.mMoreRouter.openViberOut();
  }

  public void openVln(String paramString1, String paramString2)
  {
    this.mMoreRouter.openVln(paramString1, paramString2);
  }

  public void openWalletHomePage()
  {
    this.mMoreRouter.openWalletHomePage();
  }

  public void openWalletWuSelectionPage()
  {
    this.mMoreRouter.openWalletWuSelectionPage();
  }

  public void registerPermissionsGrantedListener(MorePermissionHelper.PermissionsGrantedListener paramPermissionsGrantedListener)
  {
    this.mMorePermissionHelper.registerPermissionsGrantedListener(paramPermissionsGrantedListener);
  }

  void reloadFromArguments(Intent paramIntent)
  {
    if (paramIntent == null)
      return;
    ((MorePresenter)this.mPresenter).reloadFromArguments(new MoreArguments(paramIntent));
  }

  public void requestPermissionsWithCheck(int paramInt, String[] paramArrayOfString)
  {
    this.mMorePermissionHelper.requestPermissionsWithCheck(paramInt, paramArrayOfString);
  }

  public void setEditMenuItemVisibility(boolean paramBoolean)
  {
    FragmentActivity localFragmentActivity = this.mFragment.getActivity();
    if ((localFragmentActivity != null) && (this.mEditMenuVisible != paramBoolean))
    {
      this.mEditMenuVisible = paramBoolean;
      localFragmentActivity.invalidateOptionsMenu();
    }
  }

  public void setItems(List<a> paramList)
  {
    this.mPreferenceAdapter.setItems(paramList);
  }

  public void setUserName(CharSequence paramCharSequence)
  {
    this.mMoreHeader.setUserName(paramCharSequence);
  }

  public void setUserPhoneNumber(CharSequence paramCharSequence)
  {
    this.mMoreHeader.setUserPhoneNumber(paramCharSequence);
  }

  public void setUserPhoto(Uri paramUri)
  {
    this.mMoreHeader.setUserPhoto(paramUri);
  }

  public void unregisterPermissionsGrantedListener()
  {
    this.mMorePermissionHelper.unregisterPermissionsGrantedListener();
  }

  public void updateViberOutBalanceText(CharSequence paramCharSequence)
  {
    this.mViberOutInfoProvider.setViberOutBalanceText(paramCharSequence);
  }

  public void updateVisibleItem(int paramInt)
  {
    this.mPreferenceAdapter.updateVisibleItem(paramInt);
  }

  public void updateVisibleItems()
  {
    this.mPreferenceAdapter.updateVisibleItems();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreViewImpl
 * JD-Core Version:    0.6.2
 */