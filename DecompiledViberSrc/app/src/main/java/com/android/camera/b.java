package com.android.camera;

import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.Path.Direction;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.view.View;
import com.viber.dexshared.Logger;
import com.viber.voip.R.drawable;
import com.viber.voip.ViberEnv;

class b
{
  private static final Logger g = ViberEnv.getLogger();
  View a;
  boolean b;
  boolean c;
  Rect d;
  RectF e;
  Matrix f;
  private a h = a.a;
  private RectF i;
  private boolean j = false;
  private float k;
  private boolean l = false;
  private Drawable m;
  private Drawable n;
  private Drawable o;
  private final Paint p = new Paint();
  private final Paint q = new Paint();
  private final Paint r = new Paint();

  public b(View paramView)
  {
    this.a = paramView;
  }

  private void d()
  {
    Resources localResources = this.a.getResources();
    this.m = localResources.getDrawable(R.drawable.camera_crop_width);
    this.n = localResources.getDrawable(R.drawable.camera_crop_height);
    this.o = localResources.getDrawable(R.drawable.indicator_autocrop);
  }

  private Rect e()
  {
    RectF localRectF = new RectF(this.e.left, this.e.top, this.e.right, this.e.bottom);
    this.f.mapRect(localRectF);
    return new Rect(Math.round(localRectF.left), Math.round(localRectF.top), Math.round(localRectF.right), Math.round(localRectF.bottom));
  }

  public int a(float paramFloat1, float paramFloat2)
  {
    int i1 = 32;
    Rect localRect = e();
    if (this.l)
    {
      float f1 = paramFloat1 - localRect.centerX();
      float f2 = paramFloat2 - localRect.centerY();
      int i6 = (int)Math.sqrt(f1 * f1 + f2 * f2);
      int i7 = this.d.width() / 2;
      if (Math.abs(i6 - i7) <= 20.0F)
        if (Math.abs(f2) > Math.abs(f1))
          if (f2 < 0.0F)
            i1 = 8;
      while (i6 < i7)
      {
        return i1;
        return 16;
        if (f1 < 0.0F)
          return 2;
        return 4;
      }
      return 1;
    }
    int i2;
    int i3;
    if ((paramFloat2 >= localRect.top - 20.0F) && (paramFloat2 < 20.0F + localRect.bottom))
    {
      i2 = 1;
      boolean bool1 = paramFloat1 < localRect.left - 20.0F;
      i3 = 0;
      if (!bool1)
      {
        boolean bool2 = paramFloat1 < 20.0F + localRect.right;
        i3 = 0;
        if (bool2)
          i3 = 1;
      }
      if ((Math.abs(localRect.left - paramFloat1) >= 20.0F) || (i2 == 0))
        break label350;
    }
    label348: label350: for (int i4 = 3; ; i4 = 1)
    {
      if ((Math.abs(localRect.right - paramFloat1) < 20.0F) && (i2 != 0))
        i4 |= 4;
      if ((Math.abs(localRect.top - paramFloat2) < 20.0F) && (i3 != 0))
        i4 |= 8;
      if ((Math.abs(localRect.bottom - paramFloat2) < 20.0F) && (i3 != 0));
      for (int i5 = i4 | 0x10; ; i5 = i4)
      {
        if ((i5 == 1) && (localRect.contains((int)paramFloat1, (int)paramFloat2)))
          break label348;
        return i5;
        i2 = 0;
        break;
      }
      break;
    }
  }

