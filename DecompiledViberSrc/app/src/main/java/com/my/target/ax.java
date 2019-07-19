package com.my.target;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View.MeasureSpec;
import android.view.ViewPropertyAnimator;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import com.my.target.common.a.b;

@SuppressLint({"AppCompatCustomView"})
public class ax extends ImageView
{
  private Bitmap a;
  private int b;
  private int c;
  private int d;
  private int e;

  public ax(Context paramContext)
  {
    super(paramContext);
    a();
  }

  private void a()
  {
    setScaleType(ImageView.ScaleType.CENTER_INSIDE);
    setAdjustViewBounds(true);
  }

  public void a(Bitmap paramBitmap, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      setAlpha(0.0F);
      setImageBitmap(paramBitmap);
      animate().alpha(1.0F).setDuration(300L);
      return;
    }
    setImageBitmap(paramBitmap);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    int i = View.MeasureSpec.getSize(paramInt1);
    int j = View.MeasureSpec.getSize(paramInt2);
    int k = View.MeasureSpec.getMode(paramInt1);
    int m = View.MeasureSpec.getMode(paramInt2);
    int n;
    int i1;
    if ((this.b != 0) && (this.c != 0))
    {
      n = this.c;
      i1 = this.b;
    }
    while ((n <= 0) || (i1 <= 0))
    {
      super.onMeasure(paramInt1, paramInt2);
      return;
      if (this.a != null)
      {
        n = this.a.getWidth();
        i1 = this.a.getHeight();
      }
      else
      {
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i, -2147483648), View.MeasureSpec.makeMeasureSpec(j, -2147483648));
        return;
      }
    }
    float f1 = n / i1;
    if (this.e > 0)
      j = Math.min(this.e, j);
    if (this.d > 0)
      i = Math.min(this.d, i);
    if ((k == 1073741824) && (m == 1073741824))
    {
      setMeasuredDimension(i, j);
      return;
    }
    int i2;
    if ((k == 0) && (m == 0))
    {
      j = i1;
      i2 = n;
    }
    while (true)
    {
      setMeasuredDimension(i2, j);
      return;
      if (k == 0)
      {
        i2 = (int)(f1 * j);
      }
      else if (m == 0)
      {
        j = (int)(i / f1);
        i2 = i;
      }
      else
      {
        float f2 = i / n;
        if ((Math.min(f2, j / i1) == f2) && (f1 > 0.0F))
        {
          j = (int)(i / f1);
          i2 = i;
        }
        else
        {
          i2 = (int)(f1 * j);
        }
      }
    }
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    this.a = paramBitmap;
    super.setImageBitmap(paramBitmap);
  }

  public void setImageData(b paramb)
  {
    if (paramb == null)
    {
      this.b = 0;
      this.c = 0;
      setImageBitmap(null);
      return;
    }
    this.b = paramb.c();
    this.c = paramb.b();
    setImageBitmap(paramb.e());
  }

  public void setMaxHeight(int paramInt)
  {
    this.e = paramInt;
  }

  public void setMaxWidth(int paramInt)
  {
    this.d = paramInt;
  }

  public void setPlaceholderHeight(int paramInt)
  {
    this.b = paramInt;
  }

  public void setPlaceholderWidth(int paramInt)
  {
    this.c = paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ax
 * JD-Core Version:    0.6.2
 */