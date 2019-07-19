package org.webrtc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;

public class DefaultVideoEncoderFactory
  implements VideoEncoderFactory
{
  private final VideoEncoderFactory hardwareVideoEncoderFactory;
  private final VideoEncoderFactory softwareVideoEncoderFactory = new SoftwareVideoEncoderFactory();

  public DefaultVideoEncoderFactory(EglBase.Context paramContext, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.hardwareVideoEncoderFactory = new HardwareVideoEncoderFactory(paramContext, paramBoolean1, paramBoolean2);
  }

  DefaultVideoEncoderFactory(VideoEncoderFactory paramVideoEncoderFactory)
  {
    this.hardwareVideoEncoderFactory = paramVideoEncoderFactory;
  }

  @Nullable
  public VideoEncoder createEncoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoEncoder localVideoEncoder = this.softwareVideoEncoderFactory.createEncoder(paramVideoCodecInfo);
    Object localObject = this.hardwareVideoEncoderFactory.createEncoder(paramVideoCodecInfo);
    if ((localObject != null) && (localVideoEncoder != null))
      localObject = new VideoEncoderFallback(localVideoEncoder, (VideoEncoder)localObject);
    while (localObject != null)
      return localObject;
    return localVideoEncoder;
  }

  public VideoCodecInfo[] getSupportedCodecs()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(Arrays.asList(this.softwareVideoEncoderFactory.getSupportedCodecs()));
    localLinkedHashSet.addAll(Arrays.asList(this.hardwareVideoEncoderFactory.getSupportedCodecs()));
    return (VideoCodecInfo[])localLinkedHashSet.toArray(new VideoCodecInfo[localLinkedHashSet.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.DefaultVideoEncoderFactory
 * JD-Core Version:    0.6.2
 */