package com.facebook.react.turbomodule.core;

import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JSIModule;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.turbomodule.core.interfaces.TurboModule;
import com.facebook.soloader.SoLoader;

public class TurboModuleManager
  implements JSIModule
{

  @DoNotStrip
  private final HybridData mHybridData;
  private final ModuleProvider mModuleProvider;
  private final ReactApplicationContext mReactApplicationContext;

  static
  {
    SoLoader.loadLibrary("turbomodulejsijni");
  }

  public TurboModuleManager(ReactApplicationContext paramReactApplicationContext, JavaScriptContextHolder paramJavaScriptContextHolder, ModuleProvider paramModuleProvider)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
    MessageQueueThread localMessageQueueThread = this.mReactApplicationContext.getCatalystInstance().getReactQueueConfiguration().getJSQueueThread();
    this.mHybridData = initHybrid(paramJavaScriptContextHolder.get(), localMessageQueueThread);
    this.mModuleProvider = paramModuleProvider;
  }

  @DoNotStrip
  protected TurboModule getJavaModule(String paramString)
  {
    return this.mModuleProvider.getModule(paramString, this.mReactApplicationContext);
  }

  protected ReactApplicationContext getReactApplicationContext()
  {
    return this.mReactApplicationContext;
  }

  protected native HybridData initHybrid(long paramLong, MessageQueueThread paramMessageQueueThread);

  public void initialize()
  {
  }

  public void installBindings()
  {
    installJSIBindings();
  }

  protected native void installJSIBindings();

  public void onCatalystInstanceDestroy()
  {
  }

  public static abstract interface ModuleProvider
  {
    public abstract TurboModule getModule(String paramString, ReactApplicationContext paramReactApplicationContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.turbomodule.core.TurboModuleManager
 * JD-Core Version:    0.6.2
 */