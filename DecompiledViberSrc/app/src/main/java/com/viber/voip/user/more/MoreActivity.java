package com.viber.voip.user.more;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.i.c.p;
import com.viber.voip.i.f;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.util.ViberActionRunner.af;
import com.viber.voip.vln.e;
import dagger.android.c;
import javax.inject.Inject;

public class MoreActivity extends ViberFragmentActivity
  implements l, MoreFragment.Callbacks, dagger.android.support.b
{

  @Inject
  c<Fragment> mFragmentInjector;

  @Inject
  dagger.a<e> mVlnReactContextManager;

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = new k();
    localk.a(0, 5);
    localk.a(1, 83);
    localk.a(4, 95);
    return localk;
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onClickOpenSettings(Intent paramIntent)
  {
    startActivity(paramIntent);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    if (c.p.a.e())
      ((e)this.mVlnReactContextManager.get()).a();
    if ((!(this instanceof MoreDialogActivity)) && (this.mIsTablet))
      finish();
    do
    {
      return;
      android.support.v7.app.a locala = getSupportActionBar();
      if (locala != null)
        locala.b(true);
      if (paramBundle == null)
      {
        FragmentTransaction localFragmentTransaction = getSupportFragmentManager().beginTransaction();
        localFragmentTransaction.add(16908290, new MoreFragment());
        localFragmentTransaction.commit();
      }
    }
    while (!getIntent().getBooleanExtra("show_share", false));
    getIntent().removeExtra("show_share");
    ViberActionRunner.af.a(this, null);
  }

  protected void onDestroy()
  {
    super.onDestroy();
    if (c.p.a.e())
      ((e)this.mVlnReactContextManager.get()).b();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.mFragmentInjector;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.user.more.MoreActivity
 * JD-Core Version:    0.6.2
 */