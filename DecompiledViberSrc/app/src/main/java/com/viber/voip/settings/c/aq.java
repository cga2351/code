package com.viber.voip.settings.c;

import android.content.Context;
import android.support.v7.preference.PreferenceGroup;
import android.support.v7.preference.PreferenceScreen;
import com.viber.common.b.h;
import com.viber.voip.ViberApplication;
import com.viber.voip.registration.HardwareParameters;
import com.viber.voip.settings.d.aa;
import com.viber.voip.settings.ui.x;
import com.viber.voip.settings.ui.x.a;

public class aq extends m
{
  public aq(Context paramContext, PreferenceScreen paramPreferenceScreen)
  {
    super(paramContext, paramPreferenceScreen);
  }

  protected void a()
  {
    f(new x(this.a, x.a.d, d.aa.a.c(), "Sim MCC").a(ViberApplication.getInstance().getHardwareParameters().getSimMCC()).a());
    f(new x(this.a, x.a.d, d.aa.b.c(), "Sim MNC").a(ViberApplication.getInstance().getHardwareParameters().getSimMNC()).a());
    f(new x(this.a, x.a.d, d.aa.c.c(), "Network MCC").a(ViberApplication.getInstance().getHardwareParameters().getMCC()).a());
    f(new x(this.a, x.a.d, d.aa.d.c(), "Network MNC").a(ViberApplication.getInstance().getHardwareParameters().getMNC()).a());
  }

  protected void a(PreferenceGroup paramPreferenceGroup)
  {
    paramPreferenceGroup.d("mcc_mnc_codes_settings_key");
    paramPreferenceGroup.c("MccMncCodes");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.settings.c.aq
 * JD-Core Version:    0.6.2
 */