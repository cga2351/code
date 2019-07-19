package com.android.camera;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;

abstract class c extends ImageView
{
  private final Matrix a = new Matrix();
  private final float[] b = new float[9];
  private a c;
  private Runnable d = null;
  protected Matrix f = new Matrix();
  protected Matrix g = new Matrix();
  protected final d h = new d(null);
  int i = -1;
  int j = -1;
  float k;
  protected Handler l = new Handler();

  public c(Context paramContext)
  {
    super(paramContext);
    c();
  }

  public c(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    c();
  }

  private void a(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setDither(true);
    Bitmap localBitmap = this.h.b();
    this.h.a(paramBitmap);
    this.h.a(paramInt);
    if ((localBitmap != null) && (localBitmap != paramBitmap) && (this.c != null))
      this.c.a(localBitmap);
  }

  private void a(d paramd, Matrix paramMatrix)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    float f3 = paramd.f();
    float f4 = paramd.e();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, 3.0F), Math.min(f2 / f4, 3.0F));
    paramMatrix.postConcat(paramd.c());
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((f1 - f3 * f5) / 2.0F, (f2 - f4 * f5) / 2.0F);
  }

  private void c()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  protected float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }

  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.b);
    return this.b[paramInt];
  }

  public void a()
  {
    a(null, true);
  }

  protected void a(float paramFloat)
  {
    a(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }

  protected void a(float paramFloat1, float paramFloat2)
  {
    this.g.postTranslate(paramFloat1, paramFloat2);
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > this.k)
      paramFloat1 = this.k;
    float f1 = paramFloat1 / getScale();
    this.g.postScale(f1, f1, paramFloat2, paramFloat3);
    setImageMatrix(getImageViewMatrix());
    a(true, true);
  }

  protected void a(float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    final float f1 = (paramFloat1 - getScale()) / paramFloat4;
    float f2 = getScale();
    final long l1 = System.currentTimeMillis();
    this.l.post(new Runnable()
    {
      public void run()
      {
        long l = System.currentTimeMillis();
        float f1 = Math.min(paramFloat4, (float)(l - l1));
        float f2 = f1 + f1 * paramFloat2;
        c.this.a(f2, paramFloat3, this.f);
        if (f1 < paramFloat4)
          c.this.l.post(this);
      }
    });
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    a(new d(paramBitmap), paramBoolean);
  }

  public void a(final d paramd, final boolean paramBoolean)
  {
    if (getWidth() <= 0)
    {
      this.d = new Runnable()
      {
        public void run()
        {
          c.this.a(paramd, paramBoolean);
        }
      };
      return;
    }
    if (paramd.b() != null)
    {
      a(paramd, this.f);
      a(paramd.b(), paramd.a());
    }
    while (true)
    {
      if (paramBoolean)
        this.g.reset();
      setImageMatrix(getImageViewMatrix());
      this.k = b();
      return;
      this.f.reset();
      setImageBitmap(null);
    }
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.h.b() == null)
      return;
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, this.h.b().getWidth(), this.h.b().getHeight());
    localMatrix.mapRect(localRectF);
    float f1 = localRectF.height();
    float f2 = localRectF.width();
    int n;
    float f3;
    if (paramBoolean2)
    {
      n = getHeight();
      if (f1 < n)
        f3 = (n - f1) / 2.0F - localRectF.top;
    }
    while (true)
    {
      float f4 = 0.0F;
      int m;
      if (paramBoolean1)
      {
        m = getWidth();
        if (f2 >= m)
          break label209;
        f4 = (m - f2) / 2.0F - localRectF.left;
      }
      while (true)
      {
        a(f4, f3);
        setImageMatrix(getImageViewMatrix());
        return;
        if (localRectF.top > 0.0F)
        {
          f3 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= n)
          break label263;
        f3 = getHeight() - localRectF.bottom;
        break;
        label209: if (localRectF.left > 0.0F)
        {
          f4 = -localRectF.left;
        }
        else
        {
          boolean bool = localRectF.right < m;
          f4 = 0.0F;
          if (bool)
            f4 = m - localRectF.right;
        }
      }
      label263: f3 = 0.0F;
    }
  }

  protected float b()
  {
    if (this.h.b() == null)
      return 1.0F;
    return 4.0F * Math.max(this.h.f() / this.i, this.h.e() / this.j);
  }

  protected void b(float paramFloat1, float paramFloat2)
  {
    a(paramFloat1, paramFloat2);
    setImageMatrix(getImageViewMatrix());
  }

  protected Matrix getImageViewMatrix()
  {
    this.a.set(this.f);
    this.a.postConcat(this.g);
    return this.a;
  }

  protected float getScale()
  {
    return a(this.g);
  }

  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.getRepeatCount() == 0))
    {
      paramKeyEvent.startTracking();
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }

  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((paramInt == 4) && (paramKeyEvent.isTracking()) && (!paramKeyEvent.isCanceled()) && (getScale() > 1.0F))
    {
      a(1.0F);
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.i = (paramInt3 - paramInt1);
    this.j = (paramInt4 - paramInt2);
    Runnable localRunnable = this.d;
    if (localRunnable != null)
    {
      this.d = null;
      localRunnable.run();
    }
    if (this.h.b() != null)
    {
      a(this.h, this.f);
      setImageMatrix(getImageViewMatrix());
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }

  public void setRecycler(a parama)
  {
    this.c = parama;
  }

  public static abstract interface a
  {
    public abstract void a(Bitmap paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.android.camera.c
 * JD-Core Version:    0.6.2
 */