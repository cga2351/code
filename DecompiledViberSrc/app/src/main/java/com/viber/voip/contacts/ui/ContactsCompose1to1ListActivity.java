package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.Menu;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.permissions.l;
import com.viber.voip.ui.c.d;
import com.viber.voip.ui.j.av;
import com.viber.voip.util.dj;
import javax.inject.Inject;

public class ContactsCompose1to1ListActivity extends ViberSingleFragmentActivity
  implements ContactsFragment.a, s.a, l, dagger.android.support.b
{

  @Inject
  dagger.android.c<Fragment> a;

  @Inject
  dagger.a<av> b;

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(Intent paramIntent)
  {
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
  }

  public void b(Intent paramIntent)
  {
  }

  protected com.viber.voip.ui.c.c createActivityDecorator()
  {
    return new d(new com.viber.voip.ui.c.k(), this, (av)this.b.get());
  }

  public com.viber.voip.permissions.k getPermissionConfigForFragment(Fragment paramFragment)
  {
    com.viber.voip.permissions.k localk = new com.viber.voip.permissions.k();
    localk.a(0, 88);
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
    super.onBackPressed();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    if (ViberApplication.isTablet(this))
      dj.b(this);
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    if (ViberApplication.isTablet(this))
      dj.b(this);
    super.onCreate(paramBundle);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    String str = getIntent().getStringExtra("title");
    if (str != null)
    {
      getSupportActionBar().a(str);
      return;
    }
    getSupportActionBar().b(R.string.select_contact);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected Fragment onCreatePane()
  {
    return new o();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    dj.d(this);
    finish();
    return true;
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.a;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactsCompose1to1ListActivity
 * JD-Core Version:    0.6.2
 */