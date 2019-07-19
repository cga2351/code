package com.viber.voip.videoconvert.gpu.b;

import android.os.Build.VERSION;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.gpu.e.d;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import com.viber.voip.videoconvert.gpu.f.b;
import com.viber.voip.videoconvert.gpu.f.d.a;
import com.viber.voip.videoconvert.gpu.opengl.PBufferGLWrapperNative;
import com.viber.voip.videoconvert.gpu.receivers.LibMuxDataReceiver;
import java.util.ArrayList;
import java.util.List;

public class c extends a
{
  public com.viber.voip.videoconvert.gpu.encoders.c a(String paramString1, String paramString2, c.a parama, d.a parama1)
  {
    return a(new com.viber.voip.videoconvert.gpu.encoders.a(parama), new b(paramString1), parama1, new d(), new LibMuxDataReceiver(paramString2));
  }

  public boolean a()
  {
    e.a().a("Checking availability of InputBuffers mode");
    if (Build.VERSION.SDK_INT < 16)
    {
      e.a().a("SDK_INT < 16. InputBuffers mode is not avaible.");
      return false;
    }
    ArrayList localArrayList1 = new ArrayList();
    localArrayList1.add(new com.viber.voip.videoconvert.gpu.a.a("LGE", "vee7ds"));
    localArrayList1.add(new com.viber.voip.videoconvert.gpu.a.a("LGE", "vee3e"));
    localArrayList1.add(new com.viber.voip.videoconvert.gpu.a.a("HTC", "m7"));
    localArrayList1.add(new com.viber.voip.videoconvert.gpu.a.a("samsung", "golden"));
    localArrayList1.add(new com.viber.voip.videoconvert.gpu.a.a("TCT", "ALCATEL ONE TOUCH 6040D"));
    if (b(localArrayList1))
    {
      e.a().a("found blacklisted device " + new com.viber.voip.videoconvert.gpu.a.a().toString());
      return false;
    }
    ArrayList localArrayList2 = new ArrayList();
    localArrayList2.add("OMX.MARVELL.VIDEO.HW");
    localArrayList2.add("OMX.TI.DUCATI1.VIDEO");
    localArrayList2.add("OMX.Exynos.avc.enc");
    localArrayList2.add("OMX.Intel.VideoDecoder.AVC");
    localArrayList2.add("OMX.Intel.VideoEncoder.AVC");
    if (a(localArrayList2))
    {
      e.a().a("Found blacklisted codec. InputBuffers mode is not avaible.");
      return false;
    }
    try
    {
      PBufferGLWrapperNative localPBufferGLWrapperNative = new PBufferGLWrapperNative(128, 128);
      try
      {
        localPBufferGLWrapperNative.init();
        boolean bool1 = a("mux");
        if (!bool1)
          e.a().a("required library is not available");
        if (bool1);
        for (boolean bool2 = true; ; bool2 = false)
        {
          localPBufferGLWrapperNative.release(false);
          e.a().a("Availability of InputBuffers mode: " + bool2);
          return bool2;
        }
      }
      finally
      {
        localPBufferGLWrapperNative.release(false);
      }
    }
    catch (Throwable localThrowable)
    {
      e.a().a("Exception when trying GLWrapper. InputBuffers mode is not avaible.");
    }
    return false;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.b.c
 * JD-Core Version:    0.6.2
 */