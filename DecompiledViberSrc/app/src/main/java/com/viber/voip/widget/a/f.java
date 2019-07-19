package com.viber.voip.widget.a;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.ItemDecoration;
import android.support.v7.widget.RecyclerView.LayoutManager;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;

public class f extends RecyclerView.ItemDecoration
{
  private final int a;
  private final Drawable b;
  private final Drawable c;
  private final boolean d;
  private final int e;
  private final int f;

  public f(int paramInt, Drawable paramDrawable1, Drawable paramDrawable2, boolean paramBoolean)
  {
    this.a = paramInt;
    this.b = paramDrawable1;
    if (this.b != null);
    for (int i = this.b.getIntrinsicHeight(); ; i = 0)
    {
      this.e = i;
      this.c = paramDrawable2;
      Drawable localDrawable = this.c;
      int j = 0;
      if (localDrawable != null)
        j = this.c.getIntrinsicWidth();
      this.f = j;
      this.d = paramBoolean;
      return;
    }
  }

  private boolean a(int paramInt)
  {
    return paramInt % this.a != -1 + this.a;
  }

  private boolean a(int paramInt1, int paramInt2)
  {
    boolean bool1 = false;
    if (paramInt2 > 0)
    {
      int i = (paramInt2 - 1) / this.a;
      if (paramInt1 / this.a >= i)
      {
        boolean bool2 = this.d;
        bool1 = false;
        if (!bool2);
      }
      else
      {
        bool1 = true;
      }
    }
    return bool1;
  }

  public void getItemOffsets(Rect paramRect, View paramView, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    int i = paramRecyclerView.getChildLayoutPosition(paramView);
    if (a(i));
    for (int j = this.f; ; j = 0)
    {
      paramRect.right = j;
      boolean bool = a(i, paramRecyclerView.getLayoutManager().getItemCount());
      int k = 0;
      if (bool)
        k = this.e;
      paramRect.bottom = k;
      return;
    }
  }

  public void onDrawOver(Canvas paramCanvas, RecyclerView paramRecyclerView, RecyclerView.State paramState)
  {
    RecyclerView.LayoutManager localLayoutManager = paramRecyclerView.getLayoutManager();
    int i;
    int j;
    View localView1;
    RecyclerView.LayoutParams localLayoutParams1;
    int n;
    int i1;
    int i2;
    int i12;
    label120: int i13;
    int i14;
    int i15;
    int i16;
    if (localLayoutManager != null)
    {
      i = localLayoutManager.getChildCount();
      if (i <= 0)
        break label459;
      j = localLayoutManager.getItemCount();
      int k = paramRecyclerView.getChildViewHolder(localLayoutManager.getChildAt(0)).getLayoutPosition() / this.a;
      localView1 = localLayoutManager.getChildAt(i - 1);
      localLayoutParams1 = (RecyclerView.LayoutParams)localView1.getLayoutParams();
      int m = paramRecyclerView.getChildViewHolder(localView1).getLayoutPosition();
      n = m / this.a;
      i1 = m % this.a;
      i2 = 0;
      if (this.e <= 0)
        break label283;
      int i11 = n - k;
      i12 = 0;
      if (i12 > i11)
        break label283;
      View localView3 = localLayoutManager.getChildAt(i12 * this.a);
      RecyclerView.LayoutParams localLayoutParams3 = (RecyclerView.LayoutParams)localView3.getLayoutParams();
      i13 = localView3.getBottom() + localLayoutParams3.bottomMargin;
      i14 = i13 + this.e;
      i15 = localLayoutManager.getPaddingLeft();
      if (i12 >= n)
        break label260;
      i16 = localLayoutManager.getWidth() - localLayoutManager.getPaddingRight();
    }
    while (true)
    {
      if ((this.b != null) && ((i12 < n) || (this.d)))
      {
        this.b.setBounds(i15, i13, i16, i14);
        this.b.draw(paramCanvas);
      }
      i12++;
      i2 = i16;
      break label120;
      i = 0;
      break;
      label260: if (this.d)
      {
        i16 = localView1.getRight() + localLayoutParams1.rightMargin;
        continue;
        label283: if (this.f > 0)
        {
          int i3 = Math.min(-1 + this.a, j);
          int i4 = 0;
          if (i4 < i3)
          {
            View localView2 = localLayoutManager.getChildAt(i4);
            RecyclerView.LayoutParams localLayoutParams2 = (RecyclerView.LayoutParams)localView2.getLayoutParams();
            int i5 = localLayoutManager.getPaddingTop();
            int i6 = localView2.getRight() + localLayoutParams2.rightMargin;
            int i7 = i6 + this.f;
            int i9;
            int i10;
            if (i4 <= i1)
            {
              i9 = localView1.getBottom() + localLayoutParams1.bottomMargin;
              if (this.d)
                i10 = this.e;
            }
            for (int i8 = i10 + i9; ; i8 = localView1.getTop() - localLayoutParams1.topMargin)
            {
              if (this.c != null)
              {
                this.c.setBounds(i6, i5, i7, i8);
                this.c.draw(paramCanvas);
              }
              i4++;
              break;
              i10 = 0;
              break label394;
            }
          }
        }
      }
      else
      {
        label394: label459: i16 = i2;
      }
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.widget.a.f
 * JD-Core Version:    0.6.2
 */