package com.facebook.react.modules.deviceinfo;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.facebook.react.bridge.BaseJavaModule;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import com.facebook.react.uimanager.DisplayMetricsHolder;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="DeviceInfo")
public class DeviceInfoModule extends BaseJavaModule
  implements LifecycleEventListener
{
  public static final String NAME = "DeviceInfo";
  private float mFontScale;

  @Nullable
  private ReactApplicationContext mReactApplicationContext = null;

  public DeviceInfoModule(Context paramContext)
  {
    DisplayMetricsHolder.initDisplayMetricsIfNotInitialized(paramContext);
    this.mFontScale = paramContext.getResources().getConfiguration().fontScale;
  }

  public DeviceInfoModule(ReactApplicationContext paramReactApplicationContext)
  {
    this(paramReactApplicationContext);
    this.mReactApplicationContext = paramReactApplicationContext;
    this.mReactApplicationContext.addLifecycleEventListener(this);
  }

  public void emitUpdateDimensionsEvent()
  {
    if (this.mReactApplicationContext == null)
      return;
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)this.mReactApplicationContext.getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("didUpdateDimensions", DisplayMetricsHolder.getDisplayMetricsNativeMap(this.mFontScale));
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Dimensions", DisplayMetricsHolder.getDisplayMetricsMap(this.mFontScale));
    return localHashMap;
  }

  public String getName()
  {
    return "DeviceInfo";
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
  }

  public void onHostResume()
  {
    if (this.mReactApplicationContext == null);
    float f;
    do
    {
      return;
      f = this.mReactApplicationContext.getResources().getConfiguration().fontScale;
    }
    while (this.mFontScale == f);
    this.mFontScale = f;
    emitUpdateDimensionsEvent();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.deviceinfo.DeviceInfoModule
 * JD-Core Version:    0.6.2
 */