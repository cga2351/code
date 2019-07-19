package com.swmansion.gesturehandler.react;

import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="GestureHandlerRootView")
public class RNGestureHandlerRootViewManager extends ViewGroupManager<h>
{
  public static final String REACT_CLASS = "GestureHandlerRootView";

  protected h createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new h(paramThemedReactContext);
  }

  @Nullable
  public Map getExportedCustomDirectEventTypeConstants()
  {
    return MapBuilder.of("onGestureHandlerEvent", MapBuilder.of("registrationName", "onGestureHandlerEvent"), "onGestureHandlerStateChange", MapBuilder.of("registrationName", "onGestureHandlerStateChange"));
  }

  public String getName()
  {
    return "GestureHandlerRootView";
  }

  public void onDropViewInstance(h paramh)
  {
    paramh.a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.swmansion.gesturehandler.react.RNGestureHandlerRootViewManager
 * JD-Core Version:    0.6.2
 */