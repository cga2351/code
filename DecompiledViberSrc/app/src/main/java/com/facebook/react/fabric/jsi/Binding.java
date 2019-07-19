package com.facebook.react.fabric.jsi;

import android.annotation.SuppressLint;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.NativeMap;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.fabric.FabricUIManager;
import com.facebook.react.fabric.ReactNativeConfig;
import com.facebook.react.uimanager.PixelUtil;

@SuppressLint({"MissingNativeLoadLibrary"})
@DoNotStrip
public class Binding
{

  @DoNotStrip
  private final HybridData mHybridData = initHybrid();

  static
  {
    FabricSoLoader.staticInit();
  }

  private static native HybridData initHybrid();

  private native void installFabricUIManager(long paramLong, Object paramObject1, EventBeatManager paramEventBeatManager, MessageQueueThread paramMessageQueueThread, ComponentFactoryDelegate paramComponentFactoryDelegate, Object paramObject2);

  private native void uninstallFabricUIManager();

  public void register(JavaScriptContextHolder paramJavaScriptContextHolder, FabricUIManager paramFabricUIManager, EventBeatManager paramEventBeatManager, MessageQueueThread paramMessageQueueThread, ComponentFactoryDelegate paramComponentFactoryDelegate, ReactNativeConfig paramReactNativeConfig)
  {
    paramFabricUIManager.setBinding(this);
    installFabricUIManager(paramJavaScriptContextHolder.get(), paramFabricUIManager, paramEventBeatManager, paramMessageQueueThread, paramComponentFactoryDelegate, paramReactNativeConfig);
    setPixelDensity(PixelUtil.getDisplayMetricDensity());
  }

  public native void renderTemplateToSurface(int paramInt, String paramString);

  public native void setConstraints(int paramInt, float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4);

  public native void setPixelDensity(float paramFloat);

  public native void startSurface(int paramInt, NativeMap paramNativeMap);

  public native void stopSurface(int paramInt);

  public void unregister()
  {
    uninstallFabricUIManager();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.jsi.Binding
 * JD-Core Version:    0.6.2
 */