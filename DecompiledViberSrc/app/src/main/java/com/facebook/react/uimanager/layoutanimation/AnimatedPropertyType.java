package com.facebook.react.uimanager.layoutanimation;

 enum AnimatedPropertyType
{
  static
  {
    SCALE_XY = new AnimatedPropertyType("SCALE_XY", 3);
    AnimatedPropertyType[] arrayOfAnimatedPropertyType = new AnimatedPropertyType[4];
    arrayOfAnimatedPropertyType[0] = OPACITY;
    arrayOfAnimatedPropertyType[1] = SCALE_X;
    arrayOfAnimatedPropertyType[2] = SCALE_Y;
    arrayOfAnimatedPropertyType[3] = SCALE_XY;
  }

  public static AnimatedPropertyType fromString(String paramString)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -1267206133:
    case -908189618:
    case -908189617:
    case 1910893003:
    }
    while (true)
      switch (i)
      {
      default:
        throw new IllegalArgumentException("Unsupported animated property: " + paramString);
        if (paramString.equals("opacity"))
        {
          i = 0;
          continue;
          if (paramString.equals("scaleX"))
          {
            i = 1;
            continue;
            if (paramString.equals("scaleY"))
            {
              i = 2;
              continue;
              if (paramString.equals("scaleXY"))
                i = 3;
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      }
    return OPACITY;
    return SCALE_X;
    return SCALE_Y;
    return SCALE_XY;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.AnimatedPropertyType
 * JD-Core Version:    0.6.2
 */