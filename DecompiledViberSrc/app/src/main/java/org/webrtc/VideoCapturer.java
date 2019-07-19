package org.webrtc;

import android.content.Context;

public abstract interface VideoCapturer
{
  public abstract void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3);

  public abstract void dispose();

  public abstract void initialize(SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver);

  public abstract boolean isScreencast();

  public abstract void startCapture(int paramInt1, int paramInt2, int paramInt3);

  public abstract void stopCapture()
    throws InterruptedException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoCapturer
 * JD-Core Version:    0.6.2
 */