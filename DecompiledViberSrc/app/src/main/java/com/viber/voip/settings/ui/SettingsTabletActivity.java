package com.viber.voip.settings.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;

public class SettingsTabletActivity extends SettingsHeadersActivity
{
  protected int a()
  {
    return R.layout.activity_settings_tablet;
  }

  protected void a(Fragment paramFragment)
  {
    if ((paramFragment == null) || (paramFragment == this.b))
      return;
    FragmentManager localFragmentManager = getSupportFragmentManager();
    localFragmentManager.beginTransaction().replace(R.id.settingsDetailsContainer, paramFragment).commitNowAllowingStateLoss();
    this.a = paramFragment;
    SettingsHeadersFragment.a(localFragmentManager, this.a);
    this.b.a();
  }

  protected SettingsHeadersFragment b()
  {
    return (SettingsHeadersFragment)getSupportFragmentManager().findFragmentById(R.id.settingsHeadersFragment);
  }

  protected boolean c()
  {
    return false;
  }

  public void onBackPressed()
  {
    if (isTaskRoot())
    {
      finish();
      return;
    }
    super.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    if (this.c == -1)
    {
      this.c = R.string.pref_category_account_key;
      this.b.b(this.c);
      a(false);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.SettingsTabletActivity
 * JD-Core Version:    0.6.2
 */