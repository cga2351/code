package org.webrtc;

import java.util.List;

public abstract interface CameraEnumerator
{
  public abstract CameraVideoCapturer createCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler);

  public abstract String[] getDeviceNames();

  public abstract List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String paramString);

  public abstract boolean isBackFacing(String paramString);

  public abstract boolean isFrontFacing(String paramString);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CameraEnumerator
 * JD-Core Version:    0.6.2
 */