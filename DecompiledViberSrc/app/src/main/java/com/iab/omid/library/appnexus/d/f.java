package com.iab.omid.library.appnexus.d;

import android.os.Build.VERSION;
import android.view.View;
import android.view.ViewParent;

public final class f
{
  public static float a(View paramView)
  {
    if (Build.VERSION.SDK_INT >= 21)
      return paramView.getZ();
    return 0.0F;
  }

  public static View b(View paramView)
  {
    ViewParent localViewParent = paramView.getParent();
    if ((localViewParent instanceof View))
      return (View)localViewParent;
    return null;
  }

  public static boolean c(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (!paramView.isAttachedToWindow()));
    while (!paramView.isShown())
      return false;
    while (true)
    {
      if (paramView == null)
        break label45;
      if (paramView.getAlpha() == 0.0F)
        break;
      paramView = b(paramView);
    }
    label45: return true;
  }

  public static boolean d(View paramView)
  {
    if ((Build.VERSION.SDK_INT >= 19) && (!paramView.isAttachedToWindow()));
    while ((paramView.getVisibility() != 0) || (paramView.getAlpha() == 0.0F))
      return false;
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.iab.omid.library.appnexus.d.f
 * JD-Core Version:    0.6.2
 */