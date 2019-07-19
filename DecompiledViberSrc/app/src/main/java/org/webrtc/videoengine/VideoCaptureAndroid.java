package org.webrtc.videoengine;

import android.graphics.Rect;
import android.graphics.YuvImage;
import android.hardware.Camera;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PreviewCallback;
import android.hardware.Camera.Size;
import android.os.Build;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Looper;
import android.view.SurfaceHolder;
import android.view.SurfaceHolder.Callback;
import android.view.SurfaceView;
import android.widget.Toast;
import com.viber.dexshared.Logger;
import com.viber.voip.R.string;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.av;
import com.viber.voip.av.e;
import com.viber.voip.n.b;
import com.viber.voip.util.u;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class VideoCaptureAndroid extends VideoCaptureApi
  implements Camera.ErrorCallback, Camera.PreviewCallback, SurfaceHolder.Callback, Thread.UncaughtExceptionHandler, ViERenderer.ViERendererCallback
{
  private static final boolean FORCE_USE_LIVE_CAMERA_PREVIEW = true;
  private static final Logger L;
  private static final long PROBLEMATIC_CAMERA_NOTIFICATION_DELAY = 5000L;
  private static final boolean USE_CAMERA_CONTROL_THREAD = false;
  public static final boolean USE_LIVE_CAMERA_PREVIEW = false;
  private static final boolean USE_OWN_CAPTURE_BUFFERS = true;
  private static int supported_pixfmt_index;
  private AtomicBoolean _previewUpdate = new AtomicBoolean(true);
  private Thread.UncaughtExceptionHandler _ubhandler = null;
  private int[] bits_per_pixel = { 12, 12, 12 };
  VideoCaptureDeviceInfoAndroid.AutoReleaseCamHolder camholder = null;
  private ReentrantLock captureLock = new ReentrantLock();
  long context = 0L;
  private VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice currentDevice = null;
  private final VideoCaptureDeviceInfoAndroid deviceInfo;
  private String deviceUniqueName = null;
  private int expectedFrameSize = 0;
  private int id = 0;
  private AtomicBoolean isCaptureRunning = new AtomicBoolean(false);
  private int mCaptureHeight = 0;
  private int mCaptureMaxFPS = -1;
  private int mCaptureMinFPS = -1;
  private int mCaptureWidth = 0;
  byte[][] mPreviewBuffer = new byte[3][];
  AtomicInteger mPreviewBufferIndex = new AtomicInteger(-1);
  private final int numCaptureBuffers = 3;
  private int orientation = 0;
  private boolean ownsBuffers = false;
  private int[] pixel_formats = { 35, 842094169, 17 };
  public ReentrantLock previewBufferLock = new ReentrantLock();
  private Runnable problematicCameraCallback = new Runnable()
  {
    public void run()
    {
      Toast.makeText(ViberApplication.getApplication(), R.string.debug_problems_with_camera, 1).show();
    }
  };
  private Set<VideoCaptureApi.CaptureEventCallback> subscribers = new HashSet();

  static
  {
    int i = 1;
    L = ViberEnv.getLogger();
    int j;
    int k;
    if (("grouper".equals(Build.DEVICE)) && ("Nexus 7".equals(Build.MODEL)))
    {
      j = i;
      k = j | 0x1;
      if ((!"endeavoru".equals(Build.DEVICE)) || (!"HTC One X".equals(Build.MODEL)))
        break label74;
    }
    while (true)
    {
      USE_LIVE_CAMERA_PREVIEW = k | i;
      supported_pixfmt_index = 0;
      return;
      j = 0;
      break;
      label74: i = 0;
    }
  }

  protected VideoCaptureAndroid(VideoCaptureDeviceInfoAndroid paramVideoCaptureDeviceInfoAndroid, int paramInt, long paramLong, VideoCaptureDeviceInfoAndroid.AutoReleaseCamHolder paramAutoReleaseCamHolder)
  {
    this.deviceInfo = paramVideoCaptureDeviceInfoAndroid;
    this.id = paramInt;
    this.context = paramLong;
    this.camholder = paramAutoReleaseCamHolder;
    this.currentDevice = paramAutoReleaseCamHolder.device();
    this.deviceUniqueName = paramAutoReleaseCamHolder.deviceUniqueId();
    try
    {
      this.camholder.get().setPreviewDisplay(null);
      this.camholder.get().setPreviewCallback(null);
      this.camholder.get().setPreviewCallbackWithBuffer(null);
      return;
    }
    catch (IOException localIOException)
    {
      while (true)
        localIOException.printStackTrace();
    }
  }

  public static VideoCaptureDeviceInfoAndroid.AutoReleaseCamHolder AllocateCamera(int paramInt, long paramLong, String paramString)
  {
    try
    {
      List localList = VideoCaptureDeviceInfoAndroid.getDevicesList();
      if (localList != null)
      {
        Iterator localIterator = localList.iterator();
        while (localIterator.hasNext())
        {
          VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = (VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice)localIterator.next();
          if (localAndroidVideoCaptureDevice.deviceUniqueName.equals(paramString))
          {
            Object localObject;
            switch (9.$SwitchMap$org$webrtc$videoengine$VideoCaptureDeviceInfo$FrontFacingCameraType[localAndroidVideoCaptureDevice.frontCameraType.ordinal()])
            {
            default:
              if (Build.VERSION.SDK_INT > 8)
                localObject = Camera.open(localAndroidVideoCaptureDevice.index);
              break;
            case 1:
            case 2:
            }
            while (true)
            {
              return new VideoCaptureDeviceInfoAndroid.AutoReleaseCamHolder((Camera)localObject, localAndroidVideoCaptureDevice, paramString);
              localObject = VideoCaptureDeviceInfoAndroid.AllocateGalaxySFrontCamera();
              continue;
              localObject = VideoCaptureDeviceInfoAndroid.AllocateEVOFrontFacingCamera();
              continue;
              Camera localCamera = Camera.open();
              localObject = localCamera;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  private int StartCaptureInternal(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    try
    {
      this.captureLock.lock();
      this.mCaptureWidth = paramInt1;
      this.mCaptureHeight = paramInt2;
      this.mCaptureMinFPS = paramInt3;
      this.mCaptureMaxFPS = paramInt4;
      int i = tryStartCapture(this.mCaptureWidth, this.mCaptureHeight, this.mCaptureMinFPS, this.mCaptureMaxFPS, null);
      return i;
    }
    finally
    {
      this.captureLock.unlock();
    }
  }

  // ERROR //
  private int StopCaptureInternal()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 118	org/webrtc/videoengine/VideoCaptureAndroid:previewBufferLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   4: invokevirtual 285	java/util/concurrent/locks/ReentrantLock:lock	()V
    //   7: aload_0
    //   8: getfield 132	org/webrtc/videoengine/VideoCaptureAndroid:isCaptureRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   11: invokevirtual 295	java/util/concurrent/atomic/AtomicBoolean:get	()Z
    //   14: istore_3
    //   15: iload_3
    //   16: ifne +39 -> 55
    //   19: aload_0
    //   20: iconst_0
    //   21: putfield 146	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureWidth	I
    //   24: aload_0
    //   25: iconst_0
    //   26: putfield 148	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureHeight	I
    //   29: aload_0
    //   30: iconst_0
    //   31: putfield 152	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMinFPS	I
    //   34: aload_0
    //   35: iconst_0
    //   36: putfield 150	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMaxFPS	I
    //   39: aload_0
    //   40: getfield 118	org/webrtc/videoengine/VideoCaptureAndroid:previewBufferLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   43: invokevirtual 292	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   46: aload_0
    //   47: getfield 179	org/webrtc/videoengine/VideoCaptureAndroid:_ubhandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   50: invokestatic 301	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   53: iconst_0
    //   54: ireturn
    //   55: aload_0
    //   56: getfield 111	org/webrtc/videoengine/VideoCaptureAndroid:camholder	Lorg/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AutoReleaseCamHolder;
    //   59: invokevirtual 197	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AutoReleaseCamHolder:get	()Landroid/hardware/Camera;
    //   62: astore 4
    //   64: getstatic 307	com/viber/voip/av$e:a	Lcom/viber/voip/av$e;
    //   67: invokestatic 312	com/viber/voip/av:a	(Lcom/viber/voip/av$e;)Landroid/os/Handler;
    //   70: aload_0
    //   71: getfield 177	org/webrtc/videoengine/VideoCaptureAndroid:problematicCameraCallback	Ljava/lang/Runnable;
    //   74: ldc2_w 22
    //   77: invokevirtual 318	android/os/Handler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   80: pop
    //   81: aload 4
    //   83: ifnull +32 -> 115
    //   86: aload 4
    //   88: invokevirtual 321	android/hardware/Camera:stopPreview	()V
    //   91: aload 4
    //   93: aconst_null
    //   94: invokevirtual 203	android/hardware/Camera:setPreviewDisplay	(Landroid/view/SurfaceHolder;)V
    //   97: aload 4
    //   99: aconst_null
    //   100: invokevirtual 325	android/hardware/Camera:setPreviewTexture	(Landroid/graphics/SurfaceTexture;)V
    //   103: aload 4
    //   105: aconst_null
    //   106: invokevirtual 207	android/hardware/Camera:setPreviewCallback	(Landroid/hardware/Camera$PreviewCallback;)V
    //   109: aload 4
    //   111: aconst_null
    //   112: invokevirtual 210	android/hardware/Camera:setPreviewCallbackWithBuffer	(Landroid/hardware/Camera$PreviewCallback;)V
    //   115: getstatic 307	com/viber/voip/av$e:a	Lcom/viber/voip/av$e;
    //   118: invokestatic 312	com/viber/voip/av:a	(Lcom/viber/voip/av$e;)Landroid/os/Handler;
    //   121: aload_0
    //   122: getfield 177	org/webrtc/videoengine/VideoCaptureAndroid:problematicCameraCallback	Ljava/lang/Runnable;
    //   125: invokevirtual 329	android/os/Handler:removeCallbacks	(Ljava/lang/Runnable;)V
    //   128: aload_0
    //   129: getfield 132	org/webrtc/videoengine/VideoCaptureAndroid:isCaptureRunning	Ljava/util/concurrent/atomic/AtomicBoolean;
    //   132: iconst_0
    //   133: invokevirtual 332	java/util/concurrent/atomic/AtomicBoolean:set	(Z)V
    //   136: aload_0
    //   137: invokespecial 335	org/webrtc/videoengine/VideoCaptureAndroid:notifyStopEventCallback	()V
    //   140: aload_0
    //   141: iconst_0
    //   142: putfield 146	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureWidth	I
    //   145: aload_0
    //   146: iconst_0
    //   147: putfield 148	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureHeight	I
    //   150: aload_0
    //   151: iconst_0
    //   152: putfield 152	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMinFPS	I
    //   155: aload_0
    //   156: iconst_0
    //   157: putfield 150	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMaxFPS	I
    //   160: aload_0
    //   161: getfield 118	org/webrtc/videoengine/VideoCaptureAndroid:previewBufferLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   164: invokevirtual 292	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   167: aload_0
    //   168: getfield 179	org/webrtc/videoengine/VideoCaptureAndroid:_ubhandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   171: invokestatic 301	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   174: iconst_0
    //   175: ireturn
    //   176: astore 6
    //   178: aload 6
    //   180: invokevirtual 336	java/lang/Exception:printStackTrace	()V
    //   183: goto -86 -> 97
    //   186: astore_2
    //   187: aload_0
    //   188: iconst_0
    //   189: putfield 146	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureWidth	I
    //   192: aload_0
    //   193: iconst_0
    //   194: putfield 148	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureHeight	I
    //   197: aload_0
    //   198: iconst_0
    //   199: putfield 152	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMinFPS	I
    //   202: aload_0
    //   203: iconst_0
    //   204: putfield 150	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMaxFPS	I
    //   207: aload_0
    //   208: getfield 118	org/webrtc/videoengine/VideoCaptureAndroid:previewBufferLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   211: invokevirtual 292	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   214: aload_0
    //   215: getfield 179	org/webrtc/videoengine/VideoCaptureAndroid:_ubhandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   218: invokestatic 301	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   221: iconst_m1
    //   222: ireturn
    //   223: astore 7
    //   225: aload 7
    //   227: invokevirtual 336	java/lang/Exception:printStackTrace	()V
    //   230: goto -127 -> 103
    //   233: astore_1
    //   234: aload_0
    //   235: iconst_0
    //   236: putfield 146	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureWidth	I
    //   239: aload_0
    //   240: iconst_0
    //   241: putfield 148	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureHeight	I
    //   244: aload_0
    //   245: iconst_0
    //   246: putfield 152	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMinFPS	I
    //   249: aload_0
    //   250: iconst_0
    //   251: putfield 150	org/webrtc/videoengine/VideoCaptureAndroid:mCaptureMaxFPS	I
    //   254: aload_0
    //   255: getfield 118	org/webrtc/videoengine/VideoCaptureAndroid:previewBufferLock	Ljava/util/concurrent/locks/ReentrantLock;
    //   258: invokevirtual 292	java/util/concurrent/locks/ReentrantLock:unlock	()V
    //   261: aload_0
    //   262: getfield 179	org/webrtc/videoengine/VideoCaptureAndroid:_ubhandler	Ljava/lang/Thread$UncaughtExceptionHandler;
    //   265: invokestatic 301	java/lang/Thread:setDefaultUncaughtExceptionHandler	(Ljava/lang/Thread$UncaughtExceptionHandler;)V
    //   268: aload_1
    //   269: athrow
    //   270: astore 8
    //   272: aload 8
    //   274: invokevirtual 336	java/lang/Exception:printStackTrace	()V
    //   277: goto -168 -> 109
    //   280: astore 9
    //   282: aload 9
    //   284: invokevirtual 336	java/lang/Exception:printStackTrace	()V
    //   287: goto -172 -> 115
    //
    // Exception table:
    //   from	to	target	type
    //   91	97	176	java/lang/Exception
    //   0	15	186	java/lang/Exception
    //   55	81	186	java/lang/Exception
    //   86	91	186	java/lang/Exception
    //   115	140	186	java/lang/Exception
    //   178	183	186	java/lang/Exception
    //   225	230	186	java/lang/Exception
    //   272	277	186	java/lang/Exception
    //   282	287	186	java/lang/Exception
    //   97	103	223	java/lang/Exception
    //   0	15	233	finally
    //   55	81	233	finally
    //   86	91	233	finally
    //   91	97	233	finally
    //   97	103	233	finally
    //   103	109	233	finally
    //   109	115	233	finally
    //   115	140	233	finally
    //   178	183	233	finally
    //   225	230	233	finally
    //   272	277	233	finally
    //   282	287	233	finally
    //   103	109	270	java/lang/Exception
    //   109	115	280	java/lang/Exception
  }

  private static boolean checkIfColorspaceIsNotBlacklisted(int paramInt)
  {
    if ((("jflte".equals(Build.DEVICE)) || ("pyramid".equals(Build.DEVICE)) || ("crespo".equals(Build.DEVICE)) || ("ST25i".equals(Build.DEVICE)) || (Build.MODEL.equals("KFJWI"))) && (842094169 == paramInt));
    while ((("SAMSUNG-SGH-I747".equals(Build.MODEL)) || ("ODROID-U2".equals(Build.MODEL)) || ("XT1092".equals(Build.MODEL)) || ("XT1095".equals(Build.MODEL)) || ("XT1096".equals(Build.MODEL)) || ("XT1097".equals(Build.MODEL))) && (17 != paramInt))
      return false;
    return true;
  }

  private void notifyConfigureEventCallback(final int paramInt1, final int paramInt2)
  {
    Runnable local2;
    synchronized (this.subscribers)
    {
      final HashSet localHashSet = new HashSet(this.subscribers);
      local2 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localHashSet.iterator();
          while (localIterator.hasNext())
            ((VideoCaptureApi.CaptureEventCallback)localIterator.next()).onConfigureCamera(VideoCaptureAndroid.this, paramInt1, paramInt2);
        }
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        local2.run();
        return;
      }
    }
    av.a(av.e.a).post(local2);
  }

  private void notifyStartEventCallback()
  {
    Runnable local1;
    synchronized (this.subscribers)
    {
      final HashSet localHashSet = new HashSet(this.subscribers);
      local1 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localHashSet.iterator();
          while (localIterator.hasNext())
            ((VideoCaptureApi.CaptureEventCallback)localIterator.next()).onStartCapture(VideoCaptureAndroid.this);
        }
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        local1.run();
        return;
      }
    }
    av.a(av.e.a).post(local1);
  }

  private void notifyStopEventCallback()
  {
    Runnable local3;
    synchronized (this.subscribers)
    {
      final HashSet localHashSet = new HashSet(this.subscribers);
      local3 = new Runnable()
      {
        public void run()
        {
          Iterator localIterator = localHashSet.iterator();
          while (localIterator.hasNext())
            ((VideoCaptureApi.CaptureEventCallback)localIterator.next()).onStopCapture(VideoCaptureAndroid.this);
        }
      };
      if (Thread.currentThread() == Looper.getMainLooper().getThread())
      {
        local3.run();
        return;
      }
    }
    av.a(av.e.a).post(local3);
  }

  private void setCameraBuffers(Camera paramCamera, int paramInt1, int paramInt2)
  {
    int i = paramInt1 * paramInt2 * this.bits_per_pixel[supported_pixfmt_index] >> 3;
    for (int j = 0; j < 3; j++)
    {
      this.mPreviewBuffer[j] = new byte[i];
      paramCamera.addCallbackBuffer(this.mPreviewBuffer[j]);
    }
    paramCamera.setPreviewCallbackWithBuffer(this);
    this.ownsBuffers = true;
    this.expectedFrameSize = i;
  }

  private int tryStartCapture(int paramInt1, int paramInt2, int paramInt3, int paramInt4, SurfaceHolder paramSurfaceHolder)
  {
    this.mPreviewBufferIndex.set(-1);
    if (this.camholder == null)
      return -1;
    Camera localCamera = this.camholder.get();
    if (localCamera == null)
      return -1;
    if ((this.isCaptureRunning.get()) && (paramSurfaceHolder == null))
      return 0;
    CaptureCapabilityAndroid localCaptureCapabilityAndroid;
    int i;
    int j;
    label104: int k;
    if (paramSurfaceHolder == null)
    {
      notifyConfigureEventCallback(paramInt1, paramInt2);
      this._ubhandler = Thread.getDefaultUncaughtExceptionHandler();
      Thread.setDefaultUncaughtExceptionHandler(this);
      localCaptureCapabilityAndroid = new CaptureCapabilityAndroid(paramInt1, paramInt2, paramInt3, paramInt4, this.orientation, this.currentDevice.facing, null);
      i = paramInt2;
      j = paramInt1;
      if (307200 == j * i)
        break label352;
      k = 1;
    }
    while (true)
    {
      label118: int m;
      if ((640 != j) || (480 != i))
        m = 1;
      label352: int n;
      while (true)
      {
        try
        {
          localParameters = localCamera.getParameters();
          List localList1 = localParameters.getSupportedPreviewFormats();
          if ((supported_pixfmt_index >= this.pixel_formats.length) || ((u.a(localList1, Integer.valueOf(this.pixel_formats[supported_pixfmt_index]))) && (checkIfColorspaceIsNotBlacklisted(this.pixel_formats[supported_pixfmt_index]))))
          {
            Iterator localIterator = localParameters.getSupportedPreviewSizes().iterator();
            if (!localIterator.hasNext())
              continue;
            ((Camera.Size)localIterator.next());
            continue;
            if ((paramSurfaceHolder.getSurfaceFrame().width() != paramInt1) || (paramSurfaceHolder.getSurfaceFrame().height() != paramInt2))
              try
              {
                if (this.isCaptureRunning.getAndSet(false))
                  localCamera.stopPreview();
                localCamera.setPreviewDisplay(paramSurfaceHolder);
                setCameraBuffers(localCamera, paramInt1, paramInt2);
                SetPreviewRotation(b.b());
                if ((paramInt1 != 0) && (paramInt2 != 0) && (!this.isCaptureRunning.getAndSet(true)))
                  localCamera.startPreview();
                return 0;
              }
              catch (Exception localException1)
              {
                this.isCaptureRunning.set(false);
                localException1.printStackTrace();
                return -1;
              }
            if (!this.isCaptureRunning.get())
              break;
            return 0;
            k = 0;
            break label118;
            m = 0;
            continue;
          }
          supported_pixfmt_index = 1 + supported_pixfmt_index;
          continue;
        }
        catch (RuntimeException localRuntimeException)
        {
          Camera.Parameters localParameters;
          localRuntimeException.printStackTrace();
          if (m != 0)
          {
            n = 640;
            if (m != 0)
              break label777;
            int i1 = 480;
            localCamera.setErrorCallback(this);
            if ((n != this.mCaptureWidth) || (i1 != this.mCaptureHeight))
            {
              this.mCaptureWidth = n;
              this.mCaptureHeight = i1;
            }
            setCameraBuffers(localCamera, n, i1);
            if (USE_LIVE_CAMERA_PREVIEW)
            {
              if (this._previewUpdate.get())
              {
                if ((ViERenderer.getLocalRenderView() instanceof ViEDirectInputSurface))
                  localCamera.setPreviewTexture(((ViEDirectInputSurface)ViERenderer.getLocalRenderView()).getSurfaceTexture());
              }
              else
                SetPreviewRotation(b.b());
            }
            else
            {
              this.currentDevice.device_aspect_ratio = (1.0D * n / i1);
              if (paramSurfaceHolder != null)
                continue;
              return 0;
              if (supported_pixfmt_index >= this.pixel_formats.length)
                supported_pixfmt_index = -1 + this.pixel_formats.length;
              localParameters.setPreviewSize(j, i);
              localParameters.setPreviewFormat(this.pixel_formats[supported_pixfmt_index]);
              localParameters.setPreviewFpsRange(localCaptureCapabilityAndroid.minFPS, localCaptureCapabilityAndroid.maxFPS);
              if (Build.VERSION.SDK_INT >= 14);
              localParameters.setPictureSize(j, i);
              localParameters.set("video-size", "" + j + "x" + i);
              if (Build.VERSION.SDK_INT >= 15);
              List localList2 = localParameters.getSupportedFocusModes();
              if ((localList2 != null) && (localList2.size() > 0) && (u.a(localList2, "continuous-video")))
                localParameters.setFocusMode("continuous-video");
              localCamera.setParameters(localParameters);
              i1 = i;
              n = j;
              continue;
            }
          }
          else
          {
            throw localRuntimeException;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          if (this.mCaptureHeight * this.mCaptureWidth == 307200)
          {
            return -1;
            localCamera.setPreviewDisplay(paramSurfaceHolder);
            continue;
            if (this.isCaptureRunning.getAndSet(true))
              continue;
            localCamera.startPreview();
            notifyStartEventCallback();
            continue;
          }
          j = 640;
          i = 480;
        }
        if (k != 0)
          break label104;
      }
      label777: j = n;
      i = 480;
    }
  }

  public void SetPreviewRotation(int paramInt)
  {
    SetPreviewRotationInternal(paramInt);
  }

  public void SetPreviewRotationInternal(int paramInt)
  {
    if (this.camholder.get() == null)
      return;
    try
    {
      this.previewBufferLock.lock();
      if (VideoCaptureDeviceInfo.FrontFacingCameraType.Android23 == this.currentDevice.frontCameraType);
      for (int i = (360 - (paramInt + this.currentDevice.orientation) % 360) % 360; ; i = (360 + (this.currentDevice.orientation - paramInt)) % 360)
      {
        this.camholder.get().setDisplayOrientation(i);
        return;
      }
    }
    finally
    {
      this.previewBufferLock.unlock();
    }
  }

  public int StartCapture(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return StartCaptureInternal(paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public int StopCapture()
  {
    return StopCaptureInternal();
  }

  public void addEventCallback(VideoCaptureApi.CaptureEventCallback paramCaptureEventCallback)
  {
    synchronized (this.subscribers)
    {
      this.subscribers.add(paramCaptureEventCallback);
      return;
    }
  }

  public boolean deletePreviewSessionForHolder(SurfaceHolder paramSurfaceHolder)
  {
    surfaceDestroyed(paramSurfaceHolder);
    return true;
  }

  protected void finalize()
    throws Throwable
  {
    release();
    super.finalize();
  }

  public VideoCaptureDeviceInfo.FrontFacingCameraType getCaptureCameraFacing()
  {
    return this.currentDevice.frontCameraType;
  }

  public double getDeviceAspectRatio()
  {
    return this.currentDevice.device_aspect_ratio;
  }

  public VideoCaptureDeviceInfo getDeviceInfo()
  {
    return this.deviceInfo;
  }

  public final int getDeviceOrientationFromRotation(int paramInt)
  {
    if ((this.currentDevice.frontCameraType != VideoCaptureDeviceInfo.FrontFacingCameraType.Android23) && ((paramInt == 0) || (paramInt == 180)))
      paramInt = (paramInt + 180) % 360;
    return (paramInt + this.currentDevice.device_rotation_hint) % 360;
  }

  public int getDeviceRotationHint()
  {
    return this.currentDevice.device_rotation_hint;
  }

  public Object getDeviceUniqueName()
  {
    return this.deviceUniqueName;
  }

  public int getFacing()
  {
    if (this.currentDevice != null)
      return this.currentDevice.facing;
    return 0;
  }

  public int getHeight()
  {
    return this.mCaptureHeight;
  }

  public YuvImage getPreviewBufferCopy()
  {
    this.previewBufferLock.lock();
    try
    {
      int i = this.mPreviewBufferIndex.get();
      if ((-1 != i) && (this.mPreviewBuffer != null) && (this.mPreviewBuffer[i] != null) && (this.mCaptureWidth * this.mCaptureHeight * this.bits_per_pixel[supported_pixfmt_index] >> 3 == this.mPreviewBuffer[i].length))
      {
        YuvImage localYuvImage = new YuvImage(this.mPreviewBuffer[i], this.pixel_formats[supported_pixfmt_index], this.mCaptureWidth, this.mCaptureHeight, null);
        return localYuvImage;
      }
      return null;
    }
    finally
    {
      this.previewBufferLock.unlock();
    }
  }

  public float getPreviewRotation()
  {
    if (this.currentDevice != null)
      return this.currentDevice.orientation;
    return 0.0F;
  }

  public int getWidth()
  {
    return this.mCaptureWidth;
  }

  public void lockPreviewUpdate()
  {
    this._previewUpdate.set(false);
  }

  public boolean newPreviewSessionForHolder(SurfaceHolder paramSurfaceHolder)
  {
    surfaceChanged(paramSurfaceHolder, 842094169, paramSurfaceHolder.getSurfaceFrame().width(), paramSurfaceHolder.getSurfaceFrame().height());
    return true;
  }

  public void onError(int paramInt, Camera paramCamera)
  {
  }

  public void onLocalRenderGone(SurfaceHolder paramSurfaceHolder)
  {
    StopCapture();
  }

  public void onLocalSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
    int i = this.mCaptureWidth;
    int j = this.mCaptureHeight;
    int k = this.mCaptureMinFPS;
    int m = this.mCaptureMaxFPS;
    StopCapture();
    StartCapture(i, j, k, m);
  }

  public void onLocalSurfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
  }

  public void onNewRemoteRenderer(int paramInt, SurfaceView paramSurfaceView, SurfaceHolder paramSurfaceHolder)
  {
  }

  public void onPreviewFrame(byte[] paramArrayOfByte, Camera paramCamera)
  {
    if ((paramArrayOfByte == null) || (0L == this.context));
    do
    {
      return;
      if (this.ownsBuffers)
        paramCamera.addCallbackBuffer(paramArrayOfByte);
      this.mPreviewBufferIndex.set(this.mPreviewBufferIndex.incrementAndGet() % 3);
    }
    while ((paramArrayOfByte.length != this.expectedFrameSize) || (!this.isCaptureRunning.get()));
    if (this.currentDevice != null);
    for (int i = this.currentDevice.orientation; ; i = 0)
    {
      System.currentTimeMillis();
      ProvideCameraFrame(paramArrayOfByte, this.expectedFrameSize, this.context, this.pixel_formats[supported_pixfmt_index], i);
      return;
    }
  }

  public void onRegisterCaptureObject()
  {
  }

  public void onRemoteRenderGone(SurfaceHolder paramSurfaceHolder, SurfaceView paramSurfaceView)
  {
  }

  public void onRemoteSurfaceChanged(SurfaceHolder paramSurfaceHolder)
  {
  }

  public void onUnregisterCaptureObject()
  {
  }

  public boolean registerPreviewHolder(SurfaceHolder paramSurfaceHolder)
  {
    boolean bool1 = true;
    if (this.camholder != null);
    while (true)
    {
      try
      {
        if (this.camholder.get() == null)
          return false;
        boolean bool2;
        if ((this._previewUpdate.get()) && (paramSurfaceHolder != null))
        {
          bool2 = bool1;
          if (!bool2)
            break label92;
          notifyConfigureEventCallback(this.mCaptureWidth, this.mCaptureHeight);
          break label92;
          boolean bool3 = this.isCaptureRunning.get();
          if (!bool3)
            return bool1;
        }
        else
        {
          bool2 = false;
          continue;
        }
        bool1 = false;
        continue;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
      }
      return false;
      label92: if (paramSurfaceHolder == null);
    }
  }

  public void release()
  {
    if (this.camholder != null)
      this.camholder.release();
    this.camholder = null;
  }

  public void removeEventCallback(VideoCaptureApi.CaptureEventCallback paramCaptureEventCallback)
  {
    synchronized (this.subscribers)
    {
      this.subscribers.remove(paramCaptureEventCallback);
      return;
    }
  }

  public void surfaceChanged(SurfaceHolder paramSurfaceHolder, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      this.captureLock.lock();
      tryStartCapture(this.mCaptureWidth, this.mCaptureHeight, this.mCaptureMinFPS, this.mCaptureMaxFPS, paramSurfaceHolder);
      return;
    }
    finally
    {
      this.captureLock.unlock();
    }
  }

  public void surfaceCreated(SurfaceHolder paramSurfaceHolder)
  {
  }

  public void surfaceDestroyed(SurfaceHolder paramSurfaceHolder)
  {
    try
    {
      this.previewBufferLock.lock();
      boolean bool = this.isCaptureRunning.get();
      if (!bool)
        return;
      Camera localCamera = this.camholder.get();
      if (localCamera != null);
      try
      {
        localCamera.setPreviewDisplay(null);
        av.a(av.e.a).removeCallbacks(this.problematicCameraCallback);
        return;
      }
      catch (Exception localException2)
      {
        while (true)
          localException2.printStackTrace();
      }
    }
    catch (Exception localException1)
    {
    }
    finally
    {
      this.previewBufferLock.unlock();
    }
  }

  public void uncaughtException(Thread paramThread, Throwable paramThrowable)
  {
    try
    {
      release();
      label4: if (this._ubhandler != null)
        this._ubhandler.uncaughtException(paramThread, paramThrowable);
      return;
    }
    catch (Throwable localThrowable)
    {
      break label4;
    }
  }

  public void unlockPreviewUpdate()
  {
    this._previewUpdate.set(true);
  }

  public boolean unregisterPreviewHolder(SurfaceHolder paramSurfaceHolder)
  {
    if (this.camholder != null)
      try
      {
        Camera localCamera = this.camholder.get();
        if (localCamera == null)
          return false;
        localCamera.stopPreview();
        if ((this._previewUpdate.get()) && (paramSurfaceHolder != null))
          localCamera.setPreviewDisplay(null);
        return true;
      }
      catch (IOException localIOException)
      {
        localIOException.printStackTrace();
      }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.VideoCaptureAndroid
 * JD-Core Version:    0.6.2
 */