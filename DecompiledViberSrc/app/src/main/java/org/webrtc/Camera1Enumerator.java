package org.webrtc;

import android.hardware.Camera;
import android.hardware.Camera.CameraInfo;
import android.hardware.Camera.Parameters;
import android.hardware.Camera.Size;
import android.os.SystemClock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public class Camera1Enumerator
  implements CameraEnumerator
{
  private static final String TAG = "Camera1Enumerator";
  private static List<List<CameraEnumerationAndroid.CaptureFormat>> cachedSupportedFormats;
  private final boolean captureToTexture;

  public Camera1Enumerator()
  {
    this(true);
  }

  public Camera1Enumerator(boolean paramBoolean)
  {
    this.captureToTexture = paramBoolean;
  }

  static List<CameraEnumerationAndroid.CaptureFormat.FramerateRange> convertFramerates(List<int[]> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      int[] arrayOfInt = (int[])localIterator.next();
      localArrayList.add(new CameraEnumerationAndroid.CaptureFormat.FramerateRange(arrayOfInt[0], arrayOfInt[1]));
    }
    return localArrayList;
  }

  static List<Size> convertSizes(List<Camera.Size> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      Camera.Size localSize = (Camera.Size)localIterator.next();
      localArrayList.add(new Size(localSize.width, localSize.height));
    }
    return localArrayList;
  }

  private static List<CameraEnumerationAndroid.CaptureFormat> enumerateFormats(int paramInt)
  {
    Logging.d("Camera1Enumerator", "Get supported formats for camera index " + paramInt + ".");
    long l1 = SystemClock.elapsedRealtime();
    Camera localCamera = null;
    while (true)
    {
      try
      {
        Logging.d("Camera1Enumerator", "Opening camera with index " + paramInt);
        localCamera = Camera.open(paramInt);
        Camera.Parameters localParameters = localCamera.getParameters();
        if (localCamera != null)
          localCamera.release();
        ArrayList localArrayList2 = new ArrayList();
        try
        {
          List localList = localParameters.getSupportedPreviewFpsRange();
          if (localList != null)
          {
            int[] arrayOfInt = (int[])localList.get(-1 + localList.size());
            int i = arrayOfInt[0];
            int j = arrayOfInt[1];
            k = i;
            m = j;
            Iterator localIterator = localParameters.getSupportedPreviewSizes().iterator();
            if (localIterator.hasNext())
            {
              Camera.Size localSize = (Camera.Size)localIterator.next();
              localArrayList2.add(new CameraEnumerationAndroid.CaptureFormat(localSize.width, localSize.height, k, m));
              continue;
            }
          }
        }
        catch (Exception localException)
        {
          Logging.e("Camera1Enumerator", "getSupportedFormats() failed on camera index " + paramInt, localException);
          long l2 = SystemClock.elapsedRealtime();
          Logging.d("Camera1Enumerator", "Get supported formats for camera index " + paramInt + " done. Time spent: " + (l2 - l1) + " ms.");
          localArrayList1 = localArrayList2;
          return localArrayList1;
        }
      }
      catch (RuntimeException localRuntimeException)
      {
        Logging.e("Camera1Enumerator", "Open camera failed on camera index " + paramInt, localRuntimeException);
        ArrayList localArrayList1 = new ArrayList();
        return localArrayList1;
      }
      finally
      {
        if (localCamera != null)
          localCamera.release();
      }
      int m = 0;
      int k = 0;
    }
  }

  static int getCameraIndex(String paramString)
  {
    Logging.d("Camera1Enumerator", "getCameraIndex: " + paramString);
    for (int i = 0; i < Camera.getNumberOfCameras(); i++)
      if (paramString.equals(getDeviceName(i)))
        return i;
    throw new IllegalArgumentException("No such camera: " + paramString);
  }

  @Nullable
  private static Camera.CameraInfo getCameraInfo(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = new Camera.CameraInfo();
    try
    {
      Camera.getCameraInfo(paramInt, localCameraInfo);
      return localCameraInfo;
    }
    catch (Exception localException)
    {
      Logging.e("Camera1Enumerator", "getCameraInfo failed on index " + paramInt, localException);
    }
    return null;
  }

  @Nullable
  static String getDeviceName(int paramInt)
  {
    Camera.CameraInfo localCameraInfo = getCameraInfo(paramInt);
    if (localCameraInfo == null)
      return null;
    if (localCameraInfo.facing == 1);
    for (String str = "front"; ; str = "back")
      return "Camera " + paramInt + ", Facing " + str + ", Orientation " + localCameraInfo.orientation;
  }

  static List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(int paramInt)
  {
    try
    {
      if (cachedSupportedFormats == null)
      {
        cachedSupportedFormats = new ArrayList();
        for (int i = 0; i < Camera.getNumberOfCameras(); i++)
          cachedSupportedFormats.add(enumerateFormats(i));
      }
      List localList = (List)cachedSupportedFormats.get(paramInt);
      return localList;
    }
    finally
    {
    }
  }

  public CameraVideoCapturer createCapturer(String paramString, CameraVideoCapturer.CameraEventsHandler paramCameraEventsHandler)
  {
    return new Camera1Capturer(paramString, paramCameraEventsHandler, this.captureToTexture);
  }

  public String[] getDeviceNames()
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < Camera.getNumberOfCameras())
    {
      String str = getDeviceName(i);
      if (str != null)
      {
        localArrayList.add(str);
        Logging.d("Camera1Enumerator", "Index: " + i + ". " + str);
      }
      while (true)
      {
        i++;
        break;
        Logging.e("Camera1Enumerator", "Index: " + i + ". Failed to query camera name.");
      }
    }
    return (String[])localArrayList.toArray(new String[localArrayList.size()]);
  }

  public List<CameraEnumerationAndroid.CaptureFormat> getSupportedFormats(String paramString)
  {
    return getSupportedFormats(getCameraIndex(paramString));
  }

  public boolean isBackFacing(String paramString)
  {
    Camera.CameraInfo localCameraInfo = getCameraInfo(getCameraIndex(paramString));
    return (localCameraInfo != null) && (localCameraInfo.facing == 0);
  }

  public boolean isFrontFacing(String paramString)
  {
    Camera.CameraInfo localCameraInfo = getCameraInfo(getCameraIndex(paramString));
    return (localCameraInfo != null) && (localCameraInfo.facing == 1);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.Camera1Enumerator
 * JD-Core Version:    0.6.2
 */