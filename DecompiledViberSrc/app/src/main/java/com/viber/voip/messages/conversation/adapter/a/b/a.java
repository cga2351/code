package com.viber.voip.messages.conversation.adapter.a.b;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.StateListDrawable;

public class a extends StateListDrawable
{
  private final float a = 3000.0F;
  private float b;
  private float c;
  private boolean d;
  private boolean e;
  private Paint f = new Paint(1);
  private ColorStateList g;
  private Path h = new Path();
  private RectF i;
  private Path j = new Path();
  private final Matrix k = new Matrix();
  private int l;
  private int m;
  private boolean n;
  private final RectF o = new RectF();

  private void a(Path paramPath)
  {
    this.k.reset();
    this.k.setScale(-1.0F, 1.0F);
    this.k.postTranslate(this.l, 0.0F);
    paramPath.transform(this.k);
  }

  private void a(boolean paramBoolean)
  {
    float f1 = this.l;
    float f2 = this.m;
    float f3 = f2 - this.c;
    float f4 = f1 - this.c;
    boolean bool;
    label78: RectF localRectF;
    if (f2 > 3000.0F)
    {
      bool = true;
      this.e = bool;
      this.h.rewind();
      if (!this.e)
        break label368;
      this.h.moveTo(f1, 3000.0F);
      this.h.lineTo(0.0F, 3000.0F);
      this.h.lineTo(0.0F, this.b);
      this.o.set(0.0F, 0.0F, this.c, this.c);
      this.h.arcTo(this.o, 180.0F, 90.0F);
      this.h.lineTo(f1 - this.b, 0.0F);
      if (!paramBoolean)
        break label427;
      this.h.lineTo(f1, 0.0F);
      label149: if (!this.e)
        break label460;
      this.h.lineTo(f1, 3000.0F);
      label166: this.h.close();
      if (this.d)
        a(this.h);
      if (this.e)
      {
        if (this.i == null)
          this.i = new RectF();
        localRectF = this.i;
        if (!this.d)
          break label504;
      }
    }
    label368: label504: for (float f5 = this.l; ; f5 = f1)
    {
      localRectF.set(0.0F, 3000.0F, f5, f2 - this.b);
      this.j.rewind();
      this.j.moveTo(f1, f2 - this.b);
      this.o.set(f4, f3, f1, f2);
      this.j.arcTo(this.o, 0.0F, 90.0F);
      this.j.lineTo(this.b, f2);
      this.o.set(0.0F, f3, this.c, f2);
      this.j.arcTo(this.o, 90.0F, 90.0F);
      this.j.close();
      if (this.d)
        a(this.j);
      return;
      bool = false;
      break;
      this.h.moveTo(f1 - this.b, f2);
      this.h.lineTo(this.b, f2);
      this.o.set(0.0F, f3, this.c, f2);
      this.h.arcTo(this.o, 90.0F, 90.0F);
      break label78;
      this.o.set(f4, 0.0F, f1, this.c);
      this.h.arcTo(this.o, 270.0F, 90.0F);
      break label149;
      this.h.lineTo(f1, f2 - this.b);
      this.o.set(f4, f3, f1, f2);
      this.h.arcTo(this.o, 0.0F, 90.0F);
      break label166;
    }
  }

  public boolean a(boolean paramBoolean1, boolean paramBoolean2, ColorStateList paramColorStateList, float paramFloat)
  {
    if ((this.n != paramBoolean1) || (this.d != paramBoolean2) || (this.g != paramColorStateList) || (this.b != paramFloat));
    for (boolean bool = true; ; bool = false)
    {
      this.d = paramBoolean2;
      this.g = paramColorStateList;
      this.f.setColor(paramColorStateList.getDefaultColor());
      this.n = paramBoolean1;
      this.b = paramFloat;
      this.c = (2.0F * this.b);
      return bool;
    }
  }

  public void draw(Canvas paramCanvas)
  {
    a(this.n);
    paramCanvas.drawPath(this.h, this.f);
    if ((this.e) && (this.i != null))
    {
      paramCanvas.drawRect(this.i, this.f);
      paramCanvas.drawPath(this.j, this.f);
    }
  }

  public int getOpacity()
  {
    return -2;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.m = paramRect.height();
    this.l = paramRect.width();
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.f != null)
    {
      this.f.setColor(this.g.getColorForState(paramArrayOfInt, this.g.getDefaultColor()));
      invalidateSelf();
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }

  public void setAlpha(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.conversation.adapter.a.b.a
 * JD-Core Version:    0.6.2
 */