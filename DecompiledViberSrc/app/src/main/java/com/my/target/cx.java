package com.my.target;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Paint.Style;
import android.graphics.RectF;
import android.os.SystemClock;
import android.view.View;
import android.view.View.MeasureSpec;

public final class cx extends View
{
  private final Paint a = new Paint();
  private final Paint b = new Paint();
  private final Paint c = new Paint();
  private final bj d;
  private RectF e = new RectF();
  private long f = 0L;
  private float g = 0.0F;
  private float h = 0.0F;
  private float i = 230.0F;
  private boolean j = false;
  private int k;

  public cx(Context paramContext)
  {
    super(paramContext);
    this.d = bj.a(paramContext);
  }

  protected final void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawOval(this.e, this.b);
    if (this.g != this.h)
    {
      this.g = Math.min((float)(SystemClock.uptimeMillis() - this.f) / 1000.0F * this.i + this.g, this.h);
      this.f = SystemClock.uptimeMillis();
    }
    for (int m = 1; ; m = 0)
    {
      float f1 = this.g;
      if (isInEditMode())
        f1 = 360.0F;
      paramCanvas.drawArc(this.e, -90.0F, f1, false, this.a);
      this.c.setColor(-1);
      this.c.setTextSize(this.d.c(12));
      this.c.setTextAlign(Paint.Align.CENTER);
      this.c.setAntiAlias(true);
      int n = (int)this.e.centerX();
      int i1 = (int)(this.e.centerY() - (this.c.descent() + this.c.ascent()) / 2.0F);
      paramCanvas.drawText(String.valueOf(this.k), n, i1, this.c);
      if (m != 0)
        invalidate();
      return;
    }
  }

  protected final void onMeasure(int paramInt1, int paramInt2)
  {
    int m = this.d.c(28) + getPaddingLeft() + getPaddingRight();
    int n = this.d.c(28) + getPaddingTop() + getPaddingBottom();
    int i1 = View.MeasureSpec.getMode(paramInt1);
    int i2 = View.MeasureSpec.getSize(paramInt1);
    int i3 = View.MeasureSpec.getMode(paramInt2);
    int i4 = View.MeasureSpec.getSize(paramInt2);
    switch (i1)
    {
    default:
      i2 = m;
    case 1073741824:
      if ((i3 == 1073741824) || (i1 == 1073741824))
        n = i4;
      break;
    case -2147483648:
    }
    while (true)
    {
      setMeasuredDimension(i2, n);
      return;
      i2 = Math.min(m, i2);
      break;
      if (i3 == -2147483648)
        n = Math.min(n, i4);
    }
  }

  protected final void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int m = getPaddingTop();
    int n = getPaddingBottom();
    int i1 = getPaddingLeft();
    int i2 = getPaddingRight();
    this.e = new RectF(i1 + this.d.c(1), m + this.d.c(1), paramInt1 - i2 - this.d.c(1), paramInt2 - n - this.d.c(1));
    this.a.setColor(-1);
    this.a.setAntiAlias(true);
    this.a.setStyle(Paint.Style.STROKE);
    this.a.setStrokeWidth(this.d.c(1));
    this.b.setColor(-2013265920);
    this.b.setAntiAlias(true);
    this.b.setStyle(Paint.Style.FILL);
    this.b.setStrokeWidth(this.d.c(4));
    invalidate();
  }

  protected final void onVisibilityChanged(View paramView, int paramInt)
  {
    super.onVisibilityChanged(paramView, paramInt);
    if (paramInt == 0)
      this.f = SystemClock.uptimeMillis();
  }

  public final void setDigit(int paramInt)
  {
    this.k = paramInt;
  }

  public final void setMax(float paramFloat)
  {
    if (paramFloat > 0.0F)
      this.i = (360.0F / paramFloat);
  }

  public final void setProgress(float paramFloat)
  {
    if (this.j)
    {
      this.g = 0.0F;
      this.j = false;
    }
    if (paramFloat > 1.0F)
      paramFloat = 1.0F;
    while (paramFloat == this.h)
    {
      return;
      if (paramFloat < 0.0F)
        paramFloat = 0.0F;
    }
    if (this.g == this.h)
      this.f = SystemClock.uptimeMillis();
    this.h = Math.min(paramFloat * 360.0F, 360.0F);
    invalidate();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cx
 * JD-Core Version:    0.6.2
 */