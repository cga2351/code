package com.viber.common.d;

import android.os.Build.VERSION;
import android.support.v4.os.BuildCompat;

public final class a
{
  public static boolean a()
  {
    return Build.VERSION.SDK_INT >= 16;
  }

  public static boolean b()
  {
    return Build.VERSION.SDK_INT >= 17;
  }

  public static boolean c()
  {
    return Build.VERSION.SDK_INT >= 18;
  }

  public static boolean d()
  {
    return Build.VERSION.SDK_INT >= 19;
  }

  public static boolean e()
  {
    return Build.VERSION.SDK_INT == 19;
  }

  public static boolean f()
  {
    return Build.VERSION.SDK_INT >= 20;
  }

  public static boolean g()
  {
    return Build.VERSION.SDK_INT >= 21;
  }

  public static boolean h()
  {
    return Build.VERSION.SDK_INT >= 22;
  }

  public static boolean i()
  {
    return (Build.VERSION.SDK_INT == 21) || (Build.VERSION.SDK_INT == 22);
  }

  public static boolean j()
  {
    return Build.VERSION.SDK_INT >= 23;
  }

  public static boolean k()
  {
    return Build.VERSION.SDK_INT >= 24;
  }

  public static boolean l()
  {
    return (Build.VERSION.SDK_INT == 24) || (Build.VERSION.SDK_INT == 25);
  }

  public static boolean m()
  {
    return Build.VERSION.SDK_INT >= 26;
  }

  public static boolean n()
  {
    return Build.VERSION.SDK_INT >= 28;
  }

  public static boolean o()
  {
    return BuildCompat.isAtLeastQ();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.d.a
 * JD-Core Version:    0.6.2
 */