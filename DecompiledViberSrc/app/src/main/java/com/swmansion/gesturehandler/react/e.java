package com.swmansion.gesturehandler.react;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.List;

public class e
  implements ReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    NativeModule[] arrayOfNativeModule = new NativeModule[1];
    arrayOfNativeModule[0] = new RNGestureHandlerModule(paramReactApplicationContext);
    return Arrays.asList(arrayOfNativeModule);
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    ViewManager[] arrayOfViewManager = new ViewManager[2];
    arrayOfViewManager[0] = new RNGestureHandlerRootViewManager();
    arrayOfViewManager[1] = new RNGestureHandlerButtonViewManager();
    return Arrays.asList(arrayOfViewManager);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.e
 * JD-Core Version:    0.6.2
 */