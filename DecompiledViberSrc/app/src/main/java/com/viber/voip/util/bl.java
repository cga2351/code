package com.viber.voip.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.view.Display;
import android.view.WindowManager;
import com.viber.voip.R.dimen;
import com.viber.voip.ViberApplication;
import com.viber.voip.util.e.j;

public final class bl
{
  public static int a(Context paramContext)
  {
    return j.a(paramContext, 128.0F);
  }

  public static int a(Context paramContext, int paramInt)
  {
    Point localPoint = new Point();
    ((WindowManager)paramContext.getSystemService("window")).getDefaultDisplay().getSize(localPoint);
    Resources localResources = paramContext.getResources();
    if ((!dj.c(paramContext)) || (ViberApplication.isTablet(paramContext)));
    for (int i = 1; ; i = 0)
    {
      int j = dj.m(paramContext);
      int k = 0;
      if (i != 0)
        k = dj.i(paramContext);
      int m = j + k;
      int n = localResources.getDimensionPixelSize(R.dimen.msg_edit_text_height) + localResources.getDimensionPixelSize(R.dimen.composer_group_layout_height);
      return Math.min((int)(localPoint.y * (Math.min(paramInt, 100) / 100.0F)) - n, localPoint.y - m - n);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.util.bl
 * JD-Core Version:    0.6.2
 */