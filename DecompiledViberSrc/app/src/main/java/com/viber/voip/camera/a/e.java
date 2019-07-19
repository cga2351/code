package com.viber.voip.camera.a;

import android.annotation.TargetApi;
import android.hardware.Camera;
import android.hardware.Camera.Area;
import android.hardware.Camera.AutoFocusCallback;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.ErrorCallback;
import android.hardware.Camera.Face;
import android.hardware.Camera.FaceDetectionListener;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.PictureCallback;
import android.hardware.Camera.ShutterCallback;
import android.hardware.Camera.Size;
import android.media.MediaRecorder;
import android.os.Build.VERSION;
import android.os.Handler;
import android.view.SurfaceHolder;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

public class e extends a
{
  private static final String c = com.viber.voip.camera.e.a.a(e.class);
  private Camera d = null;
  private int e = 0;
  private Camera.CameraInfo f = new Camera.CameraInfo();
  private String g = null;

  public e(int paramInt)
    throws b
  {
    super(paramInt);
    try
    {
      this.d = Camera.open(paramInt);
      if (this.d == null)
        throw new b();
    }
    catch (RuntimeException localRuntimeException1)
    {
      throw new b();
    }
    try
    {
      Camera.getCameraInfo(paramInt, this.f);
      this.d.setErrorCallback(new Camera.ErrorCallback()
      {
        public void onError(int paramAnonymousInt, Camera paramAnonymousCamera)
        {
        }
      });
      return;
    }
    catch (RuntimeException localRuntimeException2)
    {
      a();
    }
    throw new b();
  }

  private Camera.Parameters F()
  {
    return this.d.getParameters();
  }

  private void a(Camera.Parameters paramParameters)
  {
    try
    {
      this.d.setParameters(paramParameters);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      this.b = (1 + this.b);
    }
  }

  private List<String> b(List<String> paramList)
  {
    Vector localVector = new Vector();
    if (paramList != null)
    {
      if (paramList.contains("off"))
        localVector.add("flash_off");
      if (paramList.contains("auto"))
        localVector.add("flash_auto");
      if (paramList.contains("on"))
        localVector.add("flash_on");
      if (paramList.contains("torch"))
        localVector.add("flash_torch");
      if (paramList.contains("red-eye"))
        localVector.add("flash_red_eye");
    }
    return localVector;
  }

  private List<String> c(List<String> paramList)
  {
    Vector localVector = new Vector();
    if (paramList != null)
    {
      if (paramList.contains("auto"))
        localVector.add("focus_mode_auto");
      if (paramList.contains("infinity"))
        localVector.add("focus_mode_infinity");
      if (paramList.contains("macro"))
        localVector.add("focus_mode_macro");
      if (paramList.contains("auto"))
        localVector.add("focus_mode_locked");
      if (paramList.contains("fixed"))
        localVector.add("focus_mode_fixed");
      if (paramList.contains("edof"))
        localVector.add("focus_mode_edof");
      if (paramList.contains("continuous-video"))
        localVector.add("focus_mode_continuous_video");
    }
    return localVector;
  }

  private String g(String paramString)
  {
    String str = "";
    if (paramString.equals("flash_off"))
      str = "off";
    do
    {
      return str;
      if (paramString.equals("flash_auto"))
        return "auto";
      if (paramString.equals("flash_on"))
        return "on";
      if (paramString.equals("flash_torch"))
        return "torch";
    }
    while (!paramString.equals("flash_red_eye"));
    return "red-eye";
  }

  private String h(String paramString)
  {
    if (paramString == null);
    do
    {
      return "";
      if (paramString.equals("off"))
        return "flash_off";
      if (paramString.equals("auto"))
        return "flash_auto";
      if (paramString.equals("on"))
        return "flash_on";
      if (paramString.equals("torch"))
        return "flash_torch";
    }
    while (!paramString.equals("red-eye"));
    return "flash_red_eye";
  }

  public int A()
  {
    return this.e;
  }

