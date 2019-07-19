package com.viber.voip;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceScreen;
import com.viber.dexshared.Logger;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.settings.ui.ai;
import com.viber.voip.ui.ba.a;

public class SoundSettingsActivity extends ViberSingleFragmentActivity
  implements ba.a
{
  private static final Logger a = ViberEnv.getLogger();

  private Intent a()
  {
    Intent localIntent = new Intent(this, y.b());
    localIntent.setFlags(603979776);
    return localIntent;
  }

  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  public Intent getParentActivityIntent()
  {
    if ((this.mIsTablet) && (y.c()))
      return a();
    return super.getParentActivityIntent();
  }

  public Intent getSupportParentActivityIntent()
  {
    if ((this.mIsTablet) && (y.c()))
      return a();
    return super.getSupportParentActivityIntent();
  }

  protected Fragment onCreatePane()
  {
    return new ai();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.SoundSettingsActivity
 * JD-Core Version:    0.6.2
 */