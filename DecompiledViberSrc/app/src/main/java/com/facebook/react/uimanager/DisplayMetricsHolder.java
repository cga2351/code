package com.facebook.react.uimanager;

import android.content.Context;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;
import com.facebook.react.bridge.WritableNativeMap;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

public class DisplayMetricsHolder
{

  @Nullable
  private static DisplayMetrics sScreenDisplayMetrics;

  @Nullable
  private static DisplayMetrics sWindowDisplayMetrics;

  public static Map<String, Map<String, Object>> getDisplayMetricsMap(double paramDouble)
  {
    if ((sWindowDisplayMetrics != null) || (sScreenDisplayMetrics != null));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertNotNull(Boolean.valueOf(bool), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
      HashMap localHashMap = new HashMap();
      localHashMap.put("windowPhysicalPixels", getPhysicalPixelsMap(sWindowDisplayMetrics, paramDouble));
      localHashMap.put("screenPhysicalPixels", getPhysicalPixelsMap(sScreenDisplayMetrics, paramDouble));
      return localHashMap;
    }
  }

  public static WritableNativeMap getDisplayMetricsNativeMap(double paramDouble)
  {
    if ((sWindowDisplayMetrics != null) || (sScreenDisplayMetrics != null));
    for (boolean bool = true; ; bool = false)
    {
      Assertions.assertNotNull(Boolean.valueOf(bool), "DisplayMetricsHolder must be initialized with initDisplayMetricsIfNotInitialized or initDisplayMetrics");
      WritableNativeMap localWritableNativeMap = new WritableNativeMap();
      localWritableNativeMap.putMap("windowPhysicalPixels", getPhysicalPixelsNativeMap(sWindowDisplayMetrics, paramDouble));
      localWritableNativeMap.putMap("screenPhysicalPixels", getPhysicalPixelsNativeMap(sScreenDisplayMetrics, paramDouble));
      return localWritableNativeMap;
    }
  }

  private static Map<String, Object> getPhysicalPixelsMap(DisplayMetrics paramDisplayMetrics, double paramDouble)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("width", Integer.valueOf(paramDisplayMetrics.widthPixels));
    localHashMap.put("height", Integer.valueOf(paramDisplayMetrics.heightPixels));
    localHashMap.put("scale", Float.valueOf(paramDisplayMetrics.density));
    localHashMap.put("fontScale", Double.valueOf(paramDouble));
    localHashMap.put("densityDpi", Integer.valueOf(paramDisplayMetrics.densityDpi));
    return localHashMap;
  }

  private static WritableNativeMap getPhysicalPixelsNativeMap(DisplayMetrics paramDisplayMetrics, double paramDouble)
  {
    WritableNativeMap localWritableNativeMap = new WritableNativeMap();
    localWritableNativeMap.putInt("width", paramDisplayMetrics.widthPixels);
    localWritableNativeMap.putInt("height", paramDisplayMetrics.heightPixels);
    localWritableNativeMap.putDouble("scale", paramDisplayMetrics.density);
    localWritableNativeMap.putDouble("fontScale", paramDouble);
    localWritableNativeMap.putDouble("densityDpi", paramDisplayMetrics.densityDpi);
    return localWritableNativeMap;
  }

  public static DisplayMetrics getScreenDisplayMetrics()
  {
    return sScreenDisplayMetrics;
  }

  @Deprecated
  public static DisplayMetrics getWindowDisplayMetrics()
  {
    return sWindowDisplayMetrics;
  }

  public static void initDisplayMetrics(Context paramContext)
  {
    DisplayMetrics localDisplayMetrics1 = paramContext.getResources().getDisplayMetrics();
    setWindowDisplayMetrics(localDisplayMetrics1);
    DisplayMetrics localDisplayMetrics2 = new DisplayMetrics();
    localDisplayMetrics2.setTo(localDisplayMetrics1);
    WindowManager localWindowManager = (WindowManager)paramContext.getSystemService("window");
    Assertions.assertNotNull(localWindowManager, "WindowManager is null!");
    Display localDisplay = localWindowManager.getDefaultDisplay();
    if (Build.VERSION.SDK_INT >= 17)
      localDisplay.getRealMetrics(localDisplayMetrics2);
    while (true)
    {
      setScreenDisplayMetrics(localDisplayMetrics2);
      return;
      try
      {
        Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
        localDisplayMetrics2.widthPixels = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(localDisplay, new Object[0])).intValue();
        localDisplayMetrics2.heightPixels = ((Integer)localMethod.invoke(localDisplay, new Object[0])).intValue();
      }
      catch (InvocationTargetException localInvocationTargetException)
      {
        throw new RuntimeException("Error getting real dimensions for API level < 17", localInvocationTargetException);
      }
      catch (IllegalAccessException localIllegalAccessException)
      {
        break label138;
      }
      catch (NoSuchMethodException localNoSuchMethodException)
      {
        label138: break label138;
      }
    }
  }

  public static void initDisplayMetricsIfNotInitialized(Context paramContext)
  {
    if (getScreenDisplayMetrics() != null)
      return;
    initDisplayMetrics(paramContext);
  }

  public static void setScreenDisplayMetrics(DisplayMetrics paramDisplayMetrics)
  {
    sScreenDisplayMetrics = paramDisplayMetrics;
  }

  public static void setWindowDisplayMetrics(DisplayMetrics paramDisplayMetrics)
  {
    sWindowDisplayMetrics = paramDisplayMetrics;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.DisplayMetricsHolder
 * JD-Core Version:    0.6.2
 */