  public int B()
  {
    return this.f.orientation;
  }

  public boolean C()
  {
    return this.f.facing == 1;
  }

  public void D()
  {
    x();
    this.d.unlock();
  }

  public String E()
  {
    try
    {
      String str = F().flatten();
      return str;
    }
    catch (Exception localException)
    {
    }
    return "";
  }

  public a.i a(String paramString)
  {
    String str = m();
    Camera.Parameters localParameters = F();
    a.i locali = a(localParameters.getSupportedSceneModes(), paramString, str);
    if ((locali != null) && (!localParameters.getSceneMode().equals(locali.b)))
    {
      localParameters.setSceneMode(locali.b);
      a(localParameters);
    }
    return locali;
  }

  public void a()
  {
    this.d.release();
    this.d = null;
  }

  public void a(int paramInt1, int paramInt2)
  {
    Camera.Parameters localParameters = F();
    localParameters.setPictureSize(paramInt1, paramInt2);
    a(localParameters);
  }

  public void a(MediaRecorder paramMediaRecorder)
  {
    paramMediaRecorder.setCamera(this.d);
  }

  public void a(SurfaceHolder paramSurfaceHolder)
    throws b
  {
    try
    {
      this.d.setPreviewDisplay(paramSurfaceHolder);
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new b();
  }

  public void a(final a.b paramb)
  {
    Camera.AutoFocusCallback local3 = new Camera.AutoFocusCallback()
    {
      public void onAutoFocus(boolean paramAnonymousBoolean, Camera paramAnonymousCamera)
      {
        paramb.a(paramAnonymousBoolean);
      }
    };
    try
    {
      this.d.autoFocus(local3);
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
      paramb.a(false);
    }
  }

  public void a(final a.f paramf)
  {
    this.d.setFaceDetectionListener(new a(paramf));
  }

  @TargetApi(15)
  public void a(boolean paramBoolean)
  {
    Camera.Parameters localParameters = F();
    localParameters.setVideoStabilization(paramBoolean);
    a(localParameters);
  }

  public void a(boolean paramBoolean, final a.g paramg1, final a.g paramg2, a.d paramd)
  {
    Camera.ShutterCallback local41 = new Camera.ShutterCallback()
    {
      public void onShutter()
      {
      }
    };
    Object localObject1;
    if (paramg1 == null)
      localObject1 = null;
    while (true)
    {
      Object localObject2;
      if (paramg2 == null)
        localObject2 = null;
      try
      {
        while (true)
        {
          Camera localCamera = this.d;
          Camera.ShutterCallback local42 = null;
          if (paramBoolean)
            local42 = local41;
          localCamera.takePicture(local42, (Camera.PictureCallback)localObject1, (Camera.PictureCallback)localObject2);
          return;
          localObject1 = new Camera.PictureCallback()
          {
            public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
            {
              paramg1.a(paramAnonymousArrayOfByte);
            }
          };
          break;
          localObject2 = new Camera.PictureCallback()
          {
            public void onPictureTaken(byte[] paramAnonymousArrayOfByte, Camera paramAnonymousCamera)
            {
              paramg2.a(paramAnonymousArrayOfByte);
            }
          };
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        paramd.a();
      }
    }
  }

  public boolean a(float paramFloat)
  {
    return false;
  }

  public boolean a(int paramInt)
  {
    return false;
  }

  public boolean a(long paramLong)
  {
    return false;
  }

  public boolean a(List<a.a> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      a.a locala = (a.a)localIterator.next();
      localArrayList.add(new Camera.Area(locala.a, locala.b));
    }
    Camera.Parameters localParameters = F();
    String str = localParameters.getFocusMode();
    if ((localParameters.getMaxNumFocusAreas() != 0) && (str != null) && ((str.equals("auto")) || (str.equals("macro")) || (str.equals("continuous-picture")) || (str.equals("continuous-video"))))
    {
      localParameters.setFocusAreas(localArrayList);
      if (localParameters.getMaxNumMeteringAreas() == 0);
      while (true)
      {
        a(localParameters);
        return true;
        localParameters.setMeteringAreas(localArrayList);
      }
    }
    if (localParameters.getMaxNumMeteringAreas() != 0)
    {
      localParameters.setMeteringAreas(localArrayList);
      a(localParameters);
    }
    return false;
  }

  public a.i b(String paramString)
  {
    String str = n();
    Camera.Parameters localParameters = F();
    a.i locali = a(localParameters.getSupportedColorEffects(), paramString, str);
    if ((locali != null) && (!localParameters.getColorEffect().equals(locali.b)))
    {
      localParameters.setColorEffect(locali.b);
      a(localParameters);
    }
    return locali;
  }

  public String b()
  {
    return "Camera";
  }

  public void b(int paramInt)
  {
    Camera.Parameters localParameters = F();
    localParameters.setJpegQuality(paramInt);
    a(localParameters);
  }

  public void b(int paramInt1, int paramInt2)
  {
    Camera.Parameters localParameters = F();
    localParameters.setPreviewSize(paramInt1, paramInt2);
    a(localParameters);
  }

  public void b(MediaRecorder paramMediaRecorder)
    throws b
  {
  }

  public void b(boolean paramBoolean)
  {
    Camera.Parameters localParameters = F();
    String str = localParameters.getFocusMode();
    if ((str != null) && (!str.equals("continuous-video")))
    {
      localParameters.setRecordingHint(paramBoolean);
      a(localParameters);
    }
  }

  @TargetApi(17)
  public a.c c()
  {
    Camera.Parameters localParameters = F();
    a.c localc = new a.c();
    localc.a = localParameters.isZoomSupported();
    if (localc.a)
      localc.b = localParameters.getMaxZoom();
    try
    {
      localc.c = localParameters.getZoomRatios();
      if (localParameters.getMaxNumDetectedFaces() > 0)
      {
        bool = true;
        localc.d = bool;
        List localList1 = localParameters.getSupportedPictureSizes();
        localc.e = new ArrayList();
        Iterator localIterator1 = localList1.iterator();
        while (localIterator1.hasNext())
        {
          Camera.Size localSize3 = (Camera.Size)localIterator1.next();
          localc.e.add(new a.h(localSize3.width, localSize3.height));
        }
      }
    }
    catch (NumberFormatException localNumberFormatException)
    {
      while (true)
      {
        localc.a = false;
        localc.b = 0;
        localc.c = null;
        continue;
        boolean bool = false;
      }
      localc.h = b(localParameters.getSupportedFlashModes());
      localc.i = c(localParameters.getSupportedFocusModes());
      localc.j = localParameters.getMaxNumFocusAreas();
      localc.l = localParameters.isAutoExposureLockSupported();
      localc.m = localParameters.isVideoStabilizationSupported();
      localc.t = localParameters.getMinExposureCompensation();
      localc.u = localParameters.getMaxExposureCompensation();
      try
      {
        localc.v = localParameters.getExposureCompensationStep();
        List localList2 = localParameters.getSupportedVideoSizes();
        if (localList2 == null)
          localList2 = localParameters.getSupportedPreviewSizes();
        localc.f = new ArrayList();
        Iterator localIterator2 = localList2.iterator();
        while (localIterator2.hasNext())
        {
          Camera.Size localSize2 = (Camera.Size)localIterator2.next();
          localc.f.add(new a.h(localSize2.width, localSize2.height));
        }
      }
      catch (Exception localException)
      {
        while (true)
          localc.v = 0.3333333F;
        List localList3 = localParameters.getSupportedPreviewSizes();
        localc.g = new ArrayList();
        Iterator localIterator3 = localList3.iterator();
        while (localIterator3.hasNext())
        {
          Camera.Size localSize1 = (Camera.Size)localIterator3.next();
          localc.g.add(new a.h(localSize1.width, localSize1.height));
        }
        if (Build.VERSION.SDK_INT >= 17)
        {
          localc.w = this.f.canDisableShutterSound;
          return localc;
        }
        localc.w = false;
      }
    }
    return localc;
  }

  public a.i c(String paramString)
  {
    String str = o();
    Camera.Parameters localParameters = F();
    a.i locali = a(localParameters.getSupportedWhiteBalance(), paramString, str);
    if ((locali != null) && (!localParameters.getWhiteBalance().equals(locali.b)))
    {
      localParameters.setWhiteBalance(locali.b);
      a(localParameters);
    }
    return locali;
  }

  public void c(int paramInt)
  {
    Camera.Parameters localParameters = F();
    localParameters.setZoom(paramInt);
    a(localParameters);
  }

  public void c(int paramInt1, int paramInt2)
  {
    Camera.Parameters localParameters = F();
    localParameters.setPreviewFpsRange(paramInt1, paramInt2);
    a(localParameters);
  }

  @TargetApi(17)
  public void c(boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 17)
      this.d.enableShutterSound(paramBoolean);
  }

