package org.webrtc.videoengine;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.YuvImage;
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
import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.Image.Plane;
import android.media.ImageReader;
import android.media.ImageReader.OnImageAvailableListener;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.util.Log;
import android.util.Range;
import android.util.Size;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

@SuppressLint({"UseSparseArrays"})
@TargetApi(21)
public class VideoCaptureApi21 extends VideoCaptureApi
{
  private static final boolean DEBUG_FRAME_INFO = false;
  private static final Logger L = ViberEnv.getLogger();
  private static final int MAX_NUM_IMAGES = 2;
  public static final String TAG = VideoCaptureApi21.class.getSimpleName();
  public static final boolean USE_INTERNAL_SURFACE_SIZE_CONTROL = true;
  private static final Map<Integer, VideoCaptureDeviceInfo> g_helpers = new HashMap();
  protected final AtomicReference<CameraDevice> _cameraDevice = new AtomicReference(null);
  private CameraManager _cameraService = null;
  protected CameraCaptureSession.CaptureCallback _captureListener = new CameraCaptureSession.CaptureCallback()
  {
    public void onCaptureFailed(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, CaptureFailure paramAnonymousCaptureFailure)
    {
      VideoCaptureApi21.log("onCaptureFailed: session=" + paramAnonymousCameraCaptureSession + ", request" + paramAnonymousCaptureRequest + ", fault=" + paramAnonymousCaptureFailure);
      VideoCaptureApi21.this._captureState.set(-2);
    }

    public void onCaptureProgressed(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, CaptureResult paramAnonymousCaptureResult)
    {
    }

    public void onCaptureStarted(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, long paramAnonymousLong1, long paramAnonymousLong2)
    {
      VideoCaptureApi21.log("onCaptureStarted: session=" + paramAnonymousCameraCaptureSession + ", request" + paramAnonymousCaptureRequest + ", timestamp=" + paramAnonymousLong1 + ", frameNumber=" + paramAnonymousLong2);
      if (VideoCaptureApi21.this._captureState.compareAndSet(1, 2))
        VideoCaptureApi21.this.notifyStartEventCallback();
      while (2 != VideoCaptureApi21.this._captureState.get())
        return;
      VideoCaptureApi21.this.notifyFrameAvailable(paramAnonymousLong1, paramAnonymousLong2);
    }
  };
  private final AtomicReference<CameraCaptureSession> _captureSession = new AtomicReference(null);
  protected AtomicInteger _captureState = new AtomicInteger(-1);
  private CameraCaptureSession.StateCallback _captureStateCallback = new CameraCaptureSession.StateCallback()
  {
    public void onConfigureFailed(CameraCaptureSession paramAnonymousCameraCaptureSession)
    {
      VideoCaptureApi21.log("failed to configure capture session: " + paramAnonymousCameraCaptureSession);
      VideoCaptureApi21.this._captureState.set(-2);
      VideoCaptureApi21.this._captureSession.set(null);
    }

    public void onConfigured(CameraCaptureSession paramAnonymousCameraCaptureSession)
    {
      try
      {
        ArrayList localArrayList1 = new ArrayList(VideoCaptureApi21.this._configuredOutputs);
        ArrayList localArrayList2 = new ArrayList(VideoCaptureApi21.this._pendingPreviewSurfaces);
        VideoCaptureApi21.this._captureSession.set(paramAnonymousCameraCaptureSession);
        if (!VideoCaptureApi21.this._captureState.compareAndSet(0, 1))
          VideoCaptureApi21.log("unknown error while configuring: wrong state (" + VideoCaptureApi21.this._captureState.get() + "), need: " + 0);
        if (VideoCaptureApi21.this.checkIfSessionNeedsRestart(VideoCaptureApi21.this._captureSession, (Surface[])localArrayList2.toArray(new Surface[localArrayList2.size()])))
        {
          VideoCaptureApi21.this.createCaptureSession((CameraDevice)VideoCaptureApi21.this._cameraDevice.get(), VideoCaptureApi21.this.getOutputs());
          return;
        }
        VideoCaptureApi21.this.makeBurstCaptureRequests(paramAnonymousCameraCaptureSession, (Surface[])localArrayList1.toArray(new Surface[localArrayList1.size()]));
        return;
      }
      catch (CameraAccessException localCameraAccessException)
      {
        VideoCaptureApi21.this._captureState.set(-2);
        return;
      }
      catch (Exception localException)
      {
        VideoCaptureApi21.this._captureState.set(-2);
      }
    }
  };
  private CameraCharacteristics _characteristics = null;
  protected final Set<Surface> _configuredOutputs = new HashSet();
  private ImageReader _defaultImageReader = null;
  private String _deviceUniqueId = null;
  private final AtomicReference<Handler> _handler = new AtomicReference(null);
  private final AtomicReference<HandlerThread> _handlerThread = new AtomicReference(null);
  protected int _height = 0;
  private VideoCaptureDeviceInfoHelper _helper;
  private final int _id;
  private ImageReader.OnImageAvailableListener _imageAvailableListener = new ImageReader.OnImageAvailableListener()
  {
    public void onImageAvailable(ImageReader paramAnonymousImageReader)
    {
      Image localImage = paramAnonymousImageReader.acquireLatestImage();
      if (localImage == null)
        return;
      VideoCaptureApi21.this.deliverFrame(localImage);
    }
  };
  protected int _max_frameRate = 0;
  protected int _min_frameRate = 0;
  protected final long _nativeContext;
  protected final Set<Surface> _pendingPreviewSurfaces = new HashSet();
  private SurfaceHolder.Callback _previewCallback = new SurfaceHolder.Callback()
  {
    public void surfaceChanged(SurfaceHolder paramAnonymousSurfaceHolder, int paramAnonymousInt1, int paramAnonymousInt2, int paramAnonymousInt3)
    {
      VideoCaptureApi21.log("SurfaceChanged: holder=" + paramAnonymousSurfaceHolder + ", format=" + paramAnonymousInt1 + ", " + paramAnonymousInt2 + "x" + paramAnonymousInt3 + "; vs " + VideoCaptureApi21.this._width + "x" + VideoCaptureApi21.this._height);
      VideoCaptureApi21.this.newPreviewSessionForHolder(paramAnonymousSurfaceHolder);
    }

    public void surfaceCreated(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      VideoCaptureApi21.log("SurfaceCreated: holder=" + paramAnonymousSurfaceHolder);
      VideoCaptureApi21.this.newPreviewSessionForHolder(paramAnonymousSurfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder paramAnonymousSurfaceHolder)
    {
      paramAnonymousSurfaceHolder.setFixedSize(0, 0);
    }
  };
  protected final Set<SurfaceHolder> _previewHolders = new HashSet();
  protected CameraCaptureSession.CaptureCallback _previewListener = new CameraCaptureSession.CaptureCallback()
  {
    public void onCaptureFailed(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, CaptureFailure paramAnonymousCaptureFailure)
    {
    }

    public void onCaptureProgressed(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, CaptureResult paramAnonymousCaptureResult)
    {
    }

    public void onCaptureStarted(CameraCaptureSession paramAnonymousCameraCaptureSession, CaptureRequest paramAnonymousCaptureRequest, long paramAnonymousLong1, long paramAnonymousLong2)
    {
    }
  };
  private int _rotation = 0;
  private CameraDevice.StateCallback _stateCallback = new CameraDevice.StateCallback()
  {
    public void onDisconnected(CameraDevice paramAnonymousCameraDevice)
    {
      VideoCaptureApi21.log("camera disconnected");
      VideoCaptureApi21.this._cameraDevice.set(null);
    }

    public void onError(CameraDevice paramAnonymousCameraDevice, int paramAnonymousInt)
    {
      VideoCaptureApi21.log("camera got error, code=" + paramAnonymousInt);
      VideoCaptureApi21.this._cameraDevice.set(null);
    }

    public void onOpened(CameraDevice paramAnonymousCameraDevice)
    {
      VideoCaptureApi21.this._cameraDevice.set(paramAnonymousCameraDevice);
      VideoCaptureApi21.this.startCaptureInternal(VideoCaptureApi21.this._width, VideoCaptureApi21.this._height, VideoCaptureApi21.this._min_frameRate, VideoCaptureApi21.this._max_frameRate);
    }
  };
  private final Handler _uiHandler = av.a(av.e.a);
  protected int _width = 0;
  private final Set<VideoCaptureApi.CaptureEventCallback> subscribers = new HashSet();

  protected VideoCaptureApi21(VideoCaptureDeviceInfoHelper paramVideoCaptureDeviceInfoHelper, int paramInt, long paramLong, VideoCaptureDeviceInfoAndroid.AutoReleaseCamHolder paramAutoReleaseCamHolder, String paramString)
  {
    this._helper = paramVideoCaptureDeviceInfoHelper;
    this._deviceUniqueId = paramVideoCaptureDeviceInfoHelper.uniqueToCameraId(paramString);
    log("VideoCaptureApi21 ctor: id=" + paramInt + "; unique=" + paramString + "; helper=" + paramVideoCaptureDeviceInfoHelper);
    this._nativeContext = paramLong;
    this._id = paramInt;
    init();
  }

  protected static void DeleteCamera(VideoCaptureApi paramVideoCaptureApi)
  {
    if (!(paramVideoCaptureApi instanceof VideoCaptureApi21));
    VideoCaptureDeviceInfoHelper localVideoCaptureDeviceInfoHelper;
    do
    {
      do
        return;
      while (paramVideoCaptureApi == null);
      paramVideoCaptureApi.StopCapture();
      paramVideoCaptureApi.release();
      localVideoCaptureDeviceInfoHelper = (VideoCaptureDeviceInfoHelper)getDeviceInfoHelper(((VideoCaptureApi21)paramVideoCaptureApi).getId(), ((VideoCaptureApi21)paramVideoCaptureApi).getContext());
    }
    while (localVideoCaptureDeviceInfoHelper == null);
    localVideoCaptureDeviceInfoHelper.DeleteCamera(paramVideoCaptureApi);
  }

  private void addPendingPreviews()
  {
    while (true)
    {
      SurfaceHolder localSurfaceHolder;
      synchronized (this._configuredOutputs)
      {
        synchronized (this._pendingPreviewSurfaces)
        {
          Iterator localIterator = this._previewHolders.iterator();
          if (!localIterator.hasNext())
            break;
          localSurfaceHolder = (SurfaceHolder)localIterator.next();
          if (this._pendingPreviewSurfaces.contains(localSurfaceHolder.getSurface()))
          {
            if (!synchronizeSurfaceHolderSize(localSurfaceHolder, this._width, this._height))
              continue;
            this._configuredOutputs.add(localSurfaceHolder.getSurface());
          }
        }
      }
      if ((localSurfaceHolder.getSurfaceFrame().width() == this._width) && (localSurfaceHolder.getSurfaceFrame().height() == this._height))
        this._configuredOutputs.add(localSurfaceHolder.getSurface());
    }
    this._pendingPreviewSurfaces.clear();
  }

  static Size chooseBigEnoughSize(Size[] paramArrayOfSize, int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfSize.length;
    for (int j = 0; j < i; j++)
    {
      Size localSize = paramArrayOfSize[j];
      if ((localSize.getWidth() >= paramInt1) && (localSize.getHeight() >= paramInt2))
        localArrayList.add(localSize);
    }
    if (localArrayList.size() > 0)
      return (Size)Collections.min(localArrayList, new CompareSizesByArea());
    Log.e(TAG, "Couldn't find any suitable preview size");
    return paramArrayOfSize[0];
  }

  private static VideoCaptureDeviceInfoHelper createDeviceInfoHelper(int paramInt)
  {
    try
    {
      if (21 <= Build.VERSION.SDK_INT)
      {
        localVideoCaptureDeviceInfoHelper = new VideoCaptureDeviceInfoHelper(paramInt, ViberApplication.getApplication());
        return localVideoCaptureDeviceInfoHelper;
      }
      VideoCaptureDeviceInfoHelper localVideoCaptureDeviceInfoHelper = null;
    }
    finally
    {
    }
  }

  public static VideoCaptureDeviceInfo getDeviceInfoHelper(int paramInt, Context paramContext)
  {
    try
    {
      if (!g_helpers.containsKey(Integer.valueOf(paramInt)))
        g_helpers.put(Integer.valueOf(paramInt), createDeviceInfoHelper(paramInt));
      return (VideoCaptureDeviceInfo)g_helpers.get(Integer.valueOf(paramInt));
    }
    finally
    {
    }
  }

  protected static void log(String paramString)
  {
  }

  private boolean makePendingPreviewSession(SurfaceHolder paramSurfaceHolder)
  {
    log("makePendingPreviewSession " + paramSurfaceHolder + ", surface=" + paramSurfaceHolder.getSurface());
    if ((paramSurfaceHolder == null) || (paramSurfaceHolder.getSurface() == null))
      return false;
    log("makePendingPreviewSession - synchronizing holder size");
    synchronizeSurfaceHolderSize(paramSurfaceHolder, this._width, this._height);
    return this._pendingPreviewSurfaces.add(paramSurfaceHolder.getSurface());
  }

  private boolean runPendingPreviewSession(AtomicReference<CameraCaptureSession> paramAtomicReference, Surface paramSurface, int paramInt1, int paramInt2, int paramInt3)
    throws CameraAccessException
  {
    log("runPendingPreviewSession: " + paramSurface + "; session: " + paramAtomicReference.get());
    if (paramAtomicReference.get() == null)
      return false;
    if (checkIfSessionNeedsRestart(paramAtomicReference, new Surface[] { paramSurface }))
    {
      if (createCaptureSession((CameraDevice)this._cameraDevice.get(), getOutputs()) == 0);
      for (boolean bool = true; ; bool = false)
        return bool;
    }
    CaptureRequest.Builder localBuilder = ((CameraCaptureSession)paramAtomicReference.get()).getDevice().createCaptureRequest(1);
    localBuilder.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(this._rotation));
    Iterator localIterator = this._configuredOutputs.iterator();
    while (localIterator.hasNext())
      localBuilder.addTarget((Surface)localIterator.next());
    localBuilder.addTarget(paramSurface);
    try
    {
      ((CameraCaptureSession)paramAtomicReference.get()).setRepeatingRequest(localBuilder.build(), null, null);
      this._captureState.set(2);
      return true;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      this._captureState.set(-2);
    }
    return false;
  }

