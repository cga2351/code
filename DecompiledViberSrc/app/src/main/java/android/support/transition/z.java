package android.support.transition;

import android.util.Log;
import android.view.ViewGroup;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class z
{
  private static Method a;
  private static boolean b;

  private static void a()
  {
    if (!b);
    try
    {
      Class[] arrayOfClass = new Class[1];
      arrayOfClass[0] = Boolean.TYPE;
      a = ViewGroup.class.getDeclaredMethod("suppressLayout", arrayOfClass);
      a.setAccessible(true);
      b = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        Log.i("ViewUtilsApi18", "Failed to retrieve suppressLayout method", localNoSuchMethodException);
    }
  }

  static void a(ViewGroup paramViewGroup, boolean paramBoolean)
  {
    a();
    if (a != null);
    try
    {
      Method localMethod = a;
      Object[] arrayOfObject = new Object[1];
      arrayOfObject[0] = Boolean.valueOf(paramBoolean);
      localMethod.invoke(paramViewGroup, arrayOfObject);
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      Log.i("ViewUtilsApi18", "Failed to invoke suppressLayout method", localIllegalAccessException);
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      Log.i("ViewUtilsApi18", "Error invoking suppressLayout method", localInvocationTargetException);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.z
 * JD-Core Version:    0.6.2
 */