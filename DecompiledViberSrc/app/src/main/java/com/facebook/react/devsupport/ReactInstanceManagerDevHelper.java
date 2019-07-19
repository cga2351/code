package com.facebook.react.devsupport;

import android.app.Activity;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.NativeDeltaClient;
import javax.annotation.Nullable;

public abstract interface ReactInstanceManagerDevHelper
{
  @Nullable
  public abstract Activity getCurrentActivity();

  public abstract void onJSBundleLoadedFromServer(@Nullable NativeDeltaClient paramNativeDeltaClient);

  public abstract void onReloadWithJSDebugger(JavaJSExecutor.Factory paramFactory);

  public abstract void toggleElementInspector();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.devsupport.ReactInstanceManagerDevHelper
 * JD-Core Version:    0.6.2
 */