package com.facebook.react.views.modal;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.facebook.infer.annotation.Assertions;

class ModalHostHelper
{
  private static final Point MAX_POINT = new Point();
  private static final Point MIN_POINT = new Point();
  private static final Point SIZE_POINT = new Point();

  public static Point getModalHostSize(Context paramContext)
  {
    Display localDisplay = ((WindowManager)Assertions.assertNotNull((WindowManager)paramContext.getSystemService("window"))).getDefaultDisplay();
    localDisplay.getCurrentSizeRange(MIN_POINT, MAX_POINT);
    localDisplay.getSize(SIZE_POINT);
    int[] arrayOfInt = { 16843277 };
    boolean bool = paramContext.getTheme().obtainStyledAttributes(arrayOfInt).getBoolean(0, false);
    Resources localResources = paramContext.getResources();
    int i = localResources.getIdentifier("status_bar_height", "dimen", "android");
    if ((bool) && (i > 0));
    for (int j = (int)localResources.getDimension(i); ; j = 0)
    {
      if (SIZE_POINT.x < SIZE_POINT.y)
        return new Point(MIN_POINT.x, j + MAX_POINT.y);
      return new Point(MAX_POINT.x, j + MIN_POINT.y);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.views.modal.ModalHostHelper
 * JD-Core Version:    0.6.2
 */