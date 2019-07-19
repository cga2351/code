package com.facebook.react.uimanager;

import android.view.ViewGroup;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;

public class RootViewManager extends ViewGroupManager<ViewGroup>
{
  public static final String REACT_CLASS = "RootView";

  protected ViewGroup createViewInstance(ThemedReactContext paramThemedReactContext)
  {
    return new SizeMonitoringFrameLayout(paramThemedReactContext);
  }

  public String getName()
  {
    return "RootView";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.RootViewManager
 * JD-Core Version:    0.6.2
 */