  public a.i d(String paramString)
  {
    String str1 = p();
    Camera.Parameters localParameters = F();
    String str2 = localParameters.get("iso-values");
    if (str2 == null)
    {
      str2 = localParameters.get("iso-mode-values");
      if (str2 == null)
      {
        str2 = localParameters.get("iso-speed-values");
        if (str2 == null)
          str2 = localParameters.get("nv-picture-iso-values");
      }
    }
    ArrayList localArrayList2;
    if ((str2 != null) && (str2.length() > 0))
    {
      String[] arrayOfString = str2.split(",");
      if ((arrayOfString != null) && (arrayOfString.length > 0))
      {
        localArrayList2 = new ArrayList();
        for (int i = 0; i < arrayOfString.length; i++)
          localArrayList2.add(arrayOfString[i]);
      }
    }
    for (ArrayList localArrayList1 = localArrayList2; ; localArrayList1 = null)
    {
      this.g = "iso";
      if (localParameters.get(this.g) == null)
      {
        this.g = "iso-speed";
        if (localParameters.get(this.g) == null)
        {
          this.g = "nv-picture-iso";
          if (localParameters.get(this.g) == null)
            this.g = null;
        }
      }
      String str3 = this.g;
      a.i locali = null;
      if (str3 != null)
      {
        if (localArrayList1 == null)
        {
          localArrayList1 = new ArrayList();
          localArrayList1.add("auto");
          localArrayList1.add("100");
          localArrayList1.add("200");
          localArrayList1.add("400");
          localArrayList1.add("800");
          localArrayList1.add("1600");
        }
        locali = a(localArrayList1, paramString, str1);
        if (locali != null)
        {
          localParameters.set(this.g, locali.b);
          a(localParameters);
        }
      }
      return locali;
    }
  }

