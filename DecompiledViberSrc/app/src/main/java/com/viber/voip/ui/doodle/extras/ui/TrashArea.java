package com.viber.voip.ui.doodle.extras.ui;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PointF;
import android.graphics.RectF;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.view.View;
import com.viber.voip.R.color;
import com.viber.voip.ui.doodle.extras.a;

public class TrashArea extends View
{
  private boolean a;
  private Paint b;
  private RectF c = new RectF();
  private float d = 1.0F;
  private PointF e = new PointF();
  private PointF f = new PointF();

  public TrashArea(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public TrashArea(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public TrashArea(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    this.b = new Paint(1);
    this.b.setColor(ContextCompat.getColor(paramContext, R.color.trash_area_color));
    this.b.setStyle(Paint.Style.FILL);
  }

  public boolean a(float paramFloat1, float paramFloat2)
  {
    this.e.set(paramFloat1, paramFloat2);
    return a.a(this.e, this.f, this.d);
  }

  protected void onDraw(Canvas paramCanvas)
  {
    if (this.a)
    {
      paramCanvas.save();
      paramCanvas.scale(2.0F, 2.0F);
      paramCanvas.drawArc(this.c, 180.0F, 90.0F, true, this.b);
      paramCanvas.restore();
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i = Math.min(paramInt1, paramInt2);
    this.c.set(0.0F, 0.0F, i, i);
    this.d = (i * i);
    this.f.set(paramInt1, paramInt2);
  }

  public void setDrawTrashArea(boolean paramBoolean)
  {
    if (this.a != paramBoolean)
    {
      this.a = paramBoolean;
      if (ViewCompat.isLaidOut(this))
        invalidate();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.extras.ui.TrashArea
 * JD-Core Version:    0.6.2
 */