package com.viber.voip.viberout.ui.products.plans;

import android.support.v4.view.ViewCompat;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.viber.svg.jni.SvgImageView;
import com.viber.svg.jni.clock.CyclicClock;
import com.viber.voip.R.id;
import com.viber.voip.R.layout;
import com.viber.voip.viberout.ui.products.model.PlanModel;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class e extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
  private final List<PlanModel> a = new ArrayList();
  private final b.a b;
  private int c = -1;
  private boolean d;
  private LayoutInflater e;
  private com.viber.voip.viberout.ui.products.e f;

  public e(b.a parama, LayoutInflater paramLayoutInflater, com.viber.voip.viberout.ui.products.e parame)
  {
    this.b = parama;
    this.e = paramLayoutInflater;
    this.f = parame;
  }

  public void a(int paramInt)
  {
    this.c = paramInt;
  }

  public void a(Collection<PlanModel> paramCollection)
  {
    this.a.clear();
    this.a.addAll(paramCollection);
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

  public int getItemCount()
  {
    if (a())
      return 3;
    return this.a.size();
  }

  public int getItemViewType(int paramInt)
  {
    if (a())
      return 0;
    return 1;
  }

  public void onBindViewHolder(RecyclerView.ViewHolder paramViewHolder, int paramInt)
  {
    switch (getItemViewType(paramInt))
    {
    default:
      return;
    case 0:
      ((a)paramViewHolder).a();
      return;
    case 1:
    }
    PlanModel localPlanModel = (PlanModel)this.a.get(paramInt);
    ((b)paramViewHolder).a(localPlanModel);
  }

  public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup paramViewGroup, int paramInt)
  {
    switch (paramInt)
    {
    default:
      return null;
    case 0:
      return new a(this.e.inflate(R.layout.vo_plan_empty_item, paramViewGroup, false), this.f);
    case 1:
    }
    return new b(this.e.inflate(R.layout.vo_plan_item, paramViewGroup, false), this.b, this.c, this.f);
  }

  static class a extends RecyclerView.ViewHolder
  {
    private final SvgImageView a;
    private final Button b;
    private com.viber.voip.viberout.ui.products.e c;

    public a(View paramView, com.viber.voip.viberout.ui.products.e parame)
    {
      super();
      this.c = parame;
      this.a = ((SvgImageView)paramView.findViewById(R.id.progress));
      this.b = ((Button)paramView.findViewById(R.id.buy_button));
    }

    public void a()
    {
      this.a.loadFromAsset(this.itemView.getContext(), "svg/vo_loading_plan.svg", "", 0);
      this.a.setClock(new CyclicClock(4.0D));
      this.a.setSvgEnabled(true);
      if (this.c.b() != null)
        ViewCompat.setBackgroundTintList(this.b, this.c.b());
    }
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.e
 * JD-Core Version:    0.6.2
 */