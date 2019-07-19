package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.modules.core.DefaultHardwareBackBtnHandler;
import com.facebook.react.modules.core.DeviceEventManagerModule;
import com.facebook.react.modules.core.ExceptionsManagerModule;
import com.facebook.react.modules.core.HeadlessJsTaskSupportModule;
import com.facebook.react.modules.core.Timing;
import com.facebook.react.modules.debug.SourceCodeModule;
import com.facebook.react.modules.deviceinfo.DeviceInfoModule;
import com.facebook.react.modules.systeminfo.AndroidInfoModule;
import com.facebook.react.uimanager.UIImplementationProvider;
import com.facebook.react.uimanager.UIManagerModule;
import com.facebook.react.uimanager.UIManagerModule.ViewManagerResolver;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.Systrace;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

class CoreModulesPackage extends TurboReactPackage
  implements ReactPackageLogger
{
  private final DefaultHardwareBackBtnHandler mHardwareBackBtnHandler;
  private final boolean mLazyViewManagersEnabled;
  private final int mMinTimeLeftInFrameForNonBatchedOperationMs;
  private final ReactInstanceManager mReactInstanceManager;

  CoreModulesPackage(ReactInstanceManager paramReactInstanceManager, DefaultHardwareBackBtnHandler paramDefaultHardwareBackBtnHandler, @Nullable UIImplementationProvider paramUIImplementationProvider, boolean paramBoolean, int paramInt)
  {
    this.mReactInstanceManager = paramReactInstanceManager;
    this.mHardwareBackBtnHandler = paramDefaultHardwareBackBtnHandler;
    this.mLazyViewManagersEnabled = paramBoolean;
    this.mMinTimeLeftInFrameForNonBatchedOperationMs = paramInt;
  }

  private UIManagerModule createUIManager(ReactApplicationContext paramReactApplicationContext)
  {
    ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_START);
    Systrace.beginSection(0L, "createUIManagerModule");
    try
    {
      if (this.mLazyViewManagersEnabled)
      {
        UIManagerModule localUIManagerModule1 = new UIManagerModule(paramReactApplicationContext, new UIManagerModule.ViewManagerResolver()
        {
          @Nullable
          public ViewManager getViewManager(String paramAnonymousString)
          {
            return CoreModulesPackage.this.mReactInstanceManager.createViewManager(paramAnonymousString);
          }

          public List<String> getViewManagerNames()
          {
            return CoreModulesPackage.this.mReactInstanceManager.getViewManagerNames();
          }
        }
        , this.mMinTimeLeftInFrameForNonBatchedOperationMs);
        return localUIManagerModule1;
      }
      UIManagerModule localUIManagerModule2 = new UIManagerModule(paramReactApplicationContext, this.mReactInstanceManager.getOrCreateViewManagers(paramReactApplicationContext), this.mMinTimeLeftInFrameForNonBatchedOperationMs);
      return localUIManagerModule2;
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_UI_MANAGER_MODULE_END);
    }
  }

  public void endProcessPackage()
  {
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_END);
  }

  public NativeModule getModule(String paramString, ReactApplicationContext paramReactApplicationContext)
  {
    int i = -1;
    switch (paramString.hashCode())
    {
    default:
    case -790603268:
    case -1037217463:
    case 512434409:
    case 1256514152:
    case 881516744:
    case -1789797270:
    case 1861242489:
    case -1520650172:
    }
    while (true)
      switch (i)
      {
      default:
        throw new IllegalArgumentException("In CoreModulesPackage, could not find Native module for " + paramString);
        if (paramString.equals("PlatformConstants"))
        {
          i = 0;
          continue;
          if (paramString.equals("DeviceEventManager"))
          {
            i = 1;
            continue;
            if (paramString.equals("ExceptionsManager"))
            {
              i = 2;
              continue;
              if (paramString.equals("HeadlessJsTaskSupport"))
              {
                i = 3;
                continue;
                if (paramString.equals("SourceCode"))
                {
                  i = 4;
                  continue;
                  if (paramString.equals("Timing"))
                  {
                    i = 5;
                    continue;
                    if (paramString.equals("UIManager"))
                    {
                      i = 6;
                      continue;
                      if (paramString.equals("DeviceInfo"))
                        i = 7;
                    }
                  }
                }
              }
            }
          }
        }
        break;
      case 0:
      case 1:
      case 2:
      case 3:
      case 4:
      case 5:
      case 6:
      case 7:
      }
    return new AndroidInfoModule(paramReactApplicationContext);
    return new DeviceEventManagerModule(paramReactApplicationContext, this.mHardwareBackBtnHandler);
    return new ExceptionsManagerModule(this.mReactInstanceManager.getDevSupportManager());
    return new HeadlessJsTaskSupportModule(paramReactApplicationContext);
    return new SourceCodeModule(paramReactApplicationContext);
    return new Timing(paramReactApplicationContext, this.mReactInstanceManager.getDevSupportManager());
    return createUIManager(paramReactApplicationContext);
    return new DeviceInfoModule(paramReactApplicationContext);
  }

  public ReactModuleInfoProvider getReactModuleInfoProvider()
  {
    try
    {
      ReactModuleInfoProvider localReactModuleInfoProvider = (ReactModuleInfoProvider)Class.forName("com.facebook.react.CoreModulesPackage$$ReactModuleInfoProvider").newInstance();
      return localReactModuleInfoProvider;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      Class[] arrayOfClass = { AndroidInfoModule.class, DeviceEventManagerModule.class, DeviceInfoModule.class, ExceptionsManagerModule.class, HeadlessJsTaskSupportModule.class, SourceCodeModule.class, Timing.class, UIManagerModule.class };
      final HashMap localHashMap = new HashMap();
      int i = arrayOfClass.length;
      for (int j = 0; j < i; j++)
      {
        Class localClass = arrayOfClass[j];
        ReactModule localReactModule = (ReactModule)localClass.getAnnotation(ReactModule.class);
        localHashMap.put(localReactModule.name(), new ReactModuleInfo(localReactModule.name(), localClass.getName(), localReactModule.canOverrideExistingModule(), localReactModule.needsEagerInit(), localReactModule.hasConstants(), localReactModule.isCxxModule(), false));
      }
      return new ReactModuleInfoProvider()
      {
        public Map<String, ReactModuleInfo> getReactModuleInfos()
        {
          return localHashMap;
        }
      };
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("No ReactModuleInfoProvider for CoreModulesPackage$$ReactModuleInfoProvider", localIllegalAccessException);
    }
  }

  public void startProcessPackage()
  {
    ReactMarker.logMarker(ReactMarkerConstants.PROCESS_CORE_REACT_PACKAGE_START);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.CoreModulesPackage
 * JD-Core Version:    0.6.2
 */