package org.webrtc;

import android.content.Context;
import android.media.MediaRecorder;
import android.os.Handler;
import android.os.Looper;
import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;

abstract class CameraCapturer
  implements CameraVideoCapturer
{
  private static final int MAX_OPEN_CAMERA_ATTEMPTS = 3;
  private static final int OPEN_CAMERA_DELAY_MS = 500;
  private static final int OPEN_CAMERA_TIMEOUT = 10000;
  private static final String TAG = "CameraCapturer";
  private Context applicationContext;
  private final CameraEnumerator cameraEnumerator;
  private String cameraName;

  @Nullable
  private final CameraSession.Events cameraSessionEventsHandler = new CameraSession.Events()
  {
    public void onCameraClosed(CameraSession paramAnonymousCameraSession)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if ((paramAnonymousCameraSession != CameraCapturer.this.currentSession) && (CameraCapturer.this.currentSession != null))
        {
          Logging.d("CameraCapturer", "onCameraClosed from another session.");
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraClosed();
        return;
      }
    }

    public void onCameraDisconnected(CameraSession paramAnonymousCameraSession)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (paramAnonymousCameraSession != CameraCapturer.this.currentSession)
        {
          Logging.w("CameraCapturer", "onCameraDisconnected from another session.");
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraDisconnected();
        CameraCapturer.this.stopCapture();
        return;
      }
    }

    public void onCameraError(CameraSession paramAnonymousCameraSession, String paramAnonymousString)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (paramAnonymousCameraSession != CameraCapturer.this.currentSession)
        {
          Logging.w("CameraCapturer", "onCameraError from another session: " + paramAnonymousString);
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraError(paramAnonymousString);
        CameraCapturer.this.stopCapture();
        return;
      }
    }

    public void onCameraOpening()
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (CameraCapturer.this.currentSession != null)
        {
          Logging.w("CameraCapturer", "onCameraOpening while session was open.");
          return;
        }
        CameraCapturer.this.eventsHandler.onCameraOpening(CameraCapturer.this.cameraName);
        return;
      }
    }

    public void onFrameCaptured(CameraSession paramAnonymousCameraSession, VideoFrame paramAnonymousVideoFrame)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      synchronized (CameraCapturer.this.stateLock)
      {
        if (paramAnonymousCameraSession != CameraCapturer.this.currentSession)
        {
          Logging.w("CameraCapturer", "onFrameCaptured from another session.");
          return;
        }
        if (!CameraCapturer.this.firstFrameObserved)
        {
          CameraCapturer.this.eventsHandler.onFirstFrameAvailable();
          CameraCapturer.access$1102(CameraCapturer.this, true);
        }
        CameraCapturer.this.cameraStatistics.addFrame();
        CameraCapturer.this.capturerObserver.onFrameCaptured(paramAnonymousVideoFrame);
        return;
      }
    }
  };

  @Nullable
  private CameraVideoCapturer.CameraStatistics cameraStatistics;

  @Nullable
  private Handler cameraThreadHandler;
  private CapturerObserver capturerObserver;

  @Nullable
  private final CameraSession.CreateSessionCallback createSessionCallback = new CameraSession.CreateSessionCallback()
  {
    public void onDone(CameraSession paramAnonymousCameraSession)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      Logging.d("CameraCapturer", "Create session done. Switch state: " + CameraCapturer.this.switchState);
      CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
      synchronized (CameraCapturer.this.stateLock)
      {
        CameraCapturer.this.capturerObserver.onCapturerStarted(true);
        CameraCapturer.access$602(CameraCapturer.this, false);
        CameraCapturer.access$702(CameraCapturer.this, paramAnonymousCameraSession);
        CameraCapturer.access$802(CameraCapturer.this, new CameraVideoCapturer.CameraStatistics(CameraCapturer.this.surfaceHelper, CameraCapturer.this.eventsHandler));
        CameraCapturer.access$1102(CameraCapturer.this, false);
        CameraCapturer.this.stateLock.notifyAll();
        if (CameraCapturer.this.switchState == CameraCapturer.SwitchState.IN_PROGRESS)
        {
          CameraCapturer.access$102(CameraCapturer.this, CameraCapturer.SwitchState.IDLE);
          if (CameraCapturer.this.switchEventsHandler != null)
          {
            CameraCapturer.this.switchEventsHandler.onCameraSwitchDone(CameraCapturer.this.cameraEnumerator.isFrontFacing(CameraCapturer.this.cameraName));
            CameraCapturer.access$1202(CameraCapturer.this, null);
          }
        }
        while (CameraCapturer.this.switchState != CameraCapturer.SwitchState.PENDING)
          return;
        CameraCapturer.access$102(CameraCapturer.this, CameraCapturer.SwitchState.IDLE);
        CameraCapturer.this.switchCameraInternal(CameraCapturer.this.switchEventsHandler);
      }
    }

    public void onFailure(CameraSession.FailureType paramAnonymousFailureType, String paramAnonymousString)
    {
      CameraCapturer.this.checkIsOnCameraThread();
      CameraCapturer.this.uiThreadHandler.removeCallbacks(CameraCapturer.this.openCameraTimeoutRunnable);
      while (true)
      {
        synchronized (CameraCapturer.this.stateLock)
        {
          CameraCapturer.this.capturerObserver.onCapturerStarted(false);
          CameraCapturer.access$1610(CameraCapturer.this);
          if (CameraCapturer.this.openAttemptsRemaining <= 0)
          {
            Logging.w("CameraCapturer", "Opening camera failed, passing: " + paramAnonymousString);
            CameraCapturer.access$602(CameraCapturer.this, false);
            CameraCapturer.this.stateLock.notifyAll();
            if (CameraCapturer.this.switchState != CameraCapturer.SwitchState.IDLE)
            {
              if (CameraCapturer.this.switchEventsHandler != null)
              {
                CameraCapturer.this.switchEventsHandler.onCameraSwitchError(paramAnonymousString);
                CameraCapturer.access$1202(CameraCapturer.this, null);
              }
              CameraCapturer.access$102(CameraCapturer.this, CameraCapturer.SwitchState.IDLE);
            }
            if (paramAnonymousFailureType == CameraSession.FailureType.DISCONNECTED)
            {
              CameraCapturer.this.eventsHandler.onCameraDisconnected();
              return;
            }
            CameraCapturer.this.eventsHandler.onCameraError(paramAnonymousString);
          }
        }
        Logging.w("CameraCapturer", "Opening camera failed, retry: " + paramAnonymousString);
        CameraCapturer.this.createSessionInternal(500);
      }
    }
  };

  @Nullable
  private CameraSession currentSession;

  @Nullable
  private final CameraVideoCapturer.CameraEventsHandler eventsHandler;
  private boolean firstFrameObserved;
  private int framerate;
  private int height;
  private int openAttemptsRemaining;
  private final Runnable openCameraTimeoutRunnable = new Runnable()
  {
    public void run()
    {
      CameraCapturer.this.eventsHandler.onCameraError("Camera failed to start within timeout.");
    }
  };
  private boolean sessionOpening;
  private final Object stateLock = new Object();

  @Nullable
  private SurfaceTextureHelper surfaceHelper;

  @Nullable
  private CameraVideoCapturer.CameraSwitchHandler switchEventsHandler;
  private SwitchState switchState = SwitchState.IDLE;
  private final Handler uiThreadHandler;
  private int width;

  public CameraCapturer(String paramString, @Nullable CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler, CameraEnumerator paramCameraEnumerator)
  {
    if (paramCameraEventsHandler == null)
      paramCameraEventsHandler = new CameraVideoCapturer.CameraEventsHandler()
      {
        public void onCameraClosed()
        {
        }

        public void onCameraDisconnected()
        {
        }

        public void onCameraError(String paramAnonymousString)
        {
        }

        public void onCameraFreezed(String paramAnonymousString)
        {
        }

        public void onCameraOpening(String paramAnonymousString)
        {
        }

        public void onFirstFrameAvailable()
        {
        }
      };
    this.eventsHandler = paramCameraEventsHandler;
    this.cameraEnumerator = paramCameraEnumerator;
    this.cameraName = paramString;
    this.uiThreadHandler = new Handler(Looper.getMainLooper());
    String[] arrayOfString = paramCameraEnumerator.getDeviceNames();
    if (arrayOfString.length == 0)
      throw new RuntimeException("No cameras attached.");
    if (!Arrays.asList(arrayOfString).contains(this.cameraName))
      throw new IllegalArgumentException("Camera name " + this.cameraName + " does not match any known camera device.");
  }

  private void checkIsOnCameraThread()
  {
    if (Thread.currentThread() != this.cameraThreadHandler.getLooper().getThread())
    {
      Logging.e("CameraCapturer", "Check is on camera thread failed.");
      throw new RuntimeException("Not on camera thread.");
    }
  }

  private void createSessionInternal(int paramInt)
  {
    this.uiThreadHandler.postDelayed(this.openCameraTimeoutRunnable, paramInt + 10000);
    this.cameraThreadHandler.postDelayed(new Runnable()
    {
      public void run()
      {
        CameraCapturer.this.createCameraSession(CameraCapturer.this.createSessionCallback, CameraCapturer.this.cameraSessionEventsHandler, CameraCapturer.this.applicationContext, CameraCapturer.this.surfaceHelper, CameraCapturer.this.cameraName, CameraCapturer.this.width, CameraCapturer.this.height, CameraCapturer.this.framerate);
      }
    }
    , paramInt);
  }

  private void reportCameraSwitchError(String paramString, @Nullable CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler)
  {
    Logging.e("CameraCapturer", paramString);
    if (paramCameraSwitchHandler != null)
      paramCameraSwitchHandler.onCameraSwitchError(paramString);
  }

  private void switchCameraInternal(@Nullable CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler)
  {
    Logging.d("CameraCapturer", "switchCamera internal");
    String[] arrayOfString = this.cameraEnumerator.getDeviceNames();
    if (arrayOfString.length < 2)
    {
      if (paramCameraSwitchHandler != null)
        paramCameraSwitchHandler.onCameraSwitchError("No camera to switch to.");
      return;
    }
    synchronized (this.stateLock)
    {
      if (this.switchState != SwitchState.IDLE)
      {
        reportCameraSwitchError("Camera switch already in progress.", paramCameraSwitchHandler);
        return;
      }
    }
    if ((!this.sessionOpening) && (this.currentSession == null))
    {
      reportCameraSwitchError("switchCamera: camera is not running.", paramCameraSwitchHandler);
      return;
    }
    this.switchEventsHandler = paramCameraSwitchHandler;
    if (this.sessionOpening)
    {
      this.switchState = SwitchState.PENDING;
      return;
    }
    this.switchState = SwitchState.IN_PROGRESS;
    Logging.d("CameraCapturer", "switchCamera: Stopping session");
    this.cameraStatistics.release();
    this.cameraStatistics = null;
    final CameraSession localCameraSession = this.currentSession;
    this.cameraThreadHandler.post(new Runnable()
    {
      public void run()
      {
        localCameraSession.stop();
      }
    });
    this.currentSession = null;
    this.cameraName = arrayOfString[((1 + Arrays.asList(arrayOfString).indexOf(this.cameraName)) % arrayOfString.length)];
    this.sessionOpening = true;
    this.openAttemptsRemaining = 1;
    createSessionInternal(0);
    Logging.d("CameraCapturer", "switchCamera done");
  }

  public void addMediaRecorderToCamera(MediaRecorder paramMediaRecorder, CameraVideoCapturer.MediaRecorderHandler paramMediaRecorderHandler)
  {
    CameraVideoCapturer..CC.addMediaRecorderToCamera(this, paramMediaRecorder, paramMediaRecorderHandler);
  }

  public void changeCaptureFormat(int paramInt1, int paramInt2, int paramInt3)
  {
    Logging.d("CameraCapturer", "changeCaptureFormat: " + paramInt1 + "x" + paramInt2 + "@" + paramInt3);
    synchronized (this.stateLock)
    {
      stopCapture();
      startCapture(paramInt1, paramInt2, paramInt3);
      return;
    }
  }

  protected abstract void createCameraSession(CameraSession.CreateSessionCallback paramCreateSessionCallback, CameraSession.Events paramEvents, Context paramContext, SurfaceTextureHelper paramSurfaceTextureHelper, String paramString, int paramInt1, int paramInt2, int paramInt3);

  public void dispose()
  {
    Logging.d("CameraCapturer", "dispose");
    stopCapture();
  }

  protected String getCameraName()
  {
    synchronized (this.stateLock)
    {
      String str = this.cameraName;
      return str;
    }
  }

  public void initialize(@Nullable SurfaceTextureHelper paramSurfaceTextureHelper, Context paramContext, CapturerObserver paramCapturerObserver)
  {
    this.applicationContext = paramContext;
    this.capturerObserver = paramCapturerObserver;
    this.surfaceHelper = paramSurfaceTextureHelper;
    if (paramSurfaceTextureHelper == null);
    for (Handler localHandler = null; ; localHandler = paramSurfaceTextureHelper.getHandler())
    {
      this.cameraThreadHandler = localHandler;
      return;
    }
  }

  public boolean isScreencast()
  {
    return false;
  }

  public void printStackTrace()
  {
    Handler localHandler = this.cameraThreadHandler;
    Thread localThread = null;
    if (localHandler != null)
      localThread = this.cameraThreadHandler.getLooper().getThread();
    if (localThread != null)
    {
      StackTraceElement[] arrayOfStackTraceElement = localThread.getStackTrace();
      if (arrayOfStackTraceElement.length > 0)
      {
        Logging.d("CameraCapturer", "CameraCapturer stack trace:");
        int i = arrayOfStackTraceElement.length;
        for (int j = 0; j < i; j++)
          Logging.d("CameraCapturer", arrayOfStackTraceElement[j].toString());
      }
    }
  }

  public void removeMediaRecorderFromCamera(CameraVideoCapturer.MediaRecorderHandler paramMediaRecorderHandler)
  {
    CameraVideoCapturer..CC.removeMediaRecorderFromCamera(this, paramMediaRecorderHandler);
  }

  public void startCapture(int paramInt1, int paramInt2, int paramInt3)
  {
    Logging.d("CameraCapturer", "startCapture: " + paramInt1 + "x" + paramInt2 + "@" + paramInt3);
    if (this.applicationContext == null)
      throw new RuntimeException("CameraCapturer must be initialized before calling startCapture.");
    synchronized (this.stateLock)
    {
      if ((this.sessionOpening) || (this.currentSession != null))
      {
        Logging.w("CameraCapturer", "Session already open");
        return;
      }
      this.width = paramInt1;
      this.height = paramInt2;
      this.framerate = paramInt3;
      this.sessionOpening = true;
      this.openAttemptsRemaining = 3;
      createSessionInternal(0);
      return;
    }
  }

  public void stopCapture()
  {
    Logging.d("CameraCapturer", "Stop capture");
    synchronized (this.stateLock)
    {
      while (this.sessionOpening)
      {
        Logging.d("CameraCapturer", "Stop capture: Waiting for session to open");
        try
        {
          this.stateLock.wait();
        }
        catch (InterruptedException localInterruptedException)
        {
          Logging.w("CameraCapturer", "Stop capture interrupted while waiting for the session to open.");
          Thread.currentThread().interrupt();
          return;
        }
      }
      if (this.currentSession != null)
      {
        Logging.d("CameraCapturer", "Stop capture: Nulling session");
        this.cameraStatistics.release();
        this.cameraStatistics = null;
        final CameraSession localCameraSession = this.currentSession;
        this.cameraThreadHandler.post(new Runnable()
        {
          public void run()
          {
            localCameraSession.stop();
          }
        });
        this.currentSession = null;
        this.capturerObserver.onCapturerStopped();
        Logging.d("CameraCapturer", "Stop capture done");
        return;
      }
      Logging.d("CameraCapturer", "Stop capture: No session open");
    }
  }

  public void switchCamera(final CameraVideoCapturer.CameraSwitchHandler paramCameraSwitchHandler)
  {
    Logging.d("CameraCapturer", "switchCamera");
    this.cameraThreadHandler.post(new Runnable()
    {
      public void run()
      {
        CameraCapturer.this.switchCameraInternal(paramCameraSwitchHandler);
      }
    });
  }

  static enum SwitchState
  {
    static
    {
      IN_PROGRESS = new SwitchState("IN_PROGRESS", 2);
      SwitchState[] arrayOfSwitchState = new SwitchState[3];
      arrayOfSwitchState[0] = IDLE;
      arrayOfSwitchState[1] = PENDING;
      arrayOfSwitchState[2] = IN_PROGRESS;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.CameraCapturer
 * JD-Core Version:    0.6.2
 */