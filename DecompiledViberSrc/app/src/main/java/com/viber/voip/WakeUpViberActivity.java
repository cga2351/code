package com.viber.voip;

import android.os.Bundle;
import com.viber.dexshared.Logger;
import com.viber.jni.Engine;
import com.viber.voip.app.ViberFragmentActivity;

public class WakeUpViberActivity extends ViberFragmentActivity
{
  private static final Logger a = ViberEnv.getLogger();

  protected void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    setContentView(R.layout._ics_activity_singlepane_empty);
    ViberApplication localViberApplication = ViberApplication.getInstance();
    localViberApplication.initApplication();
    localViberApplication.getEngine(false).addInitializedListener(new bo(this));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.WakeUpViberActivity
 * JD-Core Version:    0.6.2
 */