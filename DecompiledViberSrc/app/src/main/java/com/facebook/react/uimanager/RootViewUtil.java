package com.facebook.react.uimanager;

import android.view.View;
import android.view.ViewParent;
import com.facebook.infer.annotation.Assertions;

public class RootViewUtil
{
  public static RootView getRootView(View paramView)
  {
    ViewParent localViewParent;
    for (View localView = paramView; ; localView = (View)localViewParent)
    {
      if ((localView instanceof RootView))
        return (RootView)localView;
      localViewParent = localView.getParent();
      if (localViewParent == null)
        return null;
      Assertions.assertCondition(localViewParent instanceof View);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.facebook.react.uimanager.RootViewUtil
 * JD-Core Version:    0.6.2
 */