  void a(int paramInt, float paramFloat1, float paramFloat2)
  {
    Rect localRect = e();
    if (paramInt == 1)
      return;
    if (paramInt == 32)
    {
      b(paramFloat1 * (this.e.width() / localRect.width()), paramFloat2 * (this.e.height() / localRect.height()));
      return;
    }
    if ((paramInt & 0x6) == 0)
      paramFloat1 = 0.0F;
    if ((paramInt & 0x18) == 0)
      paramFloat2 = 0.0F;
    float f1 = paramFloat1 * (this.e.width() / localRect.width());
    float f2 = paramFloat2 * (this.e.height() / localRect.height());
    int i1;
    float f3;
    if ((paramInt & 0x2) != 0)
    {
      i1 = -1;
      f3 = f1 * i1;
      if ((paramInt & 0x8) == 0)
        break label155;
    }
    label155: for (int i2 = -1; ; i2 = 1)
    {
      c(f3, f2 * i2);
      return;
      i1 = 1;
      break;
    }
  }

  protected void a(Canvas paramCanvas)
  {
    if (this.c);
    while (true)
    {
      return;
      paramCanvas.save();
      Path localPath = new Path();
      if (!a())
      {
        this.r.setColor(-16777216);
        paramCanvas.drawRect(this.d, this.r);
        return;
      }
      Rect localRect = new Rect();
      this.a.getDrawingRect(localRect);
      if (this.l)
      {
        float f1 = this.d.width();
        float f2 = this.d.height();
        localPath.addCircle(this.d.left + f1 / 2.0F, this.d.top + f2 / 2.0F, f1 / 2.0F, Path.Direction.CW);
        this.r.setColor(-1112874);
      }
      try
      {
        while (true)
        {
          paramCanvas.clipPath(localPath, Region.Op.DIFFERENCE);
          if (!a())
            break label391;
          localPaint = this.p;
          paramCanvas.drawRect(localRect, localPaint);
          paramCanvas.restore();
          paramCanvas.drawPath(localPath, this.r);
          if (this.h != a.c)
            break;
          if (!this.l)
            break label400;
          int i11 = this.o.getIntrinsicWidth();
          int i12 = this.o.getIntrinsicHeight();
          int i13 = (int)Math.round(Math.cos(0.7853981633974483D) * (this.d.width() / 2.0D));
          int i14 = i13 + (this.d.left + this.d.width() / 2) - i11 / 2;
          int i15 = this.d.top + this.d.height() / 2 - i13 - i12 / 2;
          this.o.setBounds(i14, i15, i14 + this.o.getIntrinsicWidth(), i15 + this.o.getIntrinsicHeight());
          this.o.draw(paramCanvas);
          return;
          localPath.addRect(new RectF(this.d), Path.Direction.CW);
          this.r.setColor(-9812342);
        }
      }
      catch (UnsupportedOperationException localUnsupportedOperationException)
      {
        while (true)
        {
          g.a(localUnsupportedOperationException, "draw", new Object[0]);
          continue;
          label391: Paint localPaint = this.q;
        }
        label400: int i1 = 1 + this.d.left;
        int i2 = 1 + this.d.right;
        int i3 = 4 + this.d.top;
        int i4 = 3 + this.d.bottom;
        int i5 = this.m.getIntrinsicWidth() / 2;
        int i6 = this.m.getIntrinsicHeight() / 2;
        int i7 = this.n.getIntrinsicHeight() / 2;
        int i8 = this.n.getIntrinsicWidth() / 2;
        int i9 = this.d.left + (this.d.right - this.d.left) / 2;
        int i10 = this.d.top + (this.d.bottom - this.d.top) / 2;
        this.m.setBounds(i1 - i5, i10 - i6, i1 + i5, i10 + i6);
        this.m.draw(paramCanvas);
        this.m.setBounds(i2 - i5, i10 - i6, i2 + i5, i10 + i6);
        this.m.draw(paramCanvas);
        this.n.setBounds(i9 - i8, i3 - i7, i9 + i8, i3 + i7);
        this.n.draw(paramCanvas);
        this.n.setBounds(i9 - i8, i4 - i7, i9 + i8, i4 + i7);
        this.n.draw(paramCanvas);
      }
    }
  }

