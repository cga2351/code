package com.viber.voip.util;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.ActivityManager.TaskDescription;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import com.viber.common.b.h;
import com.viber.common.d.a;
import com.viber.voip.R.color;
import com.viber.voip.R.drawable;
import com.viber.voip.settings.d.bc;
import com.viber.voip.ui.j.ax;

public class dc
{
  public static int a(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      int i = localTypedArray.getResourceId(0, 0);
      return i;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static int a(Context paramContext, int paramInt1, int paramInt2)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt1 });
    try
    {
      int i = localTypedArray.getColor(0, paramInt2);
      return i;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static int a(Integer paramInteger, Context paramContext, int paramInt)
  {
    if (paramInteger != null)
      return paramInteger.intValue();
    return d(paramContext, paramInt);
  }

  public static ColorStateList a(ColorStateList paramColorStateList, Context paramContext, int paramInt)
  {
    if (paramColorStateList != null)
      return paramColorStateList;
    return e(paramContext, paramInt);
  }

  @TargetApi(21)
  public static void a(Activity paramActivity)
  {
    if ((paramActivity != null) && (a.g()))
    {
      int i = ContextCompat.getColor(paramActivity, R.color.negative);
      Bitmap localBitmap = dq.a(paramActivity.getResources(), R.drawable.logo_purple);
      paramActivity.setTaskDescription(new ActivityManager.TaskDescription(null, localBitmap, i));
      localBitmap.recycle();
    }
  }

  public static boolean a()
  {
    return ax.b.a().equals(d.bc.a.d());
  }

  public static boolean b()
  {
    return ax.a.a().equals(d.bc.a.d());
  }

  public static boolean b(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      boolean bool = localTypedArray.getBoolean(0, true);
      return bool;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static String c(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      String str = localTypedArray.getString(0);
      return str;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static int d(Context paramContext, int paramInt)
  {
    return a(paramContext, paramInt, 0);
  }

  public static ColorStateList e(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      ColorStateList localColorStateList = localTypedArray.getColorStateList(0);
      return localColorStateList;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public static ColorStateList f(Context paramContext, int paramInt)
  {
    int i = d(paramContext, paramInt);
    if (i == 0)
      return null;
    return ColorStateList.valueOf(i);
  }

  public static Drawable g(Context paramContext, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(new int[] { paramInt });
    try
    {
      Drawable localDrawable = localTypedArray.getDrawable(0);
      return localDrawable;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.dc
 * JD-Core Version:    0.6.2
 */