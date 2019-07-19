package com.viber.voip.vln;

import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

public class MixpanelModule extends ReactContextBaseJavaModule
{
  private static final String MODULE_NAME = "Mixpanel";

  public MixpanelModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  public String getName()
  {
    return "Mixpanel";
  }

  @ReactMethod
  public void registerSuperProperties(String paramString)
  {
  }

  @ReactMethod
  public void registerSuperPropertiesOnce(String paramString)
  {
  }

  @ReactMethod
  public void track(String paramString)
  {
  }

  @ReactMethod
  public void trackWithProperties(String paramString1, String paramString2)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.vln.MixpanelModule
 * JD-Core Version:    0.6.2
 */