  private boolean synchronizeSurfaceHolderSize(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2)
  {
    if ((paramInt1 != 0) && (paramInt2 != 0))
    {
      SurfaceSizeSynchronizer localSurfaceSizeSynchronizer = new SurfaceSizeSynchronizer(paramSurfaceHolder, this._width, this._height);
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
        localSurfaceSizeSynchronizer.run();
      while (true)
      {
        return true;
        this._uiHandler.post(localSurfaceSizeSynchronizer);
        localSurfaceSizeSynchronizer.join();
      }
    }
    return false;
  }

  public void SetPreviewRotation(int paramInt)
  {
  }

  public int StartCapture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return startCaptureInternal(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public int StopCapture()
  {
    return stopCaptureInternal(false);
  }

  protected boolean addDefaultOutput()
  {
    if ((this._defaultImageReader == null) || (this._defaultImageReader.getWidth() != getWidth()) || (this._defaultImageReader.getHeight() != getHeight()))
      this._defaultImageReader = createDefaultReader();
    if (this._defaultImageReader != null)
      synchronized (this._configuredOutputs)
      {
        boolean bool = this._configuredOutputs.add(this._defaultImageReader.getSurface());
        return bool;
      }
    return false;
  }

  public void addEventCallback(VideoCaptureApi.CaptureEventCallback paramCaptureEventCallback)
  {
    synchronized (this.subscribers)
    {
      this.subscribers.add(paramCaptureEventCallback);
      return;
    }
  }

  protected boolean checkIfSessionNeedsRestart(AtomicReference<CameraCaptureSession> paramAtomicReference, List<Surface> paramList)
  {
    return checkIfSessionNeedsRestart(paramAtomicReference, (Surface[])paramList.toArray(new Surface[paramList.size()]));
  }

  // ERROR //
  protected boolean checkIfSessionNeedsRestart(AtomicReference<CameraCaptureSession> paramAtomicReference, Surface[] paramArrayOfSurface)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 408	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   4: checkcast 426	android/hardware/camera2/CameraCaptureSession
    //   7: astore_3
    //   8: aload_3
    //   9: ifnull +147 -> 156
    //   12: aload_0
    //   13: getfield 118	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
    //   16: astore 8
    //   18: aload 8
    //   20: monitorenter
    //   21: aload_2
    //   22: arraylength
    //   23: istore 10
    //   25: iconst_0
    //   26: istore 11
    //   28: iconst_0
    //   29: istore 12
    //   31: iload 11
    //   33: iload 10
    //   35: if_icmpge +86 -> 121
    //   38: aload_2
    //   39: iload 11
    //   41: aaload
    //   42: astore 13
    //   44: new 204	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 528
    //   54: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 13
    //   59: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 228	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: getfield 118	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
    //   72: aload 13
    //   74: invokeinterface 291 2 0
    //   79: ifne +152 -> 231
    //   82: iconst_1
    //   83: istore 14
    //   85: iload 12
    //   87: iload 14
    //   89: ior
    //   90: istore 12
    //   92: iload 12
    //   94: ifeq +143 -> 237
    //   97: new 204	java/lang/StringBuilder
    //   100: dup
    //   101: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   104: ldc_w 530
    //   107: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   110: aload 13
    //   112: invokevirtual 221	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   115: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   118: invokestatic 228	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
    //   121: iload 12
    //   123: ifeq +30 -> 153
    //   126: ldc_w 532
    //   129: invokestatic 228	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
    //   132: aload_3
    //   133: invokevirtual 535	android/hardware/camera2/CameraCaptureSession:abortCaptures	()V
    //   136: aload_3
    //   137: invokevirtual 538	android/hardware/camera2/CameraCaptureSession:close	()V
    //   140: aload_1
    //   141: aconst_null
    //   142: invokevirtual 540	java/util/concurrent/atomic/AtomicReference:set	(Ljava/lang/Object;)V
    //   145: aload_0
    //   146: getfield 144	org/webrtc/videoengine/VideoCaptureApi21:_captureState	Ljava/util/concurrent/atomic/AtomicInteger;
    //   149: iconst_0
    //   150: invokevirtual 460	java/util/concurrent/atomic/AtomicInteger:set	(I)V
    //   153: aload 8
    //   155: monitorexit
    //   156: aload_0
    //   157: invokevirtual 542	org/webrtc/videoengine/VideoCaptureApi21:addDefaultOutput	()Z
    //   160: pop
    //   161: aload_0
    //   162: invokespecial 544	org/webrtc/videoengine/VideoCaptureApi21:addPendingPreviews	()V
    //   165: aload_0
    //   166: getfield 118	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
    //   169: astore 5
    //   171: aload 5
    //   173: monitorenter
    //   174: aload_0
    //   175: getfield 118	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
    //   178: aload_2
    //   179: invokestatic 550	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   182: invokeinterface 554 2 0
    //   187: pop
    //   188: new 204	java/lang/StringBuilder
    //   191: dup
    //   192: invokespecial 205	java/lang/StringBuilder:<init>	()V
    //   195: ldc_w 556
    //   198: invokevirtual 211	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: aload_0
    //   202: getfield 118	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
    //   205: invokeinterface 557 1 0
    //   210: invokevirtual 214	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   213: invokevirtual 224	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   216: invokestatic 228	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
    //   219: aload 5
    //   221: monitorexit
    //   222: aload_1
    //   223: invokevirtual 408	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   226: ifnonnull +43 -> 269
    //   229: iconst_1
    //   230: ireturn
    //   231: iconst_0
    //   232: istore 14
    //   234: goto -149 -> 85
    //   237: iinc 11 1
    //   240: goto -209 -> 31
    //   243: astore 15
    //   245: aload 15
    //   247: invokevirtual 558	android/hardware/camera2/CameraAccessException:printStackTrace	()V
    //   250: goto -114 -> 136
    //   253: astore 9
    //   255: aload 8
    //   257: monitorexit
    //   258: aload 9
    //   260: athrow
    //   261: astore 6
    //   263: aload 5
    //   265: monitorexit
    //   266: aload 6
    //   268: athrow
    //   269: iconst_0
    //   270: ireturn
    //
    // Exception table:
    //   from	to	target	type
    //   126	136	243	android/hardware/camera2/CameraAccessException
    //   21	25	253	finally
    //   38	82	253	finally
    //   97	121	253	finally
    //   126	136	253	finally
    //   136	153	253	finally
    //   153	156	253	finally
    //   245	250	253	finally
    //   255	258	253	finally
    //   174	222	261	finally
    //   263	266	261	finally
  }

