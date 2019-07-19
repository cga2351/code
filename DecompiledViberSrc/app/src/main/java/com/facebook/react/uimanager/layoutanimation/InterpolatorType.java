package com.facebook.react.uimanager.layoutanimation;

import java.util.Locale;

 enum InterpolatorType
{
  static
  {
    EASE_IN = new InterpolatorType("EASE_IN", 1);
    EASE_OUT = new InterpolatorType("EASE_OUT", 2);
    EASE_IN_EASE_OUT = new InterpolatorType("EASE_IN_EASE_OUT", 3);
    SPRING = new InterpolatorType("SPRING", 4);
    InterpolatorType[] arrayOfInterpolatorType = new InterpolatorType[5];
    arrayOfInterpolatorType[0] = LINEAR;
    arrayOfInterpolatorType[1] = EASE_IN;
    arrayOfInterpolatorType[2] = EASE_OUT;
    arrayOfInterpolatorType[3] = EASE_IN_EASE_OUT;
    arrayOfInterpolatorType[4] = SPRING;
  }

  public static InterpolatorType fromString(String paramString)
  {
    String str = paramString.toLowerCase(Locale.US);
    int i = -1;
    switch (str.hashCode())
    {
    default:
    case -1102672091:
    case -1310315117:
    case -1965056864:
    case 1164546989:
    case -895679987:
    }
    while (true)
      switch (i)
      {
      default:
        throw new IllegalArgumentException("Unsupported interpolation type : " + paramString);
        if (str.equals("linear"))
        {
          i = 0;
          continue;
          if (str.equals("easein"))
          {
            i = 1;
            continue;
            if (str.equals("easeout"))
            {
              i = 2;
              continue;
              if (str.equals("easeineaseout"))
              {
                i = 3;
                continue;
                if (str.equals("spring"))
                  i = 4;
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      }
    return LINEAR;
    return EASE_IN;
    return EASE_OUT;
    return EASE_IN_EASE_OUT;
    return SPRING;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.layoutanimation.InterpolatorType
 * JD-Core Version:    0.6.2
 */