package com.my.target;

import android.content.Context;
import android.graphics.Bitmap;

public class ar extends ax
{
  private int a = -1;

  public ar(Context paramContext)
  {
    super(paramContext);
  }

  protected void onMeasure(int paramInt1, int paramInt2)
  {
    if (this.a >= 0)
    {
      setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
      return;
    }
    super.onMeasure(paramInt1, paramInt2);
  }

  public void setFixedHeight(int paramInt)
  {
    this.a = paramInt;
  }

  public void setImageBitmap(Bitmap paramBitmap)
  {
    int i = -1;
    if (this.a >= 0)
    {
      i = this.a - getPaddingTop() - getPaddingBottom();
      if (i >= 0);
    }
    for (int j = 0; ; j = i)
    {
      int m;
      int k;
      if (j >= 0)
      {
        if (paramBitmap == null)
          break label105;
        int n = paramBitmap.getWidth();
        int i1 = paramBitmap.getHeight();
        m = n;
        k = i1;
      }
      while (true)
      {
        float f = 0.0F;
        if (k > 0)
          f = m / k;
        setMeasuredDimension((int)(f * j) + getPaddingLeft() + getPaddingRight(), this.a);
        super.setImageBitmap(paramBitmap);
        return;
        label105: k = 0;
        m = 0;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.ar
 * JD-Core Version:    0.6.2
 */