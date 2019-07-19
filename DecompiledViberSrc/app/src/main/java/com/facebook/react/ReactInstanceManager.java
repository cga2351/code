package com.facebook.react;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.view.View.OnAttachStateChangeListener;
import android.view.Window;
import com.facebook.common.logging.FLog;
import com.facebook.debug.holder.Printer;
import com.facebook.debug.holder.PrinterHolder;
import com.facebook.debug.tags.ReactDebugOverlayTags;
import com.facebook.infer.annotation.Assertions;
import com.facebook.infer.annotation.ThreadConfined;
import com.facebook.infer.annotation.ThreadSafe;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.CatalystInstance;
import com.facebook.react.bridge.CatalystInstanceImpl;
import com.facebook.react.bridge.CatalystInstanceImpl.Builder;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaJSExecutor.Factory;
import com.facebook.react.bridge.JavaScriptExecutor;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeDeltaClient;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.bridge.ProxyJavaScriptExecutor.Factory;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.bridge.UIManager;
import com.facebook.react.bridge.UiThreadUtil;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.bridge.WritableNativeMap;
import com.facebook.react.bridge.queue.ReactQueueConfigurationSpec;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.common.annotations.VisibleForTesting;
import com.facebook.react.devsupport.DevSupportManagerFactory;
import com.facebook.react.devsupport.ReactInstanceManagerDevHelper;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.devsupport.interfaces.DevSupportManager;
import com.facebook.react.devsupport.interfaces.PackagerStatusCallback;
import com.facebook.react.modules.appregistry.AppRegistry;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.modules.core.ReactChoreographer;
import com.facebook.react.modules.debug.interfaces.DeveloperSettings;
import com.facebook.react.modules.fabric.ReactFabric;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerHelper;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.react.views.imagehelper.ResourceDrawableIdHelper;
import com.facebook.soloader.SoLoader;
import com.facebook.systrace.Systrace;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@ThreadSafe
public class ReactInstanceManager
{
  private static final String TAG = ReactInstanceManager.class.getSimpleName();
  private final Context mApplicationContext;
  private final Set<ReactRootView> mAttachedRootViews = Collections.synchronizedSet(new HashSet());

  @Nullable
  private final NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;

  @Nullable
  private final JSBundleLoader mBundleLoader;

  @Nullable
  private volatile Thread mCreateReactContextThread;

  @Nullable
  private Activity mCurrentActivity;

  @Nullable
  private volatile ReactContext mCurrentReactContext;

  @Nullable
  @ThreadConfined("UI")
  private DefaultHardwareBackBtnHandler mDefaultBackButtonImpl;
  private final DevSupportManager mDevSupportManager;
  private volatile boolean mHasStartedCreatingInitialContext = false;
  private volatile Boolean mHasStartedDestroying = Boolean.valueOf(false);

  @Nullable
  private final JSIModulePackage mJSIModulePackage;

  @Nullable
  private final String mJSMainModulePath;
  private final JavaScriptExecutorFactory mJavaScriptExecutorFactory;
  private volatile LifecycleState mLifecycleState;
  private final MemoryPressureRouter mMemoryPressureRouter;

  @Nullable
  private final NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private final List<ReactPackage> mPackages;

  @Nullable
  @ThreadConfined("UI")
  private ReactContextInitParams mPendingReactContextInitParams;
  private final Object mReactContextLock = new Object();
  private final Collection<ReactInstanceEventListener> mReactInstanceEventListeners = Collections.synchronizedSet(new HashSet());
  private final boolean mUseDeveloperSupport;
  private List<ViewManager> mViewManagers;

  ReactInstanceManager(Context paramContext, @Nullable Activity paramActivity, @Nullable DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler, JavaScriptExecutorFactory paramJavaScriptExecutorFactory, @Nullable JSBundleLoader paramJSBundleLoader, @Nullable String paramString, List<ReactPackage> paramList, boolean paramBoolean1, @Nullable NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener, LifecycleState paramLifecycleState, @Nullable UIImplementationProvider paramUIImplementationProvider, NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler, @Nullable RedBoxHandler paramRedBoxHandler, boolean paramBoolean2, @Nullable DevBundleDownloadListener paramDevBundleDownloadListener, int paramInt1, int paramInt2, @Nullable JSIModulePackage paramJSIModulePackage, @Nullable Map<String, RequestHandler> paramMap)
  {
    Log.d("ReactNative", "ReactInstanceManager.ctor()");
    initializeSoLoaderIfNecessary(paramContext);
    DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(paramContext);
    this.mApplicationContext = paramContext;
    this.mCurrentActivity = paramActivity;
    this.mDefaultBackButtonImpl = paramDefaultHardwareBackBtnHandler;
    this.mJavaScriptExecutorFactory = paramJavaScriptExecutorFactory;
    this.mBundleLoader = paramJSBundleLoader;
    this.mJSMainModulePath = paramString;
    this.mPackages = new ArrayList();
    this.mUseDeveloperSupport = paramBoolean1;
    Systrace.beginSection(0L, "ReactInstanceManager.initDevSupportManager");
    this.mDevSupportManager = DevSupportManagerFactory.create(paramContext, createDevHelperInterface(), this.mJSMainModulePath, paramBoolean1, paramRedBoxHandler, paramDevBundleDownloadListener, paramInt1, paramMap);
    Systrace.endSection(0L);
    this.mBridgeIdleDebugListener = paramNotThreadSafeBridgeIdleDebugListener;
    this.mLifecycleState = paramLifecycleState;
    this.mMemoryPressureRouter = new MemoryPressureRouter(paramContext);
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    synchronized (this.mPackages)
    {
      PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Use Split Packages");
      this.mPackages.add(new CoreModulesPackage(this, new DefaultHardwareBackBtnHandler()
      {
        public void invokeDefaultOnBackPressed()
        {
          ReactInstanceManager.this.invokeDefaultOnBackPressed();
        }
      }
      , paramUIImplementationProvider, paramBoolean2, paramInt2));
      if (this.mUseDeveloperSupport)
        this.mPackages.add(new DebugCorePackage());
      this.mPackages.addAll(paramList);
      this.mJSIModulePackage = paramJSIModulePackage;
      ReactChoreographer.initialize();
      if (this.mUseDeveloperSupport)
        this.mDevSupportManager.startInspector();
      return;
    }
  }

