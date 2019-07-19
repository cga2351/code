package android.support.v4.view;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.os.Build.VERSION;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewConfiguration;
import java.lang.reflect.Method;

public final class ViewConfigurationCompat
{
  private static final String TAG = "ViewConfigCompat";
  private static Method sGetScaledScrollFactorMethod;

  static
  {
    if (Build.VERSION.SDK_INT == 25);
    try
    {
      sGetScaledScrollFactorMethod = ViewConfiguration.class.getDeclaredMethod("getScaledScrollFactor", new Class[0]);
      return;
    }
    catch (Exception localException)
    {
      Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
    }
  }

  private static float getLegacyScrollFactor(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if ((Build.VERSION.SDK_INT >= 25) && (sGetScaledScrollFactorMethod != null))
      try
      {
        int i = ((Integer)sGetScaledScrollFactorMethod.invoke(paramViewConfiguration, new Object[0])).intValue();
        return i;
      }
      catch (Exception localException)
      {
        Log.i("ViewConfigCompat", "Could not find method getScaledScrollFactor() on ViewConfiguration");
      }
    TypedValue localTypedValue = new TypedValue();
    if (paramContext.getTheme().resolveAttribute(16842829, localTypedValue, true))
      return localTypedValue.getDimension(paramContext.getResources().getDisplayMetrics());
    return 0.0F;
  }

  public static float getScaledHorizontalScrollFactor(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramViewConfiguration.getScaledHorizontalScrollFactor();
    return getLegacyScrollFactor(paramViewConfiguration, paramContext);
  }

  public static int getScaledHoverSlop(ViewConfiguration paramViewConfiguration)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramViewConfiguration.getScaledHoverSlop();
    return paramViewConfiguration.getScaledTouchSlop() / 2;
  }

  @Deprecated
  public static int getScaledPagingTouchSlop(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.getScaledPagingTouchSlop();
  }

  public static float getScaledVerticalScrollFactor(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 26)
      return paramViewConfiguration.getScaledVerticalScrollFactor();
    return getLegacyScrollFactor(paramViewConfiguration, paramContext);
  }

  @Deprecated
  public static boolean hasPermanentMenuKey(ViewConfiguration paramViewConfiguration)
  {
    return paramViewConfiguration.hasPermanentMenuKey();
  }

  public static boolean shouldShowMenuShortcutsWhenKeyboardPresent(ViewConfiguration paramViewConfiguration, Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 28)
      return paramViewConfiguration.shouldShowMenuShortcutsWhenKeyboardPresent();
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("config_showMenuShortcutsWhenKeyboardPresent", "bool", "android");
    return (i != 0) && (localResources.getBoolean(i));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.view.ViewConfigurationCompat
 * JD-Core Version:    0.6.2
 */