package android.support.design.g;

import android.content.res.ColorStateList;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Region.Op;
import android.graphics.drawable.Drawable;
import android.support.v4.graphics.drawable.TintAwareDrawable;

public class c extends Drawable
  implements TintAwareDrawable
{
  private final Paint a;
  private final Matrix[] b;
  private final Matrix[] c;
  private final d[] d;
  private final Matrix e;
  private final Path f;
  private final PointF g;
  private final d h;
  private final Region i;
  private final Region j;
  private final float[] k;
  private final float[] l;
  private e m;
  private boolean n;
  private boolean o;
  private float p;
  private int q;
  private int r;
  private int s;
  private int t;
  private float u;
  private float v;
  private Paint.Style w;
  private PorterDuffColorFilter x;
  private PorterDuff.Mode y;
  private ColorStateList z;

  private static int a(int paramInt1, int paramInt2)
  {
    return paramInt1 * (paramInt2 + (paramInt2 >>> 7)) >>> 8;
  }

  private a a(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return this.m.a();
    case 1:
      return this.m.b();
    case 2:
      return this.m.c();
    case 3:
    }
    return this.m.d();
  }

  private void a(int paramInt1, int paramInt2, int paramInt3)
  {
    a(paramInt1, paramInt2, paramInt3, this.g);
    float f1 = c(paramInt1, paramInt2, paramInt3);
    a(paramInt1).a(f1, this.p, this.d[paramInt1]);
    float f2 = 1.570796F + d((4 + (paramInt1 - 1)) % 4, paramInt2, paramInt3);
    this.b[paramInt1].reset();
    this.b[paramInt1].setTranslate(this.g.x, this.g.y);
    this.b[paramInt1].preRotate((float)Math.toDegrees(f2));
  }

  private void a(int paramInt1, int paramInt2, int paramInt3, PointF paramPointF)
  {
    switch (paramInt1)
    {
    default:
      paramPointF.set(0.0F, 0.0F);
      return;
    case 1:
      paramPointF.set(paramInt2, 0.0F);
      return;
    case 2:
      paramPointF.set(paramInt2, paramInt3);
      return;
    case 3:
    }
    paramPointF.set(0.0F, paramInt3);
  }

  private void a(int paramInt, Path paramPath)
  {
    this.k[0] = this.d[paramInt].a;
    this.k[1] = this.d[paramInt].b;
    this.b[paramInt].mapPoints(this.k);
    if (paramInt == 0)
      paramPath.moveTo(this.k[0], this.k[1]);
    while (true)
    {
      this.d[paramInt].a(this.b[paramInt], paramPath);
      return;
      paramPath.lineTo(this.k[0], this.k[1]);
    }
  }

  private b b(int paramInt)
  {
    switch (paramInt)
    {
    default:
      return this.m.e();
    case 1:
      return this.m.f();
    case 2:
      return this.m.g();
    case 3:
    }
    return this.m.h();
  }

  private void b()
  {
    if ((this.z == null) || (this.y == null))
      this.x = null;
    int i1;
    do
    {
      return;
      i1 = this.z.getColorForState(getState(), 0);
      this.x = new PorterDuffColorFilter(i1, this.y);
    }
    while (!this.o);
    this.q = i1;
  }

  private void b(int paramInt1, int paramInt2, int paramInt3)
  {
    this.k[0] = this.d[paramInt1].c;
    this.k[1] = this.d[paramInt1].d;
    this.b[paramInt1].mapPoints(this.k);
    float f1 = d(paramInt1, paramInt2, paramInt3);
    this.c[paramInt1].reset();
    this.c[paramInt1].setTranslate(this.k[0], this.k[1]);
    this.c[paramInt1].preRotate((float)Math.toDegrees(f1));
  }

  private void b(int paramInt1, int paramInt2, Path paramPath)
  {
    a(paramInt1, paramInt2, paramPath);
    if (this.u == 1.0F)
      return;
    this.e.reset();
    this.e.setScale(this.u, this.u, paramInt1 / 2, paramInt2 / 2);
    paramPath.transform(this.e);
  }

  private void b(int paramInt, Path paramPath)
  {
    int i1 = (paramInt + 1) % 4;
    this.k[0] = this.d[paramInt].c;
    this.k[1] = this.d[paramInt].d;
    this.b[paramInt].mapPoints(this.k);
    this.l[0] = this.d[i1].a;
    this.l[1] = this.d[i1].b;
    this.b[i1].mapPoints(this.l);
    float f1 = (float)Math.hypot(this.k[0] - this.l[0], this.k[1] - this.l[1]);
    this.h.a(0.0F, 0.0F);
    b(paramInt).a(f1, this.p, this.h);
    this.h.a(this.c[paramInt], paramPath);
  }

  private float c(int paramInt1, int paramInt2, int paramInt3)
  {
    a((4 + (paramInt1 - 1)) % 4, paramInt2, paramInt3, this.g);
    float f1 = this.g.x;
    float f2 = this.g.y;
    a((paramInt1 + 1) % 4, paramInt2, paramInt3, this.g);
    float f3 = this.g.x;
    float f4 = this.g.y;
    a(paramInt1, paramInt2, paramInt3, this.g);
    float f5 = this.g.x;
    float f6 = this.g.y;
    float f7 = f1 - f5;
    float f8 = f2 - f6;
    float f9 = f3 - f5;
    float f10 = f4 - f6;
    float f11 = (float)Math.atan2(f8, f7) - (float)Math.atan2(f10, f9);
    if (f11 < 0.0F)
      f11 = (float)(6.283185307179586D + f11);
    return f11;
  }

  private float d(int paramInt1, int paramInt2, int paramInt3)
  {
    int i1 = (paramInt1 + 1) % 4;
    a(paramInt1, paramInt2, paramInt3, this.g);
    float f1 = this.g.x;
    float f2 = this.g.y;
    a(i1, paramInt2, paramInt3, this.g);
    float f3 = this.g.x;
    float f4 = this.g.y;
    float f5 = f3 - f1;
    return (float)Math.atan2(f4 - f2, f5);
  }

  public ColorStateList a()
  {
    return this.z;
  }

  public void a(float paramFloat)
  {
    this.p = paramFloat;
    invalidateSelf();
  }

  public void a(int paramInt1, int paramInt2, Path paramPath)
  {
    paramPath.rewind();
    if (this.m == null)
      return;
    int i2;
    for (int i1 = 0; ; i1++)
    {
      i2 = 0;
      if (i1 >= 4)
        break;
      a(i1, paramInt1, paramInt2);
      b(i1, paramInt1, paramInt2);
    }
    while (i2 < 4)
    {
      a(i2, paramPath);
      b(i2, paramPath);
      i2++;
    }
    paramPath.close();
  }

  public void draw(Canvas paramCanvas)
  {
    this.a.setColorFilter(this.x);
    int i1 = this.a.getAlpha();
    this.a.setAlpha(a(i1, this.t));
    this.a.setStrokeWidth(this.v);
    this.a.setStyle(this.w);
    if ((this.r > 0) && (this.n))
      this.a.setShadowLayer(this.s, 0.0F, this.r, this.q);
    if (this.m != null)
    {
      b(paramCanvas.getWidth(), paramCanvas.getHeight(), this.f);
      paramCanvas.drawPath(this.f, this.a);
    }
    while (true)
    {
      this.a.setAlpha(i1);
      return;
      paramCanvas.drawRect(0.0F, 0.0F, paramCanvas.getWidth(), paramCanvas.getHeight(), this.a);
    }
  }

  public int getOpacity()
  {
    return -3;
  }

  public Region getTransparentRegion()
  {
    Rect localRect = getBounds();
    this.i.set(localRect);
    b(localRect.width(), localRect.height(), this.f);
    this.j.setPath(this.f, this.i);
    this.i.op(this.j, Region.Op.DIFFERENCE);
    return this.i;
  }

  public void setAlpha(int paramInt)
  {
    this.t = paramInt;
    invalidateSelf();
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }

  public void setTint(int paramInt)
  {
    setTintList(ColorStateList.valueOf(paramInt));
  }

  public void setTintList(ColorStateList paramColorStateList)
  {
    this.z = paramColorStateList;
    b();
    invalidateSelf();
  }

  public void setTintMode(PorterDuff.Mode paramMode)
  {
    this.y = paramMode;
    b();
    invalidateSelf();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.g.c
 * JD-Core Version:    0.6.2
 */