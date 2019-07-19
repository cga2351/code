package com.viber.voip.messages.extras.image.imagezoom;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Matrix;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.viber.dexshared.Logger;
import com.viber.voip.R.styleable;
import com.viber.voip.ViberEnv;

public class b extends ImageView
{
  private static final Logger a = ViberEnv.getLogger();
  private float b = 0.0F;
  private float c = 0.0F;
  private float d = 0.0F;
  private float e = 0.0F;
  private b f;
  protected int l;
  protected Matrix m = new Matrix();
  protected Matrix n = new Matrix();
  protected Handler o = new Handler();
  protected Runnable p = null;
  protected float q;
  protected final Matrix r = new Matrix();
  protected final float[] s = new float[9];
  protected int t = -1;
  protected int u = -1;
  protected final c v = new c(null, 0);

  public b(Context paramContext)
  {
    super(paramContext);
    a();
  }

  public b(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ImageViewTouch);
    try
    {
      a(localTypedArray.getDimension(R.styleable.ImageViewTouch_bitmapLeftPadding, 0.0F), localTypedArray.getDimension(R.styleable.ImageViewTouch_bitmapTopPadding, 0.0F), localTypedArray.getDimension(R.styleable.ImageViewTouch_bitmapRightPadding, 0.0F), localTypedArray.getDimension(R.styleable.ImageViewTouch_bitmapBottomPadding, 0.0F));
      localTypedArray.recycle();
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  protected float a(Matrix paramMatrix)
  {
    return a(paramMatrix, 0);
  }

  protected float a(Matrix paramMatrix, int paramInt)
  {
    paramMatrix.getValues(this.s);
    return this.s[paramInt];
  }

  protected void a()
  {
    setScaleType(ImageView.ScaleType.MATRIX);
  }

  protected void a(float paramFloat)
  {
  }

  protected void a(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    this.n.postScale(paramFloat1, paramFloat1, paramFloat2, paramFloat3);
    a(a.c, getImageViewMatrix());
  }

  public void a(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
  {
    this.b = paramFloat1;
    this.c = paramFloat2;
    this.d = paramFloat3;
    this.e = paramFloat4;
  }

  protected void a(Bitmap paramBitmap, int paramInt)
  {
    super.setImageBitmap(paramBitmap);
    Drawable localDrawable = getDrawable();
    if (localDrawable != null)
      localDrawable.setDither(true);
    this.v.a(paramBitmap);
    this.v.a(paramInt);
  }

  public void a(Bitmap paramBitmap, int paramInt, boolean paramBoolean)
  {
    a(new c(paramBitmap, paramInt), paramBoolean);
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    a(new c(paramBitmap, 0), paramBoolean);
  }

  protected void a(RectF paramRectF1, RectF paramRectF2)
  {
    float f1 = getWidth();
    float f2 = getHeight();
    if ((paramRectF1.top >= 0.0F) && (paramRectF1.bottom <= f2))
      paramRectF2.top = 0.0F;
    if ((paramRectF1.left >= 0.0F) && (paramRectF1.right <= f1))
      paramRectF2.left = 0.0F;
    if ((paramRectF1.top + paramRectF2.top >= 0.0F) && (paramRectF1.bottom > f2))
      paramRectF2.top = ((int)(0.0F - paramRectF1.top));
    if ((paramRectF1.bottom + paramRectF2.top <= f2 - 0.0F) && (paramRectF1.top < 0.0F))
      paramRectF2.top = ((int)(f2 - 0.0F - paramRectF1.bottom));
    if (paramRectF1.left + paramRectF2.left >= 0.0F)
      paramRectF2.left = ((int)(0.0F - paramRectF1.left));
    if (paramRectF1.right + paramRectF2.left <= f1 - 0.0F)
      paramRectF2.left = ((int)(f1 - 0.0F - paramRectF1.right));
  }

  protected void a(a parama, Matrix paramMatrix)
  {
    setImageMatrix(paramMatrix);
  }

  protected void a(c paramc, Matrix paramMatrix)
  {
    float f1 = getWidth() - this.b - this.d;
    float f2 = getHeight() - this.c - this.e;
    float f3 = paramc.e();
    float f4 = paramc.d();
    paramMatrix.reset();
    float f5 = Math.min(Math.min(f1 / f3, 2.0F), Math.min(f2 / f4, 2.0F));
    paramMatrix.postConcat(paramc.c());
    paramMatrix.postScale(f5, f5);
    paramMatrix.postTranslate((getWidth() - f3 * f5) / 2.0F, (getHeight() - f5 * f4) / 2.0F);
  }

  public void a(final c paramc, final boolean paramBoolean)
  {
    if (getWidth() <= 0)
    {
      this.p = new Runnable()
      {
        public void run()
        {
          b.this.a(paramc.b(), paramc.a(), paramBoolean);
        }
      };
      return;
    }
    if (paramc.b() != null)
    {
      a(paramc, this.m);
      a(paramc.b(), paramc.a());
    }
    while (true)
    {
      if (paramBoolean)
        this.n.reset();
      a(a.e, getImageViewMatrix());
      this.q = b();
      if (this.f == null)
        break;
      this.f.a(paramc.b());
      return;
      this.m.reset();
      setImageBitmap(null);
    }
  }

  protected void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.v.b() == null);
    RectF localRectF;
    do
    {
      return;
      localRectF = b(paramBoolean1, paramBoolean2);
    }
    while ((localRectF.left == 0.0F) && (localRectF.top == 0.0F));
    b(localRectF.left, localRectF.top);
  }

