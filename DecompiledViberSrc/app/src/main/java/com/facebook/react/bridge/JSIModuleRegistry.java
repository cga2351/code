package com.facebook.react.bridge;

import com.facebook.infer.annotation.Assertions;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class JSIModuleRegistry
{
  private final Map<Class, JSIModuleHolder> mModules = new HashMap();

  public <T extends JSIModule> T getModule(Class<T> paramClass)
  {
    JSIModuleHolder localJSIModuleHolder = (JSIModuleHolder)this.mModules.get(paramClass);
    if (localJSIModuleHolder == null)
      throw new IllegalArgumentException("Unable to find JSIModule for class " + paramClass);
    return (JSIModule)Assertions.assertNotNull(localJSIModuleHolder.getJSIModule());
  }

  public void notifyJSInstanceDestroy()
  {
    Iterator localIterator = this.mModules.values().iterator();
    while (localIterator.hasNext())
      ((JSIModuleHolder)localIterator.next()).notifyJSInstanceDestroy();
  }

  public void registerModules(List<JSIModuleSpec> paramList)
  {
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      JSIModuleSpec localJSIModuleSpec = (JSIModuleSpec)localIterator.next();
      this.mModules.put(localJSIModuleSpec.getJSIModuleClass(), new JSIModuleHolder(localJSIModuleSpec));
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSIModuleRegistry
 * JD-Core Version:    0.6.2
 */