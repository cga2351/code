package com.my.target;

import android.graphics.Rect;
import android.view.View;

public class bm
{
  public static double a(View paramView)
  {
    if ((paramView.getVisibility() != 0) || (paramView.getParent() == null) || (paramView.getAlpha() < 0.5F));
    Rect localRect;
    do
    {
      return 0.0D;
      localRect = new Rect();
    }
    while (!paramView.getGlobalVisibleRect(localRect));
    return localRect.width() * localRect.height() / (paramView.getWidth() * paramView.getHeight() / 100.0D);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.bm
 * JD-Core Version:    0.6.2
 */