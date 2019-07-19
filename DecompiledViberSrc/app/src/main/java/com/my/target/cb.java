package com.my.target;

import android.content.Context;
import android.os.Parcelable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.LayoutParams;
import android.support.v7.widget.RecyclerView.State;
import android.view.View;
import android.view.View.OnClickListener;
import com.my.target.b.c.a.b;
import java.util.List;

public final class cb extends RecyclerView
  implements cc
{
  private final b a;
  private final View.OnClickListener b = new a((byte)0);
  private final ca c;
  private List<b> d;
  private boolean e;
  private cc.a f;

  public cb(Context paramContext)
  {
    this(paramContext, (byte)0);
  }

  private cb(Context paramContext, byte paramByte)
  {
    this(paramContext, '\000');
  }

  private cb(Context paramContext, char paramChar)
  {
    super(paramContext, null, 0);
    this.a = new b(paramContext);
    this.a.a(bj.a(4, paramContext));
    this.c = new ca(getContext());
    setHasFixedSize(true);
  }

  private void b()
  {
    if (this.f != null)
      this.f.a(this, getVisibleCardNumbers());
  }

  private void setCardLayoutManager(b paramb)
  {
    paramb.a(new cw.a()
    {
      public final void a()
      {
        cb.a(cb.this);
      }
    });
    super.setLayoutManager(paramb);
  }

  public final void a()
  {
    this.c.a();
  }

  public final void a(Parcelable paramParcelable)
  {
    this.a.onRestoreInstanceState(paramParcelable);
  }

  public final Parcelable getState()
  {
    return this.a.onSaveInstanceState();
  }

  public final int[] getVisibleCardNumbers()
  {
    int i = 0;
    int j = this.a.findFirstCompletelyVisibleItemPosition();
    int k = this.a.findLastCompletelyVisibleItemPosition();
    if ((this.d == null) || (j > k) || (j < 0) || (k >= this.d.size()))
      return new int[0];
    int[] arrayOfInt = new int[1 + (k - j)];
    while (i < arrayOfInt.length)
    {
      arrayOfInt[i] = j;
      j++;
      i++;
    }
    return arrayOfInt;
  }

  public final void onScrollStateChanged(int paramInt)
  {
    super.onScrollStateChanged(paramInt);
    if (paramInt != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.e = bool;
      if (!this.e)
        b();
      return;
    }
  }

  public final void setPromoCardSliderListener(cc.a parama)
  {
    this.f = parama;
  }

  public final void setupCards(List<b> paramList)
  {
    this.d = paramList;
    this.c.a(paramList);
    if (isClickable())
      this.c.a(this.b);
    setCardLayoutManager(this.a);
    swapAdapter(this.c, true);
  }

  private final class a
    implements View.OnClickListener
  {
    private a()
    {
    }

    public final void onClick(View paramView)
    {
      if ((cb.b(cb.this)) || (!cb.this.isClickable()));
      View localView;
      do
      {
        return;
        localView = cb.c(cb.this).findContainingItemView(paramView);
      }
      while ((localView == null) || (cb.d(cb.this) == null) || (cb.e(cb.this) == null));
      cb.d(cb.this).a(localView, cb.c(cb.this).getPosition(localView));
    }
  }

  static final class b extends LinearLayoutManager
  {
    private cw.a a;
    private int b;

    public b(Context paramContext)
    {
      super(0, false);
    }

    public final void a(int paramInt)
    {
      this.b = paramInt;
    }

    public final void a(cw.a parama)
    {
      this.a = parama;
    }

    public final void measureChildWithMargins(View paramView, int paramInt1, int paramInt2)
    {
      RecyclerView.LayoutParams localLayoutParams = (RecyclerView.LayoutParams)paramView.getLayoutParams();
      int i = getWidth();
      if ((getHeight() <= 0) || (i <= 0))
        return;
      if (getItemViewType(paramView) == 1)
        localLayoutParams.rightMargin = this.b;
      while (true)
      {
        super.measureChildWithMargins(paramView, paramInt1, paramInt2);
        return;
        if (getItemViewType(paramView) == 2)
        {
          localLayoutParams.leftMargin = this.b;
        }
        else
        {
          localLayoutParams.leftMargin = this.b;
          localLayoutParams.rightMargin = this.b;
        }
      }
    }

    public final void onLayoutCompleted(RecyclerView.State paramState)
    {
      super.onLayoutCompleted(paramState);
      if (this.a != null)
        this.a.a();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.cb
 * JD-Core Version:    0.6.2
 */