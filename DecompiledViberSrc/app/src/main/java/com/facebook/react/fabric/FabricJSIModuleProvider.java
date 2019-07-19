package com.facebook.react.fabric;

import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.JSIModuleProvider;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.fabric.jsi.Binding;
import com.facebook.react.fabric.jsi.ComponentFactoryDelegate;
import com.facebook.react.fabric.jsi.ComponentRegistry;
import com.facebook.react.fabric.jsi.EventBeatManager;
import com.facebook.react.fabric.jsi.EventEmitterWrapper;
import com.facebook.react.fabric.jsi.FabricSoLoader;
import com.facebook.react.fabric.mounting.ContextBasedViewPool;
import com.facebook.react.fabric.mounting.LayoutMetricsConversions;
import com.facebook.react.fabric.mounting.MountingManager;
import com.facebook.react.fabric.mounting.ViewPool;
import com.facebook.react.fabric.mounting.mountitems.BatchMountItem;
import com.facebook.react.fabric.mounting.mountitems.CreateMountItem;
import com.facebook.react.fabric.mounting.mountitems.DeleteMountItem;
import com.facebook.react.fabric.mounting.mountitems.DispatchCommandMountItem;
import com.facebook.react.fabric.mounting.mountitems.InsertMountItem;
import com.facebook.react.fabric.mounting.mountitems.MountItem;
import com.facebook.react.fabric.mounting.mountitems.PreAllocateViewMountItem;
import com.facebook.react.fabric.mounting.mountitems.RemoveMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateEventEmitterMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLayoutMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdateLocalDataMountItem;
import com.facebook.react.fabric.mounting.mountitems.UpdatePropsMountItem;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.systrace.Systrace;

public class FabricJSIModuleProvider
  implements JSIModuleProvider<UIManager>
{
  private final ComponentFactoryDelegate mComponentFactoryDelegate;
  private final ReactNativeConfig mConfig;
  private final JavaScriptContextHolder mJSContext;
  private final ReactApplicationContext mReactApplicationContext;

  public FabricJSIModuleProvider(ReactApplicationContext paramReactApplicationContext, JavaScriptContextHolder paramJavaScriptContextHolder, ComponentFactoryDelegate paramComponentFactoryDelegate, ReactNativeConfig paramReactNativeConfig)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mJSContext = paramJavaScriptContextHolder;
    this.mComponentFactoryDelegate = paramComponentFactoryDelegate;
    this.mConfig = paramReactNativeConfig;
  }

  private FabricUIManager createUIManager(EventBeatManager paramEventBeatManager)
  {
    Systrace.beginSection(0L, "FabricJSIModuleProvider.createUIManager");
    UIManagerModule localUIManagerModule = (UIManagerModule)this.mReactApplicationContext.getNativeModule(UIManagerModule.class);
    EventDispatcher localEventDispatcher = localUIManagerModule.getEventDispatcher();
    FabricUIManager localFabricUIManager = new FabricUIManager(this.mReactApplicationContext, localUIManagerModule.getViewManagerRegistry_DO_NOT_USE(), localEventDispatcher, paramEventBeatManager);
    Systrace.endSection(0L);
    return localFabricUIManager;
  }

  private static void loadClasses()
  {
    FabricEventEmitter.class.getClass();
    FabricUIManager.class.getClass();
    GuardedFrameCallback.class.getClass();
    BatchMountItem.class.getClass();
    CreateMountItem.class.getClass();
    DeleteMountItem.class.getClass();
    DispatchCommandMountItem.class.getClass();
    InsertMountItem.class.getClass();
    MountItem.class.getClass();
    RemoveMountItem.class.getClass();
    UpdateEventEmitterMountItem.class.getClass();
    UpdateLayoutMountItem.class.getClass();
    UpdateLocalDataMountItem.class.getClass();
    UpdatePropsMountItem.class.getClass();
    ContextBasedViewPool.class.getClass();
    LayoutMetricsConversions.class.getClass();
    MountingManager.class.getClass();
    ViewPool.class.getClass();
    Binding.class.getClass();
    ComponentFactoryDelegate.class.getClass();
    ComponentRegistry.class.getClass();
    EventBeatManager.class.getClass();
    EventEmitterWrapper.class.getClass();
    FabricSoLoader.class.getClass();
    PreAllocateViewMountItem.class.getClass();
  }

  public UIManager get()
  {
    EventBeatManager localEventBeatManager = new EventBeatManager(this.mJSContext, this.mReactApplicationContext);
    FabricUIManager localFabricUIManager = createUIManager(localEventBeatManager);
    Systrace.beginSection(0L, "FabricJSIModuleProvider.registerBinding");
    Binding localBinding = new Binding();
    loadClasses();
    MessageQueueThread localMessageQueueThread = this.mReactApplicationContext.getCatalystInstance().getReactQueueConfiguration().getJSQueueThread();
    localBinding.register(this.mJSContext, localFabricUIManager, localEventBeatManager, localMessageQueueThread, this.mComponentFactoryDelegate, this.mConfig);
    Systrace.endSection(0L);
    return localFabricUIManager;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.fabric.FabricJSIModuleProvider
 * JD-Core Version:    0.6.2
 */