  public void a(Matrix paramMatrix, Rect paramRect, RectF paramRectF, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (paramBoolean1)
      paramBoolean2 = true;
    this.f = new Matrix(paramMatrix);
    this.e = paramRectF;
    this.i = new RectF(paramRect);
    this.j = paramBoolean2;
    this.l = paramBoolean1;
    this.k = (this.e.width() / this.e.height());
    this.d = e();
    this.p.setARGB(125, 50, 50, 50);
    this.q.setARGB(125, 50, 50, 50);
    this.r.setStrokeWidth(3.0F);
    this.r.setStyle(Paint.Style.STROKE);
    this.r.setAntiAlias(true);
    this.h = a.a;
    d();
  }

  public void a(a parama)
  {
    if (parama != this.h)
    {
      this.h = parama;
      this.a.invalidate();
    }
  }

  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }

  public boolean a()
  {
    return this.b;
  }

  public Rect b()
  {
    return new Rect((int)this.e.left, (int)this.e.top, (int)this.e.right, (int)this.e.bottom);
  }

  void b(float paramFloat1, float paramFloat2)
  {
    Rect localRect = new Rect(this.d);
    this.e.offset(paramFloat1, paramFloat2);
    this.e.offset(Math.max(0.0F, this.i.left - this.e.left), Math.max(0.0F, this.i.top - this.e.top));
    this.e.offset(Math.min(0.0F, this.i.right - this.e.right), Math.min(0.0F, this.i.bottom - this.e.bottom));
    this.d = e();
    localRect.union(this.d);
    localRect.inset(-10, -10);
    this.a.invalidate(localRect);
  }

  public void b(boolean paramBoolean)
  {
    this.c = paramBoolean;
  }

  public void c()
  {
    this.d = e();
  }

  void c(float paramFloat1, float paramFloat2)
  {
    RectF localRectF;
    float f1;
    if (this.j)
    {
      if (paramFloat1 != 0.0F)
        paramFloat2 = paramFloat1 / this.k;
    }
    else
    {
      localRectF = new RectF(this.e);
      if ((paramFloat1 <= 0.0F) || (localRectF.width() + 2.0F * paramFloat1 <= this.i.width()))
        break label412;
      paramFloat1 = (this.i.width() - localRectF.width()) / 2.0F;
      if (!this.j)
        break label412;
      f1 = paramFloat1 / this.k;
    }
    for (float f2 = paramFloat1; ; f2 = paramFloat1)
    {
      if ((f1 > 0.0F) && (localRectF.height() + 2.0F * f1 > this.i.height()))
      {
        f1 = (this.i.height() - localRectF.height()) / 2.0F;
        if (this.j)
          f2 = f1 * this.k;
      }
      localRectF.inset(-f2, -f1);
      if (localRectF.width() < 25.0F)
        localRectF.inset(-(25.0F - localRectF.width()) / 2.0F, 0.0F);
      float f3;
      if (this.j)
      {
        f3 = 25.0F / this.k;
        label203: if (localRectF.height() < f3)
          localRectF.inset(0.0F, -(f3 - localRectF.height()) / 2.0F);
        if (localRectF.left >= this.i.left)
          break label340;
        localRectF.offset(this.i.left - localRectF.left, 0.0F);
        label260: if (localRectF.top >= this.i.top)
          break label376;
        localRectF.offset(0.0F, this.i.top - localRectF.top);
      }
      while (true)
      {
        this.e.set(localRectF);
        this.d = e();
        this.a.invalidate();
        return;
        if (paramFloat2 == 0.0F)
          break;
        paramFloat1 = paramFloat2 * this.k;
        break;
        f3 = 25.0F;
        break label203;
        label340: if (localRectF.right <= this.i.right)
          break label260;
        localRectF.offset(-(localRectF.right - this.i.right), 0.0F);
        break label260;
        label376: if (localRectF.bottom > this.i.bottom)
          localRectF.offset(0.0F, -(localRectF.bottom - this.i.bottom));
      }
      label412: f1 = paramFloat2;
    }
  }

  static enum a
  {
    static
    {
      a[] arrayOfa = new a[3];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.b
 * JD-Core Version:    0.6.2
 */