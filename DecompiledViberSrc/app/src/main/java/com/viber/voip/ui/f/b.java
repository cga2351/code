package com.viber.voip.ui.f;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewTreeObserver.OnGlobalLayoutListener;
import android.widget.AbsListView.LayoutParams;
import com.b.a.a.a;
import com.viber.dexshared.Logger;
import com.viber.voip.ViberEnv;
import com.viber.voip.util.dj;

public class b
  implements ViewTreeObserver.OnGlobalLayoutListener
{
  private static final Logger a = ViberEnv.getLogger();
  private final Context b;
  private final a c;
  private final int d;
  private View e;
  private View f;
  private Boolean g;

  public b(Context paramContext, a parama, int paramInt)
  {
    this.b = paramContext;
    this.c = parama;
    this.d = paramInt;
  }

  private View c()
  {
    if (this.f == null)
    {
      this.f = new View(this.b);
      this.f.setLayoutParams(new AbsListView.LayoutParams(-1, this.d));
    }
    return this.f;
  }

  public void a()
  {
    if (this.f != null)
      return;
    this.c.a(c());
    this.c.b(c(), false);
    onGlobalLayout();
  }

  public void a(View paramView)
  {
    this.e = paramView;
    dj.a(this.e, this);
    onGlobalLayout();
  }

  public void a(boolean paramBoolean, int paramInt)
  {
    if (this.e == null);
    ViewGroup.MarginLayoutParams localMarginLayoutParams;
    do
    {
      do
      {
        return;
        localMarginLayoutParams = (ViewGroup.MarginLayoutParams)this.e.getLayoutParams();
      }
      while (localMarginLayoutParams == null);
      if ((paramBoolean) && (localMarginLayoutParams.bottomMargin < paramInt))
      {
        localMarginLayoutParams.bottomMargin = (paramInt + localMarginLayoutParams.bottomMargin);
        this.e.requestLayout();
        return;
      }
    }
    while ((paramBoolean) || (localMarginLayoutParams.bottomMargin < paramInt));
    localMarginLayoutParams.bottomMargin -= paramInt;
    this.e.requestLayout();
  }

  public void b()
  {
    dj.b(this.e, this);
  }

  public void onGlobalLayout()
  {
    if ((this.f == null) || (this.e == null));
    do
    {
      do
      {
        return;
        if (this.e.getVisibility() != 8)
          break;
      }
      while ((this.g != null) && (!this.g.booleanValue()));
      this.g = Boolean.valueOf(false);
      this.c.b(this.f, false);
      return;
    }
    while ((this.g != null) && (this.g.booleanValue()));
    this.c.b(this.f, true);
    this.g = Boolean.valueOf(true);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.f.b
 * JD-Core Version:    0.6.2
 */