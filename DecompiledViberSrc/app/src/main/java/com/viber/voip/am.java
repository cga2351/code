package com.viber.voip;

import com.viber.common.b.b;
import com.viber.dexshared.Logger;
import com.viber.jni.mustupgrade.MustUpgradeDelegate;
import com.viber.voip.registration.ao;
import com.viber.voip.settings.d.ad;

public class am
  implements MustUpgradeDelegate
{
  private static final Logger a = ViberEnv.getLogger();

  public void onClientUpgrade(int paramInt)
  {
    if (ao.f())
      d.ad.k.a(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.am
 * JD-Core Version:    0.6.2
 */