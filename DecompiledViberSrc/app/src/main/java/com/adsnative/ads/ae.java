package com.adsnative.ads;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;

class ae extends ViewGroup
{
  private final ProgressBar a;
  private int b;

  ae(Context paramContext)
  {
    super(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    setLayoutParams(localLayoutParams);
    setVisibility(8);
    setBackgroundColor(-16777216);
    getBackground().setAlpha(180);
    this.a = new ProgressBar(paramContext);
    this.b = b(25.0F, getContext());
    this.a.setIndeterminate(true);
    addView(this.a);
  }

  public static float a(float paramFloat, Context paramContext)
  {
    return TypedValue.applyDimension(1, paramFloat, paramContext.getResources().getDisplayMetrics());
  }

  public static int b(float paramFloat, Context paramContext)
  {
    return (int)(0.5F + a(paramFloat, paramContext));
  }

  boolean a()
  {
    if ((this != null) && (getParent() == null) && ((getParent() instanceof ViewGroup)))
      ((ViewGroup)getParent()).removeView(this);
    setVisibility(8);
    return true;
  }

  boolean a(View paramView)
  {
    if (paramView == null)
      throw new NullPointerException();
    View localView = paramView.getRootView();
    if ((localView != null) && ((localView instanceof ViewGroup)))
    {
      ViewGroup localViewGroup = (ViewGroup)localView;
      setVisibility(0);
      setMeasuredDimension(localView.getWidth(), localView.getHeight());
      localViewGroup.addView(this);
      forceLayout();
      return true;
    }
    return false;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramBoolean)
    {
      int i = (paramInt1 + paramInt3) / 2;
      int j = (paramInt2 + paramInt4) / 2;
      this.a.layout(i - this.b, j - this.b, i + this.b, j + this.b);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.adsnative.ads.ae
 * JD-Core Version:    0.6.2
 */