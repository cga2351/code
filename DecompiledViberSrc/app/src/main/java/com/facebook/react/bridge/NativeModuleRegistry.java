package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.systrace.Systrace;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class NativeModuleRegistry
{
  private final Map<String, ModuleHolder> mModules;
  private final ReactApplicationContext mReactApplicationContext;

  public NativeModuleRegistry(ReactApplicationContext paramReactApplicationContext, Map<String, ModuleHolder> paramMap)
  {
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mModules = paramMap;
  }

  private Map<String, ModuleHolder> getModuleMap()
  {
    return this.mModules;
  }

  private ReactApplicationContext getReactApplicationContext()
  {
    return this.mReactApplicationContext;
  }

  public List<NativeModule> getAllModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.values().iterator();
    while (localIterator.hasNext())
      localArrayList.add(((ModuleHolder)localIterator.next()).getModule());
    return localArrayList;
  }

  Collection<ModuleHolder> getCxxModules()
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (((ModuleHolder)localEntry.getValue()).isCxxModule())
        localArrayList.add(localEntry.getValue());
    }
    return localArrayList;
  }

  Collection<JavaModuleWrapper> getJavaModules(JSInstance paramJSInstance)
  {
    ArrayList localArrayList = new ArrayList();
    Iterator localIterator = this.mModules.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (!((ModuleHolder)localEntry.getValue()).isCxxModule())
        localArrayList.add(new JavaModuleWrapper(paramJSInstance, (ModuleHolder)localEntry.getValue()));
    }
    return localArrayList;
  }

  public <T extends NativeModule> T getModule(Class<T> paramClass)
  {
    ReactModule localReactModule = (ReactModule)paramClass.getAnnotation(ReactModule.class);
    if (localReactModule == null)
      throw new IllegalArgumentException("Could not find @ReactModule annotation in class " + paramClass.getName());
    return ((ModuleHolder)Assertions.assertNotNull(this.mModules.get(localReactModule.name()), localReactModule.name() + " could not be found. Is it defined in " + paramClass.getName())).getModule();
  }

  public NativeModule getModule(String paramString)
  {
    return ((ModuleHolder)Assertions.assertNotNull(this.mModules.get(paramString), "Could not find module with name " + paramString)).getModule();
  }

  public <T extends NativeModule> boolean hasModule(Class<T> paramClass)
  {
    String str = ((ReactModule)paramClass.getAnnotation(ReactModule.class)).name();
    return this.mModules.containsKey(str);
  }

  public boolean hasModule(String paramString)
  {
    return this.mModules.containsKey(paramString);
  }

  void notifyJSInstanceDestroy()
  {
    this.mReactApplicationContext.assertOnNativeModulesQueueThread();
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyJSInstanceDestroy");
    try
    {
      Iterator localIterator = this.mModules.values().iterator();
      while (localIterator.hasNext())
        ((ModuleHolder)localIterator.next()).destroy();
    }
    finally
    {
      Systrace.endSection(0L);
    }
    Systrace.endSection(0L);
  }

  void notifyJSInstanceInitialized()
  {
    this.mReactApplicationContext.assertOnNativeModulesQueueThread("From version React Native v0.44, native modules are explicitly not initialized on the UI thread. See https://github.com/facebook/react-native/wiki/Breaking-Changes#d4611211-reactnativeandroidbreaking-move-nativemodule-initialization-off-ui-thread---aaachiuuu  for more details.");
    ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_START);
    Systrace.beginSection(0L, "NativeModuleRegistry_notifyJSInstanceInitialized");
    try
    {
      Iterator localIterator = this.mModules.values().iterator();
      while (localIterator.hasNext())
        ((ModuleHolder)localIterator.next()).markInitializable();
    }
    finally
    {
      Systrace.endSection(0L);
      ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
    }
    Systrace.endSection(0L);
    ReactMarker.logMarker(ReactMarkerConstants.NATIVE_MODULE_INITIALIZE_END);
  }

  public void onBatchComplete()
  {
    ModuleHolder localModuleHolder = (ModuleHolder)this.mModules.get("UIManager");
    if ((localModuleHolder != null) && (localModuleHolder.hasInstance()))
      ((OnBatchCompleteListener)localModuleHolder.getModule()).onBatchComplete();
  }

  void registerModules(NativeModuleRegistry paramNativeModuleRegistry)
  {
    Assertions.assertCondition(this.mReactApplicationContext.equals(paramNativeModuleRegistry.getReactApplicationContext()), "Extending native modules with non-matching application contexts.");
    Iterator localIterator = paramNativeModuleRegistry.getModuleMap().entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      String str = (String)localEntry.getKey();
      if (!this.mModules.containsKey(str))
      {
        ModuleHolder localModuleHolder = (ModuleHolder)localEntry.getValue();
        this.mModules.put(str, localModuleHolder);
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.NativeModuleRegistry
 * JD-Core Version:    0.6.2
 */