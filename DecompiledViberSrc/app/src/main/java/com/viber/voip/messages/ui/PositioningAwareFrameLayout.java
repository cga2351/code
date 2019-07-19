package com.viber.voip.messages.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class PositioningAwareFrameLayout extends FrameLayout
  implements cd
{
  private cd.b a;

  public PositioningAwareFrameLayout(Context paramContext)
  {
    super(paramContext);
  }

  public PositioningAwareFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public PositioningAwareFrameLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
    if (this.a != null)
      this.a.a(this);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (this.a != null)
      this.a.a(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null)
      this.a.b(this, paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a != null)
      this.a.a(this, paramInt1, paramInt2);
    super.onMeasure(paramInt1, paramInt2);
    if (this.a != null)
      this.a.b(this, paramInt1, paramInt2);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null)
      this.a.a(this, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public void setPositioningListener(cd.b paramb)
  {
    this.a = paramb;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.ui.PositioningAwareFrameLayout
 * JD-Core Version:    0.6.2
 */