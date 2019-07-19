package com.viber.voip.ui.doodle.pickers;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.PointF;
import android.graphics.RectF;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import com.viber.voip.R.drawable;
import com.viber.voip.util.e.j;

public class ColorPickerView extends View
{
  private static final int[] a = { -1, -16711936, -256, -65536, -65281, -16776961, -16711681, -16777216 };
  private Paint b;
  private Path c;
  private RectF d;
  private int e;
  private Bitmap f;
  private Paint g;
  private int h;
  private float i;
  private Drawable j;
  private int k;
  private boolean l;
  private RectF m;
  private PointF n;
  private int o;
  private a p;

  public ColorPickerView(Context paramContext)
  {
    super(paramContext);
    a(paramContext);
  }

  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext);
  }

  public ColorPickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext);
  }

  private void a()
  {
    float f1 = this.j.getIntrinsicHeight() / 2.0F;
    int i1 = (int)(this.i - f1);
    int i2 = this.j.getIntrinsicWidth();
    int i3 = (int)(f1 + this.i);
    this.j.setBounds(0, i1, i2, i3);
  }

  private void a(Context paramContext)
  {
    this.h = j.a(paramContext, 1.0F);
    this.j = ContextCompat.getDrawable(paramContext, R.drawable.ic_doodle_color_picker_arrow);
    this.k = j.a(paramContext, 12.0F);
    this.o = j.a(paramContext, 8.0F);
    this.e = j.a(paramContext, 7.5F);
    this.b = new Paint();
    this.b.setStyle(Paint.Style.FILL);
    this.b.setAntiAlias(true);
    this.c = new Path();
    this.g = new Paint();
    this.g.setStyle(Paint.Style.STROKE);
    this.g.setColor(1308622847);
    this.g.setAntiAlias(true);
    this.g.setStrokeWidth(this.h);
  }

  private boolean b()
  {
    if (this.n == null)
      return false;
    int i1 = (int)this.n.x;
    int i2 = (int)this.n.y;
    return this.m.contains(i1, i2);
  }

  private void c()
  {
    if (this.f == null)
    {
      setDrawingCacheEnabled(true);
      Bitmap localBitmap = getDrawingCache();
      if (localBitmap != null)
        this.f = Bitmap.createBitmap(localBitmap);
      setDrawingCacheEnabled(false);
    }
  }

  private void d()
  {
    if (this.f != null)
    {
      this.f.recycle();
      this.f = null;
    }
  }

  protected void onDetachedFromWindow()
  {
    d();
    super.onDetachedFromWindow();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    paramCanvas.drawPath(this.c, this.g);
    paramCanvas.drawPath(this.c, this.b);
    if (this.l)
      this.j.draw(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    setMeasuredDimension(this.j.getIntrinsicWidth() + this.k + 2 * (this.e + this.h) + this.o, View.MeasureSpec.getSize(paramInt2));
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    int i1 = this.j.getIntrinsicWidth() + this.k + this.h;
    int i2 = this.h;
    int i3 = i1 + 2 * this.e;
    int i4 = paramInt2 - this.h;
    this.m = new RectF(i1 - this.o, i2, i3 + this.o, i4);
    this.d = new RectF(i1, i2 + this.e, i3, i4 - this.e);
    LinearGradient localLinearGradient = new LinearGradient(0.0F, this.d.top + 1, 0.0F, this.d.bottom - 1, a, null, Shader.TileMode.CLAMP);
    this.b.setShader(localLinearGradient);
    this.c.reset();
    this.c.addCircle(this.d.centerX(), this.d.top, this.e, Path.Direction.CW);
    this.c.addCircle(this.d.centerX(), this.d.bottom, this.e, Path.Direction.CW);
    this.c.addRect(this.d, Path.Direction.CW);
    this.i = this.d.top;
    d();
    invalidate();
  }

  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool1;
    boolean bool2;
    switch (paramMotionEvent.getAction())
    {
    default:
      bool1 = false;
      bool2 = false;
    case 0:
    case 2:
    case 1:
    }
    while (true)
    {
      if (this.l != bool2)
        this.l = bool2;
      for (int i1 = 1; ; i1 = 0)
      {
        float f1 = Math.max(this.d.top, Math.min(paramMotionEvent.getY(), this.d.bottom));
        if (this.i != f1)
        {
          this.i = f1;
          a();
          if (this.p != null)
          {
            c();
            if (this.f != null)
            {
              int i2 = this.f.getPixel((int)this.d.centerX(), (int)this.i);
              this.p.a(i2);
            }
          }
          i1 = 1;
        }
        if (i1 != 0)
          invalidate();
        boolean bool3;
        if (!bool1)
        {
          boolean bool4 = super.onTouchEvent(paramMotionEvent);
          bool3 = false;
          if (!bool4);
        }
        else
        {
          bool3 = true;
        }
        return bool3;
        this.n = new PointF(paramMotionEvent.getX(), paramMotionEvent.getY());
        bool1 = b();
        if (!bool1)
          break label254;
        bool2 = true;
        break;
        bool1 = b();
        if (!bool1)
          break label254;
        bool2 = true;
        break;
        this.n = null;
        bool1 = b();
        bool2 = false;
        break;
      }
      label254: bool2 = false;
    }
  }

  public void setOnColorChangedListener(a parama)
  {
    this.p = parama;
  }

  public static abstract interface a
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.doodle.pickers.ColorPickerView
 * JD-Core Version:    0.6.2
 */