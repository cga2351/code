package com.getkeepsafe.taptargetview;

import android.os.Build.VERSION;
import android.support.v4.view.ViewCompat;
import android.view.View;
import android.view.ViewManager;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;

class f
{
  static void a(final View paramView, final Runnable paramRunnable)
  {
    if (a(paramView))
    {
      paramRunnable.run();
      return;
    }
    ViewTreeObserver localViewTreeObserver = paramView.getViewTreeObserver();
    localViewTreeObserver.addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener()
    {
      public void onGlobalLayout()
      {
        if (this.a.isAlive());
        for (ViewTreeObserver localViewTreeObserver = this.a; ; localViewTreeObserver = paramView.getViewTreeObserver())
        {
          f.a(localViewTreeObserver, this);
          paramRunnable.run();
          return;
        }
      }
    });
  }

  static void a(ViewManager paramViewManager, View paramView)
  {
    if ((paramViewManager == null) || (paramView == null))
      return;
    try
    {
      paramViewManager.removeView(paramView);
      return;
    }
    catch (Exception localException)
    {
    }
  }

  static void a(ViewTreeObserver paramViewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener paramOnGlobalLayoutListener)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramViewTreeObserver.removeOnGlobalLayoutListener(paramOnGlobalLayoutListener);
      return;
    }
    paramViewTreeObserver.removeGlobalOnLayoutListener(paramOnGlobalLayoutListener);
  }

  private static boolean a(View paramView)
  {
    return (ViewCompat.isLaidOut(paramView)) && (paramView.getWidth() > 0) && (paramView.getHeight() > 0);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.getkeepsafe.taptargetview.f
 * JD-Core Version:    0.6.2
 */