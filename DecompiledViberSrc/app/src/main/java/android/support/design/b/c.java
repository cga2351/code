package android.support.design.b;

import android.annotation.TargetApi;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.PorterDuff.Mode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build.VERSION;
import android.support.design.R.styleable;
import android.support.design.internal.k;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;

class c
{
  private static final boolean a;
  private final a b;
  private int c;
  private int d;
  private int e;
  private int f;
  private int g;
  private int h;
  private PorterDuff.Mode i;
  private ColorStateList j;
  private ColorStateList k;
  private ColorStateList l;
  private final Paint m = new Paint(1);
  private final Rect n = new Rect();
  private final RectF o = new RectF();
  private GradientDrawable p;
  private Drawable q;
  private GradientDrawable r;
  private Drawable s;
  private GradientDrawable t;
  private GradientDrawable u;
  private GradientDrawable v;
  private boolean w = false;

  static
  {
    if (Build.VERSION.SDK_INT >= 21);
    for (boolean bool = true; ; bool = false)
    {
      a = bool;
      return;
    }
  }

  public c(a parama)
  {
    this.b = parama;
  }

  private InsetDrawable a(Drawable paramDrawable)
  {
    return new InsetDrawable(paramDrawable, this.c, this.e, this.d, this.f);
  }

  private Drawable i()
  {
    this.p = new GradientDrawable();
    this.p.setCornerRadius(1.0E-005F + this.g);
    this.p.setColor(-1);
    this.q = DrawableCompat.wrap(this.p);
    DrawableCompat.setTintList(this.q, this.j);
    if (this.i != null)
      DrawableCompat.setTintMode(this.q, this.i);
    this.r = new GradientDrawable();
    this.r.setCornerRadius(1.0E-005F + this.g);
    this.r.setColor(-1);
    this.s = DrawableCompat.wrap(this.r);
    DrawableCompat.setTintList(this.s, this.l);
    Drawable[] arrayOfDrawable = new Drawable[2];
    arrayOfDrawable[0] = this.q;
    arrayOfDrawable[1] = this.s;
    return a(new LayerDrawable(arrayOfDrawable));
  }

  private void j()
  {
    if (this.t != null)
    {
      DrawableCompat.setTintList(this.t, this.j);
      if (this.i != null)
        DrawableCompat.setTintMode(this.t, this.i);
    }
  }

  @TargetApi(21)
  private Drawable k()
  {
    this.t = new GradientDrawable();
    this.t.setCornerRadius(1.0E-005F + this.g);
    this.t.setColor(-1);
    j();
    this.u = new GradientDrawable();
    this.u.setCornerRadius(1.0E-005F + this.g);
    this.u.setColor(0);
    this.u.setStroke(this.h, this.k);
    Drawable[] arrayOfDrawable = new Drawable[2];
    arrayOfDrawable[0] = this.t;
    arrayOfDrawable[1] = this.u;
    InsetDrawable localInsetDrawable = a(new LayerDrawable(arrayOfDrawable));
    this.v = new GradientDrawable();
    this.v.setCornerRadius(1.0E-005F + this.g);
    this.v.setColor(-1);
    return new b(android.support.design.f.a.a(this.l), localInsetDrawable, this.v);
  }

  private void l()
  {
    if ((a) && (this.u != null))
      this.b.setInternalBackground(k());
    while (a)
      return;
    this.b.invalidate();
  }

  private GradientDrawable m()
  {
    if ((a) && (this.b.getBackground() != null))
      return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(1);
    return null;
  }

  private GradientDrawable n()
  {
    if ((a) && (this.b.getBackground() != null))
      return (GradientDrawable)((LayerDrawable)((InsetDrawable)((RippleDrawable)this.b.getBackground()).getDrawable(0)).getDrawable()).getDrawable(0);
    return null;
  }

  void a()
  {
    this.w = true;
    this.b.setSupportBackgroundTintList(this.j);
    this.b.setSupportBackgroundTintMode(this.i);
  }

  void a(int paramInt)
  {
    if ((a) && (this.t != null))
      this.t.setColor(paramInt);
    while ((a) || (this.p == null))
      return;
    this.p.setColor(paramInt);
  }

  void a(int paramInt1, int paramInt2)
  {
    if (this.v != null)
      this.v.setBounds(this.c, this.e, paramInt2 - this.d, paramInt1 - this.f);
  }

  void a(ColorStateList paramColorStateList)
  {
    if (this.j != paramColorStateList)
    {
      this.j = paramColorStateList;
      if (!a)
        break label24;
      j();
    }
    label24: 
    while (this.q == null)
      return;
    DrawableCompat.setTintList(this.q, this.j);
  }

