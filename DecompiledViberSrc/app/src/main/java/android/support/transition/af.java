package android.support.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class af extends ae
{
  private static Method a;
  private static boolean b;
  private static Method c;
  private static boolean d;

  private void a()
  {
    if (!b);
    try
    {
      a = View.class.getDeclaredMethod("transformMatrixToGlobal", new Class[] { Matrix.class });
      a.setAccessible(true);
      b = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToGlobal method", localNoSuchMethodException);
    }
  }

  private void b()
  {
    if (!d);
    try
    {
      c = View.class.getDeclaredMethod("transformMatrixToLocal", new Class[] { Matrix.class });
      c.setAccessible(true);
      d = true;
      return;
    }
    catch (NoSuchMethodException localNoSuchMethodException)
    {
      while (true)
        Log.i("ViewUtilsApi21", "Failed to retrieve transformMatrixToLocal method", localNoSuchMethodException);
    }
  }

  public void a(View paramView, Matrix paramMatrix)
  {
    a();
    if (a != null);
    try
    {
      a.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException.getCause());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
  }

  public void b(View paramView, Matrix paramMatrix)
  {
    b();
    if (c != null);
    try
    {
      c.invoke(paramView, new Object[] { paramMatrix });
      return;
    }
    catch (InvocationTargetException localInvocationTargetException)
    {
      throw new RuntimeException(localInvocationTargetException.getCause());
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.transition.af
 * JD-Core Version:    0.6.2
 */