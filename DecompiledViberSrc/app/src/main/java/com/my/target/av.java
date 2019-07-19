package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LightingColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;

public class av extends View
{
  private final Rect a;
  private final Paint b = new Paint();
  private final ColorFilter c;
  private final float d;
  private final int e;
  private Bitmap f;
  private int g;
  private int h;

  public av(Context paramContext)
  {
    super(paramContext);
    this.b.setFilterBitmap(true);
    this.d = paramContext.getResources().getDisplayMetrics().density;
    this.e = bj.a(10, paramContext);
    this.a = new Rect();
    this.c = new LightingColorFilter(-3355444, 1);
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    float f1 = 1.0F;
    this.f = paramBitmap;
    if (this.f != null)
      if (paramBoolean)
      {
        if (this.d > f1)
          f1 = 2.0F;
        this.h = ((int)(this.f.getHeight() / f1 * this.d));
        this.g = ((int)(this.f.getWidth() / f1 * this.d));
      }
    while (true)
    {
      setMeasuredDimension(this.g + 2 * this.e, this.h + 2 * this.e);
      requestLayout();
      return;
      this.g = this.f.getWidth();
      this.h = this.f.getHeight();
      continue;
      this.h = 0;
      this.g = 0;
    }
  }

  public int getPadding()
  {
    return this.e;
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if (this.f != null)
    {
      this.a.left = this.e;
      this.a.top = this.e;
      this.a.right = (this.g + this.e);
      this.a.bottom = (this.h + this.e);
      paramCanvas.drawBitmap(this.f, null, this.a, this.b);
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
  }

  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    switch (paramMotionEvent.getAction())
    {
    case 2:
    default:
      return super.onTouchEvent(paramMotionEvent);
    case 0:
      this.b.setColorFilter(this.c);
      invalidate();
      return true;
    case 1:
      if ((paramMotionEvent.getX() >= 0.0F) && (paramMotionEvent.getX() <= getMeasuredWidth()) && (paramMotionEvent.getY() >= 0.0F) && (paramMotionEvent.getY() <= getMeasuredHeight()))
        performClick();
      break;
    case 3:
    }
    this.b.setColorFilter(null);
    invalidate();
    return true;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.av
 * JD-Core Version:    0.6.2
 */