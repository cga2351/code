package com.facebook.react.modules.storage;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.WritableMap;
import javax.annotation.Nullable;

public class AsyncStorageErrorUtil
{
  static WritableMap getDBError(@Nullable String paramString)
  {
    return getError(paramString, "Database Error");
  }

  static WritableMap getError(@Nullable String paramString1, String paramString2)
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("message", paramString2);
    if (paramString1 != null)
      localWritableMap.putString("key", paramString1);
    return localWritableMap;
  }

  static WritableMap getInvalidKeyError(@Nullable String paramString)
  {
    return getError(paramString, "Invalid key");
  }

  static WritableMap getInvalidValueError(@Nullable String paramString)
  {
    return getError(paramString, "Invalid Value");
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.storage.AsyncStorageErrorUtil
 * JD-Core Version:    0.6.2
 */