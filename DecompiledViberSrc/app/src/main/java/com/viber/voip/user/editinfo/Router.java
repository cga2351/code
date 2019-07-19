package com.viber.voip.user.editinfo;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.viber.voip.R.anim;
import com.viber.voip.user.editinfo.changeemail.ChangeEmailFragment;
import com.viber.voip.user.editinfo.changepassword.ChangePasswordFragment;
import com.viber.voip.util.ViberActionRunner.bf;
import com.viber.voip.util.dj;

public class Router
  implements EditInfoRouter
{
  protected final FragmentActivity mMainActivity;

  public Router(FragmentActivity paramFragmentActivity)
  {
    this.mMainActivity = paramFragmentActivity;
  }

  private void showFragment(Fragment paramFragment, boolean paramBoolean1, boolean paramBoolean2)
  {
    FragmentTransaction localFragmentTransaction = this.mMainActivity.getSupportFragmentManager().beginTransaction();
    if (paramBoolean2)
      localFragmentTransaction.setCustomAnimations(R.anim.slide_in_from_left, R.anim.slide_right_out, R.anim.slide_left_in, R.anim.slide_out_to_left);
    localFragmentTransaction.replace(16908290, paramFragment);
    if (paramBoolean1)
      localFragmentTransaction.addToBackStack(paramFragment.toString());
    localFragmentTransaction.commitAllowingStateLoss();
  }

  public Fragment getCurrentFragment()
  {
    if (this.mMainActivity.isFinishing())
      return null;
    return this.mMainActivity.getSupportFragmentManager().findFragmentById(16908290);
  }

  public void goToChangeEmailScreen()
  {
    if (!this.mMainActivity.isFinishing())
      showFragment(ChangeEmailFragment.createInstance(this), true, true);
  }

  public void goToChangePasswordScreen()
  {
    if (!this.mMainActivity.isFinishing())
      showFragment(ChangePasswordFragment.createInstance(this), true, true);
  }

  public void goToEditInfoScreen()
  {
    if (!this.mMainActivity.isFinishing())
      showFragment(EditInfoFragment.newInstance(0, this.mMainActivity.getIntent().getIntExtra("extra_action", 0)), false, false);
  }

  public void goToMoreScreen()
  {
    if (!this.mMainActivity.isFinishing())
    {
      ViberActionRunner.bf.b(this.mMainActivity);
      this.mMainActivity.finish();
    }
  }

  public void navigateOnDisconnect()
  {
    goToMoreScreen();
  }

  public boolean tryGoBack()
  {
    if (this.mMainActivity.isFinishing());
    FragmentManager localFragmentManager;
    do
    {
      return false;
      localFragmentManager = this.mMainActivity.getSupportFragmentManager();
    }
    while (localFragmentManager.getBackStackEntryCount() == 0);
    Fragment localFragment = getCurrentFragment();
    if (localFragment != null)
      dj.a(localFragment.getView(), false);
    try
    {
      boolean bool = localFragmentManager.popBackStackImmediate();
      return bool;
    }
    catch (Exception localException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.editinfo.Router
 * JD-Core Version:    0.6.2
 */