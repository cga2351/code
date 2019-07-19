package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.MenuItem;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.util.dj;

public class ContactsListActivity extends ViberSingleFragmentActivity
  implements ContactsFragment.a, l
{
  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
  }

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = new k();
    localk.a(0, 92);
    return localk;
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
    getSupportActionBar().b(R.string.select_contacts);
  }

  protected Fragment onCreatePane()
  {
    return new ContactsFragment();
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
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.contacts.ui.ContactsListActivity
 * JD-Core Version:    0.6.2
 */