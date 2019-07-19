package com.facebook.react.uimanager;

import android.content.ComponentCallbacks2;
import android.content.res.Configuration;
import android.media.AudioManager;
import android.util.ArrayMap;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.react.animation.Animation;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.GuardedRunnable;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.OnBatchCompleteListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.ReadableArray;
import com.facebook.react.bridge.ReadableMap;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.common.ClearableSynchronizedPool;
import com.facebook.react.common.MapBuilder;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.uimanager.common.MeasureSpecProvider;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout;
import com.facebook.react.uimanager.common.SizeMonitoringFrameLayout.OnSizeChangedListener;
import com.facebook.react.uimanager.common.ViewUtil;
import com.facebook.react.uimanager.debug.NotThreadSafeViewHierarchyUpdateDebugListener;
import com.facebook.react.uimanager.events.EventDispatcher;
import com.facebook.react.uimanager.events.RCTEventEmitter;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="UIManager")
public class UIManagerModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener, OnBatchCompleteListener, UIManager
{
  private static final boolean DEBUG = false;
  public static final String NAME = "UIManager";
  private int mBatchId = 0;
  private final Map<String, Object> mCustomDirectEvents;
  private final EventDispatcher mEventDispatcher;
  private final List<UIManagerModuleListener> mListeners = new ArrayList();
  private final MemoryTrimCallback mMemoryTrimCallback = new MemoryTrimCallback(null);
  private final Map<String, Object> mModuleConstants;
  private final UIImplementation mUIImplementation;

  @Nullable
  private Map<String, WritableMap> mViewManagerConstantsCache;
  private volatile int mViewManagerConstantsCacheSize;
  private final ViewManagerRegistry mViewManagerRegistry;

  public UIManagerModule(ReactApplicationContext paramReactApplicationContext, ViewManagerResolver paramViewManagerResolver, int paramInt)
  {
    this(paramReactApplicationContext, paramViewManagerResolver, new UIImplementationProvider(), paramInt);
  }

  @Deprecated
  public UIManagerModule(ReactApplicationContext paramReactApplicationContext, ViewManagerResolver paramViewManagerResolver, UIImplementationProvider paramUIImplementationProvider, int paramInt)
  {
    super(paramReactApplicationContext);
    DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(paramReactApplicationContext);
    this.mEventDispatcher = new EventDispatcher(paramReactApplicationContext);
    this.mModuleConstants = createConstants(paramViewManagerResolver);
    this.mCustomDirectEvents = UIManagerModuleConstants.getDirectEventTypeConstants();
    this.mViewManagerRegistry = new ViewManagerRegistry(paramViewManagerResolver);
    this.mUIImplementation = paramUIImplementationProvider.createUIImplementation(paramReactApplicationContext, this.mViewManagerRegistry, this.mEventDispatcher, paramInt);
    paramReactApplicationContext.addLifecycleEventListener(this);
  }

  public UIManagerModule(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, int paramInt)
  {
    this(paramReactApplicationContext, paramList, new UIImplementationProvider(), paramInt);
  }

  @Deprecated
  public UIManagerModule(ReactApplicationContext paramReactApplicationContext, List<ViewManager> paramList, UIImplementationProvider paramUIImplementationProvider, int paramInt)
  {
    super(paramReactApplicationContext);
    DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(paramReactApplicationContext);
    this.mEventDispatcher = new EventDispatcher(paramReactApplicationContext);
    this.mCustomDirectEvents = MapBuilder.newHashMap();
    this.mModuleConstants = createConstants(paramList, null, this.mCustomDirectEvents);
    this.mViewManagerRegistry = new ViewManagerRegistry(paramList);
    this.mUIImplementation = paramUIImplementationProvider.createUIImplementation(paramReactApplicationContext, this.mViewManagerRegistry, this.mEventDispatcher, paramInt);
    paramReactApplicationContext.addLifecycleEventListener(this);
  }

