package com.my.target.c.b;

import android.content.Context;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.ProgressBar;
import com.my.target.av;
import com.my.target.ax;
import com.my.target.bj;

public class a extends ViewGroup
{
  private static final int a = bj.a();
  private static final int b = bj.a();
  private static final int c = bj.a();
  private final ax d;
  private final ProgressBar e;
  private final av f;
  private int g;
  private int h;

  public a(Context paramContext)
  {
    super(paramContext);
    this.d = new ax(paramContext);
    this.f = new av(paramContext);
    this.e = new ProgressBar(paramContext, null, 16842871);
    a(paramContext);
  }

  private void a(Context paramContext)
  {
    bj.a(this.d, "media_image");
    this.d.setId(a);
    bj.a(this.e, "progress_bar");
    this.e.setId(c);
    bj.a(this.f, "play_button");
    this.f.setId(b);
    setBackgroundColor(-1118482);
    this.d.setScaleType(ImageView.ScaleType.FIT_XY);
    this.d.setAdjustViewBounds(false);
    addView(this.d);
    this.e.setVisibility(8);
    this.e.getIndeterminateDrawable().setColorFilter(-16733198, PorterDuff.Mode.SRC_ATOP);
    addView(this.e);
    bj localbj = bj.a(paramContext);
    this.f.a(com.my.target.b.e.a.a(localbj.c(64)), false);
    this.f.setVisibility(8);
    addView(this.f);
  }

  public void a(int paramInt1, int paramInt2)
  {
    this.g = paramInt1;
    this.h = paramInt2;
  }

  public ImageView getImageView()
  {
    return this.d;
  }

  public View getPlayButtonView()
  {
    return this.f;
  }

  public ProgressBar getProgressBarView()
  {
    return this.e;
  }

  protected void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    for (int i = 0; i < getChildCount(); i++)
    {
      View localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        int j = localView.getMeasuredWidth();
        int k = localView.getMeasuredHeight();
        int m = (paramInt3 - paramInt1 - j) / 2;
        int n = (paramInt4 - paramInt2 - k) / 2;
        localView.layout(m, n, j + m, k + n);
      }
    }
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = 0;
    int j = View.MeasureSpec.getSize(paramInt1);
    int k = View.MeasureSpec.getSize(paramInt2);
    int m = View.MeasureSpec.getMode(paramInt1);
    int n = View.MeasureSpec.getMode(paramInt2);
    if ((this.h <= 0) || (this.g <= 0))
    {
      super.onMeasure(View.MeasureSpec.makeMeasureSpec(0, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 1073741824));
      return;
    }
    float f1 = this.g / this.h;
    if (f1 == 0.0F)
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
    }
    View localView;
    int i1;
    if ((m == 0) && (n == 0))
    {
      j = this.g;
      k = this.h;
      if (i >= getChildCount())
        break label274;
      localView = getChildAt(i);
      if (localView.getVisibility() != 8)
      {
        if (localView != this.d)
          break label283;
        i1 = 1073741824;
      }
    }
    for (int i2 = 1073741824; ; i2 = -2147483648)
    {
      localView.measure(View.MeasureSpec.makeMeasureSpec(j, i2), View.MeasureSpec.makeMeasureSpec(k, i1));
      i++;
      break;
      if (m == 0)
      {
        j = (int)(f1 * k);
        i = 0;
        break;
      }
      if (n == 0)
      {
        k = (int)(j / f1);
        i = 0;
        break;
      }
      float f2 = j / this.g;
      if (Math.min(f2, k / this.h) == f2)
      {
        k = (int)(j / f1);
        i = 0;
        break;
      }
      j = (int)Math.ceil(f1 * k);
      i = 0;
      break;
      label274: setMeasuredDimension(j, k);
      return;
      label283: i1 = -2147483648;
    }
  }

  public void setOnClickListener(View.OnClickListener paramOnClickListener)
  {
    super.setOnClickListener(paramOnClickListener);
    this.f.setOnClickListener(paramOnClickListener);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.c.b.a
 * JD-Core Version:    0.6.2
 */