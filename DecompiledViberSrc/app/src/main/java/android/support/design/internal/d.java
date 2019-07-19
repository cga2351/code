package android.support.design.internal;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.design.R.styleable;
import android.support.v7.widget.LinearLayoutCompat;
import android.util.AttributeSet;
import android.view.Gravity;

public class d extends LinearLayoutCompat
{
  protected boolean a = true;
  boolean b = false;
  private Drawable c;
  private final Rect d = new Rect();
  private final Rect e = new Rect();
  private int f = 119;

  public d(Context paramContext)
  {
    this(paramContext, null);
  }

  public d(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public d(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    TypedArray localTypedArray = j.a(paramContext, paramAttributeSet, R.styleable.ForegroundLinearLayout, paramInt, 0, new int[0]);
    this.f = localTypedArray.getInt(R.styleable.ForegroundLinearLayout_android_foregroundGravity, this.f);
    Drawable localDrawable = localTypedArray.getDrawable(R.styleable.ForegroundLinearLayout_android_foreground);
    if (localDrawable != null)
      setForeground(localDrawable);
    this.a = localTypedArray.getBoolean(R.styleable.ForegroundLinearLayout_foregroundInsidePadding, true);
    localTypedArray.recycle();
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    Drawable localDrawable;
    Rect localRect1;
    Rect localRect2;
    int i;
    int j;
    if (this.c != null)
    {
      localDrawable = this.c;
      if (this.b)
      {
        this.b = false;
        localRect1 = this.d;
        localRect2 = this.e;
        i = getRight() - getLeft();
        j = getBottom() - getTop();
        if (!this.a)
          break label109;
        localRect1.set(0, 0, i, j);
      }
    }
    while (true)
    {
      Gravity.apply(this.f, localDrawable.getIntrinsicWidth(), localDrawable.getIntrinsicHeight(), localRect1, localRect2);
      localDrawable.setBounds(localRect2);
      localDrawable.draw(paramCanvas);
      return;
      label109: localRect1.set(getPaddingLeft(), getPaddingTop(), i - getPaddingRight(), j - getPaddingBottom());
    }
  }

  @TargetApi(21)
  public void drawableHotspotChanged(float paramFloat1, float paramFloat2)
  {
    super.drawableHotspotChanged(paramFloat1, paramFloat2);
    if (this.c != null)
      this.c.setHotspot(paramFloat1, paramFloat2);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.c != null) && (this.c.isStateful()))
      this.c.setState(getDrawableState());
  }

  public Drawable getForeground()
  {
    return this.c;
  }

  public int getForegroundGravity()
  {
    return this.f;
  }

  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.c != null)
      this.c.jumpToCurrentState();
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = (paramBoolean | this.b);
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    this.b = true;
  }

  public void setForeground(Drawable paramDrawable)
  {
    if (this.c != paramDrawable)
    {
      if (this.c != null)
      {
        this.c.setCallback(null);
        unscheduleDrawable(this.c);
      }
      this.c = paramDrawable;
      if (paramDrawable == null)
        break label96;
      setWillNotDraw(false);
      paramDrawable.setCallback(this);
      if (paramDrawable.isStateful())
        paramDrawable.setState(getDrawableState());
      if (this.f == 119)
        paramDrawable.getPadding(new Rect());
    }
    while (true)
    {
      requestLayout();
      invalidate();
      return;
      label96: setWillNotDraw(true);
    }
  }

  public void setForegroundGravity(int paramInt)
  {
    if (this.f != paramInt)
      if ((0x800007 & paramInt) != 0)
        break label75;
    label75: for (int i = 0x800003 | paramInt; ; i = paramInt)
    {
      if ((i & 0x70) == 0)
        i |= 48;
      this.f = i;
      if ((this.f == 119) && (this.c != null))
      {
        Rect localRect = new Rect();
        this.c.getPadding(localRect);
      }
      requestLayout();
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.c);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     android.support.design.internal.d
 * JD-Core Version:    0.6.2
 */