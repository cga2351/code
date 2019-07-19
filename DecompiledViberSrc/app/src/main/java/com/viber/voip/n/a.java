package com.viber.voip.n;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.provider.Settings.System;
import android.view.Display;
import android.view.WindowManager;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;

public final class a
{
  private static final Logger a = ViberEnv.getLogger();

  public static void a(Activity paramActivity)
  {
    if (a(paramActivity))
      return;
    paramActivity.setRequestedOrientation(e(paramActivity));
  }

  public static void a(Activity paramActivity, int paramInt)
  {
    try
    {
      paramActivity.setRequestedOrientation(paramInt);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public static void a(boolean paramBoolean, Activity paramActivity, int paramInt)
  {
    a(paramBoolean, paramActivity, paramInt, false, true);
  }

  public static void a(boolean paramBoolean1, Activity paramActivity, int paramInt, boolean paramBoolean2, boolean paramBoolean3)
  {
    if (paramBoolean1)
    {
      if (!com.viber.common.d.a.m())
        a(paramActivity, paramInt);
      dj.a(paramActivity, paramBoolean2, paramBoolean3);
      return;
    }
    a(paramActivity, paramInt);
  }

  public static boolean a(Context paramContext)
  {
    return Settings.System.getInt(paramContext.getContentResolver(), "accelerometer_rotation", 1) != 1;
  }

  public static void b(Activity paramActivity)
  {
    if (a(paramActivity))
      return;
    paramActivity.setRequestedOrientation(-1);
  }

  public static void c(Activity paramActivity)
  {
    try
    {
      if (paramActivity.getResources().getConfiguration().orientation == 1)
      {
        paramActivity.setRequestedOrientation(1);
        return;
      }
      paramActivity.setRequestedOrientation(0);
      return;
    }
    catch (IllegalStateException localIllegalStateException)
    {
    }
  }

  public static void d(Activity paramActivity)
  {
    a(paramActivity, 1);
  }

  private static int e(Activity paramActivity)
  {
    int i = ((WindowManager)paramActivity.getSystemService("window")).getDefaultDisplay().getRotation();
    paramActivity.getResources().getDisplayMetrics();
    if (dj.c(paramActivity))
    {
      if ((i == 0) || (i == 1))
        return 0;
      return 8;
    }
    if ((i == 1) || (i == 2))
      return 9;
    return 1;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.n.a
 * JD-Core Version:    0.6.2
 */