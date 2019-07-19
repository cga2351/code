package com.viber.voip.engagement.carousel;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView.Recycler;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import com.viber.voip.util.cl;

public class CarouselLinearLayoutManager extends LinearLayoutManager
{
  private float a = 0.0F;
  private float b = 0.0F;
  private float c = 0.1F;
  private int d = 0;
  private int e = 0;
  private int f = 0;
  private int g = 0;
  private float h = 1.0F;
  private float i = 1.0F;
  private b j = (b)cl.b(b.class);
  private int k;
  private a l;

  public CarouselLinearLayoutManager(Context paramContext, float paramFloat)
  {
    super(paramContext, 0, false);
    this.a = paramFloat;
  }

  private void a()
  {
    int m = super.getWidth();
    if (m > 0)
      this.e = m;
    while (true)
    {
      if ((m > 0) && (this.d > 0))
      {
        int n = 2 * (int)Math.ceil((m - this.d) / 2 / (this.d * this.c + this.a));
        this.f = ((n + 1) * this.d - m);
        this.g = (n * this.d / 2);
      }
      return;
      m = this.e;
    }
  }

  private void b()
  {
    int m = getWidth() / 2;
    int n = 2147483647;
    int i1 = -1;
    int i2 = 0;
    if (i2 < getChildCount())
    {
      View localView = getChildAt(i2);
      int i3 = getDecoratedLeft(localView);
      int i4 = getDecoratedRight(localView);
      int i5 = (i3 + i4) / 2;
      int i6 = i4 - i3;
      int i7 = i5 - m;
      int i8 = Math.abs(i7);
      if (i8 < n)
      {
        i1 = getPosition(localView);
        n = i8;
      }
      float f1 = i8 / i6;
      float f2 = Math.min(1.0F, f1);
      float f3 = 1.0F + f2 * (this.c - 1.0F);
      float f4 = (1.0F + f2 * (this.b - 1.0F)) * this.h;
      int i9 = (int)f1;
      float f5 = -Math.signum(i7);
      float f6 = f1 * -f5 * this.a;
      float f7 = f5 * (1.0F - (1.0F + (f1 - i9) * (this.c - 1.0F))) * i6 / 2.0F;
      if (i9 > 0);
      for (float f8 = f6 + f5 * ((2.0F * i9 - 1.0F) * (1.0F - f3) * i6 / 2.0F) + f7 * 2.0F; ; f8 = f7 + f6)
      {
        float f9 = f8 - this.f / 2;
        float f10 = f3 * this.i;
        localView.setScaleX(f10);
        localView.setScaleY(f10);
        localView.setAlpha(f4);
        localView.setTranslationX(f9);
        i2++;
        break;
      }
    }
    if (i1 != this.k)
    {
      this.k = i1;
      this.j.a(this.k);
    }
  }

  public void a(float paramFloat)
  {
    if (this.c != paramFloat)
    {
      this.c = paramFloat;
      a();
      requestLayout();
    }
  }

  public void a(int paramInt1, int paramInt2)
  {
    int m = 1;
    int n = this.d;
    int i1 = 0;
    if (n != paramInt1)
    {
      this.d = paramInt1;
      i1 = m;
    }
    if (this.e != paramInt2)
      this.e = paramInt2;
    while (true)
    {
      if (m != 0)
      {
        a();
        requestLayout();
      }
      return;
      m = i1;
    }
  }

  public void a(a parama)
  {
    this.l = parama;
  }

  public void a(b paramb)
  {
    this.j = paramb;
  }

  public void b(float paramFloat)
  {
    if (this.b != paramFloat)
    {
      this.b = paramFloat;
      b();
    }
  }

  public void c(float paramFloat)
  {
    if (this.h != paramFloat)
    {
      this.h = paramFloat;
      b();
    }
  }

  public void d(float paramFloat)
  {
    if (this.i != paramFloat)
    {
      this.i = paramFloat;
      b();
    }
  }

  public int getPaddingLeft()
  {
    return super.getPaddingLeft() + this.g;
  }

  public int getPaddingRight()
  {
    return super.getPaddingRight() + this.g;
  }

  public int getWidth()
  {
    return super.getWidth() + this.f;
  }

  public void onLayoutCompleted(RecyclerView.State paramState)
  {
    super.onLayoutCompleted(paramState);
    b();
    if (this.l != null)
      this.l.b();
  }

  public int scrollHorizontallyBy(int paramInt, RecyclerView.Recycler paramRecycler, RecyclerView.State paramState)
  {
    if (getOrientation() == 0)
    {
      int m = super.scrollHorizontallyBy(paramInt, paramRecycler, paramState);
      b();
      return m;
    }
    return 0;
  }

  public static abstract interface a
  {
    public abstract void b();
  }

  public static abstract interface b
  {
    public abstract void a(int paramInt);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_3_dex2jar.jar
 * Qualified Name:     com.viber.voip.engagement.carousel.CarouselLinearLayoutManager
 * JD-Core Version:    0.6.2
 */