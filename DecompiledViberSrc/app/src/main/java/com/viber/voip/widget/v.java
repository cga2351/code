package com.viber.voip.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View.MeasureSpec;

public class v
{
  private float a;
  private int b;
  private boolean c;
  private Context d;
  private int[] e;
  private int f;
  private int g;

  public v(Context paramContext, int[] paramArrayOfInt, int paramInt1, int paramInt2)
  {
    this.d = paramContext;
    this.e = paramArrayOfInt;
    this.f = paramInt1;
    this.g = paramInt2;
  }

  private void a(TypedArray paramTypedArray)
  {
    this.a = paramTypedArray.getFloat(this.g, 1.0F);
    if ((this.a <= 0.0F) || (this.a > 1.0F))
      this.a = 1.0F;
  }

  private void c()
  {
    TypedArray localTypedArray = this.d.obtainStyledAttributes(null, this.e, this.f, 0);
    a(localTypedArray);
    localTypedArray.recycle();
  }

  public int a(int paramInt)
  {
    if (this.a != 1.0F)
    {
      int i = View.MeasureSpec.getSize(paramInt);
      int j = View.MeasureSpec.getMode(paramInt);
      if (j != 0)
        paramInt = View.MeasureSpec.makeMeasureSpec((int)(i * this.a), j);
    }
    return paramInt;
  }

  public void a()
  {
    if (this.d.getResources().getConfiguration().orientation != this.b)
    {
      this.b = this.d.getResources().getConfiguration().orientation;
      c();
    }
  }

  public void a(Configuration paramConfiguration)
  {
    this.b = paramConfiguration.orientation;
    if (!this.c)
      c();
  }

  public void a(AttributeSet paramAttributeSet)
  {
    this.b = this.d.getResources().getConfiguration().orientation;
    TypedArray localTypedArray = this.d.obtainStyledAttributes(paramAttributeSet, this.e);
    a(localTypedArray);
    localTypedArray.recycle();
    if (this.a == 1.0F)
      this.c = true;
  }

  public float b()
  {
    return this.a;
  }

  public int b(int paramInt)
  {
    return paramInt;
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.v
 * JD-Core Version:    0.6.2
 */