  protected float b()
  {
    if (this.v.b() == null)
      return 1.0F;
    return 4.0F * Math.max(this.v.e() / this.t, this.v.d() / this.u);
  }

  protected RectF b(boolean paramBoolean1, boolean paramBoolean2)
  {
    if (this.v.b() == null)
      return new RectF(0.0F, 0.0F, 0.0F, 0.0F);
    RectF localRectF = getBitmapRect();
    float f1 = localRectF.height();
    float f2 = localRectF.width();
    int j;
    float f3;
    if (paramBoolean2)
    {
      j = getHeight();
      if (f1 < j)
        f3 = (j - f1) / 2.0F - localRectF.top;
    }
    while (true)
    {
      int i;
      float f4;
      if (paramBoolean1)
      {
        i = getWidth();
        if (f2 < i)
          f4 = (i - f2) / 2.0F - localRectF.left;
      }
      while (true)
      {
        return new RectF(f4, f3, 0.0F, 0.0F);
        if (localRectF.top > 0.0F)
        {
          f3 = -localRectF.top;
          break;
        }
        if (localRectF.bottom >= j)
          break label215;
        f3 = getHeight() - localRectF.bottom;
        break;
        if (localRectF.left > 0.0F)
          f4 = -localRectF.left;
        else if (localRectF.right < i)
          f4 = i - localRectF.right;
        else
          f4 = 0.0F;
      }
      label215: f3 = 0.0F;
    }
  }

  public void b(float paramFloat)
  {
    b(paramFloat, getWidth() / 2.0F, getHeight() / 2.0F);
  }

  protected void b(float paramFloat1, float paramFloat2)
  {
    this.n.postTranslate(paramFloat1, paramFloat2);
    a(a.b, getImageViewMatrix());
  }

  public void b(float paramFloat1, float paramFloat2, float paramFloat3)
  {
    if (paramFloat1 > this.q)
      paramFloat1 = this.q;
    a(paramFloat1 / getScale(), paramFloat2, paramFloat3);
    a(getScale());
    a(true, true);
  }

