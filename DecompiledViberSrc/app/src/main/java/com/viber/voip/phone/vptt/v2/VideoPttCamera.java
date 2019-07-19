package com.viber.voip.phone.vptt.v2;

import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.media.CamcorderProfile;
import android.view.Display;
import android.view.SurfaceHolder;
import android.view.WindowManager;
import com.viber.common.d.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;

public class VideoPttCamera
{
  private static final Logger L = ViberEnv.getLogger();
  private static VideoSize sPreviewSize;
  private static VideoSize sRecordSize;
  private Camera camera;
  private Context context;
  boolean mCameraOn = false;

  public VideoPttCamera(Context paramContext)
  {
    this.context = paramContext;
  }

  private void cameraStart(SurfaceHolder paramSurfaceHolder)
  {
    Camera localCamera = getCameraInstance();
    Camera.Parameters localParameters = localCamera.getParameters();
    disableShutterSound();
    VideoSize localVideoSize = getPreviewSize();
    localParameters.setPreviewSize(localVideoSize.width, localVideoSize.height);
    setContinuousAutoFocus(localParameters);
    localCamera.setParameters(localParameters);
    localCamera.setDisplayOrientation(getCameraDisplayOrientation());
    localParameters.set("orientation", "portrait");
    localParameters.setRotation(getCameraRotation());
    try
    {
      localCamera.setPreviewDisplay(paramSurfaceHolder);
      label74: localCamera.startPreview();
      return;
    }
    catch (Exception localException)
    {
      break label74;
    }
  }

  private void cameraStop()
  {
    if (this.camera == null)
      return;
    this.camera.stopPreview();
    this.camera.lock();
    this.camera.release();
    this.camera = null;
  }

  private void checkInit()
  {
    if ((sPreviewSize == null) || (sRecordSize == null))
      initCamera(getCameraInstance());
  }

  private int getCameraID()
  {
    return getFrontFacingCameraId();
  }

  private Camera getCameraInstance()
  {
    if (this.camera == null)
    {
      this.camera = Camera.open(getCameraID());
      disableShutterSound();
    }
    return this.camera;
  }

