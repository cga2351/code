package com.facebook.react.bridge;

import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import javax.annotation.Nullable;

public abstract interface UIManager extends JSIModule, PerformanceCounter
{
  public abstract <T extends SizeMonitoringFrameLayout,  extends MeasureSpecProvider> int addRootView(T paramT, WritableMap paramWritableMap, @Nullable String paramString);

  public abstract void clearJSResponder();

  public abstract void dispatchCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray);

  public abstract void removeRootView(int paramInt);

  public abstract void setJSResponder(int paramInt, boolean paramBoolean);

  public abstract void updateRootLayoutSpecs(int paramInt1, int paramInt2, int paramInt3);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.UIManager
 * JD-Core Version:    0.6.2
 */