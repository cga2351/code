package com.viber.voip.settings.ui.personal.request;

import android.support.v4.app.Fragment;
import android.support.v7.preference.PreferenceScreen;
import com.viber.voip.R.string;
import com.viber.voip.app.ViberSingleFragmentActivity;
import com.viber.voip.ui.ba.a;

public class RequestYourDataSettingsActivity extends ViberSingleFragmentActivity
  implements ba.a
{
  public void a(PreferenceScreen paramPreferenceScreen)
  {
  }

  protected Fragment onCreatePane()
  {
    setDefaultTitle(R.string.request_your_data);
    return new b();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.personal.request.RequestYourDataSettingsActivity
 * JD-Core Version:    0.6.2
 */