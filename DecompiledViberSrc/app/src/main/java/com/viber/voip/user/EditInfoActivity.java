package com.viber.voip.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.messages.extras.a.e;
import com.viber.voip.ui.aq;
import com.viber.voip.user.editinfo.EditInfoFragment.EditInfoPageDisplayState;
import com.viber.voip.user.editinfo.Router;
import com.viber.voip.util.dj;

public class EditInfoActivity extends ViberFragmentActivity
  implements EditInfoFragment.EditInfoPageDisplayState
{
  public static final String EXTRA_ACTION = "extra_action";
  public static final String EXTRA_CDR_ENTRY_POINT = "extra_cdr_entry_point";
  public static final String EXTRA_ENTRY_POINT = "extra_entry_point";
  private Router mRouter;

  public boolean isEditInfoPageInPhoneMode()
  {
    return this.mIsTablet;
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getFacebookManager().a(this, paramInt1, paramInt2, paramIntent);
    ViberApplication.getInstance().getVKManager().a(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    Fragment localFragment = this.mRouter.getCurrentFragment();
    if ((localFragment instanceof aq))
      ((aq)localFragment).onBackPressed();
    if (!this.mRouter.tryGoBack())
      super.onBackPressed();
  }

  protected void onCreate(Bundle paramBundle)
  {
    com.viber.voip.n.a.a(ViberApplication.isTablet(this), this, 1, true, false);
    super.onCreate(paramBundle);
    dj.f(this);
    this.mRouter = new Router(this);
    if (paramBundle == null)
      this.mRouter.goToEditInfoScreen();
  }

  public boolean onSupportNavigateUp()
  {
    onBackPressed();
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.EditInfoActivity
 * JD-Core Version:    0.6.2
 */