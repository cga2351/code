package com.viber.voip.settings.ui;

import android.content.Intent;
import android.support.v7.preference.PreferenceScreen;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.ui.ba.a;

public abstract class SettingsActivity extends ViberSingleFragmentActivity
  implements ba.a
{
  protected static final Logger a = ViberEnv.getLogger();

  private Intent a()
  {
    Intent localIntent = new Intent(this, SettingsTabletActivity.class);
    localIntent.setFlags(603979776);
    return localIntent;
  }

  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  public Intent getParentActivityIntent()
  {
    if (this.mIsTablet)
      return a();
    return super.getParentActivityIntent();
  }

  public Intent getSupportParentActivityIntent()
  {
    if (this.mIsTablet)
      return a();
    return super.getSupportParentActivityIntent();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.SettingsActivity
 * JD-Core Version:    0.6.2
 */