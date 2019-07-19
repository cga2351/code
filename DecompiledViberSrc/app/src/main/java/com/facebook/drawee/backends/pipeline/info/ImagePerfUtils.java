package com.facebook.drawee.backends.pipeline.info;

public class ImagePerfUtils
{
  public static String toString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "unknown";
    case 0:
      return "requested";
    case 1:
      return "origin_available";
    case 3:
      return "success";
    case 4:
      return "canceled";
    case 2:
      return "intermediate_available";
    case 5:
    }
    return "error";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.info.ImagePerfUtils
 * JD-Core Version:    0.6.2
 */