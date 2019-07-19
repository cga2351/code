package com.viber.voip.camera.e;

import android.os.Build;
import java.util.Locale;

public final class b
{
  public static boolean a()
  {
    return (c()) && (d()) && (b());
  }

  public static boolean b()
  {
    if (Build.MODEL != null);
    for (String str = Build.MODEL.toLowerCase(Locale.US); (str.contains("galaxy")) && (str.contains("nexus")); str = "")
      return true;
    return false;
  }

  public static boolean c()
  {
    return "google".equalsIgnoreCase(Build.BRAND);
  }

  public static boolean d()
  {
    return "samsung".equalsIgnoreCase(Build.MANUFACTURER);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.e.b
 * JD-Core Version:    0.6.2
 */