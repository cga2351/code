package com.facebook.react;

import android.app.Application;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.JSIModulePackage;
import com.facebook.react.bridge.JavaScriptExecutorFactory;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.devsupport.RedBoxHandler;
import com.facebook.react.uimanager.UIImplementationProvider;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;

public abstract class ReactNativeHost
{
  private final Application mApplication;

  @Nullable
  private ReactInstanceManager mReactInstanceManager;

  protected ReactNativeHost(Application paramApplication)
  {
    this.mApplication = paramApplication;
  }

  public void clear()
  {
    if (this.mReactInstanceManager != null)
    {
      this.mReactInstanceManager.destroy();
      this.mReactInstanceManager = null;
    }
  }

  protected ReactInstanceManager createReactInstanceManager()
  {
    ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_START);
    ReactInstanceManagerBuilder localReactInstanceManagerBuilder = ReactInstanceManager.builder().setApplication(this.mApplication).setJSMainModulePath(getJSMainModuleName()).setUseDeveloperSupport(getUseDeveloperSupport()).setRedBoxHandler(getRedBoxHandler()).setJavaScriptExecutorFactory(getJavaScriptExecutorFactory()).setUIImplementationProvider(getUIImplementationProvider()).setJSIModulesPackage(getJSIModulePackage()).setInitialLifecycleState(LifecycleState.BEFORE_CREATE);
    Iterator localIterator = getPackages().iterator();
    while (localIterator.hasNext())
      localReactInstanceManagerBuilder.addPackage((ReactPackage)localIterator.next());
    String str = getJSBundleFile();
    if (str != null)
      localReactInstanceManagerBuilder.setJSBundleFile(str);
    while (true)
    {
      ReactInstanceManager localReactInstanceManager = localReactInstanceManagerBuilder.build();
      ReactMarker.logMarker(ReactMarkerConstants.BUILD_REACT_INSTANCE_MANAGER_END);
      return localReactInstanceManager;
      localReactInstanceManagerBuilder.setBundleAssetName((String)Assertions.assertNotNull(getBundleAssetName()));
    }
  }

  protected final Application getApplication()
  {
    return this.mApplication;
  }

  @Nullable
  protected String getBundleAssetName()
  {
    return "index.android.bundle";
  }

  @Nullable
  protected String getJSBundleFile()
  {
    return null;
  }

  @Nullable
  protected JSIModulePackage getJSIModulePackage()
  {
    return null;
  }

  protected String getJSMainModuleName()
  {
    return "index.android";
  }

  @Nullable
  protected JavaScriptExecutorFactory getJavaScriptExecutorFactory()
  {
    return null;
  }

  protected abstract List<ReactPackage> getPackages();

  public ReactInstanceManager getReactInstanceManager()
  {
    if (this.mReactInstanceManager == null)
    {
      ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_START);
      this.mReactInstanceManager = createReactInstanceManager();
      ReactMarker.logMarker(ReactMarkerConstants.GET_REACT_INSTANCE_MANAGER_END);
    }
    return this.mReactInstanceManager;
  }

  @Nullable
  protected RedBoxHandler getRedBoxHandler()
  {
    return null;
  }

  protected UIImplementationProvider getUIImplementationProvider()
  {
    return new UIImplementationProvider();
  }

  public abstract boolean getUseDeveloperSupport();

  public boolean hasInstance()
  {
    return this.mReactInstanceManager != null;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.ReactNativeHost
 * JD-Core Version:    0.6.2
 */