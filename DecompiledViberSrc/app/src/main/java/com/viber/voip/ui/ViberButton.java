package com.viber.voip.ui;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ShapeDrawable;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;
import com.viber.common.ui.a.b;
import com.viber.voip.R.style;
import com.viber.voip.R.styleable;

public class ViberButton extends AppCompatButton
{
  private ColorStateList a;
  private ColorStateList b;
  private int c;
  private int d;
  private ShapeDrawable e;
  private b f;

  public ViberButton(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null, 0);
  }

  public ViberButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet, 0);
  }

  public ViberButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet, paramInt);
  }

  private void a()
  {
    if (this.d == 0)
      return;
    if (this.e == null)
    {
      this.e = new ShapeDrawable(this.f);
      setBackground(new ShapeDrawable(this.f));
      return;
    }
    invalidate();
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ViberButton, paramInt, R.style.Widget_Viber_Button);
    while (true)
    {
      try
      {
        this.d = localTypedArray.getInt(R.styleable.ViberButton_backgroundStyle, 0);
        this.a = localTypedArray.getColorStateList(R.styleable.ViberButton_backgroundColor);
        this.b = localTypedArray.getColorStateList(R.styleable.ViberButton_backgroundStrokeColor);
        this.c = localTypedArray.getDimensionPixelSize(R.styleable.ViberButton_backgroundStrokeWidth, 0);
        localTypedArray.recycle();
        this.f = new b();
        this.f.d(this.c);
        b localb1 = this.f;
        if (this.a != null)
        {
          i = this.a.getDefaultColor();
          localb1.b(i);
          b localb2 = this.f;
          ColorStateList localColorStateList = this.b;
          int j = 0;
          if (localColorStateList != null)
            j = this.b.getDefaultColor();
          localb2.c(j);
          if ((this.d != 0) && (getBackground() == null))
          {
            this.f.a(this.d);
            this.e = new ShapeDrawable(this.f);
            setBackground(this.e);
          }
          return;
        }
      }
      finally
      {
        localTypedArray.recycle();
      }
      int i = 0;
    }
  }

  protected void drawableStateChanged()
  {
    super.drawableStateChanged();
    if (this.d == 0);
    do
    {
      return;
      int[] arrayOfInt = getDrawableState();
      if ((this.a != null) && (this.a.isStateful()))
      {
        int j = this.a.getColorForState(arrayOfInt, this.a.getDefaultColor());
        this.f.b(j);
      }
      if ((this.b != null) && (this.b.isStateful()))
      {
        int i = this.b.getColorForState(arrayOfInt, this.b.getDefaultColor());
        this.f.c(i);
      }
    }
    while ((this.a == null) && (this.b == null));
    invalidate();
  }

  public void setBackgroundColor(int paramInt)
  {
    if (this.d == 0)
    {
      super.setBackgroundColor(paramInt);
      return;
    }
    setBackgroundColor(ColorStateList.valueOf(paramInt));
  }

  public void setBackgroundColor(ColorStateList paramColorStateList)
  {
    if (this.a == paramColorStateList)
      return;
    this.a = paramColorStateList;
    this.f.b(paramColorStateList.getDefaultColor());
    a();
  }

  public void setBackgroundStrokeColor(int paramInt)
  {
    setBackgroundStrokeColor(ColorStateList.valueOf(paramInt));
  }

  public void setBackgroundStrokeColor(ColorStateList paramColorStateList)
  {
    if (this.b == paramColorStateList)
      return;
    this.b = paramColorStateList;
    this.f.c(paramColorStateList.getDefaultColor());
    a();
  }

  public void setBackgroundStyle(int paramInt)
  {
    if (this.d == paramInt)
      return;
    this.d = paramInt;
    if (paramInt == 0)
    {
      this.e = null;
      setBackground(null);
      return;
    }
    a();
  }

  public void setStrokeWidth(int paramInt)
  {
    if (this.c == paramInt)
      return;
    this.c = paramInt;
    this.f.d(paramInt);
    a();
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.ViberButton
 * JD-Core Version:    0.6.2
 */