package com.facebook.react;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;
import javax.annotation.Nullable;

public abstract interface ViewManagerOnDemandReactPackage
{
  @Nullable
  public abstract ViewManager createViewManager(ReactApplicationContext paramReactApplicationContext, String paramString);

  @Nullable
  public abstract List<String> getViewManagerNames(ReactApplicationContext paramReactApplicationContext);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ViewManagerOnDemandReactPackage
 * JD-Core Version:    0.6.2
 */