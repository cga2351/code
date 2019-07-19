package com.my.target;

import android.content.Context;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public final class cj extends FrameLayout
{
  private int a;
  private int b;
  private boolean c;
  private int d;

  public cj(Context paramContext)
  {
    super(paramContext);
  }

  public final void a(int paramInt1, int paramInt2)
  {
    this.a = paramInt1;
    this.b = paramInt2;
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    if ((this.a <= 0) || (this.b <= 0))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    int i = View.MeasureSpec.getSize(paramInt1);
    if ((this.c) && (this.a < i))
    {
      if (this.d > 0)
        i = Math.min(i, this.d);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
      return;
    }
    super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.a, -2147483648), View.MeasureSpec.makeMeasureSpec(this.b, 1073741824));
  }

  public final void setFlexibleWidth(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public final void setMaxWidth(int paramInt)
  {
    this.d = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cj
 * JD-Core Version:    0.6.2
 */