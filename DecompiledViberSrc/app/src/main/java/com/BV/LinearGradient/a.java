package com.BV.LinearGradient;

import com.facebook.react.ReactPackage;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class a
  implements ReactPackage
{
  public List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    ViewManager[] arrayOfViewManager = new ViewManager[1];
    arrayOfViewManager[0] = new LinearGradientManager();
    return Arrays.asList(arrayOfViewManager);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.BV.LinearGradient.a
 * JD-Core Version:    0.6.2
 */