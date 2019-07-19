package com.facebook.react.bridge;

import android.content.res.AssetManager;
import android.os.AsyncTask;
import android.util.Log;
import com.facebook.common.logging.FLog;
import com.facebook.infer.annotation.Assertions;
import com.facebook.jni.HybridData;
import com.facebook.proguard.annotations.DoNotStrip;
import com.facebook.react.bridge.queue.MessageQueueThread;
import com.facebook.react.bridge.queue.QueueThreadExceptionHandler;
import com.facebook.react.bridge.queue.ReactQueueConfiguration;
import com.facebook.react.bridge.queue.ReactQueueConfigurationImpl;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.systrace.TraceListener;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.Nullable;

@DoNotStrip
public class CatalystInstanceImpl
  implements CatalystInstance
{
  private static final AtomicInteger sNextInstanceIdForTrace = new AtomicInteger(1);
  private volatile boolean mAcceptCalls = false;
  private final CopyOnWriteArrayList<NotThreadSafeBridgeIdleDebugListener> mBridgeIdleListeners;
  private volatile boolean mDestroyed = false;
  private final HybridData mHybridData;
  private boolean mInitialized = false;
  private boolean mJSBundleHasLoaded;
  private final JSBundleLoader mJSBundleLoader;
  private final ArrayList<PendingJSCall> mJSCallsPendingInit = new ArrayList();
  private final Object mJSCallsPendingInitLock = new Object();
  private final JSIModuleRegistry mJSIModuleRegistry = new JSIModuleRegistry();
  private final JavaScriptModuleRegistry mJSModuleRegistry;
  private JavaScriptContextHolder mJavaScriptContextHolder;
  private final String mJsPendingCallsTitleForTrace = "pending_js_calls_instance" + sNextInstanceIdForTrace.getAndIncrement();
  private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private final NativeModuleRegistry mNativeModuleRegistry;
  private final MessageQueueThread mNativeModulesQueueThread;
  private final AtomicInteger mPendingJSCalls = new AtomicInteger(0);
  private final ReactQueueConfigurationImpl mReactQueueConfiguration;

  @Nullable
  private String mSourceURL;
  private final TraceListener mTraceListener;

  static
  {
    ReactBridge.staticInit();
  }

  private CatalystInstanceImpl(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec, JavaScriptExecutor paramJavaScriptExecutor, NativeModuleRegistry paramNativeModuleRegistry, JSBundleLoader paramJSBundleLoader, NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    Log.d("ReactNative", "Initializing React Xplat Bridge.");
    com.facebook.systrace.Systrace.beginSection(0L, "createCatalystInstanceImpl");
    this.mHybridData = initHybrid();
    this.mReactQueueConfiguration = ReactQueueConfigurationImpl.create(paramReactQueueConfigurationSpec, new NativeExceptionHandler(null));
    this.mBridgeIdleListeners = new CopyOnWriteArrayList();
    this.mNativeModuleRegistry = paramNativeModuleRegistry;
    this.mJSModuleRegistry = new JavaScriptModuleRegistry();
    this.mJSBundleLoader = paramJSBundleLoader;
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    this.mNativeModulesQueueThread = this.mReactQueueConfiguration.getNativeModulesQueueThread();
    this.mTraceListener = new JSProfilerTraceListener(this);
    com.facebook.systrace.Systrace.endSection(0L);
    Log.d("ReactNative", "Initializing React Xplat Bridge before initializeBridge");
    com.facebook.systrace.Systrace.beginSection(0L, "initializeCxxBridge");
    initializeBridge(new BridgeCallback(this), paramJavaScriptExecutor, this.mReactQueueConfiguration.getJSQueueThread(), this.mNativeModulesQueueThread, this.mNativeModuleRegistry.getJavaModules(this), this.mNativeModuleRegistry.getCxxModules());
    Log.d("ReactNative", "Initializing React Xplat Bridge after initializeBridge");
    com.facebook.systrace.Systrace.endSection(0L);
    this.mJavaScriptContextHolder = new JavaScriptContextHolder(getJavaScriptContext());
  }

  private void decrementPendingJSCalls()
  {
    int i = this.mPendingJSCalls.decrementAndGet();
    if (i == 0);
    for (int j = 1; ; j = 0)
    {
      com.facebook.systrace.Systrace.traceCounter(0L, this.mJsPendingCallsTitleForTrace, i);
      if ((j != 0) && (!this.mBridgeIdleListeners.isEmpty()))
        this.mNativeModulesQueueThread.runOnQueue(new Runnable()
        {
          public void run()
          {
            Iterator localIterator = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
            while (localIterator.hasNext())
              ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeIdle();
          }
        });
      return;
    }
  }

  private native long getJavaScriptContext();

  private <T extends NativeModule> String getNameFromAnnotation(Class<T> paramClass)
  {
    ReactModule localReactModule = (ReactModule)paramClass.getAnnotation(ReactModule.class);
    if (localReactModule == null)
      throw new IllegalArgumentException("Could not find @ReactModule annotation in " + paramClass.getCanonicalName());
    return localReactModule.name();
  }

  private void incrementPendingJSCalls()
  {
    int i = this.mPendingJSCalls.getAndIncrement();
    if (i == 0);
    for (int j = 1; ; j = 0)
    {
      com.facebook.systrace.Systrace.traceCounter(0L, this.mJsPendingCallsTitleForTrace, i + 1);
      if ((j != 0) && (!this.mBridgeIdleListeners.isEmpty()))
        this.mNativeModulesQueueThread.runOnQueue(new Runnable()
        {
          public void run()
          {
            Iterator localIterator = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
            while (localIterator.hasNext())
              ((NotThreadSafeBridgeIdleDebugListener)localIterator.next()).onTransitionToBridgeBusy();
          }
        });
      return;
    }
  }

  private static native HybridData initHybrid();

  private native void initializeBridge(ReactCallback paramReactCallback, JavaScriptExecutor paramJavaScriptExecutor, MessageQueueThread paramMessageQueueThread1, MessageQueueThread paramMessageQueueThread2, Collection<JavaModuleWrapper> paramCollection, Collection<ModuleHolder> paramCollection1);

  private native void jniCallJSCallback(int paramInt, NativeArray paramNativeArray);

  private native void jniCallJSFunction(String paramString1, String paramString2, NativeArray paramNativeArray);

  private native void jniExtendNativeModules(Collection<JavaModuleWrapper> paramCollection, Collection<ModuleHolder> paramCollection1);

  private native void jniHandleMemoryPressure(int paramInt);

  private native void jniLoadScriptFromAssets(AssetManager paramAssetManager, String paramString, boolean paramBoolean);

  private native void jniLoadScriptFromDeltaBundle(String paramString, NativeDeltaClient paramNativeDeltaClient, boolean paramBoolean);

  private native void jniLoadScriptFromFile(String paramString1, String paramString2, boolean paramBoolean);

  private native void jniRegisterSegment(int paramInt, String paramString);

  private native void jniSetSourceURL(String paramString);

  private void onNativeException(Exception paramException)
  {
    this.mNativeModuleCallExceptionHandler.handleException(paramException);
    this.mReactQueueConfiguration.getUIQueueThread().runOnQueue(new Runnable()
    {
      public void run()
      {
        CatalystInstanceImpl.this.destroy();
      }
    });
  }

  public void addBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleListeners.add(paramNotThreadSafeBridgeIdleDebugListener);
  }

  public void addJSIModules(List<JSIModuleSpec> paramList)
  {
    this.mJSIModuleRegistry.registerModules(paramList);
  }

  public void callFunction(PendingJSCall paramPendingJSCall)
  {
    if (this.mDestroyed)
    {
      String str = paramPendingJSCall.toString();
      FLog.w("ReactNative", "Calling JS function after bridge has been destroyed: " + str);
      return;
    }
    if (!this.mAcceptCalls)
      synchronized (this.mJSCallsPendingInitLock)
      {
        if (!this.mAcceptCalls)
        {
          this.mJSCallsPendingInit.add(paramPendingJSCall);
          return;
        }
      }
    paramPendingJSCall.call(this);
  }

  public void callFunction(String paramString1, String paramString2, NativeArray paramNativeArray)
  {
    callFunction(new PendingJSCall(paramString1, paramString2, paramNativeArray));
  }

  public void destroy()
  {
    Log.d("ReactNative", "CatalystInstanceImpl.destroy() start");
    UiThreadUtil.assertOnUiThread();
    if (this.mDestroyed)
      return;
    ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_START);
    this.mDestroyed = true;
    this.mNativeModulesQueueThread.runOnQueue(new Runnable()
    {
      public void run()
      {
        CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceDestroy();
        CatalystInstanceImpl.this.mJSIModuleRegistry.notifyJSInstanceDestroy();
        if (CatalystInstanceImpl.this.mPendingJSCalls.getAndSet(0) == 0);
        for (int i = 1; !CatalystInstanceImpl.this.mBridgeIdleListeners.isEmpty(); i = 0)
        {
          Iterator localIterator = CatalystInstanceImpl.this.mBridgeIdleListeners.iterator();
          while (localIterator.hasNext())
          {
            NotThreadSafeBridgeIdleDebugListener localNotThreadSafeBridgeIdleDebugListener = (NotThreadSafeBridgeIdleDebugListener)localIterator.next();
            if (i == 0)
              localNotThreadSafeBridgeIdleDebugListener.onTransitionToBridgeIdle();
            localNotThreadSafeBridgeIdleDebugListener.onBridgeDestroyed();
          }
        }
        AsyncTask.execute(new Runnable()
        {
          public void run()
          {
            CatalystInstanceImpl.this.mJavaScriptContextHolder.clear();
            CatalystInstanceImpl.this.mHybridData.resetNative();
            CatalystInstanceImpl.this.getReactQueueConfiguration().destroy();
            Log.d("ReactNative", "CatalystInstanceImpl.destroy() end");
            ReactMarker.logMarker(ReactMarkerConstants.DESTROY_CATALYST_INSTANCE_END);
          }
        });
      }
    });
    com.facebook.systrace.Systrace.unregisterListener(this.mTraceListener);
  }

  public void extendNativeModules(NativeModuleRegistry paramNativeModuleRegistry)
  {
    this.mNativeModuleRegistry.registerModules(paramNativeModuleRegistry);
    jniExtendNativeModules(paramNativeModuleRegistry.getJavaModules(this), paramNativeModuleRegistry.getCxxModules());
  }

  public <T extends JSIModule> T getJSIModule(Class<T> paramClass)
  {
    return this.mJSIModuleRegistry.getModule(paramClass);
  }

  public <T extends JavaScriptModule> T getJSModule(Class<T> paramClass)
  {
    return this.mJSModuleRegistry.getJavaScriptModule(this, paramClass);
  }

  public JavaScriptContextHolder getJavaScriptContextHolder()
  {
    return this.mJavaScriptContextHolder;
  }

  public <T extends NativeModule> T getNativeModule(Class<T> paramClass)
  {
    return this.mNativeModuleRegistry.getModule(getNameFromAnnotation(paramClass));
  }

  public NativeModule getNativeModule(String paramString)
  {
    return this.mNativeModuleRegistry.getModule(paramString);
  }

  public Collection<NativeModule> getNativeModules()
  {
    return this.mNativeModuleRegistry.getAllModules();
  }

  public ReactQueueConfiguration getReactQueueConfiguration()
  {
    return this.mReactQueueConfiguration;
  }

  @Nullable
  public String getSourceURL()
  {
    return this.mSourceURL;
  }

  public void handleMemoryPressure(int paramInt)
  {
    if (this.mDestroyed)
      return;
    jniHandleMemoryPressure(paramInt);
  }

  public <T extends NativeModule> boolean hasNativeModule(Class<T> paramClass)
  {
    return this.mNativeModuleRegistry.hasModule(getNameFromAnnotation(paramClass));
  }

  public boolean hasRunJSBundle()
  {
    while (true)
    {
      synchronized (this.mJSCallsPendingInitLock)
      {
        if ((this.mJSBundleHasLoaded) && (this.mAcceptCalls))
        {
          bool = true;
          return bool;
        }
      }
      boolean bool = false;
    }
  }

  @VisibleForTesting
  public void initialize()
  {
    Log.d("ReactNative", "CatalystInstanceImpl.initialize()");
    if (!this.mInitialized);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "This catalyst instance has already been initialized");
      Assertions.assertCondition(this.mAcceptCalls, "RunJSBundle hasn't completed.");
      this.mInitialized = true;
      this.mNativeModulesQueueThread.runOnQueue(new Runnable()
      {
        public void run()
        {
          CatalystInstanceImpl.this.mNativeModuleRegistry.notifyJSInstanceInitialized();
        }
      });
      return;
    }
  }

  public void invokeCallback(int paramInt, NativeArrayInterface paramNativeArrayInterface)
  {
    if (this.mDestroyed)
    {
      FLog.w("ReactNative", "Invoking JS callback after bridge has been destroyed.");
      return;
    }
    jniCallJSCallback(paramInt, (NativeArray)paramNativeArrayInterface);
  }

  public boolean isDestroyed()
  {
    return this.mDestroyed;
  }

  public void loadScriptFromAssets(AssetManager paramAssetManager, String paramString, boolean paramBoolean)
  {
    this.mSourceURL = paramString;
    jniLoadScriptFromAssets(paramAssetManager, paramString, paramBoolean);
  }

  public void loadScriptFromDeltaBundle(String paramString, NativeDeltaClient paramNativeDeltaClient, boolean paramBoolean)
  {
    this.mSourceURL = paramString;
    jniLoadScriptFromDeltaBundle(paramString, paramNativeDeltaClient, paramBoolean);
  }

  public void loadScriptFromFile(String paramString1, String paramString2, boolean paramBoolean)
  {
    this.mSourceURL = paramString2;
    jniLoadScriptFromFile(paramString1, paramString2, paramBoolean);
  }

  public void registerSegment(int paramInt, String paramString)
  {
    jniRegisterSegment(paramInt, paramString);
  }

  public void removeBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleListeners.remove(paramNotThreadSafeBridgeIdleDebugListener);
  }

  public void runJSBundle()
  {
    boolean bool = true;
    Log.d("ReactNative", "CatalystInstanceImpl.runJSBundle()");
    if (!this.mJSBundleHasLoaded);
    while (true)
    {
      Assertions.assertCondition(bool, "JS bundle was already loaded!");
      this.mJSBundleLoader.loadScript(this);
      synchronized (this.mJSCallsPendingInitLock)
      {
        this.mAcceptCalls = true;
        Iterator localIterator = this.mJSCallsPendingInit.iterator();
        if (!localIterator.hasNext())
          break;
        ((PendingJSCall)localIterator.next()).call(this);
      }
      bool = false;
    }
    this.mJSCallsPendingInit.clear();
    this.mJSBundleHasLoaded = true;
    com.facebook.systrace.Systrace.registerListener(this.mTraceListener);
  }

  public native void setGlobalVariable(String paramString1, String paramString2);

  public void setSourceURLs(String paramString1, String paramString2)
  {
    this.mSourceURL = paramString1;
    jniSetSourceURL(paramString2);
  }

  private static class BridgeCallback
    implements ReactCallback
  {
    private final WeakReference<CatalystInstanceImpl> mOuter;

    BridgeCallback(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      this.mOuter = new WeakReference(paramCatalystInstanceImpl);
    }

    public void decrementPendingJSCalls()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        localCatalystInstanceImpl.decrementPendingJSCalls();
    }

    public void incrementPendingJSCalls()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        localCatalystInstanceImpl.incrementPendingJSCalls();
    }

    public void onBatchComplete()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        localCatalystInstanceImpl.mNativeModuleRegistry.onBatchComplete();
    }
  }

  public static class Builder
  {

    @Nullable
    private JSBundleLoader mJSBundleLoader;

    @Nullable
    private JavaScriptExecutor mJSExecutor;

    @Nullable
    private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;

    @Nullable
    private ReactQueueConfigurationSpec mReactQueueConfigurationSpec;

    @Nullable
    private NativeModuleRegistry mRegistry;

    public CatalystInstanceImpl build()
    {
      return new CatalystInstanceImpl((ReactQueueConfigurationSpec)Assertions.assertNotNull(this.mReactQueueConfigurationSpec), (JavaScriptExecutor)Assertions.assertNotNull(this.mJSExecutor), (NativeModuleRegistry)Assertions.assertNotNull(this.mRegistry), (JSBundleLoader)Assertions.assertNotNull(this.mJSBundleLoader), (NativeModuleCallExceptionHandler)Assertions.assertNotNull(this.mNativeModuleCallExceptionHandler), null);
    }

    public Builder setJSBundleLoader(JSBundleLoader paramJSBundleLoader)
    {
      this.mJSBundleLoader = paramJSBundleLoader;
      return this;
    }

    public Builder setJSExecutor(JavaScriptExecutor paramJavaScriptExecutor)
    {
      this.mJSExecutor = paramJavaScriptExecutor;
      return this;
    }

    public Builder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
    {
      this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
      return this;
    }

    public Builder setReactQueueConfigurationSpec(ReactQueueConfigurationSpec paramReactQueueConfigurationSpec)
    {
      this.mReactQueueConfigurationSpec = paramReactQueueConfigurationSpec;
      return this;
    }

    public Builder setRegistry(NativeModuleRegistry paramNativeModuleRegistry)
    {
      this.mRegistry = paramNativeModuleRegistry;
      return this;
    }
  }

  private static class JSProfilerTraceListener
    implements TraceListener
  {
    private final WeakReference<CatalystInstanceImpl> mOuter;

    public JSProfilerTraceListener(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      this.mOuter = new WeakReference(paramCatalystInstanceImpl);
    }

    public void onTraceStarted()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        ((Systrace)localCatalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(true);
    }

    public void onTraceStopped()
    {
      CatalystInstanceImpl localCatalystInstanceImpl = (CatalystInstanceImpl)this.mOuter.get();
      if (localCatalystInstanceImpl != null)
        ((Systrace)localCatalystInstanceImpl.getJSModule(Systrace.class)).setEnabled(false);
    }
  }

  private class NativeExceptionHandler
    implements QueueThreadExceptionHandler
  {
    private NativeExceptionHandler()
    {
    }

    public void handleException(Exception paramException)
    {
      CatalystInstanceImpl.this.onNativeException(paramException);
    }
  }

  public static class PendingJSCall
  {

    @Nullable
    public NativeArray mArguments;
    public String mMethod;
    public String mModule;

    public PendingJSCall(String paramString1, String paramString2, @Nullable NativeArray paramNativeArray)
    {
      this.mModule = paramString1;
      this.mMethod = paramString2;
      this.mArguments = paramNativeArray;
    }

    void call(CatalystInstanceImpl paramCatalystInstanceImpl)
    {
      if (this.mArguments != null);
      for (Object localObject = this.mArguments; ; localObject = new WritableNativeArray())
      {
        paramCatalystInstanceImpl.jniCallJSFunction(this.mModule, this.mMethod, (NativeArray)localObject);
        return;
      }
    }

    public String toString()
    {
      StringBuilder localStringBuilder = new StringBuilder().append(this.mModule).append(".").append(this.mMethod).append("(");
      if (this.mArguments == null);
      for (String str = ""; ; str = this.mArguments.toString())
        return str + ")";
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.CatalystInstanceImpl
 * JD-Core Version:    0.6.2
 */