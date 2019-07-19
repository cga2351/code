package com.facebook.react;

import com.facebook.react.bridge.NativeModule;
import javax.inject.Provider;

public class EagerModuleProvider
  implements Provider<NativeModule>
{
  private final NativeModule mModule;

  public EagerModuleProvider(NativeModule paramNativeModule)
  {
    this.mModule = paramNativeModule;
  }

  public NativeModule get()
  {
    return this.mModule;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.EagerModuleProvider
 * JD-Core Version:    0.6.2
 */