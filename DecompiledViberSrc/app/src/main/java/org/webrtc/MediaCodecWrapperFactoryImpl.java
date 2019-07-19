package org.webrtc;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCodec.BufferInfo;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Bundle;
import android.view.Surface;
import java.io.IOException;
import java.nio.ByteBuffer;

class MediaCodecWrapperFactoryImpl
  implements MediaCodecWrapperFactory
{
  public MediaCodecWrapper createByCodecName(String paramString)
    throws IOException
  {
    return new MediaCodecWrapperImpl(MediaCodec.createByCodecName(paramString));
  }

  private static class MediaCodecWrapperImpl
    implements MediaCodecWrapper
  {
    private final MediaCodec mediaCodec;

    public MediaCodecWrapperImpl(MediaCodec paramMediaCodec)
    {
      this.mediaCodec = paramMediaCodec;
    }

    public void configure(MediaFormat paramMediaFormat, Surface paramSurface, MediaCrypto paramMediaCrypto, int paramInt)
    {
      this.mediaCodec.configure(paramMediaFormat, paramSurface, paramMediaCrypto, paramInt);
    }

    @TargetApi(18)
    public Surface createInputSurface()
    {
      return this.mediaCodec.createInputSurface();
    }

    public int dequeueInputBuffer(long paramLong)
    {
      return this.mediaCodec.dequeueInputBuffer(paramLong);
    }

    public int dequeueOutputBuffer(MediaCodec.BufferInfo paramBufferInfo, long paramLong)
    {
      return this.mediaCodec.dequeueOutputBuffer(paramBufferInfo, paramLong);
    }

    public void flush()
    {
      this.mediaCodec.flush();
    }

    public ByteBuffer[] getInputBuffers()
    {
      return this.mediaCodec.getInputBuffers();
    }

    public ByteBuffer[] getOutputBuffers()
    {
      return this.mediaCodec.getOutputBuffers();
    }

    public MediaFormat getOutputFormat()
    {
      return this.mediaCodec.getOutputFormat();
    }

    public void queueInputBuffer(int paramInt1, int paramInt2, int paramInt3, long paramLong, int paramInt4)
    {
      this.mediaCodec.queueInputBuffer(paramInt1, paramInt2, paramInt3, paramLong, paramInt4);
    }

    public void release()
    {
      this.mediaCodec.release();
    }

    public void releaseOutputBuffer(int paramInt, boolean paramBoolean)
    {
      this.mediaCodec.releaseOutputBuffer(paramInt, paramBoolean);
    }

    @TargetApi(19)
    public void setParameters(Bundle paramBundle)
    {
      this.mediaCodec.setParameters(paramBundle);
    }

    public void start()
    {
      this.mediaCodec.start();
    }

    public void stop()
    {
      this.mediaCodec.stop();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaCodecWrapperFactoryImpl
 * JD-Core Version:    0.6.2
 */