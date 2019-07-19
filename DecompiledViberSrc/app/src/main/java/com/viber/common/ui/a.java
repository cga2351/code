package com.viber.common.ui;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.CornerPathEffect;
import android.graphics.Matrix;
import android.graphics.Matrix.ScaleToFit;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.Shader.TileMode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build;
import android.util.DisplayMetrics;
import android.widget.ImageView.ScaleType;

public abstract class a extends Drawable
{
  protected int a = 160;
  protected final Path b = new Path();
  protected final Rect c = new Rect();
  protected final RectF d = new RectF();
  private Bitmap e;
  private a f;
  private final RectF g = new RectF();
  private final Matrix h = new Matrix();
  private final Shader i;
  private int j;
  private int k;
  private float l;
  private float m;
  private boolean n;

  protected a(a parama, Resources paramResources)
  {
    this.f = parama;
    if (paramResources != null)
    {
      this.a = paramResources.getDisplayMetrics().densityDpi;
      a(parama.b);
      if ("SM-G900F".equals(Build.MODEL))
        this.f.a.setPathEffect(new CornerPathEffect(0.0F));
      if (this.e == null)
        break label166;
    }
    label166: for (BitmapShader localBitmapShader = new BitmapShader(this.e, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP); ; localBitmapShader = null)
    {
      this.i = localBitmapShader;
      return;
      this.a = parama.e;
      break;
    }
  }

  private void a(Bitmap paramBitmap)
  {
    if (paramBitmap != this.e)
    {
      this.e = paramBitmap;
      if (paramBitmap == null)
        break label26;
      e();
    }
    while (true)
    {
      invalidateSelf();
      return;
      label26: this.k = -1;
      this.j = -1;
      this.l = -1.0F;
      this.m = -1.0F;
    }
  }

  private void a(RectF paramRectF)
  {
    float f1 = 0.0F;
    float f2 = paramRectF.height();
    float f3 = paramRectF.width();
    float f4;
    if (f2 * this.l > f3 * this.m)
      f4 = f2 / this.m;
    for (float f5 = 0.5F * (f3 - f4 * this.l); ; f5 = 0.0F)
    {
      this.h.setScale(f4, f4);
      this.h.postTranslate((int)(f5 + 0.5F), (int)(f1 + 0.5F));
      return;
      f4 = f3 / this.l;
      f1 = 0.5F * (f2 - f4 * this.m);
    }
  }

  private void b(RectF paramRectF)
  {
    float f1 = paramRectF.height();
    float f2 = paramRectF.width();
    if ((this.j <= f2) && (this.k <= paramRectF.height()));
    for (float f3 = 1.0F; ; f3 = Math.min(f2 / this.l, f1 / this.m))
    {
      float f4 = (int)(0.5F + 0.5F * (f2 - f3 * this.l));
      float f5 = (int)(0.5F + 0.5F * (f1 - f3 * this.m));
      this.h.setScale(f3, f3);
      this.h.postTranslate(f4, f5);
      return;
    }
  }

  private void e()
  {
    Bitmap localBitmap = this.e;
    if (com.viber.common.d.a.n())
      this.j = localBitmap.getWidth();
    for (this.k = localBitmap.getHeight(); ; this.k = localBitmap.getScaledHeight(this.a))
    {
      this.m = this.k;
      this.l = this.j;
      return;
      this.j = localBitmap.getScaledWidth(this.a);
    }
  }

  private void f()
  {
    if (this.i == null)
      return;
    this.g.set(0.0F, 0.0F, this.l, this.m);
    switch (1.a[this.f.d.ordinal()])
    {
    default:
      this.h.setRectToRect(this.g, this.d, Matrix.ScaleToFit.CENTER);
      this.h.mapRect(this.g);
    case 1:
    case 2:
    case 3:
    case 4:
    case 5:
    case 6:
    }
    while (true)
    {
      this.i.setLocalMatrix(this.h);
      return;
      this.h.set(null);
      this.h.setTranslate((int)(0.5F + 0.5F * (this.d.width() - this.l)), (int)(0.5F + 0.5F * (this.d.height() - this.m)));
      continue;
      this.h.set(null);
      a(this.d);
      continue;
      this.h.set(null);
      b(this.d);
      continue;
      this.h.setRectToRect(this.g, this.d, Matrix.ScaleToFit.START);
      this.h.mapRect(this.g);
      continue;
      this.h.setRectToRect(this.g, this.d, Matrix.ScaleToFit.END);
      this.h.mapRect(this.g);
      continue;
      this.h.set(null);
      this.h.setRectToRect(this.g, this.d, Matrix.ScaleToFit.FILL);
    }
  }

  protected abstract void a(Path paramPath, Rect paramRect);

  public void a(ImageView.ScaleType paramScaleType)
  {
    if (paramScaleType == null)
      paramScaleType = ImageView.ScaleType.FIT_CENTER;
    if (this.f.d != paramScaleType)
    {
      this.f.d = paramScaleType;
      f();
    }
  }

  public final Paint ae_()
  {
    return this.f.a;
  }

  public Bitmap b()
  {
    return this.e;
  }

  protected final void c()
  {
    a(this.b, this.c);
  }

  protected abstract a d();

  public void draw(Canvas paramCanvas)
  {
    if (this.e == null)
      return;
    a locala = this.f;
    locala.a.setShader(this.i);
    paramCanvas.drawPath(this.b, locala.a);
  }

  @SuppressLint({"Override"})
  public int getAlpha()
  {
    return this.f.a.getAlpha();
  }

  public final Drawable.ConstantState getConstantState()
  {
    this.f.c = getChangingConfigurations();
    return this.f;
  }

  public int getIntrinsicHeight()
  {
    return this.k;
  }

  public int getIntrinsicWidth()
  {
    return this.j;
  }

  public int getOpacity()
  {
    return -3;
  }

  public final Drawable mutate()
  {
    if ((!this.n) && (super.mutate() == this))
    {
      this.f = d();
      this.n = true;
    }
    return this;
  }

  protected void onBoundsChange(Rect paramRect)
  {
    super.onBoundsChange(paramRect);
    this.c.set(paramRect);
    this.d.set(paramRect);
    a(this.b, paramRect);
    f();
  }

  public void setAlpha(int paramInt)
  {
    if (paramInt != this.f.a.getAlpha())
    {
      this.f.a.setAlpha(paramInt);
      invalidateSelf();
    }
  }

  public void setColorFilter(ColorFilter paramColorFilter)
  {
    this.f.a.setColorFilter(paramColorFilter);
    invalidateSelf();
  }

  public void setDither(boolean paramBoolean)
  {
    this.f.a.setDither(paramBoolean);
    invalidateSelf();
  }

  public void setFilterBitmap(boolean paramBoolean)
  {
    this.f.a.setFilterBitmap(paramBoolean);
    invalidateSelf();
  }

  protected static abstract class a extends Drawable.ConstantState
  {
    Paint a = new Paint(3);
    Bitmap b;
    int c;
    ImageView.ScaleType d = ImageView.ScaleType.FIT_CENTER;
    int e = 160;

    protected a(Bitmap paramBitmap)
    {
      this.b = paramBitmap;
    }

    protected a(a parama)
    {
      this(parama.b);
      this.c = parama.c;
      this.e = parama.e;
      this.a = new Paint(parama.a);
      this.d = parama.d;
    }

    public int getChangingConfigurations()
    {
      return this.c;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.viber.common.ui.a
 * JD-Core Version:    0.6.2
 */