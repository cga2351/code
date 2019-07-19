package com.viber.voip.banner.view;

import android.content.Context;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.viber.dexshared.Logger;
import com.viber.voip.R.id;
import com.viber.voip.ViberEnv;

public final class c
{
  private static final Logger a = ViberEnv.getLogger();

  public static int a(b paramb)
  {
    return paramb.getLayoutParams().height;
  }

  public static ViewGroup a(View paramView)
  {
    ViewGroup localViewGroup = null;
    View localView = paramView;
    while (true)
    {
      if ((localView instanceof CoordinatorLayout))
        return (ViewGroup)localView;
      if ((localView instanceof FrameLayout))
      {
        if (localView.getId() == 16908290)
          return (ViewGroup)localView;
        localViewGroup = (ViewGroup)localView;
      }
      ViewParent localViewParent;
      if (localView != null)
      {
        localViewParent = localView.getParent();
        if (!(localViewParent instanceof View))
          break label69;
      }
      label69: for (localView = (View)localViewParent; localView == null; localView = null)
        return localViewGroup;
    }
  }

  public static FrameLayout a(com.viber.voip.banner.d.c paramc, ViewGroup paramViewGroup)
  {
    if (paramViewGroup == null)
      return null;
    if (paramc == com.viber.voip.banner.d.c.b);
    for (View localView = paramViewGroup.findViewById(R.id.remote_banner_container_wrapper_bottom); ; localView = null)
    {
      if (localView == null)
      {
        localView = paramViewGroup.findViewById(R.id.remote_banner_container_wrapper_overlay);
        if (localView == null);
      }
      if (localView == null)
      {
        return null;
        if (paramc == com.viber.voip.banner.d.c.a)
          return null;
      }
      else
      {
        if ((localView instanceof FrameLayout))
          return (FrameLayout)localView;
        return null;
      }
    }
  }

  public static FrameLayout a(com.viber.voip.banner.d.c paramc, ViewGroup paramViewGroup, Context paramContext)
  {
    FrameLayout localFrameLayout = a(paramc, paramViewGroup);
    if (localFrameLayout != null)
      return localFrameLayout;
    if (paramContext == null)
      return null;
    if (paramViewGroup == null)
      return null;
    a locala = new a(paramContext);
    paramViewGroup.addView(locala);
    ViewGroup.LayoutParams localLayoutParams = locala.getLayoutParams();
    if ((localLayoutParams instanceof CoordinatorLayout.LayoutParams))
    {
      a locala1 = new a(null);
      ((CoordinatorLayout.LayoutParams)localLayoutParams).setBehavior(locala1);
      locala.setLayoutParams(localLayoutParams);
    }
    return locala;
  }

  public static void a(FrameLayout paramFrameLayout)
  {
    if ((paramFrameLayout.getId() == R.id.remote_banner_container_wrapper_overlay) && (paramFrameLayout.getChildCount() == 0));
    for (int i = 1; ; i = 0)
    {
      if (i != 0)
      {
        ViewParent localViewParent = paramFrameLayout.getParent();
        if ((localViewParent instanceof ViewGroup))
          ((ViewGroup)localViewParent).removeView(paramFrameLayout);
      }
      return;
    }
  }

  private static final class a extends CoordinatorLayout.Behavior<FrameLayout>
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.banner.view.c
 * JD-Core Version:    0.6.2
 */