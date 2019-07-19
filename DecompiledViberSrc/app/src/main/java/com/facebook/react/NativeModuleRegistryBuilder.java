package com.facebook.react;

import com.facebook.react.bridge.ModuleHolder;
import com.facebook.react.bridge.NativeModuleRegistry;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.config.ReactFeatureFlags;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class NativeModuleRegistryBuilder
{
  private final Map<String, ModuleHolder> mModules = new HashMap();
  private final ReactApplicationContext mReactApplicationContext;
  private final ReactInstanceManager mReactInstanceManager;

  public NativeModuleRegistryBuilder(ReactApplicationContext paramReactApplicationContext, ReactInstanceManager paramReactInstanceManager)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mReactInstanceManager = paramReactInstanceManager;
  }

  public NativeModuleRegistry build()
  {
    return new NativeModuleRegistry(this.mReactApplicationContext, this.mModules);
  }

  public void processPackage(ReactPackage paramReactPackage)
  {
    Iterable localIterable;
    Iterator localIterator;
    if ((paramReactPackage instanceof LazyReactPackage))
    {
      localIterable = ((LazyReactPackage)paramReactPackage).getNativeModuleIterator(this.mReactApplicationContext);
      localIterator = localIterable.iterator();
    }
    while (true)
    {
      if (!localIterator.hasNext())
        return;
      ModuleHolder localModuleHolder1 = (ModuleHolder)localIterator.next();
      String str = localModuleHolder1.getName();
      if (this.mModules.containsKey(str))
      {
        ModuleHolder localModuleHolder2 = (ModuleHolder)this.mModules.get(str);
        if (!localModuleHolder1.getCanOverrideExistingModule())
        {
          throw new IllegalStateException("Native module " + str + " tried to override " + localModuleHolder2.getClassName() + " for module name .Check the getPackages() method in MainApplication.java, it might be that module is being created twice. If this was your intention, set canOverrideExistingModule=true");
          if ((paramReactPackage instanceof TurboReactPackage))
          {
            localIterable = ((TurboReactPackage)paramReactPackage).getNativeModuleIterator(this.mReactApplicationContext);
            break;
          }
          localIterable = ReactPackageHelper.getNativeModuleIterator(paramReactPackage, this.mReactApplicationContext, this.mReactInstanceManager);
          break;
        }
        this.mModules.remove(localModuleHolder2);
      }
      if ((!ReactFeatureFlags.useTurboModules) || (!localModuleHolder1.isTurboModule()))
        this.mModules.put(str, localModuleHolder1);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.NativeModuleRegistryBuilder
 * JD-Core Version:    0.6.2
 */