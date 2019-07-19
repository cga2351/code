package com.mopub.nativeads;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ProgressBar;
import com.mopub.common.Preconditions;
import com.mopub.common.util.Dips;
import com.mopub.common.util.Views;

class i extends ViewGroup
{
  private final ProgressBar a;
  private int b;

  i(Context paramContext)
  {
    super(paramContext);
    LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(-1, -1);
    localLayoutParams.gravity = 17;
    setLayoutParams(localLayoutParams);
    setVisibility(8);
    setBackgroundColor(-16777216);
    getBackground().setAlpha(180);
    this.a = new ProgressBar(paramContext);
    this.b = Dips.asIntPixels(25.0F, getContext());
    this.a.setIndeterminate(true);
    addView(this.a);
  }

  boolean a()
  {
    Views.removeFromParent(this);
    setVisibility(8);
    return true;
  }

  boolean a(View paramView)
  {
    Preconditions.checkNotNull(paramView);
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

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.mopub.nativeads.i
 * JD-Core Version:    0.6.2
 */