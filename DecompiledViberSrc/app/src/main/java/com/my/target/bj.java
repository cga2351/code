package com.my.target;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.GradientDrawable.Orientation;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.util.StateSet;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.View.AccessibilityDelegate;
import android.view.Window;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.concurrent.atomic.AtomicInteger;

public class bj
{
  private static final AtomicInteger a = new AtomicInteger(1);
  private final Context b;

  private bj(Context paramContext)
  {
    this.b = paramContext;
  }

  public static int a()
  {
    if (Build.VERSION.SDK_INT < 17)
    {
      int i;
      int j;
      do
      {
        i = a.get();
        j = i + 1;
        if (j > 16777215)
          j = 1;
      }
      while (!a.compareAndSet(i, j));
      return i;
    }
    return View.generateViewId();
  }

  public static int a(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    arrayOfFloat[2] = (0.7F * arrayOfFloat[2]);
    return Color.HSVToColor(arrayOfFloat);
  }

  public static int a(int paramInt, Context paramContext)
  {
    Resources localResources = paramContext.getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }

  public static int a(Activity paramActivity)
  {
    int i = 9;
    int j = paramActivity.getWindowManager().getDefaultDisplay().getRotation();
    int k = paramActivity.getResources().getConfiguration().orientation;
    if (1 == k)
    {
      switch (j)
      {
      default:
        i = 1;
      case 1:
      case 2:
      }
      return i;
    }
    if (2 == k)
    {
      switch (j)
      {
      default:
        return 0;
      case 2:
      case 3:
      }
      return 8;
    }
    dp.a("Unknown screen orientation. Defaulting to portrait.");
    return i;
  }

  public static bj a(Context paramContext)
  {
    return new bj(paramContext);
  }

  public static void a(View paramView, int paramInt1, int paramInt2)
  {
    ColorDrawable localColorDrawable1 = new ColorDrawable(paramInt1);
    ColorDrawable localColorDrawable2 = new ColorDrawable(paramInt2);
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localColorDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, localColorDrawable1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      int[][] arrayOfInt = new int[2][];
      arrayOfInt[0] = { 16842919 };
      arrayOfInt[1] = StateSet.WILD_CARD;
      int[] arrayOfInt1 = new int[2];
      arrayOfInt1[0] = a(paramInt2);
      arrayOfInt1[1] = a(paramInt1);
      paramView.setBackground(new RippleDrawable(new ColorStateList(arrayOfInt, arrayOfInt1), localStateListDrawable, null));
      return;
    }
    if (Build.VERSION.SDK_INT >= 18)
    {
      paramView.setBackground(localStateListDrawable);
      return;
    }
    paramView.setBackgroundDrawable(localStateListDrawable);
  }

  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramView, paramInt1, paramInt2, 0, 0, paramInt3);
  }

  public static void a(View paramView, int paramInt1, int paramInt2, int paramInt3, int paramInt4, int paramInt5)
  {
    GradientDrawable localGradientDrawable1 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt1, paramInt1 });
    localGradientDrawable1.setCornerRadius(paramInt5);
    GradientDrawable localGradientDrawable2 = new GradientDrawable(GradientDrawable.Orientation.TOP_BOTTOM, new int[] { paramInt2, paramInt2 });
    localGradientDrawable2.setCornerRadius(paramInt5);
    if (paramInt3 != 0)
    {
      localGradientDrawable1.setStroke(paramInt4, paramInt3);
      localGradientDrawable2.setStroke(paramInt4, paramInt3);
    }
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, localGradientDrawable2);
    localStateListDrawable.addState(StateSet.WILD_CARD, localGradientDrawable1);
    if (Build.VERSION.SDK_INT >= 21)
    {
      int[][] arrayOfInt = new int[2][];
      arrayOfInt[0] = { 16842919 };
      arrayOfInt[1] = StateSet.WILD_CARD;
      int[] arrayOfInt1 = new int[2];
      arrayOfInt1[0] = a(paramInt2);
      arrayOfInt1[1] = a(paramInt1);
      paramView.setBackground(new RippleDrawable(new ColorStateList(arrayOfInt, arrayOfInt1), localStateListDrawable, null));
      return;
    }
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(localStateListDrawable);
      return;
    }
    paramView.setBackgroundDrawable(localStateListDrawable);
  }

  public static void a(View paramView, String paramString)
  {
    if (Build.VERSION.SDK_INT >= 18)
      paramView.setAccessibilityDelegate(new a(paramString));
  }

  public static boolean a(Activity paramActivity, View paramView)
  {
    if ((!paramView.isHardwareAccelerated()) || ((0x1 & paramView.getLayerType()) != 0));
    Window localWindow;
    do
    {
      return false;
      if ((paramView.getParent() instanceof View))
        break;
      localWindow = paramActivity.getWindow();
    }
    while (localWindow == null);
    if ((0x1000000 & localWindow.getAttributes().flags) != 0);
    for (boolean bool = true; ; bool = false)
    {
      return bool;
      paramView = (View)paramView.getParent();
      break;
    }
  }

  public static int b(int paramInt)
  {
    float[] arrayOfFloat = new float[3];
    Color.colorToHSV(paramInt, arrayOfFloat);
    return Color.HSVToColor(128, arrayOfFloat);
  }

  public int c(int paramInt)
  {
    Resources localResources = this.b.getResources();
    return (int)TypedValue.applyDimension(1, paramInt, localResources.getDisplayMetrics());
  }

  public int d(int paramInt)
  {
    Resources localResources = this.b.getResources();
    return (int)TypedValue.applyDimension(2, paramInt, localResources.getDisplayMetrics());
  }

  public int e(int paramInt)
  {
    return Math.round(paramInt / (this.b.getResources().getDisplayMetrics().xdpi / 160.0F));
  }

  private static class a extends View.AccessibilityDelegate
  {
    private final String a;

    a(String paramString)
    {
      this.a = paramString;
    }

    @TargetApi(18)
    public void onInitializeAccessibilityNodeInfo(View paramView, AccessibilityNodeInfo paramAccessibilityNodeInfo)
    {
      super.onInitializeAccessibilityNodeInfo(paramView, paramAccessibilityNodeInfo);
      paramAccessibilityNodeInfo.setViewIdResourceName(this.a);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bj
 * JD-Core Version:    0.6.2
 */