package com.viber.voip.videoconvert.gpu.receivers;

import android.annotation.TargetApi;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaFormat;
import com.viber.voip.videoconvert.e;
import com.viber.voip.videoconvert.gpu.encoders.c;
import com.viber.voip.videoconvert.gpu.encoders.c.a;
import java.nio.ByteBuffer;

@TargetApi(16)
public class WriteMkvDataReceiver extends a
{
  private String c;
  private long d = 0L;

  public WriteMkvDataReceiver(String paramString)
  {
    e.a().a("WriteMkvDataReceiver constructed");
    this.c = paramString;
  }

  private native void processEncodedData_(long paramLong1, ByteBuffer paramByteBuffer, int paramInt1, int paramInt2, long paramLong2);

  private native long start_(String paramString, ByteBuffer paramByteBuffer1, ByteBuffer paramByteBuffer2, int paramInt1, int paramInt2, double paramDouble);

  private native void stop_(long paramLong);

  public void a()
  {
    e.a().a("WriteMkvDataReceiver start");
    if (this.d != 0L)
      throw new RuntimeException("WriteMkvDataReceiver is already started");
    MediaFormat localMediaFormat = ((com.viber.voip.videoconvert.gpu.encoders.a)this.b).j();
    ByteBuffer localByteBuffer1 = localMediaFormat.getByteBuffer("csd-0");
    ByteBuffer localByteBuffer2 = localMediaFormat.getByteBuffer("csd-1");
    e.a().a("sps: " + localByteBuffer1);
    e.a().a("pps: " + localByteBuffer2);
    this.d = start_(this.c, localByteBuffer1, localByteBuffer2, this.a.b, this.a.c, (0.0D / 0.0D));
    if (this.d == 0L)
      e.a().a("WriteMkvDataReceiver failed to initialize itself");
  }

  public void a(c paramc)
  {
    e.a().a("WriteMkvDataReceiver prepare");
    super.a(paramc);
    if ((com.viber.voip.videoconvert.gpu.encoders.a)paramc == null)
      throw new RuntimeException("WriteMkvDataReceiver can work only with MediaCodecEncoder");
  }

  public void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo)
  {
    if (this.d != 0L)
    {
      processEncodedData_(this.d, paramByteBuffer, paramBufferInfo.offset, paramBufferInfo.size, paramBufferInfo.presentationTimeUs);
      return;
    }
    e.a().a("WriteMkvDataReceiver is not initialized");
  }

  public void b()
  {
    e.a().a("WriteMkvDataReceiver stop");
    if (this.d != 0L)
      stop_(this.d);
  }

  public void c()
  {
    e.a().a("WriteMkvDataReceiver release");
    if (this.d != 0L)
      this.d = 0L;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.receivers.WriteMkvDataReceiver
 * JD-Core Version:    0.6.2
 */