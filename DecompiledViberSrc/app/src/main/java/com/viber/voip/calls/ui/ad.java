package com.viber.voip.calls.ui;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.calls.c;
import com.viber.voip.ui.MenuSearchMediator;
import com.viber.voip.ui.ac;
import com.viber.voip.util.dg;
import com.viber.voip.util.dj;

public class ad extends o
{
  private ac h;

  public ad(Context paramContext, c paramc, v paramv, RecentCallsFragmentModeManager paramRecentCallsFragmentModeManager, MenuSearchMediator paramMenuSearchMediator, boolean paramBoolean)
  {
    super(paramContext, paramc, paramv, paramRecentCallsFragmentModeManager, paramBoolean);
    this.h = paramMenuSearchMediator;
  }

  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = super.getView(paramInt, paramView, paramViewGroup);
    u localu = (u)localView.getTag();
    dj.b(localu.a, this.g);
    String str = this.h.a();
    if (!TextUtils.isEmpty(str))
      dg.a(localu.f, str, 2147483647);
    return localView;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.calls.ui.ad
 * JD-Core Version:    0.6.2
 */