  @Nullable
  private WritableMap computeConstantsForViewManager(String paramString)
  {
    if (paramString != null);
    for (ViewManager localViewManager = this.mUIImplementation.resolveViewManager(paramString); localViewManager == null; localViewManager = null)
      return null;
    SystraceMessage.beginSection(0L, "UIManagerModule.getConstantsForViewManager").arg("ViewManager", localViewManager.getName()).arg("Lazy", Boolean.valueOf(true)).flush();
    try
    {
      Map localMap = UIManagerModuleConstantsHelper.createConstantsForViewManager(localViewManager, null, null, null, this.mCustomDirectEvents);
      if (localMap != null)
      {
        WritableNativeMap localWritableNativeMap = Arguments.makeNativeMap(localMap);
        return localWritableNativeMap;
      }
      return null;
    }
    finally
    {
      SystraceMessage.endSection(0L).flush();
    }
  }

  private static Map<String, Object> createConstants(ViewManagerResolver paramViewManagerResolver)
  {
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
    SystraceMessage.beginSection(0L, "CreateUIManagerConstants").arg("Lazy", Boolean.valueOf(true)).flush();
    try
    {
      Map localMap = UIManagerModuleConstantsHelper.createConstants(paramViewManagerResolver);
      return localMap;
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
    }
  }

