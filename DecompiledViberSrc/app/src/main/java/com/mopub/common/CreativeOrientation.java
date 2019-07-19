package com.mopub.common;

public enum CreativeOrientation
{
  static
  {
    LANDSCAPE = new CreativeOrientation("LANDSCAPE", 1);
    DEVICE = new CreativeOrientation("DEVICE", 2);
    CreativeOrientation[] arrayOfCreativeOrientation = new CreativeOrientation[3];
    arrayOfCreativeOrientation[0] = PORTRAIT;
    arrayOfCreativeOrientation[1] = LANDSCAPE;
    arrayOfCreativeOrientation[2] = DEVICE;
  }

  public static CreativeOrientation fromString(String paramString)
  {
    if ("l".equalsIgnoreCase(paramString))
      return LANDSCAPE;
    if ("p".equalsIgnoreCase(paramString))
      return PORTRAIT;
    return DEVICE;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.common.CreativeOrientation
 * JD-Core Version:    0.6.2
 */