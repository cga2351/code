package com.facebook.react.bridge;

public abstract interface JSIModuleSpec<T extends JSIModule>
{
  public abstract Class<? extends JSIModule> getJSIModuleClass();

  public abstract JSIModuleProvider<T> getJSIModuleProvider();
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSIModuleSpec
 * JD-Core Version:    0.6.2
 */