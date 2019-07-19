package com.viber.voip.widget.animated;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.viber.common.ui.ShapeImageView;

public class ShapeImageGlowingView extends ShapeImageView
{
  private b d;

  public ShapeImageGlowingView(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public ShapeImageGlowingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }

  public ShapeImageGlowingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }

  private void a()
  {
    setWillNotDraw(false);
    this.d = new b();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.d.a(paramCanvas);
    super.onDraw(paramCanvas);
    postInvalidate();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.d.a(getMeasuredWidth(), getMeasuredHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.animated.ShapeImageGlowingView
 * JD-Core Version:    0.6.2
 */