package org.webrtc.videoengine;

import android.app.Application;
import android.content.Context;
import android.hardware.Camera;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.Build;
import com.viber.common.b.h;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.settings.d.m;
import com.viber.voip.util.da;
import com.viber.voip.util.u;
import com.viber.voip.util.u.b;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VideoCaptureDeviceInfoAndroid extends VideoCaptureDeviceInfo
{
  private static final String INITIAL_CAMERA_CONFIG_PATH = "camera/initial_config.json";
  private static final Logger L = ViberEnv.getLogger();
  static final AtomicReference<List<AndroidVideoCaptureDevice>> deviceList = new AtomicReference();
  Context context;
  int id;

  VideoCaptureDeviceInfoAndroid(int paramInt, Context paramContext)
  {
    this.id = paramInt;
    this.context = paramContext;
    deviceList.compareAndSet(null, new ArrayList());
  }

  private void AddDeviceInfo(AndroidVideoCaptureDevice paramAndroidVideoCaptureDevice, Camera.Parameters paramParameters)
  {
    List localList1 = paramParameters.getSupportedPreviewSizes();
    List localList2 = paramParameters.getSupportedPreviewFpsRange();
    int m;
    int n;
    int i2;
    int i3;
    int i;
    if (localList2 != null)
    {
      Iterator localIterator = localList2.iterator();
      m = 100;
      for (n = 15000; localIterator.hasNext(); n = i2)
      {
        int[] arrayOfInt = (int[])localIterator.next();
        if ((arrayOfInt[1] <= n) && ((arrayOfInt[1] != n) || (arrayOfInt[1] - arrayOfInt[0] <= n - m)))
          break label286;
        int i1 = arrayOfInt[0];
        i2 = arrayOfInt[1];
        i3 = i1;
        m = i3;
      }
      i = n;
    }
    for (int j = m; ; j = 100)
    {
      ArrayList localArrayList = new ArrayList(localList1.size());
      int k = 0;
      if (k < localList1.size())
      {
        Camera.Size localSize = (Camera.Size)localList1.get(k);
        double d = 1.0D * localSize.width / localSize.height;
        if ((d != 1.333333333333333D) && (d != 1.777777777777778D) && (d != 1.6D));
        while (true)
        {
          k++;
          break;
          if (localSize.width != localSize.height)
            localArrayList.add(new CaptureCapabilityAndroid(localSize.width, localSize.height, j, i, paramAndroidVideoCaptureDevice.orientation));
        }
      }
      paramAndroidVideoCaptureDevice.captureCapabilies = ((CaptureCapabilityAndroid[])localArrayList.toArray(new CaptureCapabilityAndroid[localArrayList.size()]));
      return;
      label286: i2 = n;
      i3 = m;
      break;
      i = 15000;
    }
  }

  private void AddDeviceSpecificCapability(CaptureCapabilityAndroid paramCaptureCapabilityAndroid)
  {
    while (true)
    {
      int j;
      synchronized (deviceList)
      {
        ArrayList localArrayList = new ArrayList((Collection)deviceList.get());
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext())
          break label175;
        AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = (AndroidVideoCaptureDevice)localIterator.next();
        CaptureCapabilityAndroid[] arrayOfCaptureCapabilityAndroid1 = localAndroidVideoCaptureDevice.captureCapabilies;
        int i = arrayOfCaptureCapabilityAndroid1.length;
        j = 0;
        if (j >= i)
          break label176;
        CaptureCapabilityAndroid localCaptureCapabilityAndroid = arrayOfCaptureCapabilityAndroid1[j];
        if ((localCaptureCapabilityAndroid.width == paramCaptureCapabilityAndroid.width) && (localCaptureCapabilityAndroid.height == paramCaptureCapabilityAndroid.height))
        {
          k = 1;
          if (k != 0)
            continue;
          CaptureCapabilityAndroid[] arrayOfCaptureCapabilityAndroid2 = new CaptureCapabilityAndroid[1 + localAndroidVideoCaptureDevice.captureCapabilies.length];
          System.arraycopy(localAndroidVideoCaptureDevice.captureCapabilies, 0, arrayOfCaptureCapabilityAndroid2, 1, localAndroidVideoCaptureDevice.captureCapabilies.length);
          arrayOfCaptureCapabilityAndroid2[0] = paramCaptureCapabilityAndroid;
          localAndroidVideoCaptureDevice.captureCapabilies = arrayOfCaptureCapabilityAndroid2;
        }
      }
      j++;
      continue;
      label175: return;
      label176: int k = 0;
    }
  }

  static Camera AllocateEVOFrontFacingCamera()
    throws SecurityException, NoSuchMethodException, ClassNotFoundException, IllegalArgumentException, IllegalAccessException, InvocationTargetException
  {
    File localFile1 = new File("/system/framework/com.htc.hardware.twinCamDevice.jar");
    String str1 = "com.htc.hardware.twinCamDevice.FrontFacingCamera";
    boolean bool = localFile1.exists();
    if (!bool)
    {
      localFile1 = new File("/system/framework/com.sprint.hardware.twinCamDevice.jar");
      str1 = "com.sprint.hardware.twinCamDevice.FrontFacingCamera";
      bool = localFile1.exists();
    }
    if (!bool)
      return null;
    String str2 = ViberApplication.getApplication().getFilesDir().getAbsolutePath();
    File localFile2 = new File(str2, "dexfiles");
    if ((!localFile2.exists()) && (!localFile2.mkdirs()));
    String str3 = str2 + "/dexfiles";
    return (Camera)new DexClassLoader(localFile1.getAbsolutePath(), str3, null, ClassLoader.getSystemClassLoader()).loadClass(str1).getDeclaredMethod("getFrontFacingCamera", (Class[])null).invoke((Object[])null, (Object[])null);
  }

  static Camera AllocateGalaxySFrontCamera()
  {
    Camera localCamera = Camera.open();
    Camera.Parameters localParameters = localCamera.getParameters();
    localParameters.set("camera-id", 2);
    localCamera.setParameters(localParameters);
    return localCamera;
  }

  protected static void DeleteCamera(VideoCaptureApi paramVideoCaptureApi)
  {
    if (!(paramVideoCaptureApi instanceof VideoCaptureAndroid))
      return;
    if (paramVideoCaptureApi != null)
    {
      paramVideoCaptureApi.getDeviceInfo().notifyCaptureDeleted((VideoCaptureAndroid)paramVideoCaptureApi);
      paramVideoCaptureApi.StopCapture();
      paramVideoCaptureApi.getDeviceInfo().deregisterCaptureObject(paramVideoCaptureApi);
      paramVideoCaptureApi.release();
    }
    ((VideoCaptureAndroid)paramVideoCaptureApi).context = 0L;
  }

  private Camera.Parameters SearchOldFrontFacingCameras(AndroidVideoCaptureDevice paramAndroidVideoCaptureDevice)
    throws SecurityException, IllegalArgumentException, NoSuchMethodException, ClassNotFoundException, IllegalAccessException, InvocationTargetException
  {
    Camera localCamera1 = Camera.open();
    Camera.Parameters localParameters1 = localCamera1.getParameters();
    String str = localParameters1.get("camera-id");
    if ((str != null) && (str.equals("1")))
      try
      {
        localParameters1.set("camera-id", 2);
        localCamera1.setParameters(localParameters1);
        Camera.Parameters localParameters3 = localCamera1.getParameters();
        paramAndroidVideoCaptureDevice.frontCameraType = VideoCaptureDeviceInfo.FrontFacingCameraType.GalaxyS;
        paramAndroidVideoCaptureDevice.orientation = 0;
        localCamera1.release();
        return localParameters3;
      }
      catch (Exception localException)
      {
      }
    localCamera1.release();
    boolean bool = new File("/system/framework/com.htc.hardware.twinCamDevice.jar").exists();
    if (!bool)
      bool = new File("/system/framework/com.sprint.hardware.twinCamDevice.jar").exists();
    if (bool)
    {
      paramAndroidVideoCaptureDevice.frontCameraType = VideoCaptureDeviceInfo.FrontFacingCameraType.HTCEvo;
      paramAndroidVideoCaptureDevice.orientation = 0;
      Camera localCamera2 = AllocateEVOFrontFacingCamera();
      Camera.Parameters localParameters2 = localCamera2.getParameters();
      localCamera2.release();
      return localParameters2;
    }
    return null;
  }

  private void VerifyCapabilities()
  {
    if (("GT-I9000".equals(Build.DEVICE)) || ("crespo".equals(Build.DEVICE)))
    {
      AddDeviceSpecificCapability(new CaptureCapabilityAndroid(352, 288, 15, 15, 0));
      AddDeviceSpecificCapability(new CaptureCapabilityAndroid(176, 144, 15, 15, 0));
      AddDeviceSpecificCapability(new CaptureCapabilityAndroid(320, 240, 15, 15, 0));
    }
    if ((Build.MANUFACTURER.equals("motorola")) && ("umts_sholes".equals(Build.DEVICE)))
      synchronized (deviceList)
      {
        ArrayList localArrayList2 = new ArrayList((Collection)deviceList.get());
        Iterator localIterator2 = localArrayList2.iterator();
        while (localIterator2.hasNext())
        {
          CaptureCapabilityAndroid[] arrayOfCaptureCapabilityAndroid2 = ((AndroidVideoCaptureDevice)localIterator2.next()).captureCapabilies;
          int k = arrayOfCaptureCapabilityAndroid2.length;
          int m = 0;
          if (m < k)
          {
            arrayOfCaptureCapabilityAndroid2[m].maxFPS = 15;
            m++;
          }
        }
      }
    if (("intel".equals(Build.MANUFACTURER)) && ("noonhill".equals(Build.DEVICE)))
    {
      ArrayList localArrayList1 = new ArrayList();
      Iterator localIterator1 = ((List)deviceList.get()).iterator();
      while (localIterator1.hasNext())
      {
        AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = (AndroidVideoCaptureDevice)localIterator1.next();
        for (CaptureCapabilityAndroid localCaptureCapabilityAndroid : localAndroidVideoCaptureDevice.captureCapabilies)
          if ((320 >= localCaptureCapabilityAndroid.width) || (240 >= localCaptureCapabilityAndroid.height))
            localArrayList1.add(localCaptureCapabilityAndroid);
        localAndroidVideoCaptureDevice.captureCapabilies = ((CaptureCapabilityAndroid[])localArrayList1.toArray(new CaptureCapabilityAndroid[localArrayList1.size()]));
      }
    }
  }

  public static int getCaptureDeviceIndex(VideoCaptureApi paramVideoCaptureApi, List<AndroidVideoCaptureDevice> paramList)
  {
    Iterator localIterator = paramList.iterator();
    int i = 0;
    while (localIterator.hasNext())
    {
      AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = (AndroidVideoCaptureDevice)localIterator.next();
      i++;
      if ((localAndroidVideoCaptureDevice.deviceUniqueName != null) && (localAndroidVideoCaptureDevice.deviceUniqueName.equals(paramVideoCaptureApi.getDeviceUniqueName())))
        return i - 1;
    }
    return -1;
  }

  public static final List<AndroidVideoCaptureDevice> getDevicesList()
  {
    if (deviceList.get() == null)
      return null;
    synchronized (deviceList)
    {
      List localList = Collections.unmodifiableList(new ArrayList((Collection)deviceList.get()));
      return localList;
    }
  }

  private boolean loadFromJson(String paramString)
  {
    if (!da.a(paramString))
      try
      {
        JSONArray localJSONArray = new JSONObject(paramString).getJSONArray(d.m.m.c());
        int i = 0;
        while (i < localJSONArray.length())
          synchronized (deviceList)
          {
            ((List)deviceList.get()).add(AndroidVideoCaptureDevice.fromJson(localJSONArray.getJSONObject(i)));
            i++;
          }
      }
      catch (Exception localException)
      {
      }
    return (deviceList.get() != null) && (((List)deviceList.get()).size() > 0);
  }

  private Camera openCamera(final int paramInt)
  {
    final Object localObject1 = new Object();
    final AtomicReference localAtomicReference = new AtomicReference(null);
    final AtomicBoolean localAtomicBoolean = new AtomicBoolean();
    new Thread(new Runnable()
    {
      public void run()
      {
        Object localObject1 = localObject1;
        try
        {
          localCamera = Camera.open(paramInt);
          if ((localAtomicBoolean.get()) && (localCamera != null))
            localCamera.release();
        }
        catch (Throwable localThrowable)
        {
        }
        finally
        {
          Camera localCamera;
          localObject1.notifyAll();
        }
      }
    }).start();
    try
    {
      localObject1.wait(3000L);
      if (localAtomicReference.get() == null)
        localAtomicBoolean.set(true);
      Camera localCamera = (Camera)localAtomicReference.get();
      return localCamera;
    }
    catch (InterruptedException localInterruptedException)
    {
      localAtomicBoolean.set(true);
      return null;
    }
    finally
    {
    }
  }

  public static void removeSavedJson()
  {
    d.m.m.e();
  }

  private void saveToJson()
  {
    if ((deviceList.get() == null) || (((List)deviceList.get()).size() == 0))
      return;
    JSONObject localJSONObject;
    JSONArray localJSONArray;
    synchronized (deviceList)
    {
      ArrayList localArrayList = new ArrayList((Collection)deviceList.get());
      try
      {
        localJSONObject = new JSONObject();
        localJSONArray = new JSONArray();
        Iterator localIterator = localArrayList.iterator();
        while (localIterator.hasNext())
          localJSONArray.put(((AndroidVideoCaptureDevice)localIterator.next()).toJson());
      }
      catch (Exception localException)
      {
        return;
      }
    }
    localJSONObject.put(d.m.m.c(), localJSONArray);
    String str = localJSONObject.toString();
    d.m.m.a(str);
  }

  @ViENative
  public VideoCaptureApi AllocateCamera(int paramInt, long paramLong, String paramString)
  {
    try
    {
      AutoReleaseCamHolder localAutoReleaseCamHolder = VideoCaptureAndroid.AllocateCamera(paramInt, paramLong, paramString);
      if (localAutoReleaseCamHolder == null)
        return null;
      VideoCaptureAndroid localVideoCaptureAndroid = new VideoCaptureAndroid(this, paramInt, paramLong, localAutoReleaseCamHolder);
      localVideoCaptureAndroid.getDeviceInfo().registerCaptureObject(localVideoCaptureAndroid);
      notifyCaptureAllocated(localVideoCaptureAndroid);
      return localVideoCaptureAndroid;
    }
    catch (Exception localException)
    {
    }
    return null;
  }

  public List<String> DeviceNames()
  {
    return u.a(getDevicesList(), new u.b()
    {
      public String transform(VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice paramAnonymousAndroidVideoCaptureDevice)
      {
        return paramAnonymousAndroidVideoCaptureDevice.deviceUniqueName;
      }
    });
  }

  public CaptureCapabilityAndroid[] GetCapabilityArray(String paramString)
  {
    synchronized (deviceList)
    {
      ArrayList localArrayList = new ArrayList((Collection)deviceList.get());
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = (AndroidVideoCaptureDevice)localIterator.next();
        if (localAndroidVideoCaptureDevice.deviceUniqueName.equals(paramString))
          return (CaptureCapabilityAndroid[])localAndroidVideoCaptureDevice.captureCapabilies;
      }
    }
    return null;
  }

  public String GetDeviceUniqueName(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= NumberOfDevices()))
      return null;
    synchronized (deviceList)
    {
      String str = ((AndroidVideoCaptureDevice)((List)deviceList.get()).get(paramInt)).deviceUniqueName;
      return str;
    }
  }

  public int GetOrientation(String paramString)
  {
    synchronized (deviceList)
    {
      ArrayList localArrayList = new ArrayList((Collection)deviceList.get());
      Iterator localIterator = localArrayList.iterator();
      while (localIterator.hasNext())
      {
        AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = (AndroidVideoCaptureDevice)localIterator.next();
        if (localAndroidVideoCaptureDevice.deviceUniqueName.equals(paramString))
          return localAndroidVideoCaptureDevice.orientation;
      }
    }
    return -1;
  }

  // ERROR //
  public int Init()
  {
    // Byte code:
    //   0: getstatic 501	com/viber/voip/settings/d$aj:b	Lcom/viber/common/b/b;
    //   3: invokevirtual 506	com/viber/common/b/b:d	()Z
    //   6: ifeq +37 -> 43
    //   9: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   12: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   15: ifnull +28 -> 43
    //   18: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   21: astore 29
    //   23: aload 29
    //   25: monitorenter
    //   26: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   29: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   32: checkcast 60	java/util/List
    //   35: invokeinterface 509 1 0
    //   40: aload 29
    //   42: monitorexit
    //   43: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   46: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   49: ifnull +30 -> 79
    //   52: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   55: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   58: checkcast 60	java/util/List
    //   61: invokeinterface 80 1 0
    //   66: ifle +13 -> 79
    //   69: iconst_0
    //   70: ireturn
    //   71: astore 30
    //   73: aload 29
    //   75: monitorexit
    //   76: aload 30
    //   78: athrow
    //   79: aload_0
    //   80: getstatic 373	com/viber/voip/settings/d$m:m	Lcom/viber/common/b/h;
    //   83: invokevirtual 511	com/viber/common/b/h:d	()Ljava/lang/String;
    //   86: invokespecial 513	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:loadFromJson	(Ljava/lang/String;)Z
    //   89: ifne -20 -> 69
    //   92: aload_0
    //   93: getfield 40	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:context	Landroid/content/Context;
    //   96: invokestatic 518	com/viber/common/permission/c:a	(Landroid/content/Context;)Lcom/viber/common/permission/c;
    //   99: astore_1
    //   100: aload_1
    //   101: iconst_1
    //   102: anewarray 297	java/lang/String
    //   105: dup
    //   106: iconst_0
    //   107: ldc_w 520
    //   110: aastore
    //   111: invokevirtual 523	com/viber/common/permission/c:a	([Ljava/lang/String;)Z
    //   114: ifne +75 -> 189
    //   117: aload_1
    //   118: new 525	com/viber/voip/permissions/d
    //   121: dup
    //   122: aload_0
    //   123: getfield 40	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:context	Landroid/content/Context;
    //   126: invokespecial 528	com/viber/voip/permissions/d:<init>	(Landroid/content/Context;)V
    //   129: invokevirtual 531	com/viber/common/permission/c:a	(Lcom/viber/common/permission/b;)V
    //   132: getstatic 501	com/viber/voip/settings/d$aj:b	Lcom/viber/common/b/b;
    //   135: iconst_1
    //   136: invokevirtual 533	com/viber/common/b/b:a	(Z)V
    //   139: aload_0
    //   140: getfield 40	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:context	Landroid/content/Context;
    //   143: invokevirtual 539	android/content/Context:getAssets	()Landroid/content/res/AssetManager;
    //   146: ldc 8
    //   148: invokevirtual 544	android/content/res/AssetManager:open	(Ljava/lang/String;)Ljava/io/InputStream;
    //   151: invokestatic 549	com/viber/voip/util/bj:a	(Ljava/io/InputStream;)Ljava/lang/String;
    //   154: astore 28
    //   156: aload 28
    //   158: astore 26
    //   160: aload_0
    //   161: aload 26
    //   163: invokespecial 513	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:loadFromJson	(Ljava/lang/String;)Z
    //   166: ifeq +17 -> 183
    //   169: iconst_0
    //   170: istore 27
    //   172: iload 27
    //   174: ireturn
    //   175: astore 25
    //   177: aconst_null
    //   178: astore 26
    //   180: goto -20 -> 160
    //   183: iconst_m1
    //   184: istore 27
    //   186: goto -14 -> 172
    //   189: getstatic 501	com/viber/voip/settings/d$aj:b	Lcom/viber/common/b/b;
    //   192: iconst_0
    //   193: invokevirtual 533	com/viber/common/b/b:a	(Z)V
    //   196: iconst_0
    //   197: istore_2
    //   198: iload_2
    //   199: invokestatic 552	android/hardware/Camera:getNumberOfCameras	()I
    //   202: if_icmpge +410 -> 612
    //   205: new 554	android/hardware/Camera$CameraInfo
    //   208: dup
    //   209: invokespecial 555	android/hardware/Camera$CameraInfo:<init>	()V
    //   212: astore 4
    //   214: iload_2
    //   215: aload 4
    //   217: invokestatic 559	android/hardware/Camera:getCameraInfo	(ILandroid/hardware/Camera$CameraInfo;)V
    //   220: new 105	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice
    //   223: dup
    //   224: aload 4
    //   226: getfield 562	android/hardware/Camera$CameraInfo:facing	I
    //   229: invokespecial 563	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:<init>	(I)V
    //   232: astore 5
    //   234: aload 5
    //   236: iload_2
    //   237: putfield 566	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:index	I
    //   240: aload 5
    //   242: aload 4
    //   244: getfield 567	android/hardware/Camera$CameraInfo:orientation	I
    //   247: putfield 108	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:orientation	I
    //   250: aload 5
    //   252: aload 4
    //   254: getfield 562	android/hardware/Camera$CameraInfo:facing	I
    //   257: putfield 568	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:facing	I
    //   260: aload 4
    //   262: getfield 562	android/hardware/Camera$CameraInfo:facing	I
    //   265: ifne +98 -> 363
    //   268: aload 5
    //   270: new 198	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   277: ldc_w 570
    //   280: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   283: iload_2
    //   284: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: ldc_w 575
    //   290: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   293: aload 4
    //   295: getfield 567	android/hardware/Camera$CameraInfo:orientation	I
    //   298: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   301: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   304: putfield 346	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:deviceUniqueName	Ljava/lang/String;
    //   307: aload_0
    //   308: iload_2
    //   309: invokespecial 577	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:openCamera	(I)Landroid/hardware/Camera;
    //   312: astore 16
    //   314: aload 16
    //   316: astore 8
    //   318: aload 8
    //   320: ifnonnull +104 -> 424
    //   323: aload 8
    //   325: ifnull +36 -> 361
    //   328: aload 8
    //   330: invokevirtual 310	android/hardware/Camera:release	()V
    //   333: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   336: astore 22
    //   338: aload 22
    //   340: monitorenter
    //   341: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   344: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   347: checkcast 60	java/util/List
    //   350: aload 5
    //   352: invokeinterface 396 2 0
    //   357: pop
    //   358: aload 22
    //   360: monitorexit
    //   361: iconst_m1
    //   362: ireturn
    //   363: aload 5
    //   365: new 198	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 199	java/lang/StringBuilder:<init>	()V
    //   372: ldc_w 570
    //   375: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: iload_2
    //   379: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   382: ldc_w 579
    //   385: invokevirtual 203	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: aload 4
    //   390: getfield 567	android/hardware/Camera$CameraInfo:orientation	I
    //   393: invokevirtual 573	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   396: invokevirtual 208	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   399: putfield 346	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:deviceUniqueName	Ljava/lang/String;
    //   402: aload 5
    //   404: getstatic 582	org/webrtc/videoengine/VideoCaptureDeviceInfo$FrontFacingCameraType:Android23	Lorg/webrtc/videoengine/VideoCaptureDeviceInfo$FrontFacingCameraType;
    //   407: putfield 309	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:frontCameraType	Lorg/webrtc/videoengine/VideoCaptureDeviceInfo$FrontFacingCameraType;
    //   410: goto -103 -> 307
    //   413: astore_3
    //   414: iconst_m1
    //   415: ireturn
    //   416: astore 23
    //   418: aload 22
    //   420: monitorexit
    //   421: aload 23
    //   423: athrow
    //   424: aload 8
    //   426: invokevirtual 251	android/hardware/Camera:getParameters	()Landroid/hardware/Camera$Parameters;
    //   429: astore 18
    //   431: aload 5
    //   433: dconst_1
    //   434: aload 18
    //   436: invokevirtual 586	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   439: getfield 92	android/hardware/Camera$Size:width	I
    //   442: i2d
    //   443: dmul
    //   444: aload 18
    //   446: invokevirtual 586	android/hardware/Camera$Parameters:getPreviewSize	()Landroid/hardware/Camera$Size;
    //   449: getfield 95	android/hardware/Camera$Size:height	I
    //   452: i2d
    //   453: ddiv
    //   454: putfield 590	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice:device_aspect_ratio	D
    //   457: aload_0
    //   458: aload 5
    //   460: aload 18
    //   462: invokespecial 592	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:AddDeviceInfo	(Lorg/webrtc/videoengine/VideoCaptureDeviceInfoAndroid$AndroidVideoCaptureDevice;Landroid/hardware/Camera$Parameters;)V
    //   465: aload 8
    //   467: ifnull +165 -> 632
    //   470: aload 8
    //   472: invokevirtual 310	android/hardware/Camera:release	()V
    //   475: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   478: astore 19
    //   480: aload 19
    //   482: monitorenter
    //   483: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   486: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   489: checkcast 60	java/util/List
    //   492: aload 5
    //   494: invokeinterface 396 2 0
    //   499: pop
    //   500: aload 19
    //   502: monitorexit
    //   503: goto +129 -> 632
    //   506: astore 20
    //   508: aload 19
    //   510: monitorexit
    //   511: aload 20
    //   513: athrow
    //   514: aload 8
    //   516: ifnull +116 -> 632
    //   519: aload 8
    //   521: invokevirtual 310	android/hardware/Camera:release	()V
    //   524: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   527: astore 13
    //   529: aload 13
    //   531: monitorenter
    //   532: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   535: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   538: checkcast 60	java/util/List
    //   541: aload 5
    //   543: invokeinterface 396 2 0
    //   548: pop
    //   549: aload 13
    //   551: monitorexit
    //   552: goto +80 -> 632
    //   555: astore 14
    //   557: aload 13
    //   559: monitorexit
    //   560: aload 14
    //   562: athrow
    //   563: aload 8
    //   565: ifnull +36 -> 601
    //   568: aload 8
    //   570: invokevirtual 310	android/hardware/Camera:release	()V
    //   573: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   576: astore 9
    //   578: aload 9
    //   580: monitorenter
    //   581: getstatic 34	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:deviceList	Ljava/util/concurrent/atomic/AtomicReference;
    //   584: invokevirtual 129	java/util/concurrent/atomic/AtomicReference:get	()Ljava/lang/Object;
    //   587: checkcast 60	java/util/List
    //   590: aload 5
    //   592: invokeinterface 396 2 0
    //   597: pop
    //   598: aload 9
    //   600: monitorexit
    //   601: aload 7
    //   603: athrow
    //   604: astore 10
    //   606: aload 9
    //   608: monitorexit
    //   609: aload 10
    //   611: athrow
    //   612: aload_0
    //   613: invokespecial 594	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:VerifyCapabilities	()V
    //   616: aload_0
    //   617: invokespecial 596	org/webrtc/videoengine/VideoCaptureDeviceInfoAndroid:saveToJson	()V
    //   620: iconst_0
    //   621: ireturn
    //   622: astore 7
    //   624: goto -61 -> 563
    //   627: astore 17
    //   629: goto -115 -> 514
    //   632: iinc 2 1
    //   635: goto -437 -> 198
    //   638: astore 12
    //   640: aconst_null
    //   641: astore 8
    //   643: goto -129 -> 514
    //   646: astore 6
    //   648: aload 6
    //   650: astore 7
    //   652: aconst_null
    //   653: astore 8
    //   655: goto -92 -> 563
    //
    // Exception table:
    //   from	to	target	type
    //   26	43	71	finally
    //   73	76	71	finally
    //   139	156	175	java/io/IOException
    //   198	307	413	java/lang/Exception
    //   328	341	413	java/lang/Exception
    //   363	410	413	java/lang/Exception
    //   421	424	413	java/lang/Exception
    //   470	483	413	java/lang/Exception
    //   511	514	413	java/lang/Exception
    //   519	532	413	java/lang/Exception
    //   560	563	413	java/lang/Exception
    //   568	581	413	java/lang/Exception
    //   601	604	413	java/lang/Exception
    //   609	612	413	java/lang/Exception
    //   341	361	416	finally
    //   418	421	416	finally
    //   483	503	506	finally
    //   508	511	506	finally
    //   532	552	555	finally
    //   557	560	555	finally
    //   581	601	604	finally
    //   606	609	604	finally
    //   424	465	622	finally
    //   424	465	627	java/lang/Throwable
    //   307	314	638	java/lang/Throwable
    //   307	314	646	finally
  }

  public int NumberOfDevices()
  {
    synchronized (deviceList)
    {
      int i = ((List)deviceList.get()).size();
      return i;
    }
  }

  public static class AndroidVideoCaptureDevice
  {
    private static final String CAPTURE_CAPABILITIES = "captureCapabilies";
    private static final String DEVICE_ASPECT_RATIO = "device_aspect_ratio";
    private static final String DEVICE_ROTATION_HINT = "device_rotation_hint";
    private static final String DEVICE_UNIQUE_NAME = "deviceUniqueName";
    private static final String FACING = "facing";
    private static final String FRONT_CAMERA_TYPE = "frontCameraType";
    private static final String INDEX = "index";
    private static final String ORIENTATION = "orientation";
    public CaptureCapabilityAndroid[] captureCapabilies;
    public String deviceUniqueName;
    public double device_aspect_ratio = 0.0D;
    public int device_rotation_hint = 0;
    public int facing;
    public VideoCaptureDeviceInfo.FrontFacingCameraType frontCameraType;
    public int index;
    public int orientation;

    private AndroidVideoCaptureDevice()
    {
    }

    AndroidVideoCaptureDevice(int paramInt)
    {
      this.frontCameraType = VideoCaptureDeviceInfo.FrontFacingCameraType.None;
      this.index = 0;
      this.facing = paramInt;
      if ("LT18i".equalsIgnoreCase(Build.DEVICE))
        this.device_rotation_hint = 180;
      if (("N1mini".equalsIgnoreCase(Build.DEVICE)) || ("N1".equalsIgnoreCase(Build.DEVICE)) || ("N3".equalsIgnoreCase(Build.DEVICE)))
        this.device_rotation_hint = 180;
      if (("jflte".equalsIgnoreCase(Build.DEVICE)) && (paramInt == 1))
        this.device_aspect_ratio = 1.6D;
    }

    public static AndroidVideoCaptureDevice fromJson(JSONObject paramJSONObject)
      throws JSONException
    {
      AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = new AndroidVideoCaptureDevice();
      localAndroidVideoCaptureDevice.deviceUniqueName = paramJSONObject.optString("deviceUniqueName", null);
      JSONArray localJSONArray = paramJSONObject.getJSONArray("captureCapabilies");
      localAndroidVideoCaptureDevice.captureCapabilies = new CaptureCapabilityAndroid[localJSONArray.length()];
      for (int i = 0; i < localJSONArray.length(); i++)
        localAndroidVideoCaptureDevice.captureCapabilies[i] = CaptureCapabilityAndroid.fromJson(localJSONArray.getJSONObject(i));
      localAndroidVideoCaptureDevice.frontCameraType = VideoCaptureDeviceInfo.FrontFacingCameraType.valueOf(paramJSONObject.optString("frontCameraType", VideoCaptureDeviceInfo.FrontFacingCameraType.None.name()));
      localAndroidVideoCaptureDevice.orientation = paramJSONObject.optInt("orientation", 0);
      localAndroidVideoCaptureDevice.index = paramJSONObject.optInt("index", 0);
      localAndroidVideoCaptureDevice.device_rotation_hint = paramJSONObject.optInt("device_rotation_hint", 0);
      localAndroidVideoCaptureDevice.device_aspect_ratio = paramJSONObject.optDouble("device_aspect_ratio", 0.0D);
      localAndroidVideoCaptureDevice.facing = paramJSONObject.optInt("facing", 0);
      return localAndroidVideoCaptureDevice;
    }

    public AndroidVideoCaptureDevice clone()
    {
      AndroidVideoCaptureDevice localAndroidVideoCaptureDevice = new AndroidVideoCaptureDevice(this.facing);
      localAndroidVideoCaptureDevice.deviceUniqueName = this.deviceUniqueName;
      localAndroidVideoCaptureDevice.captureCapabilies = ((CaptureCapabilityAndroid[])this.captureCapabilies.clone());
      localAndroidVideoCaptureDevice.frontCameraType = this.frontCameraType;
      localAndroidVideoCaptureDevice.orientation = this.orientation;
      localAndroidVideoCaptureDevice.index = this.index;
      localAndroidVideoCaptureDevice.device_rotation_hint = this.device_rotation_hint;
      localAndroidVideoCaptureDevice.device_aspect_ratio = this.device_aspect_ratio;
      return localAndroidVideoCaptureDevice;
    }

    public JSONObject toJson()
      throws JSONException
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("deviceUniqueName", this.deviceUniqueName);
      JSONArray localJSONArray = new JSONArray();
      CaptureCapabilityAndroid[] arrayOfCaptureCapabilityAndroid = this.captureCapabilies;
      int i = arrayOfCaptureCapabilityAndroid.length;
      for (int j = 0; j < i; j++)
        localJSONArray.put(arrayOfCaptureCapabilityAndroid[j].toJson());
      localJSONObject.put("captureCapabilies", localJSONArray);
      localJSONObject.put("frontCameraType", this.frontCameraType.name());
      localJSONObject.put("orientation", this.orientation);
      localJSONObject.put("index", this.index);
      localJSONObject.put("device_rotation_hint", this.device_rotation_hint);
      localJSONObject.put("device_aspect_ratio", this.device_aspect_ratio);
      localJSONObject.put("facing", this.facing);
      return localJSONObject;
    }
  }

  protected static class AutoReleaseCamHolder
  {
    private VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice device;
    private String deviceUniqueId;
    private AtomicReference<Camera> ref;

    public AutoReleaseCamHolder(Camera paramCamera, VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice paramAndroidVideoCaptureDevice, String paramString)
    {
      this.ref = new AtomicReference(paramCamera);
      this.device = paramAndroidVideoCaptureDevice;
      this.deviceUniqueId = paramString;
    }

    public VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice device()
    {
      return this.device;
    }

    public String deviceUniqueId()
    {
      return this.deviceUniqueId;
    }

    protected void finalize()
      throws Throwable
    {
      release();
      super.finalize();
    }

    public Camera get()
    {
      return (Camera)this.ref.get();
    }

    public void release()
    {
      set(null, null, null);
    }

    public void set(Camera paramCamera, VideoCaptureDeviceInfoAndroid.AndroidVideoCaptureDevice paramAndroidVideoCaptureDevice, String paramString)
    {
      Camera localCamera = (Camera)this.ref.getAndSet(paramCamera);
      if (localCamera != null);
      try
      {
        localCamera.release();
        if (this.ref.compareAndSet(null, paramCamera))
        {
          this.device = paramAndroidVideoCaptureDevice;
          this.deviceUniqueId = paramString;
        }
        return;
      }
      catch (Exception localException)
      {
        while (true)
          localException.printStackTrace();
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.VideoCaptureDeviceInfoAndroid
 * JD-Core Version:    0.6.2
 */