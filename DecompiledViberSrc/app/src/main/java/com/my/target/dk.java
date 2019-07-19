package com.my.target;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.support.v7.widget.LinearSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewParent;
import com.my.target.b.c.a.f;
import java.util.ArrayList;
import java.util.List;

public final class dk extends RecyclerView
{
  private final View.OnClickListener a = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      if (dk.a(dk.this));
      View localView;
      do
      {
        return;
        localView = dk.this.getCardLayoutManager().findContainingItemView(paramAnonymousView);
      }
      while (localView == null);
      dj localdj = dk.this.getCardLayoutManager();
      int i = localdj.findFirstCompletelyVisibleItemPosition();
      int j = localdj.getPosition(localView);
      int k = localdj.findLastCompletelyVisibleItemPosition();
      if ((i <= j) && (j <= k));
      for (int m = 1; ; m = 0)
      {
        if ((m == 0) && (!dk.b(dk.this)))
          break label158;
        if ((!paramAnonymousView.isClickable()) || (dk.c(dk.this) == null) || (dk.d(dk.this) == null))
          break;
        dk.c(dk.this).a((f)dk.d(dk.this).get(dk.this.getCardLayoutManager().getPosition(localView)));
        return;
      }
      label158: dk.this.a(localView);
    }
  };
  private final dj b;
  private final View.OnClickListener c = new View.OnClickListener()
  {
    public final void onClick(View paramAnonymousView)
    {
      for (ViewParent localViewParent = paramAnonymousView.getParent(); (localViewParent != null) && (!(localViewParent instanceof di)); localViewParent = localViewParent.getParent());
      if ((dk.c(dk.this) != null) && (dk.d(dk.this) != null) && (localViewParent != null))
        dk.c(dk.this).a((f)dk.d(dk.this).get(dk.this.getCardLayoutManager().getPosition((View)localViewParent)));
    }
  };
  private final LinearSnapHelper d;
  private List<f> e;
  private dl.a f;
  private boolean g;
  private boolean h;

  public dk(Context paramContext)
  {
    this(paramContext, (byte)0);
  }

  private dk(Context paramContext, byte paramByte)
  {
    this(paramContext, '\000');
  }

  private dk(Context paramContext, char paramChar)
  {
    super(paramContext, null, 0);
    setOverScrollMode(2);
    this.b = new dj(paramContext);
    this.d = new LinearSnapHelper();
    this.d.attachToRecyclerView(this);
  }

  private void a()
  {
    if (this.f != null)
      this.f.a(getVisibleCards());
  }

  private List<f> getVisibleCards()
  {
    ArrayList localArrayList = new ArrayList();
    if (this.e == null);
    while (true)
    {
      return localArrayList;
      int i = getCardLayoutManager().findFirstCompletelyVisibleItemPosition();
      int j = getCardLayoutManager().findLastCompletelyVisibleItemPosition();
      if ((i <= j) && (i >= 0) && (j < this.e.size()))
        while (i <= j)
        {
          localArrayList.add(this.e.get(i));
          i++;
        }
    }
  }

  private void setCardLayoutManager(dj paramdj)
  {
    paramdj.a(new dj.a()
    {
      public final void a()
      {
        dk.e(dk.this);
      }
    });
    super.setLayoutManager(paramdj);
  }

  protected final void a(View paramView)
  {
    int[] arrayOfInt = this.d.calculateDistanceToFinalSnap(getCardLayoutManager(), paramView);
    if (arrayOfInt != null)
      smoothScrollBy(arrayOfInt[0], 0);
  }

  public final void a(List<f> paramList)
  {
    a locala = new a(paramList, getContext());
    this.e = paramList;
    locala.c = this.a;
    locala.d = this.c;
    setCardLayoutManager(this.b);
    setAdapter(locala);
  }

  public final void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.d.attachToRecyclerView(this);
      return;
    }
    this.d.attachToRecyclerView(null);
  }

  public final dj getCardLayoutManager()
  {
    return this.b;
  }

  public final LinearSnapHelper getSnapHelper()
  {
    return this.d;
  }

  protected final void onLayout(boolean paramBoolean, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt3 > paramInt4)
      this.h = true;
    super.onLayout(paramBoolean, paramInt1, paramInt2, paramInt3, paramInt4);
  }

  public final void onScrollStateChanged(int paramInt)
  {
    super.onScrollStateChanged(paramInt);
    if (paramInt != 0);
    for (boolean bool = true; ; bool = false)
    {
      this.g = bool;
      if (!this.g)
        a();
      return;
    }
  }

  public final void setCarouselListener(dl.a parama)
  {
    this.f = parama;
  }

  public final void setSideSlidesMargins(int paramInt)
  {
    getCardLayoutManager().a(paramInt);
  }

  private static final class a extends RecyclerView.Adapter<dk.b>
  {
    final Context a;
    final List<f> b;
    View.OnClickListener c;
    View.OnClickListener d;
    private final boolean e;

    a(List<f> paramList, Context paramContext)
    {
      this.b = paramList;
      this.a = paramContext;
      if ((0xF & paramContext.getResources().getConfiguration().screenLayout) >= 3);
      for (boolean bool = true; ; bool = false)
      {
        this.e = bool;
        return;
      }
    }

    public final int getItemCount()
    {
      return this.b.size();
    }

    public final int getItemViewType(int paramInt)
    {
      if (paramInt == 0)
        return 1;
      if (paramInt == -1 + getItemCount())
        return 2;
      return 0;
    }
  }

  static final class b extends RecyclerView.ViewHolder
  {
    private final di a;

    b(di paramdi)
    {
      super();
      this.a = paramdi;
    }

    final di a()
    {
      return this.a;
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_2_dex2jar.jar
 * Qualified Name:     com.my.target.dk
 * JD-Core Version:    0.6.2
 */