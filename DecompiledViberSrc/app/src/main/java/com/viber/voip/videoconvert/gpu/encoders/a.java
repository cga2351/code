package com.viber.voip.videoconvert.gpu.encoders;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCodecInfo;
import android.media.MediaCodecInfo.CodecCapabilities;
import android.media.MediaFormat;
import android.os.Build.VERSION;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.gpu.a.c.c;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.List;

@TargetApi(16)
public class a extends BaseVideoEncoder
  implements b
{
  private MediaCodec g;
  private MediaFormat h;
  private MediaFormat i;
  private MediaCodec.BufferInfo j;
  private boolean k = false;
  private com.viber.voip.videoconvert.gpu.a.c l = new com.viber.voip.videoconvert.gpu.a.c();
  private com.viber.voip.videoconvert.gpu.d.b m;

  public a(c.a parama)
  {
    super(parama);
    this.l.a(new c.c());
    this.l.a(new com.viber.voip.videoconvert.gpu.a.c.d("video/avc"));
  }

  public static boolean a(com.viber.voip.videoconvert.gpu.opengl.c paramc)
  {
    paramc.makeCurrent();
    String[] arrayOfString = paramc.getExtensions().split(" ");
    e.a().b("Vendor:     " + paramc.getVendor());
    e.a().b("Renderer:   " + paramc.getRenderer());
    if (arrayOfString.length > 0)
      e.a().b("Extensions: " + arrayOfString[0]);
    for (int n = 1; n < arrayOfString.length; n++)
      e.a().b("            " + arrayOfString[n]);
    boolean bool = paramc.isExtensionSupported("GL_OES_EGL_image_external");
    paramc.doneCurrent();
    return bool;
  }

  public void a(ByteBuffer paramByteBuffer, int paramInt, long paramLong, boolean paramBoolean)
  {
    ByteBuffer[] arrayOfByteBuffer = this.g.getInputBuffers();
    int n = 0;
    label265: 
    while (true)
    {
      int i1 = this.g.dequeueInputBuffer(3000L);
      int i6;
      int i2;
      if (i1 >= 0)
      {
        ByteBuffer localByteBuffer = arrayOfByteBuffer[i1];
        int i3 = Math.min(localByteBuffer.limit(), paramInt);
        e.a().a("submitting " + i3 + " bytes into " + i1 + "/" + arrayOfByteBuffer.length + " input buffer");
        localByteBuffer.put(paramByteBuffer.array(), n, i3);
        int i4 = n + i3;
        paramInt -= i3;
        int i5 = 2;
        if (paramBoolean)
        {
          e.a().a("submitting " + i3 + " bytes into " + i1 + "/" + arrayOfByteBuffer.length + "input buffer with BUFFER_FLAG_END_OF_STREAM set");
          i5 = 6;
        }
        this.g.queueInputBuffer(i1, 0, i3, paramLong / 1000L, i5);
        if (paramInt != 0)
        {
          i6 = 1;
          i2 = i6;
          n = i4;
        }
      }
      while (true)
      {
        if (i2 != 0)
          break label265;
        return;
        i6 = 0;
        break;
        e.a().a("dequeueInputBuffer returned " + i1);
        i2 = 1;
      }
    }
  }

  public void a(ByteBuffer paramByteBuffer, c.b paramb, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean)
  {
    c.b localb = this.m.c();
    if (b().h)
    {
      if (localb != c.b.f)
        break label103;
      localb = c.b.e;
    }
    while (true)
    {
      int n = convertPixels(paramInt1, paramInt2, paramByteBuffer, paramb.ordinal(), this.d, this.c, localb.ordinal(), this.m.d(), this.m.e(), this.m.f());
      a(this.c, n, paramLong, paramBoolean);
      return;
      label103: e.a().a("mHackSwapUandV set, but PixelFormat is not NV12");
    }
  }

  public void a(boolean paramBoolean)
  {
    ByteBuffer[] arrayOfByteBuffer = this.g.getOutputBuffers();
    do
    {
      int n;
      while (true)
      {
        n = this.g.dequeueOutputBuffer(this.j, 3000L);
        if (n == -1)
        {
          if (!paramBoolean)
            return;
          e.a().a("no output available, spinning to await EOS");
        }
        else if (n == -3)
        {
          arrayOfByteBuffer = this.g.getOutputBuffers();
        }
        else if (n == -2)
        {
          if (a() != c.d.b)
            throw new RuntimeException("format changed twice");
          if (a() == c.d.b)
          {
            this.i = this.g.getOutputFormat();
            this.m.a(this.i);
            e.a().a("encoder output format changed: " + this.i);
            this.b.a();
            a(c.d.c);
          }
        }
        else
        {
          if (n >= 0)
            break;
          e.a().a("unexpected result from encoder.dequeueOutputBuffer: " + n);
        }
      }
      ByteBuffer localByteBuffer = arrayOfByteBuffer[n];
      if (localByteBuffer == null)
        throw new RuntimeException("encoderOutputBuffer " + n + " was null");
      if (((0x2 & this.j.flags) != 0) && (a() == c.d.b))
      {
        this.i = this.h;
        this.b.a();
        a(c.d.c);
      }
      if (this.j.size != 0)
      {
        if (a() == c.d.b)
          throw new RuntimeException("encoded data receiver was not started!");
        localByteBuffer.position(this.j.offset);
        localByteBuffer.limit(this.j.offset + this.j.size);
        this.b.a(localByteBuffer, this.j);
        a(this.j.presentationTimeUs);
      }
      this.g.releaseOutputBuffer(n, false);
    }
    while ((0x4 & this.j.flags) == 0);
    if (!paramBoolean)
      e.a().b("reached end of stream unexpectedly");
    while (true)
    {
      if (this.b != null)
        this.b.b();
      e.a().a("stopped encoded data receiver");
      return;
      e.a().a("end of stream reached");
    }
  }

  public void c()
  {
    e.a().a("preparing encoder");
    e.a().a("available encoders supporting video/avc");
    List localList = this.l.a();
    e.a().a("there are " + localList.size() + " encoders supporting " + "video/avc" + " on this device");
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
    {
      MediaCodecInfo localMediaCodecInfo2 = (MediaCodecInfo)localIterator.next();
      String str = "\t" + localMediaCodecInfo2.getName() + " : ";
      for (int i2 : localMediaCodecInfo2.getCapabilitiesForType("video/avc").colorFormats)
        str = str + String.valueOf(i2) + " ";
      e.a().a(str);
    }
    if (localList.isEmpty())
      throw new RuntimeException("no valid encoders is available");
    this.j = new MediaCodec.BufferInfo();
    c.a locala = b();
    e.a().a("creating video/avc encoder");
    MediaCodecInfo localMediaCodecInfo1 = (MediaCodecInfo)localList.get(0);
    while (true)
    {
      try
      {
        this.g = MediaCodec.createByCodecName(localMediaCodecInfo1.getName());
        e.a().a("creating MediaFormat");
        this.h = MediaFormat.createVideoFormat("video/avc", locala.b, locala.c);
        this.m = com.viber.voip.videoconvert.gpu.d.c.a(localMediaCodecInfo1, "video/avc", 19);
        this.m.a();
        this.h.setInteger("bitrate", locala.d);
        this.h.setInteger("frame-rate", locala.e);
        this.h.setInteger("i-frame-interval", 5);
        this.h.setInteger("color-format", this.m.b());
        super.c();
        this.g.configure(this.h, null, null, 1);
        if (this.h.getInteger("color-format") == 2130708361)
        {
          bool = true;
          this.k = bool;
          this.m.a(this.h);
          return;
        }
      }
      catch (IOException localIOException)
      {
        throw new RuntimeException("failed to create MediaCodec class");
      }
      boolean bool = false;
    }
  }

  public void d()
  {
    super.d();
    e.a().a("starting MediaCodec");
    this.g.start();
  }

  public void e()
  {
    super.e();
    if (this.k)
      if (Build.VERSION.SDK_INT >= 18)
        this.g.signalEndOfInputStream();
    while (true)
    {
      a(true);
      e.a().a("stopping encoder");
      this.g.stop();
      return;
      throw new RuntimeException("MediaCodecInfo.COLOR_FormatSurface could be used only after PLATFORM_SDK=18");
      a(this.c, 0, this.a.f(), true);
    }
  }

  public void f()
  {
    e.a().a("releasing encoder");
    if (this.g != null)
    {
      this.g.release();
      this.g = null;
    }
    super.f();
    e.a().a("released MediaCodec");
  }

  public MediaCodec i()
  {
    return this.g;
  }

  public MediaFormat j()
  {
    if (this.i != null)
      return this.i;
    return this.h;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.encoders.a
 * JD-Core Version:    0.6.2
 */