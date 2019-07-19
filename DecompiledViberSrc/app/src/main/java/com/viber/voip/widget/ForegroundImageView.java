package com.viber.voip.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import com.viber.voip.R.styleable;

public final class ForegroundImageView extends AppCompatImageView
{
  private Drawable a;
  private int b;

  public ForegroundImageView(Context paramContext)
  {
    this(paramContext, null);
  }

  public ForegroundImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }

  public ForegroundImageView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ForegroundImageView);
    Drawable localDrawable = localTypedArray.getDrawable(R.styleable.ForegroundImageView_android_foreground);
    if (localDrawable != null)
      setForeground(localDrawable);
    localTypedArray.recycle();
  }

  private void setForegroundDrawable(Drawable paramDrawable)
  {
    if (this.a == paramDrawable)
      return;
    if (this.a != null)
    {
      this.a.setCallback(null);
      unscheduleDrawable(this.a);
    }
    this.a = paramDrawable;
    if (this.a != null)
    {
      this.a.setBounds(0, 0, getWidth(), getHeight());
      this.a.setCallback(this);
      if (this.a.isStateful())
        this.a.setState(getDrawableState());
    }
    invalidate();
  }

  public void draw(Canvas paramCanvas)
  {
    super.draw(paramCanvas);
    if (this.a != null)
      this.a.draw(paramCanvas);
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if ((this.a != null) && (this.a.isStateful()) && (this.a.setState(getDrawableState())))
      invalidate();
  }

  public Drawable getForeground()
  {
    return this.a;
  }

  public void jumpDrawablesToCurrentState()
  {
    super.jumpDrawablesToCurrentState();
    if (this.a != null)
      this.a.jumpToCurrentState();
  }

  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
    if (this.a != null)
    {
      this.a.setBounds(0, 0, paramInt1, paramInt2);
      invalidate();
    }
  }

  public void setForeground(int paramInt)
  {
    if (this.b == paramInt)
      return;
    this.b = paramInt;
    setForegroundDrawable(ContextCompat.getDrawable(getContext(), paramInt));
  }

  public void setForeground(Drawable paramDrawable)
  {
    if (this.a != paramDrawable);
    for (int i = 0; ; i = this.b)
    {
      this.b = i;
      setForegroundDrawable(paramDrawable);
      return;
    }
  }

  protected boolean verifyDrawable(Drawable paramDrawable)
  {
    return (super.verifyDrawable(paramDrawable)) || (paramDrawable == this.a);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ForegroundImageView
 * JD-Core Version:    0.6.2
 */