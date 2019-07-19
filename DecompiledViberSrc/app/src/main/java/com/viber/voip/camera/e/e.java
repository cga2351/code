package com.viber.voip.camera.e;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.view.WindowManager;
import java.lang.reflect.Method;

public final class e
{
  @TargetApi(17)
  public static Point a(Context paramContext)
  {
    Display localDisplay = ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay();
    int i;
    int j;
    if (Build.VERSION.SDK_INT >= 17)
    {
      DisplayMetrics localDisplayMetrics = new DisplayMetrics();
      localDisplay.getRealMetrics(localDisplayMetrics);
      i = localDisplayMetrics.widthPixels;
      j = localDisplayMetrics.heightPixels;
    }
    while (true)
    {
      return new Point(i, j);
      if (Build.VERSION.SDK_INT >= 14)
      {
        try
        {
          Method localMethod = Display.class.getMethod("getRawHeight", new Class[0]);
          i = ((Integer)Display.class.getMethod("getRawWidth", new Class[0]).invoke(localDisplay, new Object[0])).intValue();
          int k = ((Integer)localMethod.invoke(localDisplay, new Object[0])).intValue();
          j = k;
        }
        catch (Exception localException)
        {
          i = localDisplay.getWidth();
          j = localDisplay.getHeight();
        }
      }
      else
      {
        i = localDisplay.getWidth();
        j = localDisplay.getHeight();
      }
    }
  }

  public static void a(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramInt != paramView.getVisibility()))
      paramView.setVisibility(paramInt);
  }

  public static void a(View paramView, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.getViewTreeObserver().removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
      return;
    }
    paramView.getViewTreeObserver().removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }

  public static void a(View paramView, final Runnable paramRunnable)
  {
    paramView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      @SuppressLint({"NewApi"})
      public void onGlobalLayout()
      {
        e.a(this.a, this);
        paramRunnable.run();
      }
    });
  }

  public static boolean a(float paramFloat1, float paramFloat2, View paramView)
  {
    return (paramFloat1 >= 0.0F) && (paramFloat2 >= 0.0F) && (paramFloat1 <= paramView.getWidth()) && (paramFloat2 <= paramView.getHeight());
  }

  public static void b(View paramView, int paramInt)
  {
    if ((paramView != null) && (paramInt != paramView.getRotation()))
      paramView.setRotation(paramInt);
  }

  public static void c(View paramView, int paramInt)
  {
    if (paramView != null)
      if (paramInt % 180 != 0)
        break label28;
    label28: for (int i = 0; ; i = paramView.getHeight() / 2 - paramView.getWidth() / 2)
    {
      paramView.setTranslationX(i);
      paramView.setTranslationY(-i);
      return;
    }
  }

  public static void d(View paramView, int paramInt)
  {
    if (paramView != null)
      if (paramInt % 180 != 0)
        break label29;
    label29: for (int i = 0; ; i = paramView.getHeight() / 2 - paramView.getWidth() / 2)
    {
      paramView.setTranslationX(-i);
      paramView.setTranslationY(-i);
      return;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.camera.e.e
 * JD-Core Version:    0.6.2
 */