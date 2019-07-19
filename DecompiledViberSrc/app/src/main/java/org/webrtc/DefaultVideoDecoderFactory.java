package org.webrtc;

import java.util.Arrays;
import java.util.LinkedHashSet;
import javax.annotation.Nullable;

public class DefaultVideoDecoderFactory
  implements VideoDecoderFactory
{
  private final VideoDecoderFactory hardwareVideoDecoderFactory;
  private final VideoDecoderFactory softwareVideoDecoderFactory = new SoftwareVideoDecoderFactory();

  public DefaultVideoDecoderFactory(EglBase.Context paramContext)
  {
    this.hardwareVideoDecoderFactory = new HardwareVideoDecoderFactory(paramContext);
  }

  DefaultVideoDecoderFactory(VideoDecoderFactory paramVideoDecoderFactory)
  {
    this.hardwareVideoDecoderFactory = paramVideoDecoderFactory;
  }

  public VideoDecoder createDecoder(String paramString)
  {
    return VideoDecoderFactory..CC.createDecoder(this, paramString);
  }

  @Nullable
  public VideoDecoder createDecoder(VideoCodecInfo paramVideoCodecInfo)
  {
    VideoDecoder localVideoDecoder = this.softwareVideoDecoderFactory.createDecoder(paramVideoCodecInfo);
    Object localObject = this.hardwareVideoDecoderFactory.createDecoder(paramVideoCodecInfo);
    if ((localObject != null) && (localVideoDecoder != null))
      localObject = new VideoDecoderFallback(localVideoDecoder, (VideoDecoder)localObject);
    while (localObject != null)
      return localObject;
    return localVideoDecoder;
  }

  public VideoCodecInfo[] getSupportedCodecs()
  {
    LinkedHashSet localLinkedHashSet = new LinkedHashSet();
    localLinkedHashSet.addAll(Arrays.asList(this.softwareVideoDecoderFactory.getSupportedCodecs()));
    localLinkedHashSet.addAll(Arrays.asList(this.hardwareVideoDecoderFactory.getSupportedCodecs()));
    return (VideoCodecInfo[])localLinkedHashSet.toArray(new VideoCodecInfo[localLinkedHashSet.size()]);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.DefaultVideoDecoderFactory
 * JD-Core Version:    0.6.2
 */