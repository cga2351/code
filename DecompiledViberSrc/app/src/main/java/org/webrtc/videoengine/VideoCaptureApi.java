package org.webrtc.videoengine;

import android.graphics.YuvImage;
import android.view.SurfaceHolder;
import java.nio.ByteBuffer;

public abstract class VideoCaptureApi
  implements VideoCaptureDeviceInfo.VideoCaptureInternal
{
  public static void DeleteVideoCapture(VideoCaptureApi paramVideoCaptureApi)
  {
    if ((paramVideoCaptureApi instanceof VideoCaptureApi21))
      VideoCaptureApi21.DeleteCamera(paramVideoCaptureApi);
    if ((paramVideoCaptureApi instanceof VideoCaptureAndroid))
      VideoCaptureDeviceInfoAndroid.DeleteCamera(paramVideoCaptureApi);
    if ((paramVideoCaptureApi instanceof VideoCaptureAndroidH264))
      VideoCaptureAndroidH264.DeleteCamera(paramVideoCaptureApi);
  }

  protected static native void ProvideCameraFrame(byte[] paramArrayOfByte, int paramInt1, long paramLong, int paramInt2, int paramInt3);

  protected static native void ProvideYUVFrame(ByteBuffer paramByteBuffer1, int paramInt1, ByteBuffer paramByteBuffer2, int paramInt2, ByteBuffer paramByteBuffer3, int paramInt3, int paramInt4, int paramInt5, int paramInt6, long paramLong1, long paramLong2);

  public abstract void SetPreviewRotation(int paramInt);

  public abstract int StartCapture(int paramInt1, int paramInt2, int paramInt3, int paramInt4);

  public abstract int StopCapture();

  public abstract void addEventCallback(CaptureEventCallback paramCaptureEventCallback);

  public abstract boolean deletePreviewSessionForHolder(SurfaceHolder paramSurfaceHolder);

  public abstract VideoCaptureDeviceInfo.FrontFacingCameraType getCaptureCameraFacing();

  public abstract double getDeviceAspectRatio();

  public abstract VideoCaptureDeviceInfo getDeviceInfo();

  public abstract int getDeviceOrientationFromRotation(int paramInt);

  public abstract int getDeviceRotationHint();

  public abstract Object getDeviceUniqueName();

  public abstract int getFacing();

  public abstract int getHeight();

  public abstract YuvImage getPreviewBufferCopy();

  public abstract float getPreviewRotation();

  public abstract int getWidth();

  public abstract void lockPreviewUpdate();

  public abstract boolean newPreviewSessionForHolder(SurfaceHolder paramSurfaceHolder);

  public abstract boolean registerPreviewHolder(SurfaceHolder paramSurfaceHolder);

  public abstract void release();

  public abstract void removeEventCallback(CaptureEventCallback paramCaptureEventCallback);

  public abstract void unlockPreviewUpdate();

  public abstract boolean unregisterPreviewHolder(SurfaceHolder paramSurfaceHolder);

  public static abstract interface CaptureEventCallback
  {
    public abstract void onConfigureCamera(VideoCaptureApi paramVideoCaptureApi, int paramInt1, int paramInt2);

    public abstract void onStartCapture(VideoCaptureApi paramVideoCaptureApi);

    public abstract void onStopCapture(VideoCaptureApi paramVideoCaptureApi);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.VideoCaptureApi
 * JD-Core Version:    0.6.2
 */