  private static Map<String, Object> createConstants(List<ViewManager> paramList, @Nullable Map<String, Object> paramMap1, @Nullable Map<String, Object> paramMap2)
  {
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_START);
    SystraceMessage.beginSection(0L, "CreateUIManagerConstants").arg("Lazy", Boolean.valueOf(false)).flush();
    try
    {
      Map localMap = UIManagerModuleConstantsHelper.createConstants(paramList, paramMap1, paramMap2);
      return localMap;
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_CONSTANTS_END);
    }
  }

  public void addAnimation(int paramInt1, int paramInt2, Callback paramCallback)
  {
    this.mUIImplementation.addAnimation(paramInt1, paramInt2, paramCallback);
  }

  public <T extends SizeMonitoringFrameLayout,  extends MeasureSpecProvider> int addRootView(T paramT)
  {
    return addRootView(paramT, null, null);
  }

  public <T extends SizeMonitoringFrameLayout,  extends MeasureSpecProvider> int addRootView(T paramT, WritableMap paramWritableMap, @Nullable String paramString)
  {
    Systrace.beginSection(0L, "UIManagerModule.addRootView");
    final int i = ReactRootViewTagGenerator.getNextRootViewTag();
    final ReactApplicationContext localReactApplicationContext = getReactApplicationContext();
    ThemedReactContext localThemedReactContext = new ThemedReactContext(localReactApplicationContext, paramT.getContext());
    this.mUIImplementation.registerRootView(paramT, i, localThemedReactContext);
    paramT.setOnSizeChangedListener(new SizeMonitoringFrameLayout.OnSizeChangedListener()
    {
      public void onSizeChanged(final int paramAnonymousInt1, final int paramAnonymousInt2, int paramAnonymousInt3, int paramAnonymousInt4)
      {
        localReactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(localReactApplicationContext)
        {
          public void runGuarded()
          {
            UIManagerModule.this.updateNodeSize(UIManagerModule.2.this.val$tag, paramAnonymousInt1, paramAnonymousInt2);
          }
        });
      }
    });
    Systrace.endSection(0L);
    return i;
  }

  public void addUIBlock(UIBlock paramUIBlock)
  {
    this.mUIImplementation.addUIBlock(paramUIBlock);
  }

  public void addUIManagerListener(UIManagerModuleListener paramUIManagerModuleListener)
  {
    this.mListeners.add(paramUIManagerModuleListener);
  }

  @ReactMethod
  public void clearJSResponder()
  {
    this.mUIImplementation.clearJSResponder();
  }

  @ReactMethod
  public void configureNextLayoutAnimation(ReadableMap paramReadableMap, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.configureNextLayoutAnimation(paramReadableMap, paramCallback1, paramCallback2);
  }

  @ReactMethod
  public void createView(int paramInt1, String paramString, int paramInt2, ReadableMap paramReadableMap)
  {
    if (DEBUG)
    {
      String str = "(UIManager.createView) tag: " + paramInt1 + ", class: " + paramString + ", props: " + paramReadableMap;
      FLog.d("ReactNative", str);
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
    }
    this.mUIImplementation.createView(paramInt1, paramString, paramInt2, paramReadableMap);
  }

  @ReactMethod
  public void dismissPopupMenu()
  {
    this.mUIImplementation.dismissPopupMenu();
  }

  public void dispatchCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    this.mUIImplementation.dispatchViewManagerCommand(paramInt1, paramInt2, paramReadableArray);
  }

  @ReactMethod
  public void dispatchViewManagerCommand(int paramInt1, int paramInt2, @Nullable ReadableArray paramReadableArray)
  {
    UIManagerHelper.getUIManager(getReactApplicationContext(), ViewUtil.getUIManagerType(paramInt1)).dispatchCommand(paramInt1, paramInt2, paramReadableArray);
  }

  @ReactMethod
  public void findSubviewIn(int paramInt, ReadableArray paramReadableArray, Callback paramCallback)
  {
    this.mUIImplementation.findSubviewIn(paramInt, Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(0))), Math.round(PixelUtil.toPixelFromDIP(paramReadableArray.getDouble(1))), paramCallback);
  }

  public Map<String, Object> getConstants()
  {
    return this.mModuleConstants;
  }

  @ReactMethod(isBlockingSynchronousMethod=true)
  @Nullable
  public WritableMap getConstantsForViewManager(String paramString)
  {
    if ((this.mViewManagerConstantsCache != null) && (this.mViewManagerConstantsCache.containsKey(paramString)))
    {
      WritableMap localWritableMap = (WritableMap)this.mViewManagerConstantsCache.get(paramString);
      int i = -1 + this.mViewManagerConstantsCacheSize;
      this.mViewManagerConstantsCacheSize = i;
      if (i <= 0)
        this.mViewManagerConstantsCache = null;
      return localWritableMap;
    }
    return computeConstantsForViewManager(paramString);
  }

  @ReactMethod(isBlockingSynchronousMethod=true)
  public WritableMap getDefaultEventTypes()
  {
    return Arguments.makeNativeMap(UIManagerModuleConstantsHelper.getDefaultExportableEventTypes());
  }

  public CustomEventNamesResolver getDirectEventNamesResolver()
  {
    return new CustomEventNamesResolver()
    {
      @Nullable
      public String resolveCustomEventName(String paramAnonymousString)
      {
        Map localMap = (Map)UIManagerModule.this.mCustomDirectEvents.get(paramAnonymousString);
        if (localMap != null)
          return (String)localMap.get("registrationName");
        return paramAnonymousString;
      }
    };
  }

  public EventDispatcher getEventDispatcher()
  {
    return this.mEventDispatcher;
  }

  public String getName()
  {
    return "UIManager";
  }

  public Map<String, Long> getPerformanceCounters()
  {
    return this.mUIImplementation.getProfiledBatchPerfCounters();
  }

  public UIImplementation getUIImplementation()
  {
    return this.mUIImplementation;
  }

  @Deprecated
  public ViewManagerRegistry getViewManagerRegistry_DO_NOT_USE()
  {
    return this.mViewManagerRegistry;
  }

  public void initialize()
  {
    getReactApplicationContext().registerComponentCallbacks(this.mMemoryTrimCallback);
    this.mEventDispatcher.registerEventEmitter(1, (RCTEventEmitter)getReactApplicationContext().getJSModule(RCTEventEmitter.class));
  }

  public void invalidateNodeLayout(int paramInt)
  {
    ReactShadowNode localReactShadowNode = this.mUIImplementation.resolveShadowNode(paramInt);
    if (localReactShadowNode == null)
    {
      FLog.w("ReactNative", "Warning : attempted to dirty a non-existent react shadow node. reactTag=" + paramInt);
      return;
    }
    localReactShadowNode.dirty();
    this.mUIImplementation.dispatchViewUpdates(-1);
  }

  @ReactMethod
  public void manageChildren(int paramInt, @Nullable ReadableArray paramReadableArray1, @Nullable ReadableArray paramReadableArray2, @Nullable ReadableArray paramReadableArray3, @Nullable ReadableArray paramReadableArray4, @Nullable ReadableArray paramReadableArray5)
  {
    if (DEBUG)
    {
      String str = "(UIManager.manageChildren) tag: " + paramInt + ", moveFrom: " + paramReadableArray1 + ", moveTo: " + paramReadableArray2 + ", addTags: " + paramReadableArray3 + ", atIndices: " + paramReadableArray4 + ", removeFrom: " + paramReadableArray5;
      FLog.d("ReactNative", str);
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
    }
    this.mUIImplementation.manageChildren(paramInt, paramReadableArray1, paramReadableArray2, paramReadableArray3, paramReadableArray4, paramReadableArray5);
  }

  @ReactMethod
  public void measure(int paramInt, Callback paramCallback)
  {
    this.mUIImplementation.measure(paramInt, paramCallback);
  }

  @ReactMethod
  public void measureInWindow(int paramInt, Callback paramCallback)
  {
    this.mUIImplementation.measureInWindow(paramInt, paramCallback);
  }

  @ReactMethod
  public void measureLayout(int paramInt1, int paramInt2, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.measureLayout(paramInt1, paramInt2, paramCallback1, paramCallback2);
  }

  @ReactMethod
  public void measureLayoutRelativeToParent(int paramInt, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.measureLayoutRelativeToParent(paramInt, paramCallback1, paramCallback2);
  }

  public void onBatchComplete()
  {
    int i = this.mBatchId;
    this.mBatchId = (1 + this.mBatchId);
    SystraceMessage.beginSection(0L, "onBatchCompleteUI").arg("BatchId", i).flush();
    Iterator localIterator = this.mListeners.iterator();
    while (localIterator.hasNext())
      ((UIManagerModuleListener)localIterator.next()).willDispatchViewUpdates(this);
    try
    {
      this.mUIImplementation.dispatchViewUpdates(i);
      return;
    }
    finally
    {
      Systrace.endSection(0L);
    }
  }

  public void onCatalystInstanceDestroy()
  {
    super.onCatalystInstanceDestroy();
    this.mEventDispatcher.onCatalystInstanceDestroyed();
    getReactApplicationContext().unregisterComponentCallbacks(this.mMemoryTrimCallback);
    YogaNodePool.get().clear();
    ViewManagerPropertyUpdater.clear();
  }

  public void onHostDestroy()
  {
    this.mUIImplementation.onHostDestroy();
  }

  public void onHostPause()
  {
    this.mUIImplementation.onHostPause();
  }

  public void onHostResume()
  {
    this.mUIImplementation.onHostResume();
  }

  @ReactMethod
  public void playTouchSound()
  {
    AudioManager localAudioManager = (AudioManager)getReactApplicationContext().getSystemService("audio");
    if (localAudioManager != null)
      localAudioManager.playSoundEffect(0);
  }

  @Deprecated
  public void preComputeConstantsForViewManager(List<String> paramList)
  {
    ArrayMap localArrayMap = new ArrayMap();
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      String str = (String)localIterator.next();
      WritableMap localWritableMap = computeConstantsForViewManager(str);
      if (localWritableMap != null)
        localArrayMap.put(str, localWritableMap);
    }
    this.mViewManagerConstantsCacheSize = paramList.size();
    this.mViewManagerConstantsCache = Collections.unmodifiableMap(localArrayMap);
  }

  public void prependUIBlock(UIBlock paramUIBlock)
  {
    this.mUIImplementation.prependUIBlock(paramUIBlock);
  }

  public void profileNextBatch()
  {
    this.mUIImplementation.profileNextBatch();
  }

  public void registerAnimation(Animation paramAnimation)
  {
    this.mUIImplementation.registerAnimation(paramAnimation);
  }

  public void removeAnimation(int paramInt1, int paramInt2)
  {
    this.mUIImplementation.removeAnimation(paramInt1, paramInt2);
  }

  @ReactMethod
  public void removeRootView(int paramInt)
  {
    this.mUIImplementation.removeRootView(paramInt);
  }

  @ReactMethod
  public void removeSubviewsFromContainerWithID(int paramInt)
  {
    this.mUIImplementation.removeSubviewsFromContainerWithID(paramInt);
  }

  public void removeUIManagerListener(UIManagerModuleListener paramUIManagerModuleListener)
  {
    this.mListeners.remove(paramUIManagerModuleListener);
  }

  @ReactMethod
  public void replaceExistingNonRootView(int paramInt1, int paramInt2)
  {
    this.mUIImplementation.replaceExistingNonRootView(paramInt1, paramInt2);
  }

  public int resolveRootTagFromReactTag(int paramInt)
  {
    if (ViewUtil.isRootTag(paramInt))
      return paramInt;
    return this.mUIImplementation.resolveRootTagFromReactTag(paramInt);
  }

  @ReactMethod
  public void sendAccessibilityEvent(int paramInt1, int paramInt2)
  {
    this.mUIImplementation.sendAccessibilityEvent(paramInt1, paramInt2);
  }

  @ReactMethod
  public void setChildren(int paramInt, ReadableArray paramReadableArray)
  {
    if (DEBUG)
    {
      String str = "(UIManager.setChildren) tag: " + paramInt + ", children: " + paramReadableArray;
      FLog.d("ReactNative", str);
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
    }
    this.mUIImplementation.setChildren(paramInt, paramReadableArray);
  }

  @ReactMethod
  public void setJSResponder(int paramInt, boolean paramBoolean)
  {
    this.mUIImplementation.setJSResponder(paramInt, paramBoolean);
  }

  @ReactMethod
  public void setLayoutAnimationEnabledExperimental(boolean paramBoolean)
  {
    this.mUIImplementation.setLayoutAnimationEnabledExperimental(paramBoolean);
  }

  public void setViewHierarchyUpdateDebugListener(@Nullable NotThreadSafeViewHierarchyUpdateDebugListener paramNotThreadSafeViewHierarchyUpdateDebugListener)
  {
    this.mUIImplementation.setViewHierarchyUpdateDebugListener(paramNotThreadSafeViewHierarchyUpdateDebugListener);
  }

  public void setViewLocalData(final int paramInt, final Object paramObject)
  {
    ReactApplicationContext localReactApplicationContext = getReactApplicationContext();
    localReactApplicationContext.assertOnUiQueueThread();
    localReactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(localReactApplicationContext)
    {
      public void runGuarded()
      {
        UIManagerModule.this.mUIImplementation.setViewLocalData(paramInt, paramObject);
      }
    });
  }

  @ReactMethod
  public void showPopupMenu(int paramInt, ReadableArray paramReadableArray, Callback paramCallback1, Callback paramCallback2)
  {
    this.mUIImplementation.showPopupMenu(paramInt, paramReadableArray, paramCallback1, paramCallback2);
  }

  public void updateNodeSize(int paramInt1, int paramInt2, int paramInt3)
  {
    getReactApplicationContext().assertOnNativeModulesQueueThread();
    this.mUIImplementation.updateNodeSize(paramInt1, paramInt2, paramInt3);
  }

  public void updateRootLayoutSpecs(final int paramInt1, final int paramInt2, final int paramInt3)
  {
    ReactApplicationContext localReactApplicationContext = getReactApplicationContext();
    localReactApplicationContext.runOnNativeModulesQueueThread(new GuardedRunnable(localReactApplicationContext)
    {
      public void runGuarded()
      {
        UIManagerModule.this.mUIImplementation.updateRootView(paramInt1, paramInt2, paramInt3);
        UIManagerModule.this.mUIImplementation.dispatchViewUpdates(-1);
      }
    });
  }

  @ReactMethod
  public void updateView(int paramInt, String paramString, ReadableMap paramReadableMap)
  {
    if (DEBUG)
    {
      String str = "(UIManager.updateView) tag: " + paramInt + ", class: " + paramString + ", props: " + paramReadableMap;
      FLog.d("ReactNative", str);
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.UI_MANAGER, str);
    }
    this.mUIImplementation.updateView(paramInt, paramString, paramReadableMap);
  }

  @ReactMethod
  public void viewIsDescendantOf(int paramInt1, int paramInt2, Callback paramCallback)
  {
    this.mUIImplementation.viewIsDescendantOf(paramInt1, paramInt2, paramCallback);
  }

  public static abstract interface CustomEventNamesResolver
  {
    @Nullable
    public abstract String resolveCustomEventName(String paramString);
  }

  private class MemoryTrimCallback
    implements ComponentCallbacks2
  {
    private MemoryTrimCallback()
    {
    }

    public void onConfigurationChanged(Configuration paramConfiguration)
    {
    }

    public void onLowMemory()
    {
    }

    public void onTrimMemory(int paramInt)
    {
      if (paramInt >= 60)
        YogaNodePool.get().clear();
    }
  }

  public static abstract interface ViewManagerResolver
  {
    @Nullable
    public abstract ViewManager getViewManager(String paramString);

    public abstract List<String> getViewManagerNames();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.UIManagerModule
 * JD-Core Version:    0.6.2
 */