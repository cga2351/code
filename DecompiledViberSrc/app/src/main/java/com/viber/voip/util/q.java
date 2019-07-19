package com.viber.voip.util;

import android.hardware.Camera;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

public final class q
{
  private static final Logger a = ViberEnv.getLogger();

  public static boolean a()
  {
    return Camera.getNumberOfCameras() > 0;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.q
 * JD-Core Version:    0.6.2
 */