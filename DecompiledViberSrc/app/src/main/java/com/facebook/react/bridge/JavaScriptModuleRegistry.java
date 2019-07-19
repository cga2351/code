package com.facebook.react.bridge;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.HashMap;
import javax.annotation.Nullable;

public final class JavaScriptModuleRegistry
{
  private final HashMap<Class<? extends JavaScriptModule>, JavaScriptModule> mModuleInstances = new HashMap();

  public <T extends JavaScriptModule> T getJavaScriptModule(CatalystInstance paramCatalystInstance, Class<T> paramClass)
  {
    try
    {
      JavaScriptModule localJavaScriptModule = (JavaScriptModule)this.mModuleInstances.get(paramClass);
      if (localJavaScriptModule != null);
      while (true)
      {
        return localJavaScriptModule;
        localJavaScriptModule = (JavaScriptModule)Proxy.newProxyInstance(paramClass.getClassLoader(), new Class[] { paramClass }, new JavaScriptModuleInvocationHandler(paramCatalystInstance, paramClass));
        this.mModuleInstances.put(paramClass, localJavaScriptModule);
      }
    }
    finally
    {
    }
  }

  private static class JavaScriptModuleInvocationHandler
    implements InvocationHandler
  {
    private final CatalystInstance mCatalystInstance;
    private final Class<? extends JavaScriptModule> mModuleInterface;

    @Nullable
    private String mName;

    public JavaScriptModuleInvocationHandler(CatalystInstance paramCatalystInstance, Class<? extends JavaScriptModule> paramClass)
    {
      this.mCatalystInstance = paramCatalystInstance;
      this.mModuleInterface = paramClass;
    }

    private String getJSModuleName()
    {
      if (this.mName == null)
      {
        String str = this.mModuleInterface.getSimpleName();
        int i = str.lastIndexOf('$');
        if (i != -1)
          str = str.substring(i + 1);
        this.mName = str;
      }
      return this.mName;
    }

    @Nullable
    public Object invoke(Object paramObject, Method paramMethod, @Nullable Object[] paramArrayOfObject)
      throws Throwable
    {
      if (paramArrayOfObject != null);
      for (WritableNativeArray localWritableNativeArray = Arguments.fromJavaArgs(paramArrayOfObject); ; localWritableNativeArray = new WritableNativeArray())
      {
        this.mCatalystInstance.callFunction(getJSModuleName(), paramMethod.getName(), localWritableNativeArray);
        return null;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JavaScriptModuleRegistry
 * JD-Core Version:    0.6.2
 */