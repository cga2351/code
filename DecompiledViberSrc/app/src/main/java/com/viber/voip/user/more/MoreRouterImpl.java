package com.viber.voip.user.more;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import com.viber.voip.market.StickerMarketActivity;
import com.viber.voip.rakuten.a;
import com.viber.voip.settings.ui.ManageSecondariesSettingsActivity;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.util.ViberActionRunner.aq;
import com.viber.voip.util.ViberActionRunner.aw;
import com.viber.voip.util.ViberActionRunner.ay;
import com.viber.voip.util.ViberActionRunner.b;
import com.viber.voip.util.ViberActionRunner.bf;
import com.viber.voip.util.ViberActionRunner.bh;
import com.viber.voip.util.ViberActionRunner.bi;
import com.viber.voip.util.ViberActionRunner.bj;
import com.viber.voip.util.ViberActionRunner.bk;
import com.viber.voip.util.ViberActionRunner.br;
import com.viber.voip.viberwallet.ViberWalletWebActivity;

class MoreRouterImpl
  implements MoreRouter
{
  private final Activity mActivity;
  private final MoreFragment.Callbacks mCallbacks;
  private final a mRakutenController;

  MoreRouterImpl(Activity paramActivity, MoreFragment.Callbacks paramCallbacks, a parama)
  {
    this.mActivity = paramActivity;
    this.mCallbacks = paramCallbacks;
    this.mRakutenController = parama;
  }

  public void openAbout()
  {
    ViberActionRunner.ay.a(this.mActivity);
  }

  @SuppressLint({"MissingPermission"})
  public void openAddContact()
  {
    ViberActionRunner.b.a(this.mActivity, "More - Add Contact");
  }

  public void openDesktopAndTablets()
  {
    Intent localIntent = new Intent(this.mActivity, ManageSecondariesSettingsActivity.class);
    localIntent.putExtra("extra entry point", "More Screen");
    this.mActivity.startActivity(localIntent);
  }

  public void openEditInfo(String paramString, int paramInt)
  {
    Bundle localBundle = new Bundle(2);
    localBundle.putString("extra_entry_point", paramString);
    localBundle.putInt("extra_action", paramInt);
    ViberActionRunner.bf.a(this.mActivity, localBundle);
  }

  public void openGetFreeStickers()
  {
    ViberActionRunner.bh.a(this.mActivity);
  }

  public void openInviteScreenNative()
  {
    ViberActionRunner.af.a(this.mActivity, null);
  }

  public void openPublicAccounts()
  {
    ViberActionRunner.aq.b(this.mActivity);
  }

  @SuppressLint({"MissingPermission"})
  public void openQRScanner()
  {
    ViberActionRunner.aw.a(true, this.mActivity, "More Tab", "More");
  }

  public void openRakutenAccount()
  {
    this.mRakutenController.b(this.mActivity);
  }

  public void openRakutenBankApp()
  {
    ViberActionRunner.br.a(this.mActivity, null, 0);
  }

  public void openSendLog()
  {
    ViberActionRunner.ay.b(this.mActivity);
  }

  public void openSettings()
  {
    if (this.mCallbacks != null)
      this.mCallbacks.onClickOpenSettings(new Intent("com.viber.voip.action.SETTINGS"));
  }

  public void openShareViber()
  {
    ViberActionRunner.af.c(this.mActivity, "More");
  }

  public void openStickerMarket()
  {
    StickerMarketActivity.a(1, "More", "Top");
  }

  public void openViberNews()
  {
    ViberActionRunner.bj.b(this.mActivity);
  }

  public void openViberOut()
  {
    ViberActionRunner.bk.b(this.mActivity, "More", null);
  }

  public void openVln(String paramString1, String paramString2)
  {
    ViberActionRunner.bi.a(this.mActivity, paramString1, paramString2);
  }

  public void openWalletHomePage()
  {
    ViberWalletWebActivity.b(0);
  }

  public void openWalletWuSelectionPage()
  {
    ViberActionRunner.br.a(this.mActivity);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreRouterImpl
 * JD-Core Version:    0.6.2
 */