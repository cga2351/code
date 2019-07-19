package com.viber.voip.viberout.ui.products.countryplans;

import android.content.res.Resources;
import android.support.constraint.ConstraintLayout;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import com.viber.voip.R.color;
import com.viber.voip.R.dimen;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.viberout.ui.products.d;
import com.viber.voip.viberout.ui.products.model.CreditModel;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import com.viber.voip.viberout.ui.products.model.RateModel;
import com.viber.voip.viberout.ui.products.plans.b;
import com.viber.voip.viberout.ui.products.plans.b.a;
import java.util.ArrayList;
import java.util.List;

class e extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final List<PlanModel> a = new ArrayList();
  private final List<CreditModel> b = new ArrayList();
  private RateModel c;
  private int d;
  private CreditModel e;
  private int f;
  private int g;
  private int h;
  private a i;
  private LayoutInflater j;
  private com.viber.voip.viberout.ui.products.e k;

  public e(LayoutInflater paramLayoutInflater, com.viber.voip.viberout.ui.products.e parame)
  {
    this.j = paramLayoutInflater;
    this.k = parame;
  }

  public void a(a parama)
  {
    this.i = parama;
  }

  public void a(List<PlanModel> paramList)
  {
    this.a.clear();
    this.a.addAll(paramList);
    notifyDataSetChanged();
  }

  public void a(List<CreditModel> paramList, int paramInt, CreditModel paramCreditModel, RateModel paramRateModel)
  {
    this.b.clear();
    this.b.addAll(paramList);
    this.c = paramRateModel;
    this.e = paramCreditModel;
    this.d = paramInt;
    notifyItemChanged(0);
  }

  public int getItemCount()
  {
    if (!this.b.isEmpty());
    int n;
    for (int m = 1; ; m = 0)
    {
      n = this.a.size();
      if (n > 0)
        n++;
      if (m == 0)
        break;
      int i1 = n + 1;
      if (i1 > 1)
        i1++;
      return i1;
    }
    return n;
  }

  public int getItemViewType(int paramInt)
  {
    int m;
    int n;
    if (!this.b.isEmpty())
    {
      m = 1;
      if (this.a.isEmpty())
        break label43;
      n = 1;
    }
    while (true)
      if (m != 0)
      {
        if (paramInt == 0)
        {
          return 0;
          m = 0;
          break;
          label43: n = 0;
          continue;
        }
        if (n == 0)
          break label72;
        if (paramInt == 1)
          return 1;
        if (paramInt != 2)
          break label72;
        return 2;
      }
    if (paramInt == 0)
      return 2;
    label72: return 3;
  }

  public void onAttachedToRecyclerView(RecyclerView paramRecyclerView)
  {
    super.onAttachedToRecyclerView(paramRecyclerView);
    this.f = paramRecyclerView.getResources().getDimensionPixelOffset(R.dimen.country_plans_padding);
    this.g = paramRecyclerView.getResources().getDimensionPixelOffset(R.dimen.vo_plan_item_height);
    this.h = paramRecyclerView.getResources().getDimensionPixelOffset(R.dimen.vo_plan_item_padding);
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    int m = 1;
    switch (getItemViewType(paramInt))
    {
    case 1:
    case 2:
    default:
      return;
    case 0:
      ((b)paramViewHolder).a(this.b, this.d, this.e, this.c, this.k);
      return;
    case 3:
    }
    if (!this.b.isEmpty());
    for (int n = m; ; n = 0)
    {
      b localb = (b)paramViewHolder;
      List localList = this.a;
      if (n != 0)
        m = 3;
      localb.a((PlanModel)localList.get(paramInt - m));
      return;
    }
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      a locala = new a(paramViewGroup.getContext());
      locala.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
      return new b(locala, this.i, this.j);
    case 1:
      int m = paramViewGroup.getResources().getDimensionPixelSize(R.dimen.empty_credit_offer_margin);
      View localView = new View(paramViewGroup.getContext());
      localView.setLayoutParams(new ViewGroup.LayoutParams(-1, m));
      localView.setBackgroundColor(ContextCompat.getColor(paramViewGroup.getContext(), R.color.sections_divider));
      return new c(localView);
    case 2:
      return new c(this.j.inflate(R.layout.vo_plan_header, paramViewGroup, false));
    case 3:
    }
    ConstraintLayout localConstraintLayout = (ConstraintLayout)this.j.inflate(R.layout.vo_plan_item, paramViewGroup, false);
    localConstraintLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    ViewGroup.LayoutParams localLayoutParams = localConstraintLayout.findViewById(R.id.card).getLayoutParams();
    localLayoutParams.width = -1;
    localLayoutParams.height = this.g;
    localConstraintLayout.setPadding(this.f, localConstraintLayout.getPaddingTop(), this.f, this.h);
    return new b(localConstraintLayout, this.i, -1, this.k);
  }

  public static abstract interface a extends b.a
  {
    public abstract void a(int paramInt);

    public abstract void a(CreditModel paramCreditModel);
  }

  static class b extends RecyclerView.ViewHolder
    implements a.a
  {
    private final e.a a;

    b(a parama, e.a parama1, LayoutInflater paramLayoutInflater)
    {
      super();
      parama.setCountryCreditViewListener(this);
      parama.setUiHelper(new d(paramLayoutInflater));
      this.a = parama1;
    }

    public void a(int paramInt)
    {
      if (this.a != null)
        this.a.a(paramInt);
    }

    public void a(CreditModel paramCreditModel)
    {
      if (this.a != null)
        this.a.a(paramCreditModel);
    }

    void a(List<CreditModel> paramList, int paramInt, CreditModel paramCreditModel, RateModel paramRateModel, com.viber.voip.viberout.ui.products.e parame)
    {
      a locala = (a)this.itemView;
      locala.a(paramList, paramInt, paramCreditModel);
      locala.setRate(paramRateModel);
      locala.a(parame);
    }
  }

  static class c extends RecyclerView.ViewHolder
  {
    c(View paramView)
    {
      super();
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.countryplans.e
 * JD-Core Version:    0.6.2
 */