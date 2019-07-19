package com.viber.voip.viberout.ui.products.plans;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.util.dj;
import com.viber.voip.viberout.ui.products.account.b;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class g extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private b.a a;
  private b b;
  private final List<List<PlanModel>> c;
  private boolean d;
  private boolean e = false;
  private boolean f = false;
  private LayoutInflater g;
  private com.viber.voip.viberout.ui.products.e h;

  public g(LayoutInflater paramLayoutInflater, com.viber.voip.viberout.ui.products.e parame)
  {
    this.g = paramLayoutInflater;
    this.c = new ArrayList();
    this.h = parame;
  }

  void a(b paramb)
  {
    this.b = paramb;
  }

  public void a(b.a parama)
  {
    this.a = parama;
  }

  public void a(Collection<List<PlanModel>> paramCollection)
  {
    this.c.clear();
    this.c.addAll(paramCollection);
    notifyDataSetChanged();
  }

  public void a(boolean paramBoolean)
  {
    this.d = paramBoolean;
    notifyDataSetChanged();
  }

  public boolean a()
  {
    return this.d;
  }

  void b()
  {
    this.e = true;
  }

  void b(boolean paramBoolean)
  {
    this.f = paramBoolean;
  }

  public int getItemCount()
  {
    if (a());
    for (int i = 2; ; i = this.c.size())
    {
      if (!this.e)
        i++;
      return i;
    }
  }

  public int getItemViewType(int paramInt)
  {
    if (a())
      return 0;
    if ((!this.e) && (paramInt == this.c.size()))
      return 2;
    return 1;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default:
      return;
    case 1:
      b localb = (b)paramViewHolder;
      localb.a((List)this.c.get(paramInt), paramInt);
      localb.a(this.d);
      return;
    case 0:
      ((b)paramViewHolder).a(this.d);
      return;
    case 2:
    }
    ((a)paramViewHolder).a(this.f);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
    case 1:
      return new b(this.g.inflate(R.layout.vo_country_plans_item, paramViewGroup, false), this.a, this.g, this.h);
    case 2:
    }
    return new a(this.g.inflate(R.layout.vo_my_account_with_divider, paramViewGroup, false), this.b);
  }

  static class a extends RecyclerView.ViewHolder
  {
    private final View a;

    a(View paramView, b paramb)
    {
      super();
      this.a = paramView.findViewById(R.id.divider);
      paramView.setOnClickListener(new h(paramb));
    }

    void a(boolean paramBoolean)
    {
      dj.b(this.a, paramBoolean);
    }
  }

  static class b extends RecyclerView.ViewHolder
  {
    e a;

    b(View paramView, b.a parama, LayoutInflater paramLayoutInflater, com.viber.voip.viberout.ui.products.e parame)
    {
      super();
      this.a = new e(parama, paramLayoutInflater, parame);
      RecyclerView localRecyclerView = (RecyclerView)paramView.findViewById(R.id.list_view);
      localRecyclerView.setAdapter(this.a);
      TextView localTextView = (TextView)LayoutInflater.from(paramView.getContext()).inflate(R.layout.view_ribbon, localRecyclerView, false);
      Resources localResources = paramView.getContext().getResources();
      localRecyclerView.addItemDecoration(new f(localResources));
      localRecyclerView.addItemDecoration(new d(localTextView, localResources, true));
    }

    void a(List<PlanModel> paramList, int paramInt)
    {
      this.a.a(paramList);
      this.a.a(paramInt);
    }

    void a(boolean paramBoolean)
    {
      this.a.a(paramBoolean);
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.g
 * JD-Core Version:    0.6.2
 */