package com.yandex.mobile.ads.video;

import com.yandex.mobile.ads.impl.py;
import com.yandex.mobile.ads.impl.pz;

public class VideoAdError
{
  private final int a;
  private final String b;
  private final String c;

  private VideoAdError(int paramInt, String paramString)
  {
    this(paramInt, paramString, null);
  }

  private VideoAdError(int paramInt, String paramString1, String paramString2)
  {
    this.a = paramInt;
    this.b = paramString1;
    this.c = paramString2;
  }

  public static VideoAdError createConnectionError(String paramString)
  {
    return new VideoAdError(2, paramString);
  }

  public static VideoAdError createInternalError(pz parampz)
  {
    return new VideoAdError(1, "Internal error. Failed to parse response\n " + parampz.a());
  }

  public static VideoAdError createInternalError(String paramString)
  {
    return new VideoAdError(1, paramString);
  }

  public static final VideoAdError createNoAdError(py parampy)
  {
    return new VideoAdError(3, parampy.getMessage(), parampy.a());
  }

  public static VideoAdError createRetriableError(String paramString)
  {
    return new VideoAdError(4, paramString);
  }

  public int getCode()
  {
    return this.a;
  }

  public String getDescription()
  {
    return this.b;
  }

  public String getRawResponse()
  {
    return this.c;
  }

  public static abstract interface Code
  {
    public static final int CONNECTION_ERROR = 2;
    public static final int INTERNAL_ERROR = 1;
    public static final int NO_AD_ERROR = 3;
    public static final int RETRIABLE_ERROR = 4;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.video.VideoAdError
 * JD-Core Version:    0.6.2
 */