  protected void b(float paramFloat1, final float paramFloat2, final float paramFloat3, final float paramFloat4)
  {
    final long l1 = System.currentTimeMillis();
    final float f1 = (paramFloat1 - getScale()) / paramFloat4;
    float f2 = getScale();
    this.o.post(new Runnable()
    {
      public void run()
      {
        long l = System.currentTimeMillis();
        float f1 = Math.min(paramFloat4, (float)(l - l1));
        float f2 = f1 + f1 * paramFloat2;
        b.this.b(f2, paramFloat3, this.f);
        if (f1 < paramFloat4)
          b.this.o.post(this);
      }
    });
  }

  public void c()
  {
    this.p = null;
  }

  public void c(float paramFloat1, float paramFloat2)
  {
    b(paramFloat1, getWidth() / 2.0F, getHeight() / 2.0F, paramFloat2);
  }

  protected void c(float paramFloat1, final float paramFloat2, final float paramFloat3)
  {
    final long l1 = System.currentTimeMillis();
    this.o.post(new Runnable()
    {
      float a = 0.0F;
      float b = 0.0F;

      public void run()
      {
        long l = System.currentTimeMillis();
        float f1 = Math.min(paramFloat3, (float)(l - l1));
        float f2 = a.a(f1, 0.0F, paramFloat2, paramFloat3);
        float f3 = a.a(f1, 0.0F, this.f, paramFloat3);
        b.this.e(f2 - this.a, f3 - this.b);
        this.a = f2;
        this.b = f3;
        if (f1 < paramFloat3)
          b.this.o.post(this);
        RectF localRectF;
        do
        {
          return;
          localRectF = b.this.b(true, true);
        }
        while ((localRectF.left == 0.0F) && (localRectF.top == 0.0F));
        b.this.d(localRectF.left, localRectF.top);
      }
    });
  }

  public void d(float paramFloat1, float paramFloat2)
  {
    e(paramFloat1, paramFloat2);
  }

  protected void e(float paramFloat1, float paramFloat2)
  {
    RectF localRectF1 = getBitmapRect();
    if (localRectF1 == null)
      return;
    RectF localRectF2 = new RectF(paramFloat1, paramFloat2, 0.0F, 0.0F);
    a(localRectF1, localRectF2);
    b(localRectF2.left, localRectF2.top);
    a(true, true);
  }

  protected RectF getBitmapRect()
  {
    if (this.v.b() == null)
      return null;
    Matrix localMatrix = getImageViewMatrix();
    RectF localRectF = new RectF(0.0F, 0.0F, this.v.b().getWidth(), this.v.b().getHeight());
    localMatrix.mapRect(localRectF);
    return localRectF;
  }

  public c getDisplayBitmap()
  {
    return this.v;
  }

  protected Matrix getImageViewMatrix()
  {
    this.r.set(this.m);
    this.r.postConcat(this.n);
    return this.r;
  }

  public float getMaxZoom()
  {
    return this.q;
  }

  public float getScale()
  {
    return a(this.n);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.t = (paramInt3 - paramInt1);
    this.u = (paramInt4 - paramInt2);
    Runnable localRunnable = this.p;
    if (localRunnable != null)
    {
      this.p = null;
      localRunnable.run();
    }
    if (this.v.b() != null)
    {
      a(this.v, this.m);
      a(a.d, getImageViewMatrix());
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.l = ((int)(0.3D * paramInt1));
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    a(paramBitmap, 0);
  }

  public void setOnBitmapChangedListener(b paramb)
  {
    this.f = paramb;
  }

  protected static enum a
  {
    static
    {
      a[] arrayOfa = new a[5];
      arrayOfa[0] = a;
      arrayOfa[1] = b;
      arrayOfa[2] = c;
      arrayOfa[3] = d;
      arrayOfa[4] = e;
    }
  }

  public static abstract interface b
  {
    public abstract void a(Bitmap paramBitmap);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.messages.extras.image.imagezoom.b
 * JD-Core Version:    0.6.2
 */