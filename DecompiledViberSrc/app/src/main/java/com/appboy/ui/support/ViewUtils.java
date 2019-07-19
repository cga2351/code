package com.appboy.ui.support;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.WindowManager;
import com.appboy.f.c;

public class ViewUtils
{
  private static final String TAG = c.a(ViewUtils.class);
  private static int sDisplayHeight;

  public static double convertDpToPixels(Context paramContext, double paramDouble)
  {
    return paramDouble * paramContext.getResources().getDisplayMetrics().density;
  }

  public static int getDisplayHeight(Activity paramActivity)
  {
    if (sDisplayHeight > 0)
      return sDisplayHeight;
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint = new Point();
    localDisplay.getSize(localPoint);
    sDisplayHeight = localPoint.y;
    return sDisplayHeight;
  }

  public static int getTopVisibleCoordinate(View paramView)
  {
    Rect localRect = new Rect();
    paramView.getWindowVisibleDisplayFrame(localRect);
    return localRect.top;
  }

  public static boolean isRunningOnTablet(Activity paramActivity)
  {
    return paramActivity.getResources().getConfiguration().smallestScreenWidthDp >= 600;
  }

  public static void removeViewFromParent(View paramView)
  {
    if ((paramView != null) && ((paramView.getParent() instanceof ViewGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)paramView.getParent();
      setFocusableInTouchModeAndRequestFocus(localViewGroup);
      localViewGroup.removeView(paramView);
    }
  }

  public static void setActivityRequestedOrientation(Activity paramActivity, int paramInt)
  {
    try
    {
      paramActivity.setRequestedOrientation(paramInt);
      return;
    }
    catch (Exception localException)
    {
      c.d(TAG, "Failed to set requested orientation " + paramInt + " for activity class: " + paramActivity.getLocalClassName(), localException);
    }
  }

  public static void setFocusableInTouchModeAndRequestFocus(View paramView)
  {
    try
    {
      paramView.setFocusableInTouchMode(true);
      paramView.requestFocus();
      return;
    }
    catch (Exception localException)
    {
      c.d(TAG, "Caught exception while setting view to focusable in touch mode and requesting focus.", localException);
    }
  }

  public static void setHeightOnViewLayoutParams(View paramView, int paramInt)
  {
    if (paramView == null)
    {
      c.d(TAG, "Cannot set height on null view.");
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = paramView.getLayoutParams();
    localLayoutParams.height = paramInt;
    paramView.setLayoutParams(localLayoutParams);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appboy.ui.support.ViewUtils
 * JD-Core Version:    0.6.2
 */