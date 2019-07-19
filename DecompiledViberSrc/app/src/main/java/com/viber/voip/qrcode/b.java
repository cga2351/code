package com.viber.voip.qrcode;

import android.content.Context;
import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.view.Display;
import android.view.WindowManager;
import com.google.e.b.a.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

final class b
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private Point c;
  private Point d;

  b(Context paramContext)
  {
    this.b = paramContext;
  }

  Point a()
  {
    return this.d;
  }

  void a(int paramInt, Camera paramCamera)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(paramInt, localCameraInfo);
    int i;
    switch (((WindowManager)this.b.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default:
      i = 0;
      if (localCameraInfo.facing != 1)
        break;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    for (int j = (360 - (i + localCameraInfo.orientation) % 360) % 360; ; j = (360 + (localCameraInfo.orientation - i)) % 360)
    {
      paramCamera.setDisplayOrientation(j);
      return;
      i = 0;
      break;
      i = 90;
      break;
      i = 180;
      break;
      i = 270;
      break;
    }
  }

  void a(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    Display localDisplay = ((WindowManager)this.b.getSystemService("window")).getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    this.c = localPoint;
    this.d = a.a(localParameters, this.c);
  }

  void a(Camera paramCamera, boolean paramBoolean)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    if (localParameters == null);
    Camera.Size localSize;
    do
    {
      return;
      if (paramBoolean);
      a.a(localParameters, true, true, paramBoolean);
      if (!paramBoolean)
      {
        a.b(localParameters);
        a.a(localParameters);
      }
      localParameters.setPreviewSize(this.d.x, this.d.y);
      paramCamera.setParameters(localParameters);
      localSize = paramCamera.getParameters().getPreviewSize();
    }
    while ((localSize == null) || ((this.d.x == localSize.width) && (this.d.y == localSize.height)));
    this.d.x = localSize.width;
    this.d.y = localSize.height;
  }

  Point b()
  {
    return this.c;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.b
 * JD-Core Version:    0.6.2
 */