package com.viber.voip.settings.ui;

import android.support.v4.app.Fragment;
import com.viber.voip.R.string;

public class ManageSecondariesSettingsActivity extends SettingsActivity
{
  public boolean isSwitchingThemeSupported()
  {
    return true;
  }

  protected Fragment onCreatePane()
  {
    setActionBarTitle(R.string.pref_category_manage_secondaries);
    return new q();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.ManageSecondariesSettingsActivity
 * JD-Core Version:    0.6.2
 */