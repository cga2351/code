package com.facebook.react.uimanager;

import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.uimanager.common.ViewUtil;

public class UIManagerHelper
{
  public static UIManager getUIManager(ReactContext paramReactContext, int paramInt)
  {
    CatalystInstance localCatalystInstance = paramReactContext.getCatalystInstance();
    if (paramInt == 2)
      return (UIManager)localCatalystInstance.getJSIModule(UIManager.class);
    return (UIManager)localCatalystInstance.getNativeModule(UIManagerModule.class);
  }

  public static UIManager getUIManagerForReactTag(ReactContext paramReactContext, int paramInt)
  {
    return getUIManager(paramReactContext, ViewUtil.getUIManagerType(paramInt));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIManagerHelper
 * JD-Core Version:    0.6.2
 */