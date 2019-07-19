package com.viber.voip.videoconvert.gpu.receivers;

import android.media.MediaCodec.BufferInfo;
import com.viber.voip.videoconvert.gpu.encoders.c;
import java.nio.ByteBuffer;

public abstract interface b
{
  public abstract void a();

  public abstract void a(c paramc);

  public abstract void a(ByteBuffer paramByteBuffer, MediaCodec.BufferInfo paramBufferInfo);

  public abstract void b();

  public abstract void c();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.videoconvert.gpu.receivers.b
 * JD-Core Version:    0.6.2
 */