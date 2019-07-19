package pl.droidsonroids.gif;

import android.annotation.SuppressLint;
import android.content.Context;
import java.lang.reflect.Method;

public class j
{

  @SuppressLint({"StaticFieldLeak"})
  private static Context a;

  private static Context a()
  {
    if (a == null);
    try
    {
      a = (Context)Class.forName("android.app.ActivityThread").getDeclaredMethod("currentApplication", new Class[0]).invoke(null, new Object[0]);
      return a;
    }
    catch (Exception localException)
    {
      throw new IllegalStateException("LibraryLoader not initialized. Call LibraryLoader.initialize() before using library classes.", localException);
    }
  }

  static void a(Context paramContext)
  {
    try
    {
      System.loadLibrary("pl_droidsonroids_gif");
      return;
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      if (paramContext == null)
        paramContext = a();
      l.a(paramContext);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     pl.droidsonroids.gif.j
 * JD-Core Version:    0.6.2
 */