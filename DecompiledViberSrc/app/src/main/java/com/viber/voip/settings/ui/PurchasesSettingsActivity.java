package com.viber.voip.settings.ui;

import android.support.v4.app.Fragment;
import com.viber.voip.R.string;

public class PurchasesSettingsActivity extends SettingsActivity
{
  protected Fragment onCreatePane()
  {
    setActionBarTitle(R.string.pref_category_purchases);
    return new ad();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.PurchasesSettingsActivity
 * JD-Core Version:    0.6.2
 */