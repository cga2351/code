package com.viber.voip.ui.d;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.StateListDrawable;

public class g extends StateListDrawable
{
  private float a;
  private float b;
  private boolean c;
  private Paint d = new Paint(1);
  private ColorStateList e;
  private Path f = new Path();
  private final Matrix g = new Matrix();
  private int h;
  private int i;
  private boolean j;
  private boolean k;
  private boolean l;
  private final RectF m = new RectF();

  private void a(Path paramPath)
  {
    this.g.reset();
    this.g.setScale(-1.0F, 1.0F);
    this.g.postTranslate(this.h, 0.0F);
    paramPath.transform(this.g);
  }

  private void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    float f1 = this.h;
    float f2 = this.i;
    float f3 = f2 - this.b;
    float f4 = f1 - this.b;
    this.f.rewind();
    Path localPath1 = this.f;
    float f5;
    float f6;
    label83: float f7;
    label143: label220: Path localPath4;
    if (paramBoolean3)
    {
      f5 = this.a;
      localPath1.moveTo(f1 - f5, f2);
      Path localPath2 = this.f;
      if (!paramBoolean3)
        break label310;
      f6 = this.a;
      localPath2.lineTo(f6, f2);
      if (paramBoolean3)
      {
        this.m.set(0.0F, f3, this.b, f2);
        this.f.arcTo(this.m, 90.0F, 90.0F);
      }
      Path localPath3 = this.f;
      if (!paramBoolean2)
        break label316;
      f7 = this.a;
      localPath3.lineTo(0.0F, f7);
      if (paramBoolean2)
      {
        this.m.set(0.0F, 0.0F, this.b, this.b);
        this.f.arcTo(this.m, 180.0F, 90.0F);
      }
      this.f.lineTo(f1 - this.a, 0.0F);
      if ((!paramBoolean1) && (paramBoolean2))
        break label322;
      this.f.lineTo(f1, 0.0F);
      localPath4 = this.f;
      if (!paramBoolean3)
        break label356;
    }
    label310: label316: label322: label356: for (float f8 = this.a; ; f8 = f2)
    {
      localPath4.lineTo(f1, f2 - f8);
      if (paramBoolean3)
      {
        this.m.set(f4, f3, f1, f2);
        this.f.arcTo(this.m, 0.0F, 90.0F);
      }
      this.f.close();
      if (this.c)
        a(this.f);
      return;
      f5 = 0.0F;
      break;
      f6 = 0.0F;
      break label83;
      f7 = 0.0F;
      break label143;
      this.m.set(f4, 0.0F, f1, this.b);
      this.f.arcTo(this.m, 270.0F, 90.0F);
      break label220;
    }
  }

  public void a(boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3, boolean paramBoolean4, ColorStateList paramColorStateList, float paramFloat)
  {
    this.c = paramBoolean4;
    this.e = paramColorStateList;
    this.d.setColor(paramColorStateList.getDefaultColor());
    this.l = paramBoolean1;
    this.j = paramBoolean2;
    this.k = paramBoolean3;
    this.a = paramFloat;
    this.b = (2.0F * this.a);
  }

  public void draw(Canvas paramCanvas)
  {
    a(this.l, this.j, this.k);
    paramCanvas.drawPath(this.f, this.d);
  }

  public int getOpacity()
  {
    return -2;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.i = paramRect.height();
    this.h = paramRect.width();
  }

  protected boolean onStateChange(int[] paramArrayOfInt)
  {
    if (this.e != null)
    {
      this.d.setColor(this.e.getColorForState(paramArrayOfInt, this.e.getDefaultColor()));
      invalidateSelf();
      return true;
    }
    return super.onStateChange(paramArrayOfInt);
  }

  public void setAlpha(int paramInt)
  {
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.d.g
 * JD-Core Version:    0.6.2
 */