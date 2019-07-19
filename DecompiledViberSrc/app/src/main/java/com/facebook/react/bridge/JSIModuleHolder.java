package com.facebook.react.bridge;

public class JSIModuleHolder
{
  private JSIModule mModule;
  private final JSIModuleSpec mSpec;

  public JSIModuleHolder(JSIModuleSpec paramJSIModuleSpec)
  {
    this.mSpec = paramJSIModuleSpec;
  }

  public JSIModule getJSIModule()
  {
    if (this.mModule == null);
    try
    {
      if (this.mModule != null)
      {
        JSIModule localJSIModule = this.mModule;
        return localJSIModule;
      }
      this.mModule = this.mSpec.getJSIModuleProvider().get();
      this.mModule.initialize();
      return this.mModule;
    }
    finally
    {
    }
  }

  public void notifyJSInstanceDestroy()
  {
    if (this.mModule != null)
      this.mModule.onCatalystInstanceDestroy();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.bridge.JSIModuleHolder
 * JD-Core Version:    0.6.2
 */