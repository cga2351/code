package com.facebook.react.uimanager;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.events.EventDispatcher;
import java.util.List;

@Deprecated
public class UIImplementationProvider
{
  public UIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, UIManagerModule.ViewManagerResolver paramViewManagerResolver, EventDispatcher paramEventDispatcher, int paramInt)
  {
    return new UIImplementation(paramReactApplicationContext, paramViewManagerResolver, paramEventDispatcher, paramInt);
  }

  UIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, ViewManagerRegistry paramViewManagerRegistry, EventDispatcher paramEventDispatcher, int paramInt)
  {
    return new UIImplementation(paramReactApplicationContext, paramViewManagerRegistry, paramEventDispatcher, paramInt);
  }

  public UIImplementation createUIImplementation(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, EventDispatcher paramEventDispatcher, int paramInt)
  {
    return new UIImplementation(paramReactApplicationContext, paramList, paramEventDispatcher, paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIImplementationProvider
 * JD-Core Version:    0.6.2
 */