package org.webrtc;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;

public class SoftwareVideoDecoderFactory
  implements VideoDecoderFactory
{
  static VideoCodecInfo[] supportedCodecs()
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(new VideoCodecInfo("VP8", new HashMap()));
    if (VP9Decoder.nativeIsSupported())
      localArrayList.add(new VideoCodecInfo("VP9", new HashMap()));
    return (VideoCodecInfo[])localArrayList.toArray(new VideoCodecInfo[localArrayList.size()]);
  }

  @Deprecated
  @Nullable
  public VideoDecoder createDecoder(String paramString)
  {
    return createDecoder(new VideoCodecInfo(paramString, new HashMap()));
  }

  @Nullable
  public VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo)
  {
    if (paramVideoCodecInfo.getName().equalsIgnoreCase("VP8"))
      return new VP8Decoder();
    if ((paramVideoCodecInfo.getName().equalsIgnoreCase("VP9")) && (VP9Decoder.nativeIsSupported()))
      return new VP9Decoder();
    return null;
  }

  public VideoCodecInfo[] getSupportedCodecs()
  {
    return supportedCodecs();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.SoftwareVideoDecoderFactory
 * JD-Core Version:    0.6.2
 */