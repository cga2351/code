package org.webrtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;

public class SoftwareVideoEncoderFactory
  implements VideoEncoderFactory
{
  static VideoCodecInfo[] supportedCodecs()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoCodecInfo("VP8", new HashMap()));
    if (VP9Encoder.nativeIsSupported())
      localArrayList.add(new VideoCodecInfo("VP9", new HashMap()));
    return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
  }

  @Nullable
  public VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo)
  {
    if (paramVideoCodecInfo.name.equalsIgnoreCase("VP8"))
      return new VP8Encoder();
    if ((paramVideoCodecInfo.name.equalsIgnoreCase("VP9")) && (VP9Encoder.nativeIsSupported()))
      return new VP9Encoder();
    return null;
  }

  public VideoCodecInfo[] getSupportedCodecs()
  {
    return supportedCodecs();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SoftwareVideoEncoderFactory
 * JD-Core Version:    0.6.2
 */