package com.viber.voip.settings.ui.personal;

import android.support.v4.app.Fragment;
import com.viber.voip.R.string;
import com.viber.voip.settings.ui.SettingsActivity;

public class PersonalDataSettingsActivity extends SettingsActivity
{
  protected Fragment onCreatePane()
  {
    setActionBarTitle(R.string.personal_data);
    return new a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.personal.PersonalDataSettingsActivity
 * JD-Core Version:    0.6.2
 */