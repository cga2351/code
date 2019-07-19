package com.facebook.react.bridge;

import com.facebook.common.logging.FLog;
import com.facebook.react.module.annotations.ReactModule;
import javax.annotation.Nullable;
import javax.inject.Provider;

public class ModuleSpec
{
  private static final String TAG = "ModuleSpec";
  private final String mName;
  private final Provider<? extends NativeModule> mProvider;

  @Nullable
  private final Class<? extends NativeModule> mType = null;

  private ModuleSpec(Provider<? extends NativeModule> paramProvider)
  {
    this.mProvider = paramProvider;
    this.mName = null;
  }

  private ModuleSpec(Provider<? extends NativeModule> paramProvider, String paramString)
  {
    this.mProvider = paramProvider;
    this.mName = paramString;
  }

  public static ModuleSpec nativeModuleSpec(Class<? extends NativeModule> paramClass, Provider<? extends NativeModule> paramProvider)
  {
    ReactModule localReactModule = (ReactModule)paramClass.getAnnotation(ReactModule.class);
    if (localReactModule == null)
    {
      FLog.w("ModuleSpec", "Could not find @ReactModule annotation on " + paramClass.getName() + ". So creating the module eagerly to get the name. Consider adding an annotation to make this Lazy");
      return new ModuleSpec(paramProvider, ((NativeModule)paramProvider.get()).getName());
    }
    return new ModuleSpec(paramProvider, localReactModule.name());
  }

  public static ModuleSpec nativeModuleSpec(String paramString, Provider<? extends NativeModule> paramProvider)
  {
    return new ModuleSpec(paramProvider, paramString);
  }

  public static ModuleSpec viewManagerSpec(Provider<? extends NativeModule> paramProvider)
  {
    return new ModuleSpec(paramProvider);
  }

  public String getName()
  {
    return this.mName;
  }

  public Provider<? extends NativeModule> getProvider()
  {
    return this.mProvider;
  }

  @Nullable
  public Class<? extends NativeModule> getType()
  {
    return this.mType;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.ModuleSpec
 * JD-Core Version:    0.6.2
 */