package com.viber.voip.settings.ui;

import android.support.v4.app.Fragment;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.app.ViberSingleFragmentActivity;

public class DebugFeatureActivity extends ViberSingleFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();

  protected Fragment onCreatePane()
  {
    finish();
    return null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.ui.DebugFeatureActivity
 * JD-Core Version:    0.6.2
 */