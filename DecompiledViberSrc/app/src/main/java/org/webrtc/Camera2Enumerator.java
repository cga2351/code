package org.webrtc;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Build.VERSION;
import android.os.SystemClock;
import android.util.AndroidException;
import android.util.Range;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@TargetApi(21)
public class Camera2Enumerator
  implements CameraEnumerator
{
  private static final double NANO_SECONDS_PER_SECOND = 1000000000.0D;
  private static final String TAG = "Camera2Enumerator";
  private static final Map<String, List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats = new HashMap();

  @Nullable
  final CameraManager cameraManager;
  final Context context;

  public Camera2Enumerator(Context paramContext)
  {
    this.context = paramContext;
    this.cameraManager = ((CameraManager)paramContext.getSystemService("camera"));
  }

  static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(Range<Integer>[] paramArrayOfRange, int paramInt)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfRange.length;
    for (int j = 0; j < i; j++)
    {
      Range<Integer> localRange = paramArrayOfRange[j];
      localArrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(paramInt * ((Integer)localRange.getLower()).intValue(), paramInt * ((Integer)localRange.getUpper()).intValue()));
    }
    return localArrayList;
  }

  private static List<Size> convertSizes(android.util.Size[] paramArrayOfSize)
  {
    ArrayList localArrayList = new ArrayList();
    int i = paramArrayOfSize.length;
    for (int j = 0; j < i; j++)
    {
      android.util.Size localSize = paramArrayOfSize[j];
      localArrayList.add(new Size(localSize.getWidth(), localSize.getHeight()));
    }
    return localArrayList;
  }

  @Nullable
  private CameraCharacteristics getCameraCharacteristics(String paramString)
  {
    try
    {
      CameraCharacteristics localCameraCharacteristics = this.cameraManager.getCameraCharacteristics(paramString);
      return localCameraCharacteristics;
    }
    catch (AndroidException localAndroidException)
    {
      Logging.e("Camera2Enumerator", "Camera access exception: " + localAndroidException);
    }
    return null;
  }

  static int getFpsUnitFactor(Range<Integer>[] paramArrayOfRange)
  {
    if (paramArrayOfRange.length == 0)
      return 1000;
    if (((Integer)paramArrayOfRange[0].getUpper()).intValue() < 1000);
    for (int i = 1000; ; i = 1)
      return i;
  }

  static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(Context paramContext, String paramString)
  {
    return getSupportedFormats((CameraManager)paramContext.getSystemService("camera"), paramString);
  }

  static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(CameraManager paramCameraManager, String paramString)
  {
    long l1;
    StreamConfigurationMap localStreamConfigurationMap;
    List localList2;
    int i;
    synchronized (cachedSupportedFormats)
    {
      if (cachedSupportedFormats.containsKey(paramString))
      {
        List localList3 = (List)cachedSupportedFormats.get(paramString);
        return localList3;
      }
      Logging.d("Camera2Enumerator", "Get supported formats for camera index " + paramString + ".");
      l1 = SystemClock.elapsedRealtime();
      try
      {
        CameraCharacteristics localCameraCharacteristics = paramCameraManager.getCameraCharacteristics(paramString);
        localStreamConfigurationMap = (StreamConfigurationMap)localCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
        Range[] arrayOfRange = (Range[])localCameraCharacteristics.get(CameraCharacteristics.CONTROL_AE_AVAILABLE_TARGET_FPS_RANGES);
        List localList1 = convertFramerates(arrayOfRange, getFpsUnitFactor(arrayOfRange));
        localList2 = getSupportedSizes(localCameraCharacteristics);
        i = 0;
        Iterator localIterator1 = localList1.iterator();
        while (localIterator1.hasNext())
          i = Math.max(i, ((CameraEnumerationAndroid.CaptureFormat.FramerateRange)localIterator1.next()).max);
      }
      catch (Exception localException1)
      {
        Logging.e("Camera2Enumerator", "getCameraCharacteristics(): " + localException1);
        ArrayList localArrayList1 = new ArrayList();
        return localArrayList1;
      }
    }
    ArrayList localArrayList2 = new ArrayList();
    Iterator localIterator2 = localList2.iterator();
    while (true)
    {
      Size localSize;
      long l3;
      if (localIterator2.hasNext())
      {
        localSize = (Size)localIterator2.next();
        l3 = 0L;
      }
      try
      {
        long l4 = localStreamConfigurationMap.getOutputMinFrameDuration(SurfaceTexture.class, new android.util.Size(localSize.width, localSize.height));
        l3 = l4;
        label287: if (l3 == 0L);
        for (int j = i; ; j = 1000 * (int)Math.round(1000000000.0D / l3))
        {
          localArrayList2.add(new CameraEnumerationAndroid.CaptureFormat(localSize.width, localSize.height, 0, j));
          Logging.d("Camera2Enumerator", "Format: " + localSize.width + "x" + localSize.height + "@" + j);
          break;
        }
        cachedSupportedFormats.put(paramString, localArrayList2);
        long l2 = SystemClock.elapsedRealtime();
        Logging.d("Camera2Enumerator", "Get supported formats for camera index " + paramString + " done. Time spent: " + (l2 - l1) + " ms.");
        return localArrayList2;
      }
      catch (Exception localException2)
      {
        break label287;
      }
    }
  }

  static List<Size> getSupportedSizes(CameraCharacteristics paramCameraCharacteristics)
  {
    StreamConfigurationMap localStreamConfigurationMap = (StreamConfigurationMap)paramCameraCharacteristics.get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP);
    int i = ((Integer)paramCameraCharacteristics.get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
    List localList = convertSizes(localStreamConfigurationMap.getOutputSizes(SurfaceTexture.class));
    if ((Build.VERSION.SDK_INT < 22) && (i == 2))
    {
      Rect localRect = (Rect)paramCameraCharacteristics.get(CameraCharacteristics.SENSOR_INFO_ACTIVE_ARRAY_SIZE);
      ArrayList localArrayList = new ArrayList();
      Iterator localIterator = localList.iterator();
      while (localIterator.hasNext())
      {
        Size localSize = (Size)localIterator.next();
        if (localRect.width() * localSize.height == localRect.height() * localSize.width)
          localArrayList.add(localSize);
      }
      return localArrayList;
    }
    return localList;
  }

  public static boolean isSupported(Context paramContext)
  {
    if (Build.VERSION.SDK_INT < 21)
      return false;
    CameraManager localCameraManager = (CameraManager)paramContext.getSystemService("camera");
    try
    {
      String[] arrayOfString = localCameraManager.getCameraIdList();
      int i = arrayOfString.length;
      for (int j = 0; j < i; j++)
      {
        int k = ((Integer)localCameraManager.getCameraCharacteristics(arrayOfString[j]).get(CameraCharacteristics.INFO_SUPPORTED_HARDWARE_LEVEL)).intValue();
        if (k == 2)
          return false;
      }
    }
    catch (AndroidException localAndroidException)
    {
      Logging.e("Camera2Enumerator", "Camera access exception: " + localAndroidException);
      return false;
    }
    return true;
  }

  public CameraVideoCapturer createCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
  {
    return new Camera2Capturer(this.context, paramString, paramCameraEventsHandler);
  }

  public String[] getDeviceNames()
  {
    try
    {
      String[] arrayOfString = this.cameraManager.getCameraIdList();
      return arrayOfString;
    }
    catch (AndroidException localAndroidException)
    {
      Logging.e("Camera2Enumerator", "Camera access exception: " + localAndroidException);
    }
    return new String[0];
  }

  public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String paramString)
  {
    return getSupportedFormats(this.context, paramString);
  }

  public boolean isBackFacing(String paramString)
  {
    CameraCharacteristics localCameraCharacteristics = getCameraCharacteristics(paramString);
    return (localCameraCharacteristics != null) && (((Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 1);
  }

  public boolean isFrontFacing(String paramString)
  {
    CameraCharacteristics localCameraCharacteristics = getCameraCharacteristics(paramString);
    return (localCameraCharacteristics != null) && (((Integer)localCameraCharacteristics.get(CameraCharacteristics.LENS_FACING)).intValue() == 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Camera2Enumerator
 * JD-Core Version:    0.6.2
 */