package com.viber.voip.ui.call;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.viber.voip.R.color;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.call.a.d;
import java.util.ArrayList;
import java.util.List;

public class WavesView extends View
  implements b.a
{
  public static int a = -1;
  private Paint b = new Paint();
  private a c;
  private List<Drawable> d;
  private float e;
  private float f;
  private b g;
  private d h = new d(1300L);
  private float i;
  private float j;
  private float k;
  private float l;
  private float m;
  private a n;

  public WavesView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.b.setColor(0);
    this.b.setFlags(7);
    setClickable(true);
    setEnabled(true);
    a = getResources().getColor(R.color.negative);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.WavesView);
    try
    {
      this.e = localTypedArray.getDimension(R.styleable.WavesView_targetsOffset, 100.0F);
      this.i = localTypedArray.getDimension(R.styleable.WavesView_r, 100.0F);
      this.j = localTypedArray.getDimension(R.styleable.WavesView_ringW, 100.0F);
      this.k = localTypedArray.getDimension(R.styleable.WavesView_targetR, 100.0F);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, int paramInt)
  {
    float f1 = getMeasuredWidth() / 2;
    this.f = f1;
    this.l = paramFloat1;
    this.m = this.f;
    this.f -= this.e;
    this.c = new a(this.l, this.m, paramFloat3, paramFloat4, f1, getResources());
    this.g = new b(this.d, getResources(), this.l, this.m, this.f, paramInt, this);
    this.h.a(this.c);
    this.h.a(d.a);
    invalidate();
  }

  public void a(int paramInt)
  {
    this.c.a(false);
  }

  public void a(int paramInt, boolean paramBoolean)
  {
    a locala = this.c;
    if (!paramBoolean);
    for (boolean bool = true; ; bool = false)
    {
      locala.a(bool);
      return;
    }
  }

  public void b(int paramInt)
  {
    this.c.a(true);
    if (this.n != null)
      this.n.onTarget(paramInt);
  }

  @SuppressLint({"DrawAllocation"})
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawPaint(this.b);
    if (isInEditMode())
    {
      this.f = (getMeasuredWidth() / 2);
      float f1 = getMeasuredWidth() / 2;
      float f2 = this.f;
      this.f -= this.e;
      new c(f1, f2, 200.0F, 200.0F, 0.0F, isInEditMode()).a(paramCanvas);
      new a(f1, f2, this.i, this.j, getMeasuredWidth() / 2, getResources()).a(paramCanvas);
      Paint localPaint = new Paint();
      localPaint.setStyle(Paint.Style.STROKE);
      localPaint.setColor(-16711681);
      localPaint.setStrokeWidth(10.0F);
      paramCanvas.drawCircle(f1, f2, this.f, localPaint);
      return;
    }
    if (this.c != null)
    {
      long l1 = SystemClock.uptimeMillis();
      this.h.a(l1);
      if (this.c.b())
        this.c.a(paramCanvas);
      this.g.a(l1);
      if (this.g.b())
        this.g.a(paramCanvas);
      invalidate();
      return;
    }
    a(getMeasuredWidth() / 2, getMeasuredHeight() / 2, this.i, this.j, (int)this.k);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if (paramBoolean)
      this.c = null;
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    float f1 = paramMotionEvent.getX();
    float f2 = paramMotionEvent.getY();
    double d1 = Math.sqrt((this.l - f1) * (this.l - f1) + (this.m - f2) * (this.m - f2));
    if ((this.c != null) && (this.g != null))
    {
      float f3 = this.f - this.c.a().width() / 2;
      if (d1 >= f3)
      {
        float f4 = (float)(f3 / d1);
        paramMotionEvent.setLocation(f4 * (f1 - this.l) + this.l, f4 * (f2 - this.l) + this.m);
      }
      if (this.c.onTouch(this, paramMotionEvent))
        this.g.onTouch(this, paramMotionEvent);
    }
    return super.onTouchEvent(paramMotionEvent);
  }

  public void setTargetDrawables(int paramInt)
  {
    int i1 = 0;
    TypedArray localTypedArray = getResources().obtainTypedArray(paramInt);
    try
    {
      this.d = new ArrayList(4);
      while (i1 < localTypedArray.length())
      {
        Drawable localDrawable = localTypedArray.getDrawable(i1);
        if (localDrawable != null)
          localDrawable.setState(new int[] { 16842910 });
        this.d.add(localDrawable);
        i1++;
      }
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public void setTargetListener(a parama)
  {
    this.n = parama;
  }

  public static abstract interface a
  {
    public abstract void onTarget(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.call.WavesView
 * JD-Core Version:    0.6.2
 */