  public boolean d(int paramInt)
  {
    Camera.Parameters localParameters = F();
    if (paramInt != localParameters.getExposureCompensation())
    {
      localParameters.setExposureCompensation(paramInt);
      a(localParameters);
      return true;
    }
    return false;
  }

  public String e()
  {
    return F().getSceneMode();
  }

  public void e(int paramInt)
  {
    Camera.Parameters localParameters = F();
    localParameters.setRotation(paramInt);
    a(localParameters);
  }

  public void e(String paramString)
  {
    Camera.Parameters localParameters = F();
    if ((paramString.equals("focus_mode_auto")) || (paramString.equals("focus_mode_locked")))
      localParameters.setFocusMode("auto");
    while (true)
    {
      a(localParameters);
      return;
      if (paramString.equals("focus_mode_infinity"))
        localParameters.setFocusMode("infinity");
      else if (paramString.equals("focus_mode_macro"))
        localParameters.setFocusMode("macro");
      else if (paramString.equals("focus_mode_fixed"))
        localParameters.setFocusMode("fixed");
      else if (paramString.equals("focus_mode_edof"))
        localParameters.setFocusMode("edof");
      else if (paramString.equals("focus_mode_continuous_video"))
        localParameters.setFocusMode("continuous-video");
    }
  }

