package org.webrtc;

import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;

public abstract interface CameraVideoCapturer extends VideoCapturer
{
  @Deprecated
  public abstract void addMediaRecorderToCamera(MediaRecorder paramMediaRecorder, MediaRecorderHandler paramMediaRecorderHandler);

  @Deprecated
  public abstract void removeMediaRecorderFromCamera(MediaRecorderHandler paramMediaRecorderHandler);

  public abstract void switchCamera(CameraSwitchHandler paramCameraSwitchHandler);

  public static abstract interface CameraEventsHandler
  {
    public abstract void onCameraClosed();

    public abstract void onCameraDisconnected();

    public abstract void onCameraError(String paramString);

    public abstract void onCameraFreezed(String paramString);

    public abstract void onCameraOpening(String paramString);

    public abstract void onFirstFrameAvailable();
  }

  public static class CameraStatistics
  {
    private static final int CAMERA_FREEZE_REPORT_TIMOUT_MS = 4000;
    private static final int CAMERA_OBSERVER_PERIOD_MS = 2000;
    private static final String TAG = "CameraStatistics";
    private final Runnable cameraObserver = new Runnable()
    {
      public void run()
      {
        int i = Math.round(1000.0F * CameraVideoCapturer.CameraStatistics.this.frameCount / 2000.0F);
        Logging.d("CameraStatistics", "Camera fps: " + i + ".");
        if (CameraVideoCapturer.CameraStatistics.this.frameCount == 0)
        {
          CameraVideoCapturer.CameraStatistics.access$104(CameraVideoCapturer.CameraStatistics.this);
          if ((2000 * CameraVideoCapturer.CameraStatistics.this.freezePeriodCount >= 4000) && (CameraVideoCapturer.CameraStatistics.this.eventsHandler != null))
          {
            Logging.e("CameraStatistics", "Camera freezed.");
            if (CameraVideoCapturer.CameraStatistics.this.surfaceTextureHelper.isTextureInUse())
            {
              CameraVideoCapturer.CameraStatistics.this.eventsHandler.onCameraFreezed("Camera failure. Client must return video buffers.");
              return;
            }
            CameraVideoCapturer.CameraStatistics.this.eventsHandler.onCameraFreezed("Camera failure.");
          }
        }
        else
        {
          CameraVideoCapturer.CameraStatistics.access$102(CameraVideoCapturer.CameraStatistics.this, 0);
        }
        CameraVideoCapturer.CameraStatistics.access$002(CameraVideoCapturer.CameraStatistics.this, 0);
        CameraVideoCapturer.CameraStatistics.this.surfaceTextureHelper.getHandler().postDelayed(this, 2000L);
      }
    };
    private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
    private int frameCount;
    private int freezePeriodCount;
    private final SurfaceTextureHelper surfaceTextureHelper;

    public CameraStatistics(SurfaceTextureHelper paramSurfaceTextureHelper, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
    {
      if (paramSurfaceTextureHelper == null)
        throw new IllegalArgumentException("SurfaceTextureHelper is null");
      this.surfaceTextureHelper = paramSurfaceTextureHelper;
      this.eventsHandler = paramCameraEventsHandler;
      this.frameCount = 0;
      this.freezePeriodCount = 0;
      paramSurfaceTextureHelper.getHandler().postDelayed(this.cameraObserver, 2000L);
    }

    private void checkThread()
    {
      if (Thread.currentThread() != this.surfaceTextureHelper.getHandler().getLooper().getThread())
        throw new IllegalStateException("Wrong thread");
    }

    public void addFrame()
    {
      checkThread();
      this.frameCount = (1 + this.frameCount);
    }

    public void release()
    {
      this.surfaceTextureHelper.getHandler().removeCallbacks(this.cameraObserver);
    }
  }

  public static abstract interface CameraSwitchHandler
  {
    public abstract void onCameraSwitchDone(boolean paramBoolean);

    public abstract void onCameraSwitchError(String paramString);
  }

  @Deprecated
  public static abstract interface MediaRecorderHandler
  {
    public abstract void onMediaRecorderError(String paramString);

    public abstract void onMediaRecorderSuccess();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CameraVideoCapturer
 * JD-Core Version:    0.6.2
 */