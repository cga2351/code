package com.facebook.react.views.scroll;

import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.ThemedReactContext;
import com.facebook.react.uimanager.ViewGroupManager;

@ReactModule(name="AndroidHorizontalScrollContentView")
public class ReactHorizontalScrollContainerViewManager extends ViewGroupManager<ReactHorizontalScrollContainerView>
{
  public static final String REACT_CLASS = "AndroidHorizontalScrollContentView";

  public ReactHorizontalScrollContainerView createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new ReactHorizontalScrollContainerView(paramThemedReactContext);
  }

  public String getName()
  {
    return "AndroidHorizontalScrollContentView";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.scroll.ReactHorizontalScrollContainerViewManager
 * JD-Core Version:    0.6.2
 */