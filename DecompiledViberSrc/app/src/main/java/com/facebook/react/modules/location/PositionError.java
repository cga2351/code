package com.facebook.react.modules.location;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;

public class PositionError
{
  public static int PERMISSION_DENIED = 1;
  public static int POSITION_UNAVAILABLE = 2;
  public static int TIMEOUT = 3;

  public static WritableMap buildError(int paramInt, String paramString)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putInt("code", paramInt);
    if (paramString != null)
      localWritableMap.putString("message", paramString);
    localWritableMap.putInt("PERMISSION_DENIED", PERMISSION_DENIED);
    localWritableMap.putInt("POSITION_UNAVAILABLE", POSITION_UNAVAILABLE);
    localWritableMap.putInt("TIMEOUT", TIMEOUT);
    return localWritableMap;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.location.PositionError
 * JD-Core Version:    0.6.2
 */