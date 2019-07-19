package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCaptureSession.CaptureCallback;
import android.hardware.camera2.CameraCaptureSession.StateCallback;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraDevice.StateCallback;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureFailure;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.CaptureRequest.Builder;
import android.os.Handler;
import android.os.Looper;
import android.util.Range;
import android.view.Surface;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

@TargetApi(21)
class Camera2Session
  implements CameraSession
{
  private static final String TAG = "Camera2Session";
  private static final Histogram camera2ResolutionHistogram = Histogram.createEnumeration("WebRTC.Android.Camera2.Resolution", CameraEnumerationAndroid.COMMON_RESOLUTIONS.size());
  private static final Histogram camera2StartTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StartTimeMs", 1, 10000, 50);
  private static final Histogram camera2StopTimeMsHistogram = Histogram.createCounts("WebRTC.Android.Camera2.StopTimeMs", 1, 10000, 50);
  private final Context applicationContext;
  private final CameraSession.CreateSessionCallback callback;
  private CameraCharacteristics cameraCharacteristics;

  @Nullable
  private CameraDevice cameraDevice;
  private final String cameraId;
  private final CameraManager cameraManager;
  private int cameraOrientation;
  private final Handler cameraThreadHandler;
  private CameraEnumerationAndroid.CaptureFormat captureFormat;

  @Nullable
  private CameraCaptureSession captureSession;
  private final long constructionTimeNs;
  private final CameraSession.Events events;
  private boolean firstFrameReported = false;
  private int fpsUnitFactor;
  private final int framerate;
  private final int height;
  private boolean isCameraFrontFacing;
  private SessionState state = SessionState.RUNNING;

  @Nullable
  private Surface surface;
  private final SurfaceTextureHelper surfaceTextureHelper;
  private final int width;

  private Camera2Session(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, CameraManager paramCameraManager, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    Logging.d("Camera2Session", "Create new camera2 session on camera " + paramString);
    this.constructionTimeNs = System.nanoTime();
    this.cameraThreadHandler = new Handler();
    this.callback = paramCreateSessionCallback;
    this.events = paramEvents;
    this.applicationContext = paramContext;
    this.cameraManager = paramCameraManager;
    this.surfaceTextureHelper = paramSurfaceTextureHelper;
    this.cameraId = paramString;
    this.width = paramInt1;
    this.height = paramInt2;
    this.framerate = paramInt3;
    start();
  }

  private void checkIsOnCameraThread()
  {
    if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread())
      throw new IllegalStateException("Wrong thread");
  }

  public static void create(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, CameraManager paramCameraManager, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    new Camera2Session(paramCreateSessionCallback, paramEvents, paramContext, paramCameraManager, paramSurfaceTextureHelper, paramString, paramInt1, paramInt2, paramInt3);
  }

  private void findCaptureFormat()
  {
    checkIsOnCameraThread();
    Range[] arrayOfRange = (Range[])this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
    this.fpsUnitFactor = Camera2Enumerator.getFpsUnitFactor(arrayOfRange);
    List localList1 = Camera2Enumerator.convertFramerates(arrayOfRange, this.fpsUnitFactor);
    List localList2 = Camera2Enumerator.getSupportedSizes(this.cameraCharacteristics);
    Logging.d("Camera2Session", "Available preview sizes: " + localList2);
    Logging.d("Camera2Session", "Available fps ranges: " + localList1);
    if ((localList1.isEmpty()) || (localList2.isEmpty()))
    {
      reportError("No supported capture formats.");
      return;
    }
    CameraEnumerationAndroid.CaptureFormat.FramerateRange localFramerateRange = CameraEnumerationAndroid.getClosestSupportedFramerateRange(localList1, this.framerate);
    Size localSize = CameraEnumerationAndroid.getClosestSupportedSize(localList2, this.width, this.height);
    CameraEnumerationAndroid.reportCameraResolution(camera2ResolutionHistogram, localSize);
    this.captureFormat = new CameraEnumerationAndroid.CaptureFormat(localSize.width, localSize.height, localFramerateRange);
    Logging.d("Camera2Session", "Using capture format: " + this.captureFormat);
  }

  private int getFrameOrientation()
  {
    int i = CameraSession..CC.getDeviceOrientation$$STATIC$$(this.applicationContext);
    if (!this.isCameraFrontFacing)
      i = 360 - i;
    return (i + this.cameraOrientation) % 360;
  }

  private void openCamera()
  {
    checkIsOnCameraThread();
    Logging.d("Camera2Session", "Opening camera " + this.cameraId);
    this.events.onCameraOpening();
    try
    {
      this.cameraManager.openCamera(this.cameraId, new CameraStateCallback(null), this.cameraThreadHandler);
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      reportError("Failed to open camera: " + localCameraAccessException);
    }
  }

  private void reportError(String paramString)
  {
    checkIsOnCameraThread();
    Logging.e("Camera2Session", "Error: " + paramString);
    if ((this.captureSession == null) && (this.state != SessionState.STOPPED));
    for (int i = 1; ; i = 0)
    {
      this.state = SessionState.STOPPED;
      stopInternal();
      if (i == 0)
        break;
      this.callback.onFailure(CameraSession.FailureType.ERROR, paramString);
      return;
    }
    this.events.onCameraError(this, paramString);
  }

  private void start()
  {
    checkIsOnCameraThread();
    Logging.d("Camera2Session", "start");
    while (true)
    {
      try
      {
        this.cameraCharacteristics = this.cameraManager.getCameraCharacteristics(this.cameraId);
        this.cameraOrientation = ((Integer)this.cameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
        if (((Integer)this.cameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0)
        {
          bool = true;
          this.isCameraFrontFacing = bool;
          findCaptureFormat();
          openCamera();
          return;
        }
      }
      catch (CameraAccessException localCameraAccessException)
      {
        reportError("getCameraCharacteristics(): " + localCameraAccessException.getMessage());
        return;
      }
      boolean bool = false;
    }
  }

  private void stopInternal()
  {
    Logging.d("Camera2Session", "Stop internal");
    checkIsOnCameraThread();
    this.surfaceTextureHelper.stopListening();
    if (this.captureSession != null)
    {
      this.captureSession.close();
      this.captureSession = null;
    }
    if (this.surface != null)
    {
      this.surface.release();
      this.surface = null;
    }
    if (this.cameraDevice != null)
    {
      this.cameraDevice.close();
      this.cameraDevice = null;
    }
    Logging.d("Camera2Session", "Stop done");
  }

  public void stop()
  {
    Logging.d("Camera2Session", "Stop camera2 session on camera " + this.cameraId);
    checkIsOnCameraThread();
    if (this.state != SessionState.STOPPED)
    {
      long l = System.nanoTime();
      this.state = SessionState.STOPPED;
      stopInternal();
      int i = (int)TimeUnit.NANOSECONDS.toMillis(System.nanoTime() - l);
      camera2StopTimeMsHistogram.addSample(i);
    }
  }

  private static class CameraCaptureCallback extends CameraCaptureSession.CaptureCallback
  {
    public void onCaptureFailed(CameraCaptureSession paramCameraCaptureSession, CaptureRequest paramCaptureRequest, CaptureFailure paramCaptureFailure)
    {
      Logging.d("Camera2Session", "Capture failed: " + paramCaptureFailure);
    }
  }

  private class CameraStateCallback extends CameraDevice.StateCallback
  {
    private CameraStateCallback()
    {
    }

    private String getErrorDescription(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return "Unknown camera error: " + paramInt;
      case 4:
        return "Camera device has encountered a fatal error.";
      case 3:
        return "Camera device could not be opened due to a device policy.";
      case 1:
        return "Camera device is in use already.";
      case 5:
        return "Camera service has encountered a fatal error.";
      case 2:
      }
      return "Camera device could not be opened because there are too many other open camera devices.";
    }

    public void onClosed(CameraDevice paramCameraDevice)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Logging.d("Camera2Session", "Camera device closed.");
      Camera2Session.this.events.onCameraClosed(Camera2Session.this);
    }

    public void onDisconnected(CameraDevice paramCameraDevice)
    {
      Camera2Session.this.checkIsOnCameraThread();
      if ((Camera2Session.this.captureSession == null) && (Camera2Session.this.state != Camera2Session.SessionState.STOPPED));
      for (int i = 1; ; i = 0)
      {
        Camera2Session.access$202(Camera2Session.this, Camera2Session.SessionState.STOPPED);
        Camera2Session.this.stopInternal();
        if (i == 0)
          break;
        Camera2Session.this.callback.onFailure(CameraSession.FailureType.DISCONNECTED, "Camera disconnected / evicted.");
        return;
      }
      Camera2Session.this.events.onCameraDisconnected(Camera2Session.this);
    }

    public void onError(CameraDevice paramCameraDevice, int paramInt)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Camera2Session.this.reportError(getErrorDescription(paramInt));
    }

    public void onOpened(CameraDevice paramCameraDevice)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Logging.d("Camera2Session", "Camera opened.");
      Camera2Session.access$702(Camera2Session.this, paramCameraDevice);
      Camera2Session.this.surfaceTextureHelper.setTextureSize(Camera2Session.this.captureFormat.width, Camera2Session.this.captureFormat.height);
      Camera2Session.access$1002(Camera2Session.this, new Surface(Camera2Session.this.surfaceTextureHelper.getSurfaceTexture()));
      try
      {
        Surface[] arrayOfSurface = new Surface[1];
        arrayOfSurface[0] = Camera2Session.this.surface;
        paramCameraDevice.createCaptureSession(Arrays.asList(arrayOfSurface), new Camera2Session.CaptureSessionCallback(Camera2Session.this, null), Camera2Session.this.cameraThreadHandler);
        return;
      }
      catch (CameraAccessException localCameraAccessException)
      {
        Camera2Session.this.reportError("Failed to create capture session. " + localCameraAccessException);
      }
    }
  }

  private class CaptureSessionCallback extends CameraCaptureSession.StateCallback
  {
    private CaptureSessionCallback()
    {
    }

    private void chooseFocusMode(CaptureRequest.Builder paramBuilder)
    {
      int[] arrayOfInt = (int[])Camera2Session.this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AF_AVAILABLE_MODES);
      int i = arrayOfInt.length;
      for (int j = 0; j < i; j++)
        if (arrayOfInt[j] == 3)
        {
          paramBuilder.set(CaptureRequest.CONTROL_AF_MODE, Integer.valueOf(3));
          Logging.d("Camera2Session", "Using continuous video auto-focus.");
          return;
        }
      Logging.d("Camera2Session", "Auto-focus is not available.");
    }

    private void chooseStabilizationMode(CaptureRequest.Builder paramBuilder)
    {
      int[] arrayOfInt1 = (int[])Camera2Session.this.cameraCharacteristics.get(CameraCharacteristics.LENS_INFO_AVAILABLE_OPTICAL_STABILIZATION);
      if (arrayOfInt1 != null)
      {
        int k = arrayOfInt1.length;
        for (int m = 0; m < k; m++)
          if (arrayOfInt1[m] == 1)
          {
            paramBuilder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(1));
            paramBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(0));
            Logging.d("Camera2Session", "Using optical stabilization.");
            return;
          }
      }
      int[] arrayOfInt2 = (int[])Camera2Session.this.cameraCharacteristics.get(CameraCharacteristics.CONTROL_AVAILABLE_VIDEO_STABILIZATION_MODES);
      int i = arrayOfInt2.length;
      for (int j = 0; j < i; j++)
        if (arrayOfInt2[j] == 1)
        {
          paramBuilder.set(CaptureRequest.CONTROL_VIDEO_STABILIZATION_MODE, Integer.valueOf(1));
          paramBuilder.set(CaptureRequest.LENS_OPTICAL_STABILIZATION_MODE, Integer.valueOf(0));
          Logging.d("Camera2Session", "Using video stabilization.");
          return;
        }
      Logging.d("Camera2Session", "Stabilization not available.");
    }

    public void onConfigureFailed(CameraCaptureSession paramCameraCaptureSession)
    {
      Camera2Session.this.checkIsOnCameraThread();
      paramCameraCaptureSession.close();
      Camera2Session.this.reportError("Failed to configure capture session.");
    }

    public void onConfigured(CameraCaptureSession paramCameraCaptureSession)
    {
      Camera2Session.this.checkIsOnCameraThread();
      Logging.d("Camera2Session", "Camera capture session configured.");
      Camera2Session.access$102(Camera2Session.this, paramCameraCaptureSession);
      try
      {
        CaptureRequest.Builder localBuilder = Camera2Session.this.cameraDevice.createCaptureRequest(3);
        localBuilder.set(CaptureRequest.CONTROL_AE_TARGET_FPS_RANGE, new Range(Integer.valueOf(Camera2Session.this.captureFormat.framerate.min / Camera2Session.this.fpsUnitFactor), Integer.valueOf(Camera2Session.this.captureFormat.framerate.max / Camera2Session.this.fpsUnitFactor)));
        localBuilder.set(CaptureRequest.CONTROL_AE_MODE, Integer.valueOf(1));
        localBuilder.set(CaptureRequest.CONTROL_AE_LOCK, Boolean.valueOf(false));
        chooseStabilizationMode(localBuilder);
        chooseFocusMode(localBuilder);
        localBuilder.addTarget(Camera2Session.this.surface);
        paramCameraCaptureSession.setRepeatingRequest(localBuilder.build(), new Camera2Session.CameraCaptureCallback(null), Camera2Session.this.cameraThreadHandler);
        Camera2Session.this.surfaceTextureHelper.startListening(new Camera2Session.CaptureSessionCallback..Lambda.0(this));
        Logging.d("Camera2Session", "Camera device successfully started.");
        Camera2Session.this.callback.onDone(Camera2Session.this);
        return;
      }
      catch (CameraAccessException localCameraAccessException)
      {
        Camera2Session.this.reportError("Failed to start capture request. " + localCameraAccessException);
      }
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
 * Qualified Name:     org.webrtc.Camera2Session
 * JD-Core Version:    0.6.2
 */