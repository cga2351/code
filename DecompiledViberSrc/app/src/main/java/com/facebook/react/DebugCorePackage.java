package com.facebook.react;

import com.facebook.react.bridge.ModuleSpec;
import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.devsupport.JSCHeapCapture;
import com.facebook.react.devsupport.JSCSamplingProfiler;
import com.facebook.react.module.model.ReactModuleInfoProvider;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Provider;

class DebugCorePackage extends LazyReactPackage
{
  public List<ModuleSpec> getNativeModules(final ReactApplicationContext paramReactApplicationContext)
  {
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(ModuleSpec.nativeModuleSpec(JSCHeapCapture.class, new Provider()
    {
      public NativeModule get()
      {
        return new JSCHeapCapture(paramReactApplicationContext);
      }
    }));
    localArrayList.add(ModuleSpec.nativeModuleSpec(JSCSamplingProfiler.class, new Provider()
    {
      public NativeModule get()
      {
        return new JSCSamplingProfiler(paramReactApplicationContext);
      }
    }));
    return localArrayList;
  }

  public ReactModuleInfoProvider getReactModuleInfoProvider()
  {
    return LazyReactPackage.getReactModuleInfoProviderViaReflection(this);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.DebugCorePackage
 * JD-Core Version:    0.6.2
 */