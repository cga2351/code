package com.viber.voip.camera.a;

import android.annotation.SuppressLint;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import com.viber.voip.camera.e.a;

public class d extends c
{
  private static final String a = a.a(d.class);

  public int a()
  {
    return Camera.getNumberOfCameras();
  }

  @SuppressLint({"LongLogTag"})
  public boolean a(int paramInt)
  {
    try
    {
      Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt, localCameraInfo);
      int i = localCameraInfo.facing;
      return i == 1;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.a.d
 * JD-Core Version:    0.6.2
 */