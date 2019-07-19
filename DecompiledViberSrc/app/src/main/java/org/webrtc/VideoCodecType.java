package org.webrtc;

 enum VideoCodecType
{
  private final String mimeType;

  static
  {
    H264 = new VideoCodecType("H264", 2, "video/avc");
    VideoCodecType[] arrayOfVideoCodecType = new VideoCodecType[3];
    arrayOfVideoCodecType[0] = VP8;
    arrayOfVideoCodecType[1] = VP9;
    arrayOfVideoCodecType[2] = H264;
  }

  private VideoCodecType(String paramString)
  {
    this.mimeType = paramString;
  }

  String mimeType()
  {
    return this.mimeType;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     org.webrtc.VideoCodecType
 * JD-Core Version:    0.6.2
 */