  private int getFrontFacingCameraId()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    int i = Camera.getNumberOfCameras();
    for (int j = 0; j < i; j++)
    {
      Camera.getCameraInfo(j, localCameraInfo);
      if (localCameraInfo.facing == 1)
        return j;
    }
    return 0;
  }

  private static Camera.Size getOptimalPreviewSize(List<Camera.Size> paramList, int paramInt1, int paramInt2)
  {
    Object localObject1 = null;
    int i = 2147483647;
    float f1 = paramInt1 / paramInt2;
    if (paramList == null)
      return null;
    Iterator localIterator1 = paramList.iterator();
    int j = i;
    Object localObject5;
    int i2;
    while (localIterator1.hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)localIterator1.next();
      float f2 = localSize2.width / localSize2.height;
      if ((localSize2.width >= paramInt1) && (localSize2.height >= paramInt2) && (Math.abs(f2 - f1) <= 0.1F) && (1.5F * paramInt1 >= localSize2.width) && (1.5F * paramInt2 >= localSize2.height))
      {
        int i1 = localSize2.width - paramInt1 + localSize2.height - paramInt1;
        if (i1 >= j)
          break label363;
        localObject5 = localSize2;
        i2 = i1;
      }
    }
    while (true)
    {
      j = i2;
      localObject1 = localObject5;
      break;
      int k;
      int m;
      if (localObject1 == null)
      {
        Iterator localIterator3 = paramList.iterator();
        k = i;
        while (localIterator3.hasNext())
        {
          Camera.Size localSize1 = (Camera.Size)localIterator3.next();
          if ((localSize1.width >= paramInt1) && (localSize1.height >= paramInt2))
          {
            m = localSize1.width - paramInt1 + localSize1.height - paramInt1;
            if (m >= k)
              break label356;
            localObject1 = localSize1;
          }
        }
      }
      label346: label349: label356: for (int n = m; ; n = k)
      {
        k = n;
        break;
        Object localObject2 = localObject1;
        Object localObject3;
        Object localObject4;
        if (localObject2 == null)
        {
          Iterator localIterator2 = paramList.iterator();
          localObject3 = localObject2;
          if (!localIterator2.hasNext())
            break label346;
          localObject4 = (Camera.Size)localIterator2.next();
          if (Math.abs(((Camera.Size)localObject4).width - paramInt1) >= i)
            break label349;
          i = Math.abs(((Camera.Size)localObject4).width - paramInt1);
        }
        while (true)
        {
          localObject3 = localObject4;
          break;
          localObject3 = localObject2;
          return localObject3;
          localObject4 = localObject3;
        }
      }
      label363: i2 = j;
      localObject5 = localObject1;
    }
  }

  private void initCamera(Camera paramCamera)
  {
    Camera.Parameters localParameters = paramCamera.getParameters();
    List localList = localParameters.getSupportedVideoSizes();
    if (localList == null)
      localList = localParameters.getSupportedPreviewSizes();
    initRecordSize(localList);
    initPreviewSize(localParameters, sRecordSize);
  }

  private void initPreviewSize(Camera.Parameters paramParameters, VideoSize paramVideoSize)
  {
    List localList = paramParameters.getSupportedPreviewSizes();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      Camera.Size localSize2 = (Camera.Size)localIterator.next();
      if ((localSize2.width == paramVideoSize.width) && (localSize2.height == paramVideoSize.height))
      {
        sPreviewSize = new VideoSize(localSize2.width, localSize2.height);
        return;
      }
    }
    Camera.Size localSize1 = getOptimalPreviewSize(localList, 600, 600);
    sPreviewSize = new VideoSize(localSize1.width, localSize1.height);
  }

  private void initRecordSize(List<Camera.Size> paramList)
  {
    Camera.Size localSize = getOptimalPreviewSize(paramList, 600, 600);
    sRecordSize = new VideoSize(localSize.width, localSize.height);
  }

  public void destroy()
  {
    try
    {
      if (this.camera != null)
      {
        Camera localCamera = this.camera;
        if (localCamera != null)
          break label21;
      }
      while (true)
      {
        return;
        label21: this.camera.release();
        this.camera = null;
      }
    }
    finally
    {
    }
  }

  public void disableShutterSound()
  {
    if (a.b());
    try
    {
      this.camera.enableShutterSound(false);
      return;
    }
    catch (Throwable localThrowable)
    {
    }
  }

  public Camera getCamera()
  {
    return this.camera;
  }

  public int getCameraDisplayOrientation()
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    Camera.getCameraInfo(getCameraID(), localCameraInfo);
    int i;
    switch (((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getRotation())
    {
    default:
      i = 0;
    case 0:
    case 1:
    case 2:
    case 3:
    }
    while (localCameraInfo.facing == 1)
    {
      return (360 - (i + localCameraInfo.orientation) % 360) % 360;
      i = 0;
      continue;
      i = 90;
      continue;
      i = 180;
      continue;
      i = 270;
    }
    return (360 + (localCameraInfo.orientation - i)) % 360;
  }

  public int getCameraRotation()
  {
    try
    {
      switch (((WindowManager)this.context.getSystemService("window")).getDefaultDisplay().getRotation())
      {
      default:
      case 0:
      case 1:
      case 2:
      case 3:
      }
      while (true)
      {
        Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
        if (getCameraID() == 0)
          Camera.getCameraInfo(0, localCameraInfo);
        int j;
        while (true)
        {
          j = localCameraInfo.orientation;
          if (localCameraInfo.facing != 1)
            break;
          return (i + (j + 360)) % 360;
          Camera.getCameraInfo(1, localCameraInfo);
        }
        int k = (j + 360 - i) % 360;
        return k;
        int i = 0;
        continue;
        i = 0;
        continue;
        i = 90;
        continue;
        i = 180;
        continue;
        i = 270;
      }
    }
    catch (Exception localException)
    {
    }
    return 0;
  }

  public int getLowVideoFramerate()
  {
    int i = getCameraID();
    if (CamcorderProfile.hasProfile(i, 0))
      return CamcorderProfile.get(i, 0).videoFrameRate;
    return 24;
  }

  public VideoSize getPreviewOrientationNormalizedSize()
  {
    checkInit();
    int i = getCameraDisplayOrientation();
    if ((90 == i) || (270 == i))
      return new VideoSize(sPreviewSize.height, sPreviewSize.width);
    return new VideoSize(sPreviewSize.width, sPreviewSize.height);
  }

  public VideoSize getPreviewSize()
  {
    checkInit();
    return sPreviewSize;
  }

  public VideoSize getRecordSize()
  {
    checkInit();
    return sRecordSize;
  }

  public void lock()
  {
    if (this.camera != null)
      this.camera.lock();
  }

  public void reconnect()
  {
    if (this.camera != null);
    try
    {
      this.camera.reconnect();
      return;
    }
    catch (IOException localIOException)
    {
    }
  }

  public void recreate()
  {
    destroy();
    this.camera = getCameraInstance();
  }

  boolean setContinuousAutoFocus(Camera.Parameters paramParameters)
  {
    List localList = paramParameters.getSupportedFocusModes();
    String str;
    if (localList.contains("continuous-picture"))
      str = "continuous-picture";
    while (!str.equals(""))
    {
      paramParameters.setFocusMode(str);
      return true;
      if (localList.contains("continuous-video"))
        str = "continuous-video";
      else
        str = "";
    }
    return false;
  }

  public void start(SurfaceHolder paramSurfaceHolder)
  {
    if (!this.mCameraOn)
    {
      this.mCameraOn = true;
      cameraStart(paramSurfaceHolder);
    }
  }

  public void stop()
  {
    if (this.mCameraOn)
    {
      this.mCameraOn = false;
      cameraStop();
    }
  }

  public void unlock()
  {
    if (this.camera != null)
      this.camera.unlock();
  }

  public static class VideoSize
  {
    public final int height;
    public final int width;

    public VideoSize(int paramInt1, int paramInt2)
    {
      this.width = paramInt1;
      this.height = paramInt2;
    }

    public String toString()
    {
      return "VideoSize{width=" + this.width + ", height=" + this.height + '}';
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.phone.vptt.v2.VideoPttCamera
 * JD-Core Version:    0.6.2
 */