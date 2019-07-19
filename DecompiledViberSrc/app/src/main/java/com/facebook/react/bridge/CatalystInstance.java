package com.facebook.react.bridge;

import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.common.annotations.VisibleForTesting;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nullable;

@DoNotStrip
public abstract interface CatalystInstance extends JSBundleLoaderDelegate, JSInstance, MemoryPressureListener
{
  public abstract void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener);

  public abstract void addJSIModules(List<JSIModuleSpec> paramList);

  @DoNotStrip
  public abstract void callFunction(String paramString1, String paramString2, NativeArray paramNativeArray);

  public abstract void destroy();

  public abstract void extendNativeModules(NativeModuleRegistry paramNativeModuleRegistry);

  public abstract <T extends JSIModule> T getJSIModule(Class<T> paramClass);

  public abstract <T extends JavaScriptModule> T getJSModule(Class<T> paramClass);

  public abstract JavaScriptContextHolder getJavaScriptContextHolder();

  public abstract <T extends NativeModule> T getNativeModule(Class<T> paramClass);

  public abstract NativeModule getNativeModule(String paramString);

  public abstract Collection<NativeModule> getNativeModules();

  public abstract ReactQueueConfiguration getReactQueueConfiguration();

  @Nullable
  public abstract String getSourceURL();

  public abstract <T extends NativeModule> boolean hasNativeModule(Class<T> paramClass);

  public abstract boolean hasRunJSBundle();

  @VisibleForTesting
  public abstract void initialize();

  @DoNotStrip
  public abstract void invokeCallback(int paramInt, NativeArrayInterface paramNativeArrayInterface);

  public abstract boolean isDestroyed();

  public abstract void registerSegment(int paramInt, String paramString);

  public abstract void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener);

  public abstract void runJSBundle();

  @VisibleForTesting
  public abstract void setGlobalVariable(String paramString1, String paramString2);
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CatalystInstance
 * JD-Core Version:    0.6.2
 */