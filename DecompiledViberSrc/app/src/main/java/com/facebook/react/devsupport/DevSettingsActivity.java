package com.facebook.react.devsupport;

import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.preference.PreferenceActivity;
import com.facebook.react.R.string;
import com.facebook.react.R.xml;

public class DevSettingsActivity extends PreferenceActivity
{
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setTitle(getApplication().getResources().getString(R.string.catalyst_settings_title));
    addPreferencesFromResource(R.xml.rn_dev_preferences);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.DevSettingsActivity
 * JD-Core Version:    0.6.2
 */