  private void attachRootViewToInstance(final ReactRootView paramReactRootView)
  {
    Log.d("ReactNative", "ReactInstanceManager.attachRootViewToInstance()");
    Systrace.beginSection(0L, "attachRootViewToInstance");
    UIManager localUIManager = UIManagerHelper.getUIManager(this.mCurrentReactContext, paramReactRootView.getUIManagerType());
    Bundle localBundle = paramReactRootView.getAppProperties();
    if (localBundle == null);
    for (Object localObject = new WritableNativeMap(); ; localObject = Arguments.fromBundle(localBundle))
    {
      final int i = localUIManager.addRootView(paramReactRootView, (WritableMap)localObject, paramReactRootView.getInitialUITemplate());
      paramReactRootView.setRootViewTag(i);
      paramReactRootView.runApplication();
      Systrace.beginAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", i);
      UiThreadUtil.runOnUiThread(new Runnable()
      {
        public void run()
        {
          Systrace.endAsyncSection(0L, "pre_rootView.onAttachedToReactInstance", i);
          paramReactRootView.onAttachedToReactInstance();
        }
      });
      Systrace.endSection(0L);
      return;
    }
  }

  public static ReactInstanceManagerBuilder builder()
  {
    return new ReactInstanceManagerBuilder();
  }

  private ReactInstanceManagerDevHelper createDevHelperInterface()
  {
    return new ReactInstanceManagerDevHelper()
    {
      @Nullable
      public Activity getCurrentActivity()
      {
        return ReactInstanceManager.this.mCurrentActivity;
      }

      public void onJSBundleLoadedFromServer(@Nullable NativeDeltaClient paramAnonymousNativeDeltaClient)
      {
        ReactInstanceManager.this.onJSBundleLoadedFromServer(paramAnonymousNativeDeltaClient);
      }

      public void onReloadWithJSDebugger(JavaJSExecutor.Factory paramAnonymousFactory)
      {
        ReactInstanceManager.this.onReloadWithJSDebugger(paramAnonymousFactory);
      }

      public void toggleElementInspector()
      {
        ReactInstanceManager.this.toggleElementInspector();
      }
    };
  }

