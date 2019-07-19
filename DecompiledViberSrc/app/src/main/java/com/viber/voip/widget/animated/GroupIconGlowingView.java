package com.viber.voip.widget.animated;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.viber.voip.widget.GroupIconView;

public class GroupIconGlowingView extends GroupIconView
{
  private b a;

  public GroupIconGlowingView(Context paramContext)
  {
    super(paramContext);
    b();
  }

  public GroupIconGlowingView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }

  public GroupIconGlowingView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }

  private void b()
  {
    setWillNotDraw(false);
    this.a = new b();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    this.a.a(paramCanvas);
    super.onDraw(paramCanvas);
    postInvalidate();
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.a.a(getMeasuredWidth(), getMeasuredHeight(), getPaddingLeft(), getPaddingTop(), getPaddingRight(), getPaddingBottom());
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.animated.GroupIconGlowingView
 * JD-Core Version:    0.6.2
 */