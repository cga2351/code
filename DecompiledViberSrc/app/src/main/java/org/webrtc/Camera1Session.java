package org.webrtc;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

class Camera1Session
  implements CameraSession
{
  private static final int NUMBER_OF_CAPTURE_BUFFERS = 3;
  private static final String TAG = "Camera1Session";
  private static final Histogram camera1ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera1.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
  private static final Histogram camera1StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StartTimeMs", 1, 10000, 50);
  private static final Histogram camera1StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera1.StopTimeMs", 1, 10000, 50);
  private final Context applicationContext;
  private final Camera camera;
  private final int cameraId;
  private final Handler cameraThreadHandler;
  private final CameraEnumerationAndroid.CaptureFormat captureFormat;
  private final boolean captureToTexture;
  private final long constructionTimeNs;
  private final CameraSession.Events events;
  private boolean firstFrameReported = false;
  private final Camera.CameraInfo info;
  private SessionState state;
  private final SurfaceTextureHelper surfaceTextureHelper;

  private Camera1Session(CameraSession.Events paramEvents, boolean paramBoolean, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, int paramInt, Camera paramCamera, Camera.CameraInfo paramCameraInfo, CameraEnumerationAndroid.CaptureFormat paramCaptureFormat, long paramLong)
  {
    Logging.d("Camera1Session", "Create new camera1 session on camera " + paramInt);
    this.cameraThreadHandler = new Handler();
    this.events = paramEvents;
    this.captureToTexture = paramBoolean;
    this.applicationContext = paramContext;
    this.surfaceTextureHelper = paramSurfaceTextureHelper;
    this.cameraId = paramInt;
    this.camera = paramCamera;
    this.info = paramCameraInfo;
    this.captureFormat = paramCaptureFormat;
    this.constructionTimeNs = paramLong;
    paramSurfaceTextureHelper.setTextureSize(paramCaptureFormat.width, paramCaptureFormat.height);
    startCapturing();
  }

  private void checkIsOnCameraThread()
  {
    if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread())
      throw new IllegalStateException("Wrong thread");
  }

  public static void create(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, boolean paramBoolean, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    long l = System.nanoTime();
    Logging.d("Camera1Session", "Open camera " + paramInt1);
    paramEvents.onCameraOpening();
    Camera localCamera;
    try
    {
      localCamera = Camera.open(paramInt1);
      if (localCamera == null)
      {
        paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, "android.hardware.Camera.open returned null for camera id = " + paramInt1);
        return;
      }
    }
    catch (RuntimeException localRuntimeException1)
    {
      paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, localRuntimeException1.getMessage());
      return;
    }
    try
    {
      localCamera.setPreviewTexture(paramSurfaceTextureHelper.getSurfaceTexture());
      localCameraInfo = new Camera.CameraInfo();
      Camera.getCameraInfo(paramInt1, localCameraInfo);
    }
    catch (RuntimeException localRuntimeException2)
    {
      Camera.CameraInfo localCameraInfo;
      CameraEnumerationAndroid.CaptureFormat localCaptureFormat;
      try
      {
        Camera.Parameters localParameters = localCamera.getParameters();
        localCaptureFormat = findClosestCaptureFormat(localParameters, paramInt2, paramInt3, paramInt4);
        updateCameraParameters(localCamera, localParameters, localCaptureFormat, findClosestPictureSize(localParameters, paramInt2, paramInt3), paramBoolean);
        if (!paramBoolean)
        {
          int i = localCaptureFormat.frameSize();
          int j = 0;
          while (j < 3)
          {
            localCamera.addCallbackBuffer(ByteBuffer.allocateDirect(i).array());
            j++;
            continue;
            localRuntimeException2 = localRuntimeException2;
            localCamera.release();
            paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, localRuntimeException2.getMessage());
            return;
          }
        }
      }
      catch (RuntimeException localRuntimeException3)
      {
        localCamera.release();
        paramCreateSessionCallback.onFailure(CameraSession.FailureType.ERROR, localRuntimeException3.getMessage());
        return;
      }
      localCamera.setDisplayOrientation(0);
      paramCreateSessionCallback.onDone(new Camera1Session(paramEvents, paramBoolean, paramContext, paramSurfaceTextureHelper, paramInt1, localCamera, localCameraInfo, localCaptureFormat, l));
      return;
    }
    catch (IOException localIOException)
    {
      label201: break label201;
    }
  }

  private static CameraEnumerationAndroid.CaptureFormat findClosestCaptureFormat(Camera.Parameters paramParameters, int paramInt1, int paramInt2, int paramInt3)
  {
    List localList = Camera1Enumerator.convertFramerates(paramParameters.getSupportedPreviewFpsRange());
    Logging.d("Camera1Session", "Available fps ranges: " + localList);
    CameraEnumerationAndroid.CaptureFormat.FramerateRange localFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(localList, paramInt3);
    Size localSize = CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(paramParameters.getSupportedPreviewSizes()), paramInt1, paramInt2);
    CameraEnumerationAndroid.reportCameraResolution(camera1ResolutionHistogram, localSize);
    return new CameraEnumerationAndroid.CaptureFormat(localSize.width, localSize.height, localFramerateRange);
  }

  private static Size findClosestPictureSize(Camera.Parameters paramParameters, int paramInt1, int paramInt2)
  {
    return CameraEnumerationAndroid.getClosestSupportedSize(Camera1Enumerator.convertSizes(paramParameters.getSupportedPictureSizes()), paramInt1, paramInt2);
  }

  private int getFrameOrientation()
  {
    int i = CameraSession..CC.getDeviceOrientation$$STATIC$$(this.applicationContext);
    if (this.info.facing == 0)
      i = 360 - i;
    return (i + this.info.orientation) % 360;
  }

  private void listenForBytebufferFrames()
  {
    this.camera.setPreviewCallbackWithBuffer(new Camera.PreviewCallback()
    {
      public void onPreviewFrame(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
      {
        Camera1Session.this.checkIsOnCameraThread();
        if (paramAnonymousCamera != Camera1Session.this.camera)
        {
          Logging.e("Camera1Session", "Callback from a different camera. This should never happen.");
          return;
        }
        if (Camera1Session.this.state != Camera1Session.SessionState.RUNNING)
        {
          Logging.d("Camera1Session", "Bytebuffer frame captured but camera is no longer running.");
          return;
        }
        long l = TimeUnit.MILLISECONDS.toNanos(SystemClock.elapsedRealtime());
        if (!Camera1Session.this.firstFrameReported)
        {
          int i = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - Camera1Session.this.constructionTimeNs);
          Camera1Session.camera1StartTimeMsHistogram.addSample(i);
          Camera1Session.access$502(Camera1Session.this, true);
        }
        VideoFrame localVideoFrame = new VideoFrame(new NV21Buffer(paramAnonymousArrayOfByte, Camera1Session.this.captureFormat.width, Camera1Session.this.captureFormat.height, new Camera1Session.2..Lambda.0(this, paramAnonymousArrayOfByte)), Camera1Session.this.getFrameOrientation(), l);
        Camera1Session.this.events.onFrameCaptured(Camera1Session.this, localVideoFrame);
        localVideoFrame.release();
      }
    });
  }

  private void listenForTextureFrames()
  {
    this.surfaceTextureHelper.startListening(new Camera1Session..Lambda.0(this));
  }

  private void startCapturing()
  {
    Logging.d("Camera1Session", "Start capturing");
    checkIsOnCameraThread();
    this.state = SessionState.RUNNING;
    this.camera.setErrorCallback(new Camera.ErrorCallback()
    {
      public void onError(int paramAnonymousInt, Camera paramAnonymousCamera)
      {
        if (paramAnonymousInt == 100);
        for (String str = "Camera server died!"; ; str = "Camera error: " + paramAnonymousInt)
        {
          Logging.e("Camera1Session", str);
          Camera1Session.this.stopInternal();
          if (paramAnonymousInt != 2)
            break;
          Camera1Session.this.events.onCameraDisconnected(Camera1Session.this);
          return;
        }
        Camera1Session.this.events.onCameraError(Camera1Session.this, str);
      }
    });
    if (this.captureToTexture)
      listenForTextureFrames();
    try
    {
      while (true)
      {
        this.camera.startPreview();
        return;
        listenForBytebufferFrames();
      }
    }
    catch (RuntimeException localRuntimeException)
    {
      stopInternal();
      this.events.onCameraError(this, localRuntimeException.getMessage());
    }
  }

  private void stopInternal()
  {
    Logging.d("Camera1Session", "Stop internal");
    checkIsOnCameraThread();
    if (this.state == SessionState.STOPPED)
    {
      Logging.d("Camera1Session", "Camera is already stopped");
      return;
    }
    this.state = SessionState.STOPPED;
    this.surfaceTextureHelper.stopListening();
    this.camera.stopPreview();
    this.camera.release();
    this.events.onCameraClosed(this);
    Logging.d("Camera1Session", "Stop done");
  }

  private static void updateCameraParameters(Camera paramCamera, Camera.Parameters paramParameters, CameraEnumerationAndroid.CaptureFormat paramCaptureFormat, Size paramSize, boolean paramBoolean)
  {
    List localList = paramParameters.getSupportedFocusModes();
    paramParameters.setPreviewFpsRange(paramCaptureFormat.framerate.min, paramCaptureFormat.framerate.max);
    paramParameters.setPreviewSize(paramCaptureFormat.width, paramCaptureFormat.height);
    paramParameters.setPictureSize(paramSize.width, paramSize.height);
    if (!paramBoolean)
    {
      Objects.requireNonNull(paramCaptureFormat);
      paramParameters.setPreviewFormat(17);
    }
    if (paramParameters.isVideoStabilizationSupported())
      paramParameters.setVideoStabilization(true);
    if (localList.contains("continuous-video"))
      paramParameters.setFocusMode("continuous-video");
    paramCamera.setParameters(paramParameters);
  }

  public void stop()
  {
    Logging.d("Camera1Session", "Stop camera1 session on camera " + this.cameraId);
    checkIsOnCameraThread();
    if (this.state != SessionState.STOPPED)
    {
      long l = System.nanoTime();
      stopInternal();
      int i = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l);
      camera1StopTimeMsHistogram.addSample(i);
    }
  }

  private static enum SessionState
  {
    static
    {
      SessionState[] arrayOfSessionState = new SessionState[2];
      arrayOfSessionState[0] = RUNNING;
      arrayOfSessionState[1] = STOPPED;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Camera1Session
 * JD-Core Version:    0.6.2
 */