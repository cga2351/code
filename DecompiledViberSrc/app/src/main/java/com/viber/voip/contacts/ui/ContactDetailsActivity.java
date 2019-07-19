package com.viber.voip.contacts.ui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.bool;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.util.ViberActionRunner.ab;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;

public class ContactDetailsActivity extends ViberSingleFragmentActivity
  implements ContactDetailsFragment.c, l, dagger.android.support.b
{

  @Inject
  c<Fragment> a;

  @Inject
  com.viber.voip.app.b b;

  @SuppressLint({"InlinedApi"})
  protected void a()
  {
  }

  protected void a(Bundle paramBundle)
  {
  }

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = new k();
    localk.a(0, 85);
    localk.a(1, 61);
    localk.a(3, 37);
    localk.a(2, 47);
    localk.a(4, 45);
    return localk;
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  public void onBackPressed()
  {
    Fragment localFragment = getFragment();
    if (((localFragment instanceof com.viber.voip.app.a)) && (((com.viber.voip.app.a)localFragment).onBackPressed()))
      return;
    if (getIntent().getBooleanExtra("EXTRA_RETURN_TO_HOME", false))
    {
      startActivity(new Intent(this, ViberActionRunner.ab.a(ViberApplication.isTablet(this))));
      finish();
      return;
    }
    super.onBackPressed();
  }

  protected final void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    a();
    super.onCreate(paramBundle);
    if (getResources().getBoolean(R.bool.translucent_status_for_fullscreen))
      dj.f(this);
    if ((!this.b.a()) && (!this.b.a(this)))
      dj.c(this, false);
    a(paramBundle);
  }

  protected Fragment onCreatePane()
  {
    return new ContactDetailsFragment();
  }

  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(paramIntent);
    ((ContactDetailsFragment)getFragment()).a(paramIntent);
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

  protected void onStart()
  {
    super.onStart();
    ((ContactDetailsFragment)getFragment()).a(getIntent());
  }

  public void q()
  {
    finish();
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactDetailsActivity
 * JD-Core Version:    0.6.2
 */