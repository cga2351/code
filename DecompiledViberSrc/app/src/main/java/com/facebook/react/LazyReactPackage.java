package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactMarker;
import com.facebook.react.bridge.ReactMarkerConstants;
import com.facebook.react.module.model.ReactModuleInfo;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import com.facebook.react.uimanager.ViewManager;
import com.facebook.systrace.SystraceMessage;
import com.facebook.systrace.SystraceMessage.Builder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.inject.Provider;

public abstract class LazyReactPackage
  implements ReactPackage
{
  public static ReactModuleInfoProvider getReactModuleInfoProviderViaReflection(LazyReactPackage paramLazyReactPackage)
  {
    Class localClass;
    try
    {
      localClass = Class.forName(paramLazyReactPackage.getClass().getCanonicalName() + "$$ReactModuleInfoProvider");
      if (localClass == null)
        throw new RuntimeException("ReactModuleInfoProvider class for " + paramLazyReactPackage.getClass().getCanonicalName() + " not found.");
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      return new ReactModuleInfoProvider()
      {
        public Map<String, ReactModuleInfo> getReactModuleInfos()
        {
          return Collections.emptyMap();
        }
      };
    }
    try
    {
      ReactModuleInfoProvider localReactModuleInfoProvider = (ReactModuleInfoProvider)localClass.newInstance();
      return localReactModuleInfoProvider;
    }
    catch (InstantiationException localInstantiationException)
    {
      throw new RuntimeException("Unable to instantiate ReactModuleInfoProvider for " + paramLazyReactPackage.getClass(), localInstantiationException);
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      throw new RuntimeException("Unable to instantiate ReactModuleInfoProvider for " + paramLazyReactPackage.getClass(), localIllegalAccessException);
    }
  }

  public final List<NativeModule> createNativeModules(ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = getNativeModules(paramReactApplicationContext).iterator();
    while (localIterator.hasNext())
    {
      ModuleSpec localModuleSpec = (ModuleSpec)localIterator.next();
      SystraceMessage.beginSection(0L, "createNativeModule").arg("module", localModuleSpec.getType()).flush();
      ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, localModuleSpec.getName());
      try
      {
        NativeModule localNativeModule = (NativeModule)localModuleSpec.getProvider().get();
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
        SystraceMessage.endSection(0L).flush();
        localArrayList.add(localNativeModule);
      }
      finally
      {
        ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
        SystraceMessage.endSection(0L).flush();
      }
    }
    return localArrayList;
  }

  public List<ViewManager> createViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    List localList = getViewManagers(paramReactApplicationContext);
    if ((localList == null) || (localList.isEmpty()))
      return Collections.emptyList();
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = localList.iterator();
    while (localIterator.hasNext())
      localArrayList.add((ViewManager)((ModuleSpec)localIterator.next()).getProvider().get());
    return localArrayList;
  }

  Iterable<ModuleHolder> getNativeModuleIterator(ReactApplicationContext paramReactApplicationContext)
  {
    final Map localMap = getReactModuleInfoProvider().getReactModuleInfos();
    return new Iterable()
    {
      public Iterator<ModuleHolder> iterator()
      {
        return new Iterator()
        {
          int position = 0;

          public boolean hasNext()
          {
            return this.position < LazyReactPackage.2.this.val$nativeModules.size();
          }

          public ModuleHolder next()
          {
            List localList = LazyReactPackage.2.this.val$nativeModules;
            int i = this.position;
            this.position = (i + 1);
            ModuleSpec localModuleSpec = (ModuleSpec)localList.get(i);
            String str = localModuleSpec.getName();
            ReactModuleInfo localReactModuleInfo = (ReactModuleInfo)LazyReactPackage.2.this.val$reactModuleInfoMap.get(str);
            if (localReactModuleInfo == null)
            {
              ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_START, str);
              try
              {
                NativeModule localNativeModule = (NativeModule)localModuleSpec.getProvider().get();
                return new ModuleHolder(localNativeModule);
              }
              finally
              {
                ReactMarker.logMarker(ReactMarkerConstants.CREATE_MODULE_END);
              }
            }
            return new ModuleHolder(localReactModuleInfo, localModuleSpec.getProvider());
          }

          public void remove()
          {
            throw new UnsupportedOperationException("Cannot remove native modules from the list");
          }
        };
      }
    };
  }

  protected abstract List<ModuleSpec> getNativeModules(ReactApplicationContext paramReactApplicationContext);

  public abstract ReactModuleInfoProvider getReactModuleInfoProvider();

  public List<ModuleSpec> getViewManagers(ReactApplicationContext paramReactApplicationContext)
  {
    return Collections.emptyList();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.LazyReactPackage
 * JD-Core Version:    0.6.2
 */