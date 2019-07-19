package com.facebook.react.modules.common;

import com.facebook.common.logging.FLog;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.NativeModule;
import java.util.Collection;
import java.util.Iterator;

public class ModuleDataCleaner
{
  public static void cleanDataFromModules(CatalystInstance paramCatalystInstance)
  {
    Iterator localIterator = paramCatalystInstance.getNativeModules().iterator();
    while (localIterator.hasNext())
    {
      NativeModule localNativeModule = (NativeModule)localIterator.next();
      if ((localNativeModule instanceof Cleanable))
      {
        FLog.d("ReactNative", "Cleaning data from " + localNativeModule.getName());
        ((Cleanable)localNativeModule).clearSensitiveData();
      }
    }
  }

  public static abstract interface Cleanable
  {
    public abstract void clearSensitiveData();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.common.ModuleDataCleaner
 * JD-Core Version:    0.6.2
 */