  private ReactApplicationContext createReactContext(JavaScriptExecutor paramJavaScriptExecutor, JSBundleLoader paramJSBundleLoader)
  {
    Log.d("ReactNative", "ReactInstanceManager.createReactContext()");
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_REACT_CONTEXT_START, paramJavaScriptExecutor.getName());
    ReactApplicationContext localReactApplicationContext = new ReactApplicationContext(this.mApplicationContext);
    Object localObject1;
    if (this.mNativeModuleCallExceptionHandler != null)
      localObject1 = this.mNativeModuleCallExceptionHandler;
    while (true)
    {
      localReactApplicationContext.setNativeModuleCallExceptionHandler((NativeModuleCallExceptionHandler)localObject1);
      NativeModuleRegistry localNativeModuleRegistry = processPackages(localReactApplicationContext, this.mPackages, false);
      CatalystInstanceImpl.Builder localBuilder = new CatalystInstanceImpl.Builder().setReactQueueConfigurationSpec(ReactQueueConfigurationSpec.createDefault()).setJSExecutor(paramJavaScriptExecutor).setRegistry(localNativeModuleRegistry).setJSBundleLoader(paramJSBundleLoader).setNativeModuleCallExceptionHandler((NativeModuleCallExceptionHandler)localObject1);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_START);
      Systrace.beginSection(0L, "createCatalystInstance");
      try
      {
        CatalystInstanceImpl localCatalystInstanceImpl = localBuilder.build();
        Systrace.endSection(0L);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
        if (this.mJSIModulePackage != null)
          localCatalystInstanceImpl.addJSIModules(this.mJSIModulePackage.getJSIModules(localReactApplicationContext, localCatalystInstanceImpl.getJavaScriptContextHolder()));
        if (this.mBridgeIdleDebugListener != null)
          localCatalystInstanceImpl.addBridgeIdleDebugListener(this.mBridgeIdleDebugListener);
        if (Systrace.isTracing(0L))
          localCatalystInstanceImpl.setGlobalVariable("__RCTProfileIsProfiling", "true");
        ReactMarker.logMarker(ReactMarkerConstants.PRE_RUN_JS_BUNDLE_START);
        Systrace.beginSection(0L, "runJSBundle");
        localCatalystInstanceImpl.runJSBundle();
        return localReactApplicationContext;
        localObject1 = this.mDevSupportManager;
      }
      finally
      {
        Systrace.endSection(0L);
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_CATALYST_INSTANCE_END);
      }
    }
  }

  private void detachViewFromInstance(ReactRootView paramReactRootView, CatalystInstance paramCatalystInstance)
  {
    Log.d("ReactNative", "ReactInstanceManager.detachViewFromInstance()");
    UiThreadUtil.assertOnUiThread();
    if (paramReactRootView.getUIManagerType() == 2)
    {
      ((ReactFabric)paramCatalystInstance.getJSModule(ReactFabric.class)).unmountComponentAtNode(paramReactRootView.getId());
      return;
    }
    ((AppRegistry)paramCatalystInstance.getJSModule(AppRegistry.class)).unmountApplicationComponentAtRootTag(paramReactRootView.getId());
  }

  private static void initializeSoLoaderIfNecessary(Context paramContext)
  {
    SoLoader.init(paramContext, false);
  }

  private void invokeDefaultOnBackPressed()
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mDefaultBackButtonImpl != null)
      this.mDefaultBackButtonImpl.invokeDefaultOnBackPressed();
  }

  private void moveReactContextToCurrentLifecycleState()
  {
    try
    {
      if (this.mLifecycleState == LifecycleState.RESUMED)
        moveToResumedLifecycleState(true);
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }

  private void moveToBeforeCreateLifecycleState()
  {
    try
    {
      ReactContext localReactContext = getCurrentReactContext();
      if (localReactContext != null)
      {
        if (this.mLifecycleState == LifecycleState.RESUMED)
        {
          localReactContext.onHostPause();
          this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        }
        if (this.mLifecycleState == LifecycleState.BEFORE_RESUME)
          localReactContext.onHostDestroy();
      }
      this.mLifecycleState = LifecycleState.BEFORE_CREATE;
      return;
    }
    finally
    {
    }
  }

  private void moveToBeforeResumeLifecycleState()
  {
    try
    {
      ReactContext localReactContext = getCurrentReactContext();
      if (localReactContext != null)
      {
        if (this.mLifecycleState != LifecycleState.BEFORE_CREATE)
          break label43;
        localReactContext.onHostResume(this.mCurrentActivity);
        localReactContext.onHostPause();
      }
      while (true)
      {
        this.mLifecycleState = LifecycleState.BEFORE_RESUME;
        return;
        label43: if (this.mLifecycleState == LifecycleState.RESUMED)
          localReactContext.onHostPause();
      }
    }
    finally
    {
    }
  }

  private void moveToResumedLifecycleState(boolean paramBoolean)
  {
    try
    {
      ReactContext localReactContext = getCurrentReactContext();
      if ((localReactContext != null) && ((paramBoolean) || (this.mLifecycleState == LifecycleState.BEFORE_RESUME) || (this.mLifecycleState == LifecycleState.BEFORE_CREATE)))
        localReactContext.onHostResume(this.mCurrentActivity);
      this.mLifecycleState = LifecycleState.RESUMED;
      return;
    }
    finally
    {
    }
  }

  @ThreadConfined("UI")
  private void onJSBundleLoadedFromServer(@Nullable NativeDeltaClient paramNativeDeltaClient)
  {
    Log.d("ReactNative", "ReactInstanceManager.onJSBundleLoadedFromServer()");
    if (paramNativeDeltaClient == null);
    for (JSBundleLoader localJSBundleLoader = JSBundleLoader.createCachedBundleFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), this.mDevSupportManager.getDownloadedJSBundleFile()); ; localJSBundleLoader = JSBundleLoader.createDeltaFromNetworkLoader(this.mDevSupportManager.getSourceUrl(), paramNativeDeltaClient))
    {
      recreateReactContextInBackground(this.mJavaScriptExecutorFactory, localJSBundleLoader);
      return;
    }
  }

  @ThreadConfined("UI")
  private void onReloadWithJSDebugger(JavaJSExecutor.Factory paramFactory)
  {
    Log.d("ReactNative", "ReactInstanceManager.onReloadWithJSDebugger()");
    recreateReactContextInBackground(new ProxyJavaScriptExecutor.Factory(paramFactory), JSBundleLoader.createRemoteDebuggerBundleLoader(this.mDevSupportManager.getJSBundleURLForRemoteDebugging(), this.mDevSupportManager.getSourceUrl()));
  }

  private void processPackage(ReactPackage paramReactPackage, NativeModuleRegistryBuilder paramNativeModuleRegistryBuilder)
  {
    SystraceMessage.beginSection(0L, "processPackage").arg("className", paramReactPackage.getClass().getSimpleName()).flush();
    if ((paramReactPackage instanceof ReactPackageLogger))
      ((ReactPackageLogger)paramReactPackage).startProcessPackage();
    paramNativeModuleRegistryBuilder.processPackage(paramReactPackage);
    if ((paramReactPackage instanceof ReactPackageLogger))
      ((ReactPackageLogger)paramReactPackage).endProcessPackage();
    SystraceMessage.endSection(0L).flush();
  }

  private NativeModuleRegistry processPackages(ReactApplicationContext paramReactApplicationContext, List<ReactPackage> paramList, boolean paramBoolean)
  {
    NativeModuleRegistryBuilder localNativeModuleRegistryBuilder = new NativeModuleRegistryBuilder(paramReactApplicationContext, this);
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_START);
    while (true)
    {
      ReactPackage localReactPackage;
      synchronized (this.mPackages)
      {
        Iterator localIterator = paramList.iterator();
        if (!localIterator.hasNext())
          break;
        localReactPackage = (ReactPackage)localIterator.next();
        if ((paramBoolean) && (this.mPackages.contains(localReactPackage)))
          continue;
        Systrace.beginSection(0L, "createAndProcessCustomReactPackage");
        if (!paramBoolean);
      }
      try
      {
        this.mPackages.add(localReactPackage);
        processPackage(localReactPackage, localNativeModuleRegistryBuilder);
        Systrace.endSection(0L);
        continue;
        localObject1 = finally;
        throw localObject1;
      }
      finally
      {
        Systrace.endSection(0L);
      }
    }
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_PACKAGES_END);
    ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_START);
    Systrace.beginSection(0L, "buildNativeModuleRegistry");
    try
    {
      NativeModuleRegistry localNativeModuleRegistry = localNativeModuleRegistryBuilder.build();
      return localNativeModuleRegistry;
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.BUILD_NATIVE_MODULE_REGISTRY_END);
    }
  }

  @ThreadConfined("UI")
  private void recreateReactContextInBackground(JavaScriptExecutorFactory paramJavaScriptExecutorFactory, JSBundleLoader paramJSBundleLoader)
  {
    Log.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackground()");
    UiThreadUtil.assertOnUiThread();
    ReactContextInitParams localReactContextInitParams = new ReactContextInitParams(paramJavaScriptExecutorFactory, paramJSBundleLoader);
    if (this.mCreateReactContextThread == null)
    {
      runCreateReactContextOnNewThread(localReactContextInitParams);
      return;
    }
    this.mPendingReactContextInitParams = localReactContextInitParams;
  }

  @ThreadConfined("UI")
  private void recreateReactContextInBackgroundFromBundleLoader()
  {
    Log.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackgroundFromBundleLoader()");
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: load from BundleLoader");
    recreateReactContextInBackground(this.mJavaScriptExecutorFactory, this.mBundleLoader);
  }

  @ThreadConfined("UI")
  private void recreateReactContextInBackgroundInner()
  {
    Log.d("ReactNative", "ReactInstanceManager.recreateReactContextInBackgroundInner()");
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: recreateReactContextInBackground");
    UiThreadUtil.assertOnUiThread();
    if ((this.mUseDeveloperSupport) && (this.mJSMainModulePath != null))
    {
      final DeveloperSettings localDeveloperSettings = this.mDevSupportManager.getDevSettings();
      if ((this.mDevSupportManager.hasUpToDateJSBundleInCache()) && (!localDeveloperSettings.isRemoteJSDebugEnabled()))
      {
        onJSBundleLoadedFromServer(null);
        return;
      }
      if (!Systrace.isTracing(0L))
      {
        if (this.mBundleLoader == null)
        {
          this.mDevSupportManager.handleReloadJS();
          return;
        }
        this.mDevSupportManager.isPackagerRunning(new PackagerStatusCallback()
        {
          public void onPackagerStatusFetched(final boolean paramAnonymousBoolean)
          {
            UiThreadUtil.runOnUiThread(new Runnable()
            {
              public void run()
              {
                if (paramAnonymousBoolean)
                {
                  ReactInstanceManager.this.mDevSupportManager.handleReloadJS();
                  return;
                }
                ReactInstanceManager.3.this.val$devSettings.setRemoteJSDebugEnabled(false);
                ReactInstanceManager.this.recreateReactContextInBackgroundFromBundleLoader();
              }
            });
          }
        });
        return;
      }
    }
    recreateReactContextInBackgroundFromBundleLoader();
  }

  @ThreadConfined("UI")
  private void runCreateReactContextOnNewThread(final ReactContextInitParams paramReactContextInitParams)
  {
    Log.d("ReactNative", "ReactInstanceManager.runCreateReactContextOnNewThread()");
    UiThreadUtil.assertOnUiThread();
    synchronized (this.mAttachedRootViews)
    {
      synchronized (this.mReactContextLock)
      {
        if (this.mCurrentReactContext != null)
        {
          tearDownReactContext(this.mCurrentReactContext);
          this.mCurrentReactContext = null;
        }
        this.mCreateReactContextThread = new Thread(null, new Runnable()
        {
          public void run()
          {
            ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_END);
            synchronized (ReactInstanceManager.this.mHasStartedDestroying)
            {
              while (true)
              {
                boolean bool = ReactInstanceManager.this.mHasStartedDestroying.booleanValue();
                if (!bool)
                  break;
                try
                {
                  ReactInstanceManager.this.mHasStartedDestroying.wait();
                }
                catch (InterruptedException localInterruptedException)
                {
                }
              }
              ReactInstanceManager.access$802(ReactInstanceManager.this, true);
            }
            try
            {
              Process.setThreadPriority(-4);
              ReactMarker.logMarker(ReactMarkerConstants.VM_INIT);
              final ReactApplicationContext localReactApplicationContext = ReactInstanceManager.this.createReactContext(paramReactContextInitParams.getJsExecutorFactory().create(), paramReactContextInitParams.getJsBundleLoader());
              ReactInstanceManager.access$1002(ReactInstanceManager.this, null);
              ReactMarker.logMarker(ReactMarkerConstants.PRE_SETUP_REACT_CONTEXT_START);
              Runnable local1 = new Runnable()
              {
                public void run()
                {
                  if (ReactInstanceManager.this.mPendingReactContextInitParams != null)
                  {
                    ReactInstanceManager.this.runCreateReactContextOnNewThread(ReactInstanceManager.this.mPendingReactContextInitParams);
                    ReactInstanceManager.access$1102(ReactInstanceManager.this, null);
                  }
                }
              };
              localReactApplicationContext.runOnNativeModulesQueueThread(new Runnable()
              {
                public void run()
                {
                  try
                  {
                    ReactInstanceManager.this.setupReactContext(localReactApplicationContext);
                    return;
                  }
                  catch (Exception localException)
                  {
                    ReactInstanceManager.this.mDevSupportManager.handleException(localException);
                  }
                }
              });
              UiThreadUtil.runOnUiThread(local1);
              return;
              localObject = finally;
              throw localObject;
            }
            catch (Exception localException)
            {
              ReactInstanceManager.this.mDevSupportManager.handleException(localException);
            }
          }
        }
        , "create_react_context");
        ReactMarker.logMarker(ReactMarkerConstants.REACT_CONTEXT_THREAD_START);
        this.mCreateReactContextThread.start();
        return;
      }
    }
  }

  // ERROR //
  private void setupReactContext(final ReactApplicationContext paramReactApplicationContext)
  {
    // Byte code:
    //   0: ldc 99
    //   2: ldc_w 723
    //   5: invokestatic 107	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   8: pop
    //   9: getstatic 726	com/facebook/react/bridge/ReactMarkerConstants:PRE_SETUP_REACT_CONTEXT_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   12: invokestatic 423	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;)V
    //   15: getstatic 729	com/facebook/react/bridge/ReactMarkerConstants:SETUP_REACT_CONTEXT_START	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   18: invokestatic 423	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;)V
    //   21: lconst_0
    //   22: ldc_w 730
    //   25: invokestatic 143	com/facebook/systrace/Systrace:beginSection	(JLjava/lang/String;)V
    //   28: aload_0
    //   29: getfield 83	com/facebook/react/ReactInstanceManager:mAttachedRootViews	Ljava/util/Set;
    //   32: astore_3
    //   33: aload_3
    //   34: monitorenter
    //   35: aload_0
    //   36: getfield 85	com/facebook/react/ReactInstanceManager:mReactContextLock	Ljava/lang/Object;
    //   39: astore 5
    //   41: aload 5
    //   43: monitorenter
    //   44: aload_0
    //   45: aload_1
    //   46: invokestatic 736	com/facebook/infer/annotation/Assertions:assertNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   49: checkcast 525	com/facebook/react/bridge/ReactContext
    //   52: putfield 293	com/facebook/react/ReactInstanceManager:mCurrentReactContext	Lcom/facebook/react/bridge/ReactContext;
    //   55: aload 5
    //   57: monitorexit
    //   58: aload_1
    //   59: invokevirtual 740	com/facebook/react/bridge/ReactApplicationContext:getCatalystInstance	()Lcom/facebook/react/bridge/CatalystInstance;
    //   62: invokestatic 736	com/facebook/infer/annotation/Assertions:assertNotNull	(Ljava/lang/Object;)Ljava/lang/Object;
    //   65: checkcast 434	com/facebook/react/bridge/CatalystInstance
    //   68: astore 7
    //   70: aload 7
    //   72: invokeinterface 741 1 0
    //   77: aload_0
    //   78: getfield 155	com/facebook/react/ReactInstanceManager:mDevSupportManager	Lcom/facebook/react/devsupport/interfaces/DevSupportManager;
    //   81: aload_1
    //   82: invokeinterface 744 2 0
    //   87: aload_0
    //   88: getfield 169	com/facebook/react/ReactInstanceManager:mMemoryPressureRouter	Lcom/facebook/react/MemoryPressureRouter;
    //   91: aload 7
    //   93: invokevirtual 748	com/facebook/react/MemoryPressureRouter:addMemoryPressureListener	(Lcom/facebook/react/bridge/MemoryPressureListener;)V
    //   96: aload_0
    //   97: invokespecial 750	com/facebook/react/ReactInstanceManager:moveReactContextToCurrentLifecycleState	()V
    //   100: getstatic 753	com/facebook/react/bridge/ReactMarkerConstants:ATTACH_MEASURED_ROOT_VIEWS_START	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   103: invokestatic 423	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;)V
    //   106: aload_0
    //   107: getfield 83	com/facebook/react/ReactInstanceManager:mAttachedRootViews	Ljava/util/Set;
    //   110: invokeinterface 756 1 0
    //   115: astore 8
    //   117: aload 8
    //   119: invokeinterface 631 1 0
    //   124: ifeq +35 -> 159
    //   127: aload_0
    //   128: aload 8
    //   130: invokeinterface 635 1 0
    //   135: checkcast 295	com/facebook/react/ReactRootView
    //   138: invokespecial 758	com/facebook/react/ReactInstanceManager:attachRootViewToInstance	(Lcom/facebook/react/ReactRootView;)V
    //   141: goto -24 -> 117
    //   144: astore 4
    //   146: aload_3
    //   147: monitorexit
    //   148: aload 4
    //   150: athrow
    //   151: astore 6
    //   153: aload 5
    //   155: monitorexit
    //   156: aload 6
    //   158: athrow
    //   159: getstatic 761	com/facebook/react/bridge/ReactMarkerConstants:ATTACH_MEASURED_ROOT_VIEWS_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   162: invokestatic 423	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;)V
    //   165: aload_3
    //   166: monitorexit
    //   167: aload_0
    //   168: getfield 87	com/facebook/react/ReactInstanceManager:mReactInstanceEventListeners	Ljava/util/Collection;
    //   171: invokeinterface 766 1 0
    //   176: anewarray 768	com/facebook/react/ReactInstanceManager$ReactInstanceEventListener
    //   179: astore 9
    //   181: new 770	com/facebook/react/ReactInstanceManager$6
    //   184: dup
    //   185: aload_0
    //   186: aload_0
    //   187: getfield 87	com/facebook/react/ReactInstanceManager:mReactInstanceEventListeners	Ljava/util/Collection;
    //   190: aload 9
    //   192: invokeinterface 774 2 0
    //   197: checkcast 776	[Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;
    //   200: aload_1
    //   201: invokespecial 779	com/facebook/react/ReactInstanceManager$6:<init>	(Lcom/facebook/react/ReactInstanceManager;[Lcom/facebook/react/ReactInstanceManager$ReactInstanceEventListener;Lcom/facebook/react/bridge/ReactApplicationContext;)V
    //   204: invokestatic 345	com/facebook/react/bridge/UiThreadUtil:runOnUiThread	(Ljava/lang/Runnable;)V
    //   207: lconst_0
    //   208: invokestatic 159	com/facebook/systrace/Systrace:endSection	(J)V
    //   211: getstatic 782	com/facebook/react/bridge/ReactMarkerConstants:SETUP_REACT_CONTEXT_END	Lcom/facebook/react/bridge/ReactMarkerConstants;
    //   214: invokestatic 423	com/facebook/react/bridge/ReactMarker:logMarker	(Lcom/facebook/react/bridge/ReactMarkerConstants;)V
    //   217: aload_1
    //   218: new 784	com/facebook/react/ReactInstanceManager$7
    //   221: dup
    //   222: aload_0
    //   223: invokespecial 785	com/facebook/react/ReactInstanceManager$7:<init>	(Lcom/facebook/react/ReactInstanceManager;)V
    //   226: invokevirtual 788	com/facebook/react/bridge/ReactApplicationContext:runOnJSQueueThread	(Ljava/lang/Runnable;)V
    //   229: aload_1
    //   230: new 790	com/facebook/react/ReactInstanceManager$8
    //   233: dup
    //   234: aload_0
    //   235: invokespecial 791	com/facebook/react/ReactInstanceManager$8:<init>	(Lcom/facebook/react/ReactInstanceManager;)V
    //   238: invokevirtual 794	com/facebook/react/bridge/ReactApplicationContext:runOnNativeModulesQueueThread	(Ljava/lang/Runnable;)V
    //   241: return
    //
    // Exception table:
    //   from	to	target	type
    //   35	44	144	finally
    //   58	117	144	finally
    //   117	141	144	finally
    //   146	148	144	finally
    //   156	159	144	finally
    //   159	167	144	finally
    //   44	58	151	finally
    //   153	156	151	finally
  }

  private void tearDownReactContext(ReactContext paramReactContext)
  {
    Log.d("ReactNative", "ReactInstanceManager.tearDownReactContext()");
    UiThreadUtil.assertOnUiThread();
    if (this.mLifecycleState == LifecycleState.RESUMED)
      paramReactContext.onHostPause();
    synchronized (this.mAttachedRootViews)
    {
      Iterator localIterator = this.mAttachedRootViews.iterator();
      if (localIterator.hasNext())
      {
        ReactRootView localReactRootView = (ReactRootView)localIterator.next();
        localReactRootView.removeAllViews();
        localReactRootView.setId(-1);
      }
    }
    paramReactContext.destroy();
    this.mDevSupportManager.onReactInstanceDestroyed(paramReactContext);
    this.mMemoryPressureRouter.removeMemoryPressureListener(paramReactContext.getCatalystInstance());
  }

  private void toggleElementInspector()
  {
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext != null)
      ((DeviceEventManagerModule.RCTDeviceEventEmitter)localReactContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("toggleElementInspector", null);
  }

  public void addReactInstanceEventListener(ReactInstanceEventListener paramReactInstanceEventListener)
  {
    this.mReactInstanceEventListeners.add(paramReactInstanceEventListener);
  }

  @ThreadConfined("UI")
  public void attachRootView(ReactRootView paramReactRootView)
  {
    UiThreadUtil.assertOnUiThread();
    this.mAttachedRootViews.add(paramReactRootView);
    paramReactRootView.removeAllViews();
    paramReactRootView.setId(-1);
    ReactContext localReactContext = getCurrentReactContext();
    if ((this.mCreateReactContextThread == null) && (localReactContext != null))
      attachRootViewToInstance(paramReactRootView);
  }

  @ThreadConfined("UI")
  public void createReactContextInBackground()
  {
    Log.d("ReactNative", "ReactInstanceManager.createReactContextInBackground()");
    if (!this.mHasStartedCreatingInitialContext);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "createReactContextInBackground should only be called when creating the react application for the first time. When reloading JS, e.g. from a new file, explicitlyuse recreateReactContextInBackground");
      this.mHasStartedCreatingInitialContext = true;
      recreateReactContextInBackgroundInner();
      return;
    }
  }

  @Nullable
  public ViewManager createViewManager(String paramString)
  {
    ReactApplicationContext localReactApplicationContext;
    synchronized (this.mReactContextLock)
    {
      localReactApplicationContext = (ReactApplicationContext)getCurrentReactContext();
      if ((localReactApplicationContext == null) || (!localReactApplicationContext.hasActiveCatalystInstance()))
        return null;
    }
    synchronized (this.mPackages)
    {
      Iterator localIterator = this.mPackages.iterator();
      while (localIterator.hasNext())
      {
        ReactPackage localReactPackage = (ReactPackage)localIterator.next();
        if ((localReactPackage instanceof ViewManagerOnDemandReactPackage))
        {
          ViewManager localViewManager = ((ViewManagerOnDemandReactPackage)localReactPackage).createViewManager(localReactApplicationContext, paramString);
          if (localViewManager != null)
          {
            return localViewManager;
            localObject2 = finally;
            throw localObject2;
          }
        }
      }
      return null;
    }
  }

  @ThreadConfined("UI")
  public void destroy()
  {
    UiThreadUtil.assertOnUiThread();
    PrinterHolder.getPrinter().logMessage(ReactDebugOverlayTags.RN_CORE, "RNCore: Destroy");
    this.mHasStartedDestroying = Boolean.valueOf(true);
    if (this.mUseDeveloperSupport)
    {
      this.mDevSupportManager.setDevSupportEnabled(false);
      this.mDevSupportManager.stopInspector();
    }
    moveToBeforeCreateLifecycleState();
    if (this.mCreateReactContextThread != null)
      this.mCreateReactContextThread = null;
    this.mMemoryPressureRouter.destroy(this.mApplicationContext);
    synchronized (this.mReactContextLock)
    {
      if (this.mCurrentReactContext != null)
      {
        this.mCurrentReactContext.destroy();
        this.mCurrentReactContext = null;
      }
      this.mHasStartedCreatingInitialContext = false;
      this.mCurrentActivity = null;
      ResourceDrawableIdHelper.getInstance().clear();
      this.mHasStartedDestroying = Boolean.valueOf(false);
    }
    synchronized (this.mHasStartedDestroying)
    {
      this.mHasStartedDestroying.notifyAll();
      return;
      localObject2 = finally;
      throw localObject2;
    }
  }

  @ThreadConfined("UI")
  public void detachRootView(ReactRootView paramReactRootView)
  {
    UiThreadUtil.assertOnUiThread();
    synchronized (this.mAttachedRootViews)
    {
      if (this.mAttachedRootViews.contains(paramReactRootView))
      {
        ReactContext localReactContext = getCurrentReactContext();
        this.mAttachedRootViews.remove(paramReactRootView);
        if ((localReactContext != null) && (localReactContext.hasActiveCatalystInstance()))
          detachViewFromInstance(paramReactRootView, localReactContext.getCatalystInstance());
      }
      return;
    }
  }

  @Nullable
  @VisibleForTesting
  public ReactContext getCurrentReactContext()
  {
    synchronized (this.mReactContextLock)
    {
      ReactContext localReactContext = this.mCurrentReactContext;
      return localReactContext;
    }
  }

  public DevSupportManager getDevSupportManager()
  {
    return this.mDevSupportManager;
  }

  public String getJsExecutorName()
  {
    return this.mJavaScriptExecutorFactory.toString();
  }

  public LifecycleState getLifecycleState()
  {
    return this.mLifecycleState;
  }

  public MemoryPressureRouter getMemoryPressureRouter()
  {
    return this.mMemoryPressureRouter;
  }

  public List<ViewManager> getOrCreateViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_START);
    Systrace.beginSection(0L, "createAllViewManagers");
    try
    {
      if (this.mViewManagers != null)
        break label147;
      synchronized (this.mPackages)
      {
        if (this.mViewManagers != null)
          break label144;
        this.mViewManagers = new ArrayList();
        Iterator localIterator = this.mPackages.iterator();
        if (localIterator.hasNext())
        {
          ReactPackage localReactPackage = (ReactPackage)localIterator.next();
          this.mViewManagers.addAll(localReactPackage.createViewManagers(paramReactApplicationContext));
        }
      }
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
    }
    List localList3 = this.mViewManagers;
    Systrace.endSection(0L);
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
    return localList3;
    label144: label147: List localList1 = this.mViewManagers;
    Systrace.endSection(0L);
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_VIEW_MANAGERS_END);
    return localList1;
  }

  @Nullable
  public List<String> getViewManagerNames()
  {
    Systrace.beginSection(0L, "ReactInstanceManager.getViewManagerNames");
    HashSet localHashSet;
    synchronized (this.mReactContextLock)
    {
      ReactApplicationContext localReactApplicationContext = (ReactApplicationContext)getCurrentReactContext();
      if ((localReactApplicationContext == null) || (!localReactApplicationContext.hasActiveCatalystInstance()))
        return null;
      synchronized (this.mPackages)
      {
        localHashSet = new HashSet();
        Iterator localIterator = this.mPackages.iterator();
        if (localIterator.hasNext())
        {
          ReactPackage localReactPackage = (ReactPackage)localIterator.next();
          SystraceMessage.beginSection(0L, "ReactInstanceManager.getViewManagerName").arg("Package", localReactPackage.getClass().getSimpleName()).flush();
          if ((localReactPackage instanceof ViewManagerOnDemandReactPackage))
          {
            List localList2 = ((ViewManagerOnDemandReactPackage)localReactPackage).getViewManagerNames(localReactApplicationContext);
            if (localList2 != null)
              localHashSet.addAll(localList2);
          }
          SystraceMessage.endSection(0L).flush();
        }
      }
    }
    Systrace.endSection(0L);
    ArrayList localArrayList = new ArrayList(localHashSet);
    return localArrayList;
  }

  public boolean hasStartedCreatingInitialContext()
  {
    return this.mHasStartedCreatingInitialContext;
  }

  @ThreadConfined("UI")
  public void onActivityResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent)
  {
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext != null)
      localReactContext.onActivityResult(paramActivity, paramInt1, paramInt2, paramIntent);
  }

  public void onBackPressed()
  {
    UiThreadUtil.assertOnUiThread();
    ReactContext localReactContext = this.mCurrentReactContext;
    if (localReactContext == null)
    {
      FLog.w("ReactNative", "Instance detached from instance manager");
      invokeDefaultOnBackPressed();
      return;
    }
    ((DeviceEventManagerModule)localReactContext.getNativeModule(DeviceEventManagerModule.class)).emitHardwareBackPressed();
  }

  @ThreadConfined("UI")
  public void onHostDestroy()
  {
    UiThreadUtil.assertOnUiThread();
    if (this.mUseDeveloperSupport)
      this.mDevSupportManager.setDevSupportEnabled(false);
    moveToBeforeCreateLifecycleState();
    this.mCurrentActivity = null;
  }

  @ThreadConfined("UI")
  public void onHostDestroy(Activity paramActivity)
  {
    if (paramActivity == this.mCurrentActivity)
      onHostDestroy();
  }

  @ThreadConfined("UI")
  public void onHostPause()
  {
    UiThreadUtil.assertOnUiThread();
    this.mDefaultBackButtonImpl = null;
    if (this.mUseDeveloperSupport)
      this.mDevSupportManager.setDevSupportEnabled(false);
    moveToBeforeResumeLifecycleState();
  }

  @ThreadConfined("UI")
  public void onHostPause(Activity paramActivity)
  {
    Assertions.assertNotNull(this.mCurrentActivity);
    if (paramActivity == this.mCurrentActivity);
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertCondition(bool, "Pausing an activity that is not the current activity, this is incorrect! Current activity: " + this.mCurrentActivity.getClass().getSimpleName() + " Paused activity: " + paramActivity.getClass().getSimpleName());
      onHostPause();
      return;
    }
  }

  @ThreadConfined("UI")
  public void onHostResume(Activity paramActivity)
  {
    UiThreadUtil.assertOnUiThread();
    this.mCurrentActivity = paramActivity;
    if (this.mUseDeveloperSupport)
    {
      final View localView = this.mCurrentActivity.getWindow().getDecorView();
      if (ViewCompat.isAttachedToWindow(localView))
        break label52;
      localView.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener()
      {
        public void onViewAttachedToWindow(View paramAnonymousView)
        {
          localView.removeOnAttachStateChangeListener(this);
          ReactInstanceManager.this.mDevSupportManager.setDevSupportEnabled(true);
        }

        public void onViewDetachedFromWindow(View paramAnonymousView)
        {
        }
      });
    }
    while (true)
    {
      moveToResumedLifecycleState(false);
      return;
      label52: this.mDevSupportManager.setDevSupportEnabled(true);
    }
  }

  @ThreadConfined("UI")
  public void onHostResume(Activity paramActivity, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    UiThreadUtil.assertOnUiThread();
    this.mDefaultBackButtonImpl = paramDefaultHardwareBackBtnHandler;
    onHostResume(paramActivity);
  }

  @ThreadConfined("UI")
  public void onNewIntent(Intent paramIntent)
  {
    UiThreadUtil.assertOnUiThread();
    ReactContext localReactContext = getCurrentReactContext();
    if (localReactContext == null)
    {
      FLog.w("ReactNative", "Instance detached from instance manager");
      return;
    }
    String str = paramIntent.getAction();
    Uri localUri = paramIntent.getData();
    if (("android.intent.action.VIEW".equals(str)) && (localUri != null))
      ((DeviceEventManagerModule)localReactContext.getNativeModule(DeviceEventManagerModule.class)).emitNewIntentReceived(localUri);
    localReactContext.onNewIntent(this.mCurrentActivity, paramIntent);
  }

  @ThreadConfined("UI")
  public void recreateReactContextInBackground()
  {
    Assertions.assertCondition(this.mHasStartedCreatingInitialContext, "recreateReactContextInBackground should only be called after the initial createReactContextInBackground call.");
    recreateReactContextInBackgroundInner();
  }

  public void removeReactInstanceEventListener(ReactInstanceEventListener paramReactInstanceEventListener)
  {
    this.mReactInstanceEventListeners.remove(paramReactInstanceEventListener);
  }

  @ThreadConfined("UI")
  public void showDevOptionsDialog()
  {
    UiThreadUtil.assertOnUiThread();
    this.mDevSupportManager.showDevOptionsDialog();
  }

  private class ReactContextInitParams
  {
    private final JSBundleLoader mJsBundleLoader;
    private final JavaScriptExecutorFactory mJsExecutorFactory;

    public ReactContextInitParams(JavaScriptExecutorFactory paramJSBundleLoader, JSBundleLoader arg3)
    {
      this.mJsExecutorFactory = ((JavaScriptExecutorFactory)Assertions.assertNotNull(paramJSBundleLoader));
      Object localObject;
      this.mJsBundleLoader = ((JSBundleLoader)Assertions.assertNotNull(localObject));
    }

    public JSBundleLoader getJsBundleLoader()
    {
      return this.mJsBundleLoader;
    }

    public JavaScriptExecutorFactory getJsExecutorFactory()
    {
      return this.mJsExecutorFactory;
    }
  }

  public static abstract interface ReactInstanceEventListener
  {
    public abstract void onReactContextInitialized(ReactContext paramReactContext);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactInstanceManager
 * JD-Core Version:    0.6.2
 */