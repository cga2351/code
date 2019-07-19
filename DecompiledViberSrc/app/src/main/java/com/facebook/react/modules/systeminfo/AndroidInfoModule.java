package com.facebook.react.modules.systeminfo;

import android.annotation.SuppressLint;
import android.app.UiModeManager;
import android.os.Build;
import android.os.Build.VERSION;
import android.provider.Settings.Secure;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.facebook.react.module.annotations.ReactModule;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@ReactModule(name="PlatformConstants")
@SuppressLint({"HardwareIds"})
public class AndroidInfoModule extends ReactContextBaseJavaModule
{
  private static final String IS_TESTING = "IS_TESTING";
  public static final String NAME = "PlatformConstants";

  public AndroidInfoModule(ReactApplicationContext paramReactApplicationContext)
  {
    super(paramReactApplicationContext);
  }

  private String uiMode()
  {
    switch (((UiModeManager)getReactApplicationContext().getSystemService("uimode")).getCurrentModeType())
    {
    case 5:
    default:
      return "unknown";
    case 4:
      return "tv";
    case 3:
      return "car";
    case 2:
      return "desk";
    case 6:
      return "watch";
    case 1:
    }
    return "normal";
  }

  @ReactMethod(isBlockingSynchronousMethod=true)
  public String getAndroidID()
  {
    return Settings.Secure.getString(getReactApplicationContext().getContentResolver(), "android_id");
  }

  @Nullable
  public Map<String, Object> getConstants()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("Version", Integer.valueOf(Build.VERSION.SDK_INT));
    localHashMap.put("Release", Build.VERSION.RELEASE);
    localHashMap.put("Serial", Build.SERIAL);
    localHashMap.put("Fingerprint", Build.FINGERPRINT);
    localHashMap.put("Model", Build.MODEL);
    localHashMap.put("isTesting", Boolean.valueOf("true".equals(System.getProperty("IS_TESTING"))));
    localHashMap.put("reactNativeVersion", ReactNativeVersion.VERSION);
    localHashMap.put("uiMode", uiMode());
    return localHashMap;
  }

  public String getName()
  {
    return "PlatformConstants";
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.modules.systeminfo.AndroidInfoModule
 * JD-Core Version:    0.6.2
 */