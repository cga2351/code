package com.appnexus.opensdk.utils;

import android.app.Activity;
import android.content.Context;
import android.content.MutableContextWrapper;
import android.content.res.Resources;
import android.graphics.Point;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageButton;

public class ViewUtil
{
  public static void convertFromDPToPixels(Activity paramActivity, int[] paramArrayOfInt)
  {
    float f = paramActivity.getResources().getDisplayMetrics().density;
    for (int i = 0; i < paramArrayOfInt.length; i++)
      paramArrayOfInt[i] = ((int)(0.5F + f * paramArrayOfInt[i]));
  }

  public static void convertFromPixelsToDP(Activity paramActivity, int[] paramArrayOfInt)
  {
    float f = paramActivity.getResources().getDisplayMetrics().density;
    for (int i = 0; i < paramArrayOfInt.length; i++)
      paramArrayOfInt[i] = ((int)(0.5F + paramArrayOfInt[i] / f));
  }

  public static ImageButton createCloseButton(Context paramContext, boolean paramBoolean)
  {
    ImageButton localImageButton = new ImageButton(paramContext);
    if (!paramBoolean)
      localImageButton.setImageDrawable(paramContext.getResources().getDrawable(17301560));
    localImageButton.setLayoutParams(new FrameLayout.LayoutParams(-2, -2, 53));
    localImageButton.setBackgroundColor(0);
    return localImageButton;
  }

  public static int[] getScreenSizeAsDP(Activity paramActivity)
  {
    int[] arrayOfInt = getScreenSizeAsPixels(paramActivity);
    convertFromPixelsToDP(paramActivity, arrayOfInt);
    return arrayOfInt;
  }

  public static int[] getScreenSizeAsPixels(Activity paramActivity)
  {
    Display localDisplay = paramActivity.getWindowManager().getDefaultDisplay();
    Point localPoint;
    int i;
    if (Build.VERSION.SDK_INT >= 13)
    {
      localPoint = new Point();
      localDisplay.getSize(localPoint);
      i = localPoint.x;
    }
    for (int j = localPoint.y; ; j = localDisplay.getHeight())
    {
      return new int[] { i, j };
      i = localDisplay.getWidth();
    }
  }

  public static Context getTopContext(View paramView)
  {
    if (paramView == null)
      return null;
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent == null) || (!(localViewParent instanceof View)))
    {
      if ((paramView.getContext() instanceof MutableContextWrapper))
        return ((MutableContextWrapper)paramView.getContext()).getBaseContext();
      return paramView.getContext();
    }
    while ((localViewParent.getParent() != null) && ((localViewParent.getParent() instanceof View)))
      localViewParent = localViewParent.getParent();
    return ((View)localViewParent).getContext();
  }

  public static int getValueInPixel(Context paramContext, int paramInt)
  {
    return (int)(0.5F + paramContext.getResources().getDisplayMetrics().density * paramInt);
  }

  public static void removeChildFromParent(View paramView)
  {
    if ((paramView != null) && (paramView.getParent() != null))
      ((ViewGroup)paramView.getParent()).removeView(paramView);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.appnexus.opensdk.utils.ViewUtil
 * JD-Core Version:    0.6.2
 */