package org.webrtc.videoengine;

import android.content.Context;
import android.os.Build.VERSION;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class VideoCaptureDeviceInfoH264 extends VideoCaptureApi21.VideoCaptureDeviceInfoHelper
{
  private static final Logger L = ViberEnv.getLogger();
  public static final String TAG = VideoCaptureDeviceInfoH264.class.getSimpleName();
  private AtomicInteger _init_status = new AtomicInteger(-1);

  public VideoCaptureDeviceInfoH264(int paramInt, Context paramContext)
  {
    super(paramInt, paramContext);
  }

  public static VideoCaptureDeviceInfo CreateVideoCaptureDeviceInfo(int paramInt, Context paramContext)
  {
    if (!probeForSupportedModel());
    VideoCaptureDeviceInfoH264 localVideoCaptureDeviceInfoH264;
    do
    {
      return null;
      localVideoCaptureDeviceInfoH264 = new VideoCaptureDeviceInfoH264(paramInt, paramContext);
    }
    while ((localVideoCaptureDeviceInfoH264 == null) || (localVideoCaptureDeviceInfoH264.Init() != 0));
    return localVideoCaptureDeviceInfoH264;
  }

  protected static void log(String paramString)
  {
  }

  private static boolean probeForSupportedModel()
  {
    if (21 <= Build.VERSION.SDK_INT);
    return false;
  }

  public VideoCaptureApi AllocateCamera(int paramInt, long paramLong, String paramString)
  {
    return super.AllocateCamera(paramInt, paramLong, paramString);
  }

  public void DeleteCamera(VideoCaptureApi paramVideoCaptureApi)
  {
    VideoCaptureAndroidH264.DeleteCamera(paramVideoCaptureApi);
    super.DeleteCamera(paramVideoCaptureApi);
  }

  public int Init()
  {
    int i = -1;
    AtomicInteger localAtomicInteger1 = this._init_status;
    if (probeForSupportedModel());
    for (int j = 0; ; j = i)
    {
      localAtomicInteger1.compareAndSet(i, j);
      this._init_status.compareAndSet(0, super.Init());
      if (this._init_status.get() != 0)
        break label152;
      synchronized (_camera_ids)
      {
        ArrayList localArrayList = new ArrayList(_camera_ids);
        _camera_ids.clear();
        Iterator localIterator = localArrayList.iterator();
        if (!localIterator.hasNext())
          break;
        String str = (String)localIterator.next();
        _camera_ids.add("HW H264 " + str);
      }
    }
    label152: AtomicInteger localAtomicInteger2 = this._init_status;
    if ((_camera_ids != null) && (_camera_ids.size() > 0))
      i = 0;
    localAtomicInteger2.compareAndSet(0, i);
    return this._init_status.get();
  }

  protected String getPrefix()
  {
    return "HW H264 ";
  }

  protected VideoCaptureApi newVideoCaptor(int paramInt, long paramLong, String paramString)
  {
    return new VideoCaptureAndroidH264(this, paramInt, paramLong, null, paramString);
  }

  public String uniqueToCameraId(String paramString)
  {
    log(this + "/cutting H264 HW unique prefix");
    return paramString.replaceFirst("HW H264 ", "");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.videoengine.VideoCaptureDeviceInfoH264
 * JD-Core Version:    0.6.2
 */