  public String f()
  {
    return this.g;
  }

  public void f(int paramInt)
  {
    if (this.f.facing == 1);
    for (int i = (360 - (paramInt + this.f.orientation) % 360) % 360; ; i = (360 + (this.f.orientation - paramInt)) % 360)
    {
      this.d.setDisplayOrientation(i);
      this.e = i;
      return;
    }
  }

  public void f(String paramString)
  {
    Camera.Parameters localParameters = F();
    if (localParameters.getFlashMode() == null);
    final String str;
    do
    {
      return;
      str = g(paramString);
    }
    while ((str.length() <= 0) || (str.equals(localParameters.getFlashMode())));
    if ((localParameters.getFlashMode().equals("torch")) && (!str.equals("off")))
    {
      localParameters.setFlashMode("off");
      a(localParameters);
      new Handler().postDelayed(new Runnable()
      {
        public void run()
        {
          if (e.a(e.this) != null)
          {
            Camera.Parameters localParameters = e.b(e.this);
            localParameters.setFlashMode(str);
            e.a(e.this, localParameters);
          }
        }
      }
      , 100L);
      return;
    }
    localParameters.setFlashMode(str);
    a(localParameters);
  }

  public int g()
  {
    return 0;
  }

  public long h()
  {
    return 0L;
  }

  public a.h i()
  {
    Camera.Size localSize = F().getPictureSize();
    return new a.h(localSize.width, localSize.height);
  }

  public int j()
  {
    return F().getZoom();
  }

  public int k()
  {
    return F().getExposureCompensation();
  }

  public List<int[]> l()
  {
    Camera.Parameters localParameters = F();
    try
    {
      List localList = localParameters.getSupportedPreviewFpsRange();
      return localList;
    }
    catch (StringIndexOutOfBoundsException localStringIndexOutOfBoundsException)
    {
    }
    return null;
  }

  public float q()
  {
    return 0.0F;
  }

  public String r()
  {
    return h(F().getFlashMode());
  }

  public void s()
  {
    int i = 1;
    Camera.Parameters localParameters = F();
    int j = localParameters.getMaxNumFocusAreas();
    int k = 0;
    if (j > 0)
    {
      localParameters.setFocusAreas(null);
      k = i;
    }
    if (localParameters.getMaxNumMeteringAreas() > 0)
      localParameters.setMeteringAreas(null);
    while (true)
    {
      if (i != 0)
        a(localParameters);
      return;
      i = k;
    }
  }

  public boolean t()
  {
    String str = F().getFocusMode();
    return (str != null) && ((str.equals("auto")) || (str.equals("macro")));
  }

  public boolean u()
  {
    String str = F().getFocusMode();
    return (str != null) && (str.equals("continuous-video"));
  }

  public void v()
    throws b
  {
    try
    {
      this.d.reconnect();
      return;
    }
    catch (IOException localIOException)
    {
    }
    throw new b();
  }

  public void w()
    throws b
  {
    try
    {
      this.d.startPreview();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    throw new b();
  }

  public void x()
  {
    this.d.stopPreview();
  }

  public boolean y()
  {
    try
    {
      this.d.startFaceDetection();
      return true;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
    return false;
  }

  public void z()
  {
    try
    {
      this.d.cancelAutoFocus();
      return;
    }
    catch (RuntimeException localRuntimeException)
    {
    }
  }

  class a
    implements Camera.FaceDetectionListener
  {
    public void onFaceDetection(Camera.Face[] paramArrayOfFace, Camera paramCamera)
    {
      a.e[] arrayOfe = new a.e[paramArrayOfFace.length];
      for (int i = 0; i < paramArrayOfFace.length; i++)
        arrayOfe[i] = new a.e(paramArrayOfFace[i].score, paramArrayOfFace[i].rect);
      paramf.a(arrayOfe);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.a.e
 * JD-Core Version:    0.6.2
 */