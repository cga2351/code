package com.viber.voip.backgrounds;

import android.app.Application;
import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.dimen;
import com.viber.voip.R.integer;
import com.viber.voip.ViberApplication;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.e.j;

public class g
{
  public static int a = a();
  public static int b;
  private static final Logger c = ViberEnv.getLogger();
  private static final int[] d = { 1920, 1280, 1136, 960, 800, 540, 480, 320 };
  private static int e;
  private static int f;
  private static int g;

  static
  {
    Application localApplication = ViberApplication.getApplication();
    int[] arrayOfInt = j.a(localApplication);
    f = arrayOfInt[0];
    e = arrayOfInt[1];
    g = localApplication.getResources().getDimensionPixelSize(R.dimen.background_gallery_items_side_spacing);
    int i = localApplication.getResources().getInteger(R.integer.backgrounds_num_columns);
    b = f / i - 2 * g;
  }

  private static int a()
  {
    int i = 0;
    int j = e;
    int k = 0;
    int m = 2147483647;
    while (i < d.length)
    {
      int n = d[i];
      if ((n < m) && (n >= j))
        m = n;
      if (k < n)
        k = n;
      i++;
    }
    if (m == 2147483647)
      return k;
    return m;
  }

  public static int a(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, R.integer.gallery_images_per_row);
  }

  private static int a(Context paramContext, View paramView, int paramInt)
  {
    int i = paramContext.getResources().getInteger(paramInt);
    if (paramView != null);
    for (int j = paramView.getWidth(); ; j = f)
      return (j - (i - 1) * g) / i;
  }

  public static int b(Context paramContext, View paramView)
  {
    return a(paramContext, paramView, R.integer.backgrounds_num_columns);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.backgrounds.g
 * JD-Core Version:    0.6.2
 */