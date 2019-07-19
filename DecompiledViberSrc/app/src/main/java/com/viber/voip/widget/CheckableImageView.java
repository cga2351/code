package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.MeasureSpec;
import android.widget.Checkable;
import android.widget.ImageView;
import com.viber.voip.R.styleable;
import com.viber.voip.gallery.selection.y;

public class CheckableImageView extends ImageView
  implements Checkable
{
  private boolean a;
  private boolean b;
  private Drawable c;
  private Drawable d;
  private Drawable e;
  private int f;
  private Rect g;
  private Rect h;
  private boolean i;
  private boolean j;
  private boolean k = true;

  public CheckableImageView(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public CheckableImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public CheckableImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Canvas paramCanvas)
  {
    if (this.d == null);
    while ((this.a) && (!this.k))
      return;
    Drawable localDrawable = this.d;
    this.g.set(0, 0, getWidth(), getHeight());
    localDrawable.setBounds(this.g);
    localDrawable.draw(paramCanvas);
  }

  private boolean a()
  {
    return (!isInTouchMode()) || (isPressed());
  }

  private void b()
  {
    if (this.d != null)
    {
      if (a())
        this.d.setState(getDrawableState());
    }
    else
      return;
    this.d.setState(new int[] { 0 });
  }

  private void b(Canvas paramCanvas)
  {
    if (this.c == null)
      return;
    Drawable localDrawable = this.c;
    int m = getPaddingLeft();
    int n = getPaddingTop();
    int i1 = getWidth() - getPaddingRight();
    int i2 = getHeight() - getPaddingBottom();
    this.g.set(m, n, i1, i2);
    localDrawable.setBounds(this.g);
    localDrawable.draw(paramCanvas);
  }

  private void c()
  {
    if ((this.e == null) || (this.h == null))
      return;
    Drawable localDrawable = this.e;
    int m = localDrawable.getIntrinsicWidth();
    int n = localDrawable.getIntrinsicHeight();
    if ((n < 0) && ((localDrawable instanceof y)))
      n = ((y)localDrawable).e();
    for (int i1 = ((y)localDrawable).f(); ; i1 = m)
    {
      int i2;
      int i3;
      int i5;
      if ((0x1 & this.f) != 0)
      {
        i2 = 0;
        i3 = i1 + i2;
        int i4 = 0x8 & this.f;
        i5 = 0;
        if (i4 == 0)
          break label151;
      }
      while (true)
      {
        int i6 = n + i5;
        this.h.set(i2, i5, i3, i6);
        return;
        if ((0x2 & this.f) != 0)
        {
          i2 = getWidth() - i1;
          break;
        }
        i2 = (getWidth() - i1) / 2;
        break;
        label151: if ((0x4 & this.f) != 0)
          i5 = getHeight() - n;
        else
          i5 = (getHeight() - n) / 2;
      }
    }
  }

  private void c(Canvas paramCanvas)
  {
    if (this.e == null)
      return;
    Drawable localDrawable = this.e;
    localDrawable.setBounds(this.h);
    localDrawable.draw(paramCanvas);
  }

  public void a(int paramInt1, int paramInt2)
  {
    a(ContextCompat.getDrawable(getContext(), paramInt1), paramInt2);
  }

  protected void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.CheckableImageView);
    this.c = localTypedArray.getDrawable(R.styleable.CheckableImageView_checkMark);
    this.e = localTypedArray.getDrawable(R.styleable.CheckableImageView_compoundDrawable);
    this.f = localTypedArray.getInt(R.styleable.CheckableImageView_compoundDrawableGravity, 48);
    Drawable localDrawable = localTypedArray.getDrawable(R.styleable.CheckableImageView_selectorDrawable);
    if (localDrawable != null)
      setSelector(localDrawable);
    this.a = localTypedArray.getBoolean(R.styleable.CheckableImageView_checked, false);
    this.b = localTypedArray.getBoolean(R.styleable.CheckableImageView_drawSelectorOnTop, false);
    this.i = localTypedArray.getBoolean(R.styleable.CheckableImageView_squared, false);
    this.j = localTypedArray.getBoolean(R.styleable.CheckableImageView_squaredUsingWidthSide, false);
    localTypedArray.recycle();
    this.g = new Rect();
    this.h = new Rect();
  }

  public void a(Drawable paramDrawable, int paramInt)
  {
    a(paramDrawable, paramInt, false);
  }

  public void a(Drawable paramDrawable, int paramInt, boolean paramBoolean)
  {
    if ((this.e != paramDrawable) || (this.f != paramInt) || (paramBoolean))
    {
      this.e = paramDrawable;
      this.f = paramInt;
      c();
      invalidate();
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    b();
  }

  public Drawable getCompoundDrawable()
  {
    return this.e;
  }

  public Drawable getSelector()
  {
    return this.d;
  }

  public boolean isChecked()
  {
    return this.a;
  }

  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.d != null)
      this.d.jumpToCurrentState();
  }

  protected void onDraw(Canvas paramCanvas)
  {
    boolean bool = this.b;
    if (!bool)
      a(paramCanvas);
    super.onDraw(paramCanvas);
    c(paramCanvas);
    if (this.a)
      b(paramCanvas);
    if (bool)
      a(paramCanvas);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.j)
      paramInt2 = paramInt1;
    while (true)
    {
      super.onMeasure(paramInt2, paramInt1);
      return;
      if (this.i)
      {
        if (View.MeasureSpec.getSize(paramInt1) > View.MeasureSpec.getSize(paramInt2))
          paramInt1 = paramInt2;
        else
          paramInt2 = paramInt1;
      }
      else
      {
        int m = paramInt2;
        paramInt2 = paramInt1;
        paramInt1 = m;
      }
    }
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    c();
  }

  public void setChecked(boolean paramBoolean)
  {
    this.a = paramBoolean;
    invalidate();
  }

  public void setDrawSelectorAndCheckCombination(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public void setPressed(boolean paramBoolean)
  {
    if ((paramBoolean) && ((getParent() instanceof View)) && (((View)getParent()).isPressed()))
      return;
    super.setPressed(paramBoolean);
  }

  public void setSelector(int paramInt)
  {
    setSelector(ContextCompat.getDrawable(getContext(), paramInt));
  }

  public void setSelector(Drawable paramDrawable)
  {
    if (this.d != null)
    {
      this.d.setCallback(null);
      unscheduleDrawable(this.d);
    }
    this.d = paramDrawable;
    if (paramDrawable != null)
      paramDrawable.setCallback(this);
    b();
  }

  public void toggle()
  {
    if (!this.a);
    for (boolean bool = true; ; bool = false)
    {
      setChecked(bool);
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (this.d == paramDrawable) || (super.verifyDrawable(paramDrawable));
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.CheckableImageView
 * JD-Core Version:    0.6.2
 */