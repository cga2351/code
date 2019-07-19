package org.webrtc;

import java.io.IOException;

abstract interface MediaCodecWrapperFactory
{
  public abstract MediaCodecWrapper createByCodecName(String paramString)
    throws IOException;
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.MediaCodecWrapperFactory
 * JD-Core Version:    0.6.2
 */