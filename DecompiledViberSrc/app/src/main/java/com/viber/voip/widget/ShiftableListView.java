package com.viber.voip.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import com.viber.voip.ui.ViberListView;

public class ShiftableListView extends ViberListView
{
  private float a;

  public ShiftableListView(Context paramContext)
  {
    super(paramContext);
  }

  public ShiftableListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }

  public ShiftableListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }

  public void draw(Canvas paramCanvas)
  {
    paramCanvas.translate(0.0F, this.a);
    paramCanvas.clipRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight() - this.a);
    super.draw(paramCanvas);
  }

  public float getShiftY()
  {
    return this.a;
  }

  public void setShiftY(float paramFloat)
  {
    this.a = paramFloat;
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ShiftableListView
 * JD-Core Version:    0.6.2
 */