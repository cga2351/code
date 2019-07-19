package com.google.android.exoplayer2.ui;

import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;
import android.widget.FrameLayout;

public final class AspectRatioFrameLayout extends FrameLayout
{
  private final b a;
  private a b;
  private float c;
  private int d = 0;

  public AspectRatioFrameLayout(Context paramContext)
  {
    this(paramContext, null);
  }

  public AspectRatioFrameLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    TypedArray localTypedArray;
    if (paramAttributeSet != null)
      localTypedArray = paramContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.AspectRatioFrameLayout, 0, 0);
    try
    {
      this.d = localTypedArray.getInt(R.styleable.AspectRatioFrameLayout_resize_mode, 0);
      localTypedArray.recycle();
      this.a = new b(null);
      return;
    }
    finally
    {
      localTypedArray.recycle();
    }
  }

  public int getResizeMode()
  {
    return this.d;
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    if (this.c <= 0.0F)
      return;
    int i = getMeasuredWidth();
    int j = getMeasuredHeight();
    float f1 = i / j;
    float f2 = this.c / f1 - 1.0F;
    if (Math.abs(f2) <= 0.01F)
    {
      this.a.a(this.c, f1, false);
      return;
    }
    switch (this.d)
    {
    case 3:
    default:
    case 1:
    case 2:
    case 4:
    case 0:
    }
    while (true)
    {
      this.a.a(this.c, f1, true);
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, 1073741824), View.MeasureSpec.makeMeasureSpec(j, 1073741824));
      return;
      j = (int)(i / this.c);
      continue;
      i = (int)(j * this.c);
      continue;
      if (f2 > 0.0F)
      {
        i = (int)(j * this.c);
      }
      else
      {
        j = (int)(i / this.c);
        continue;
        if (f2 > 0.0F)
          j = (int)(i / this.c);
        else
          i = (int)(j * this.c);
      }
    }
  }

  public void setAspectRatio(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      requestLayout();
    }
  }

  public void setAspectRatioListener(a parama)
  {
    this.b = parama;
  }

  public void setResizeMode(int paramInt)
  {
    if (this.d != paramInt)
    {
      this.d = paramInt;
      requestLayout();
    }
  }

  public static abstract interface a
  {
    public abstract void a(float paramFloat1, float paramFloat2, boolean paramBoolean);
  }

  private final class b
    implements Runnable
  {
    private float b;
    private float c;
    private boolean d;
    private boolean e;

    private b()
    {
    }

    public void a(float paramFloat1, float paramFloat2, boolean paramBoolean)
    {
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramBoolean;
      if (!this.e)
      {
        this.e = true;
        AspectRatioFrameLayout.this.post(this);
      }
    }

    public void run()
    {
      this.e = false;
      if (AspectRatioFrameLayout.a(AspectRatioFrameLayout.this) == null)
        return;
      AspectRatioFrameLayout.a(AspectRatioFrameLayout.this).a(this.b, this.c, this.d);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_dex2jar.jar
 * Qualified Name:     com.google.android.exoplayer2.ui.AspectRatioFrameLayout
 * JD-Core Version:    0.6.2
 */