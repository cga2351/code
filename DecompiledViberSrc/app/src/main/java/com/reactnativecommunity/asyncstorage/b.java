package com.reactnativecommunity.asyncstorage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public class b
{
  static WritableMap a(@Nullable String paramString)
  {
    return a(paramString, "Invalid key");
  }

  static WritableMap a(@Nullable String paramString1, String paramString2)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("message", paramString2);
    if (paramString1 != null)
      localWritableMap.putString("key", paramString1);
    return localWritableMap;
  }

  static WritableMap b(@Nullable String paramString)
  {
    return a(paramString, "Invalid Value");
  }

  static WritableMap c(@Nullable String paramString)
  {
    return a(paramString, "Database Error");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.asyncstorage.b
 * JD-Core Version:    0.6.2
 */