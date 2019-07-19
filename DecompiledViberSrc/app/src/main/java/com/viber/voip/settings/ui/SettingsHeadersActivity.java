package com.viber.voip.settings.ui;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.preference.Preference;
import android.support.v7.preference.PreferenceScreen;
import android.support.v7.preference.TwoStatePreference;
import android.util.AttributeSet;
import android.view.MenuItem;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.R.string;
import com.viber.voip.ViberEnv;
import com.viber.voip.analytics.g;
import com.viber.voip.app.ViberFragmentActivity;
import com.viber.voip.settings.d;
import com.viber.voip.ui.ba;
import com.viber.voip.ui.ba.a;
import javax.inject.Inject;

public class SettingsHeadersActivity extends ViberFragmentActivity
  implements SettingsHeadersFragment.a, ba.a, dagger.android.support.b
{
  private static final Logger f = ViberEnv.getLogger();
  protected Fragment a;
  protected SettingsHeadersFragment b;
  protected int c = -1;

  @Inject
  dagger.android.c<Fragment> d;

  @Inject
  com.viber.voip.app.b e;
  private boolean g;
  private byte h;

  private void a(Intent paramIntent)
  {
    if (paramIntent.hasExtra("selected_item"))
    {
      this.c = paramIntent.getIntExtra("selected_item", -1);
      this.h = paramIntent.getByteExtra("inner_screen", (byte)0);
      this.g = paramIntent.getBooleanExtra("single_screen", false);
      this.b.b(this.c);
      this.b.a(this.h);
      str = paramIntent.getStringExtra("ui_language");
      if (str != null)
        this.b.a(str);
      paramIntent.removeExtra("inner_screen");
      a(false);
    }
    while (!paramIntent.hasCategory("android.intent.category.NOTIFICATION_PREFERENCES"))
    {
      String str;
      return;
    }
    this.c = R.string.pref_category_notifications_key;
    this.b.b(this.c);
    a(false);
  }

  private void a(CharSequence paramCharSequence)
  {
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.a(paramCharSequence);
  }

  protected int a()
  {
    return R.layout.activity_settings;
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.c = paramInt2;
    a(false);
  }

  protected void a(Fragment paramFragment)
  {
    if (paramFragment == null)
      return;
    FragmentManager localFragmentManager = getSupportFragmentManager();
    FragmentTransaction localFragmentTransaction = localFragmentManager.beginTransaction();
    if (this.a != null)
      localFragmentTransaction.remove(this.a);
    localFragmentTransaction.replace(R.id.settingsFragmentHolder, paramFragment);
    if (this.e.a(this))
      localFragmentTransaction.setTransition(4099);
    localFragmentTransaction.commitNowAllowingStateLoss();
    this.a = paramFragment;
    SettingsHeadersFragment.a(localFragmentManager, this.a);
  }

  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  public void a(boolean paramBoolean)
  {
    com.viber.voip.settings.a.a locala = this.b.a(this.c);
    if (locala != null)
    {
      a(locala.b());
      a(this.b.a(paramBoolean));
    }
  }

  protected SettingsHeadersFragment b()
  {
    return new SettingsHeadersFragment();
  }

  protected boolean c()
  {
    if ((this.c != -1) && (!this.g))
    {
      this.c = -1;
      a(getString(R.string.pref_settings_title));
      getSupportActionBar().a(R.drawable.ic_ab_settings);
      this.b = new SettingsHeadersFragment();
      a(this.b);
      return true;
    }
    return false;
  }

  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if ((this.a instanceof a))
      this.a.onActivityResult(paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    if (c())
      return;
    if (isTaskRoot())
    {
      startActivity(new Intent("com.viber.voip.action.MORE"));
      finish();
      return;
    }
    super.onBackPressed();
  }

  public void onCreate(Bundle paramBundle)
  {
    dagger.android.a.a(this);
    super.onCreate(paramBundle);
    setContentView(a());
    this.b = b();
    setActionBarTitle(R.string.pref_settings_title);
    android.support.v7.app.a locala = getSupportActionBar();
    if (locala != null)
      locala.b(true);
    a(this.b);
    if (paramBundle == null)
      a(getIntent());
  }

  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }

  protected void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    a(paramIntent);
    setIntent(paramIntent);
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return false;
    case 16908332:
    }
    onBackPressed();
    return true;
  }

  protected void onRestoreInstanceState(Bundle paramBundle)
  {
    super.onRestoreInstanceState(paramBundle);
    this.c = paramBundle.getInt("com.viber.voip.settings.ui.SettingsHeadersActivity.selectedItemId");
    if (this.c > 0)
    {
      this.b.b(this.c);
      a(true);
    }
  }

  public void onSaveInstanceState(Bundle paramBundle)
  {
    paramBundle.putInt("com.viber.voip.settings.ui.SettingsHeadersActivity.selectedItemId", this.c);
    super.onSaveInstanceState(paramBundle);
  }

  public dagger.android.b<Fragment> supportFragmentInjector()
  {
    return this.d;
  }

  public static abstract class a extends ba
    implements SharedPreferences.OnSharedPreferenceChangeListener
  {
    PreferenceScreen i = null;

    protected void b(String paramString, boolean paramBoolean)
    {
      Preference localPreference = a(paramString);
      if ((localPreference instanceof TwoStatePreference))
        ((TwoStatePreference)localPreference).f(paramBoolean);
    }

    public void i()
    {
    }

    public void onCreate(Bundle paramBundle)
    {
      super.onCreate(paramBundle);
      this.i = b();
    }

    public void onPause()
    {
      super.onPause();
      g.a().h().a(false);
    }

    public void onResume()
    {
      super.onResume();
      g.a().h().a(true);
    }

    public void onSharedPreferenceChanged(SharedPreferences paramSharedPreferences, String paramString)
    {
    }

    public void onStart()
    {
      super.onStart();
      d.a(this);
    }

    public void onStop()
    {
      super.onStop();
      d.b(this);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.SettingsHeadersActivity
 * JD-Core Version:    0.6.2
 */