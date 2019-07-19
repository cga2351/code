package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.viber.common.d.a;
import com.viber.voip.R.color;
import com.viber.voip.R.styleable;
import com.viber.voip.ui.d.c;
import com.viber.voip.util.br;
import com.viber.voip.util.dj;
import com.viber.voip.util.dj.a;

public class ProgressBar extends android.widget.ProgressBar
{
  private c a;
  private int b;
  private int c;
  private boolean d;
  private dj.a e = new dj.a()
  {
    public boolean onGlobalLayout()
    {
      if (ProgressBar.this.getWidth() != 0)
      {
        ProgressBar.a(ProgressBar.this, ProgressBar.this.getWidth());
        ProgressBar.a(ProgressBar.this);
        return true;
      }
      return false;
    }
  };

  public ProgressBar(Context paramContext)
  {
    super(paramContext);
    a(paramContext, null);
  }

  public ProgressBar(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a(paramContext, paramAttributeSet);
  }

  public ProgressBar(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a(paramContext, paramAttributeSet);
  }

  private void a(Context paramContext, AttributeSet paramAttributeSet)
  {
    TypedArray localTypedArray = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.ProgressBar);
    try
    {
      this.b = localTypedArray.getColor(R.styleable.ProgressBar_progressColor, getContext().getResources().getColor(R.color.link_text));
      this.c = localTypedArray.getLayoutDimension(R.styleable.ProgressBar_android_layout_width, 0);
      this.d = localTypedArray.getBoolean(R.styleable.ProgressBar_considerForceCompatibilityMode, false);
      localTypedArray.recycle();
      if ((!isInEditMode()) && (a()))
      {
        this.a = new c(getContext(), this);
        c localc = this.a;
        int[] arrayOfInt = new int[1];
        arrayOfInt[0] = this.b;
        localc.a(arrayOfInt);
        this.a.setAlpha(255);
        setIndeterminateDrawable(this.a);
        b();
        return;
      }
    }
    finally
    {
      localTypedArray.recycle();
    }
    getIndeterminateDrawable().setColorFilter(this.b, PorterDuff.Mode.SRC_IN);
  }

  private boolean a()
  {
    return (!a.g()) || ((this.d) && (br.f.a()));
  }

  private void b()
  {
    if (this.c <= 0)
      dj.a(this, this.e);
    while (this.a == null)
      return;
    this.a.a(2, this.c);
  }

  public void setProgressColor(int paramInt)
  {
    this.b = paramInt;
    if ((a()) && (this.a != null))
    {
      c localc = this.a;
      int[] arrayOfInt = new int[1];
      arrayOfInt[0] = this.b;
      localc.a(arrayOfInt);
      return;
    }
    getIndeterminateDrawable().setColorFilter(this.b, PorterDuff.Mode.SRC_IN);
  }

  public void setVisibility(int paramInt)
  {
    if (this.a != null)
    {
      if (paramInt != 0)
        break label31;
      if (getVisibility() != 0)
        this.a.start();
    }
    while (true)
    {
      super.setVisibility(paramInt);
      return;
      label31: this.a.stop();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.ProgressBar
 * JD-Core Version:    0.6.2
 */