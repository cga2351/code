package com.viber.voip.qrcode;

import android.graphics.Point;
import android.hardware.Camera;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Message;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;

final class g
  implements Camera.PreviewCallback
{
  private static final Logger a = ViberEnv.getLogger();
  private final b b;
  private Handler c;
  private int d;

  g(b paramb)
  {
    this.b = paramb;
  }

  void a(Handler paramHandler, int paramInt)
  {
    this.c = paramHandler;
    this.d = paramInt;
  }

  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    Point localPoint = this.b.a();
    Handler localHandler = this.c;
    if ((localPoint != null) && (localHandler != null))
    {
      localHandler.obtainMessage(this.d, localPoint.x, localPoint.y, paramArrayOfByte).sendToTarget();
      this.c = null;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.qrcode.g
 * JD-Core Version:    0.6.2
 */