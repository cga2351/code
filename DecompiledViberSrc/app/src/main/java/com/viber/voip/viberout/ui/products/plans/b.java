package com.viber.voip.viberout.ui.products.plans;

import android.content.res.Resources;
import android.support.constraint.ConstraintLayout.a;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import com.viber.voip.R.dimen;
import com.viber.voip.R.drawable;
import com.viber.voip.R.id;
import com.viber.voip.R.plurals;
import com.viber.voip.util.dj;
import com.viber.voip.util.e.f;
import com.viber.voip.util.e.f.b;
import com.viber.voip.viberout.ui.products.model.PlanModel;

public class b extends RecyclerView.ViewHolder
  implements View.OnClickListener, c
{
  private final a a;
  private final int b;
  private final AppCompatButton c;
  private final ImageView d;
  private final TextView e;
  private final TextView f;
  private final TextView g;
  private final TextView h;
  private final TextView i;
  private final TextView j;
  private PlanModel k;
  private com.viber.voip.viberout.ui.products.e l;

  public b(View paramView, a parama, int paramInt, com.viber.voip.viberout.ui.products.e parame)
  {
    super(paramView);
    this.a = parama;
    this.b = paramInt;
    this.l = parame;
    paramView.findViewById(R.id.card).setOnClickListener(this);
    this.d = ((ImageView)paramView.findViewById(R.id.country_icon));
    this.e = ((TextView)paramView.findViewById(R.id.country_name));
    this.f = ((TextView)paramView.findViewById(R.id.discount));
    this.g = ((TextView)paramView.findViewById(R.id.offer));
    this.h = ((TextView)paramView.findViewById(R.id.destinations));
    this.c = ((AppCompatButton)paramView.findViewById(R.id.buy_button));
    this.c.setOnClickListener(this);
    this.i = ((TextView)paramView.findViewById(R.id.description));
    this.j = ((TextView)paramView.findViewById(R.id.destination_countries_count));
  }

  public void a(PlanModel paramPlanModel)
  {
    this.k = paramPlanModel;
    Resources localResources = this.itemView.getResources();
    this.e.setText(this.l.a(paramPlanModel.getCountry()));
    com.viber.voip.util.e.e.a(this.itemView.getContext()).a(paramPlanModel.getCountryIcon(), this.d, f.a(R.drawable.ic_vo_default_country, f.b.a));
    if ((paramPlanModel.getDiscountValue() > 0) && (!a()) && (!paramPlanModel.isMultipleDestinations()))
    {
      dj.b(this.f, true);
      this.f.setText(paramPlanModel.getDiscount());
    }
    while (true)
    {
      if (a())
        ((ConstraintLayout.a)this.d.getLayoutParams()).topMargin = ((int)localResources.getDimension(R.dimen.vo_country_icon_top_margin));
      this.g.setText(paramPlanModel.getOffer());
      this.h.setText(paramPlanModel.getDestinations());
      this.c.setText(paramPlanModel.getBuyButtonText());
      if (this.l.b() != null)
        ViewCompat.setBackgroundTintList(this.c, this.l.b());
      this.i.setText(paramPlanModel.getDescription());
      boolean bool = paramPlanModel.isMultipleDestinations();
      dj.b(this.j, bool);
      if (bool)
      {
        int m = paramPlanModel.getDestinationCountriesCount();
        TextView localTextView = this.j;
        int n = R.plurals.vo_countries_count_in_plan;
        Object[] arrayOfObject = new Object[1];
        arrayOfObject[0] = Integer.valueOf(m);
        localTextView.setText(localResources.getQuantityString(n, m, arrayOfObject));
      }
      return;
      dj.b(this.f, false);
    }
  }

  public boolean a()
  {
    return this.k.hasIntroductory();
  }

  public void onClick(View paramView)
  {
    int m = paramView.getId();
    if (m == R.id.card)
      if (this.a != null)
        this.a.c(this.k);
    while ((m != R.id.buy_button) || (this.a == null))
      return;
    this.a.a(this.k, getAdapterPosition(), this.b);
  }

  public static abstract interface a
  {
    public abstract void a(PlanModel paramPlanModel, int paramInt1, int paramInt2);

    public abstract void c(PlanModel paramPlanModel);
  }
}

/* Location:           E:\Study\Tools\apktool2_2\dex2jar-0.0.9.15\classes_viber_4_dex2jar.jar
 * Qualified Name:     com.viber.voip.viberout.ui.products.plans.b
 * JD-Core Version:    0.6.2
 */