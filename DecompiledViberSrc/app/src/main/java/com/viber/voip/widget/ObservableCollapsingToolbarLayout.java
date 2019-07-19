package com.viber.voip.widget;

import android.content.Context;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.AppBarLayout.OnOffsetChangedListener;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.CoordinatorLayout.Behavior;
import android.support.design.widget.CoordinatorLayout.LayoutParams;
import android.util.AttributeSet;
import android.view.ViewParent;

public class ObservableCollapsingToolbarLayout extends CollapsingToolbarLayout
{
  private AppBarLayout.OnOffsetChangedListener a;
  private b b;
  private float c;

  public ObservableCollapsingToolbarLayout(Context paramContext)
  {
    super(paramContext);
  }

  public ObservableCollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ObservableCollapsingToolbarLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
    ViewParent localViewParent = getParent();
    if ((localViewParent instanceof AppBarLayout))
    {
      if (this.a == null)
        this.a = new a(null);
      ((AppBarLayout)localViewParent).addOnOffsetChangedListener(this.a);
    }
  }

  protected void onDetachedFromWindow()
  {
    ViewParent localViewParent = getParent();
    if ((this.a != null) && ((localViewParent instanceof AppBarLayout)))
      ((AppBarLayout)localViewParent).removeOnOffsetChangedListener(this.a);
    super.onDetachedFromWindow();
  }

  public void setOnScrollListener(b paramb)
  {
    this.b = paramb;
  }

  private final class a
    implements AppBarLayout.OnOffsetChangedListener
  {
    private a()
    {
    }

    public void onOffsetChanged(AppBarLayout paramAppBarLayout, int paramInt)
    {
      float f = ObservableCollapsingToolbarLayout.a(ObservableCollapsingToolbarLayout.this);
      int i = paramAppBarLayout.getTotalScrollRange();
      CoordinatorLayout.Behavior localBehavior = ((CoordinatorLayout.LayoutParams)paramAppBarLayout.getLayoutParams()).getBehavior();
      if ((localBehavior instanceof ViberAppBarLayout.Behavior))
      {
        int k = ((ViberAppBarLayout.Behavior)localBehavior).getInitialOffset();
        paramInt += k;
        i -= k;
      }
      int j;
      if (paramInt < 0)
      {
        j = Math.abs(paramInt);
        ObservableCollapsingToolbarLayout.a(ObservableCollapsingToolbarLayout.this, 1.0F - Math.round(100.0F * ((i - j) / i)) / 100.0F);
        if ((ObservableCollapsingToolbarLayout.b(ObservableCollapsingToolbarLayout.this) != null) && (f != ObservableCollapsingToolbarLayout.a(ObservableCollapsingToolbarLayout.this)))
          if (f >= ObservableCollapsingToolbarLayout.a(ObservableCollapsingToolbarLayout.this))
            break label163;
      }
      label163: for (ObservableCollapsingToolbarLayout.c localc = ObservableCollapsingToolbarLayout.c.a; ; localc = ObservableCollapsingToolbarLayout.c.b)
      {
        ObservableCollapsingToolbarLayout.b(ObservableCollapsingToolbarLayout.this).onScroll(ObservableCollapsingToolbarLayout.a(ObservableCollapsingToolbarLayout.this), localc);
        return;
        j = 0;
        break;
      }
    }
  }

  public static abstract interface b
  {
    public abstract void onScroll(float paramFloat, ObservableCollapsingToolbarLayout.c paramc);
  }

  public static enum c
  {
    static
    {
      c[] arrayOfc = new c[2];
      arrayOfc[0] = a;
      arrayOfc[1] = b;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ObservableCollapsingToolbarLayout
 * JD-Core Version:    0.6.2
 */