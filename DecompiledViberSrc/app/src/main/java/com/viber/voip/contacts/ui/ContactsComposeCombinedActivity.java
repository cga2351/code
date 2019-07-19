package com.viber.voip.contacts.ui;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.MenuItem;
import com.viber.voip.R.id;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.calls.ui.RecentCallsFragment.a;
import com.viber.voip.permissions.k;
import com.viber.voip.permissions.l;
import com.viber.voip.util.dj;
import dagger.android.c;
import javax.inject.Inject;

public class ContactsComposeCombinedActivity extends ViberSingleFragmentActivity
  implements RecentCallsFragment.a, ContactsFragment.a, s.a, l, dagger.android.support.b
{

  @Inject
  c<Fragment> a;
  private Bundle b;

  private void a()
  {
    if (ViberApplication.isTablet(this))
      dj.a(this, 0.65F, 0.75F, 0.65F, 0.75F, true);
  }

  public void a(int paramInt, Fragment paramFragment)
  {
  }

  public void a(Intent paramIntent)
  {
    startActivity(paramIntent);
    setResult(-1);
    finish();
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    Bundle localBundle = new Bundle();
    if (paramBoolean)
      localBundle.putInt("extra_participants_selector_mode", ParticipantSelector.f.c.ordinal());
    localBundle.putInt("compose_chat_mode_multiple", paramInt);
    localBundle.putString("extra_create_chat_origin", "Create Chat Icon");
    this.mFragment = new s();
    this.mFragment.setArguments(localBundle);
    getSupportFragmentManager().beginTransaction().replace(R.id.root_container, this.mFragment, "single_pane").commit();
  }

  public void a(boolean paramBoolean, Intent paramIntent)
  {
  }

  public void b(Intent paramIntent)
  {
    if (this.b != null)
      paramIntent.putExtras(this.b);
    startActivityForResult(paramIntent, 1021);
  }

  public k getPermissionConfigForFragment(Fragment paramFragment)
  {
    k localk = new k();
    localk.a(0, 89);
    return localk;
  }

  public void h(Intent paramIntent)
  {
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((20 == paramInt1) && (paramInt2 == -1))
      startActivityForResult(paramIntent, 1021);
    do
    {
      do
        return;
      while (1021 != paramInt1);
      switch (paramInt2)
      {
      default:
        return;
      case -1:
        Intent localIntent = (Intent)paramIntent.getParcelableExtra("open_add_members_intent");
        if (localIntent != null)
        {
          paramIntent.removeExtra("open_add_members_intent");
          startActivities(new Intent[] { paramIntent, localIntent });
        }
        while (true)
        {
          finish();
          return;
          startActivity(paramIntent);
        }
      case 0:
      }
    }
    while (paramIntent == null);
    this.b = paramIntent.getExtras();
  }

  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    a();
  }

  protected void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    a();
    super.onCreate(paramBundle);
    getSupportActionBar().a(false);
    getSupportActionBar().b(true);
    if (!getIntent().hasExtra("android.intent.extra.TITLE"))
      setTitle(R.string.select_contacts);
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
 * Qualified Name:     com.viber.voip.contacts.ui.ContactsComposeCombinedActivity
 * JD-Core Version:    0.6.2
 */