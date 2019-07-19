package android.support.v4.widget;

import android.os.Build.VERSION;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewCompat;
import android.util.Log;
import android.view.View;
import android.widget.PopupWindow;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public final class PopupWindowCompat
{
  private static final String TAG = "PopupWindowCompatApi21";
  private static Method sGetWindowLayoutTypeMethod;
  private static boolean sGetWindowLayoutTypeMethodAttempted;
  private static Field sOverlapAnchorField;
  private static boolean sOverlapAnchorFieldAttempted;
  private static Method sSetWindowLayoutTypeMethod;
  private static boolean sSetWindowLayoutTypeMethodAttempted;

  public static boolean getOverlapAnchor(PopupWindow paramPopupWindow)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramPopupWindow.getOverlapAnchor();
    if (Build.VERSION.SDK_INT >= 21)
    {
      if (!sOverlapAnchorFieldAttempted);
      try
      {
        sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        sOverlapAnchorField.setAccessible(true);
        sOverlapAnchorFieldAttempted = true;
        if (sOverlapAnchorField == null);
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        try
        {
          boolean bool = ((Boolean)sOverlapAnchorField.get(paramPopupWindow)).booleanValue();
          return bool;
          localNoSuchFieldException = localNoSuchFieldException;
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.i("PopupWindowCompatApi21", "Could not get overlap anchor field in PopupWindow", localIllegalAccessException);
        }
      }
    }
    return false;
  }

  public static int getWindowLayoutType(PopupWindow paramPopupWindow)
  {
    if (Build.VERSION.SDK_INT >= 23)
      return paramPopupWindow.getWindowLayoutType();
    if (!sGetWindowLayoutTypeMethodAttempted);
    try
    {
      sGetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("getWindowLayoutType", new Class[0]);
      sGetWindowLayoutTypeMethod.setAccessible(true);
      label40: sGetWindowLayoutTypeMethodAttempted = true;
      if (sGetWindowLayoutTypeMethod != null)
        try
        {
          int i = ((Integer)sGetWindowLayoutTypeMethod.invoke(paramPopupWindow, new Object[0])).intValue();
          return i;
        }
        catch (Exception localException1)
        {
        }
      return 0;
    }
    catch (Exception localException2)
    {
      break label40;
    }
  }

  public static void setOverlapAnchor(PopupWindow paramPopupWindow, boolean paramBoolean)
  {
    if (Build.VERSION.SDK_INT >= 23)
      paramPopupWindow.setOverlapAnchor(paramBoolean);
    while (true)
    {
      return;
      if (Build.VERSION.SDK_INT < 21)
        continue;
      if (!sOverlapAnchorFieldAttempted);
      try
      {
        sOverlapAnchorField = PopupWindow.class.getDeclaredField("mOverlapAnchor");
        sOverlapAnchorField.setAccessible(true);
        sOverlapAnchorFieldAttempted = true;
        if (sOverlapAnchorField == null)
          continue;
        try
        {
          sOverlapAnchorField.set(paramPopupWindow, Boolean.valueOf(paramBoolean));
          return;
        }
        catch (IllegalAccessException localIllegalAccessException)
        {
          Log.i("PopupWindowCompatApi21", "Could not set overlap anchor field in PopupWindow", localIllegalAccessException);
          return;
        }
      }
      catch (NoSuchFieldException localNoSuchFieldException)
      {
        while (true)
          Log.i("PopupWindowCompatApi21", "Could not fetch mOverlapAnchor field from PopupWindow", localNoSuchFieldException);
      }
    }
  }

  public static void setWindowLayoutType(PopupWindow paramPopupWindow, int paramInt)
  {
    if (Build.VERSION.SDK_INT >= 23)
      paramPopupWindow.setWindowLayoutType(paramInt);
    while (true)
    {
      return;
      if (!sSetWindowLayoutTypeMethodAttempted);
      try
      {
        Class[] arrayOfClass = new Class[1];
        arrayOfClass[0] = Integer.TYPE;
        sSetWindowLayoutTypeMethod = PopupWindow.class.getDeclaredMethod("setWindowLayoutType", arrayOfClass);
        sSetWindowLayoutTypeMethod.setAccessible(true);
        label52: sSetWindowLayoutTypeMethodAttempted = true;
        if (sSetWindowLayoutTypeMethod == null)
          continue;
        try
        {
          Method localMethod = sSetWindowLayoutTypeMethod;
          Object[] arrayOfObject = new Object[1];
          arrayOfObject[0] = Integer.valueOf(paramInt);
          localMethod.invoke(paramPopupWindow, arrayOfObject);
          return;
        }
        catch (Exception localException1)
        {
        }
      }
      catch (Exception localException2)
      {
        break label52;
      }
    }
  }

  public static void showAsDropDown(PopupWindow paramPopupWindow, View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    if (Build.VERSION.SDK_INT >= 19)
    {
      paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2, paramInt3);
      return;
    }
    if ((0x7 & GravityCompat.getAbsoluteGravity(paramInt3, ViewCompat.getLayoutDirection(paramView))) == 5)
      paramInt1 -= paramPopupWindow.getWidth() - paramView.getWidth();
    paramPopupWindow.showAsDropDown(paramView, paramInt1, paramInt2);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v4.widget.PopupWindowCompat
 * JD-Core Version:    0.6.2
 */