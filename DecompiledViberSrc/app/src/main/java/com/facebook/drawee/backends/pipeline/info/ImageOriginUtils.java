package com.facebook.drawee.backends.pipeline.info;

public class ImageOriginUtils
{
  public static int mapProducerNameToImageOrigin(String paramString)
  {
    int i = 3;
    label56: int j;
    switch (paramString.hashCode())
    {
    default:
      j = -1;
    case -1914072202:
    case 957714404:
    case -1307634203:
    case 656304759:
    case -1224383234:
    }
    while (true)
      switch (j)
      {
      default:
        i = -1;
      case 0:
      case 1:
        return i;
        if (!paramString.equals("BitmapMemoryCacheGetProducer"))
          break label56;
        j = 0;
        continue;
        if (!paramString.equals("BitmapMemoryCacheProducer"))
          break label56;
        j = 1;
        continue;
        if (!paramString.equals("EncodedMemoryCacheProducer"))
          break label56;
        j = 2;
        continue;
        if (!paramString.equals("DiskCacheProducer"))
          break label56;
        j = i;
        continue;
        if (!paramString.equals("NetworkFetchProducer"))
          break label56;
        j = 4;
      case 2:
      case 3:
      case 4:
      }
    return 2;
    return 1;
    return 0;
  }

  public static String toString(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return "unknown";
    case 0:
      return "network";
    case 1:
      return "disk";
    case 2:
      return "memory_encoded";
    case 3:
    }
    return "memory_bitmap";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.drawee.backends.pipeline.info.ImageOriginUtils
 * JD-Core Version:    0.6.2
 */