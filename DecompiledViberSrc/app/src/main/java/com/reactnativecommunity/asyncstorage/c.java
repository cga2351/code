package com.reactnativecommunity.asyncstorage;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class c
  implements ReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    NativeModule[] arrayOfNativeModule = new NativeModule[1];
    arrayOfNativeModule[0] = new AsyncStorageModule(paramReactApplicationContext);
    return Arrays.asList(arrayOfNativeModule);
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.reactnativecommunity.asyncstorage.c
 * JD-Core Version:    0.6.2
 */