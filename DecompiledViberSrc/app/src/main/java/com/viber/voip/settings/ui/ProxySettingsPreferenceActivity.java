package com.viber.voip.settings.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.a;
import android.support.v7.preference.PreferenceScreen;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import com.viber.voip.R.menu;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.ui.ba.a;

public class ProxySettingsPreferenceActivity extends ViberSingleFragmentActivity
  implements ba.a
{
  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    a locala = getSupportActionBar();
    locala.b(true);
    locala.a(false);
    setDefaultTitle(R.string.proxy);
  }

  public boolean onCreateOptionsMenu(Menu paramMenu)
  {
    getMenuInflater().inflate(R.menu.menu_edit_options, paramMenu);
    return super.onCreateOptionsMenu(paramMenu);
  }

  protected Fragment onCreatePane()
  {
    return new ac();
  }

  public boolean onOptionsItemSelected(MenuItem paramMenuItem)
  {
    switch (paramMenuItem.getItemId())
    {
    default:
      return super.onOptionsItemSelected(paramMenuItem);
    case 16908332:
    }
    finish();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ProxySettingsPreferenceActivity
 * JD-Core Version:    0.6.2
 */