  protected int createCaptureSession(CameraDevice paramCameraDevice, List<Surface> paramList)
  {
    try
    {
      log("making new capture session");
      notifyCaptureConfiguration();
      Iterator localIterator = paramList.iterator();
      while (localIterator.hasNext())
      {
        Surface localSurface = (Surface)localIterator.next();
        log("++ adding " + localSurface + " to outputs list, valid(" + localSurface.isValid() + ")");
      }
    }
    catch (CameraAccessException localCameraAccessException)
    {
      localCameraAccessException.printStackTrace();
      return -1;
      if (paramList.size() > 0)
        paramCameraDevice.createCaptureSession(paramList, this._captureStateCallback, this._uiHandler);
      log("capture session was made");
      return 0;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      localIllegalArgumentException.printStackTrace();
      return -1;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return -1;
  }

  protected ImageReader createDefaultReader()
  {
    int i = getWidth();
    int j = getHeight();
    log("createDefaultReader, " + i + "x" + j + "@" + 2);
    if ((i != 0) && (j != 0))
    {
      ImageReader localImageReader = ImageReader.newInstance(i, j, 35, 2);
      localImageReader.setOnImageAvailableListener(this._imageAvailableListener, (Handler)this._handler.get());
      return localImageReader;
    }
    return null;
  }

  public boolean deletePreviewSessionForHolder(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      log("deletePreviewSessionForHolder " + paramSurfaceHolder);
      boolean bool = unregisterPreviewHolder(paramSurfaceHolder);
      return bool;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  protected void deliverFrame(Image paramImage)
  {
    if (paramImage != null);
    try
    {
      Image.Plane[] arrayOfPlane = paramImage.getPlanes();
      if (arrayOfPlane != null)
      {
        int i = arrayOfPlane.length;
        if (3 == i);
      }
      else
      {
        return;
      }
      synchronized (this._captureState)
      {
        if (2 != this._captureState.get())
        {
          log("capture state is " + this._captureState.get() + ", dropping this frame");
          return;
        }
        log("delivering frame to WebRTC");
        VideoCaptureApi.ProvideYUVFrame(arrayOfPlane[0].getBuffer(), arrayOfPlane[0].getRowStride(), arrayOfPlane[1].getBuffer(), arrayOfPlane[1].getRowStride(), arrayOfPlane[2].getBuffer(), arrayOfPlane[2].getRowStride(), paramImage.getWidth(), paramImage.getHeight(), this._rotation, paramImage.getTimestamp(), this._nativeContext);
        return;
      }
    }
    finally
    {
      paramImage.close();
    }
  }

  public VideoCaptureDeviceInfo.FrontFacingCameraType getCaptureCameraFacing()
  {
    return VideoCaptureDeviceInfo.FrontFacingCameraType.Android23;
  }

  protected final AtomicReference<CameraCaptureSession> getCaptureSession()
  {
    return this._captureSession;
  }

  protected Context getContext()
  {
    return ViberApplication.getApplication();
  }

  public double getDeviceAspectRatio()
  {
    if (this._width > this._height)
      return this._width / this._height;
    return this._height / this._width;
  }

  public VideoCaptureDeviceInfo getDeviceInfo()
  {
    return this._helper;
  }

  public int getDeviceOrientationFromRotation(int paramInt)
  {
    return (paramInt + this._rotation) % 360;
  }

  public int getDeviceRotationHint()
  {
    if (getFacing() == 1)
      return 180;
    return 0;
  }

  public Object getDeviceUniqueName()
  {
    return this._deviceUniqueId;
  }

  public int getFacing()
  {
    if (this._characteristics != null)
      return ((Integer)this._characteristics.get(CameraCharacteristics.LENS_FACING)).intValue();
    return -1;
  }

  public final Handler getHandler()
  {
    return (Handler)this._handler.get();
  }

  public int getHeight()
  {
    return this._height;
  }

  protected int getId()
  {
    return this._id;
  }

  protected List<Surface> getOutputs()
  {
    synchronized (this._configuredOutputs)
    {
      ArrayList localArrayList = new ArrayList(this._configuredOutputs);
      return localArrayList;
    }
  }

  public YuvImage getPreviewBufferCopy()
  {
    return null;
  }

  public float getPreviewRotation()
  {
    if (this._characteristics != null)
      return ((Integer)this._characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue();
    return 0.0F;
  }

  protected int getSensorOrientation()
  {
    return this._rotation;
  }

  public int getWidth()
  {
    return this._width;
  }

  protected void init()
  {
    log("starting own handler thread");
    HandlerThread localHandlerThread = new HandlerThread("capture " + this._id);
    localHandlerThread.start();
    this._handlerThread.set(localHandlerThread);
    log("making own handler");
    Handler localHandler = new Handler(localHandlerThread.getLooper());
    this._handler.set(localHandler);
    log("querying camera service instance");
    this._cameraService = ((CameraManager)ViberApplication.getApplication().getSystemService("camera"));
    try
    {
      this._characteristics = this._cameraService.getCameraCharacteristics(this._deviceUniqueId);
      this._rotation = getDeviceOrientationFromRotation(((Integer)this._characteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue());
      log("opening camera...");
      this._cameraService.openCamera(this._deviceUniqueId, this._stateCallback, this._uiHandler);
      log("camera opened");
      this._captureState.set(0);
      return;
    }
    catch (CameraAccessException localCameraAccessException)
    {
      this._captureState.set(-2);
    }
  }

  public void lockPreviewUpdate()
  {
  }

  protected void makeBurstCaptureRequests(CameraCaptureSession paramCameraCaptureSession, List<Surface> paramList)
    throws CameraAccessException
  {
    makeBurstCaptureRequests(paramCameraCaptureSession, (Surface[])paramList.toArray(new Surface[paramList.size()]));
  }

  protected void makeBurstCaptureRequests(CameraCaptureSession paramCameraCaptureSession, Surface[] paramArrayOfSurface)
    throws CameraAccessException
  {
    log("makeBurstCaptureRequests " + paramArrayOfSurface + ", rotation: " + this._rotation + ", session:" + paramCameraCaptureSession);
    if (paramCameraCaptureSession == null)
      return;
    CaptureRequest.Builder localBuilder = paramCameraCaptureSession.getDevice().createCaptureRequest(1);
    localBuilder.set(CaptureRequest.JPEG_ORIENTATION, Integer.valueOf(this._rotation));
    int i = paramArrayOfSurface.length;
    for (int j = 0; j < i; j++)
      localBuilder.addTarget(paramArrayOfSurface[j]);
    log("makeBurstCaptureRequests: handler=" + this._handler + ", captureListener=" + this._captureListener);
    paramCameraCaptureSession.setRepeatingRequest(localBuilder.build(), this._captureListener, (Handler)this._handler.get());
  }

  public boolean newPreviewSessionForHolder(SurfaceHolder paramSurfaceHolder)
  {
    while (true)
    {
      boolean bool3;
      try
      {
        log("newPreviewSessionForHolder " + paramSurfaceHolder + ", surface=" + paramSurfaceHolder.getSurface());
        if (this._captureSession.get() == null)
        {
          bool3 = makePendingPreviewSession(paramSurfaceHolder);
          if (this._captureState.compareAndSet(-2, 0))
          {
            int i = startCaptureInternal(this._width, this._height, this._min_frameRate, this._max_frameRate);
            if (i == 0)
            {
              bool4 = true;
              bool1 = bool4 & bool3;
              return bool1;
            }
            boolean bool4 = false;
            continue;
          }
        }
        else
        {
          try
          {
            boolean bool2 = runPendingPreviewSession(this._captureSession, paramSurfaceHolder.getSurface(), 0, this._width, this._height);
            bool1 = bool2;
          }
          catch (CameraAccessException localCameraAccessException)
          {
            localCameraAccessException.printStackTrace();
            bool1 = false;
          }
          continue;
        }
      }
      finally
      {
      }
      boolean bool1 = bool3;
    }
  }

  protected void notifyCaptureConfiguration()
  {
    synchronized (this.subscribers)
    {
      HashSet localHashSet = new HashSet(this.subscribers);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((VideoCaptureApi.CaptureEventCallback)localIterator.next()).onConfigureCamera(this, this._width, this._height);
    }
  }

  protected void notifyFrameAvailable(long paramLong1, long paramLong2)
  {
  }

  protected void notifyStartEventCallback()
  {
    synchronized (this.subscribers)
    {
      HashSet localHashSet = new HashSet(this.subscribers);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((VideoCaptureApi.CaptureEventCallback)localIterator.next()).onStartCapture(this);
    }
  }

  protected void notifyStopEventCallback()
  {
    synchronized (this.subscribers)
    {
      HashSet localHashSet = new HashSet(this.subscribers);
      Iterator localIterator = localHashSet.iterator();
      if (localIterator.hasNext())
        ((VideoCaptureApi.CaptureEventCallback)localIterator.next()).onStopCapture(this);
    }
  }

  public void onRegisterCaptureObject()
  {
  }

  public void onUnregisterCaptureObject()
  {
  }

  public boolean registerPreviewHolder(SurfaceHolder paramSurfaceHolder)
  {
    log("registerPreviewHolder with holder=" + paramSurfaceHolder);
    if (this._captureState.get() == 2)
    {
      log("cannot add new camera view, capture is already started");
      return false;
    }
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() != null));
    synchronized (this._configuredOutputs)
    {
      synchronized (this._previewHolders)
      {
        log("new preview holder registered, " + paramSurfaceHolder);
        log("registerPreviewHolder: leaving");
        return true;
      }
    }
  }

  public void release()
  {
    log("release() for capture object " + this);
    StopCapture();
    this._captureState.set(-1);
    this._cameraDevice.set(null);
    ((HandlerThread)this._handlerThread.get()).quit();
    ((Handler)this._handler.get()).getLooper().quit();
    synchronized (this._configuredOutputs)
    {
      this._configuredOutputs.clear();
      synchronized (this._previewHolders)
      {
        Iterator localIterator = this._previewHolders.iterator();
        if (localIterator.hasNext())
          ((SurfaceHolder)localIterator.next()).removeCallback(this._previewCallback);
      }
    }
    this._previewHolders.clear();
    synchronized (this._pendingPreviewSurfaces)
    {
      this._pendingPreviewSurfaces.clear();
      return;
    }
  }

  public void removeEventCallback(VideoCaptureApi.CaptureEventCallback paramCaptureEventCallback)
  {
    synchronized (this.subscribers)
    {
      this.subscribers.remove(paramCaptureEventCallback);
      return;
    }
  }

  protected int startCaptureInternal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    this._width = paramInt1;
    this._height = paramInt2;
    if (Thread.currentThread() == Looper.getMainLooper().getThread())
    {
      try
      {
        new StartCaptureCommand(this, (CameraDevice)this._cameraDevice.get(), paramInt1, paramInt2, paramInt3, paramInt4).run();
      }
      finally
      {
      }
    }
    else
    {
      StartCaptureCommand localStartCaptureCommand = new StartCaptureCommand(this, (CameraDevice)this._cameraDevice.get(), paramInt1, paramInt2, paramInt3, paramInt4);
      this._uiHandler.post(localStartCaptureCommand);
      localStartCaptureCommand.join();
    }
    return 0;
  }

  protected int stopCaptureInternal(boolean paramBoolean)
  {
    log("StopCameraCapture: soft=" + paramBoolean);
    this._width = 0;
    this._height = 0;
    CameraDevice localCameraDevice;
    if (paramBoolean)
      localCameraDevice = (CameraDevice)this._cameraDevice.get();
    while (Thread.currentThread() == Looper.getMainLooper().getThread())
      try
      {
        new StopCaptureCommand(this, localCameraDevice, (CameraCaptureSession)this._captureSession.getAndSet(null), paramBoolean).run();
        return 0;
        localCameraDevice = (CameraDevice)this._cameraDevice.getAndSet(null);
      }
      finally
      {
      }
    StopCaptureCommand localStopCaptureCommand = new StopCaptureCommand(this, localCameraDevice, (CameraCaptureSession)this._captureSession.getAndSet(null), paramBoolean);
    this._uiHandler.post(localStopCaptureCommand);
    localStopCaptureCommand.join();
    return 0;
  }

  public String toString()
  {
    return "VideoCaptureApi " + this._deviceUniqueId + ":: " + this._width + "x" + this._height;
  }

  public void unlockPreviewUpdate()
  {
  }

  public boolean unregisterPreviewHolder(SurfaceHolder paramSurfaceHolder)
  {
    log("unregisterPreviewHolder with holder=" + paramSurfaceHolder);
    if ((paramSurfaceHolder != null) && (paramSurfaceHolder.getSurface() != null))
    {
      boolean bool2;
      CameraCaptureSession localCameraCaptureSession1;
      List localList;
      synchronized (this._configuredOutputs)
      {
        synchronized (this._previewHolders)
        {
          boolean bool1 = this._previewHolders.remove(paramSurfaceHolder);
          if (bool1)
          {
            log("preview holder removed, " + paramSurfaceHolder);
            paramSurfaceHolder.removeCallback(this._previewCallback);
          }
          bool2 = bool1 | this._configuredOutputs.remove(paramSurfaceHolder.getSurface());
          if (bool2)
            log("preview surface removed, " + paramSurfaceHolder);
          if (bool2)
          {
            localCameraCaptureSession1 = (CameraCaptureSession)this._captureSession.get();
            if (localCameraCaptureSession1 != null)
            {
              localList = getOutputs();
              if ((localList == null) || (localList.size() <= 0))
                break label231;
            }
          }
        }
      }
      try
      {
        makeBurstCaptureRequests(localCameraCaptureSession1, localList);
        return bool2;
        localObject2 = finally;
        throw localObject2;
        localObject1 = finally;
        throw localObject1;
      }
      catch (CameraAccessException localCameraAccessException2)
      {
        localCameraAccessException2.printStackTrace();
        return false;
      }
      label231: CameraCaptureSession localCameraCaptureSession2 = (CameraCaptureSession)this._captureSession.getAndSet(null);
      if (localCameraCaptureSession2 != null);
      while (true)
      {
        try
        {
          localCameraCaptureSession2.abortCaptures();
          bool3 = bool2;
          this._captureState.set(0);
          return bool3;
        }
        catch (CameraAccessException localCameraAccessException1)
        {
          localCameraAccessException1.printStackTrace();
          bool3 = false;
          continue;
        }
        boolean bool3 = bool2;
      }
    }
    return false;
  }

  protected class CaptureState
  {
    protected static final int STATE_CAPTURE_CONFIGURED = 1;
    protected static final int STATE_CAPTURE_STARTED = 2;
    protected static final int STATE_ERROR = -2;
    protected static final int STATE_READY = 0;
    protected static final int STATE_UNINITIALIZED = -1;

    protected CaptureState()
    {
    }
  }

  static class CompareSizesByArea
    implements Comparator<Size>
  {
    public int compare(Size paramSize1, Size paramSize2)
    {
      return Long.signum(paramSize1.getWidth() * paramSize1.getHeight() - paramSize2.getWidth() * paramSize2.getHeight());
    }
  }

  public abstract class SignalableSynchronizer
    implements Runnable
  {
    final Semaphore semaphoreRef;

    public SignalableSynchronizer()
    {
      this.semaphoreRef = null;
    }

    SignalableSynchronizer(Semaphore arg2)
    {
      Object localObject;
      this.semaphoreRef = localObject;
    }

    public SignalableSynchronizer(boolean arg2)
    {
      int i;
      if (i != 0);
      for (Semaphore localSemaphore = new Semaphore(0); ; localSemaphore = null)
      {
        this.semaphoreRef = localSemaphore;
        return;
      }
    }

    public void join()
    {
      if (this.semaphoreRef == null)
        return;
      this.semaphoreRef.acquireUninterruptibly();
    }

    public void signal()
    {
      if (this.semaphoreRef == null)
        return;
      this.semaphoreRef.release();
    }
  }

  private class StartCaptureCommand extends VideoCaptureApi21.SignalableSynchronizer
  {
    private final CameraDevice _camera;
    private final VideoCaptureApi21 _captureApi;
    private final int _height;
    private final int _max_framerate;
    private final int _min_framerate;
    private final int _width;

    public StartCaptureCommand(VideoCaptureApi21 paramCameraDevice, CameraDevice paramInt1, int paramInt2, int paramInt3, int paramInt4, int arg7)
    {
      super(true);
      this._width = paramInt2;
      this._height = paramInt3;
      this._min_framerate = paramInt4;
      int i;
      this._max_framerate = i;
      this._camera = paramInt1;
      this._captureApi = paramCameraDevice;
    }

    public void run()
    {
      try
      {
        VideoCaptureApi21.log("capture start request on " + this._width + "x" + this._height + ", fps [" + this._min_framerate + "-" + this._max_framerate + "]");
        if ((this._width == 0) || (this._height == 0) || (this._camera == null))
        {
          VideoCaptureApi21.log("error starting capture, device '" + toString() + "', camera=" + this._camera + ", state=" + VideoCaptureApi21.this._captureState);
          return;
        }
        if (!this._captureApi._captureState.compareAndSet(0, 1))
        {
          VideoCaptureApi21.log("error starting capture, device '" + toString() + ": invalid state: " + VideoCaptureApi21.this._captureState.get());
          return;
        }
        List localList = this._captureApi.getOutputs();
        if (this._captureApi.checkIfSessionNeedsRestart(VideoCaptureApi21.this._captureSession, (Surface[])localList.toArray(new Surface[localList.size()])))
          VideoCaptureApi21.this.createCaptureSession(this._camera, this._captureApi.getOutputs());
        while (true)
        {
          return;
          VideoCaptureApi21.this.createCaptureSession(this._camera, localList);
        }
      }
      finally
      {
        signal();
      }
    }
  }

  private class StopCaptureCommand extends VideoCaptureApi21.SignalableSynchronizer
  {
    private final CameraDevice _camera;
    private final VideoCaptureApi21 _captureApi;
    private final CameraCaptureSession _session;
    private final boolean _soft;

    StopCaptureCommand(VideoCaptureApi21 paramCameraDevice, CameraDevice paramCameraCaptureSession, CameraCaptureSession paramBoolean, boolean arg5)
    {
      super(true);
      this._captureApi = paramCameraDevice;
      this._camera = paramCameraCaptureSession;
      this._session = paramBoolean;
      boolean bool;
      this._soft = bool;
    }

    // ERROR //
    public void run()
    {
      // Byte code:
      //   0: new 34	java/lang/StringBuilder
      //   3: dup
      //   4: invokespecial 36	java/lang/StringBuilder:<init>	()V
      //   7: ldc 38
      //   9: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   12: aload_0
      //   13: getfield 24	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_camera	Landroid/hardware/camera2/CameraDevice;
      //   16: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   19: ldc 47
      //   21: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   24: aload_0
      //   25: getfield 26	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_session	Landroid/hardware/camera2/CameraCaptureSession;
      //   28: invokevirtual 45	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
      //   31: ldc 49
      //   33: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   36: aload_0
      //   37: getfield 28	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_soft	Z
      //   40: invokevirtual 52	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
      //   43: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   46: invokestatic 62	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
      //   49: aload_0
      //   50: getfield 24	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_camera	Landroid/hardware/camera2/CameraDevice;
      //   53: astore_2
      //   54: aload_2
      //   55: ifnonnull +8 -> 63
      //   58: aload_0
      //   59: invokevirtual 65	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:signal	()V
      //   62: return
      //   63: aload_0
      //   64: getfield 26	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_session	Landroid/hardware/camera2/CameraCaptureSession;
      //   67: astore_3
      //   68: aload_3
      //   69: ifnull +29 -> 98
      //   72: ldc 67
      //   74: invokestatic 62	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
      //   77: aload_0
      //   78: getfield 26	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_session	Landroid/hardware/camera2/CameraCaptureSession;
      //   81: invokevirtual 72	android/hardware/camera2/CameraCaptureSession:abortCaptures	()V
      //   84: aload_0
      //   85: getfield 26	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_session	Landroid/hardware/camera2/CameraCaptureSession;
      //   88: invokevirtual 75	android/hardware/camera2/CameraCaptureSession:stopRepeating	()V
      //   91: aload_0
      //   92: getfield 26	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_session	Landroid/hardware/camera2/CameraCaptureSession;
      //   95: invokevirtual 78	android/hardware/camera2/CameraCaptureSession:close	()V
      //   98: ldc 80
      //   100: invokestatic 62	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
      //   103: aload_0
      //   104: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   107: invokestatic 84	org/webrtc/videoengine/VideoCaptureApi21:access$200	(Lorg/webrtc/videoengine/VideoCaptureApi21;)Ljava/util/concurrent/atomic/AtomicReference;
      //   110: new 86	android/os/HandlerThread
      //   113: dup
      //   114: new 34	java/lang/StringBuilder
      //   117: dup
      //   118: invokespecial 36	java/lang/StringBuilder:<init>	()V
      //   121: ldc 88
      //   123: invokevirtual 42	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
      //   126: aload_0
      //   127: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   130: invokestatic 92	org/webrtc/videoengine/VideoCaptureApi21:access$100	(Lorg/webrtc/videoengine/VideoCaptureApi21;)I
      //   133: invokevirtual 95	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
      //   136: invokevirtual 56	java/lang/StringBuilder:toString	()Ljava/lang/String;
      //   139: invokespecial 97	android/os/HandlerThread:<init>	(Ljava/lang/String;)V
      //   142: invokevirtual 103	java/util/concurrent/atomic/AtomicReference:getAndSet	(Ljava/lang/Object;)Ljava/lang/Object;
      //   145: checkcast 86	android/os/HandlerThread
      //   148: pop
      //   149: aload_0
      //   150: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   153: getfield 107	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
      //   156: astore 5
      //   158: aload 5
      //   160: monitorenter
      //   161: aload_0
      //   162: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   165: getfield 107	org/webrtc/videoengine/VideoCaptureApi21:_configuredOutputs	Ljava/util/Set;
      //   168: invokeinterface 112 1 0
      //   173: aload 5
      //   175: monitorexit
      //   176: aload_0
      //   177: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   180: getfield 115	org/webrtc/videoengine/VideoCaptureApi21:_previewHolders	Ljava/util/Set;
      //   183: astore 7
      //   185: aload 7
      //   187: monitorenter
      //   188: aload_0
      //   189: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   192: getfield 115	org/webrtc/videoengine/VideoCaptureApi21:_previewHolders	Ljava/util/Set;
      //   195: invokeinterface 119 1 0
      //   200: astore 9
      //   202: aload 9
      //   204: invokeinterface 125 1 0
      //   209: ifeq +61 -> 270
      //   212: aload 9
      //   214: invokeinterface 129 1 0
      //   219: checkcast 131	android/view/SurfaceHolder
      //   222: aload_0
      //   223: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   226: invokestatic 135	org/webrtc/videoengine/VideoCaptureApi21:access$300	(Lorg/webrtc/videoengine/VideoCaptureApi21;)Landroid/view/SurfaceHolder$Callback;
      //   229: invokeinterface 139 2 0
      //   234: goto -32 -> 202
      //   237: astore 8
      //   239: aload 7
      //   241: monitorexit
      //   242: aload 8
      //   244: athrow
      //   245: astore_1
      //   246: aload_0
      //   247: invokevirtual 65	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:signal	()V
      //   250: aload_1
      //   251: athrow
      //   252: astore 12
      //   254: aload 12
      //   256: invokevirtual 142	android/hardware/camera2/CameraAccessException:printStackTrace	()V
      //   259: goto -161 -> 98
      //   262: astore 6
      //   264: aload 5
      //   266: monitorexit
      //   267: aload 6
      //   269: athrow
      //   270: aload_0
      //   271: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   274: getfield 115	org/webrtc/videoengine/VideoCaptureApi21:_previewHolders	Ljava/util/Set;
      //   277: invokeinterface 112 1 0
      //   282: aload 7
      //   284: monitorexit
      //   285: aload_0
      //   286: getfield 28	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_soft	Z
      //   289: ifne +61 -> 350
      //   292: aload_0
      //   293: getfield 17	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:this$0	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   296: getfield 146	org/webrtc/videoengine/VideoCaptureApi21:_captureState	Ljava/util/concurrent/atomic/AtomicInteger;
      //   299: astore 10
      //   301: aload 10
      //   303: monitorenter
      //   304: ldc 148
      //   306: invokestatic 62	org/webrtc/videoengine/VideoCaptureApi21:log	(Ljava/lang/String;)V
      //   309: aload_0
      //   310: getfield 22	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_captureApi	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   313: getfield 146	org/webrtc/videoengine/VideoCaptureApi21:_captureState	Ljava/util/concurrent/atomic/AtomicInteger;
      //   316: iconst_m1
      //   317: invokevirtual 154	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   320: aload_0
      //   321: getfield 24	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_camera	Landroid/hardware/camera2/CameraDevice;
      //   324: invokevirtual 157	android/hardware/camera2/CameraDevice:close	()V
      //   327: aload 10
      //   329: monitorexit
      //   330: aload_0
      //   331: getfield 22	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_captureApi	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   334: invokevirtual 160	org/webrtc/videoengine/VideoCaptureApi21:notifyStopEventCallback	()V
      //   337: aload_0
      //   338: invokevirtual 65	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:signal	()V
      //   341: return
      //   342: astore 11
      //   344: aload 10
      //   346: monitorexit
      //   347: aload 11
      //   349: athrow
      //   350: aload_0
      //   351: getfield 22	org/webrtc/videoengine/VideoCaptureApi21$StopCaptureCommand:_captureApi	Lorg/webrtc/videoengine/VideoCaptureApi21;
      //   354: getfield 146	org/webrtc/videoengine/VideoCaptureApi21:_captureState	Ljava/util/concurrent/atomic/AtomicInteger;
      //   357: iconst_0
      //   358: invokevirtual 154	java/util/concurrent/atomic/AtomicInteger:set	(I)V
      //   361: goto -31 -> 330
      //
      // Exception table:
      //   from	to	target	type
      //   188	202	237	finally
      //   202	234	237	finally
      //   239	242	237	finally
      //   270	285	237	finally
      //   0	54	245	finally
      //   63	68	245	finally
      //   72	98	245	finally
      //   98	161	245	finally
      //   176	188	245	finally
      //   242	245	245	finally
      //   254	259	245	finally
      //   267	270	245	finally
      //   285	304	245	finally
      //   330	337	245	finally
      //   347	350	245	finally
      //   350	361	245	finally
      //   72	98	252	android/hardware/camera2/CameraAccessException
      //   161	176	262	finally
      //   264	267	262	finally
      //   304	330	342	finally
      //   344	347	342	finally
    }
  }

  private class SurfaceSizeSynchronizer extends VideoCaptureApi21.SignalableSynchronizer
  {
    final int _height;
    final SurfaceHolder _holder;
    final int _width;

    SurfaceSizeSynchronizer(SurfaceHolder paramInt1, int paramInt2, int arg4)
    {
      super(true);
      this._holder = paramInt1;
      this._width = paramInt2;
      int i;
      this._height = i;
    }

    public void run()
    {
      try
      {
        SurfaceHolder localSurfaceHolder = this._holder;
        if (localSurfaceHolder == null)
          return;
        VideoCaptureApi21.log("SurfaceSizeSynchronizer: frame (" + this._holder.getSurfaceFrame().width() + "x" + this._holder.getSurfaceFrame().height() + "), size=" + this._width + "x" + this._height);
        if ((this._holder.getSurfaceFrame().width() != this._width) || (this._holder.getSurfaceFrame().height() != this._height))
          this._holder.setFixedSize(this._width, this._height);
        return;
      }
      finally
      {
        signal();
      }
    }
  }

  @TargetApi(21)
  static class VideoCaptureDeviceInfoHelper extends VideoCaptureDeviceInfo
  {
    private static Map<String, HashSet<CaptureCapabilityAndroid>> _camera_caps = new HashMap();
    protected static List<String> _camera_ids = Collections.synchronizedList(new ArrayList());
    private CameraManager _cameraService = null;
    private Context _context;
    public final int _id;
    private int _status = -1;
    protected Map<Integer, VideoCaptureApi> videoCaptureApiRegistry = new HashMap();

    public VideoCaptureDeviceInfoHelper(int paramInt, Context paramContext)
    {
      VideoCaptureApi21.log(this + "/+++ VideoCaptureDeviceInfoHelper +++ id=" + paramInt);
      this._id = paramInt;
      this._context = paramContext;
    }

    private static void dumpFullStreamMappingInfo(String paramString, StreamConfigurationMap paramStreamConfigurationMap)
    {
      VideoCaptureApi21.log("++++++++++++++++++++++++++++++++++++++++++++++++++");
      for (int k : paramStreamConfigurationMap.getOutputFormats())
      {
        VideoCaptureApi21.log("-- camera[" + paramString + "]: stream output format " + k + " (" + pixelFormat(k) + ")");
        for (Size localSize : paramStreamConfigurationMap.getOutputSizes(k))
          VideoCaptureApi21.log("---- camera[" + paramString + "]: " + localSize.getWidth() + "x" + localSize.getHeight() + " for colorspace " + k + " (" + pixelFormat(k) + ")");
      }
      VideoCaptureApi21.log("++++++++++++++++++++++++++++++++++++++++++++++++++");
    }

    private static String pixelFormat(int paramInt)
    {
      switch (paramInt)
      {
      default:
        return "unknown";
      case 256:
        return "JPEG";
      case 16:
        return "NV16";
      case 17:
        return "NV21";
      case 37:
        return "RAW10";
      case 32:
        return "RAW_SENSOR";
      case 4:
        return "RGB_565";
      case 35:
        return "YUV_420_888";
      case 20:
        return "YUY2";
      case 842094169:
      }
      return "YV12";
    }

    public VideoCaptureApi AllocateCamera(int paramInt, long paramLong, String paramString)
    {
      VideoCaptureApi21.log(this + "/AllocateCamera: id=" + paramInt + ", context=" + paramLong + ", unique=" + paramString);
      synchronized (this.videoCaptureApiRegistry)
      {
        VideoCaptureApi localVideoCaptureApi = (VideoCaptureApi)this.videoCaptureApiRegistry.get(paramString);
        VideoCaptureApi21.log("AllocateCamera: getting on " + paramString + " returned " + localVideoCaptureApi);
        if (localVideoCaptureApi == null)
        {
          VideoCaptureApi21.log("AllocateCamera: need to allocate new instance");
          localVideoCaptureApi = newVideoCaptor(paramInt, paramLong, paramString);
          VideoCaptureApi21.log("AllocateCamera: allocated, api=" + localVideoCaptureApi);
          this.videoCaptureApiRegistry.put(Integer.valueOf(paramInt), localVideoCaptureApi);
          VideoCaptureApi21.log("AllocateCamera: putting on " + paramString + " returned " + localVideoCaptureApi);
          localVideoCaptureApi.getDeviceInfo().registerCaptureObject(localVideoCaptureApi);
          VideoCaptureApi21.log("broadcasting capture allocated notification");
          notifyCaptureAllocated(localVideoCaptureApi);
          VideoCaptureApi21.log("broadcast completed");
        }
        VideoCaptureApi21.log(this + "/AllocateCamera: returning " + localVideoCaptureApi);
        return localVideoCaptureApi;
      }
    }

    public void DeleteCamera(VideoCaptureApi paramVideoCaptureApi)
    {
      synchronized (this.videoCaptureApiRegistry)
      {
        this.videoCaptureApiRegistry.remove(paramVideoCaptureApi);
        if (paramVideoCaptureApi != null)
        {
          notifyCaptureDeleted(paramVideoCaptureApi);
          paramVideoCaptureApi.getDeviceInfo().deregisterCaptureObject(paramVideoCaptureApi);
          paramVideoCaptureApi.release();
        }
        return;
      }
    }

    public List<String> DeviceNames()
    {
      return _camera_ids;
    }

    public CaptureCapabilityAndroid[] GetCapabilityArray(String paramString)
    {
      String str = uniqueToCameraId(paramString);
      VideoCaptureApi21.log(this + "/GetCapabilityArray: " + paramString + " -> " + str + ": caps=" + _camera_caps.get(str));
      if (_camera_caps.get(str) != null)
        try
        {
          CaptureCapabilityAndroid[] arrayOfCaptureCapabilityAndroid = (CaptureCapabilityAndroid[])new ArrayList((Collection)_camera_caps.get(str)).toArray(new CaptureCapabilityAndroid[((HashSet)_camera_caps.get(str)).size()]);
          return arrayOfCaptureCapabilityAndroid;
        }
        catch (Exception localException)
        {
        }
      return null;
    }

    public String GetDeviceUniqueName(int paramInt)
    {
      VideoCaptureApi21.log("GetDeviceUniqueName: " + paramInt);
      VideoCaptureApi localVideoCaptureApi = (VideoCaptureApi)this.videoCaptureApiRegistry.get(Integer.valueOf(paramInt));
      if (localVideoCaptureApi != null)
      {
        VideoCaptureApi21.log("returning registered name for deviceId " + localVideoCaptureApi.toString());
        return localVideoCaptureApi.toString();
      }
      if ((paramInt < 0) || (paramInt >= NumberOfDevices()))
      {
        VideoCaptureApi21.log("device " + paramInt + " not found");
        return null;
      }
      try
      {
        VideoCaptureApi21.log("returning captureApi name " + getPrefix() + (String)_camera_ids.get(paramInt));
        String str = getPrefix() + (String)_camera_ids.get(paramInt);
        return str;
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
      }
      return null;
    }

    public int GetOrientation(String paramString)
    {
      String str = uniqueToCameraId(paramString);
      VideoCaptureApi21.log("GetOrientation: " + str);
      try
      {
        int i = ((CaptureCapabilityAndroid)((HashSet)_camera_caps.get(str)).iterator().next()).orientation;
        return i;
      }
      catch (Exception localException)
      {
      }
      return -1;
    }

    public int Init()
    {
      this._cameraService = ((CameraManager)this._context.getSystemService("camera"));
      while (true)
      {
        HashSet localHashSet1;
        int m;
        try
        {
          if (_camera_ids.size() != 0)
            break label547;
          _camera_ids.addAll(Arrays.asList(this._cameraService.getCameraIdList()));
          if (_camera_ids.size() <= 0)
            break label592;
          j = 0;
          this._status = j;
          if (j == 0)
          {
            Iterator localIterator = _camera_ids.iterator();
            if (localIterator.hasNext())
            {
              String str1 = (String)localIterator.next();
              CameraCharacteristics localCameraCharacteristics = this._cameraService.getCameraCharacteristics(str1);
              if (localCameraCharacteristics == null)
                continue;
              StreamConfigurationMap localStreamConfigurationMap = (StreamConfigurationMap)localCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
              if (localStreamConfigurationMap == null)
                continue;
              dumpFullStreamMappingInfo(str1, localStreamConfigurationMap);
              Size[] arrayOfSize = localStreamConfigurationMap.getOutputSizes(35);
              if (arrayOfSize == null)
                continue;
              localHashSet1 = (HashSet)_camera_caps.get(str1);
              if (localHashSet1 != null)
                break label579;
              localHashSet2 = new HashSet();
              int k = arrayOfSize.length;
              m = 0;
              if (m < k)
              {
                Size localSize = arrayOfSize[m];
                Range[] arrayOfRange1;
                int n;
                int i1;
                try
                {
                  Range[] arrayOfRange2 = localStreamConfigurationMap.getHighSpeedVideoFpsRangesFor(localSize);
                  arrayOfRange1 = arrayOfRange2;
                  if (arrayOfRange1 == null)
                    break label586;
                  if (arrayOfRange1.length != 0);
                }
                catch (Exception localException)
                {
                  arrayOfRange1 = (Range[])localCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
                  continue;
                  n = arrayOfRange1.length;
                  i1 = 0;
                }
                if (i1 >= n)
                  break label586;
                Range localRange = arrayOfRange1[i1];
                CaptureCapabilityAndroid localCaptureCapabilityAndroid = new CaptureCapabilityAndroid(localSize.getWidth(), localSize.getHeight(), ((Integer)localRange.getLower()).intValue(), ((Integer)localRange.getUpper()).intValue(), ((Integer)localCameraCharacteristics.get(CameraCharacteristics.SENSOR_ORIENTATION)).intValue(), ((Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue(), localStreamConfigurationMap);
                StringBuilder localStringBuilder = new StringBuilder().append("camera ").append(str1).append(" -- ").append(localSize.getWidth()).append("x").append(localSize.getHeight()).append("@").append(localRange.getLower()).append("-").append(localRange.getUpper()).append(", sensor orientation: ").append(localCaptureCapabilityAndroid.orientation).append(", facing: ");
                if (localCaptureCapabilityAndroid.lens_facing != 0)
                  break label598;
                str2 = "front";
                VideoCaptureApi21.log(str2);
                localHashSet2.add(localCaptureCapabilityAndroid);
                i1++;
                continue;
              }
              if (localHashSet2.size() > 0)
                _camera_caps.put(str1, localHashSet2);
              VideoCaptureApi21.log("camera " + str1 + " +++++++++++");
              continue;
            }
          }
        }
        catch (CameraAccessException localCameraAccessException)
        {
          localCameraAccessException.printStackTrace();
        }
        return this._status;
        label547: VideoCaptureApi21.log("camera names list is already populated, no need to duplicate");
        if (_camera_ids.size() > 0);
        for (int i = 0; ; i = -1)
        {
          this._status = i;
          break;
        }
        label579: HashSet localHashSet2 = localHashSet1;
        continue;
        label586: m++;
        continue;
        label592: int j = -1;
        continue;
        label598: String str2 = "back";
      }
    }

    public int NumberOfDevices()
    {
      return _camera_ids.size();
    }

    protected String getPrefix()
    {
      return "";
    }

    protected VideoCaptureApi newVideoCaptor(int paramInt, long paramLong, String paramString)
    {
      return new VideoCaptureApi21(this, paramInt, paramLong, null, paramString);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.VideoCaptureApi21
 * JD-Core Version:    0.6.2
 */