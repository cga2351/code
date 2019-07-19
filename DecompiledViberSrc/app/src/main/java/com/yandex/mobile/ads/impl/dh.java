package com.yandex.mobile.ads.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.Rect;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.Comparator;
import java.util.Map.Entry;

public final class dh
{
  private static final Comparator<Map.Entry<Integer, Integer>> a = new Comparator()
  {
  };

  public static int a(int paramInt, float paramFloat)
  {
    return Color.argb(Math.max(0, Math.min(255, (int)(255.0F * (100.0F - paramFloat) / 100.0F))), Color.red(paramInt), Color.green(paramInt), Color.blue(paramInt));
  }

  public static int a(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().widthPixels;
  }

  @Deprecated
  public static int a(Context paramContext, float paramFloat)
  {
    new cy();
    return cy.a(paramContext, paramFloat);
  }

  @Deprecated
  public static int a(Context paramContext, int paramInt)
  {
    new cy();
    float f = paramContext.getResources().getDisplayMetrics().density;
    return Math.round(paramInt / f);
  }

  public static void a(View paramView)
  {
    if (paramView != null);
    try
    {
      if ((paramView.getParent() instanceof ViewGroup))
        ((ViewGroup)paramView.getParent()).removeView(paramView);
      try
      {
        label25: if ((paramView instanceof ViewGroup))
          ((ViewGroup)paramView).removeAllViews();
        return;
      }
      catch (Exception localException2)
      {
      }
    }
    catch (Exception localException1)
    {
      break label25;
    }
  }

  public static void a(final View paramView, ViewTreeObserver.OnPreDrawListener paramOnPreDrawListener)
  {
    paramView.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
    {
      public final boolean onPreDraw()
      {
        this.a.onPreDraw();
        paramView.getViewTreeObserver().removeOnPreDrawListener(this);
        return true;
      }
    });
  }

  public static boolean a(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    return arrayOfFloat[2] < 0.5F;
  }

  public static boolean a(Context paramContext, View paramView)
  {
    boolean bool = false;
    int j;
    if (paramView != null)
    {
      Rect localRect = b(paramView);
      int i = b(paramContext);
      if ((localRect.bottom > 0) && (localRect.top < i))
        break label79;
      j = 1;
      int k = a(paramContext);
      if ((localRect.right > 0) && (localRect.left < k))
        break label85;
    }
    label79: label85: for (int m = 1; ; m = 0)
    {
      bool = false;
      if (j == 0)
      {
        bool = false;
        if (m == 0)
          bool = true;
      }
      return bool;
      j = 0;
      break;
    }
  }

  public static boolean a(View paramView, int paramInt)
  {
    return e(paramView) >= paramInt;
  }

  public static int b(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().heightPixels;
  }

  public static Rect b(View paramView)
  {
    if (paramView != null)
    {
      int[] arrayOfInt = new int[2];
      paramView.getLocationOnScreen(arrayOfInt);
      int i = arrayOfInt[0];
      int j = arrayOfInt[1];
      return new Rect(i, j, i + paramView.getWidth(), j + paramView.getHeight());
    }
    return null;
  }

  public static int c(Context paramContext)
  {
    return (int)(0.5F + (0.0F + a(paramContext)) / e(paramContext));
  }

  public static Bitmap c(View paramView)
  {
    if (paramView != null)
      try
      {
        paramView.setDrawingCacheEnabled(true);
        float f = 1.0F / e(paramView.getContext()) / 5.0F;
        int i = Math.round(f * paramView.getWidth());
        int j = Math.round(f * paramView.getHeight());
        Bitmap localBitmap = Bitmap.createScaledBitmap(paramView.getDrawingCache(), i, j, true);
        paramView.setDrawingCacheEnabled(false);
        return localBitmap;
      }
      catch (Exception localException)
      {
      }
    return null;
  }

  public static int d(Context paramContext)
  {
    return (int)(0.5F + (0.0F + b(paramContext)) / e(paramContext));
  }

  public static boolean d(View paramView)
  {
    if (paramView.isShown())
      if ((Build.VERSION.SDK_INT < 11) || (paramView.getAlpha() != 0.0F))
        break label36;
    label36: for (int i = 0; ; i = 1)
    {
      boolean bool = false;
      if (i == 0)
        bool = true;
      return bool;
    }
  }

  public static float e(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().density;
  }

  public static int e(View paramView)
  {
    if ((paramView != null) && (paramView.isShown()))
    {
      Rect localRect = new Rect();
      if (paramView.getGlobalVisibleRect(localRect))
      {
        int i = localRect.width();
        int j = localRect.height();
        int k;
        if (paramView.getLayoutParams().width > 0)
        {
          k = paramView.getLayoutParams().width;
          if (paramView.getLayoutParams().height <= 0)
            break label112;
        }
        label112: for (int m = paramView.getLayoutParams().height; ; m = paramView.getHeight())
        {
          int n = 100 * (i * j) / (k * m);
          new Object[1][0] = Integer.valueOf(n);
          return n;
          k = paramView.getWidth();
          break;
        }
      }
    }
    return 0;
  }

  public static int f(Context paramContext)
  {
    return paramContext.getResources().getDisplayMetrics().densityDpi;
  }

  public static int g(Context paramContext)
  {
    return Math.min(c(paramContext), d(paramContext));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.yandex.mobile.ads.impl.dh
 * JD-Core Version:    0.6.2
 */