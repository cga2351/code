package com.viber.voip.ui.a;

import android.content.Context;
import android.support.v4.util.Pair;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.AdapterDataObserver;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.viber.voip.R.id;
import com.viber.voip.ads.b.c.a.i;
import com.viber.voip.util.dj;

public class b extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  protected final RecyclerView.Adapter<RecyclerView.ViewHolder> a;
  private final LayoutInflater b;
  private final i c;
  private final com.viber.voip.ads.b.b.b.c d;
  private final com.viber.voip.ads.b.c.a.b e;
  private final int f;
  private final int g;
  private final int h;
  private final RecyclerView.AdapterDataObserver i;
  private com.viber.voip.ads.b.c.c.c j;
  private boolean k;

  public b(Context paramContext, RecyclerView.Adapter<RecyclerView.ViewHolder> paramAdapter, final i parami, com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.c.a.b paramb, int paramInt1, int paramInt2, int paramInt3)
  {
    this.a = paramAdapter;
    this.b = LayoutInflater.from(paramContext);
    this.d = paramc;
    this.e = paramb;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramInt3;
    this.c = new i()
    {
      public void a(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
      {
        parami.a(paramAnonymousa, paramAnonymousView);
      }

      public void a(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView, String paramAnonymousString)
      {
        parami.a(paramAnonymousa, paramAnonymousView, paramAnonymousString);
      }

      public void b(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
      {
        parami.b(paramAnonymousa, paramAnonymousView);
        b.a(b.this);
      }

      public void c(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
      {
        parami.c(paramAnonymousa, paramAnonymousView);
        b.b(b.this);
      }

      public void d(com.viber.voip.ads.b.b.b.a paramAnonymousa, View paramAnonymousView)
      {
        parami.d(paramAnonymousa, paramAnonymousView);
      }
    };
    this.i = new b(null);
    paramAdapter.registerAdapterDataObserver(this.i);
  }

  private boolean a()
  {
    return (!this.k) && (this.a.getItemCount() >= this.h);
  }

  private boolean a(int paramInt)
  {
    return (a()) && (paramInt == this.h);
  }

  private int b(int paramInt)
  {
    if ((a()) && (this.h < paramInt))
      paramInt--;
    return paramInt;
  }

  private void b()
  {
    this.k = true;
    a(null);
  }

  private void c()
  {
    this.k = true;
    a(null);
  }

  public void a(com.viber.voip.ads.b.c.c.c paramc)
  {
    if ((this.j != null) && (this.j.equals(paramc)));
    while ((this.j == null) && (paramc == null))
      return;
    this.j = paramc;
    notifyDataSetChanged();
  }

  public void a(boolean paramBoolean)
  {
    this.k = paramBoolean;
  }

  public int getItemCount()
  {
    int m = this.a.getItemCount();
    if (a())
      m++;
    return m;
  }

  public long getItemId(int paramInt)
  {
    if (a(paramInt))
      return -10L;
    return this.a.getItemId(b(paramInt));
  }

  public int getItemViewType(int paramInt)
  {
    if (a(paramInt))
      return -1;
    return this.a.getItemViewType(b(paramInt));
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    if (paramViewHolder.getItemViewType() == -1)
    {
      ((a)paramViewHolder).a(this.j);
      return;
    }
    this.a.onBindViewHolder(paramViewHolder, b(paramInt));
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    if (paramInt == -1)
      return new a(this.b.inflate(this.f, paramViewGroup, false), this.c, this.d, this.e, this.g, null);
    return this.a.onCreateViewHolder(paramViewGroup, paramInt);
  }

  private static class a extends RecyclerView.ViewHolder
  {
    private final com.viber.voip.ads.b.c.a.a<com.viber.voip.ads.b.c.c.c> a;
    private final View b;
    private final View c;
    private final View d;
    private final int e;

    private a(View paramView, i parami, com.viber.voip.ads.b.b.b.c paramc, com.viber.voip.ads.b.c.a.b paramb, int paramInt)
    {
      super();
      this.a = paramb.a(paramc, (ViewGroup)paramView, parami);
      this.b = paramView.findViewById(R.id.adViewPlaceholder);
      this.c = paramView.findViewById(R.id.overflowButton);
      this.d = paramView.findViewById(R.id.adProviderView);
      this.e = paramInt;
    }

    void a(com.viber.voip.ads.b.c.c.c paramc)
    {
      this.itemView.setTag(this.e, paramc);
      if (paramc != null)
      {
        if ((this.b != null) && (this.b.getVisibility() == 0))
          com.viber.voip.ui.b.a.b(this.b, 100L, com.viber.voip.ui.b.c.a);
        this.a.a(paramc);
      }
      while (this.b == null)
        return;
      View localView1 = this.itemView.findViewById(R.id.googleAdView);
      if (localView1 == null);
      for (View localView2 = this.itemView.findViewById(R.id.adViewContainer); ; localView2 = localView1)
      {
        if (localView2 != null)
          ((ViewGroup)this.itemView).removeView(localView2);
        dj.b(this.c, false);
        dj.b(this.d, false);
        dj.b(this.b, true);
        return;
      }
    }
  }

  private class b extends RecyclerView.AdapterDataObserver
  {
    private b()
    {
    }

    private Pair<Integer, Integer> a(int paramInt1, int paramInt2)
    {
      if (b.c(b.this))
      {
        if (paramInt1 < b.d(b.this))
          break label36;
        paramInt1++;
      }
      while (true)
      {
        return Pair.create(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
        label36: if (paramInt1 + paramInt2 > b.d(b.this))
          paramInt2++;
      }
    }

    public void onChanged()
    {
      b.this.notifyDataSetChanged();
    }

    public void onItemRangeChanged(int paramInt1, int paramInt2)
    {
      Pair localPair = a(paramInt1, paramInt2);
      if (localPair.first != null)
        paramInt1 = ((Integer)localPair.first).intValue();
      if (localPair.second != null)
        paramInt2 = ((Integer)localPair.second).intValue();
      b.this.notifyItemRangeChanged(paramInt1, paramInt2);
    }

    public void onItemRangeChanged(int paramInt1, int paramInt2, Object paramObject)
    {
      Pair localPair = a(paramInt1, paramInt2);
      if (localPair.first != null)
        paramInt1 = ((Integer)localPair.first).intValue();
      if (localPair.second != null)
        paramInt2 = ((Integer)localPair.second).intValue();
      b.this.notifyItemRangeChanged(paramInt1, paramInt2, paramObject);
    }

    public void onItemRangeInserted(int paramInt1, int paramInt2)
    {
      Pair localPair = a(paramInt1, paramInt2);
      if (localPair.first != null)
        paramInt1 = ((Integer)localPair.first).intValue();
      if (localPair.second != null)
        paramInt2 = ((Integer)localPair.second).intValue();
      b.this.notifyItemRangeInserted(paramInt1, paramInt2);
    }

    public void onItemRangeMoved(int paramInt1, int paramInt2, int paramInt3)
    {
      b.this.notifyDataSetChanged();
    }

    public void onItemRangeRemoved(int paramInt1, int paramInt2)
    {
      Pair localPair = a(paramInt1, paramInt2);
      if (localPair.first != null)
        paramInt1 = ((Integer)localPair.first).intValue();
      if (localPair.second != null)
        paramInt2 = ((Integer)localPair.second).intValue();
      b.this.notifyItemRangeRemoved(paramInt1, paramInt2);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.ui.a.b
 * JD-Core Version:    0.6.2
 */