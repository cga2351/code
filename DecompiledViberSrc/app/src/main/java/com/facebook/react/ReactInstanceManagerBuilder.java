package com.facebook.react;

import android.app.Activity;
import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.NativeModuleCallExceptionHandler;
import com.facebook.react.bridge.NotThreadSafeBridgeIdleDebugListener;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.devsupport.interfaces.DevBundleDownloadListener;
import com.facebook.react.jscexecutor.JSCExecutorFactory;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.systeminfo.AndroidInfoHelpers;
import com.facebook.react.packagerconnection.RequestHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public class ReactInstanceManagerBuilder
{

  @Nullable
  private Application mApplication;

  @Nullable
  private NotThreadSafeBridgeIdleDebugListener mBridgeIdleDebugListener;

  @Nullable
  private Activity mCurrentActivity;

  @Nullable
  private Map<String, RequestHandler> mCustomPackagerCommandHandlers;

  @Nullable
  private DefaultHardwareBackBtnHandler mDefaultHardwareBackBtnHandler;

  @Nullable
  private DevBundleDownloadListener mDevBundleDownloadListener;

  @Nullable
  private LifecycleState mInitialLifecycleState;

  @Nullable
  private String mJSBundleAssetUrl;

  @Nullable
  private JSBundleLoader mJSBundleLoader;

  @Nullable
  private JSIModulePackage mJSIModulesPackage;

  @Nullable
  private String mJSMainModulePath;

  @Nullable
  private JavaScriptExecutorFactory mJavaScriptExecutorFactory;
  private boolean mLazyViewManagersEnabled;
  private int mMinNumShakes = 1;
  private int mMinTimeLeftInFrameForNonBatchedOperationMs = -1;

  @Nullable
  private NativeModuleCallExceptionHandler mNativeModuleCallExceptionHandler;
  private final List<ReactPackage> mPackages = new ArrayList();

  @Nullable
  private RedBoxHandler mRedBoxHandler;

  @Nullable
  private UIImplementationProvider mUIImplementationProvider;
  private boolean mUseDeveloperSupport;

  public ReactInstanceManagerBuilder addPackage(ReactPackage paramReactPackage)
  {
    this.mPackages.add(paramReactPackage);
    return this;
  }

  public ReactInstanceManagerBuilder addPackages(List<ReactPackage> paramList)
  {
    this.mPackages.addAll(paramList);
    return this;
  }

  public ReactInstanceManager build()
  {
    Assertions.assertNotNull(this.mApplication, "Application property has not been set with this builder");
    boolean bool1;
    boolean bool2;
    label62: Application localApplication;
    Activity localActivity;
    DefaultHardwareBackBtnHandler localDefaultHardwareBackBtnHandler;
    Object localObject;
    if ((this.mUseDeveloperSupport) || (this.mJSBundleAssetUrl != null) || (this.mJSBundleLoader != null))
    {
      bool1 = true;
      Assertions.assertCondition(bool1, "JS Bundle File or Asset URL has to be provided when dev support is disabled");
      if ((this.mJSMainModulePath == null) && (this.mJSBundleAssetUrl == null) && (this.mJSBundleLoader == null))
        break label253;
      bool2 = true;
      Assertions.assertCondition(bool2, "Either MainModulePath or JS Bundle File needs to be provided");
      if (this.mUIImplementationProvider == null)
        this.mUIImplementationProvider = new UIImplementationProvider();
      String str1 = this.mApplication.getPackageName();
      String str2 = AndroidInfoHelpers.getFriendlyDeviceName();
      localApplication = this.mApplication;
      localActivity = this.mCurrentActivity;
      localDefaultHardwareBackBtnHandler = this.mDefaultHardwareBackBtnHandler;
      if (this.mJavaScriptExecutorFactory != null)
        break label258;
      localObject = new JSCExecutorFactory(str1, str2);
      label138: if ((this.mJSBundleLoader != null) || (this.mJSBundleAssetUrl == null))
        break label267;
    }
    label258: label267: for (JSBundleLoader localJSBundleLoader = JSBundleLoader.createAssetLoader(this.mApplication, this.mJSBundleAssetUrl, false); ; localJSBundleLoader = this.mJSBundleLoader)
    {
      return new ReactInstanceManager(localApplication, localActivity, localDefaultHardwareBackBtnHandler, (JavaScriptExecutorFactory)localObject, localJSBundleLoader, this.mJSMainModulePath, this.mPackages, this.mUseDeveloperSupport, this.mBridgeIdleDebugListener, (LifecycleState)Assertions.assertNotNull(this.mInitialLifecycleState, "Initial lifecycle state was not set"), this.mUIImplementationProvider, this.mNativeModuleCallExceptionHandler, this.mRedBoxHandler, this.mLazyViewManagersEnabled, this.mDevBundleDownloadListener, this.mMinNumShakes, this.mMinTimeLeftInFrameForNonBatchedOperationMs, this.mJSIModulesPackage, this.mCustomPackagerCommandHandlers);
      bool1 = false;
      break;
      label253: bool2 = false;
      break label62;
      localObject = this.mJavaScriptExecutorFactory;
      break label138;
    }
  }

  public ReactInstanceManagerBuilder setApplication(Application paramApplication)
  {
    this.mApplication = paramApplication;
    return this;
  }

  public ReactInstanceManagerBuilder setBridgeIdleDebugListener(NotThreadSafeBridgeIdleDebugListener paramNotThreadSafeBridgeIdleDebugListener)
  {
    this.mBridgeIdleDebugListener = paramNotThreadSafeBridgeIdleDebugListener;
    return this;
  }

  public ReactInstanceManagerBuilder setBundleAssetName(String paramString)
  {
    if (paramString == null);
    for (String str = null; ; str = "assets://" + paramString)
    {
      this.mJSBundleAssetUrl = str;
      this.mJSBundleLoader = null;
      return this;
    }
  }

  public ReactInstanceManagerBuilder setCurrentActivity(Activity paramActivity)
  {
    this.mCurrentActivity = paramActivity;
    return this;
  }

  public ReactInstanceManagerBuilder setCustomPackagerCommandHandlers(Map<String, RequestHandler> paramMap)
  {
    this.mCustomPackagerCommandHandlers = paramMap;
    return this;
  }

  public ReactInstanceManagerBuilder setDefaultHardwareBackBtnHandler(DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler)
  {
    this.mDefaultHardwareBackBtnHandler = paramDefaultHardwareBackBtnHandler;
    return this;
  }

  public ReactInstanceManagerBuilder setDevBundleDownloadListener(@Nullable DevBundleDownloadListener paramDevBundleDownloadListener)
  {
    this.mDevBundleDownloadListener = paramDevBundleDownloadListener;
    return this;
  }

  public ReactInstanceManagerBuilder setInitialLifecycleState(LifecycleState paramLifecycleState)
  {
    this.mInitialLifecycleState = paramLifecycleState;
    return this;
  }

  public ReactInstanceManagerBuilder setJSBundleFile(String paramString)
  {
    if (paramString.startsWith("assets://"))
    {
      this.mJSBundleAssetUrl = paramString;
      this.mJSBundleLoader = null;
      return this;
    }
    return setJSBundleLoader(JSBundleLoader.createFileLoader(paramString));
  }

  public ReactInstanceManagerBuilder setJSBundleLoader(JSBundleLoader paramJSBundleLoader)
  {
    this.mJSBundleLoader = paramJSBundleLoader;
    this.mJSBundleAssetUrl = null;
    return this;
  }

  public ReactInstanceManagerBuilder setJSIModulesPackage(@Nullable JSIModulePackage paramJSIModulePackage)
  {
    this.mJSIModulesPackage = paramJSIModulePackage;
    return this;
  }

  public ReactInstanceManagerBuilder setJSMainModulePath(String paramString)
  {
    this.mJSMainModulePath = paramString;
    return this;
  }

  public ReactInstanceManagerBuilder setJavaScriptExecutorFactory(@Nullable JavaScriptExecutorFactory paramJavaScriptExecutorFactory)
  {
    this.mJavaScriptExecutorFactory = paramJavaScriptExecutorFactory;
    return this;
  }

  public ReactInstanceManagerBuilder setLazyViewManagersEnabled(boolean paramBoolean)
  {
    this.mLazyViewManagersEnabled = paramBoolean;
    return this;
  }

  public ReactInstanceManagerBuilder setMinNumShakes(int paramInt)
  {
    this.mMinNumShakes = paramInt;
    return this;
  }

  public ReactInstanceManagerBuilder setMinTimeLeftInFrameForNonBatchedOperationMs(int paramInt)
  {
    this.mMinTimeLeftInFrameForNonBatchedOperationMs = paramInt;
    return this;
  }

  public ReactInstanceManagerBuilder setNativeModuleCallExceptionHandler(NativeModuleCallExceptionHandler paramNativeModuleCallExceptionHandler)
  {
    this.mNativeModuleCallExceptionHandler = paramNativeModuleCallExceptionHandler;
    return this;
  }

  public ReactInstanceManagerBuilder setRedBoxHandler(@Nullable RedBoxHandler paramRedBoxHandler)
  {
    this.mRedBoxHandler = paramRedBoxHandler;
    return this;
  }

  public ReactInstanceManagerBuilder setUIImplementationProvider(@Nullable UIImplementationProvider paramUIImplementationProvider)
  {
    this.mUIImplementationProvider = paramUIImplementationProvider;
    return this;
  }

  public ReactInstanceManagerBuilder setUseDeveloperSupport(boolean paramBoolean)
  {
    this.mUseDeveloperSupport = paramBoolean;
    return this;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactInstanceManagerBuilder
 * JD-Core Version:    0.6.2
 */