package com.viber.voip.videoconvert.gpu.receivers;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.MediaCodec.BufferInfo;
import com.viber.voip.videoconvert.VideoConverterService;
import com.viber.voip.videoconvert.gpu.a.d;
import com.viber.voip.videoconvert.gpu.encoders.c;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import java.io.File;
import java.io.IOException;
import java.nio.ByteBuffer;

@TargetApi(16)
public class LibMuxDataReceiver extends a
{
  private String c;
  private String d;
  private Process e;
  private b f;

  public LibMuxDataReceiver(String paramString)
  {
    this.c = paramString;
    this.d = (d() + File.separator + "input.mkv");
  }

  private String d()
  {
    return "/data/data/" + VideoConverterService.b().getPackageName();
  }

  private native int deleteExistingAndCreateFifoFile(String paramString);

  private void e()
  {
    String str = d.a("mux");
    String[] arrayOfString = new String[27];
    arrayOfString[0] = str;
    arrayOfString[1] = "-v";
    arrayOfString[2] = "panic";
    arrayOfString[3] = "-i";
    arrayOfString[4] = this.c;
    arrayOfString[5] = "-probesize";
    arrayOfString[6] = "500";
    arrayOfString[7] = "-f";
    arrayOfString[8] = "matroska";
    arrayOfString[9] = "-i";
    arrayOfString[10] = this.d;
    arrayOfString[11] = "-metadata:s:v:0";
    arrayOfString[12] = ("rotate=" + this.a.f);
    arrayOfString[13] = "-c";
    arrayOfString[14] = "copy";
    arrayOfString[15] = "-map";
    arrayOfString[16] = "0";
    arrayOfString[17] = "-map";
    arrayOfString[18] = "-0:v";
    arrayOfString[19] = "-map";
    arrayOfString[20] = "1";
    arrayOfString[21] = "-f";
    arrayOfString[22] = "mp4";
    arrayOfString[23] = "-movflags";
    arrayOfString[24] = "faststart";
    arrayOfString[25] = "-y";
    arrayOfString[26] = this.a.a;
    try
    {
      this.e = com.viber.voip.videoconvert.gpu.a.e.a(arrayOfString, "AudioVideoMuxer", true);
      return;
    }
    catch (IOException localIOException)
    {
      this.e = null;
      com.viber.voip.videoconvert.e.a().a("[muxing] muxing start failed");
    }
  }

  public void a()
  {
    this.f.a();
  }

  public void a(c paramc)
  {
    super.a(paramc);
    if (deleteExistingAndCreateFifoFile(this.d) != 0)
      com.viber.voip.videoconvert.e.a().a("Failed to create fifo file. Expect overflowing /data/data/");
    e();
    this.f = new WriteMkvDataReceiver(this.d);
    this.f.a(paramc);
    try
    {
      Thread.sleep(500L);
      return;
    }
    catch (InterruptedException localInterruptedException)
    {
    }
  }

  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    this.f.a(paramByteBuffer, paramBufferInfo);
  }

  public void b()
  {
    this.f.b();
    try
    {
      if ((this.e != null) && (this.e.waitFor() != 0))
        com.viber.voip.videoconvert.e.a().a("[muxing] muxing failed");
      return;
    }
    catch (Exception localException)
    {
      com.viber.voip.videoconvert.e.a().a("[muxing] exception");
      com.viber.voip.videoconvert.e.a().a(localException);
    }
  }

  public void c()
  {
    this.f.c();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.receivers.LibMuxDataReceiver
 * JD-Core Version:    0.6.2
 */