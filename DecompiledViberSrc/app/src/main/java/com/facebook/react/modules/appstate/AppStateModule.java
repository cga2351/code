package com.facebook.react.modules.appstate;

import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.Callback;
import com.facebook.react.bridge.LifecycleEventListener;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.bridge.WritableMap;
import com.facebook.react.common.LifecycleState;
import com.facebook.react.module.annotations.ReactModule;
import com.facebook.react.modules.core.DeviceEventManagerModule.RCTDeviceEventEmitter;
import java.util.HashMap;
import java.util.Map;

@ReactModule(name="AppState")
public class AppStateModule extends ReactContextBaseJavaModule
  implements LifecycleEventListener
{
  public static final String APP_STATE_ACTIVE = "active";
  public static final String APP_STATE_BACKGROUND = "background";
  private static final String INITIAL_STATE = "initialAppState";
  protected static final String NAME = "AppState";
  private String mAppState;

  public AppStateModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
    paramReactApplicationContext.addLifecycleEventListener(this);
    if (paramReactApplicationContext.getLifecycleState() == LifecycleState.RESUMED);
    for (String str = "active"; ; str = "background")
    {
      this.mAppState = str;
      return;
    }
  }

  private WritableMap createAppStateEventMap()
  {
    WritableMap localWritableMap = Arguments.createMap();
    localWritableMap.putString("app_state", this.mAppState);
    return localWritableMap;
  }

  private void sendAppStateChangeEvent()
  {
    ((DeviceEventManagerModule.RCTDeviceEventEmitter)getReactApplicationContext().getJSModule(DeviceEventManagerModule.RCTDeviceEventEmitter.class)).emit("appStateDidChange", createAppStateEventMap());
  }

  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("initialAppState", this.mAppState);
    return localHashMap;
  }

  @ReactMethod
  public void getCurrentAppState(Callback paramCallback1, Callback paramCallback2)
  {
    Object[] arrayOfObject = new Object[1];
    arrayOfObject[0] = createAppStateEventMap();
    paramCallback1.invoke(arrayOfObject);
  }

  public String getName()
  {
    return "AppState";
  }

  public void onHostDestroy()
  {
  }

  public void onHostPause()
  {
    this.mAppState = "background";
    sendAppStateChangeEvent();
  }

  public void onHostResume()
  {
    this.mAppState = "active";
    sendAppStateChangeEvent();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.appstate.AppStateModule
 * JD-Core Version:    0.6.2
 */