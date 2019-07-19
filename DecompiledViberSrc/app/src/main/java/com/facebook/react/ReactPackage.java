package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.uimanager.ViewManager;
import java.util.List;
import javax.annotation.Nonnull;

public abstract interface ReactPackage
{
  @Nonnull
  public abstract List<NativeModule> createNativeModules(@Nonnull ReactApplicationContext paramReactApplicationContext);

  @Nonnull
  public abstract List<ViewManager> createViewManagers(@Nonnull ReactApplicationContext paramReactApplicationContext);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactPackage
 * JD-Core Version:    0.6.2
 */