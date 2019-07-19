package com.viber.voip.videoconvert.gpu.b;

import android.os.Build.VERSION;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import com.viber.voip.videoconvert.gpu.f.b;
import com.viber.voip.videoconvert.gpu.f.d.a;
import com.viber.voip.videoconvert.gpu.opengl.PBufferGLWrapperNative;
import com.viber.voip.videoconvert.gpu.receivers.LibMuxDataReceiver;
import java.util.ArrayList;
import java.util.List;

public class d extends a
{
  public com.viber.voip.videoconvert.gpu.encoders.c a(String paramString1, String paramString2, c.a parama, d.a parama1)
  {
    return a(new com.viber.voip.videoconvert.gpu.encoders.a(parama), new b(paramString1), parama1, new com.viber.voip.videoconvert.gpu.e.c(), new LibMuxDataReceiver(paramString2));
  }

  public boolean a()
  {
    e.a().a("Checking availability of InputSurface mode");
    if (Build.VERSION.SDK_INT < 18)
    {
      e.a().a("SDK_INT < 18. InputSurface mode is not avaible.");
      return false;
    }
    if (a(new ArrayList()))
    {
      e.a().a("Found blacklisted codec. InputSurface mode is not avaible.");
      return false;
    }
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new com.viber.voip.videoconvert.gpu.a.a("intel", "byt_t_ffrd8"));
    localArrayList.add(new com.viber.voip.videoconvert.gpu.a.a("HTC", "m7"));
    if (b(localArrayList))
    {
      e.a().a("found blacklisted device " + new com.viber.voip.videoconvert.gpu.a.a().toString());
      return false;
    }
    try
    {
      PBufferGLWrapperNative localPBufferGLWrapperNative = new PBufferGLWrapperNative(128, 128);
      try
      {
        localPBufferGLWrapperNative.init();
        boolean bool = com.viber.voip.videoconvert.gpu.encoders.a.a(localPBufferGLWrapperNative);
        localPBufferGLWrapperNative.release(false);
        e.a().a("Availability of InputSurface mode: " + bool);
        return bool;
      }
      finally
      {
        localPBufferGLWrapperNative.release(false);
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().a("Trying to initialize GLWrapper failed. InputSurface mode is not avaible.");
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.b.d
 * JD-Core Version:    0.6.2
 */