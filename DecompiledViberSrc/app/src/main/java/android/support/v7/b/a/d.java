package android.support.v7.b.a;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.DrawableCompat;

public class d extends Drawable
{
  private static final float b = (float)Math.toRadians(45.0D);
  private final Paint a;
  private float c;
  private float d;
  private float e;
  private float f;
  private boolean g;
  private final Path h;
  private final int i;
  private boolean j;
  private float k;
  private float l;
  private int m;

  private static float a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    return paramFloat1 + paramFloat3 * (paramFloat2 - paramFloat1);
  }

  public void a(float paramFloat)
  {
    if (this.k != paramFloat)
    {
      this.k = paramFloat;
      invalidateSelf();
    }
  }

  public void a(boolean paramBoolean)
  {
    if (this.j != paramBoolean)
    {
      this.j = paramBoolean;
      invalidateSelf();
    }
  }

  public void draw(Canvas paramCanvas)
  {
    Rect localRect = getBounds();
    int n;
    float f6;
    label138: float f7;
    label146: int i1;
    switch (this.m)
    {
    case 2:
    default:
      if (DrawableCompat.getLayoutDirection(this) == 1)
      {
        n = 1;
        float f1 = (float)Math.sqrt(2.0F * (this.c * this.c));
        float f2 = a(this.d, f1, this.k);
        float f3 = a(this.d, this.e, this.k);
        float f4 = Math.round(a(0.0F, this.l, this.k));
        float f5 = a(0.0F, b, this.k);
        if (n == 0)
          break label452;
        f6 = 0.0F;
        if (n == 0)
          break label459;
        f7 = 180.0F;
        float f8 = a(f6, f7, this.k);
        float f9 = (float)Math.round(f2 * Math.cos(f5));
        float f10 = (float)Math.round(f2 * Math.sin(f5));
        this.h.rewind();
        float f11 = a(this.f + this.a.getStrokeWidth(), -this.l, this.k);
        float f12 = -f3 / 2.0F;
        this.h.moveTo(f12 + f4, 0.0F);
        this.h.rLineTo(f3 - f4 * 2.0F, 0.0F);
        this.h.moveTo(f12, f11);
        this.h.rLineTo(f9, f10);
        this.h.moveTo(f12, -f11);
        this.h.rLineTo(f9, -f10);
        this.h.close();
        paramCanvas.save();
        float f13 = this.a.getStrokeWidth();
        float f14 = 2 * ((int)(localRect.height() - 3.0F * f13 - 2.0F * this.f) / 4) + (f13 * 1.5F + this.f);
        paramCanvas.translate(localRect.centerX(), f14);
        if (!this.g)
          break label471;
        if ((n ^ this.j) == 0)
          break label465;
        i1 = -1;
        label393: paramCanvas.rotate(f8 * i1);
      }
      break;
    case 0:
    case 1:
    case 3:
    }
    while (true)
    {
      paramCanvas.drawPath(this.h, this.a);
      paramCanvas.restore();
      return;
      n = 0;
      break;
      n = 1;
      break;
      if (DrawableCompat.getLayoutDirection(this) == 0)
      {
        n = 1;
        break;
      }
      n = 0;
      break;
      n = 0;
      break;
      label452: f6 = -180.0F;
      break label138;
      label459: f7 = 0.0F;
      break label146;
      label465: i1 = 1;
      break label393;
      label471: if (n != 0)
        paramCanvas.rotate(180.0F);
    }
  }

  public int getIntrinsicHeight()
  {
    return this.i;
  }

  public int getIntrinsicWidth()
  {
    return this.i;
  }

  public int getOpacity()
  {
    return -3;
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.a.getAlpha())
    {
      this.a.setAlpha(paramInt);
      invalidateSelf();
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.v7.b.a.d
 * JD-Core Version:    0.6.2
 */