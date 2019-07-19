package com.viber.voip.qrcode.a;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.viber.common.b.d;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.ad;

public final class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static Camera a()
  {
    return a(-1);
  }

  public static Camera a(int paramInt)
  {
    int i = Camera.getNumberOfCameras();
    if (i == 0)
      return null;
    if (paramInt >= 0);
    for (int j = 1; ; j = 0)
    {
      if (j == 0)
        paramInt = b(i);
      if (paramInt >= i)
        break;
      Camera localCamera2 = Camera.open(paramInt);
      d.ad.J.a(paramInt);
      return localCamera2;
    }
    if (j != 0)
    {
      d.ad.J.a(-1);
      return null;
    }
    Camera localCamera1 = Camera.open(0);
    d.ad.J.a(0);
    return localCamera1;
  }

  public static int b()
  {
    return b(Camera.getNumberOfCameras());
  }

  private static int b(int paramInt)
  {
    for (int i = 0; ; i++)
      if (i < paramInt)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        Camera.getCameraInfo(i, localCameraInfo);
        if (localCameraInfo.facing != 0);
      }
      else
      {
        if (i >= paramInt)
          break;
        return i;
      }
    if (paramInt > 0)
      return 0;
    return -1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.a.a
 * JD-Core Version:    0.6.2
 */