  public void a(TypedArray paramTypedArray)
  {
    this.c = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetLeft, 0);
    this.d = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetRight, 0);
    this.e = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetTop, 0);
    this.f = paramTypedArray.getDimensionPixelOffset(R.styleable.MaterialButton_android_insetBottom, 0);
    this.g = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_cornerRadius, 0);
    this.h = paramTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_strokeWidth, 0);
    this.i = k.a(paramTypedArray.getInt(R.styleable.MaterialButton_backgroundTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.j = android.support.design.e.a.a(this.b.getContext(), paramTypedArray, R.styleable.MaterialButton_backgroundTint);
    this.k = android.support.design.e.a.a(this.b.getContext(), paramTypedArray, R.styleable.MaterialButton_strokeColor);
    this.l = android.support.design.e.a.a(this.b.getContext(), paramTypedArray, R.styleable.MaterialButton_rippleColor);
    this.m.setStyle(Paint.Style.STROKE);
    this.m.setStrokeWidth(this.h);
    Paint localPaint = this.m;
    ColorStateList localColorStateList = this.k;
    int i1 = 0;
    if (localColorStateList != null)
      i1 = this.k.getColorForState(this.b.getDrawableState(), 0);
    localPaint.setColor(i1);
    int i2 = ViewCompat.getPaddingStart(this.b);
    int i3 = this.b.getPaddingTop();
    int i4 = ViewCompat.getPaddingEnd(this.b);
    int i5 = this.b.getPaddingBottom();
    a locala = this.b;
    if (a);
    for (Drawable localDrawable = k(); ; localDrawable = i())
    {
      locala.setInternalBackground(localDrawable);
      ViewCompat.setPaddingRelative(this.b, i2 + this.c, i3 + this.e, i4 + this.d, i5 + this.f);
      return;
    }
  }

  void a(Canvas paramCanvas)
  {
    if ((paramCanvas != null) && (this.k != null) && (this.h > 0))
    {
      this.n.set(this.b.getBackground().getBounds());
      this.o.set(this.n.left + this.h / 2.0F + this.c, this.n.top + this.h / 2.0F + this.e, this.n.right - this.h / 2.0F - this.d, this.n.bottom - this.h / 2.0F - this.f);
      float f1 = this.g - this.h / 2.0F;
      paramCanvas.drawRoundRect(this.o, f1, f1, this.m);
    }
  }

  void a(PorterDuff.Mode paramMode)
  {
    if (this.i != paramMode)
    {
      this.i = paramMode;
      if (!a)
        break label24;
      j();
    }
    label24: 
    while ((this.q == null) || (this.i == null))
      return;
    DrawableCompat.setTintMode(this.q, this.i);
  }

  void b(int paramInt)
  {
    if (this.h != paramInt)
    {
      this.h = paramInt;
      this.m.setStrokeWidth(paramInt);
      l();
    }
  }

  void b(ColorStateList paramColorStateList)
  {
    if (this.l != paramColorStateList)
    {
      this.l = paramColorStateList;
      if ((!a) || (!(this.b.getBackground() instanceof RippleDrawable)))
        break label47;
      ((RippleDrawable)this.b.getBackground()).setColor(paramColorStateList);
    }
    label47: 
    while ((a) || (this.s == null))
      return;
    DrawableCompat.setTintList(this.s, paramColorStateList);
  }

  boolean b()
  {
    return this.w;
  }

  ColorStateList c()
  {
    return this.j;
  }

  void c(int paramInt)
  {
    if (this.g != paramInt)
    {
      this.g = paramInt;
      if ((!a) || (this.t == null) || (this.u == null) || (this.v == null))
        break label109;
      if (Build.VERSION.SDK_INT == 21)
      {
        n().setCornerRadius(1.0E-005F + paramInt);
        m().setCornerRadius(1.0E-005F + paramInt);
      }
      this.t.setCornerRadius(1.0E-005F + paramInt);
      this.u.setCornerRadius(1.0E-005F + paramInt);
      this.v.setCornerRadius(1.0E-005F + paramInt);
    }
    label109: 
    while ((a) || (this.p == null) || (this.r == null))
      return;
    this.p.setCornerRadius(1.0E-005F + paramInt);
    this.r.setCornerRadius(1.0E-005F + paramInt);
    this.b.invalidate();
  }

  void c(ColorStateList paramColorStateList)
  {
    if (this.k != paramColorStateList)
    {
      this.k = paramColorStateList;
      Paint localPaint = this.m;
      int i1 = 0;
      if (paramColorStateList != null)
        i1 = paramColorStateList.getColorForState(this.b.getDrawableState(), 0);
      localPaint.setColor(i1);
      l();
    }
  }

  PorterDuff.Mode d()
  {
    return this.i;
  }

  ColorStateList e()
  {
    return this.l;
  }

  ColorStateList f()
  {
    return this.k;
  }

  int g()
  {
    return this.h;
  }

  int h()
  {
    return this.g;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.b.c
 * JD-Core Version:    0.6.2
 */