package android.support.design.b;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.design.R.attr;
import android.support.design.R.style;
import android.support.design.R.styleable;
import android.support.design.internal.j;
import android.support.design.internal.k;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import android.util.Log;

public class a extends AppCompatButton
{
  private final c a;
  private int b;
  private PorterDuff.Mode c;
  private ColorStateList d;
  private Drawable e;
  private int f;
  private int g;
  private int h;

  public a(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, R.attr.materialButtonStyle);
  }

  public a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = j.a(paramContext, paramAttributeSet, R.styleable.MaterialButton, paramInt, R.style.Widget_MaterialComponents_Button, new int[0]);
    this.b = localTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_iconPadding, 0);
    this.c = k.a(localTypedArray.getInt(R.styleable.MaterialButton_iconTintMode, -1), PorterDuff.Mode.SRC_IN);
    this.d = android.support.design.e.a.a(getContext(), localTypedArray, R.styleable.MaterialButton_iconTint);
    this.e = android.support.design.e.a.b(getContext(), localTypedArray, R.styleable.MaterialButton_icon);
    this.h = localTypedArray.getInteger(R.styleable.MaterialButton_iconGravity, 1);
    this.f = localTypedArray.getDimensionPixelSize(R.styleable.MaterialButton_iconSize, 0);
    this.a = new c(this);
    this.a.a(localTypedArray);
    localTypedArray.recycle();
    setCompoundDrawablePadding(this.b);
    b();
  }

  private boolean a()
  {
    return ViewCompat.getLayoutDirection(this) == 1;
  }

  private void b()
  {
    int i;
    if (this.e != null)
    {
      this.e = this.e.mutate();
      DrawableCompat.setTintList(this.e, this.d);
      if (this.c != null)
        DrawableCompat.setTintMode(this.e, this.c);
      if (this.f == 0)
        break label102;
      i = this.f;
      if (this.f == 0)
        break label113;
    }
    label102: label113: for (int j = this.f; ; j = this.e.getIntrinsicHeight())
    {
      this.e.setBounds(this.g, 0, i + this.g, j);
      TextViewCompat.setCompoundDrawablesRelative(this, this.e, null, null, null);
      return;
      i = this.e.getIntrinsicWidth();
      break;
    }
  }

  private boolean c()
  {
    return (this.a != null) && (!this.a.b());
  }

  public ColorStateList getBackgroundTintList()
  {
    return getSupportBackgroundTintList();
  }

  public PorterDuff.Mode getBackgroundTintMode()
  {
    return getSupportBackgroundTintMode();
  }

  public int getCornerRadius()
  {
    if (c())
      return this.a.h();
    return 0;
  }

  public Drawable getIcon()
  {
    return this.e;
  }

  public int getIconGravity()
  {
    return this.h;
  }

  public int getIconPadding()
  {
    return this.b;
  }

  public int getIconSize()
  {
    return this.f;
  }

  public ColorStateList getIconTint()
  {
    return this.d;
  }

  public PorterDuff.Mode getIconTintMode()
  {
    return this.c;
  }

  public ColorStateList getRippleColor()
  {
    if (c())
      return this.a.e();
    return null;
  }

  public ColorStateList getStrokeColor()
  {
    if (c())
      return this.a.f();
    return null;
  }

  public int getStrokeWidth()
  {
    if (c())
      return this.a.g();
    return 0;
  }

  public ColorStateList getSupportBackgroundTintList()
  {
    if (c())
      return this.a.c();
    return super.getSupportBackgroundTintList();
  }

  public PorterDuff.Mode getSupportBackgroundTintMode()
  {
    if (c())
      return this.a.d();
    return super.getSupportBackgroundTintMode();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((Build.VERSION.SDK_INT < 21) && (c()))
      this.a.a(paramCanvas);
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    if ((Build.VERSION.SDK_INT == 21) && (this.a != null))
      this.a.a(paramInt4 - paramInt2, paramInt3 - paramInt1);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if ((this.e == null) || (this.h != 2))
      return;
    int i = (int)getPaint().measureText(getText().toString());
    if (this.f == 0);
    for (int j = this.e.getIntrinsicWidth(); ; j = this.f)
    {
      int k = (getMeasuredWidth() - i - ViewCompat.getPaddingEnd(this) - j - this.b - ViewCompat.getPaddingStart(this)) / 2;
      if (a())
        k = -k;
      if (this.g == k)
        break;
      this.g = k;
      b();
      return;
    }
  }

  public void setBackground(Drawable paramDrawable)
  {
    setBackgroundDrawable(paramDrawable);
  }

  public void setBackgroundColor(int paramInt)
  {
    if (c())
    {
      this.a.a(paramInt);
      return;
    }
    super.setBackgroundColor(paramInt);
  }

  public void setBackgroundDrawable(Drawable paramDrawable)
  {
    if (c())
    {
      if (paramDrawable != getBackground())
      {
        Log.i("MaterialButton", "Setting a custom background is not supported.");
        this.a.a();
        super.setBackgroundDrawable(paramDrawable);
        return;
      }
      getBackground().setState(paramDrawable.getState());
      return;
    }
    super.setBackgroundDrawable(paramDrawable);
  }

  public void setBackgroundResource(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0)
      localDrawable = android.support.v7.a.a.a.b(getContext(), paramInt);
    setBackgroundDrawable(localDrawable);
  }

  public void setBackgroundTintList(ColorStateList paramColorStateList)
  {
    setSupportBackgroundTintList(paramColorStateList);
  }

  public void setBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    setSupportBackgroundTintMode(paramMode);
  }

  public void setCornerRadius(int paramInt)
  {
    if (c())
      this.a.c(paramInt);
  }

  public void setCornerRadiusResource(int paramInt)
  {
    if (c())
      setCornerRadius(getResources().getDimensionPixelSize(paramInt));
  }

  public void setIcon(Drawable paramDrawable)
  {
    if (this.e != paramDrawable)
    {
      this.e = paramDrawable;
      b();
    }
  }

  public void setIconGravity(int paramInt)
  {
    this.h = paramInt;
  }

  public void setIconPadding(int paramInt)
  {
    if (this.b != paramInt)
    {
      this.b = paramInt;
      setCompoundDrawablePadding(paramInt);
    }
  }

  public void setIconResource(int paramInt)
  {
    Drawable localDrawable = null;
    if (paramInt != 0)
      localDrawable = android.support.v7.a.a.a.b(getContext(), paramInt);
    setIcon(localDrawable);
  }

  public void setIconSize(int paramInt)
  {
    if (paramInt < 0)
      throw new IllegalArgumentException("iconSize cannot be less than 0");
    if (this.f != paramInt)
    {
      this.f = paramInt;
      b();
    }
  }

  public void setIconTint(ColorStateList paramColorStateList)
  {
    if (this.d != paramColorStateList)
    {
      this.d = paramColorStateList;
      b();
    }
  }

  public void setIconTintMode(PorterDuff.Mode paramMode)
  {
    if (this.c != paramMode)
    {
      this.c = paramMode;
      b();
    }
  }

  public void setIconTintResource(int paramInt)
  {
    setIconTint(android.support.v7.a.a.a.a(getContext(), paramInt));
  }

  void setInternalBackground(Drawable paramDrawable)
  {
    super.setBackgroundDrawable(paramDrawable);
  }

  public void setRippleColor(ColorStateList paramColorStateList)
  {
    if (c())
      this.a.b(paramColorStateList);
  }

  public void setRippleColorResource(int paramInt)
  {
    if (c())
      setRippleColor(android.support.v7.a.a.a.a(getContext(), paramInt));
  }

  public void setStrokeColor(ColorStateList paramColorStateList)
  {
    if (c())
      this.a.c(paramColorStateList);
  }

  public void setStrokeColorResource(int paramInt)
  {
    if (c())
      setStrokeColor(android.support.v7.a.a.a.a(getContext(), paramInt));
  }

  public void setStrokeWidth(int paramInt)
  {
    if (c())
      this.a.b(paramInt);
  }

  public void setStrokeWidthResource(int paramInt)
  {
    if (c())
      setStrokeWidth(getResources().getDimensionPixelSize(paramInt));
  }

  public void setSupportBackgroundTintList(ColorStateList paramColorStateList)
  {
    if (c())
      this.a.a(paramColorStateList);
    while (this.a == null)
      return;
    super.setSupportBackgroundTintList(paramColorStateList);
  }

  public void setSupportBackgroundTintMode(PorterDuff.Mode paramMode)
  {
    if (c())
      this.a.a(paramMode);
    while (this.a == null)
      return;
    super.setSupportBackgroundTintMode(paramMode);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.b.a
 * JD-Core Version:    0.6.2
 */